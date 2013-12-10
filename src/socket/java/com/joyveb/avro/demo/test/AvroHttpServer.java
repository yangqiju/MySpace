package com.joyveb.avro.demo.test;

import java.io.File;

import org.apache.avro.Protocol;
import org.apache.avro.Protocol.Message;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.ipc.HttpServer;
import org.apache.avro.ipc.Server;
import org.apache.avro.ipc.generic.GenericResponder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * 
 * 项目名称：MySpace 类名称：AvroHttpServer
 * 
 * @Company: 北京畅享互联有限公司
 * @Copyright: Copyright (c) 2012
 * @Author： 杨其桔 创建时间：2013-12-10 上午10:25:42 修改备注：
 * @version
 * 
 */
public class AvroHttpServer extends GenericResponder {
	private static Log log = LogFactory.getLog(AvroHttpServer.class);

	public AvroHttpServer(Protocol protocol) {
		super(protocol);
	}

	public Object respond(Message message, Object request) throws Exception {
		GenericRecord req = (GenericRecord) request;
		GenericRecord reMessage = null;
		if (message.getName().equals("sayHello")) {
			Object name = req.get("name");
			// do something...
			// 取得返回值的类型
			reMessage = new GenericData.Record(super.getLocal().getType(
					"nameMessage"));
			// 直接构造回复
			reMessage.put("name", "Hello, " + name.toString());
			log.info(reMessage);
		}
		return reMessage;
	}

	public static void main(String[] args) throws Exception {
		int port = 8088;
		try {
			Server server = new HttpServer(new AvroHttpServer(
					Protocol.parse(new File("src/main/resources/helloword.json"))), port);
			server.start();
			server.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
