package com.joyveb.deque.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**   
 *    
 * 项目名称：MySpace   
 * 类名称：URLTest   
 * @Company: 北京畅享互联有限公司
 * @Copyright: Copyright (c) 2012
 * @Author： 杨其桔
 * 创建时间：2013-11-22 下午1:34:29   
 * 修改备注：   
 * @version    
 *    
 */
public class URLTest {

	private static String address = "http://serverip:port/TvTest/Lotsubmit?";
	private static String separate = "&&";
	
	public static void main(String[] args) {
		try {
			String mess = sendMessage();
			System.out.println(mess);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static String getUrl(){
		Map<String,String> config = new HashMap<String,String>();
		config.put("userid", "");
		config.put("Dealid", "");
		config.put("Lottype", "");
		config.put("Lotqh", "");
		config.put("Lotnum", "");
		config.put("Lotbs", "");
		config.put("Tzfs", "");
		config.put("Tzje", "");
		config.put("Tvmac", "");
		config.put("Mac", "");
		StringBuffer sb = new StringBuffer();
		for(Entry<String,String> entry : config.entrySet()){
			sb.append(entry.getKey()).append("=").append(entry.getValue()).append(separate);
		}
		return address+sb.toString();
	}
	
	private static String sendMessage() throws IOException{
		URL url = new URL(getUrl());
		HttpURLConnection connection = (HttpURLConnection )url.openConnection();
		connection.setDoOutput(false);
		connection.setDoInput(true);
		connection.setRequestMethod("GET");
		connection.setUseCaches(false);
		connection.setReadTimeout(50000);
		connection.setRequestProperty("content-type", "text/html");
//		connection.setRequestProperty("content-type", "text/xml;charset=utf-8");
		connection.setRequestProperty("SOAPAction", "\"\"");
		connection.setRequestProperty("Cache-Control", "no-cache");
		connection.setRequestProperty("Accept","application/soap+xml, application/dime, multipart/related, text/*");
		connection.connect();
//		DataOutputStream out = new DataOutputStream(connection.getOutputStream());
////		out.writeBytes(content);
//		out.write(content.getBytes("utf-8"));
//		out.flush();
		StringBuilder result = new StringBuilder("");
		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String line = null;
		while((line = reader.readLine()) != null) {
			result.append(line);
		}
		reader.close();
//		out.close();
		connection.disconnect();
		return new String(result.toString().getBytes("gb2312"));
	}
	
}
