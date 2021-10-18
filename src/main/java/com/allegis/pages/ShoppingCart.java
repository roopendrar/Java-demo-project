package com.allegis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCart {

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	public WebElement availabilitytext;

	@FindBy(xpath = "//div[@class='pull-right']/a[@class='btn btn-primary']")
	public WebElement checkout;

	public ShoppingCart(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void availabletext() {
		try {
			availabilitytext.getText();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void finalchekout() {
		try {
			checkout.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
