package com.joyveb.datastax.demo;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Host;
import com.datastax.driver.core.Metadata;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.Statement;
import com.datastax.driver.core.querybuilder.QueryBuilder;

/**   
 *    
 * 项目名称：MySpace   
 * 类名称：SimpleClient   
 * @Company: 北京畅享互联有限公司
 * @Copyright: Copyright (c) 2012
 * @Author： 杨其桔
 * 创建时间：2013-10-25 下午2:27:45   
 * 修改备注：   
 * @version    
 *    
 */
public class SimpleClient {
	private Cluster cluster;
    Session session;
    String keyspace = "mykeyspaces";
    String columnfamily = "users";
    String PK = "user id";
    String filename = "RHDSetup.log";


    public void connect(String node) {
        cluster = Cluster.builder().addContactPoint(node).build();
        Metadata metadata = cluster.getMetadata();
        System.out.printf("Connected to cluster: %s\n",
                metadata.getClusterName());
        for (Host host : metadata.getAllHosts()) {
            System.out.printf("Datatacenter: %s; Host: %s; Rack: %s\n",
                    host.getDatacenter(), host.getAddress(), host.getRack());
        }
        session = cluster.connect(keyspace);
    }
    public void close() {
        cluster.shutdown();
    }

    private void createCF() {
        String cqlStatement = "CREATE TABLE " + columnfamily + " (" + PK
                + " varchar PRIMARY KEY," + " password varchar ,"
                + " file blob" + ");";
        session.execute(cqlStatement);
    }

    private void insert() {
        String cqlStatement = "INSERT INTO " + keyspace + "." + columnfamily
                + " (" + PK + ", password) VALUES ('gt', '123456')";
        session.execute(cqlStatement);
    }


    private void select() {


        String cqlStatement = "SELECT * FROM " + keyspace + "." + columnfamily;
        for (Row row : session.execute(cqlStatement)) {
            System.out.println(row.toString());
        }


    }


    private void insertFile() {


        File file = new File("c:/"+filename);
        byte[] b = null;
        try {
            b = getByte(file);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ByteBuffer fileByteBuffer = ByteBuffer.wrap(b);
        Statement insertFile = QueryBuilder.insertInto(keyspace, columnfamily)
                .value(PK, filename).value("file", fileByteBuffer)
                .value("password", "654321");
        // .value(PK, "LDCR.lua").value("password", "654321");
        session.execute(insertFile);


    }


    private void readFile() {


        Statement readFile = QueryBuilder.select("file")
                .from(keyspace, columnfamily)
                .where(QueryBuilder.eq(PK, filename));
        Row fileRow = session.execute(readFile).one();
        if (fileRow != null) {
            ByteBuffer fileByteBuffer = fileRow.getBytes("file");
            byte[] bs = null;


            bs = fileByteBuffer.array();


            createFile(bs, "C:", "2" + filename);
        }


    }


    public static byte[] getByte(File file) throws Exception {
        byte[] bytes = null;
        if (file != null) {
            InputStream is = new FileInputStream(file);
            int length = (int) file.length();
            if (length > Integer.MAX_VALUE) // 当文件的长度超过了int的最大值
            {
                System.out.println("this file is max ");
                return null;
            }
            bytes = new byte[length];
            int offset = 0;
            int numRead = 0;
            while (offset < bytes.length
                    && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
                offset += numRead;
            }
            // 如果得到的字节长度和file实际的长度不一致就可能出错了
            if (offset < bytes.length) {
                System.out.println("file length is error");
                return null;
            }
            is.close();
        }
        return bytes;
    }


    public static void createFile(byte[] bfile, String filePath, String fileName) {
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        File file = null;
        try {
            File dir = new File(filePath);
            if (!dir.exists() && dir.isDirectory()) {// 判断文件目录是否存在
                dir.mkdirs();
            }
            file = new File(filePath + "\\" + fileName);
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            bos.write(bfile);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        SimpleClient client = new SimpleClient();
        client.connect("192.168.2.14");
        client.createCF();
        // client.insert();
        client.insertFile();
        // client.select();
        client.readFile();
        client.close();
    }

}
