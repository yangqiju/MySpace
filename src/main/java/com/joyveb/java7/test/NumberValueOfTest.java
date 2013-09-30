package com.joyveb.java7.test;

/**
 * 
 * 项目名称：MySpace 类名称：NumberValueOfTest
 * 
 * @Company: 北京畅享互联有限公司
 * @Copyright: Copyright (c) 2012
 * @Author： 杨其桔 创建时间：2013-9-30 上午10:23:37 修改备注：
 * @version
 * 
 */
public class NumberValueOfTest {

	public static void main(String[] args) {
		System.out.println(Integer.valueOf(3)==Integer.valueOf(3));
		System.out.println(Integer.valueOf(64)==Integer.valueOf(64));
		System.out.println(Integer.valueOf(127)==Integer.valueOf(127));
		System.out.println(Integer.valueOf(129)==Integer.valueOf(129));
	}
}
