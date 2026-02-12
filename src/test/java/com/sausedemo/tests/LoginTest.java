package com.sausedemo.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sausedemo.pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	
	public static final String STANDARD_USERNAME = "standard_user";
	public static final String PASSWORD = "secret_sauce";
	public static final String SAUSEDEMO_URL = "https://www.saucedemo.com/";
	
	LoginPage loginPage;
	WebDriver driver;
	
	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();	
        driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		loginPage = new LoginPage(driver);
		loginPage.open(SAUSEDEMO_URL);
	}
	
	@Test
	public void loginStandardUser() {
		loginPage.enterUserName(STANDARD_USERNAME);
		loginPage.enterPassword(PASSWORD);
		loginPage.clickLoginButton();
		
		WebElement inventory = driver.findElement(By.id("inventory_container"));
		Assert.assertTrue(inventory.isDisplayed());
	}
	
	@AfterClass
	public void closeDriver() {
		driver.quit();
	}
}
