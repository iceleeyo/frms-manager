package cn.com.bsfit.frms.manager.utils;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.security.auth.login.FailedLoginException;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import cn.com.bsfit.frms.manager.mapper.UsersMapper;
import cn.com.bsfit.frms.manager.pojo.Users;
import cn.com.bsfit.frms.manager.pojo.UsersExample;

/**
 * Base class for server-side service which provides the ability to communicate
 * with the database.<br>
 * <br>
 * The <tt>safeExecute</tt> provides a connection-safe wrapped method to
 * customize some database operations.
 * 
 * @author hjp
 * 
 * @since 1.0.0
 */
public abstract class BaseServerResource {

	@Autowired
	@Qualifier("managerSqlSessionFactory")
	private SqlSessionFactory sqlSessionFactoryManager;

	public static List<String> ignoreStatusList;

	static {
		ignoreStatusList = new ArrayList<String>();
		ignoreStatusList.add("RECL");
		ignoreStatusList.add("HIDDEN");
	}

	@Autowired
	protected HttpServletRequest request;

	private int sessionCacheTimeout = 60 * 60 * 1000;

	public void setSessionCacheTimeout(int sessionCacheTimeout) {
		this.sessionCacheTimeout = sessionCacheTimeout;
	}

	public int getSessionCacheTimeout() {
		return sessionCacheTimeout;
	}

	/**
	 * put attribute into request session.
	 * 
	 * @param key
	 * @param item
	 */
	public void setSessionItem(String key, Object item) {
		request.getSession().setAttribute(key, item);
	}

	/**
	 * get stored Object from session with key.<br>
	 * if these objects were store by {@link SessionCachedItem}, timeout will be
	 * judged.
	 * 
	 * @param key
	 *            name of the attribute to get.
	 * @return Object stored in request session.
	 */
	public Object getSessionItem(String key) {
		Object obj = request.getSession().getAttribute(key);
		if (obj != null && obj instanceof SessionCachedItem) {
			SessionCachedItem item = (SessionCachedItem) obj;
			obj = new Date().getTime() - item.getCacheTime().getTime() >= sessionCacheTimeout ? null : item.getObject();
		}
		return obj;
	}

	/**
	 * Get the {@link SqlSession}.
	 * 
	 * @param autoCommit
	 *            the auto commit value of {@link Connection}.
	 * @return {@link SqlSession}.
	 */
	public SqlSession openSession(boolean autoCommit) {
		if (getSqlSessionFactoryManager() == null) {
			return null;
		}
		return getSqlSessionFactoryManager().openSession(autoCommit);
	}

	/**
	 * Execute the {@link SessionExecutor} within the auto-commit disabled
	 * connection-safe session.<br>
	 * 
	 * @param executor
	 *            The {@link SessionExecutor}.
	 * @return the results of the SQL operations.
	 * @throws Exception
	 *             Some {@link PersistenceException} occurs.
	 */
	public <V> V safeExecute(final SessionExecutor<V> executor) throws Exception {
		return safeExecute(executor, false);
	}

	/**
	 * Execute the {@link SessionExecutor} within the connection-safe session.
	 * <br>
	 * <br>
	 * The {@link SessionExecutor} defines the detail SQL operations.
	 * 
	 * @param executor
	 *            the {@link SessionExecutor} defined the detail sql operations.
	 * @param autoCommit
	 *            The auto commit value of {@link SqlSession}.
	 * @return The results of the SQL operations.
	 * @throws Exception
	 *             Occurs if some {@link PersistenceException} occurs.
	 */
	public <V> V safeExecute(final SessionExecutor<V> executor, final boolean autoCommit) throws Exception {
		SqlSession sqlSessionRams = null;
		try {
			sqlSessionRams = openSession(autoCommit);
			V returnObject = executor.execute(sqlSessionRams);
			if (autoCommit == false) {
				sqlSessionRams.commit();
			}
			return returnObject;
		} catch (PersistenceException e) {
			if (autoCommit == false && sqlSessionRams != null) {
				sqlSessionRams.rollback();
			}
			throw new Exception(e.getMessage(), e);
		} catch (NullPointerException e) {
			throw new Exception("提交的请求无效，某必须项为空", e);
		} finally {
			if (sqlSessionRams != null) {
				sqlSessionRams.close();
			}
		}
	}

	/**
	 * convert params to list of Attribute.
	 * 
	 * @param params
	 *            params from extjs client
	 * @return {@link List} of converted keys and values.
	 */
	@SuppressWarnings("unchecked")
	protected List<Map<String, Object>> params2Attributes(Object params) {
		if (params == null)
			return null;
		Map<String, Object> map = null;
		if (params instanceof Map) {
			map = (Map<String, Object>) params;
		}
		List<Map<String, Object>> objs = new ArrayList<Map<String, Object>>(1);
		if (params instanceof List) {
			objs = (List<Map<String, Object>>) params;
		}
		if (map != null)
			objs.add(map);
		return objs;
	}

	public SqlSessionFactory getSqlSessionFactoryManager() {
		return sqlSessionFactoryManager;
	}

	public void setSqlSessionFactoryManager(SqlSessionFactory sqlSessionFactoryManager) {
		this.sqlSessionFactoryManager = sqlSessionFactoryManager;
	}

	protected Object getCurrentUserDetails() {
		return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}

	protected Collection<? extends GrantedAuthority> getAuthorities() {
		return SecurityContextHolder.getContext().getAuthentication().getAuthorities();
	}
	
	protected Users getCurrentUser() throws Exception {
		if (request.getSession().getAttribute("myself") != null) {
			return (Users) request.getSession().getAttribute("myself");
		} else {
			final Object userDetails = getCurrentUserDetails();
			if (userDetails == null) {
				throw new FailedLoginException();
			}
			Users users = safeExecute(new SessionExecutor<Users>(){
				@Override
				public Users execute(SqlSession session) throws Exception {
					UsersMapper mapper = session.getMapper(UsersMapper.class);
					UsersExample example = new UsersExample();
					if (userDetails instanceof UserDetails) {
						example.createCriteria().andUserNameEqualTo(((UserDetails) userDetails).getUsername());
					} else {
						example.createCriteria().andUserNameEqualTo(userDetails.toString());
					}
					List<Users> usersList = mapper.selectByExample(example);
					return usersList != null && usersList.size() > 0 ? usersList.get(0) : null;
				}
			});
			request.getSession().setAttribute("myself", users);
			return users;
		}
	}
}
