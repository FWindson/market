package com.market.utils;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LoggerUtil {

	private static Map<Class,Log> loggerMap = new HashMap<Class, Log>();
	
	/**
	 * 获取一个日志类
	 * @param classObject
	 * @return
	 */
	public static Log getLogger(Object classObject) {
		Log logger = loggerMap.get(classObject.getClass());
		if (logger == null) {
			logger = LogFactory.getLog(classObject.getClass());
		}
		return logger;
	}
	
}
