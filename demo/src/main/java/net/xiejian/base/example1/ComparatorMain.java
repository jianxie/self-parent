package net.xiejian.base.example1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;


/**
 * 
 * @author jian_xie
 * @date 2015年11月16日
 */
public class ComparatorMain {

	public static void main(String[] args) {
		Random random = new Random();
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < 10; i++){
			list.add(random.nextInt(10));
		}
		System.out.println(list);
		testDesc(list);
		testAsc(list);
	}
	
	/**
	 * 降
	 */
	public static void testDesc(List<Integer> list){
		Collections.sort(list, new Comparator<Integer>(){
			// o1 为第二个值， o2为第一个值
			public int compare(Integer o1, Integer o2) {
				// 大于0,为大于， 0 为等于， 小于0，为小于
				return o1 - o2;
			}			
		});
		System.out.println(list);
	}
	
	/**
	 * 升
	 */
	public static void testAsc(List<Integer> list){
		Collections.sort(list, new Comparator<Integer>(){
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}			
		});
		System.out.println(list);
	}

}
