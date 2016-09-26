package com.gome.test;

import java.util.UUID;

public class UUIDdemo {

	public static void main(String[] args) {
		System.out.println("network"+UUID.randomUUID().toString().replaceAll("-", ""));
	}
}
