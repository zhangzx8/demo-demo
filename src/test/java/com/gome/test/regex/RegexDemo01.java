package com.gome.test.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo01 {
	   private static String REGEX = "a*b";
	   private static String INPUT = "aabfooaabfooabfoob";
	   private static String REPLACE = "-";
	   public static void main(String[] args) {
	      Pattern p = Pattern.compile(REGEX);
	      // get a matcher object
	      Matcher m = p.matcher(INPUT);
	      StringBuffer sb = new StringBuffer();
	      while(m.find()){
	         m.appendReplacement(sb,REPLACE);
	      }
	    //  sb = m.appendTail(sb);
	      System.out.println(sb.toString());
	   }
}
