package com.allegis.pages;

import java.awt.List;

import java.util.Map;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ReadExcel;
//
public class LoginAccount {

	@FindBy(xpath="//div[@class='u-tac  Login-panel']//a[text()='Create an account for free']")
	public WebElement Account;
	
	@FindBy(xpath="//input[@class='sfTxt js-useremail js-login-email sessioncamexclude' and @id='username']")
	public WebElement email;
	
	@FindBy(xpath="//input[@class='sfTxt sessioncamexclude' and @id='password']")
	public WebElement password;
	
	@FindBy(xpath="//button[@id='LoginButton-1']")
	public WebElement login;
	
	@FindBy(xpath="//div[@class='u-mb20 u-cf r-header']/h2[@class='u-fl']")
	public WebElement SuccessFulllogin;
	
	public LoginAccount(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
		public void username() {
		try {
			 List<Map<String, String>> testDataupdated = ReadExcel.readstringdata();
			email.sendKeys(testDataupdated.get(0).get("emial"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void password() {

		try {
			 List<Map<String, String>> testDataupdated = ReadExcel.readstringdata();
			password.sendKeys(testDataupdated.get(0).get("password"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void login() {
		try {
			login.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}


