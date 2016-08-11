package com.gome.test;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;


public class Demo01Test {
 
	public static void main(String[] args) {
		// 取当前日期：
		LocalDate today = LocalDate.now(); // -> 2014-12-24
		// 根据年月日取日期，12月就是12：
		LocalDate crischristmas = LocalDate.of(2014, 12, 25); // -> 2014-12-25
		// 根据字符串取：
		LocalDate endOfFeb = LocalDate.parse("2014-02-28"); // 严格按照ISO yyyy-MM-dd验证，02写成2都不行，当然也有一个重载方法允许自己定义格式
	//	LocalDate.parse("2014-02-29"); // 无效日期无法通过：DateTimeParseException: Invalid date
		
		// 取本月第1天：
		LocalDate firstDayOfThisMonth = today.with(TemporalAdjusters.firstDayOfMonth()); // 2014-12-01
		// 取本月第2天：
		LocalDate secondDayOfThisMonth = today.withDayOfMonth(2); // 2014-12-02
		// 取本月最后一天，再也不用计算是28，29，30还是31：
		LocalDate lastDayOfThisMonth = today.with(TemporalAdjusters.lastDayOfMonth()); // 2014-12-31
		// 取下一天：
		LocalDate firstDayOf2015 = lastDayOfThisMonth.plusDays(1); // 变成了2015-01-01
		// 取2015年1月第一个周一，这个计算用Calendar要死掉很多脑细胞：
		LocalDate firstMondayOf2015 = LocalDate.parse("2015-01-01").with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY)); // 2015-01-05
		
		
		//包含毫秒
		LocalTime now = LocalTime.now(); // 11:09:09.240
		//清除毫秒数：
		LocalTime now2 = LocalTime.now().withNano(0); // 11:09:09
		LocalTime zero = LocalTime.of(0, 0, 0); // 00:00:00
//		时间也是按照ISO格式识别，但可以识别以下3种格式：
//
//		12:00
//		12:01:02
//		12:01:02.345
		LocalTime mid = LocalTime.parse("12:00:00"); // 12:00:00
		
//		最新JDBC映射将把数据库的日期类型和Java 8的新类型关联起来：
//
//		SQL -> Java
//		--------------------------
//		date -> LocalDate
//		time -> LocalTime
//		timestamp -> LocalDateTime
//		再也不会出现映射到java.util.Date其中日期或时间某些部分为0的情况了。
		
		//时间戳转换
		long current = System.currentTimeMillis();
		Instant ins = Instant.ofEpochMilli(current);
		ZoneId currentZone = ZoneId.systemDefault();
		LocalDateTime time = LocalDateTime.ofInstant(ins, currentZone);
		
		//本月第二个星期六”或“下周二
	      //Get the current date
	      LocalDate date1 = LocalDate.now();
	      System.out.println("Current date: " + date1);	  

	      //get the next tuesday
	      LocalDate nextTuesday = date1.with(TemporalAdjusters.next(DayOfWeek.TUESDAY));
	      System.out.println("Next Tuesday on : " + nextTuesday);

	      //get the second saturday of next month
	      LocalDate firstInYear = LocalDate.of(date1.getYear(),date1.getMonth(), 1);

	      LocalDate secondSaturday = firstInYear.with(
          TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY)).with(
          TemporalAdjusters.next(DayOfWeek.SATURDAY));
	      System.out.println("Second saturday on : " + secondSaturday);	
	      
	      //toInstant()方法被添加到可用于将它们转换到新的日期时间的API原始日期和日历对象。使用ofInstant(Insant,ZoneId)方法得到一个LocalDateTime或ZonedDateTime对象。
	      //Get the current date
	      Date currentDate = new Date();
	      System.out.println("Current date: " + currentDate);	  

	      //Get the instant of current date in terms of milliseconds
	      Instant nownow = currentDate.toInstant();
	      ZoneId currentZonecurrentZone = ZoneId.systemDefault();

	      LocalDateTime localDateTime = LocalDateTime.ofInstant(nownow, currentZone);
	      System.out.println("Local date: " + localDateTime);	  

	      ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(nownow, currentZone);
	      System.out.println("Zoned date: " + zonedDateTime);
	      

	      
		System.out.println(mid);
	}
	
	
	
	
