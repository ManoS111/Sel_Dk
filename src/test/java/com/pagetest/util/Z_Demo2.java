package com.pagetest.util;

import com.pagetest.vendorportal.model.vendorPortalTestData;

public class Z_Demo2 {

	public static void main(String[] args) throws Exception {
		vendorPortalTestData testData = JsonUtil.getTestData("test-data/sam.json",vendorPortalTestData.class);
		System.out.println(testData.getMonthlyEarning());
	}

}
