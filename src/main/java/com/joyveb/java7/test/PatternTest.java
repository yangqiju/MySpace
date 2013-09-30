package com.joyveb.java7.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**   
 *    
 * 项目名称：MySpace   
 * 类名称：PatternTest   
 * @Company: 北京畅享互联有限公司
 * @Copyright: Copyright (c) 2012
 * @Author： 杨其桔
 * 创建时间：2013-9-30 下午2:09:39   
 * 修改备注：   
 * @version    
 *    
 */
public class PatternTest {

	public static void main(String[] args) {
//		namedCapturingGroup();
		repeatPatter();
	}
	
	private static void namedCapturingGroup(){
		String url = "http://www.example.org/uid/alex/docid/1/title/myfirstbolg";
		Pattern pattern = Pattern.compile("^.*/uid/(?<uid>.*)/docid/(?<docid>.*)/title/(?<title>.*)");
		Matcher matcher = pattern.matcher(url);
		if(matcher.matches()){
			String uid = matcher.group("uid");
			System.out.println(uid);
			String docid = matcher.group("docid");
			System.out.println(docid);
			String title = matcher.group("title");
			System.out.println(title);
		}
	}
	
	private static void repeatPatter(){
		String str = "123-456-789-012-456-456";
		Pattern pattern = Pattern.compile("(?<num>\\d+)-\\k<num>");
		Matcher matcher = pattern.matcher(str);
		while(matcher.find()){
			String repeat = matcher.group("num");
			System.out.println(repeat);
		}
	}
}
