package com.joyveb.ehcache.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.joyveb.ehcache.bean.IDGenerator;
import com.joyveb.ehcache.bean.UserCache;

/**
 * @Title: EhcacheGetAndPutTimeTest.java
 * @Company: 北京畅享互联有限公司
 * @Copyright: Copyright (c) 2011
 * @Description:
 * @author 杨其桔
 * @date 2013-10-18 上午11:13:14
 * @version V1.0
 */
public class EhcacheGetAndPutTimeTest {
	private static ApplicationContext ctx;
	private static UserCache cache;
	private static long HOUR = 60 * 60 * 1000;// 小时
	private static AtomicLong count = new AtomicLong(0);
	private static ExecutorService executorService;
	private static boolean STOP = false;
	private static AtomicLong sumTime = new AtomicLong(0);
	private static int poolsize = 50;
	private static int sleepTime = 10*1000;//seconds
	
	public static void main(String[] args) {
		init();//
		executorService = new ThreadPoolExecutor(poolsize, poolsize, 10, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());
		long start = System.currentTimeMillis();
		for (int i = 0; i < poolsize; i++) {
			executorService.execute(new PutIfAbsentThread());
		}
		long end = System.currentTimeMillis();
		long elapseTime = end - start;
		long time = HOUR/20;
		while(elapseTime<time){
			try {
				TimeUnit.MILLISECONDS.sleep(sleepTime);
				elapseTime+=sleepTime;
				long tps = count.get() * 1000 / elapseTime;
				System.out.println("elaspe time : " + elapseTime+ "ms, count is " + count.get() + " TPS is : " + tps+ ".  response time:" + sumTime.doubleValue() / count.get());
				end = System.currentTimeMillis();
				elapseTime = end-start;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		STOP = true;
		executorService.shutdown();
		System.out.println("test end");
	}
	
	private static void init(){
		ctx = new ClassPathXmlApplicationContext("test-applicationContext-ehcache.xml");
		cache = (UserCache) ctx.getBean("userCache");
	}
	
	
	
	static class GetCacheThread extends Thread{
		@Override
		public void run() {
			while(!STOP){
				insertMessageid(IDGenerator.getInstance().generate(), "QGLOTO");
				long start = System.currentTimeMillis();
				isRepeatMsgId(IDGenerator.getInstance().generate());
				long end = System.currentTimeMillis();
				sumTime.addAndGet(end - start);// 累加相应时间
				count.incrementAndGet();
			}
		}
		
		public static boolean isRepeatMsgId(String msgid){
			return cache.getObjectA(msgid)!=null;
		}
		
		public void insertMessageid(String msgid,String ltype){
//			CoreJdMessageid cjmId = new CoreJdMessageid();
//			cjmId.setLtype(ltype);
//			cjmId.setMessageid(msgid);
//			//ltype_msgid
//			cjmId.setCreatedate(new Date());
			cache.putObject(msgid, msgid);
		}
	}
	
	static class PutIfAbsentThread extends Thread{
		@Override
		public void run() {
			while(!STOP){
//				insertMessageid(IDGenerator.getInstance().generate(),"QGSLTO");
				long start = System.currentTimeMillis();
				isRepeatMsgId(IDGenerator.getInstance().generate(),"QGSLTO");
				long end = System.currentTimeMillis();
				sumTime.addAndGet(end - start);// 累加相应时间
				count.incrementAndGet();
			}
		}
		
		public static boolean isRepeatMsgId(String msgId,String ltype){
//			CoreJdMessageid cjmId = new CoreJdMessageid();
//			cjmId.setLtype(ltype);
//			cjmId.setMessageid(msgId);
//			cjmId.setCreatedate(new Date());
			return cache.putIfAbsent(msgId, msgId)!=null;
		}
		
		public void insertMessageid(String msgid,String ltype){
//			CoreJdMessageid cjmId = new CoreJdMessageid();
//			cjmId.setLtype(ltype);
//			cjmId.setMessageid(msgid);
//			cjmId.setCreatedate(new Date());
			cache.putObject(msgid, msgid);
		}
	}
	
}
