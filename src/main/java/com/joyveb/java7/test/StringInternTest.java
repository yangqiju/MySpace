package com.joyveb.java7.test;

/**
 * 
 * 项目名称：MySpace 类名称：StringInternTest
 * 
 * @Company: 北京畅享互联有限公司
 * @Copyright: Copyright (c) 2012
 * @Author： 杨其桔 创建时间：2013-9-30 上午10:19:21 修改备注：
 * @version
 * 
 */
public class StringInternTest {

	public static void main(String[] args) {
		System.out.println("Hello"=="Hello");
		System.out.println(new String("Hello")=="Hello");
		System.out.println(new String("Hello").intern() == "Hello");
	}
}
