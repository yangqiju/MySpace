package com.joyveb.java7.aio.test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**   
 *    
 * 项目名称：MySpace   
 * 类名称：Receive   
 * @Company: 北京畅享互联有限公司
 * @Copyright: Copyright (c) 2012
 * @Author： 杨其桔
 * 创建时间：2013-10-10 下午4:13:08   
 * 修改备注：   
 * @version    
 *    
 */
public class Receive {
	
	public static void main(String[] args) {
		server1();
	}
	
	/**
	 * Using the Future object in a server
	 */
	public static void server2() {
		try {
			final AsynchronousServerSocketChannel listener = AsynchronousServerSocketChannel
					.open();
			InetSocketAddress address = new InetSocketAddress("localhost", 5000);
			listener.bind(address);
			Future<AsynchronousSocketChannel> future = listener.accept();
			System.out.println("Receive:future.get()");
			AsynchronousSocketChannel worker = future.get();
			while (true) {
				// Wait
//				System.out.println("Server: Receiving ...");
				ByteBuffer buffer = ByteBuffer.allocate(32);
				System.out.println("Receive:worker.read()");
				Future<Integer> readFuture = worker.read(buffer);
				System.out.println("Receive:readFuture.get()");
				Integer number = readFuture.get();
				System.out.println("Server: Message received: "
						+ new String(buffer.array()));
			}
		} catch (IOException | InterruptedException | ExecutionException ex) {
			ex.printStackTrace();
		}
	}

	public static void server1() {
		try {
			final AsynchronousServerSocketChannel listener = AsynchronousServerSocketChannel
					.open();
			InetSocketAddress address = new InetSocketAddress("localhost", 5000);
			listener.bind(address);
			listener.accept(null,
					new CompletionHandler<AsynchronousSocketChannel, Void>() {
						@Override
						public void completed( AsynchronousSocketChannel channel, Void attribute) {
							try {
								System.out .println("Server: completed method executing");
								while (true) {
									ByteBuffer buffer = ByteBuffer.allocate(1024);
									Future<Integer> readFuture = channel.read(buffer);
									Integer number = readFuture.get();
									System.out.println("Server: Message received: "+ new String(buffer.array()));
									buffer.flip();
									
									channel.write(ByteBuffer.wrap("Server:abc".getBytes()));
								}
							} catch (InterruptedException | ExecutionException ex) {
								ex.printStackTrace();
							}
						}

						@Override
						public void failed(Throwable exc, Void attachment) {
							System.out.println("Server: CompletionHandler exception");
							exc.printStackTrace();
						}
					});
			while (true) {
				// wait – Prevents the program from// terminating before the
				// client can connect
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
