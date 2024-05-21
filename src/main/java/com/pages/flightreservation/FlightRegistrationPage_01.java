package com.pages.flightreservation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.pages.AbstractPage;

public class FlightRegistrationPage_01 extends AbstractPage {

	public FlightRegistrationPage_01(WebDriver driver) {
		super(driver);
	}

	//public WebDriver driver;
	@FindBy(id = "firstName")
	private WebElement firstName;
	@FindBy(id = "lastName")
	private WebElement lastName;
	@FindBy(id = "email")
	private WebElement email;
	@FindBy(id = "password")
	private WebElement password;
	@FindBy(name = "street")
	private WebElement street;
	@FindBy(name = "city")
	private WebElement city;
	@FindBy(name = "zip")
	private WebElement zip;
	@FindBy(id = "register-btn")
	private WebElement register;

	
	@Override
	public boolean isAt() {
		this.wait.until(ExpectedConditions.visibilityOf(firstName));
		return firstName.isDisplayed();
	}

	public void goTo(String url) {
		this.driver.get(url);
	}

	public void enterUserDetails(String firstname, String lastName) {
		this.firstName.sendKeys(firstname);
		this.lastName.sendKeys(lastName);
	}

	public void enterUserCredentials(String email, String password) {
		this.email.sendKeys(email);
		this.password.sendKeys(password);
	}

	public void enterUserAddress(String street, String city, String zip) {
		this.street.sendKeys(street);
		this.city.sendKeys(city);
		this.zip.sendKeys(zip);
	}

	public void clickRegister() {
		jsClick(this.register);
	}

}
