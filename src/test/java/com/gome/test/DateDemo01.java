package com.gome.test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class DateDemo01 {

	public static void main(String[] args) {
		Instant timestamp = Instant.now();
		System.out.println(timestamp.toEpochMilli());
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println(localDateTime.toInstant(ZoneOffset.ofHours(8)).toEpochMilli());
	}
}
