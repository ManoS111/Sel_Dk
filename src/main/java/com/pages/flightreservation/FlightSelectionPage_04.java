package com.pages.flightreservation;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.pages.AbstractPage;

public class FlightSelectionPage_04 extends AbstractPage {

	public FlightSelectionPage_04(WebDriver driver) {
		super(driver);
	}

	@FindBy(name = "departure-flight")
	private List<WebElement> departureflight;
	@FindBy(name = "arrival-flight")
	private List<WebElement> arrivalflight;
	@FindBy(id = "confirm-flights")
	private WebElement confirmflights;

	@Override
	public boolean isAt() {
		this.wait.until(ExpectedConditions.visibilityOf(this.confirmflights));
		return confirmflights.isDisplayed();
	}

	public void selectFlight() {
		int depvalue = 0;int arrvalue = 0;
		try {
			Thread.sleep(500);
			System.out.println(">"+ departureflight.size());
			System.out.println(">"+ arrivalflight.size());
			 depvalue = ThreadLocalRandom.current().nextInt(1, departureflight.size());
			 arrvalue = ThreadLocalRandom.current().nextInt(1, arrivalflight.size());
			System.out.println("depvalue > "+ depvalue+ "arrvalue > "+arrvalue);
			jsClick(this.departureflight.get(depvalue));
			jsClick(this.arrivalflight.get(arrvalue));
			//this.departureflight.get(depvalue).click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	public void confirmFlight() {
		jsClick(this.confirmflights);
	}
}
