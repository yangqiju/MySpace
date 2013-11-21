package com.joyveb.datastax.bean;

import lombok.Data;

import com.joyveb.cassandra.dao.CassandraPrimaryKey;


/**   
 *    
 * 项目名称：MySpace   
 * 类名称：User   
 * @Company: 北京畅享互联有限公司
 * @Copyright: Copyright (c) 2012
 * @Author： 杨其桔
 * 创建时间：2013-10-29 下午4:01:27   
 * 修改备注：   
 * @version    
 *    
 */
public @Data class User extends CassandraPrimaryKey<String>{
	private Integer userid;
	private String fname;
	private String lname;
}
