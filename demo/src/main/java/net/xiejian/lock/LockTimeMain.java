package net.xiejian.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 加锁时间分析
 * @author jian_xie
 * @date 2015年10月31日
 */
public class LockTimeMain {
	
	private Lock lock = new ReentrantLock();
	
	public static void main(String[] args) {
		LockTimeMain lockMain = null;
		long start, end;
		long times = 100000;
		
		lockMain = new LockTimeMain();
		start = System.currentTimeMillis();
		for(int i = 0; i < times; i++){
			lockMain.test4();
		}
		end = System.currentTimeMillis();
		System.out.println("test4:" + (end - start));
		
		lockMain = new LockTimeMain();
		start = System.currentTimeMillis();
		for(int i = 0; i < times; i++){
			lockMain.test1();
		}
		end = System.currentTimeMillis();
		System.out.println("test1:" + (end - start));
		
		lockMain = new LockTimeMain();
		start = System.currentTimeMillis();
		for(int i = 0; i < times; i++){
			lockMain.test2();
		}
		end = System.currentTimeMillis();
		System.out.println("test2:" + (end - start));
		
		lockMain = new LockTimeMain();
		start = System.currentTimeMillis();
		for(int i = 0; i < times; i++){
			lockMain.test3();
		}
		end = System.currentTimeMillis();
		System.out.println("test3:" + (end - start));
	}
	
	public void test1(){
		run();
	}
	
	public synchronized void test2(){
		run();
	}
	
	public void test3(){
		lock.lock();
		try{
			run();
		}finally{
			lock.unlock();
		}
	}
	
	public synchronized void test4(){
		run();
	}

	private void run() {		
		for(int i=0; i < 1000; i++){
			List list1 = new ArrayList(i);
//			List list2 = new ArrayList();
		}
	}
	
	
	
}
