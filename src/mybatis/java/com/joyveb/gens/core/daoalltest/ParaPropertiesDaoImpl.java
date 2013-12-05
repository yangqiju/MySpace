package com.joyveb.gens.core.daoalltest;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.joyveb.gens.core.daoalltest.mapper.ParaPropertiesMapper;

/**   
 *    
 * 项目名称：MySpace   
 * 类名称：ParaPropertiesDao   
 * @Company: 北京畅享互联有限公司
 * @Copyright: Copyright (c) 2012
 * @Author： 杨其桔
 * 创建时间：2013-12-5 上午10:31:56   
 * 修改备注：   
 * @version    
 *    
 */
@Repository("paraPropertiesDao")
public class ParaPropertiesDaoImpl extends SqlSessionDaoSupport implements ParaPropertiesDao{

	@Resource(name = "sqlSession")
	private SqlSessionTemplate sqlSessionTemplate;
	
	@PostConstruct
	public void init(){
		this.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	public ParaProperties selectInfoByBean(ParaProperties info){
		return getSqlSession().getMapper(ParaPropertiesMapper.class).selectInfoByBean(info);
	}
	
	public List<ParaProperties> selectAll(){
		return getSqlSession().selectList("com.joyveb.gens.core.daoalltest.ParaPropertiesMapper.selectAllByXml");
	}
	
	@Transactional
	public void insert(ParaProperties info){
		getSqlSession().getMapper(ParaPropertiesMapper.class).insert(info);
		throw new RuntimeException();
	}
}
