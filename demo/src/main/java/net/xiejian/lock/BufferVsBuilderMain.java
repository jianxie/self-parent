package net.xiejian.lock;

public class BufferVsBuilderMain {
	
	private static final int times = 10000000;

	public static void main(String[] args) {
		long start, end;
		start = System.currentTimeMillis();
		buffer();
		end = System.currentTimeMillis();
		System.out.println("buffer:" + (end - start));
		
		start = System.currentTimeMillis();
		builder();
		end = System.currentTimeMillis();
		System.out.println("builder:" + (end - start));
	}
	
	public static void buffer(){
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < times; i++){
			sb.append(sb);
		}
	}
	
	public static void builder(){
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < times; i++){
			sb.append(sb);
		}
	}

}
