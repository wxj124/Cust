package com.wxj.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DaoUtils {
	/**
	 * 工具类，用于获取数据源和连接
	 */
	private static DataSource source = new ComboPooledDataSource();
	private DaoUtils(){
	}
	public static DataSource getDataSource(){
		return source;
	}
	public static Connection getConn(){
		try {
			return source.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
