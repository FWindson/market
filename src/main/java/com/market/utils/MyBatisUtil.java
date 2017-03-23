package com.market.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {

	public final static String MYBATIS_CONFIG = "mybatis-config.xml";

	/**
	 * 工厂类静态单例
	 */
	private static SqlSessionFactory sqlSessionFactory;

	/**
	 * 获取新的SqlSession
	 * 
	 * @return
	 * @throws IOException
	 */
	public static SqlSession getSession() {
		if (sqlSessionFactory == null) {
			String resource = MYBATIS_CONFIG;
			InputStream inputStream;
			try {
				inputStream = Resources.getResourceAsStream(resource);
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sqlSessionFactory.openSession();
	}

}
