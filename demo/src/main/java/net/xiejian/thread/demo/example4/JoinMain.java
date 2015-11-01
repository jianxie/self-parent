package net.xiejian.thread.demo.example4;

/**
 * join的使用
 * 子线程调用了join()方法后面的代码，只有等到子线程结束了才能执行
 * @author jian_xie
 * @date 2015年10月31日
 */
public class JoinMain {

	public static void main(String[] args) throws InterruptedException {
		JoinMain joinMain = new JoinMain();
		Thread a = new Thread(joinMain.new PrintThread("A"));
		a.start();
		a.join();
		Thread b = new Thread(joinMain.new PrintThread("B"));
		b.start();
		b.join();
		Thread c = new Thread(joinMain.new PrintThread("C"));
		c.start();
		c.join();
	}
	
	public class PrintThread implements Runnable{
		
		private String str = null;
		
		public PrintThread(String str){
			this.str = str;
		}
		
		public void run() {
			System.out.println(str);
		}
	}
}
