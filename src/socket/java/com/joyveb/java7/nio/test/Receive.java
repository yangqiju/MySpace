package com.joyveb.java7.nio.test;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Set;

public class Receive {
	public static void main(String[] args) throws Exception {
		CharsetEncoder encoder = Charset.forName("UTF-8").newEncoder();
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		ServerSocketChannel ss = ServerSocketChannel.open();
		ss.socket().bind(new InetSocketAddress("127.0.0.1",6202));
		ss.configureBlocking(false);
		Selector se = Selector.open();
		ss.register(se, SelectionKey.OP_ACCEPT);
		System.out.println("server start..");
		while (se.select() > 0) {//阻塞
			Set<SelectionKey> set = se.selectedKeys();
			for (SelectionKey key : set) {
				if (key.isAcceptable()) {
					ServerSocketChannel server = (ServerSocketChannel) key
							.channel();
					SocketChannel channel = server.accept();
					channel.configureBlocking(false);
					channel.register(se, SelectionKey.OP_READ);
				} else if (key.isReadable()) {
					SocketChannel sc = (SocketChannel) key.channel();
					sc.read(buffer);
					buffer.flip();
//					System.out.println("[server]"+ new String(buffer.array(), 0, buffer.limit()));
					sc.register(se, SelectionKey.OP_WRITE);
				} else if (key.isWritable()) {
					SocketChannel sc = (SocketChannel) key.channel();
					sc.write(encoder.encode(CharBuffer.wrap("send to client.")));
					sc.register(se, SelectionKey.OP_READ);
				}
			}
			set.clear();
		}
	}
}