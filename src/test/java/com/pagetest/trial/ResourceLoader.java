package com.pagetest.trial;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResourceLoader {

	
	private static final Logger log=LoggerFactory.getLogger(ResourceLoader.class);
	
	public static  InputStream getResource(String path) throws Exception {
		log.info("Reading resource from loader: {}",path);
		InputStream stream = ResourceLoader.class.getClassLoader().getResourceAsStream(path);
		System.out.println("2000");
		
		if(Objects.nonNull(stream)) {
			System.out.println("444444");
		return stream;
		}
		return Files.newInputStream(Path.of(path)); 
		
	}
}
