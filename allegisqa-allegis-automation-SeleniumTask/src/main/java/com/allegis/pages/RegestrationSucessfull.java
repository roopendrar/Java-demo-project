package com.allegis.pages;

import java.awt.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ReadExcel;

public class RegestrationSucessfull {

	@FindBy(xpath="//div[@class='u-ma']/h1[@class='Title Title--xxxl Title--slim u-mt4']")
	public WebElement Sucessfull;
	
	public RegestrationSucessfull(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

public void Sucessfull() {

	try {
		 List<Map<String, String>> testDataupdated = ReadExcel.readstringdata();
		 Sucessfull.sendKeys(testDataupdated.get(0).get("Sucessfull"));
	} catch (Exception e) {
		e.printStackTrace();
	}
}

}
