package com.pages.flightreservation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pages.AbstractPage;

public class FlightConfirmationPage_05 extends AbstractPage {
	
	public static final Logger log= LoggerFactory.getLogger(FlightConfirmationPage_05.class);

	public FlightConfirmationPage_05(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "#flights-confirmation-section .card-body .row:nth-child(1) .col:nth-child(2)")
	private WebElement flightconfirmationid;
	@FindBy(css = "#flights-confirmation-section .card-body .row:nth-child(3) .col:nth-child(2)")
	private WebElement totalprice;

	@Override
	public boolean isAt() {
		this.wait.until(ExpectedConditions.visibilityOf(flightconfirmationid));
		return flightconfirmationid.isDisplayed();
	}

	public String  getprice() {
		String confirmId= flightconfirmationid.getText();
		String price= totalprice.getText();
		log.info("ConfirmationId {}",confirmId);
		log.info("TotalPrice {}",price);
		return price;
	}
}
