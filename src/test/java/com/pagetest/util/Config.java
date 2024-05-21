package com.pagetest.util;

import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Config {
	 private static final Logger log = LoggerFactory.getLogger(Config.class);
	private static final String DEFAULT_PROPERTIES = "config/default.properties";
	private static Properties properties;

	public static void initialize() {
		properties = loadPropertyies();
		for (String key : properties.stringPropertyNames()) {
			System.out.println("Key .."+key);
			if (System.getProperties().containsKey(key)) {
				properties.setProperty(key, System.getProperty(key));
			}
		}
		for (String key : properties.stringPropertyNames()) {
			log.info("{}={}", key, properties.getProperty(key));
			//System.out.println("Key :"+key +"Value :"+properties.getProperty(key));
		}
	}

	public static String get(String key) {
		return properties.getProperty(key);
	}

	private static Properties loadPropertyies() {
		Properties properties = new Properties();
		try (InputStream resource = ResourceLoader.getResource(DEFAULT_PROPERTIES)) {
			properties.load(resource);
		} catch (Exception e) {
			log.error("Unable to read Properties file {}", DEFAULT_PROPERTIES, e);
		}
		return properties;
	}

}
