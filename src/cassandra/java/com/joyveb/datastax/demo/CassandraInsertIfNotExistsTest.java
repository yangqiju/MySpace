package com.joyveb.datastax.demo;

import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.querybuilder.Insert;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.joyveb.ehcache.bean.IDGenerator;

/**
 * 
 * 项目名称：MySpace 类名称：CassandraInsertIfNotExistsTest
 * 
 * @Company: 北京畅享互联有限公司
 * @Copyright: Copyright (c) 2012
 * @Author： 杨其桔 创建时间：2013-11-6 上午11:38:12 修改备注：
 * @version
 * 
 */
public class CassandraInsertIfNotExistsTest {

	private static Cluster cluster1 = null;
	private static Cluster cluster2 = null;
	private static Session session1 = null;
	private static Session session2 = null;
	private static String HOST1 = "192.168.3.141";
	private static String HOST2 = "192.168.3.144";
	private static String CLUSTERNAME = "Test Cluster";
	private static String KEYSPACE = "mykeyspace2";
	private static String TABLE = "users";
	private static AtomicInteger stopCount = new AtomicInteger();
	private static AtomicInteger failCount = new AtomicInteger();
	private static boolean STOP = false;
	private static long HOUR = 60 * 60 * 1000;// 小时
	private static long SIZE = 10000;

	public static void main(String[] args) {
		System.out.println("--------------test start----------------");
		init();
		InsertThread insert1 = new InsertThread(session1, HOST1);
		InsertThread insert2 = new InsertThread(session2, HOST2);
		insert1.start();
		insert2.start();
		while(stopCount.get()!=2){
		}
		cluster1.shutdown();
		cluster2.shutdown();
		System.out.println("--------------insert end----------------");
		System.out.println("faildcount:"+failCount.get());
	}

	private static class InsertThread extends Thread {
		private Session session = null;
		private String host;

		public InsertThread(Session session, String host) {
			this.session = session;
			this.host = host;
		}

		@Override
		public void run() {
			for(int i=0;i<=SIZE;i++){
				try {
					insert(i);
				} catch (Exception e) {
					e.printStackTrace();
					failCount.incrementAndGet();
				}
			}
			stopCount.incrementAndGet();
		}

		private void insert(int i) {
			Insert insert = QueryBuilder.insertInto(TABLE)
					.value("userid", i+"")
					.value("fname", host).value("age", 1)
					.value("lname", host).ifNotExists();
			ResultSet set = session.execute(insert);
			if(set.one().getBool("[applied]")){
				System.out.println("key:"+i+" exists ");
			}
		}
	}

	private static void init() {
		cluster1 = Cluster.builder().withClusterName(CLUSTERNAME)
				.addContactPoint(HOST1).build();
		cluster2 = Cluster.builder().withClusterName(CLUSTERNAME)
				.addContactPoint(HOST2).build();
		session1 = cluster1.connect(KEYSPACE);
		session2 = cluster2.connect(KEYSPACE);
	}
}
