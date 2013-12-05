package com.joyveb.gens.core.daoalltest;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**   
 *    
 * 项目名称：MySpace   
 * 类名称：ParaPropertiesMapperDaoTest   
 * @Company: 北京畅享互联有限公司
 * @Copyright: Copyright (c) 2012
 * @Author： 杨其桔
 * 创建时间：2013-12-5 上午11:00:09   
 * 修改备注：   
 * @version    
 *    
 */
public class ParaPropertiesMapperDaoTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext*.xml");
		MapperService mapperService = (MapperService)context.getBean("mapperService");
		ParaProperties info = new ParaProperties();
		info.setKey("yang.test");
		info.setValue("yang");
		info.setDes("des");
		mapperService.insert(info);
	}
}
