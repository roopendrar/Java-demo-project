package com.allegis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Blogs {
	
	@FindBy(xpath="//a[@href='/blogs/testing-alm']")
	public WebElement Testing;
	
	@FindBy(xpath="//a[@href='/blogs/how-to-automate-pdf-testing-truly-straightforward-approach\']")
	public WebElement Testingblog;
	
	@FindBy(xpath="//div[@class='BlogPost-Featured--big']//h1//span[text()]")
	public WebElement Title;
	
	public Blogs(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void Testing() {
		try {
			Testing.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void Testingblog() {
		try {
			Testingblog.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void Title() {
		try {
			Title.getText();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
