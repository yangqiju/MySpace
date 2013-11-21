package com.joyveb.land.socket.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.commons.lang3.math.NumberUtils;


/**   
 *    
 * 项目名称：MySpace   
 * 类名称：QueryMain   
 * @Company: 北京畅享互联有限公司
 * @Copyright: Copyright (c) 2012
 * @Author： 杨其桔
 * 创建时间：2013-11-19 下午4:00:20   
 * 修改备注：   
 * @version    
 *    
 */
public class SingleLogicQueryMain {

	private static File file = null;
	private static FileWriter fw = null;
	private static String FILE_NAME = "socketTest";
	private static ExecutorService executorService;
	private static int poolsize = 10;
	private static String[] logicCode = {};
	private static String host = "";
	private static int port= 6202;
	private static List<Long> times = new ArrayList<Long>();
	private static CountDownLatch latch = null;
	
	private static void init(String[] args) {
		file = new File(FILE_NAME);
		host = args[0];
		port = NumberUtils.toInt(args[1]);
		logicCode = args[2].split(",");
		poolsize = NumberUtils.toInt(args[3]);
		latch = new CountDownLatch(poolsize*logicCode.length);
	}
	
	public static void main(String[] args) throws InterruptedException {
		if(args.length!=4){
			System.out.println("input:  host port logicCode poolsize|host port logiccode,logiccode poolsize");
			System.exit(0);
		}
		init(args);
		executorService = new ThreadPoolExecutor(poolsize, poolsize, 10,
				TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());
		UploadDataClient client = new UploadDataClient();
		long start = System.currentTimeMillis();
		for(int i= 0;i<poolsize;i++){
			for(int j = 0;j<logicCode.length;j++){
				executorService.execute(new QueryMoneryThread(client, logicCode[j], host, port));
			}
		}
		latch.await();
		long end = System.currentTimeMillis();
		long maxtime = 0;
		for(long i : times){
			if(i>maxtime){
				maxtime = i;
			}
		}
		appendContent("测试结束..总耗时["+(end-start)+"]线程最大耗时["+maxtime+"]");
		executorService.shutdown();
	}
	
	public static void appendContent(String content){
		try {
			fw = new FileWriter(file, true);
			fw.append(content+"\n");
			System.out.println(content+"\n");
			fw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
//			if(fw!=null){
//				try {
//					fw.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
		}
	}
	
	static class QueryMoneryThread extends Thread{
		private String host;
		private int port;
		private UploadDataClient client;
		private String logicCode;
		private int command = 3;//查询余额
		
		public QueryMoneryThread(UploadDataClient client,String logicCode,String host ,int port) {
			this.client = client;
			this.logicCode = logicCode;
			this.host = host ;
			this.port = port ; 
		}
		
		@Override
		public void run() {
			int randInt = PadUtil.randomInt();
			long start = System.currentTimeMillis();
			try {
//				appendContent("time["+start+"]终端["+logicCode+"]"+"随机码["+randInt + "]:开始查询");
				String returnCode = client.sendData(randInt, command, logicCode, host, port);
				long end = System.currentTimeMillis();
				String[] datas = returnCode.split(Constants.TAB);
				if (randInt == NumberUtils.toInt( datas[0] ) ) {
					appendContent("starttime["+start+"]endtime["+end+"]终端["+logicCode+"]耗时["+(end-start)+"]随机码["+randInt + "]:结束查询");
				}else{
					System.out.println("error");
				}
//				appendContent("time["+end+"]终端["+logicCode+"]"+"随机码["+randInt + "]:结束查询");
				times.add(end-start);
			} catch (IOException e) {
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally{
				latch.countDown();
			}
		}
	}
}
