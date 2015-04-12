package com.wxj.factory;

import java.io.FileReader;
import java.util.Properties;

import com.wxj.dao.CustDao;

public class BasicDaoFactory {
	/**
	 * 工厂类实现解耦
	 */
	private static BasicDaoFactory factory = new BasicDaoFactory();
	private static Properties prop = new Properties();

	private BasicDaoFactory() {
	}

	public static BasicDaoFactory getFactory() {
		return factory;
	}

	static {
		prop = new Properties();
		try {
			prop.load(new FileReader(BasicDaoFactory.class.getClassLoader()
					.getResource("config.properties").getPath()));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public <T> T getInstance(Class<T> clazz) {// class即接口名字，对照接口的名字在配置文件中找到接口实现类
		try {
			String cName = clazz.getSimpleName();
			String cImplName = prop.getProperty(cName);
			return (T) Class.forName(cImplName).newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}

	}
}
