package com.sausedemo.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sausedemo.pages.CartPage;
import com.sausedemo.pages.CheckoutInfoPage;
import com.sausedemo.pages.InventoryPage;
import com.sausedemo.pages.ProductPage;

public class CartTest extends BaseTest{
	
	CartPage cartPage; 
	
	@BeforeMethod
	public void setup() {
		setupWithAuthorize();
		cartPage = new CartPage(driver, wait);
	}
	
	@Test
	public void checkProductInTheCart() {
		String productName = "Sauce Labs Fleece Jacket";
		InventoryPage inventoryPage = new InventoryPage(driver, wait);
		inventoryPage.addProductToCart(productName);
		inventoryPage.openCart();
		Assert.assertTrue(cartPage.isProductInTheCart(productName));
	}
	
	@Test
	public void returnToInventoryPage() {
		String productName = "Sauce Labs Bolt T-Shirt";
		InventoryPage inventoryPage = new InventoryPage(driver, wait);
		inventoryPage.addProductToCart(productName);
		inventoryPage.openCart();
		cartPage.returnToContinueShopping();
		Assert.assertTrue(inventoryPage.isInventoryContainerDisplayed());
	}
	
	@Test
	public void removeProductFromCart() {
		String productName = "Sauce Labs Onesie";
		InventoryPage inventoryPage = new InventoryPage(driver, wait);
		inventoryPage.addProductToCart(productName);
		inventoryPage.openCart();
		cartPage.removeProductFromCart(productName);
		Assert.assertFalse(cartPage.isProductInTheCart(productName));
	}
	
	@Test
	public void openProductFromCart() {
		String productName = "Sauce Labs Backpack";
		InventoryPage inventoryPage = new InventoryPage(driver, wait);
		inventoryPage.addProductToCart(productName);
		inventoryPage.openCart();
		cartPage.clickOnProduct(productName);
		ProductPage productPage = new ProductPage(driver, wait);
		Assert.assertTrue(productPage.isProductPageDisplayed(productName));
	}
	
	@Test
	public void checkoutProduct() {
		String productName = "Sauce Labs Bike Light";
		InventoryPage inventoryPage = new InventoryPage(driver, wait);
		inventoryPage.addProductToCart(productName);
		inventoryPage.openCart();
		cartPage.checkout();
		CheckoutInfoPage checkoutInfoPage = new CheckoutInfoPage(driver, wait);
		Assert.assertTrue(checkoutInfoPage.isCheckoutInfoDisplayed());
	}
}
