package net.xiejian.base.example1;

import java.util.ArrayList;
import java.util.List;

public class ListMain {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
//		for(int i = 0; i < 10; i++){
//			list.add(i);
//		}
		
		System.out.println(list.indexOf(9));
		System.out.println(list.remove(list.indexOf(10)));
	}
}
