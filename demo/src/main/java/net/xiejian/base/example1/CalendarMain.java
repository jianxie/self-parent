package net.xiejian.base.example1;

import java.util.Calendar;

/**
 * 日历类的具体内容
 * @author jian_xie
 * @date 2015年11月18日
 */
public class CalendarMain {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar.getTime());
		System.out.println("DAY_OF_WEEK,一个星期中的某天:" + calendar.get(Calendar.DAY_OF_WEEK));
		System.out.println("当前月中的第几个星期" + calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));
		System.out.println("本月第几天：" + calendar.get(Calendar.DAY_OF_MONTH));
		System.out.println("本年第几天:" + calendar.get(Calendar.DAY_OF_YEAR));
		System.out.println("WEEK_OF_MONTH,本月星期数:" + calendar.get(Calendar.WEEK_OF_MONTH));
		System.out.println("本年星期数:" + calendar.get(Calendar.WEEK_OF_YEAR));
		System.out.println("年:" + calendar.get(Calendar.YEAR));
	}
}
