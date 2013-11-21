package com.joyveb.java7.io.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * 项目名称：MySpace 类名称：TCPServer
 * 
 * @Company: 北京畅享互联有限公司
 * @Copyright: Copyright (c) 2012
 * @Author： 杨其桔 创建时间：2013-10-12 上午10:15:31 修改备注：
 * @version
 * 
 */
public class TCPServer {

	public static void main(String[] args) {
		System.out.println("server start");
		try(ServerSocket ss = new ServerSocket(5555);
				Socket socket = ss.accept();
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				PrintWriter pw = new PrintWriter(bw, true);) {
			while (true) {
				String str = br.readLine();
				System.out.println("[client--server]:" + str);
				if ("stop".equals(str)) {
					break;
				}
				pw.println("server send message");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
