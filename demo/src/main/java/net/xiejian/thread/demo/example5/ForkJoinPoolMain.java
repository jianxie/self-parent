package net.xiejian.thread.demo.example5;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ForkJoinPoolMain {
	public static void main(String[] args) throws Exception {
		ForkJoinPool forkJoinPool = new ForkJoinPool();
//		forkJoinPool.submit(new PrintTask(0,200));
//		forkJoinPool.awaitTermination(2, TimeUnit.SECONDS);//阻塞当前线程直到 ForkJoinPool 中所有的任务都执行结束    
		
		
		int arr[] = new int[100];
		Random random = new Random();
		int total = 0;
		for(int i = 0; i < arr.length; i++){
			int temp = random.nextInt(100);
			total +=(arr[i]=temp);
		}
		
		System.out.println("初始化时的总和="+total);
		
		Future<Integer> future = forkJoinPool.submit(new SumTask(arr, 0, arr.length));
		System.out.println("sum: " + future.get());
		
		// 关闭线程池    
		forkJoinPool.shutdown();
	}
}
