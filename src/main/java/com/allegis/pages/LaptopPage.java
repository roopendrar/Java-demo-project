package com.allegis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LaptopPage {

	@FindBy(css = "button#button-cart")
	public WebElement addtoshop;

	@FindBy(css = "div[class='alert alert-success alert-dismissible']")
	public WebElement lapconfirm;

	public LaptopPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void addtoshop() {
		try {
			addtoshop.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void confirmtext() {
		try {
			lapconfirm.getText();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
