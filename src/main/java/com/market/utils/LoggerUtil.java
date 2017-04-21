package com.market.utils;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerUtil {

	private static Map<Class,Logger> loggerMap = new HashMap<Class, Logger>();
	
	/**
	 * 获取一个日志类
	 * @param classObject
	 * @return
	 */
	public static Logger getLogger(Object classObject) {
		Logger logger = loggerMap.get(classObject.getClass());
		if (logger == null) {
			logger = LoggerFactory.getLogger(classObject.getClass());
		}
		return logger;
	}
	
}
