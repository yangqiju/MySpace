package com.joyveb.file.test;

import java.io.File;
import java.io.IOException;

/**
 * 
 * 项目名称：MySpace 类名称：FileRenameTest
 * 
 * @Company: 北京畅享互联有限公司
 * @Copyright: Copyright (c) 2012
 * @Author： 杨其桔 创建时间：2013-9-18 下午3:31:00 修改备注：
 * @version
 * 
 */
public class FileRenameTest {

	public static void main(String[] args) {
		String filepath = "D:\\test\\newFile\\test.INPROGRESS";
		File file = new File(filepath);
		try {
			if(!file.exists()){
				if(createNewFile(file)){
					System.out.println("文件创建成功.");
				}
			}else{
//				if(rename(file)){
//					System.out.println("修改成功.");
//				}
				renameFile(filepath);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean createNewFile(File file) throws IOException{
		if(!file.getParentFile().exists()){
			file.getParentFile().mkdirs();
		}
		return file.createNewFile();
	}
	
	public static boolean rename(File file){
		String filepath = "D:\\test\\newFile\\test.txt";
		return file.renameTo(new File(filepath));
	}
	
	/**
	 * 改名txt
	 * 
	 * @param filePath
	 */
	public static void renameFile(String filePath) {
		String oldname = filePath;
		String realname = filePath.replaceFirst(".txt", ".txt.bak");
		try {
			File realfile = new File(realname);
			if (realfile.exists()) {
				realfile.delete();
			}
			Runtime.getRuntime().exec("mv	" + oldname + "	" + realname);
		} catch (IOException e) {
		}
	}
}
