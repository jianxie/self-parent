package net.xiejian.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicMain {
	
	public static void main(String[] args) {
		
	}
	
	public static void test(){
		AtomicInteger acomic = new AtomicInteger(0);
		System.out.println(acomic.incrementAndGet());
		System.out.println(acomic.get());
	}
}
