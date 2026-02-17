package com.sausedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends BasePage{
	String productNameFormat = "//div[@class='inventory_details'][.//div[text()='%s']]";

	public ProductPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	public boolean isProductPageDisplayed(String productName) {
		By productCard = By.xpath(String.format(productNameFormat, productName));
		return isElementDisplayed(productCard);
	}
}
