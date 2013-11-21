package com.joyveb.datastax.demo;

import static com.datastax.driver.core.querybuilder.QueryBuilder.delete;
import static com.datastax.driver.core.querybuilder.QueryBuilder.eq;
import static com.datastax.driver.core.querybuilder.QueryBuilder.insertInto;
import static com.datastax.driver.core.querybuilder.QueryBuilder.select;
import static com.datastax.driver.core.querybuilder.QueryBuilder.set;
import static com.datastax.driver.core.querybuilder.QueryBuilder.update;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ConsistencyLevel;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.Statement;
import com.datastax.driver.core.querybuilder.Delete.Where;
import com.datastax.driver.core.querybuilder.Insert;
import com.datastax.driver.core.querybuilder.Update.Assignments;
import com.joyveb.cassandra.dao.CassandraPrimaryKey;

/**
 * 
 * 项目名称：MySpace 类名称：CassandraDaoSupport
 * 
 * @Company: 北京畅享互联有限公司
 * @Copyright: Copyright (c) 2012
 * @Author： 杨其桔 创建时间：2013-10-29 下午2:23:32 修改备注：
 * @version
 * 
 */
public abstract class CassandraDaoSupport<K, T extends CassandraPrimaryKey<K>> {

	protected Cluster cluster;
	protected String keyspace;
	protected String columnFamilyName;
	protected Session session;// singe
	protected String KEY = "key";

	public CassandraDaoSupport(Cluster cluster, Session session) {
		this.cluster = cluster;
		this.session = session;
	}

	public CassandraDaoSupport(Cluster cluster, Session session,
			String keyspace, String columnFamilyName) {
		this.keyspace = keyspace;
		this.cluster = cluster;
		this.session = session;
		this.columnFamilyName = columnFamilyName;

	}

	public boolean insert(T pojo) {
		// 一致性级别
		Insert insert = (Insert) insertInto(columnFamilyName).ifNotExists()
				.setConsistencyLevel(ConsistencyLevel.ALL);
		try {
			Class<?> clazz = pojo.getClass();
			Field[] fields = clazz.getDeclaredFields();
			for (Field field : fields) {
				String name = field.getName();
				String getterName = "get" + StringUtils.capitalize(name);
				Method getter = clazz.getDeclaredMethod(getterName);
				Object result = getter.invoke(pojo);
				if (result != null) {
					insert.value(name, result);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO throw Exception
		}
		ResultSet set = session.execute(insert);
		Row row = set.one();
		return row.getBool("[applied]");// or getBool(0)
	}

	public void updateByPrimaryKey(T pojo) {
		com.datastax.driver.core.querybuilder.Update.Where update = update(
				columnFamilyName).where(eq(KEY, pojo.getKey()));
		try {
			Assignments ass = null;
			boolean frist = true;
			Class<?> clazz = pojo.getClass();
			Field[] fields = clazz.getDeclaredFields();
			for (Field field : fields) {
				String name = field.getName();
				String getterName = "get" + StringUtils.capitalize(name);
				Method getter = clazz.getDeclaredMethod(getterName);
				Object result = getter.invoke(pojo);
				if (result != null) {
					if (frist) {
						ass = update.with(set(name, result));
					} else {
						ass.and(set(name, result));
					}
				}
			}
			session.execute(update);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteByKey(K k) {
		Where delete = delete().all().from(columnFamilyName).where(eq(KEY, k));
		session.execute(delete);
	}

	public void selectByKey(K k){
		Statement statement = select().all().from(columnFamilyName).where(eq(KEY, k));
		List<Row> rows = session.execute(statement).all();
	}
	
	private T row2Pojo(Row row){
		return null;
	}
}
