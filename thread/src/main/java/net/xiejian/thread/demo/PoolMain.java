package net.xiejian.thread.demo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池
 * @author jian_xie
 * @date 2015年10月30日
 */
public class PoolMain {

	public static void main(String[] args) {
		ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
				new ArrayBlockingQueue<Runnable>(5));

		for (int i = 0; i < 15; i++) {
			SimpleThread myTask = new SimpleThread(i);
			executor.execute(myTask);
			System.out.println("线程池中线程数目：" + executor.getPoolSize() + "，队列中等待执行的任务数目：" + executor.getQueue().size()
					+ "，已执行玩别的任务数目：" + executor.getCompletedTaskCount());
		}
		executor.shutdown();
	}

}
