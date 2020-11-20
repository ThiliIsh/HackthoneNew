package com.pearson.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;
import com.pearson.pageobjects.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PageObjectModel {

	/* default web driver */
	private WebDriver driver;

	/* default constructor */
	public PageObjectModel() {
		//System.setProperty("webdriver.gecko.driver", "./lib/geckodriver");
		WebDriverManager.chromedriver().setup(); 

		driver = new ChromeDriver();
	}

	@Test
	public void execute() {
		openURL("https://www.bing.com/");
		BingSearch bingsearch = new BingSearch(driver);
		bingsearch.getSearchText().sendKeys("Nuwan bandara");
		bingsearch.getSearchButton().click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		finishTest();
	}

	private void openURL(String url) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().window().maximize();
	}

	public void setWebDriver(final WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver getWebDriver() {
		return this.driver;
	}

	public void finishTest() {
		driver.quit();
	}
}
