package com.joyveb.gens.core.daoalltest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.joyveb.gens.core.daoalltest.mapper.ParaPropertiesMapper;

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
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-common.xml");
		ParaPropertiesMapper mapperService = (ParaPropertiesMapper)context.getBean(ParaPropertiesMapper.class);
//		System.out.println(mapperService.select2TableSingle());//3D
		GameInfo info = mapperService.select2TableBean();
		System.out.println(info.getCode());
		System.out.println(info.getName());
	}
}
