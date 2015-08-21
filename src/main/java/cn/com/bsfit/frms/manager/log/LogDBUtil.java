package cn.com.bsfit.frms.manager.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 需要把日志保存到数据库的工具类
 * 
 * @author yzq
 * 
 * @since 1.0.0
 *
 */
public class LogDBUtil {

	public static String PREFIX = "toDB-";

	private static Logger logger(Class<?> clazz) {
		return LoggerFactory.getLogger(clazz);
	}

	private static String append(String msg) {
		return PREFIX + msg;
	}

	private static void checkUserName(String username) {
		if(username == null || "".equals(username)) {
			throw new RuntimeException("当前操作用户名不能为空");
		}
	}

	public static void info(Class<?> clazz, String msg) {
		logger(clazz).info(append(msg));
	}

	public static void info(Class<?> clazz, String msg, String username) {
		checkUserName(username);
		logger(clazz).info(append(msg), username);
	}

	public static void info(Class<?> clazz, String msg, Object arg) {
		logger(clazz).info(append(msg), arg);
	}

	public static void info(Class<?> clazz, String msg, String username, Object arg) {
		checkUserName(username);
		logger(clazz).info(append(msg), username, arg);
	}

	public static void info(Class<?> clazz, String msg, Throwable t) {
		logger(clazz).info(append(msg), t);
	}

	public static void info(Class<?> clazz, String msg, String username, Throwable t) {
		checkUserName(username);
		logger(clazz).info(append(msg), username, t);
	}

	public static void warn(Class<?> clazz, String msg) {
		logger(clazz).warn(append(msg));
	}

	public static void warn(Class<?> clazz, String msg, String username) {
		checkUserName(username);
		logger(clazz).warn(append(msg), username);
	}

	public static void warn(Class<?> clazz, String msg, Object arg) {
		logger(clazz).warn(append(msg), arg);
	}

	public static void warn(Class<?> clazz, String msg, String username, Object arg) {
		checkUserName(username);
		logger(clazz).warn(append(msg), username, arg);
	}

	public static void warn(Class<?> clazz, String msg, Throwable t) {
		logger(clazz).warn(append(msg), t);
	}

	public static void warn(Class<?> clazz, String msg, String username, Throwable t) {
		checkUserName(username);
		logger(clazz).warn(append(msg), username, t);
	}

	public static void error(Class<?> clazz, String msg) {
		logger(clazz).error(append(msg));
	}

	public static void error(Class<?> clazz, String msg, String username) {
		checkUserName(username);
		logger(clazz).error(append(msg), username);
	}

	public static void error(Class<?> clazz, String msg, Object arg) {
		logger(clazz).error(append(msg), arg);
	}

	public static void error(Class<?> clazz, String msg, String username, Object arg) {
		checkUserName(username);
		logger(clazz).error(append(msg), username, arg);
	}

	public static void error(Class<?> clazz, String msg, Throwable t) {
		logger(clazz).error(append(msg), t);
	}

	public static void error(Class<?> clazz, String msg, String username, Throwable t) {
		checkUserName(username);
		logger(clazz).error(append(msg), username, t);
	}
}