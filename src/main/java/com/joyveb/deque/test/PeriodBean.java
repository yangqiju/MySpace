package com.joyveb.deque.test;

import lombok.Data;

/**
 * @Date: 2011-12-27
 * @Title: 期信息Bean
 * @Copyright: Copyright (c) 2011
 * @Company: 北京畅享互联科技有限公司
 * @Author: 李明建
 * @version: 1.0
 */
public @Data class PeriodBean {
	/**
	 * 游戏编号
	 */
	private String ltype;
	/**
	 * 期号
	 */
	private String period;
}
