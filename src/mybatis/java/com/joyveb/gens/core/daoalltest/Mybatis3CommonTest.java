package com.joyveb.gens.core.daoalltest;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.SelectBuilder;
import org.apache.ibatis.jdbc.SqlBuilder;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.joyveb.gens.core.daoalltest.mapper.ParaPropertiesMapper;



/**   
 *    
 * 项目名称：MySpace   
 * 类名称：ParaPropertiesDaoTest   
 * @Company: 北京畅享互联有限公司
 * @Copyright: Copyright (c) 2012
 * @Author： 杨其桔
 * 创建时间：2013-12-4 上午10:37:53   
 * 修改备注：   
 * @version    
 *    
 */
public class Mybatis3CommonTest {

	private static SqlSessionFactory sqlSessionFactory;
	static {
		String resource = "configuration.xml";
		Reader reader;
		try {
			reader = Resources.getResourceAsReader(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
//			sqlSessionFactory.getConfiguration().getTypeAliasRegistry().registerAlias(ParaProperties.class);
			sqlSessionFactory.getConfiguration().addMapper(ParaPropertiesMapper.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
//		OnlyMapperSelect();
//		selectAllByXml();
//		selectKeyByXml();
//		selectKeyByMapper();
//		selectBeanByXml();
//		selectByBean();
		selectByParm();
	}
	
	private static void selectByParm() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		ParaPropertiesMapper mapper = sqlSession.getMapper(ParaPropertiesMapper.class);
		ParaProperties list = mapper.selectByParm("common.notify.thread");
		System.out.println(list.toString());
	}

	private static void selectByBean() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		ParaPropertiesMapper mapper = sqlSession.getMapper(ParaPropertiesMapper.class);
		ParaProperties key = new ParaProperties();
		key.setKey("common.notify.thread");
		ParaProperties list = mapper.selectInfoByBean(key);
		System.out.println(list.toString());
	}
	
	private static void selectBeanByXml() {
		try(SqlSession sqlSession = sqlSessionFactory.openSession();){
			ParaProperties key = new ParaProperties();
			key.setKey("common.notify.thread");
			ParaProperties info =(ParaProperties) sqlSession.selectOne("selectByBean",key);
			System.out.println(info.toString());
		}
	}
	
	private static void selectKeyByMapper() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		ParaPropertiesMapper mapper = sqlSession.getMapper(ParaPropertiesMapper.class);
		ParaProperties list = mapper.selectkeyByMapper("common.notify.thread");
		System.out.println(list.toString());
	}

	private static void selectKeyByXml() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try{
			ParaProperties info =(ParaProperties) sqlSession.selectOne("selectByKey","common.notify.thread");
			System.out.println(info.toString());
		}finally{
			sqlSession.close();
		}
	}

	public static void OnlyMapperSelect(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		ParaPropertiesMapper mapper = sqlSession.getMapper(ParaPropertiesMapper.class);
		List<ParaProperties> list = mapper.selectAll();
		System.out.println(list.size());
	}
	
	public static void selectAllByXml(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<ParaProperties> list =sqlSession.selectList("selectAllByXml");
		System.out.println(list.size());
		System.out.println(list.get(0).toString());
	}
	
	public static void Sql(){
		SelectBuilder.BEGIN();
		SqlBuilder.BEGIN();
	}

}
