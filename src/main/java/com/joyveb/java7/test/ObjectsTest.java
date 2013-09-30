package com.joyveb.java7.test;

import java.util.Objects;

/**   
 *    
 * 项目名称：MySpace   
 * 类名称：ObjectsTest   
 * @Company: 北京畅享互联有限公司
 * @Copyright: Copyright (c) 2012
 * @Author： 杨其桔
 * 创建时间：2013-9-30 上午11:40:06   
 * 修改备注：   
 * @version    
 *    
 */
public class ObjectsTest {

	public static void main(String[] args) {
		System.out.println(Objects.equals(new Object(), new Object()));
		Object[] array1 = new Object[]{"hello",1,1.5};
		Object[] array2 = new Object[]{"hello",1,1.0};
		System.out.println(Objects.equals(array1, array2));
		System.out.println(Objects.deepEquals(array1, array2));
		
		String str2 = Objects.toString(null, "");
	}
}
