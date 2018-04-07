package net.xiejian.thread.demo.example6;

public class WaitAndSleepMain {
	
	public static void main(String[] args) {
		WaitAndSleepMain waitAndSleepMain = new WaitAndSleepMain();
		Wait wait = waitAndSleepMain.new Wait();
//		Thread thread = new Thread(wait);
//		thread.start();
		wait.start();
		for(int i = 0; i < 10000; i++){
			wait.add(i);
		}
	}
	
	private class Wait extends Thread {		
		public void run() {
			System.out.println("run");
			try {
				wait(10000);
				System.out.println("after");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void add(int i){
			System.out.println(i);
		}
	}
}
