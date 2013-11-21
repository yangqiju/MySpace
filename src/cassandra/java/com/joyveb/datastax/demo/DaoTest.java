package com.joyveb.datastax.demo;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.joyveb.datastax.bean.User;

/**   
 *    
 * 项目名称：MySpace   
 * 类名称：DaoTest   
 * @Company: 北京畅享互联有限公司
 * @Copyright: Copyright (c) 2012
 * @Author： 杨其桔
 * 创建时间：2013-10-29 下午4:00:55   
 * 修改备注：   
 * @version    
 *    
 */
public class DaoTest {

	public static void main(String[] args) {
		Cluster cluster = Cluster.builder().withClusterName("Test Cluster")
				.addContactPoint("192.168.3.141").build();
		Session session = cluster.connect("mykeyspace");
		UserCassandraDao dao = new UserCassandraDao(cluster, session, "mykeyspace", "users");
//		insert(dao);
//		delete(dao);
		cluster.shutdown();
	}
	
	private static void insert(UserCassandraDao dao){
		for(int i=0;i<10;i++){
			User pojo = new User();
			pojo.setUserid(i);
			pojo.setFname("yang");
			pojo.setLname("juzi");
//			System.out.println(dao.insert(pojo));
		}
	}
	
	private static void delete(UserCassandraDao dao){
		Example<User> example = new Example<User>();
//		example.addEqExpress("user_id", 1746);
		example.addEqExpress("user_id", 1745);
//		dao.delete(example);
	}
	
	private static void update(UserCassandraDao dao){
		User user = new User();
		user.setFname("yang");
		user.setKey("111");
		user.setLname("abc");
		dao.updateByPrimaryKey(user);
	}
}
