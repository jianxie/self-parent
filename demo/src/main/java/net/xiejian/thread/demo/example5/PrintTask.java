package net.xiejian.thread.demo.example5;

import java.util.concurrent.RecursiveAction;

/**
 * 没有返回值的任务
 * @author jian_xie
 * @date 2015年11月2日
 */
public class PrintTask extends RecursiveAction {

	private static final long serialVersionUID = 1L;
	
	// 每个小任务最多打印10个数
	private static final int max = 10;
	
	private int start;
	private int end;
	
	public PrintTask(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	protected void compute() {
		// 当end-start的值小于max的时候，开始打印
		if((end - start) < max){
			for(int i = start; i < end; i++){
				System.out.println(Thread.currentThread().getName() + "的i值：" + i);
			}
		}else{
			// 把大任务分成两个小任务
			int middle = (start + end) / 2;
			PrintTask left = new PrintTask(start, middle);
			PrintTask right = new PrintTask(middle, end);
			left.fork();
			right.fork();
		}
	}

}
