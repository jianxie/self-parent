package net.xiejian.thread.demo.example5;

import java.util.concurrent.RecursiveTask;

/**
 * 有返回值的任务
 * @author jian_xie
 * @date 2015年11月2日
 */
public class SumTask extends RecursiveTask<Integer> {
	private static final int max = 10;
	
	private int arr[];
	
	private int start;
	
	private int end;
	
	public SumTask(int arr[], int start, int end){
		this.arr = arr;
		this.start = start;
		this.end = end;
	}
	
	
	@Override
	protected Integer compute() {
		int sum = 0;
		if((end - start) < max){
			for(int i = start; i < end; i++){
				sum += arr[i];
			}
			return sum;
		}else{
			System.out.println("任务分解");
			int middle = (start + end) / 2;
			SumTask left = new SumTask(arr, start, middle);
			SumTask right = new SumTask(arr, middle, end);
			left.fork();
			right.fork();
			return left.join() + right.join();
		}
	}

}
