package com.joyveb.gens.core.test;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.joyveb.gens.jpa.mapper.ParaPropertiesMapper;
import com.joyveb.gens.jpa.model.ParaProperties;
import com.joyveb.gens.jpa.model.ParaPropertiesExample;

/**   
 *    
 * 项目名称：MySpace   
 * 类名称：ParaSqlTest   
 * @Company: 北京畅享互联有限公司
 * @Copyright: Copyright (c) 2012
 * @Author： 杨其桔
 * 创建时间：2013-12-5 下午5:54:41   
 * 修改备注：   
 * @version    
 *    
 */
public class ParaSqlTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-test.xml");
		ParaPropertiesMapper paraMapper = (ParaPropertiesMapper)context.getBean("paraPropertiesMapper");
		ParaPropertiesExample example = new ParaPropertiesExample();
		example.setStartRow(1);
		example.setEndRow(10);
		List<ParaProperties> list =  paraMapper.selectByExample(example);
		System.out.println(list.size());
	}
}
