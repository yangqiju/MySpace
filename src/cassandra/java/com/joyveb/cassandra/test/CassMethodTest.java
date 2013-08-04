package com.joyveb.cassandra.test;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.joyveb.cassandra.dao.CassandraList;
import com.joyveb.cassandra.dao.Example;
import com.joyveb.cassandra.dao.ExampleByCQL;
import com.joyveb.cassandra.dao.JsonUtil;
import com.joyveb.cassandra.dao.PageIterator;
import com.joyveb.cassandra.dao.SimGameInfo;
import com.joyveb.cassandra.dao.SimGameInfoDAO;

/**
 * 
 * 项目名称：Support 类名称：CassSelectByKeyTest
 * 
 * @Company: 北京畅享互联有限公司
 * @Copyright: Copyright (c) 2012
 * @Author： 杨其桔 创建时间：2013-6-6 下午3:29:05 修改备注：
 * @version
 * 
 */
public class CassMethodTest {

	private static SimGameInfoDAO simGameInfoDAO;
	private static int poolsize = 30;
	private static ExecutorService executorService;

	private static void init() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"cassandra-presure.xml");
		simGameInfoDAO = (SimGameInfoDAO) context.getBean("simGameInfoDAO",
				SimGameInfoDAO.class);
	}

	public static void main(String[] args) {
		init();
//		 for(int i=16;i<30;i++){
//		 insert(1+"");
//		 }
//		 selectByPrimaryKeyTest();
//		 selectByExampleTest();
//		 deleteBykey();
//		 selectByExampleToDate();
		// selectByExampleWithCQL();
		// selectByCQL();
		// poolSelectByExample();
//		findByPages();
//		findByPagePrev();
		count();
//		 truncate();
	}
	
	private static void truncate() {
		// TODO Auto-generated method stub
		simGameInfoDAO.truncate();
	}

	private static void count() {
		Example<String> example = new Example<String>();
		example.addEqExpress("GAMENAME", "PCK3").addEqExpress("LTYPE", "PCK3")
				.addEqExpress("PLAYNAME", "PCK3")
				.addEqExpress("PRIZEDATE", "2013-06-06");
		Integer count = simGameInfoDAO.count(example);
		System.out.println("count:"+count);
	}

	private static void findByPagePrev(){
		Example<String> example = new Example<String>();
		example.addEqExpress("GAMENAME", "PCK3").addEqExpress("LTYPE", "PCK3")
				.addEqExpress("PLAYNAME", "PCK3")
				.addEqExpress("PRIZEDATE", "2013-06-06");
		List<SimGameInfo> list = simGameInfoDAO.findByPage(example, 5, null, null);
		for(SimGameInfo info : list){
			System.out.println(JsonUtil.bean2Json(info).toString());
		}
	}

	private static void deleteBykey() {
		simGameInfoDAO.delete("10");
		simGameInfoDAO.delete("4");
		simGameInfoDAO.delete("3");
		simGameInfoDAO.delete("5");
	}

	private static void findByPages() {
		Example<String> example = new Example<String>();
		example.addEqExpress("GAMENAME", "PCK3").addEqExpress("LTYPE", "PCK3")
				.addEqExpress("PLAYNAME", "PCK3")
				.addEqExpress("PRIZEDATE", "2013-06-06");
		CassandraList<String, SimGameInfo> cassandraList = new CassandraList<String, SimGameInfo>();
		boolean first = true;
		while (cassandraList.getStartKey() != null||first) {
			cassandraList = simGameInfoDAO.findByPages(example, 10,
					cassandraList.getStartKey(), null);
			List<SimGameInfo> list = cassandraList.getResultList();
			for (SimGameInfo info : list) {
				System.out.println(JsonUtil.bean2Json(info).toString());
			}
			System.out.println("------------------" + list.size()
					+ "--------------------------");
			first = false;
		}
		System.out.println(cassandraList.getResultList().size());
	}

	public static void poolSelectByExample() {
		executorService = new ThreadPoolExecutor(poolsize, poolsize, 10,
				TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());
		for (int i = 0; i < poolsize; i++) {
			executorService.execute(new Presure());
		}
	}

	static class Presure implements Runnable {
		public void run() {
			selectByExampleTest();
		}
	}

	public static void selectByExampleTest() {
		for (int i = 1; i < 100; i++) {
			long start = System.currentTimeMillis();
			Example<String> example = new Example<String>();
			// example.addEqExpress("prizedate", "2013-06-05");
			PageIterator<String, SimGameInfo> pageiterator = simGameInfoDAO
					.createPageIterator(UUID.randomUUID().toString(), example);
			while (pageiterator.hasNext()) {
				List<SimGameInfo> list = pageiterator.next(10);
				break;
			}
			long end = System.currentTimeMillis();
			// for(SimGameInfo info : list){
			// System.out.println(JsonUtil.bean2Json(info).toString());
			// }
			System.out.println("times:" + (end - start));
		}
	}

	public static void selectByPrimaryKeyTest() {
		SimGameInfo simGameInfo = null;
//		while (simGameInfo == null) {
			String key = "b06c177e-bb7f-4dca-a732-62cd06ab8632";
			simGameInfo = simGameInfoDAO.selectByPrimaryKey(key);
//		}
		System.out.println(JsonUtil.bean2Json(simGameInfo).toString());
	}

	public static void selectByExampleToDate() {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(1374643573665L);
		System.out.println(DateFormatUtils.format(c, "yyyy-MM-dd HH:mm:ss"));
		
		Example<String> example = new Example<String>();
		example.addEqExpress("prizedate", "2013-06-06");
//		example.addEqExpress("createdate", c.getTime());
//		example.addLteExpress("createdate", c.getTime());
//		example.addGteExpress("createdate", c.getTime());
		 List<SimGameInfo> list = simGameInfoDAO.selectByExample(example);
		 for(SimGameInfo info : list){
			 System.out.println(JsonUtil.bean2Json(info).toString());
		 }
//		 System.out.println(list.size());
	}

	public static void insert(String key) {
		SimGameInfo info = new SimGameInfo();
//		 info.setKey("b06c177e-bb7f-4dca-a732-62cd06ab8632");
		info.setKey(key);
//		info.setKey(UUID.randomUUID().toString());
		info.setGamename("PCK3");
		info.setLtype("PCK3");
		info.setPlayname("PCK3");
		info.setExpireddates(60l);
		info.setPrizedate("2013-06-06");
		info.setCreatedate(new Date());
		simGameInfoDAO.insert(info);
	}

	public static void selectByExampleWithCQL() {
		ExampleByCQL example = new ExampleByCQL();
		// example.addEqExpress("ltype", "PCK3");
		example.addEqExpress("KEY", "74945433-0750-yang-9fcc-136444332083");
		List<SimGameInfo> list = simGameInfoDAO.selectByExampleWithCQL(example);
		if (list == null) {
			System.out.println("result is null");
			return;
		}
		for (SimGameInfo info : list) {
			System.out.println(JsonUtil.bean2Json(info).toString());
		}
	}

	public static void selectByCQL() {
		String cql = "select * from T_SIM_GAMEINFO where KEY='74945433-0750-yang-9fcc-136444332083'";
		// String cql =
		// "select * from T_SIM_GAMEINFO where ltype = 'PCK3' ";//不是主键，无法查询
		List<SimGameInfo> list = simGameInfoDAO.selectByCQL(cql);
		if (list == null) {
			System.out.println("result is null");
			return;
		}
		for (SimGameInfo info : list) {
			System.out.println(JsonUtil.bean2Json(info).toString());
		}
	}

}
