package com.joyveb.mina.demo.test;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

/**   
 *    
 * 项目名称：MySpace   
 * 类名称：MinaClient   
 * @Company: 北京畅享互联有限公司
 * @Copyright: Copyright (c) 2012
 * @Author： 杨其桔
 * 创建时间：2013-11-23 下午4:19:24   
 * 修改备注：   
 * @version    
 *    
 */
public class MinaClient {

	public static void main(String[] args) {
		NioSocketConnector connector = new NioSocketConnector();
		connector.getFilterChain().addLast("codecFilter", new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"))));
		connector.setHandler(new ClientHandler());
		connector.setConnectTimeoutCheckInterval(10000);
		ConnectFuture future =  connector.connect(new InetSocketAddress(9123));
		future.awaitUninterruptibly();
		future.getSession().getCloseFuture().awaitUninterruptibly();
		connector.dispose();
	}
}
