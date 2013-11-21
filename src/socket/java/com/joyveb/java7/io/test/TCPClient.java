package com.joyveb.java7.io.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 
 * 项目名称：MySpace 类名称：TCPClient
 * 
 * @Company: 北京畅享互联有限公司
 * @Copyright: Copyright (c) 2012
 * @Author： 杨其桔 创建时间：2013-10-12 上午10:42:11 修改备注：
 * @version
 * 
 */
public class TCPClient {

	public static void main(String[] args) {
		System.out.println("client start");
		InetAddress address = null;
		try {
			address = InetAddress.getByName("localhost");
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		}
		try(Socket socket = new Socket(address, 8013);
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				PrintWriter pw = new PrintWriter(bw,true);){
			pw.println("client send message");
			
			String str =br.readLine();
			System.out.println("[server-client]:"+str);
			pw.println("stop");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
