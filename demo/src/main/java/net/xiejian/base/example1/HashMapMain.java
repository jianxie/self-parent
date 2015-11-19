package net.xiejian.base.example1;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author jian_xie
 * @date 2015年11月19日
 */
public class HashMapMain {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		for(int i = 0; i < 3; i++){
			map.put(String.valueOf(1), i + "");
		}
		System.out.println(map.toString());
	}

}
