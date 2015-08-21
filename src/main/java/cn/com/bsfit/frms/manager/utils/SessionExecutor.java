package cn.com.bsfit.frms.manager.utils;

import org.apache.ibatis.session.SqlSession;

/**
 * A task that returns a result and may throw an exception. Implementors define
 * a single method with no arguments called <tt>execute</tt>.
 * 
 * @author Xingen Wang
 * @since 1.0.0
 * @param <V>
 *            the result type of method <tt>execute</tt>
 */
public abstract class SessionExecutor<V> {

    /**
     * Do actual data action. This method will be overwritten in service
     * implement.<br>
     * <br>
     * A simple example is shown below(ObjectMapper is a mybatis mapper
     * interface):
     * 
     * <pre>
     * ObjectMapper mapper = session.getMapper(ObjectMapper.class);
     * Object o = mapper.selectByPrimaryKey(key);
     * return o;
     * </pre>
     * 
     * @param session
     * @param qrySession
     * @return V type object
     */
    public abstract V execute(final SqlSession session) throws Exception;

}
