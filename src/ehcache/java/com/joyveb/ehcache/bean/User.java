package com.joyveb.ehcache.bean;

import java.io.Serializable;

import lombok.Data;

/**
 * 
 * 项目名称：MySpace 类名称：User
 * 
 * @Company: 北京畅享互联有限公司
 * @Copyright: Copyright (c) 2012
 * @Author： 杨其桔 创建时间：2013-9-6 下午2:21:08 修改备注：
 * @version
 * 
 */
@Data
public class User implements Serializable {
	private static final long serialVersionUID = -5055331161538623241L;
	private String id;
	private String name;
	private Integer age;
}
