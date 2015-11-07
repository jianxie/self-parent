package net.xiejian.base.example1;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.TreeMap;

/**
 * 
 * @author jian_xie
 * @date 2015年11月7日
 */
public class TreeMapMain {

	public static void main(String[] args) {
		testTreeMap();
	}
	
	public static void testSet(){
		
	}

	public static void testTreeMap(){
		Random ranom = new Random();
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		int n = 0;
		for(int i = 0; i < 10; i++){
			n = ranom.nextInt(100);
			System.out.println("n:" + n + ", i:" + i);
			map.put(ranom.nextInt(100), i);
		}
		
		Entry<Integer, Integer> firstEntry = map.firstEntry();
		System.out.println("key:" + firstEntry.getKey() + ", Value:" + firstEntry.getValue());
		for(Entry<Integer, Integer> entry : map.entrySet()){
			System.out.println("key:" + entry.getKey() + ", value:" + entry.getValue());
		}
	}
}
