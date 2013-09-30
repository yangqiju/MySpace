package com.joyveb.java7.ch1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class ch1_7_JDBC {

	public static void main(String[] args) {

		try (Connection con = null; Statement stmt = con.createStatement()) {

		} catch (Exception e) {
			// TODO: handle exception
		}

		RowSetFactory myRowSetFactory = null;
		JdbcRowSet jdbcRs = null;
		ResultSet rs = null;
		Statement stmt = null;
		try {
			myRowSetFactory = RowSetProvider.newFactory();// 用缺省的RowSetFactory
															// 实现
			jdbcRs = myRowSetFactory.createJdbcRowSet();
			// 创建一个 JdbcRowSet 对象，配置数据库连接属性
			jdbcRs.setUrl("jdbc:myDriver:myAttribute");
			jdbcRs.setUsername("");
			jdbcRs.setPassword("");
			jdbcRs.setCommand("select ID from TEST");
			jdbcRs.execute();
			
			
		} catch (Exception e) {

		}
	}
}
