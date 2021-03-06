package com.joyveb.land.socket.test;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.cassandra.thrift.Cassandra.Processor.set_cql_version;

/**
 * 
 * 项目名称：MySpace 类名称：TianjinSocketPressure
 * 
 * @Company: 北京畅享互联有限公司
 * @Copyright: Copyright (c) 2012
 * @Author： 杨其桔 创建时间：2013-11-21 上午10:13:26 修改备注：
 * @version
 * 
 */
public class TianjinSocketPressure {

	private static ExecutorService executorService;
	private static String MONI_HOST = "192.168.3.177";
	private static int MONI_PORT = 6202;
	private static UploadDataClient client = new UploadDataClient();
	private static int command = 3;//查询余额
	private static int poolsize = 10;
	private static String logicCode = "12280001";
	private static long HOUR = 60 * 60 * 1000;// 小时
	private static boolean STOP = false;
	private static AtomicLong successCount = new AtomicLong();
	private static AtomicLong faildCount = new AtomicLong();
	private static int sleepTime = 10*1000;//seconds

	public static void main(String[] args) {
		executorService = new ThreadPoolExecutor(poolsize, poolsize, 10,
				TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());
		long start = System.currentTimeMillis();
		System.out.println("测试开始...");
		for(int i=0;i<poolsize;i++){
			executorService.execute(new TianjinClient());
		}
		long end = System.currentTimeMillis();
		long elapseTime = end - start;
		long time = HOUR/12;
		while(elapseTime<time){
			try{
				TimeUnit.MILLISECONDS.sleep(sleepTime);
				elapseTime+=sleepTime;
				long tps = successCount.get()*1000 /elapseTime;
				System.out.println("tps["+tps+"]线程数["+poolsize+"]成功数["+successCount.get()+"]失败["+faildCount.get()+"]");
				end = System.currentTimeMillis();
				elapseTime = end - start;
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		STOP = true;
		executorService.shutdown();
		System.out.println("测试结束.....");
		long tps = successCount.get()*1000 /elapseTime;
		System.out.println("tps["+tps+"]线程数["+poolsize+"]成功数["+successCount.get()+"]失败["+faildCount.get()+"]");
	}

	static class TianjinClient extends Thread {
		@Override
		public void run() {
			while(!STOP){
				int randInt = PadUtil.randomInt();
				try {
					client.sendData(randInt, command, logicCode, MONI_HOST, MONI_PORT);
					successCount.incrementAndGet();
				} catch (Exception e) {
					faildCount.incrementAndGet();
//					e.printStackTrace();
				}
			}
		}
	}
}
