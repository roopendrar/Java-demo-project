package com.allegis.pages;


import java.awt.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ReadExcel;

public class ShoppingCart {
	
	@FindBy(xpath="//a[@class='Btn Btn--prim4 u-db u-tac js-buy-btn']")
	public WebElement Buy;
	
	@FindBy(xpath="//div[@class='coupon-control-container u-fr u-df']//input")
	public WebElement Coupon;
    
	@FindBy(xpath="//button[@class='btn btn-default e2e-save-coupon-code ng-star-inserted']")
	public WebElement ApplyCoupon;
    
	@FindBy(xpath="//button[@class='btn btn-accent btn-lg u-fr e2e-continue loader-container']//span[@class='btn-content']")
	public WebElement Continue;
	
	public ShoppingCart(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void Buy() {
		try {
			 List<Map<String, String>> testDataupdated = ReadExcel.readstringdata();
			 Buy.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void Coupon() {
		try {
			 List<Map<String, String>> testDataupdated = ReadExcel.readstringdata();
			 Coupon.sendKeys(testDataupdated.get(0).get("Coupon"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void ApplyCoupon() {

		try {
			 List<Map<String, String>> testDataupdated = ReadExcel.readstringdata();
			 ApplyCoupon.sendKeys(testDataupdated.get(0).get("ApplyCoupon"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void Continue() {

		try {
			 List<Map<String, String>> testDataupdated = ReadExcel.readstringdata();
			 Continue.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
