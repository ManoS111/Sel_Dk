package com.pagetest.util;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;

public class Z_Demo {

	public static void main(String[] args) throws Exception {

		InputStream stream = ResourceLoader.getResource("test-data/sam.json");
		String string = IOUtils.toString(stream, StandardCharsets.UTF_8);
		System.out.println(string);
		
	}

}
