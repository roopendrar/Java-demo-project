package com.allegis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PalmPhone {

	@FindBy(xpath = "//button[@class='btn btn-default']/i[@class='fa fa-heart']")
	public WebElement wishbutton;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	public WebElement phonesuccesstext;

	public PalmPhone(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void wishlistbtn() {
		try {
			wishbutton.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void successtext() {
		try {
			phonesuccesstext.getText();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
