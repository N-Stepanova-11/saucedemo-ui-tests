package com.sausedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasePage{
	By cartTitle = By.xpath("//span[text()='Your Cart']");
	By checkoutButton = By.id("checkout");
	By continueShoppingButton = By.id("continue-shopping");
	String cartItem = "//div[text()='%s']";
	String cartItemRemoveButtonFormat ="//div[@class='cart_item'][.//div[text()='%s']]//button";
	String productLinkFormat = "//div[text()='%s']/parent::a"; 

	public CartPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}
	
	public boolean isCartDisplayed() {
		return isElementDisplayed(cartTitle);
	}
		
	public void checkout() {
		wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
		driver.findElement(checkoutButton).click();
	}
	
	public boolean isProductInTheCart(String productName) {
		return isElementDisplayed(By.xpath(String.format(cartItem, productName)));
	}
	
	public void returnToContinueShopping() {
		wait.until(ExpectedConditions.elementToBeClickable(continueShoppingButton));
		driver.findElement(continueShoppingButton).click();
	}
	
	public void removeProductFromCart(String productName) {
		By cartItemRemoveButton = By.xpath(String.format(cartItemRemoveButtonFormat, productName));
		wait.until(ExpectedConditions.elementToBeClickable(cartItemRemoveButton));
		driver.findElement(cartItemRemoveButton).click();
	}
	
	public void clickOnProduct(String productName) {
		By productLink = By.xpath(String.format(productLinkFormat, productName));
		wait.until(ExpectedConditions.elementToBeClickable(productLink));
		driver.findElement(productLink).click();
	}
}
