package com.joyveb.land.socket.test;


/**
 * @Date: 2011-10-28
 * @Title: 加解密工具类
 * @Copyright: Copyright (c) 2011
 * @Company: 北京畅享互联科技有限公司
 * @Author: 李明建
 * @version: 1.0
 */
public class EnDeUtil {
	/**
	 * 异或数据0x9f
	 */
	private final static byte XOR_CONST = (byte) 0x9f;

	/**
	 * 字节高四位与低四位交换
	 * 
	 * @param a
	 * @return
	 */
	private static byte swap(byte a) {
		int lowBit = a & 0x0F; // 得到低四位
		int highBit = a & 0xF0; // 得到高四位
		return (byte) (lowBit << 4 | highBit >>> 4);
	}

	/**
	 * 数据加密(每字节首先异或0x9f，然后高4位和低4位交换顺序)
	 * 
	 * @param bit
	 * @return
	 */
	public static byte[] encrypt(byte[] mingwen){
		int k;
		for (k = 0; k < mingwen.length; k++) {
			int tmpInt = mingwen[k] ^ XOR_CONST;
			byte temp = (byte) (tmpInt);//异或
			mingwen[k] = swap(temp);				//高4位和低4位交换
		}
		return mingwen;
	}

	/**
	 * 数据解密(每字节高4位和低4位交换顺序，然后每字节异或0x9f)
	 * 
	 * @param bit
	 * @return
	 */
	public static byte[] decrypt(byte[] bytes) {
		for(int i=0;i<bytes.length;i++){
			bytes[i] = (byte) (swap(bytes[i]) ^ XOR_CONST);
		}
		return bytes;
		
//		char[] str = miwen.toCharArray();
//		for (int k = 0; k < str.length; k++) {
//			char temp = (char) swap((byte)str[k]);
//			str[k] = (char) (temp ^ XOR_CONST);
//		}
//		return new String(str);
	}
	
	/**
	 * 长整型（4字节）随机码转为4字节字符串
	 * 
	 * @param random
	 * @return
	 */
	@Deprecated
	public static String intTo4ByteString(int random) {
		byte[] bytes = new byte[4];
		for(int i=0;i<bytes.length;i++){
			bytes[i] = (byte) ((random >> (8 * i)) & 0xff);
		}
		char[] chars = new char[4];
		for(int i=0;i<bytes.length;i++){
			chars[i] = (char) bytes[i];			
		}
		return new String(chars);
	}

	/**
	 * 4字节字符串随机码转为长整型（4字节）
	 * 
	 * @param str
	 * @return
	 */
	@Deprecated
	public static int string2Int(String str) {
		char[] chars = str.toCharArray();
		int iOutcome = 0;
		byte bLoop;
		for (int i = 0; i < chars.length; i++) {
			bLoop = (byte) chars[i];
			iOutcome += (bLoop & 0xFF) << (8 * i);
		}
		return iOutcome;
	}

//	public static void main(String[] args) throws UnsupportedEncodingException {
//		String mingwen = "afdasd@$#@	1231	dfa";
//		System.out.println("明文：" + mingwen);
//		String miwen = new String(encrypt(mingwen.getBytes()));
//		System.out.println("加密后：" + miwen);
//		System.out.println("解密后：" + decrypt(encrypt(mingwen.getBytes())));
//		
//		int rand = PadUtil.randomInt();
//		String str = intTo4ByteString(rand);
//		System.out.println(rand + "---hex:" + Integer.toBinaryString(rand)
//				+ ",length:" + str.length() + ", int:"
//				+ string2Int(str));
//		
//	}
}
