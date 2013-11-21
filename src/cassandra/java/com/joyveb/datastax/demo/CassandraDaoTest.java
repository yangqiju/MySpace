package com.joyveb.datastax.demo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.datastax.driver.core.BatchStatement;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.DataType;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.SimpleStatement;
import com.datastax.driver.core.Statement;
import com.datastax.driver.core.querybuilder.Delete.Where;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
import com.joyveb.datastax.bean.DataObjectMapper;
import com.joyveb.datastax.bean.User;

public class CassandraDaoTest {

	private static final String CLUSTER_NAME = "Test Cluster";
	private static final String[] CONTACTPOINT = {"192.168.3.141","192.168.3.144"} ;
	private static final String KEYSPACE = "mykeyspace";
	private static final String TABLE = "users";
	public static void main(String[] args) {
		Cluster cluster = Cluster.builder().withClusterName(CLUSTER_NAME).addContactPoints(CONTACTPOINT).build();
		try{
			Session session = cluster.connect(KEYSPACE);
			System.out.println("connected");
//			delete(session);
//			update(session);
//			insert(session);
			select(session);
//			select2Bean(session);
//			beanNameAndType();
//			selectByExample(session);
		}finally{
			cluster.shutdown();
			System.out.println("end");
		}
	}
	
	public static void select(Session session){
		Select select = QueryBuilder.select().all().from(TABLE);
		for(Row row : session.execute(select).all()){
			System.out.println(row.toString());
		}
	}
	
	public static void select2Bean(Session session){
		Select select = QueryBuilder.select().all().from(TABLE);
		ResultSet set = session.execute(select);
		Row row = set.one();
		User pojo = new User();
		try{
			for(Field field : pojo.getClass().getDeclaredFields()){
				DataType datatype = row.getColumnDefinitions().getType(field.getName());
				Object value = DataObjectMapper.getValue(row, field.getName(), datatype);
				String setterMether = "set"
						+ StringUtils.capitalize(field.getName());
				Method setter = pojo.getClass().getMethod(setterMether,
						value.getClass());
				setter.invoke(pojo, value);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(pojo.getFname());
		System.out.println(pojo.getKey());
		System.out.println(pojo.getLname());
		System.out.println(pojo.getUserid());
	}
	public static void beanNameAndType(){
		User user = new User();
		for(Field field : user.getClass().getDeclaredFields()){
			System.out.println(field.getName());
		}
	}
	public static void selectByExample(Session session){
		Statement select = QueryBuilder.select().all().from(TABLE).where(QueryBuilder.in("userid", 10,11,12,13,14,15));
		System.out.println(select.toString());
//		String cql = "SELECT * FROM users WHERE token(userid)>token(10);";
		String cql = "SELECT * FROM users WHERE fname='yang12' and age>11 ALLOW FILTERING;";
		ResultSet set = session.execute(cql);
		for(Row row:set.all()){
			System.out.println(row.toString());
		}
	}
	public static void insert(Session session){
		BatchStatement batch = new BatchStatement();
		for(int i=0;i<20;i++){
			batch.add(new SimpleStatement("INSERT INTO users (userid,age,fname, lname) VALUES (?,?, ?, ?);",i,i,"yang"+i,"juzi"));
		}
		ResultSet set = session.execute(batch);
		List<Row> rows = set.all();
		for(Row row : rows){
			System.out.println(row.toString());
		}
	}
	public static void delete(Session session){
		Where delete = QueryBuilder.delete().all().from(TABLE).where().and(QueryBuilder.eq("userid", 10));
		System.out.println(delete.getQueryString());
		session.execute(delete);
	}
	public static void update(Session session){
		Statement update = QueryBuilder.update(TABLE).with(QueryBuilder.set("fname", "yang")).where(QueryBuilder.eq("userid", 10));
		System.out.println(update.toString());
		session.execute(update);
	}
}

