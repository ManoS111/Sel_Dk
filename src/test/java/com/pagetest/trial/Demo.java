package com.pagetest.trial;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;

public class Demo {

	public static void main(String[] args) throws Exception {

		InputStream stream = ResourceLoader.getResource("dummy.txt");
		System.out.println("MMM");
		String string = IOUtils.toString(stream, StandardCharsets.UTF_8);
		System.out.println(string);
		
	}

}
