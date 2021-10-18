package com.allegis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage {

	@FindBy(xpath = "//div[@id='content' and @class='col-sm-9']/h1")
	public WebElement confirmtext;

	public ConfirmationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void confirmtext() {
		try {
			confirmtext.getText();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
