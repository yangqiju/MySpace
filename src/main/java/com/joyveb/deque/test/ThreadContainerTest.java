package com.joyveb.deque.test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 
 * 项目名称：MySpace 类名称：ThreadContainerTest
 * 
 * @Company: 北京畅享互联有限公司
 * @Copyright: Copyright (c) 2012
 * @Author： 杨其桔 创建时间：2013-11-22 上午10:52:07 修改备注：
 * @version
 * 
 */
public class ThreadContainerTest {

	private class EncashThreadPoolExecutor extends ThreadPoolExecutor {
		public EncashThreadPoolExecutor(int corePoolSize, int maximumPoolSize,
				long keepAliveTime, TimeUnit unit,
				BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
			super(corePoolSize, maximumPoolSize, keepAliveTime, unit,
					workQueue, threadFactory);
		}
	}

	private class EncashThreadFactory implements ThreadFactory {
		@Override
		public Thread newThread(Runnable r) {
			EncashTask task = new EncashTask();
			task.setName("abc");
			return task;
		}
	}

	private class EncashTask extends Thread {
		@Override
		public void run() {
			try {
				TimeUnit.SECONDS.sleep(10);
				System.out.println(this.getName() + "--end");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	private void start(){
		EncashThreadPoolExecutor executor = new EncashThreadPoolExecutor(10,
				10, 0, TimeUnit.MILLISECONDS,
				new LinkedBlockingDeque<Runnable>(), new EncashThreadFactory());
		executor.execute(new EncashTask());
	}

	public static void main(String[] args) {
		ThreadContainerTest test = new ThreadContainerTest();
		test.start();
	}
}
