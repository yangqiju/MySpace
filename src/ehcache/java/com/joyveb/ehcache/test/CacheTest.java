package com.joyveb.ehcache.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.joyveb.ehcache.bean.User;
import com.joyveb.ehcache.bean.UserCache;

/**   
 *    
 * 项目名称：MySpace   
 * 类名称：CacheTest   
 * @Company: 北京畅享互联有限公司
 * @Copyright: Copyright (c) 2012
 * @Author： 杨其桔
 * 创建时间：2013-9-17 下午3:11:23   
 * 修改备注：   
 * @version    
 *    
 */
public class CacheTest {
	private static ApplicationContext ctx;

	public static void main(String[] args) {
		ctx = new ClassPathXmlApplicationContext(
				"test-applicationContext-ehcache.xml");
		UserCache userCache = (UserCache) ctx.getBean("userCache");
		User user = new User();
		user.setAge(10);
		user.setId("id1");
		user.setName("firstuser");
		userCache.putObject("id1", user);
		System.out.println(userCache.getObject("id1").getName());
		userCache.printConfig();
	}
}
