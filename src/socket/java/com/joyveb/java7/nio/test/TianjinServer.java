package com.joyveb.java7.nio.test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/**   
 *    
 * 项目名称：MySpace   
 * 类名称：TianjinServer   
 * @Company: 北京畅享互联有限公司
 * @Copyright: Copyright (c) 2012
 * @Author： 杨其桔
 * 创建时间：2013-11-20 下午4:40:33   
 * 修改备注：   
 * @version    
 *    
 */
public class TianjinServer {

	private Selector selector;
	private ServerSocketChannel ssc;
	private Charset charset = Charset.forName("UTF-8");
	private CharsetEncoder encoder = charset.newEncoder();
	private CharsetDecoder decoder = charset.newDecoder();
	private AtomicBoolean stop = new AtomicBoolean(false);
	public static void main(String[] args) {
		TianjinServer server = new TianjinServer();
		System.out.println("start");
		server.start();
		System.out.println("end");
	}

	private void start(){
		try {
			selector = Selector.open();
			ssc = ServerSocketChannel.open();
			ssc.socket().bind(new InetSocketAddress(8888));
			ssc.configureBlocking(false);
			ssc.register(selector, SelectionKey.OP_ACCEPT);
			while(!stop.get()){
				selector.select();
				Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
				while(iterator.hasNext()&&!stop.get()){
					SelectionKey selectionKey = iterator.next();
					iterator.remove();
					handleSelectionKey(selectionKey);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void handleSelectionKey(SelectionKey selectionKey) throws IOException {
		if(selectionKey.isAcceptable()){
			ServerSocketChannel ssc = (ServerSocketChannel)selectionKey.channel();
			SocketChannel sc = ssc.accept();
			sc.configureBlocking(false);
			sc.register(selector, SelectionKey.OP_READ);
		}else if(selectionKey.isReadable()){
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			SocketChannel sc = (SocketChannel) selectionKey.channel();
			int len = sc.read(buffer);
			if(len>0){
				buffer.flip();
				// 根据客户端请求的消息，查找到对应的输出
				byte [] inputBytes=new byte[len];
				for(int i=0;i<len;i++){
					inputBytes[i]=buffer.get(i);
				}
				String inputStr = new String(inputBytes);
				System.out.println("[server]"+inputStr);
				sc.write(encoder.encode(CharBuffer.wrap(inputStr)));
			}else{
				System.out.println("len:"+len+"----------close-------");
				sc.close();
			}
		}
	}
}
