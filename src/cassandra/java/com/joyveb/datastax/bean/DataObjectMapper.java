package com.joyveb.datastax.bean;

import com.datastax.driver.core.DataType;
import com.datastax.driver.core.Row;

/**   
 *    
 * 项目名称：MySpace   
 * 类名称：DataObjectMapper   
 * @Company: 北京畅享互联有限公司
 * @Copyright: Copyright (c) 2012
 * @Author： 杨其桔
 * 创建时间：2013-10-31 上午11:36:36   
 * 修改备注：   
 * @version    
 *    
 */
public class DataObjectMapper {
	 public static Object getValue(Row row, String name, DataType type) {
	        switch (type.getName()) {
	            case ASCII:
	                return row.getString(name);
	            case BIGINT:
	                return row.getLong(name);
	            case BLOB:
	                return row.getBytes(name);
	            case BOOLEAN:
	                return row.getBool(name);
	            case COUNTER:
	                return row.getLong(name);
	            case DECIMAL:
	                return row.getDecimal(name);
	            case DOUBLE:
	                return row.getDouble(name);
	            case FLOAT:
	                return row.getFloat(name);
	            case INET:
	                return row.getInet(name);
	            case INT:
	                return row.getInt(name);
	            case TEXT:
	                return row.getString(name);
	            case TIMESTAMP:
	                return row.getDate(name);
	            case UUID:
	                return row.getUUID(name);
	            case VARCHAR:
	                return row.getString(name);
	            case VARINT:
	                return row.getVarint(name);
	            case TIMEUUID:
	                return row.getUUID(name);
	            case LIST:
	                return row.getList(name, type.getTypeArguments().get(0).asJavaClass());
	            case SET:
	                return row.getSet(name, type.getTypeArguments().get(0).asJavaClass());
	            case MAP:
	                return row.getMap(name, type.getTypeArguments().get(0).asJavaClass(), type.getTypeArguments().get(1).asJavaClass());
	        }
	        throw new RuntimeException("Missing handling of " + type);
	    }
}
