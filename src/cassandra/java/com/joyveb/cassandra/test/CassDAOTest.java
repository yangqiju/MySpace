package com.joyveb.cassandra.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import me.prettyprint.cassandra.model.ConfigurableConsistencyLevel;
import me.prettyprint.cassandra.model.CqlQuery;
import me.prettyprint.cassandra.model.CqlRows;
import me.prettyprint.cassandra.model.thrift.ThriftRangeSlicesQuery;
import me.prettyprint.cassandra.serializers.ByteBufferSerializer;
import me.prettyprint.cassandra.serializers.StringSerializer;
import me.prettyprint.cassandra.service.CassandraHostConfigurator;
import me.prettyprint.cassandra.service.ThriftCluster;
import me.prettyprint.cassandra.service.template.ColumnFamilyResult;
import me.prettyprint.cassandra.service.template.ColumnFamilyTemplate;
import me.prettyprint.cassandra.service.template.ThriftColumnFamilyTemplate;
import me.prettyprint.cassandra.utils.Assert;
import me.prettyprint.hector.api.Cluster;
import me.prettyprint.hector.api.HConsistencyLevel;
import me.prettyprint.hector.api.Keyspace;
import me.prettyprint.hector.api.Serializer;
import me.prettyprint.hector.api.beans.HSuperColumn;
import me.prettyprint.hector.api.beans.OrderedRows;
import me.prettyprint.hector.api.beans.Row;
import me.prettyprint.hector.api.factory.HFactory;
import me.prettyprint.hector.api.mutation.Mutator;
import me.prettyprint.hector.api.query.QueryResult;
import me.prettyprint.hector.api.query.RangeSlicesQuery;
import me.prettyprint.hector.api.query.SuperColumnQuery;
import me.prettyprint.hom.HectorObjectMapper;

import org.apache.commons.lang3.StringUtils;

import com.joyveb.cassandra.dao.CassandraDaoException;
import com.joyveb.cassandra.dao.CassandraList;
import com.joyveb.cassandra.dao.Example;
import com.joyveb.cassandra.dao.JsonUtil;
import com.joyveb.cassandra.dao.SimGameInfo;

/**
 * 
 * 项目名称：Support 类名称：CassDAOTest
 * 
 * @Company: 北京畅享互联有限公司
 * @Copyright: Copyright (c) 2012
 * @Author： 杨其桔 创建时间：2013-6-6 下午6:02:12 修改备注：
 * @version
 * 
 */
public class CassDAOTest {

	private static Keyspace keyspace;
	private static String columnFamilyName;
	private static Serializer<String> keySerializer;
	private static StringSerializer stringSerializer = StringSerializer.get();
	private static Serializer<ByteBuffer> valueSerializer = ByteBufferSerializer
			.get();
	private static ColumnFamilyTemplate<String, String> columnFamilyTemplate;

	public static void main(String[] args) {
		init();
		queryColumns();
//		queryByexample();
//		selectByCql();
//		findByPages();
	}

	
	private static void findByPages() {
		Example<String> example = new Example<String>();
		example.addEqExpress("GAMENAME", "SLTO").addEqExpress("LTYPE", "SLTO")
				.addEqExpress("PLAYNAME", "SLTO")
				.addEqExpress("PRIZEDATE", "2013-06-05");
		
		long start = System.currentTimeMillis();
		CassandraList<String, SimGameInfo> cassandraList = new CassandraList<String, SimGameInfo>();
		Assert.notNull(example, "example is null.");
		RangeSlicesQuery<String, String, ByteBuffer> rangeSlicesQuery = HFactory
				.createRangeSlicesQuery(keyspace, keySerializer, keySerializer, valueSerializer);
		rangeSlicesQuery.setColumnFamily(columnFamilyName);
		rangeSlicesQuery.setKeys(null, null);
		// reason from [https://github.com/hector-client/hector/wiki/User-Guide]
		rangeSlicesQuery.setRowCount(10 + 1);
		rangeSlicesQuery.setReturnKeysOnly();//TODO ???
		rangeSlicesQuery.setRange(null, null, false, Integer.MAX_VALUE);
		example.appendExp2Query(rangeSlicesQuery);//TODO???
		QueryResult<OrderedRows<String, String, ByteBuffer>> resultQuery = rangeSlicesQuery
				.execute();
		if (resultQuery.get() != null) {
			List<Row<String, String, ByteBuffer>> rows = resultQuery.get().getList();
			rows.remove(10);//pagesize
			if (rows != null && rows.size() > 0) {
				String nextStartKey = resultQuery.get().peekLast().getKey();
				cassandraList.setStartKey(nextStartKey);
				List<SimGameInfo> beans = orderedRows2ListT(rows);
				cassandraList.setResultList(beans);
			}
		}
		System.out.println(columnFamilyName + " findbypages cost:"
				+ (System.currentTimeMillis() - start) + "ms");
		System.out.println(cassandraList.getResultList().size());
		//T_SIM_GAMEINFO findbypages cost:333ms  size:11
		//TODO 查询出11条数据
	}

