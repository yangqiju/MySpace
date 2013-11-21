package com.joyveb.deque.test;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

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
		LinkedBlockingDeque<String> deque = new LinkedBlockingDeque<String>();
//		String str = "";
//		deque.offer("a");
//		deque.add("a");
//		deque.addFirst("first");
//		deque.addLast("last");
//		deque.size();
//		str = deque.poll();
//		String str = deque.getLast();
//		String str = deque.element();//不删除
//		String str = deque.peek();
//		str = deque.peek();
//		str = deque.pop();
//		System.out.println(str);
//		System.out.println("end");
		LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<String>();
		queue.poll();
		System.out.println("end");
	}
}
