package net.xiejian.thread.demo.example1;

/**
 * 简单线程
 * @author jian_xie
 * @date 2015年10月30日
 */
public class SimpleThread implements Runnable {

	private int taskNum;
	
	public SimpleThread(int num){
		this.taskNum = num;
	}
	
	public void run() {
		System.out.println("线程在running:"+taskNum);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("执行完毕" + taskNum);
	}

}
