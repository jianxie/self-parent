package net.xiejian.common.utils;

import java.lang.reflect.ParameterizedType;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * 日期工具类
 * @author jian_xie
 * @date 2015年10月29日
 */
public class DateUtil {
	/** 锁对象 */
    private static final Object lockObj = new Object();
	
	private static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd hh:mm:ss";
	
	private static final String YYYY_MM_DD = "yyyy-MM-dd";
	
	private static Map<String, ThreadLocal<SimpleDateFormat>> sdfMap = new HashMap<String, ThreadLocal<SimpleDateFormat>>();
	
	/**
	 * 返回一个ThreadLocal的sdf,每个线程只会new一次sdf
	 * @param pattern
	 * @return
	 */
	private static SimpleDateFormat getSdf(final String pattern){
		ThreadLocal<SimpleDateFormat> tl = sdfMap.get(pattern);
		// 此处的双重判断和同步是为了防止sdfMap这个单例被多次put重复的sdf
		if(tl == null){
			synchronized (lockObj) {
				tl = sdfMap.get(pattern);
				if(tl == null){
					tl = new ThreadLocal<SimpleDateFormat>(){

						@Override
						protected SimpleDateFormat initialValue() {
							return new SimpleDateFormat(pattern);
						}
					};
					sdfMap.put(pattern, tl);
				}
			}
		}
		return tl.get();
	}
}
