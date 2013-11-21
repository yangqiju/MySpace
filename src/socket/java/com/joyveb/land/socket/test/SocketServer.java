package com.joyveb.land.socket.test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**   
 * @Title: SocketServer.java 
 * @Package com.joyveb.nio.socket.test 
 * @author ������
 * @date 2013-11-20 ����10:49:12 
 * @version V1.0   
 */
public class SocketServer {

	public  void start(){
		Selector selector = null;
		ServerSocketChannel serverSocketChannel = null;
		try{
			selector = Selector.open();
			serverSocketChannel = ServerSocketChannel.open();
			serverSocketChannel.configureBlocking(false);
			serverSocketChannel.socket().bind(new InetSocketAddress("127.0.0.1",6202));
			serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
			while(selector.select()>0){
				Iterator<SelectionKey> it = selector.selectedKeys().iterator();
				while(it.hasNext()){
				SelectionKey key = 	it.next();
				it.remove();
				execute((ServerSocketChannel) key.channel());
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	private static void execute(ServerSocketChannel channel) throws IOException {
		SocketChannel socketChannel = null;
		try{
			socketChannel = channel.accept();
			String request =receiveData(socketChannel);
//			System.out.println("[server]:"+request);
			sendData(socketChannel,request);
		}finally{
			socketChannel.close();
		}
	}
	
	
	private static void sendData(SocketChannel socketChannel, String request) throws IOException {
		socketChannel.write(ByteBuffer.wrap("server send to client message".getBytes()));
	}
	
	
	private static String receiveData(SocketChannel socketChannel) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try{
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			byte[] bytes;
			int size = 0;
			while((size=socketChannel.read(buffer))>=0){
				buffer.flip();
				bytes = new byte[size];
				buffer.get(bytes);
				baos.write(bytes);
				buffer.clear();
			}
		}finally{
			baos.close();
		}
		return new String(baos.toByteArray());
	}
	
	public static void main(String[] args) {
		SocketServer server = new SocketServer();
		System.out.println("server start..");
		server.start();
	}
}

