package com.pagetest;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.google.common.util.concurrent.Uninterruptibles;
import com.pagetest.util.Config;
import com.pagetest.util.Constants;
import com.pagetest.listener.TestListener;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners({ TestListener.class })
public abstract class AbstractTest {

	private static final Logger log = LoggerFactory.getLogger(AbstractTest.class);
	protected WebDriver driver;

	@BeforeSuite
	public void setUpConfig() {
		Config.initialize();
	}

	@BeforeTest
	public void setDriver(ITestContext cxt) throws MalformedURLException {
		this.driver = Boolean.parseBoolean(Config.get(Constants.GRID_ENABLED)) ? getRemoteDriver() : getLocalDriver();
		cxt.setAttribute(Constants.DRIVER, this.driver);
	}
	public WebDriver getRemoteDriver() throws MalformedURLException {
		// MutableCapabilities capabilities;
		Capabilities capabilities;
		if (Constants.CHROME.equalsIgnoreCase(Config.get(Constants.BROWSER))) {
			capabilities = new ChromeOptions();
		} else {
			capabilities = new FirefoxOptions();
		}

		String urlFormat = Config.get(Constants.GRID_URL_FORMAT);
		String hubHost = Config.get(Constants.GRID_HUB_HOST);
		String url = String.format(urlFormat, hubHost);
		log.info("grid url: {}", url);
		return new RemoteWebDriver(new URL(url), capabilities);

	}

	public WebDriver getLocalDriver() {
		return WebDriverManager.chromedriver().create();
	}

	@AfterTest
	public void quiteDriver() {
		this.driver.quit();
	}

	/*
	 * @AfterMethod public void sleep() {
	 * Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5)); }
	 */
}
