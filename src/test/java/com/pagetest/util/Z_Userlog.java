package com.pagetest.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Z_Userlog {
	public static Logger log;
	
	public static Logger getLog(Class<?> type) {
		 log=LoggerFactory.getLogger(type);
		 
		return log;
	}

}
