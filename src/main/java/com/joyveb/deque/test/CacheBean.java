package com.joyveb.deque.test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 
 * 项目名称：MySpace 类名称：CacheBean
 * 
 * @Company: 北京畅享互联有限公司
 * @Copyright: Copyright (c) 2012
 * @Author： 杨其桔 创建时间：2013-11-21 下午4:16:48 修改备注：
 * @version
 * 
 */
public class CacheBean {

	public static Map<String, LinkedBlockingDeque<PeriodBean>> ENCASH_DEQUE = new ConcurrentHashMap<String, LinkedBlockingDeque<PeriodBean>>();
}
