package com.pages.vendorportal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends AbstractPage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id = "login")
	private WebElement login;
	@FindBy(id = "username")
	private WebElement username;
	@FindBy(id = "password")
	private WebElement password;
	

	@Override
	public boolean isAt() {
		this.wait.until(ExpectedConditions.visibilityOf(login));
		return this.login.isDisplayed();
	}

	public void goTo(String url) {
		this.driver.get(url);
	}
	public void login(String username ,String password) {

	this.username.sendKeys(username);
	this.password.sendKeys(password);
	this.login.click();
	}
/*
 * public WebElement getUsername() {
		return username;
	}

	public void setUsername(WebElement username) {
		this.username = username;
	}*/
	
 
}
