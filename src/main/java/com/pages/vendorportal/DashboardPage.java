package com.pages.vendorportal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DashboardPage extends AbstractPage {

	public DashboardPage(WebDriver driver) {
		super(driver);
	}
	private static final Logger log=LoggerFactory.getLogger(DashboardPage.class);

	@FindBy(id = "monthly-earning")
	private WebElement monthlyearning;
	@FindBy(id = "annual-earning")
	private WebElement annualearning;
	@FindBy(id = "profit-margin")
	private WebElement profitmargin;
	@FindBy(id = "available-inventory")
	private WebElement availableinventory;
	@FindBy(css = "#dataTable_filter input")
	private WebElement search;
	@FindBy(id = "dataTable_info")
	private WebElement searchcount;
	@FindBy(css = "img.img-profile")
	private WebElement imageprofile;
	@FindBy(linkText = "Logout")
	private WebElement logoutbtn;
	@FindBy(css = "#logoutModal a")
	private WebElement cmlogout;
	

	@Override
	public boolean isAt() {
		this.wait.until(ExpectedConditions.visibilityOf(monthlyearning));
		return this.monthlyearning.isDisplayed();
	}

	public String getMonthlyEarning() {
		System.out.println(this.monthlyearning.getText());
       return this.monthlyearning.getText();
	}
	public String getAnnualEarning() {
		return this.annualearning.getText();
	}
	public String getAvailableInventry() {
		return this.availableinventory.getText();
	}
	public String getProfitMargin() {
		return this.profitmargin.getText();
	}

	public void searchOrderHistory(String input) {
		this.search.sendKeys(input);
	}
	public int getSearchResultCount() throws Exception {
		this.wait.until(ExpectedConditions.visibilityOf(searchcount));
		String text = this.searchcount.getText();
		System.out.println("Text >"+text);
		String[] split = text.split(" ");
		int count = Integer.parseInt(split[5].trim());
	    log.info("Result Count >"+count);
		return count;
	}
	public void logout() {

		
		this.imageprofile.click();
		this.wait.until(ExpectedConditions.visibilityOf(logoutbtn));
		this.logoutbtn.click();
		this.wait.until(ExpectedConditions.visibilityOf(cmlogout));
		this.cmlogout.click();
	}
	
}
