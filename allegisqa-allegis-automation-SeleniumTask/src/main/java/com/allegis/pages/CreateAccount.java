package com.allegis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccount {
	

	@FindBy(xpath ="//input[@id='Email-1']")
	public WebElement email;

	@FindBy(xpath ="//input[@id='Textbox-1']")
	public WebElement firstname;

	@FindBy(xpath ="//input[@id='Textbox-2']")
	public WebElement lastname;

	@FindBy(xpath ="//input[@id='Textbox-3']")
	public WebElement Company;

	@FindBy(xpath ="//select[@id='Country-1']")
	public WebElement Country;

	@FindBy(xpath ="//select[@id='Country-1']/option [@value='India']")
	public WebElement India;

	@FindBy(xpath ="//input[@id='Textbox-4']")
	public WebElement Phonenumber;

	@FindBy(xpath ="//button[@class='Btn Btn--prim Btn--l u-fs24 u-db js-reg-btn']")
	public WebElement CreateAccount;
	;

	public CreateAccount(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
