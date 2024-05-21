package com.pagetest.vendorportal;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.pages.vendorportal.DashboardPage;
import com.pages.vendorportal.LoginPage;
import com.pagetest.AbstractTest;
import com.pagetest.util.Config;
import com.pagetest.util.Constants;
import com.pagetest.util.JsonUtil;
import com.pagetest.vendorportal.model.vendorPortalTestData;

public class VendorPortalTest extends AbstractTest {
	
	private LoginPage login;
	private DashboardPage dbp ;
	private vendorPortalTestData testData;

	@BeforeTest
	@Parameters("TestDataPath")
	public void setPageObject(String testDataPath) throws Exception {
		this.login = new LoginPage(driver);
		this.dbp = new DashboardPage(driver);
		this.testData=JsonUtil.getTestData(testDataPath,vendorPortalTestData.class);
		System.out.println("VendorPortalTest --> @BeforeTest");
	}

	@Test
	public void loginTest() {
		login.goTo(Config.get(Constants.VENDOR_PORTAL_URL));
		Assert.assertTrue(login.isAt());
		login.login(testData.getUsername(), testData.getPassword());
	}

	@Test(dependsOnMethods="loginTest")
	public void dashboardTest() throws Exception {
		
		Assert.assertTrue(dbp.isAt());
		Assert.assertEquals(dbp.getMonthlyEarning(), testData.getMonthlyEarning());
		Assert.assertEquals(dbp.getAnnualEarning(), testData.getAnnualEarnig());
		Assert.assertEquals(dbp.getProfitMargin(), testData.getProfitMargin());
		Assert.assertEquals(dbp.getAvailableInventry(), testData.getAvailableInventory());
		dbp.searchOrderHistory(testData.getSearchKeyword());
		Assert.assertEquals(dbp.getSearchResultCount(),testData.getSearchResultCount());
	}
	@Test(dependsOnMethods="dashboardTest")
	public void logout() {
		dbp.logout();
		Assert.assertTrue(login.isAt());
	}


}
