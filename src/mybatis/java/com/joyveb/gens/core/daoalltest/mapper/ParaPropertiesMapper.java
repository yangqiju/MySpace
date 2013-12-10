package com.joyveb.gens.core.daoalltest.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.joyveb.gens.core.daoalltest.GameInfo;
import com.joyveb.gens.core.daoalltest.ParaProperties;

/**   
 *    
 * 项目名称：MySpace   
 * 类名称：ParaPropertiesMapper   
 * @Company: 北京畅享互联有限公司
 * @Copyright: Copyright (c) 2012
 * @Author： 杨其桔
 * 创建时间：2013-12-4 上午10:33:56   
 * 修改备注：   
 * @version    
 *    
 */
public interface ParaPropertiesMapper {

	@Select("select * from t_para_properties")
	public List<ParaProperties> selectAll();
	
	@Select("select * from t_para_properties where key = #{key}")
	public ParaProperties selectkeyByMapper(String key);
	
	@Select("select * from t_para_properties where key = #{key}")
	public ParaProperties selectInfoByBean(ParaProperties info);
	
	public ParaProperties selectByParm(@Param("key") String key);
	
	@Insert("insert into t_para_properties(key,value,des) values(#{key},#{value},#{des})")
	public void insert(ParaProperties info);
	
	@Select("select g.gamename from t_para_drawnumber d, t_para_gameinfo g where d.ltype = g.ltype and d.status = 3and d.period = 2012301")
	@Results(value={
			@Result(javaType=String.class,column="gamename"),
	})
	public String select2TableSingle();
	
	@Select("select g.gamename,g.ltype from t_para_drawnumber d, t_para_gameinfo g where d.ltype = g.ltype and d.status = 3and d.period = 2012301")
	@Results(value={
			@Result(javaType=String.class,column="gamename",property="name"),
			@Result(javaType=String.class,column="ltype",property="code")
	})
	public GameInfo select2TableBean();
	
	@Select("select g.gamename,g.ltype from t_para_drawnumber d, t_para_gameinfo g where d.ltype = g.ltype and d.status = 3and d.period = 2012301")
	@ResultMap("")//xml中配置
	public GameInfo select2TableMap();
}
