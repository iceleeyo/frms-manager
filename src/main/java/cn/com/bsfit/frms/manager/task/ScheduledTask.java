package cn.com.bsfit.frms.manager.task;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时任务类
 * 
 * @author hjp
 * 
 * @since 1.0.0
 *
 */
@Component
@EnableScheduling
public class ScheduledTask {
	
	/**
	 * 心跳更新。启动时执行一次，之后每隔60秒执行一次
	 */
	@Scheduled(fixedRate = 1000 * 60)
	public void reportCurrentTime() {
		
	}

	@Scheduled(fixedDelay = 1000 * 60)
	public void reportCurrentDelay() {
		
	}
	
	/**
	 * cron表达式: * * * * * *（共6位，使用空格隔开，具体如下）
	 * cron表达式: *(秒0-59) * (分钟0-59) * (小时0-23) * (日期1-31) * (月份1-12或是JAN-DEC) * (星期1-7或是SUN-SAT)
	 * 定时计算。每1分钟执行一次
	 */
	@Scheduled(cron = "0 */1 *  * * * ")
	public void reportCurrentByCron() {
		
	}
}
