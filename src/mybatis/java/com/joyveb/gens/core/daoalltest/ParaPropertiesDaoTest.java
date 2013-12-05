package com.joyveb.gens.core.daoalltest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**   
 *    
 * 项目名称：MySpace   
 * 类名称：ParaPropertiesDaoTest   
 * @Company: 北京畅享互联有限公司
 * @Copyright: Copyright (c) 2012
 * @Author： 杨其桔
 * 创建时间：2013-12-5 上午10:37:22   
 * 修改备注：   
 * @version    
 *    
 */
public class ParaPropertiesDaoTest {


	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext*.xml");
		ParaPropertiesDao paraPropertiesDao = (ParaPropertiesDao)context.getBean("paraPropertiesDao");
		ParaProperties key  = new ParaProperties();
//		key.setKey("common.notify.thread");
//		ParaProperties info = paraPropertiesDao.selectInfoByBean(key);
//		System.out.println(info.getValue());
		key.setKey("yang.test");
		key.setValue("value");
		key.setDes("des");
		paraPropertiesDao.insert(key);
	}

}
