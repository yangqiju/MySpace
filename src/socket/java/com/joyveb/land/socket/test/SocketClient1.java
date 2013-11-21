package com.joyveb.land.socket.test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import com.joyveb.java7.aio.test.Send;

/**
 * 
 * 项目名称：MySpace 类名称：SocketClient1
 * 
 * @Company: 北京畅享互联有限公司
 * @Copyright: Copyright (c) 2012
 * @Author： 杨其桔 创建时间：2013-11-21 下午12:57:42 修改备注：
 * @version
 * 
 */
public class SocketClient1 {
	private static String MONI_HOST = "127.0.0.1";
	private static int MONI_PORT = 6202;
	public static void main(String[] args) throws UnknownHostException,
			IOException {
		for(int i=0;i<1000;i++){
			sendData();
		}
		System.out.println("end");
	}

	public static void sendData() throws UnknownHostException, IOException {
		Socket socket = null;
		OutputStream ous = null;
		InputStream ins = null;
		try {
			socket = new Socket(MONI_HOST, MONI_PORT);
			ous = socket.getOutputStream();
			ins = socket.getInputStream();
			ous.write("client send to server".getBytes());
			socket.shutdownOutput();
			ins.read();
			// System.out.println("[client]:"+str);
		} finally {
			if (ins != null) {
				ins.close();
			}
			if(ous!=null){
				ous.close();
			}
			if(socket!=null){
				socket.close();
			}
		}
	}
}
