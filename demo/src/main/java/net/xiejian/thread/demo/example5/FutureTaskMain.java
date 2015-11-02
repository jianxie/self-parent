package net.xiejian.thread.demo.example5;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutureTaskMain {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
		FutureT t = new FutureT();
		FutureTask<Integer> futureTask = new FutureTask<Integer>(t);
		executor.submit(futureTask);
		executor.shutdown();
		
		//第二种方式，注意这种方式和第一种方式效果是类似的，只不过一个使用的是ExecutorService，一个使用的是Thread
		FutureTask<Integer> futureTask2 = new FutureTask<Integer>(t);
		Thread thread = new Thread(futureTask2);
		thread.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		System.out.println("主线程在执行任务");
		
		try {
			System.out.println("task2运行结果"+futureTask.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
		System.out.println("所有任务执行完毕");
	}

} 

class FutureT implements Callable<Integer> {
	public Integer call() throws Exception {
		System.out.println("子线程在进行计算");
		Thread.sleep(3000);
		int sum = 0;
		for (int i = 0; i < 100; i++)
			sum += i;
		return sum;
	}
}