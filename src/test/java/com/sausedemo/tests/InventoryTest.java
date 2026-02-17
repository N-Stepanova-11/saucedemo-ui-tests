package com.sausedemo.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sausedemo.pages.CartPage;
import com.sausedemo.pages.InventoryPage;
import com.sausedemo.pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InventoryTest extends BaseTest{
	InventoryPage inventoryPage;
	
	@BeforeMethod
	public void setup() {
		setupWithAuthorize();
		inventoryPage = new InventoryPage(driver, wait);
	}
	
	@Test
	public void addProductToCart() {
		String productName = "Sauce Labs Bike Light";
		inventoryPage.addProductToCart(productName);
		Assert.assertTrue(inventoryPage.isRemoveButtonIsDisplayed(productName));
	}
	
	@Test
	public void removeProductFromCart() {
		String productName = "Sauce Labs Backpack";
		inventoryPage.addProductToCart(productName);
		inventoryPage.removeProductFromCart(productName);
		Assert.assertTrue(inventoryPage.isAddToCartButtonIsDisplayed(productName));
	}
	
	@Test
	public void openEmptyCart() {
		inventoryPage.openCart();
		CartPage emptyCart = new CartPage(driver, wait);
		Assert.assertTrue((emptyCart.isCartDisplayed()));
	}
}
