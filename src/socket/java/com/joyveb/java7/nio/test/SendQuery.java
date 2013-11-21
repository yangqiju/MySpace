package com.joyveb.java7.nio.test;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

/**
 * 
 * 项目名称：MySpace 类名称：TimeQuery
 * 
 * @Company: 北京畅享互联有限公司
 * @Copyright: Copyright (c) 2012
 * @Author： 杨其桔 创建时间：2013-10-14 下午5:39:43 修改备注：
 * @version
 * 
 */
public class SendQuery {

	// The standard daytime port
	private static int DAYTIME_PORT = 8888;

	// The port we'll actually use
	private static int port = DAYTIME_PORT;

	private static Charset charset = Charset.forName("US-ASCII");
	private static CharsetDecoder decoder = charset.newDecoder();
	private static CharsetEncoder encoder = charset.newEncoder();
	private static ByteBuffer dbuf = ByteBuffer.allocateDirect(1024);

	private static void query(String name) throws IOException {
		InetSocketAddress isa = new InetSocketAddress(
				InetAddress.getByName("JV-PC"), port);
		SocketChannel sc = null;
		try {
			sc = SocketChannel.open();
			sc.connect(isa);
			sc.write(encoder.encode(CharBuffer.wrap(name)));
			ByteBuffer buffer = ByteBuffer.allocate(1024);  
	        ByteArrayOutputStream baos = new ByteArrayOutputStream();  
	        int size = 0;  
	        byte [] bytes = null;  
	        while((size = sc.read(buffer))>=0){  
	            buffer.flip();  
	            bytes = new byte[size];  
	            buffer.get(bytes);  
	            baos.write(bytes);  
	            buffer.clear();  
	        }  
	        bytes = baos.toByteArray();  
	        baos.close();
	        System.out.println(new String(bytes));
		} finally {
			// Make sure we close the channel (and hence the socket)
			if (sc != null)
				sc.close();
		}
	}
	
	public static  void query2(String name) throws IOException{
		Socket socket = null;
		OutputStream ous = null;
		InputStream ins = null;
		try{
			socket = new Socket("localhost", 6202);
			ous = socket.getOutputStream();
			ins = socket.getInputStream();
			ous.write(name.getBytes());
			byte[] bytes = new byte[10];
			ByteArrayOutputStream bout = new ByteArrayOutputStream();
			int size=0;
			while((size=ins.read(bytes))==bytes.length){
				bout.write(bytes,0,size);
			}
			bout.write(bytes,0,size);
			String result = new String(bout.toByteArray());
			System.out.println(result+"---"+name);
			bout.close();
		} finally{
			if (ins != null)
				ins.close();
			if (ous != null)
				ous.close();
			if (socket != null) {
				socket.close();
			}
		}
	}
	
	static class  QueryThread extends Thread{
		private String name;
		public QueryThread(String name) {
			this.name = name;
		}
		@Override
		public void run() {
//			System.out.println(name+"---starttime:"+System.currentTimeMillis());
			try {
				query2(name);
//				System.out.println(name+"---endtime:"+System.currentTimeMillis());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}

	public static void main(String[] args) {
		int size = 100;
		for(int i=0;i<size;i++){
			new QueryThread("queryThread"+i).start();
		}
	}
}
