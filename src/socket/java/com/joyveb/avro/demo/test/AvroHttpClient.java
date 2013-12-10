package com.joyveb.avro.demo.test;

import java.io.File;
import java.net.URL;

import org.apache.avro.Protocol;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.ipc.HttpTransceiver;
import org.apache.avro.ipc.Transceiver;
import org.apache.avro.ipc.generic.GenericRequestor;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * 项目名称：MySpace 类名称：AvroHttpClient
 * 
 * @Company: 北京畅享互联有限公司
 * @Copyright: Copyright (c) 2012
 * @Author： 杨其桔 创建时间：2013-12-10 上午10:36:24 修改备注：
 * @version
 * 
 */
public class AvroHttpClient {
	private Protocol protocol;

	private GenericRequestor requestor = null;

	@Before
	public void setUp() throws Exception {
		protocol = Protocol
				.parse(new File("src/main/resources/helloword.json"));
		Transceiver t = new HttpTransceiver(new URL("http://localhost:8088"));
		requestor = new GenericRequestor(protocol, t);
	}

	@Test
	public void testSendMessage() throws Exception {
		GenericRecord requestData = new GenericData.Record(
				protocol.getType("nameMessage"));
		// initiate the request data
		requestData.put("name", "zhenqin");

		System.out.println(requestData);
		Object result = requestor.request("sayHello", requestData);
		if (result instanceof GenericData.Record) {
			GenericData.Record record = (GenericData.Record) result;
			System.out.println(record.get("name"));
		}
		System.out.println(result);
	}
}
