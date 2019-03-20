package cn.smileyan.boot.main.util;

import java.util.Calendar;

public class TimeUtil {
	/**
	 * 获得系统当前时间
	 * @return 时间的字符串形式
	 */
	public static String getCurrentTime() {
		Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
		int year = c.get(Calendar.YEAR); 
		int month = c.get(Calendar.MONTH)+1; 
		int date = c.get(Calendar.DATE); 
		int hour = c.get(Calendar.HOUR_OF_DAY); 
		int minute = c.get(Calendar.MINUTE); 
		int second = c.get(Calendar.SECOND);
		return year+"年"+month+"月"+date+"日"+hour+"时"+minute+"分"+second+"秒";
	}
}
