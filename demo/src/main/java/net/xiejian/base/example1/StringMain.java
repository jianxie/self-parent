package net.xiejian.base.example1;

public class StringMain {

	public static void main(String[] args) {
		String s = new String("abc");
		String s1 = "abc";
		String s2 = new String("abc");
		System.out.println(s == s1);
		System.out.println(s == s2);
		System.out.println(s1 == s2);
	}

}
