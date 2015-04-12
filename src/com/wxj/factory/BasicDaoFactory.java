package com.wxj.factory;

import java.io.FileReader;
import java.util.Properties;

import com.wxj.dao.CustDao;

public class BasicDaoFactory {
	/**
	 * ������ʵ�ֽ���
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

	public <T> T getInstance(Class<T> clazz) {// class���ӿ����֣����սӿڵ������������ļ����ҵ��ӿ�ʵ����
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