	private static List<SimGameInfo> orderedRows2ListT(
			List<Row<String, String, ByteBuffer>> rows) {
		List<SimGameInfo> datas = new ArrayList<SimGameInfo>();
		if (rows != null) {
			Iterator<Row<String, String, ByteBuffer>> rowsIterator = rows.iterator();
			while (rowsIterator.hasNext()) {
				SimGameInfo data = row2Pojo(rowsIterator.next());
				datas.add(data);
			}
		}
		return datas;
	}


	public static void selectByCql(){
		String cql = "select * from "+columnFamilyName+" where KEY='74945433-0750-yang-9fcc-136444332083'";
		System.out.println(cql);
		QueryResult<CqlRows<String, String, ByteBuffer>> result = null;
		CqlQuery<String, String, ByteBuffer> cqlQuery = new CqlQuery<String, String, ByteBuffer>(
				keyspace, keySerializer, keySerializer, valueSerializer);
		cqlQuery.setQuery(cql);
		result = cqlQuery.execute();
		if(result.get()!=null){
			List<SimGameInfo> list = new ArrayList<SimGameInfo>();
			List<Row<String,String,ByteBuffer>> rows = result.get().getList();
			for(Row<String,String,ByteBuffer> row :rows){
				SimGameInfo info = row2Pojo(row);
				list.add(info);
			}
			System.out.println("list size is:"+list.size());
		}
	}
	public static void queryByexample() {
		RangeSlicesQuery<String, String, ByteBuffer> rangeQuery = new ThriftRangeSlicesQuery<String, String, ByteBuffer>(
				keyspace, keySerializer, stringSerializer, valueSerializer);
		rangeQuery.setColumnFamily(columnFamilyName);
		rangeQuery.setKeys(null, null);
		rangeQuery.setRange(null, null, false, Integer.MAX_VALUE);
		rangeQuery.setRowCount(1);//
		String value = "PCK3";//需要对字段添加索引
		String key = "gamename";
		String columnName = StringUtils.upperCase(key);
		Serializer serializer = HectorObjectMapper.determineSerializer(value
				.getClass());
		rangeQuery.addEqualsExpression(columnName, serializer.toByteBuffer(value));
		QueryResult<OrderedRows<String, String, ByteBuffer>> result = null;
		result = rangeQuery.execute();
		OrderedRows<String, String, ByteBuffer> rows = result.get();
		List<SimGameInfo> list = new ArrayList<SimGameInfo>();
		if(rows.getList()==null||rows.getList().size()<=0){
			System.out.println("select list is null");
			return;
		}
		for (Row<String, String, ByteBuffer> info : rows.getList()) {
			list.add(row2Pojo(info));
		}
		for(SimGameInfo info : list){
			System.out.println(JsonUtil.bean2Json(info).toString());
		}
	}

