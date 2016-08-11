package com.gome.test;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

public class Demo02Test {

	public static void main(String[] args) {
	      LocalTime time1 = LocalTime.now();
	      Duration twoHours = Duration.ofHours(2);

	      LocalTime time2 = time1.plus(twoHours);

	      Duration duration = Duration.between(time1, time2);
	      System.out.println("Duration: " + duration);

	}
	
}
