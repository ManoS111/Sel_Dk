package com.pagetest.flightreservation;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.pages.flightreservation.FlightConfirmationPage_05;
import com.pages.flightreservation.FlightRegistrationPage_01;
import com.pages.flightreservation.FlightSearchPage_03;
import com.pages.flightreservation.FlightSelectionPage_04;
import com.pages.flightreservation.RegistrationConfirmPage_02;
import com.pagetest.AbstractTest;
import com.pagetest.flightreservation.model.FlightReservationTestData;
import com.pagetest.util.Config;
import com.pagetest.util.Constants;
import com.pagetest.util.JsonUtil;

public class FlightReservationTest extends AbstractTest {

	private FlightReservationTestData testData;

	@BeforeTest
	@Parameters({"TestDataPath"})
	public void setParameters(String TestDataPath) throws Exception {
		this.testData = JsonUtil.getTestData(TestDataPath, FlightReservationTestData.class);
	}

	@Test
	public void userRegistrationTest() {
		FlightRegistrationPage_01 freg = new FlightRegistrationPage_01(driver);
		freg.goTo(Config.get(Constants.FLIGHT_RESERVATION_URL));
		Assert.assertTrue(freg.isAt());
		freg.enterUserDetails(testData.getFirstName(), testData.getLastName());
		freg.enterUserCredentials(testData.getEmail(), testData.getPassword());
		freg.enterUserAddress(testData.getStreet(),testData.getCity(),testData.getZip());
		freg.clickRegister();
	}

	@Test(dependsOnMethods = "userRegistrationTest")
	public void registrationConfirmTest() {
		System.out.println("FlightReservationTest.registrationConfirmTest()");
		RegistrationConfirmPage_02 fc = new RegistrationConfirmPage_02(driver);
		Assert.assertTrue(fc.isAt());
		Assert.assertEquals(fc.getFirstNameElement(), testData.getFirstName());
		fc.clickGoToFlightSearch();
	}

	@Test(dependsOnMethods = "registrationConfirmTest")
	public void flightSearchTest() {
		FlightSearchPage_03 fs = new FlightSearchPage_03(driver);
		Assert.assertTrue(fs.isAt());
		fs.selectPassenger(testData.getPassengersCount());
		fs.searchFlight();
	}

	@Test(dependsOnMethods = "flightSearchTest")
	public void flightSelectionTest() {
		FlightSelectionPage_04 fsel = new FlightSelectionPage_04(driver);
		Assert.assertTrue(fsel.isAt());
		fsel.selectFlight();
		fsel.confirmFlight();
	}

	@Test(dependsOnMethods = "flightSelectionTest")
	public void flightConfirmationTest() {
		FlightConfirmationPage_05 fc = new FlightConfirmationPage_05(driver);
		Assert.assertTrue(fc.isAt());
		String getprice = fc.getprice();
		Assert.assertEquals(getprice, testData.getExpectedPrice());
	}


}