	private static SimGameInfo row2Pojo(Row<String, String, ByteBuffer> row) {
		SimGameInfo info = new SimGameInfo();
		info.setKey(row.getKey());
		try {
			for (Field field : info.getClass().getDeclaredFields()) {
				String filedName = StringUtils.upperCase(field.getName());
				if (row.getColumnSlice().getColumnByName(filedName) != null) {
					Serializer<?> serializer = HectorObjectMapper
							.determineSerializer(field.getType());
					Object value = serializer.fromByteBuffer(row
							.getColumnSlice().getColumnByName(filedName)
							.getValueBytes());
					String setterMether = "set"
							+ StringUtils.capitalize(field.getName());
					Method setter = info.getClass().getMethod(setterMether, value.getClass());
					setter.invoke(info, value);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return info;
	}

	public static void queryColumns() {
		String key = "74945433-0750-yang-9fcc-136444332083";
		ColumnFamilyResult<String, String> result = columnFamilyTemplate
				.queryColumns(key);
		SimGameInfo info = null;
		if (result.hasResults()) {
			info = cfResult2Pojo(result);
			System.out.println(JsonUtil.bean2Json(info).toString());
		}

	}

	private static SimGameInfo cfResult2Pojo(
			ColumnFamilyResult<String, String> result) {
		try {
			SimGameInfo t = new SimGameInfo();
			t.setKey(result.getKey());
			Class<?> clazz = t.getClass();
			Field[] fields = clazz.getDeclaredFields();
			for (Field field : fields) {
				String name = field.getName();
				String setterName = "set" + StringUtils.capitalize(name);
				Object value = drawColumnValue(field, result);
				if (value != null) {
					Method setter = clazz.getMethod(setterName,
							value.getClass());
					setter.invoke(t, value);
				}
			}
			return t;
		} catch (Exception e) {
			throw new CassandraDaoException("result to pojo error", e);
		}
	}

	private static Object drawColumnValue(Field field,
			ColumnFamilyResult<String, String> result) {
		byte[] bytes = result.getByteArray(StringUtils.upperCase(field
				.getName()));
		if (bytes == null) {
			return null;
		}
		return HectorObjectMapper.determineSerializer(field.getType())
				.fromBytes(bytes);
	}
	
	private static void inserSuperColumn(){
		Mutator<String> mutator = HFactory.createMutator(keyspace, stringSerializer);
		mutator.insert("billing", "Super1", HFactory.createSuperColumn("jsmith",Arrays.asList(HFactory.createStringColumn("first", "John")),stringSerializer, stringSerializer, stringSerializer));
	}
	
	private static void selectSuperColumn(){
		SuperColumnQuery<String, String, String, String> superColumnQuery =HFactory.createSuperColumnQuery(keyspace, stringSerializer,stringSerializer, stringSerializer, stringSerializer);
		superColumnQuery.setColumnFamily("Super1").setKey("billing").setSuperName("jsmith");
		QueryResult<HSuperColumn<String, String, String>> result = superColumnQuery.execute();
	}

	private static void init() {
//		String hosts = "192.168.3.141:9160,192.168.3.142:9160,192.168.3.143:9160,192.168.3.144:9160";
		String hosts = "192.168.3.141:9160";
		CassandraHostConfigurator chc = new CassandraHostConfigurator(hosts);
		Cluster cluster = new ThriftCluster("Test Cluster", chc);
		ConfigurableConsistencyLevel level = new ConfigurableConsistencyLevel();
		level.setDefaultReadConsistencyLevel(HConsistencyLevel.QUORUM);
		level.setDefaultWriteConsistencyLevel(HConsistencyLevel.QUORUM);
		Map<String, HConsistencyLevel> map = new HashMap<String, HConsistencyLevel>();
		map.put("T_SIM_GAMEINFO", HConsistencyLevel.ONE);
		keyspace = HFactory.createKeyspace("gxsim", cluster);
		columnFamilyName = "T_SIM_GAMEINFO";
		keySerializer = stringSerializer;
		columnFamilyTemplate = new ThriftColumnFamilyTemplate<String, String>(
				keyspace, columnFamilyName, keySerializer, stringSerializer);

	}
}
