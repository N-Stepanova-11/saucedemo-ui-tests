package com.sausedemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	
	public final String STANDART_USERNAME = "standard_user";
	public final String PASSWORD = "secret_sauce";
	WebDriver driver;
	
	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.saucedemo.com/");
	}
	
	@Test
	public void loginStandartUser() {
		WebElement userName = driver.findElement(By.id("user-name")); 
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.id("login-button"));
		userName.sendKeys(STANDART_USERNAME);
		password.sendKeys(PASSWORD);
		loginButton.click();		
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
	}
	
	@AfterClass
	public void closeDriver() {
		driver.quit();
	}
}
