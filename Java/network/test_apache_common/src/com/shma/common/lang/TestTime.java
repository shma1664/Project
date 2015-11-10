package com.shma.common.lang;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.time.FastDateFormat;

public class TestTime {

	public static void main(String[] args) {
		System.out.println(StringUtils.center("demoDateUtil", 30, "-"));
		Date date = new Date();
		
		//日期格式化
		System.out.println(DateFormatUtils.ISO_DATE_FORMAT.format(date));
		//时间格式化
		System.out.println(DateFormatUtils.ISO_TIME_NO_T_FORMAT.format(date));
	
		FastDateFormat fdf = FastDateFormat.getInstance("yyyy-MM");
		System.out.println(fdf.format(date));
		
		System.out.println(DateUtils.round(date, Calendar.HOUR));;
	}
}
