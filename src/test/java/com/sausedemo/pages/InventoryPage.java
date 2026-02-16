package com.sausedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InventoryPage extends BasePage{
	By inventoryContainer = By.id("inventory_container");
	By addBackpack = By.xpath("//div[@class='inventory_item'][.//div[text()='Sauce Labs Backpack']]//button");
	By removeBackpack = By.xpath("//div[@class = 'inventory_item'][.//div[text()='Sauce Labs Backpack']]//button[text()='Remove']");

	public InventoryPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}
	
	public boolean isRemoveButtonIsDisplayed() {
		return isElementDisplayed(removeBackpack);
	}
	
	public boolean isInventoryContainerDisplayed() {
		return isElementDisplayed(inventoryContainer);
	}
	
	public void addBackpackToCart() {
		wait.until(ExpectedConditions.elementToBeClickable(addBackpack));
		driver.findElement(addBackpack).click();
	}
	
}
