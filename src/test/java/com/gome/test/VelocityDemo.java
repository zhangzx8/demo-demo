package com.gome.test;


import java.util.HashMap;
import java.util.Map;

import com.gome.util.VelocityUtil;

public class VelocityDemo {

	public static void main(String[] args) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("name", "xioawang");
		String path = "template/hello.vm";
		String path2 = "E:\\zhangzhixiang-ds\\workspace\\demo-demo\\src\\main\\webapp";
		String path3 = "\\template\\hello2.vm";
		//String res = VelocityUtil.getContent(map, path);
		String res2 = VelocityUtil.getContent2(map, path2, path3);
		System.out.println(res2);
		
	}
}
