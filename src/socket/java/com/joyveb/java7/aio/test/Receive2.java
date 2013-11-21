package com.joyveb.java7.aio.test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**   
 *    
 * 项目名称：MySpace   
 * 类名称：Receive2   
 * @Company: 北京畅享互联有限公司
 * @Copyright: Copyright (c) 2012
 * @Author： 杨其桔
 * 创建时间：2013-10-14 下午6:33:39   
 * 修改备注：   
 * @version    
 *    
 */
public class Receive2 {

	public static void main(String[] args) {
		server();
	}

	private static void server() {
		try {
			AsynchronousServerSocketChannel assc = AsynchronousServerSocketChannel.open();
			InetSocketAddress address = new InetSocketAddress("localhost", 8888);
			assc.bind(address);
			Future<AsynchronousSocketChannel> future = assc.accept();
			AsynchronousSocketChannel worker = future.get();
			while(true){
				ByteBuffer buffer = ByteBuffer.allocate(32);
				worker.read(buffer);
				System.out.println("Server:"+new String(buffer.array()));
			}
		} catch (IOException | InterruptedException | ExecutionException ex) {
			ex.printStackTrace();
		}
	}
}
