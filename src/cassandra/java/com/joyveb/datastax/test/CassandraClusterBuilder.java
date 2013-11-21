package com.joyveb.datastax.test;

import org.apache.commons.lang3.StringUtils;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

/**
 * 
 * 项目名称：MySpace 类名称：CassandraClusterBuilder
 * 
 * @Company: 北京畅享互联有限公司
 * @Copyright: Copyright (c) 2012
 * @Author： 杨其桔 创建时间：2013-10-30 下午7:24:34 修改备注：
 * @version
 * 
 */
public class CassandraClusterBuilder {

	private static Cluster cluster;

	private CassandraClusterBuilder() {
	}

	public static Cluster builder(String clusterName, String addresss) {
		synchronized (CassandraClusterBuilder.class) {
			if (cluster == null) {
				cluster = Cluster.builder().withClusterName(clusterName)
						.addContactPoints(StringUtils.split(addresss, ","))
						.build();
			}
		}
		return cluster;
	}
	
	public static Session getSession(Cluster cluster,String keyspace){
		if(cluster==null){
			return null;
		}
		return cluster.connect(keyspace);
	}
}
