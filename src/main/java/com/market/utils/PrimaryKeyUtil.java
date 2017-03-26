package com.market.utils;

import java.util.UUID;

public class PrimaryKeyUtil {

	/**
	 * 获取一个UUID的字符类型
	 * @return 
	 */
	public static String buildUUID() {
		UUID uuid =  UUID.randomUUID();
		return uuid.toString();
	}
	
}
