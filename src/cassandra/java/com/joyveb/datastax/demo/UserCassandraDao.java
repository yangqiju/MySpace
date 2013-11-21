package com.joyveb.datastax.demo;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.joyveb.datastax.bean.User;



/**   
 *    
 * 项目名称：MySpace   
 * 类名称：UserCassandraDao   
 * @Company: 北京畅享互联有限公司
 * @Copyright: Copyright (c) 2012
 * @Author： 杨其桔
 * 创建时间：2013-10-29 下午4:10:43   
 * 修改备注：   
 * @version    
 *    
 */
public class UserCassandraDao extends CassandraDaoSupport<String, User> {

	public UserCassandraDao(Cluster cluster, Session session, String keyspace,
			String columnFamilyName) {
		super(cluster, session, keyspace, columnFamilyName);
	}




}
