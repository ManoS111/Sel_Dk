package com.pages.flightreservation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.pages.AbstractPage;

public class FlightSearchPage_03 extends AbstractPage {

	public FlightSearchPage_03(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "passengers")
	private WebElement passengers;

	@FindBy(id = "search-flights")
	private WebElement searchflights;
	

	@Override
	public boolean isAt() {
		this.wait.until(ExpectedConditions.visibilityOf(this.passengers));
		return passengers.isDisplayed();
	}

	public void selectPassenger(String noofopassenger) {
		new Select(passengers).selectByValue(noofopassenger);
	}

	public void searchFlight() {
		jsClick(this.searchflights);
	}

}
