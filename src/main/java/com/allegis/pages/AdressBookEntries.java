package com.allegis.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdressBookEntries extends DriverClass{

	@FindBy(xpath = "//a[text()='Address Book']")
	public WebElement address;

	@FindBy(xpath = "//div[@class='pull-right']/child::a")
	public WebElement newaddress;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	public WebElement successtext;

	@FindBy(xpath = "//ul[@class='breadcrumb']/li/a/i[@class='fa fa-home']")
	public WebElement home;

	public AdressBookEntries(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	JavascriptExecutor jss = (JavascriptExecutor) driver;

	public void address() {
		try {
			address.click();
			//jss.executeScript("arguments[0].click();", address);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void newaddressbtn() {
		try {
			newaddress.click();
			//jss.executeScript("arguments[0].click();", newaddress);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void successtext() {
		try {
			successtext.getText();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void homebtn() {
		try {
			home.click();
			//jss.executeScript("arguments[0].click();", home);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
