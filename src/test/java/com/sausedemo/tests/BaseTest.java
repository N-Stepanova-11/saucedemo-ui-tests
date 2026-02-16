package com.sausedemo.tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.sausedemo.pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public static final String STANDARD_USERNAME = "standard_user";
	public static final String LOCKED_OUT_USER = "locked_out_user";
	public static final String PASSWORD = "secret_sauce";
	public static final String SAUSEDEMO_URL = "https://www.saucedemo.com/";
	
	LoginPage loginPage;
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();	
        driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		loginPage = new LoginPage(driver, wait);
		loginPage.open(SAUSEDEMO_URL);
	}
	
	@AfterMethod
	public void closeDriver() {
		driver.quit();
	}
}
