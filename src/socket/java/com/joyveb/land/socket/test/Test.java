package com.joyveb.land.socket.test;

import java.util.concurrent.atomic.AtomicLong;

/**   
 *    
 * 项目名称：CasDataStaxTest   
 * 类名称：Test   
 * @Company: 北京畅享互联有限公司
 * @Copyright: Copyright (c) 2012
 * @Author： 杨其桔
 * 创建时间：2013-11-19 下午7:04:26   
 * 修改备注：   
 * @version    
 *    
 */
public class Test {
	public static void main(String[] args) {
		AtomicLong threadSumTime = new AtomicLong(0);
		threadSumTime.set(50);
		threadSumTime.compareAndSet(60, 60);
		System.out.println(threadSumTime.get());
	}
}
