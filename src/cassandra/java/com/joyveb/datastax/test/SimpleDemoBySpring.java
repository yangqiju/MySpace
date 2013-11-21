package com.joyveb.datastax.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.datastax.driver.core.Cluster;

/**
 * 
 * 项目名称：MySpace 类名称：SimpleDemoBySpring
 * 
 * @Company: 北京畅享互联有限公司
 * @Copyright: Copyright (c) 2012
 * @Author： 杨其桔 创建时间：2013-10-30 下午7:18:15 修改备注：
 * @version
 * 
 */
public class SimpleDemoBySpring {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("cassandra-datastax-presure.xml");
		Cluster cluster =(Cluster) context.getBean("cluster");
		cluster.connect();
		System.out.println("connected");
	}
	
}
