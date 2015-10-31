package net.xiejian.thread.demo.example2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 可定时的线程池
 * @author jian_xie
 * @date 2015年10月30日
 */
public class ScheduledThreadPoolExecutorMain {
	static ScheduledThreadPoolExecutor stpe = null;
	static int index;

	public static void main(String[] args) {
		stpe = new ScheduledThreadPoolExecutor(5);
		TaskThread taskThread = new TaskThread();
		System.out.println("time:" + getTimes());
		// 隔6秒后执行一次，但只会执行一次
//		stpe.schedule(taskThread, 6, TimeUnit.SECONDS);
		// 循环执行
		stpe.scheduleAtFixedRate(taskThread, 6, 5, TimeUnit.SECONDS);
//		stpe.scheduleWithFixedDelay(taskThread, 6, 5, TimeUnit.SECONDS);
		
	}

	private static String getTimes() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
		Date date = new Date();
		date.setTime(System.currentTimeMillis());
		return format.format(date);
	}

	private static class TaskThread implements Runnable {

		public void run() {
			index++;
			System.out.println("执行时间： " + getTimes() + " " + index);
			if (index >= 10) {
				stpe.shutdown();
				if (stpe.isShutdown()) {
					System.out.println("停止了？？？？");
				}
			}
		}
	}
}
