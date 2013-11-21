package com.joyveb.datastax.demo;

import java.util.Iterator;
import java.util.List;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ConsistencyLevel;
import com.datastax.driver.core.Host;
import com.datastax.driver.core.Metadata;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.SimpleStatement;
import com.datastax.driver.core.Statement;
import com.datastax.driver.core.querybuilder.Delete.Where;
import com.datastax.driver.core.querybuilder.Insert;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;

/**
 * 
 * 项目名称：MySpace 类名称：clientDemo
 * 
 * @Company: 北京畅享互联有限公司
 * @Copyright: Copyright (c) 2012
 * @Author： 杨其桔 创建时间：2013-10-25 下午2:34:01 修改备注：
 * @version
 * 
 */
public class ClientDemo {

	public static void main(String[] args) {
		// withClusterName set Test cluster
		Cluster cluster = Cluster.builder().withClusterName("Test Cluster")
				.addContactPoint("192.168.3.141").build();
		Session session = cluster.connect("mykeyspace");
		System.out.println("connected");
		// insert(null);//
		// delete(session);
		// select(session);
		findByPage2(session);
		// shutdown
		cluster.shutdown();

	}

	private static void printConfig(Cluster cluster) {
		Metadata metadata = cluster.getMetadata();
		System.out.println(metadata.getClusterName());
		for (Host host : metadata.getAllHosts()) {
			System.out.printf("Datatacenter: %s; Host: %s; Rack: %s\n",
					host.getDatacenter(), host.getAddress(), host.getRack());
		}
	}

	private static void insert(Session session) {
		Insert insert = QueryBuilder.insertInto("mykeyspace", "users")
				.value("user_id", 1749).value("fname", "john1")
				.value("lname", "smith1").ifNotExists();
		System.out.println("consistencylevel:" + insert.getConsistencyLevel());
		System.out.println("keyspace:" + insert.getKeyspace());
		System.out.println("getchSize:" + insert.getFetchSize());
		System.out.println("querystring:" + insert.getQueryString());
		// ResultSet set = session.execute(insert);
		// List<Row> rows = set.all();
		// for (Row row : rows) {
		// System.out.println(row.getBool(0));
		// System.out.println(row.getBool("[applied]"));// true or false
		// }
	}

	private static void delete(Session session) {
		Where delete = (Where) QueryBuilder.delete().all().from("users")
				.where().and(QueryBuilder.eq("user_id", 1746))
				.setConsistencyLevel(ConsistencyLevel.ANY);
		ResultSet set = session.execute(delete);
		List<Row> rows = set.all();
		System.out.println(delete.getQueryString());
		for (Row row : rows) {
			System.out.println(row.toString());
			// System.out.println(row.getBool(0));
			// System.out.println(row.getBool("[applied]"));//true or false
		}

	}

	private static void select(Session session) {
		for (Row row : session.execute("SELECT * FROM users")) {
			System.out.println(row.toString());
		}
		// Statement select =
		// QueryBuilder.select().all().from("mykeyspace","users").limit(2);
		Statement select = QueryBuilder.select().countAll()
				.from("mykeyspace", "users");
		System.out.println(select.toString());
		ResultSet resultSet = session.execute(select);
		List<Row> rows = resultSet.all();
		for (Row info : rows) {
			System.out.println(info.toString());
		}
	}

	private static void findByPage(Session session) {
		Select select = QueryBuilder.select().all().from("ticket");
		List<Row> rows = session.execute(select).all();
		for (Row row : rows) {
			System.out.println(row.toString());
		}
		System.out.println("----------------findByPage start------------------------");
		ResultSet rs = session.execute(select);
		Iterator<Row> iter = rs.iterator();
		while (iter.hasNext()) {
			if (rs.getAvailableWithoutFetching() == 3 && !rs.isFullyFetched())
				rs.fetchMoreResults();
//			System.out.println("rs.getAvailableWithoutFetching()"+rs.getAvailableWithoutFetching());
			Row row = iter.next();
			System.out.println(row.toString());
			System.out.println("--------findbypage--------");
		}
	}
	private static void findByPage2(Session session){
		int pagesize = 5;
		SimpleStatement select = new SimpleStatement(QueryBuilder.select().from("ticket").getQueryString());
		select.setFetchSize(pagesize);
		ResultSet rs = session.execute(select);
		System.out.println(rs.getAvailableWithoutFetching());// 每一次取多少个,
	}
}
