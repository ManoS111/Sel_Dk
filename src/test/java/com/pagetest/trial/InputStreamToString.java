package com.pagetest.trial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InputStreamToString {
	public static String convertToString(InputStream inputStream) throws IOException {
		StringBuilder stringBuilder = new StringBuilder();
		try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				stringBuilder.append(line).append("\n");
			}
		}
		return stringBuilder.toString();
	}

	public static void main(String[] args) throws Exception {
        InputStream inputStream = ResourceLoader.class.getClassLoader().getResourceAsStream("./dummy.txt");
        try {
            String result = convertToString(inputStream);
            System.out.println(": -->"+result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}