package com.joyveb.java7.nio.test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Send {

	private String ENCODING_UTF8 = "utf-8";
	private ByteBuffer buffer = ByteBuffer.allocate(1024);
	private CharsetEncoder encoder = Charset.forName(ENCODING_UTF8)
			.newEncoder();
	private String server = "JV-PC";
	private Integer port = 8888;
	private SocketChannel channel;
	private Selector selector;

	private void init() throws IOException, ClosedChannelException {
		selector = Selector.open();
		channel = SocketChannel.open();
		channel.configureBlocking(false);
//		channel.register(selector, SelectionKey.OP_CONNECT
//				| SelectionKey.OP_WRITE | SelectionKey.OP_READ);
		channel.register(selector, SelectionKey.OP_CONNECT);
	}

	public void connect() throws IOException {
		channel.connect(new InetSocketAddress(server, port));
		int size = 0;
		while ((size = selector.select()) > 0) {
			System.out.println("select size :"+size);
//			try {
//				TimeUnit.SECONDS.sleep(1);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			Set<SelectionKey> readyKeys = selector.selectedKeys();
			Iterator<SelectionKey> it = readyKeys.iterator();
			while (it.hasNext()) {
				SelectionKey key = it.next();
				if (key.isConnectable()) {
					if (channel.isConnectionPending()) {
						channel.finishConnect();
					}
					onSend(key);
					System.out.println("send1");
				} else if (key.isReadable()) {
					onReceive(key);
				} else if (key.isWritable()) {
					onSend(key);
					System.out.println("send2");
				}
				it.remove();
			}
		}
	}

	private void onReceive(SelectionKey key) throws IOException {
		SocketChannel sc = (SocketChannel) key.channel();
		sc.read(buffer);
		buffer.flip();
		String mess = new String(buffer.array(), 0, buffer.limit());
		System.out.println("[client]"+mess);
//		sc.register(selector, SelectionKey.OP_WRITE);
		if("end".equals(mess)){
			sc.write(encoder.encode(CharBuffer.wrap("")));
		}
	}

	private void onSend(SelectionKey key) throws IOException {
		SocketChannel sc = (SocketChannel) key.channel();
		sc.write(encoder.encode(CharBuffer.wrap("send to server.")));
		sc.register(selector, SelectionKey.OP_READ);
	}

	public static void main(String[] args) throws Exception {
		Send del = new Send();
		del.init();
		del.connect();
	}
}