package com.pages.flightreservation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.pages.AbstractPage;

public class RegistrationConfirmPage_02 extends AbstractPage{

	public WebDriver driver;
	
	@FindBy(css="#registration-confirmation-section p b")
	private WebElement firstNameElement;
	
	@FindBy(id = "go-to-flights-search")
	private WebElement gotoflightssearch;

	public RegistrationConfirmPage_02(WebDriver driver) {
		super(driver);
	}

	public String getFirstNameElement() {
		return this.firstNameElement.getText();
	}
	
	public void clickGoToFlightSearch() {
		this.gotoflightssearch.click();
	}
	
	@Override
	public boolean isAt() {
		this.wait.until(ExpectedConditions.visibilityOf(this.gotoflightssearch));
		return gotoflightssearch.isDisplayed();
	}

}
