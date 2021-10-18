package com.allegis.pages;

import java.awt.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ReadExcel;

public class HomePage {

	@FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
	public WebElement AcceptCookies;

	@FindBy(xpath = "//a[@class='TK-Aside-Menu-Button']")
	public WebElement Account;
	
	
	
	@FindBy(xpath="//a[@class='TK-Aside-Menu-Link']")
	public WebElement Search;
	
	@FindBy(xpath="//a[@class='TK-Aside-Menu-Link js-tlrk-nav-shopping-cart-counter-container']")
	public WebElement ShoppingCart;
	

	@FindBy(xpath="//a[@class='TK-Aside-Menu-Button' and @title='Contact Us']")
	public WebElement Contactus;
    
	@FindBy(xpath="//a[@href='/blogs']")
	public WebElement Blogs;
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void AcceptCookies() {
		try {
			 AcceptCookies.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void Account() {

		try {
			 Account.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void Search() {
		try {
			Search.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void ShoppingCart() {

		try {
			ShoppingCart.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void Contactus() {

		try {
			Contactus.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void Blogs() {

		try {
			Blogs.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
