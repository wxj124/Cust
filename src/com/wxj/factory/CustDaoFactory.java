package com.wxj.factory;

import java.io.FileReader;
import java.util.Properties;

import com.wxj.dao.CustDao;
/**
 * 获取dao接口的工厂类，暂且不用
 * @author LyzIWxj
 *
 */
public class CustDaoFactory {
	private static CustDaoFactory factory = new CustDaoFactory();
	private static Properties prop = new Properties();
	private CustDaoFactory(){
	}
	public static CustDaoFactory getFactory(){
		return factory;
	}
	static{
		prop = new Properties();
		try {
			prop.load(new FileReader(CustDaoFactory.class.getClassLoader().getResource("config.properties").getPath()));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
//	public CustDao getDao(){
//		try {
//			String clazz = prop.getProperty("CustDao");
//			return (CustDao) Class.forName(clazz).newInstance();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
}