//	使用Java8，两个专门类引入来处理时间差。
//
//	Period - 处理有关基于时间的日期数量。
//
//	Duration - 处理有关基于时间的时间量。
	   public void testPeriod(){
		      //Get the current date
		      LocalDate date1 = LocalDate.now();
		      System.out.println("Current date: " + date1);	   

		      //add 1 month to the current date
		      LocalDate date2 = date1.plus(1, ChronoUnit.MONTHS);
		      System.out.println("Next month: " + date2);	  

		      Period period = Period.between(date2, date1);
		      System.out.println("Period: " + period);	    
		   }	
		   
		   public void testDuration(){
		      LocalTime time1 = LocalTime.now();
		      Duration twoHours = Duration.ofHours(2);

		      LocalTime time2 = time1.plus(twoHours);

		      Duration duration = Duration.between(time1, time2);
		      System.out.println("Duration: " + duration);	  	 
		   }
		   
		   
		   
		  // java.time.temporal.ChronoUnit 枚举在 Java8 中添加，以取代旧的API用来代表日，月等整数值
		   public void testChromoUnits(){
			   //Get the current date
		       LocalDate today = LocalDate.now();
			   System.out.println("Current date: " + today);	   
			   //add 1 week to the current date
		       LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);
			   System.out.println("Next week: " + nextWeek);	   
			   //add 1 month to the current date
		       LocalDate nextMonth = today.plus(1, ChronoUnit.MONTHS);
			   System.out.println("Next month: " + nextMonth);	  
			   //add 1 year to the current date
		       LocalDate nextYear = today.plus(1, ChronoUnit.YEARS);
			   System.out.println("Next year: " + nextYear);	  
			   //add 10 years to the current date
		       LocalDate nextDecade = today.plus(1, ChronoUnit.DECADES);
			   System.out.println("Date after ten year: " + nextDecade);	  
		   }	
		   
		   //时区日期时间的API正在使用当时区要被考虑时
		   public void testZonedDateTime(){
			      // Get the current date and time
			      ZonedDateTime date1 = ZonedDateTime.parse("2007-12-03T10:15:30+05:30[Asia/Karachi]");  
			      System.out.println("date1: " + date1);
			      ZoneId id = ZoneId.of("Europe/Paris");
			      System.out.println("ZoneId: " + id);		 
				  ZoneId currentZone = ZoneId.systemDefault();
				  System.out.println("CurrentZone: " + currentZone);	   
			   }	
		   
		   
		   //LocalDate/本地时间和LocalDateTime类简化时区不需要开发。
		   public void testLocalDateTime(){
			      // Get the current date and time
			      LocalDateTime currentTime = LocalDateTime.now();     
			      System.out.println("Current DateTime: " + currentTime);

			      LocalDate date1 = currentTime.toLocalDate();
			      System.out.println("date1: " + date1);
			      Month month = currentTime.getMonth();
			      int day = currentTime.getDayOfMonth();
			      int seconds = currentTime.getSecond();
			      System.out.println("Month: " + month
			         +"day: " + day
			         +"seconds: " + seconds
			      );

			      LocalDateTime date2 = currentTime.withDayOfMonth(10).withYear(2012);
			      System.out.println("date2: " + date2);

			      //12 december 2014
			      LocalDate date3 = LocalDate.of(2014, Month.DECEMBER, 12); 
			      System.out.println("date3: " + date3);

			      //22 hour 15 minutes
			      LocalTime date4 = LocalTime.of(22, 15); 
			      System.out.println("date4: " + date4);

			      //parse a string
			      LocalTime date5 = LocalTime.parse("20:15:30"); 
			      System.out.println("date5: " + date5);
			   }	


}
