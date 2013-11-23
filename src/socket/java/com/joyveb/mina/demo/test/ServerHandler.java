package com.joyveb.mina.demo.test;

import org.apache.log4j.Logger;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

/**
 * 
 * 项目名称：MySpace 类名称：ServerHandler
 * 
 * @Company: 北京畅享互联有限公司
 * @Copyright: Copyright (c) 2012
 * @Author： 杨其桔 创建时间：2013-11-23 下午3:50:05 修改备注：
 * @version
 * 
 */
public class ServerHandler extends IoHandlerAdapter {

	
	@Override
	public void exceptionCaught(IoSession session, Throwable cause)
			throws Exception {
		System.out.println("服务器异常:"+cause.getMessage());
	}
	
	@Override
	public void sessionCreated(IoSession session) throws Exception {
		System.out.println("创建了一个新的连接:"+session.getRemoteAddress());
	}
	
	@Override
	public void sessionClosed(IoSession session) throws Exception {
		System.out.println("连接被关闭："+session.getRemoteAddress());
	}
	@Override
	public void messageReceived(IoSession session, Object message)
			throws Exception {
		String msg = message.toString();
		System.out.println("[server收到请求]:"+msg);
		session.write("服务器收到了你的请求["+msg+"]");
	}
	
	@Override
	public void sessionIdle(IoSession session, IdleStatus status)
			throws Exception {
//		System.out.println("session status:"+session.getIdleCount(status));
	}
	
}
