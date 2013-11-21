package com.joyveb.java7.aio.test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * 
 * 项目名称：MySpace 类名称：Send
 * 
 * @Company: 北京畅享互联有限公司
 * @Copyright: Copyright (c) 2012
 * @Author： 杨其桔 创建时间：2013-10-10 下午4:13:59 修改备注：
 * @version
 * 
 */
public class Send {

	public static void main(String[] args) {
		client2();
	}

	public static void client1() {
		try {
			AsynchronousSocketChannel client = AsynchronousSocketChannel.open();
			InetSocketAddress address = new InetSocketAddress("localhost", 5000);
			Future<Void> future = client.connect(address);
			// System.out.println("Client: Waiting for the connection to complete");
			System.out.println("Send:future.get()");
			future.get();
			String message;
			do {
				System.out.print("Enter a message: ");
				Scanner scanner = new Scanner(System.in);
				message = scanner.nextLine();
				System.out.println("Client: Sending ...");
				ByteBuffer buffer = ByteBuffer.wrap(message.getBytes());
				System.out.println("Client: Message sent: "
						+ new String(buffer.array()));
				client.write(buffer).get();
				buffer.flip();

				ByteBuffer buffer2 = ByteBuffer.allocate(32);
				Future<Integer> readFuture = client.read(buffer2);
				readFuture.get();
				System.out.println("[clent]:"
						+ new String(buffer2.array(), 0, buffer2.limit()));
			} while (!"quit".equals(message));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void client2() {
		try {
			final AsynchronousSocketChannel client = AsynchronousSocketChannel.open();
			InetSocketAddress address = new InetSocketAddress("localhost", 5000);
			client.connect(address, null, new CompletionHandler<Void, Void>() {
				@Override
				public void completed(Void result, Void attachment) {
					try {
						client.write(ByteBuffer.wrap("client2".getBytes())).get();
					} catch (InterruptedException e) {
						e.printStackTrace();
					} catch (ExecutionException e) {
						e.printStackTrace();
					}
				}
				@Override
				public void failed(Throwable exc, Void attachment) {
					exc.printStackTrace();
				}
			});
			final ByteBuffer buffer = ByteBuffer.allocate(1024);
			client.read(buffer, null, new CompletionHandler<Integer, Object>() {
				@Override
				public void completed(Integer result, Object attachment) {
					  System.out.println(new String(buffer.array()));  
				}
				@Override
				public void failed(Throwable exc, Object attachment) {
					exc.printStackTrace();
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		 try {  
	            Thread.sleep(Integer.MAX_VALUE);  
	        } catch (InterruptedException ex) {  
	            System.out.println(ex);  
	        }  
	}
}
