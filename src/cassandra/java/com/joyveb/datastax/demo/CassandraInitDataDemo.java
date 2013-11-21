package com.joyveb.datastax.demo;

import java.util.List;

import com.datastax.driver.core.BatchStatement;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.SimpleStatement;

public class CassandraInitDataDemo {

	public static void main(String[] args) {
		Cluster cluster = Cluster.builder().withClusterName("Test Cluster").addContactPoint("192.168.3.141").build();
		try{
			Session session = cluster.connect();
			System.out.println("connected");
//			showKeyspace(session);
//			createKeyspace(session);
//			dropKeyspace(session);
//			dropTable(session);
			createTable(session);
//			insertInitData(session);
//			addIndex(session);
		}finally{
			cluster.shutdown();
		}
		
	}
	
	public static void createKeyspace(Session session){
		String cql = "CREATE KEYSPACE mykeyspace WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };";
		ResultSet set = session.execute(cql);
		List<Row> rows = set.all();
		for(Row row : rows){
			System.out.println(row.toString());
		}
	}
	public static void showKeyspace(Session session){
		String cql = "show keyspaces;";
		ResultSet set = session.execute(cql);
		List<Row> rows = set.all();
		for(Row row : rows){
			System.out.println(row.toString());
		}
	}
	public static void dropKeyspace(Session session){
		String cql = "drop keyspace mykeyspace;";
		ResultSet set = session.execute(cql);
		List<Row> rows = set.all();
		for(Row row : rows){
			System.out.println(row.toString());
		}
	}
	public static void createTable(Session session){
		String use = "USE mykeyspace;";
		ResultSet set = session.execute(use);
		String sql = "CREATE TABLE users (userid int,age int, fname text,lname text,PRIMARY KEY(userid,fname));";
		ResultSet set2 = session.execute(sql);
	}
	public static void dropTable(Session session){
		String use = "USE mykeyspace;";
		ResultSet set = session.execute(use);
		String cql = "drop table users;";
		ResultSet set2 = session.execute(cql);
	}
	public static void insertInitData(Session session){
		BatchStatement batch = new BatchStatement();
		for(int i=0;i<20;i++){
			batch.add(new SimpleStatement("INSERT INTO users (userid, age, fname, lname) VALUES (?,?, ?, ?);",i,i,"yang"+i,"juzi"));
		}
		ResultSet set = session.execute(batch);
		List<Row> rows = set.all();
		for(Row row : rows){
			System.out.println(row.toString());
		}
	}
	public static void addIndex(Session session){
		String use = "USE mykeyspace;";
		ResultSet set = session.execute(use);
		String cql1 = "CREATE INDEX ageIndex ON users (age);";
		String cql2 = "CREATE INDEX fnameIndex ON users (fname);";
		String cql3 = "CREATE INDEX lnameIndex ON users (lname);";
		session.execute(cql1);
		session.execute(cql2);
		session.execute(cql3);
	}
}
