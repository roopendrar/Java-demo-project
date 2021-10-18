package com.allegis.pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import datautils.UpdatedReadExcel;

public class HomePage extends DriverClass{
	@FindBy(xpath = "//span[@class='hidden-xs hidden-sm hidden-md' and text()='My Account']")
	public WebElement myaccount;

	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[text()='Register']")
	public WebElement register;

	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[text()='Login']")
	public WebElement login;

	@FindBy(xpath = "//div[@class='caption']/h4/a[text()='Apple Cinema 30\"']")
	public WebElement applecinema;

	@FindBy(xpath = "//li[@class='dropdown']/a[@class='dropdown-toggle' and text()='Desktops']")
	public WebElement desktops;

	@FindBy(xpath = "//div[@class='dropdown-menu']//a[@class='see-all' and text()='Show All Desktops']")
	public WebElement allcomponents;

	@FindBy(xpath = "//li/a[text()='Phones & PDAs']")
	public WebElement phonespda;

	@FindBy(css = "button[class='btn btn-link dropdown-toggle']")
	public WebElement currency;

	@FindBy(xpath = "//li/button[@class='currency-select btn btn-link btn-block' and text()='£ Pound Sterling']")
	public WebElement pound;

	@FindBy(xpath = "//div[@id='search']/input[@class='form-control input-lg']")
	public WebElement searchbar;

	@FindBy(xpath = "//div[@id='search']//span[@class='input-group-btn']/button[@class='btn btn-default btn-lg']")
	public WebElement searchbutton;

	@FindBy(xpath = "//li[@class='dropdown']/a[@class='dropdown-toggle' and text()='Components']")
	public WebElement components;

	@FindBy(xpath = "//div[@class='dropdown-menu']//a[@class='see-all' and text()='Show All Components']")
	public WebElement showall;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/*
	 * List<String> testData = new ArrayList<String>(); ReadExcel dataObj = new
	 * ReadExcel();
	 */
	JavascriptExecutor jss = (JavascriptExecutor) driver;

	public void myaccountbtn() {
		try {
		 	myaccount.click();
			//jss.executeScript("arguments[0].click();", myaccount);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void registerbtn() {
		try {
			register.click();
			//jss.executeScript("arguments[0].click();", register);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void loginbtn() {
		try {
			login.click();
			//jss.executeScript("arguments[0].click();", login);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void applecinemabtn() {
		try {
			applecinema.click();
			//jss.executeScript("arguments[0].click();", applecinema);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void desktopsbtn() {
		try {
			desktops.click();
			//jss.executeScript("arguments[0].click();", desktops);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void allcomponentsbtn() {
		try {
			allcomponents.click();
			//jss.executeScript("arguments[0].click();", allcomponents);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void phonespdabtn() {
		try {
			phonespda.click();
			//jss.executeScript("arguments[0].click();", phonespda);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void currencybtn() {
		try {
			currency.click();
			//jss.executeScript("arguments[0].click();", currency);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void poundsbtn() {
		try {
			pound.click();
			//jss.executeScript("arguments[0].click();", pound);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void searchbar() {
		try {
			 List<Map<String, String>> testDataupdated = UpdatedReadExcel.readstringdata();
			searchbar.sendKeys(testDataupdated.get(0).get("searchbarinfo"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void searchbtn() {
		try {
			searchbutton.click();
			//jss.executeScript("arguments[0].click();", searchbutton);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void componentsbtn() {
		try {
			components.click();
			//jss.executeScript("arguments[0].click();", components);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void showallbtn() {
		try {
			showall.click();
			//jss.executeScript("arguments[0].click();", showall);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
