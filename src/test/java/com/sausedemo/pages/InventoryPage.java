package com.sausedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPage {
	WebDriver driver;
	By inventoryContainer = By.id("inventory_container");

	public InventoryPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public boolean isDisplayed() {
		return driver.findElement(inventoryContainer).isDisplayed();
	}
}
