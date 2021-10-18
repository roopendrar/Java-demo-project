package com.allegis.pages;

import java.awt.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ReadExcel;

public class BillingInformation {
	
	@FindBy(xpath="//input[@id='biFirstName']")
	public WebElement firstname;
	
	@FindBy(xpath="//input[@id='biLastName']")
	public WebElement lastname;
	
	@FindBy(xpath="//input[@id='biEmail']")
	public WebElement email;
	
	@FindBy(xpath="//input[@id='biCompany']")
	public WebElement Company;
	
	@FindBy(xpath="//input[@id='biPhone']")
	public WebElement phone;
	
	@FindBy(xpath="//input[@id='biAddress']")
	public WebElement Address;
	
	@FindBy(xpath="//kendo-searchbar[@class='k-searchbar']//input[@class='k-input']")
	public WebElement country;
	
	@FindBy(xpath="//input[@id='biCity']")
	public WebElement city;
	
	@FindBy(xpath="//input[@id='biZipCode']")
	public WebElement zipcode;
	
	@FindBy(xpath="//input[@id='siSameAsBilling']")
	public WebElement Sameasbilling;
	
	@FindBy(xpath="//span[@class='btn-content']")
	public WebElement Continue;
	
	public BillingInformation(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void firstname() {
		try {
			 List<Map<String, String>> testDataupdated = ReadExcel.readstringdata();
			firstname.sendKeys(testDataupdated.get(0).get("firstname"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void lastname() {

		try {
			 List<Map<String, String>> testDataupdated = ReadExcel.readstringdata();
			lastname.sendKeys(testDataupdated.get(0).get("lastname"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void email() {

		try {
			 List<Map<String, String>> testDataupdated = ReadExcel.readstringdata();
			email.sendKeys(testDataupdated.get(0).get("email"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void Company() {
		try {
			 List<Map<String, String>> testDataupdated = ReadExcel.readstringdata();
			 Company.sendKeys(testDataupdated.get(0).get("Company"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void phone() {
			try {
				 List<Map<String, String>> testDataupdated = ReadExcel.readstringdata();
				 phone.sendKeys(testDataupdated.get(0).get("phone"));
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public void Address() {
		try {
			 List<Map<String, String>> testDataupdated = ReadExcel.readstringdata();
			 Address.sendKeys(testDataupdated.get(0).get("Address"));
		} catch (Exception e) {
			e.printStackTrace();
		}
 }

	public void country() {
		try {
			 List<Map<String, String>> testDataupdated = ReadExcel.readstringdata();
			 country.sendKeys(testDataupdated.get(0).get("country"));
		} catch (Exception e) {
			e.printStackTrace();
		}
  }

	public void city() {
		try {
			 List<Map<String, String>> testDataupdated = ReadExcel.readstringdata();
			 city.sendKeys(testDataupdated.get(0).get("city"));
		} catch (Exception e) {
			e.printStackTrace();
		}
}
	public void zipcode() {
		try {
			 List<Map<String, String>> testDataupdated = ReadExcel.readstringdata();
			 zipcode.sendKeys(testDataupdated.get(0).get("zipcode"));
		} catch (Exception e) {
			e.printStackTrace();
		}
}
	
	public void Sameasbilling() {

		try {
			 List<Map<String, String>> testDataupdated = ReadExcel.readstringdata();
			 Sameasbilling.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void Continue() {

		try {
			 List<Map<String, String>> testDataupdated = ReadExcel.readstringdata();
			 Continue.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
  