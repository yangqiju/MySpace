package com.joyveb.mina.demo.test;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

/**   
 *    
 * 项目名称：MySpace   
 * 类名称：ClientHandler   
 * @Company: 北京畅享互联有限公司
 * @Copyright: Copyright (c) 2012
 * @Author： 杨其桔
 * 创建时间：2013-11-23 下午4:26:24   
 * 修改备注：   
 * @version    
 *    
 */
public class ClientHandler extends IoHandlerAdapter {

	@Override
	public void messageReceived(IoSession session, Object message)
			throws Exception {
		System.out.println("[client收到请求]"+message.toString());
		session.close();
	}
	
	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
		System.out.println("messageSent??????");
	}
	
	@Override
	public void sessionClosed(IoSession session) throws Exception {
		System.out.println("[client关闭]");
	}
	
	@Override
	public void sessionCreated(IoSession session) throws Exception {
		System.out.println("[client连接成功,发送消息]");
		String msg = "你好...";
		session.write(msg);
	}
	
}
