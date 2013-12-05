package com.joyveb.gens.core.daoalltest;

import java.util.List;

import org.antlr.grammar.v3.ANTLRv3Parser.throwsSpec_return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joyveb.gens.core.daoalltest.mapper.ParaPropertiesMapper;

/**   
 *    
 * 项目名称：MySpace   
 * 类名称：MappderService   
 * @Company: 北京畅享互联有限公司
 * @Copyright: Copyright (c) 2012
 * @Author： 杨其桔
 * 创建时间：2013-12-5 上午11:02:19   
 * 修改备注：   
 * @version    
 *    
 */
@Service("mapperService")
public class MapperService {

	@Autowired
	public ParaPropertiesMapper paraMapper;
	
	public List<ParaProperties> selectAll(){
		return paraMapper.selectAll();
	}
	
	@Transactional
	public void insert(ParaProperties info){
		paraMapper.insert(info);
		throw new RuntimeException();
	}
}
