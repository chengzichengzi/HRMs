package com.company.hrm.dao.dbutil;

import com.company.hrm.common.SpringIOC;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbUtil {
	public static ComboPooledDataSource dataSource = (ComboPooledDataSource) SpringIOC.getCtx().getBean("ComboPooledDataSource");
	public static Connection getConnection() throws Exception {
		Connection con = dataSource.getConnection();
		return con;
	}
	public static void closeConnection(ResultSet rs,Statement ps,Connection con) throws Exception {
		if (rs != null) {
			rs.close();
		}
		if (ps != null) {
			ps.close();
		}
		if (con != null) {
			con.close();
		}
	}

}
