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

import com.sausedemo.pages.InventoryPage;
import com.sausedemo.pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InventoryTest extends BaseTest{
	
	@Test
	public void addProductToCart() {
		loginPage.authorize(STANDARD_USERNAME, PASSWORD);
		InventoryPage inventoryPage = new InventoryPage(driver, wait);
		inventoryPage.addBackpackToCart();
		Assert.assertTrue(inventoryPage.isRemoveButtonIsDisplayed());
	}

}
