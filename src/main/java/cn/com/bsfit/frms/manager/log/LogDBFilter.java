package cn.com.bsfit.frms.manager.log;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;

/**
 * 日志拦截器
 * 
 * @author yzq
 * 
 * @since 1.0.0
 *
 */
public class LogDBFilter extends Filter<ILoggingEvent> {
	
	@Override
	public FilterReply decide(ILoggingEvent event) {
		if (event.getMessage() != null && event.getMessage().startsWith(LogDBUtil.PREFIX)) {
			return FilterReply.ACCEPT;
		} else {
			return FilterReply.DENY;
		}
	}
}