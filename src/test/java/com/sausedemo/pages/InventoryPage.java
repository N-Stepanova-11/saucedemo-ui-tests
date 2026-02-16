package com.sausedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class InventoryPage extends BasePage{
	By inventoryContainer = By.id("inventory_container");
	By cart = By.cssSelector("[data-test='shopping-cart-link']");
	
	String productFormat ="//div[@class='inventory_item'][.//div[text()='%s']]//button";
	String removeButtonFormat = productFormat+"[text()='Remove']";
	String addButtonFormat = productFormat+"[text()='Add to cart']";
	
	public InventoryPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}
	
	public boolean isRemoveButtonIsDisplayed(String productName) {
		return isElementDisplayed(By.xpath(String.format(removeButtonFormat, productName)));
	}
	
	public boolean isAddToCartButtonIsDisplayed(String productName) {
		return isElementDisplayed(By.xpath(String.format(addButtonFormat, productName)));
	}
	
	public boolean isInventoryContainerDisplayed() {
		return isElementDisplayed(inventoryContainer);
	}
	
	public void addProductToCart(String productName) {
		By product = By.xpath(String.format(productFormat, productName));
		wait.until(ExpectedConditions.elementToBeClickable(product));
		driver.findElement(product).click();
	}
	
	public void removeProductFromCart(String productName) {
		By productRemoveButton = By.xpath(String.format(removeButtonFormat, productName));
		wait.until(ExpectedConditions.elementToBeClickable(productRemoveButton));
		driver.findElement(productRemoveButton).click();
	}	
	
	public void openCart() {
		wait.until(ExpectedConditions.elementToBeClickable(cart));
		driver.findElement(cart).click();
	}
}
