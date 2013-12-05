package com.joyveb.gens.core.daoalltest;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

/**   
 *    
 * 项目名称：MySpace   
 * 类名称：ParaPropertiesDao   
 * @Company: 北京畅享互联有限公司
 * @Copyright: Copyright (c) 2012
 * @Author： 杨其桔
 * 创建时间：2013-12-5 上午11:42:47   
 * 修改备注：   
 * @version    
 *    
 */
public interface ParaPropertiesDao {

	public ParaProperties selectInfoByBean(ParaProperties info);
	
	public List<ParaProperties> selectAll();
	
	public void insert(ParaProperties info);
}
