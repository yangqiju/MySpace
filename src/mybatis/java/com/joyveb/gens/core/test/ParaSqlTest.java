package com.joyveb.gens.core.test;

import java.util.List;

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
		int size  =  paraMapper.sumByExample(example);
		int end = 0;
		for(int i=0;i<3;i++){
			example.setStartRow(10*i);
			example.setEndRow(10*(i+1));
			List<ParaProperties> list = paraMapper.selectByExample(example);
			System.out.println(size);
			for(ParaProperties info : list){
				System.out.println(info.getKey());
			}
			System.out.println("********************************************");
		}
	}
}
