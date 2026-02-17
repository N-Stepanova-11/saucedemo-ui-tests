package com.sausedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutInfoPage extends BasePage{
	
	public CheckoutInfoPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	By checkoutInfoTitle = By.xpath("//span[text()='Checkout: Your Information']");
	
	public boolean isCheckoutInfoDisplayed() {
		return isElementDisplayed(checkoutInfoTitle);
	}
}
