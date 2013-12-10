package com.joyveb.avro.user.test;

import java.io.File;
import java.io.IOException;

import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;

/**
 * 
 * 项目名称：MySpace 类名称：Test
 * 
 * @Company: 北京畅享互联有限公司
 * @Copyright: Copyright (c) 2012
 * @Author： 杨其桔 创建时间：2013-12-10 上午11:50:06 修改备注：
 * @version
 * 
 */
public class Test {
	public static void main(String args[]) {
		User user1 = new User();
		user1.setName("Arway");
		user1.setFavoriteNumber(3);
		user1.setFavoriteColor("green");
		User user2 = new User("Ben", 7, "red");
		// construct with builder
		User user3 = User.newBuilder().setName("Charlie")
				.setFavoriteColor("blue").setFavoriteNumber(100).build();
		// Serialize user1, user2 and user3 to disk
		File file = new File("src/main/resources/users.json");
		DatumWriter<User> userDatumWriter = new SpecificDatumWriter<User>(
				User.class);
		DataFileWriter<User> dataFileWriter = new DataFileWriter<User>(
				userDatumWriter);
		try {
			dataFileWriter.create(user1.getSchema(), new File("src/main/resources/users.json"));
			dataFileWriter.append(user1);
			dataFileWriter.append(user2);
			dataFileWriter.append(user3);
			dataFileWriter.close();
		} catch (IOException e) {
		}
		// Deserialize Users from dist
		DatumReader<User> userDatumReader = new SpecificDatumReader<User>(
				User.class);
		DataFileReader<User> dataFileReader = null;
		try {
			dataFileReader = new DataFileReader<User>(file, userDatumReader);
		} catch (IOException e) {
		}
		User user = null;
		try {
			while (dataFileReader.hasNext()) {
				// Reuse user object by passing it to next(). This saves
				// us from allocating and garbage collecting many objects for
				// files with many items.
				user = dataFileReader.next(user);
				System.out.println(user);
			}
		} catch (IOException e) {
		}
	}
}
