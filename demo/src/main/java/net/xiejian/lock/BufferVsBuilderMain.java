package net.xiejian.lock;

public class BufferVsBuilderMain {
	
	private static final int times = 1000000;

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
		
		start = System.currentTimeMillis();
//		add();
		end = System.currentTimeMillis();
		System.out.println("add:" + (end - start));
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
	
	public static void add(){
		String str = "";
		for(int i = 0; i < times; i++){
			str += i;
		}
	}

}
