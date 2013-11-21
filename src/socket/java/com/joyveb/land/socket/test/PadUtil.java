package com.joyveb.land.socket.test;

import java.util.Random;


/**
 * @Date: 2011-10-28
 * @Title: 填充字符工具类
 * @Copyright: Copyright (c) 2011
 * @Company: 北京畅享互联科技有限公司
 * @Author: 李明建
 * @version: 1.0
 */
public class PadUtil {

	/**
	 * 所有上传通讯数据包大小固定为400字节，返回给合并通讯及的数据大小固定为40字节
	 * 当上传通讯数据包和返回数据包实际内容小于固定长度则以’\0’(ascii 0)补足长度
	 * 
	 * @param data
	 *            数据包
	 * @param length
	 *            要拼成的字符串长度
	 * @return
	 */
	public static String padSendDataPackage(StringBuffer data, int length) {
		if (data != null) {
			if (data.length() < length) {
				for (int i = data.length(); i < length; i++) {
					data.append(Constants.ASCII0);
				}
			}
		}else{
			data=new StringBuffer();
			for (int i = 0; i < length; i++) {
				data.append(Constants.ASCII0);
			}
		}
		return data.toString();
	}

	/**
	 * 长整型（4字节）随机码范围为100000—999999
	 * @return
	 */
	public static int randomInt() {
		Random rand = new Random();
		return rand.nextInt(899999) + 100000;
	}

	/**
	 * 组装合并通讯机下传数据文件名
	 * 文件命名规则：encashdata_城市代号_玩法英文名称_期号.ffl(期号为七位)
	 * @param head
	 *            ：文件头
	 * @param cityCode
	 *            ：城市代码
	 * @param playName
	 *            ：玩法英文名称
	 * @param termCode
	 *            ：期号
	 * @return
	 */
	public static String assembelFileName(String head, String cityCode,
			String playName, String termCode) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(head).append(Constants.DECOLLATOR);
		if (cityCode != null && cityCode.trim().length() > 0) {
			buffer.append(cityCode).append(Constants.DECOLLATOR);
		}
		buffer.append(playName).append(Constants.DECOLLATOR).append(termCode)
				.append(Constants.SEPERATE).append(Constants.SUFFIX);
		return buffer.toString();
	}

}
