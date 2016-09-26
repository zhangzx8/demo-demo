package com.gome.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.util.StringUtils;





public class Denmo03 {

	public static void main(String[] args) {
		System.out.println(Denmo03.getLongTimeFromStr("2016-09-03 00:00:00", "yyyy-MM-dd HH:mm:ss"));
		//System.out.println(Denmo03.LongToStr(1473379729338l, "yyyy-MM-dd HH:mm:ss"));
	}
	
	public static String LongToStr(Long time, String pattern){
		Instant ins = Instant.ofEpochMilli(time);
		LocalDateTime ldt = LocalDateTime.ofInstant(ins, ZoneOffset.ofHours(8));
		return Denmo03.formatTime2Str(ldt, pattern);
	}
	
	public static String formatTime2Str(TemporalAccessor time, String pattern){
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
		return dateTimeFormatter.format(time);
	}
	
	public static long getLongTimeFromStr(String str, String pattern){
		Date date = Denmo03.Str2Date(str, pattern);
		return date.getTime();
	}
	
	public static Date Str2Date(String str, String pattern){
		if(StringUtils.isEmpty(pattern)){
			pattern = "yyyy-MM-dd HH:mm:ss";
		}
	    SimpleDateFormat sdf = new SimpleDateFormat(pattern);  
	    Date date = null;
		try {
			date = sdf.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return date;
	}
}
