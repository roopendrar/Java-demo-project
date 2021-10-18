package com.allegis.pages;

import java.awt.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ReadExcel;

public class SearchFunctionality {
	
	
	
	@FindBy(xpath="//div[@class]//input[@class='TK-Tag-Input'] ")
	public WebElement SearchText;
	
	@FindBy(xpath="//button[@class='TK-Tag-Input-Button']")
	public WebElement ClickSearch;
	
	@FindBy(xpath="//b[@class='TK-Search-Results-Query']")
    public WebElement Sucessfull;
	
	public SearchFunctionality(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void SearchText() {
		try {
			 List<Map<String, String>> testDataupdated = ReadExcel.readstringdata();
			 SearchText.sendKeys(testDataupdated.get(0).get("SearchText"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void ClickSearch() {
		try {
			 List<Map<String, String>> testDataupdated = ReadExcel.readstringdata();
			 ClickSearch.sendKeys(testDataupdated.get(0).get("ClickSearch"));
		} catch (Exception e) {
			e.printStackTrace();
		}
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
