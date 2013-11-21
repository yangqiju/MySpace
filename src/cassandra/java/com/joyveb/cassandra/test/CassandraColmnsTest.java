package com.joyveb.cassandra.test;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import me.prettyprint.cassandra.model.ConfigurableConsistencyLevel;
import me.prettyprint.cassandra.serializers.ByteBufferSerializer;
import me.prettyprint.cassandra.serializers.StringSerializer;
import me.prettyprint.cassandra.service.CassandraHostConfigurator;
import me.prettyprint.cassandra.service.ThriftCluster;
import me.prettyprint.cassandra.service.template.ColumnFamilyResult;
import me.prettyprint.cassandra.service.template.ColumnFamilyTemplate;
import me.prettyprint.cassandra.service.template.ThriftColumnFamilyTemplate;
import me.prettyprint.hector.api.Cluster;
import me.prettyprint.hector.api.HConsistencyLevel;
import me.prettyprint.hector.api.Keyspace;
import me.prettyprint.hector.api.Serializer;
import me.prettyprint.hector.api.beans.HSuperColumn;
import me.prettyprint.hector.api.factory.HFactory;
import me.prettyprint.hector.api.mutation.Mutator;
import me.prettyprint.hector.api.query.QueryResult;
import me.prettyprint.hector.api.query.SuperColumnQuery;

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
public class CassandraColmnsTest {

	private static Keyspace keyspace;
	private static String columnFamilyName;
	private static Serializer<String> keySerializer;
	private static StringSerializer stringSerializer = StringSerializer.get();
	private static Serializer<ByteBuffer> valueSerializer = ByteBufferSerializer
			.get();
	private static ColumnFamilyTemplate<String, String> columnFamilyTemplate;

	public static void main(String[] args) {
		try{
			init();
			queryColumns();
		}catch(Throwable e){
			e.printStackTrace();
		}
	}

	public static void queryColumns() {
		String key = "ISNULL";
		ColumnFamilyResult<String, String> result = columnFamilyTemplate
				.queryColumns(key);
		if (result.hasResults()) {
			System.out.println(result.getColumnNames().size());
			Set ss =  (Set) result.getColumnNames();
			Iterator it = ss.iterator();
			while(it.hasNext()){
				System.out.println("///////////////");
				System.out.println(it.next());
			}
			System.out.println(ss.size());
		}
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
		String hosts = "192.168.3.141:9160,192.168.3.144";
		CassandraHostConfigurator chc = new CassandraHostConfigurator(hosts);
		Cluster cluster = new ThriftCluster("Test Cluster", chc);
		ConfigurableConsistencyLevel level = new ConfigurableConsistencyLevel();
		level.setDefaultReadConsistencyLevel(HConsistencyLevel.QUORUM);
		level.setDefaultWriteConsistencyLevel(HConsistencyLevel.QUORUM);
		Map<String, HConsistencyLevel> map = new HashMap<String, HConsistencyLevel>();
		map.put("ticket4", HConsistencyLevel.ONE);
		keyspace = HFactory.createKeyspace("mykeyspace", cluster);
		columnFamilyName = "ticket4";
		keySerializer = stringSerializer;
		columnFamilyTemplate = new ThriftColumnFamilyTemplate<String, String>(
				keyspace, columnFamilyName, keySerializer, stringSerializer);

	}
}
