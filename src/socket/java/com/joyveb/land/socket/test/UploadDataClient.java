package com.joyveb.land.socket.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

/**
 * @Title: Joyveb上传数据客户端
 * @Author: 李明建
 */
//@Slf4j
//@Component("uploadDataClient")
public class UploadDataClient {

	/**
	 * 给合并通讯机发送数据
	 * 添加synchronized 避免一个终端同时做多件事情
	 */
	public String sendData(int randInt, int command, String data,String host,int port)
			throws IOException, InterruptedException {
		/** 上传数据命令完成后返回来的明文数据 */
		String returnData = null;
		byte[] msg = chooseMessage(command, randInt, data);
		long start = System.currentTimeMillis();
		Socket socket = null;
		OutputStream ous = null;
		InputStream ins = null;
		try {
//			log.info("centerhost:"+host + "port:" + port);
			socket = new Socket(host , port);
			ous = socket.getOutputStream();
			ins = socket.getInputStream();
			ous.write(msg);
			// 接收服务器的回应
			returnData = waitResponse(ins);
			long end = System.currentTimeMillis();
//			log.info("思乐响应明文:"+returnData);
//			log.info("SILE COST TIME[" + (end - start) + "]ms.");
			return returnData;
		} finally {
			if (ins != null)
				ins.close();
			if (ous != null)
				ous.close();
			if (socket != null) {
				socket.close();
			}
		}
	}

	/**
	 * 处理上传数据命令后合并通讯机返回
	 * @throws IOException 
	 */
	public String waitResponse(InputStream ins) throws IOException {
		// 所有响应数据包大小固定为40字节
		byte[] bytes = new byte[Constants.RETURN_DATA_LENGTH];
		ins.read(bytes);
		return new String(EnDeUtil.decrypt(bytes));
	}

	public byte[] chooseMessage(int command, int randInt, String data)
			throws UnsupportedEncodingException {
		StringBuffer mingwen = new StringBuffer();
		switch (command) {
		case 0:// 销售数据
			mingwen.append(Constants.LOTTERY_TICKET).append(Constants.TAB);
			mingwen.append(randInt).append(Constants.TAB);
			mingwen.append(data.length()).append(Constants.TAB);
			mingwen.append(data).append(Constants.TAB);
			break;
		case 1:// 注销销售数据
			mingwen.append(Constants.LOTTERY_TICKET).append(Constants.TAB);
			mingwen.append(randInt).append(Constants.TAB);
			mingwen.append(data.length()).append(Constants.TAB);
			mingwen.append(data).append(Constants.TAB);
			break;
		case 2:// 兑奖数据
			mingwen.append(Constants.LOTTERY_SERVICEENCASH).append(
					Constants.TAB);
			mingwen.append(randInt).append(Constants.TAB);
			mingwen.append(data.length()).append(Constants.TAB);
			mingwen.append(data).append(Constants.TAB);
			break;
		case 3:// 获取帐户金额数据
			mingwen.append(Constants.LOTTERY_QUERYMONEY).append(Constants.TAB);
			mingwen.append(randInt).append(Constants.TAB);
			mingwen.append(data).append(Constants.TAB); // 逻辑机号
			break;
		case 4:// 获取思乐销售系统时间命令
			mingwen.append(Constants.LOTTERY_DATETIME).append(Constants.TAB);
			mingwen.append(randInt).append(Constants.TAB);
			break;
		default:
			break;
		}
//		log.info("发送明文：" + mingwen.toString());
		return EnDeUtil.encrypt(PadUtil.padSendDataPackage(mingwen,
				Constants.UPLOAD_DATA_LENGTH).getBytes(Constants.CHARSET));
	}

	public static void main(String[] args) throws Exception {
//		UploadDataClient client = new UploadDataClient();
//		int randInt = PadUtil.randomInt();
//		String returnData = client.sendData(0, randInt, "","192.168.3.1",8080);
//		log.info("返回数据：" + returnData);
		System.out.println("abc");
	}
}
