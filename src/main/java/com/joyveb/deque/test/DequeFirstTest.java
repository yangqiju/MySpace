package com.joyveb.deque.test;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * 
 * 项目名称：MySpace 类名称：DequeFristTest
 * 
 * @Company: 北京畅享互联有限公司
 * @Copyright: Copyright (c) 2012
 * @Author： 杨其桔 创建时间：2013-11-21 下午4:21:45 修改备注：
 * @version
 * 
 */
public class DequeFirstTest {

	public static void main(String[] args) {
		LinkedBlockingDeque<PeriodBean> deque = new LinkedBlockingDeque<PeriodBean>();
		System.out.println(System.currentTimeMillis());
		try {
			PeriodBean pb = deque.poll(10, TimeUnit.SECONDS);
			deque.push(pb);
			deque.put(pb);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(System.currentTimeMillis());
	}
}
