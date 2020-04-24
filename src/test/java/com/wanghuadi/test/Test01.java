package com.wanghuadi.test;

import java.text.ParseException;

import com.wanghuadi.utils.DateUtil;
import com.wanghuadi.utils.StringUtil;

public class Test01 {

	public static void main(String[] args) throws ParseException {
		
		boolean empty = StringUtil.isEmpty("");
		boolean empty2 = StringUtil.isEmpty("1");
		System.out.println(empty);
		System.out.println(empty2);
		
		
		boolean float1 = StringUtil.isFloat("11.");
		boolean float2 = StringUtil.isFloat("1.1");
		System.out.println(float1);
		System.out.println(float2);
		
		
		int age = DateUtil.getAge("1997-08-02");
		System.out.println(age);
		
	}
	
}
