package com.joyveb.java7.nio.test;

import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/**
 * 
 * 项目名称：MySpace 类名称：NBTimeServer
 * 
 * @Company: 北京畅享互联有限公司
 * @Copyright: Copyright (c) 2012
 * @Author： 杨其桔 创建时间：2013-10-14 下午5:56:14 修改备注：
 * @version
 * 
 */
public class NBTimeServer {
	private static final int DEFAULT_TIME_PORT = 8013;

	// Constructor with no arguments creates a time server on default port.
	public NBTimeServer() throws Exception {
		acceptConnections(this.DEFAULT_TIME_PORT);
	}

	// Constructor with port argument creates a time server on specified port.
	public NBTimeServer(int port) throws Exception {
		acceptConnections(port);
	}

	// Accept connections for current time. Lazy Exception thrown.
	private static void acceptConnections(int port) throws Exception {
		// Selector for incoming time requests
		Selector acceptSelector = SelectorProvider.provider().openSelector();

		// Create a new server socket and set to non blocking mode
		ServerSocketChannel ssc = ServerSocketChannel.open();
		ssc.configureBlocking(false);

		// Bind the server socket to the local host and port

		InetAddress lh = InetAddress.getLocalHost();
		InetSocketAddress isa = new InetSocketAddress(lh, port);
		ssc.socket().bind(isa);

		// Register accepts on the server socket with the selector. This
		// step tells the selector that the socket wants to be put on the
		// ready list when accept operations occur, so allowing multiplexed
		// non-blocking I/O to take place.
		SelectionKey acceptKey = ssc.register(acceptSelector,
				SelectionKey.OP_ACCEPT);

		int keysAdded = 0;

		// Here's where everything happens. The select method will
		// return when any operations registered above have occurred, the
		// thread has been interrupted, etc.
		CharsetEncoder encoder = Charset.forName("UTF-8").newEncoder();
		while ((keysAdded = acceptSelector.select()) > 0) {
			// Someone is ready for I/O, get the ready keys
			Set readyKeys = acceptSelector.selectedKeys();
			Iterator i = readyKeys.iterator();

			// Walk through the ready keys collection and process date requests.
			while (i.hasNext()) {
				SelectionKey sk = (SelectionKey) i.next();
				i.remove();
				// The key indexes into the selector so you
				// can retrieve the socket that's ready for I/O
//				ServerSocketChannel nextReady = (ServerSocketChannel) sk
//						.channel();
				// Accept the date request and send back the date string
//				Socket s = nextReady.accept().socket();
				// Write the current time to the socket
//				PrintWriter out = new PrintWriter(s.getOutputStream(), true);
//				Date now = new Date();
//				out.println(now);
//				out.close();
				 
				if(sk.isAcceptable()){
					ServerSocketChannel server = (ServerSocketChannel) sk
							.channel();
					SocketChannel channel = server.accept();
					channel.configureBlocking(false);
					channel.register(acceptSelector, SelectionKey.OP_WRITE);
					System.out.println("accept");
				}else if(sk.isWritable()){
					SocketChannel sc = (SocketChannel) sk.channel();
					sc.write(encoder.encode(CharBuffer.wrap("send to client")));
					System.out.println("write");
				}
			}
		}
	}
	// Entry point.
	public static void main(String[] args) {
		// Parse command line arguments and
		// create a new time server (no arguments yet)
		try {
			NBTimeServer nbt = new NBTimeServer();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
