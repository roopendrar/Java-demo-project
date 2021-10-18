package com.allegis.pages;

import java.awt.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ReadExcel;

public class Contactus {
	
	
	@FindBy(xpath="//select[@id='GeneralContent_C020_ctl00_ctl00_C029_ctl00_ctl00_dropDown']")
	public WebElement Selecthelp;
	
	@FindBy(xpath="//select[@id='GeneralContent_C020_ctl00_ctl00_C029_ctl00_ctl00_dropDown' ]/option[ @id='general-inquiries']")
	public WebElement generalinquires;
	
	@FindBy (xpath="//select[@id='GeneralContent_C020_ctl00_ctl00_C038_ctl00_ctl00_dropDown' ]")
	public WebElement SelectProduct;
	
	@FindBy(xpath="//select[@id='GeneralContent_C020_ctl00_ctl00_C038_ctl00_ctl00_dropDown' ]/option[ @id='devcraft']")
    public WebElement DevCraft;
	
	@FindBy(xpath="//input[@id='GeneralContent_C020_ctl00_ctl00_C019_ctl00_ctl00_textBox_write' ]")
    public WebElement Firstname;
	
	@FindBy(xpath="//input[@id='GeneralContent_C020_ctl00_ctl00_C020_ctl00_ctl00_textBox_write']")
    public WebElement Lastname;
	
	@FindBy(xpath="//input[@id='GeneralContent_C020_ctl00_ctl00_C018_ctl00_ctl00_textBox_write']")
	 public WebElement email;
	
	@FindBy(xpath="//input[@id='GeneralContent_C020_ctl00_ctl00_C021_ctl00_ctl00_textBox_write']")
    public WebElement Company;
	
	@FindBy(xpath="//select[@id='GeneralContent_C020_ctl00_ctl00_Country_ctl00_ctl00_dropDown']")
	public WebElement country;
	
	@FindBy(xpath="//select[@id='GeneralContent_C020_ctl00_ctl00_Country_ctl00_ctl00_dropDown']/option[@value='India']")
	public WebElement India;
	
	@FindBy(xpath="//input[@id='GeneralContent_C020_ctl00_ctl00_C024_ctl00_ctl00_textBox_write']")
	public WebElement Phonenumber;
	
	@FindBy(xpath="//textarea[@id='GeneralContent_C020_ctl00_ctl00_C030_ctl00_ctl00_textBox_write']")
	public WebElement Comments;
	
	@FindBy(xpath="//input[@id='GeneralContent_C020_ctl00_ctl00_C002']")
	public WebElement Contact;
	
	public Contactus(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void Selecthelp() {
		try {
			 Selecthelp.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void generalinquires() {
		try {
			generalinquires.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void SelectProduct() {
		try {
			SelectProduct.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void DevCraft() {
		try {
			DevCraft.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void firstname() {
		try {
			 List<Map<String, String>> testDataupdated = ReadExcel.readstringdata();
			 Firstname.sendKeys(testDataupdated.get(0).get("Firstname"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void lastname() {

		try {
			 List<Map<String, String>> testDataupdated = ReadExcel.readstringdata();
			Lastname.sendKeys(testDataupdated.get(0).get("Lastname"));
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
	
	public void country() {
		try {
			 List<Map<String, String>> testDataupdated = ReadExcel.readstringdata();
			 country.sendKeys(testDataupdated.get(0).get("country"));
		} catch (Exception e) {
			e.printStackTrace();
		}
  }
	public void India() {
		try {
			India.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
  }
	public void Phonenumber() {
		try {
			 List<Map<String, String>> testDataupdated = ReadExcel.readstringdata();
			 Phonenumber.sendKeys(testDataupdated.get(0).get("Phonenumber"));
		} catch (Exception e) {
			e.printStackTrace();
		}
}
	public void Comments() {
		try {
			 List<Map<String, String>> testDataupdated = ReadExcel.readstringdata();
			 Comments.sendKeys(testDataupdated.get(0).get("Comments"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void Contact() {

		try {
			 List<Map<String, String>> testDataupdated = ReadExcel.readstringdata();
			 Contact.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
