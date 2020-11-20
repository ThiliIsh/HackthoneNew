package com.pearson.pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.apache.log4j.Logger;

public class BingSearch {

	private Logger logger = Logger.getLogger(BingSearch.class);
	private WebDriver driver;

	private WebElement searchText;
	private WebElement searchButton;
	

	/*default constructor*/
	public BingSearch(){
		initializeElements();
	}
	
	/*constructor*/
	public BingSearch(WebDriver driver){
		this.driver = driver;
		initializeElements();
	}
	
	public void setWebDriver(WebDriver driver){
		this.driver = driver;
	}
	
	public WebDriver getWebDriver(){
		return this.driver;
	}
	
	public WebElement getSearchText(){
		return this.searchText;
	}
	public WebElement getSearchButton(){
		return this.searchButton;
	}
	
	/*initialization of the elements*/
	private void initializeElements(){
		searchText = driver.findElement(By.cssSelector("#sb_form_q"));
		searchButton = driver.findElement(By.cssSelector("#sb_form_go"));
		
	}
}
