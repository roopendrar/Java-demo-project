package com.allegis.pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import datautils.UpdatedReadExcel;

public class LoginPage extends UpdatedReadExcel {

	@FindBy(css = "input[id='input-email']")
	public WebElement loginmail;

	@FindBy(css = "input[id='input-password']")
	public WebElement loginpassword;

	@FindBy(css = "input[class='btn btn-primary']")
	public WebElement loginbutton;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	/*
	 * List<Map<String, String>> testData = UpdatedReadExcel.readDataupdated();
	 * ReadExcel dataObj = new ReadExcel();
	 */
	 

	public void setusername() {
		try {
			 List<Map<String, String>> testDataupdated = UpdatedReadExcel.readstringdata();
			loginmail.sendKeys(testDataupdated.get(0).get("emialid"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setpassword() {

		try {
			 List<Map<String, String>> testDataupdated = UpdatedReadExcel.readstringdata();
			loginpassword.sendKeys(testDataupdated.get(0).get("password"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void login() {
		try {
			loginbutton.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
