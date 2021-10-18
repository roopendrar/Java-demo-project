package com.allegis.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import datautils.ReadExcel;

public class AppleCinema extends DriverClass {

	@FindBy(xpath = "//div[@class='radio']/label/input[@type='radio' and @name='option[218]' and @value='6']")
	public WebElement mediumradio;

	@FindBy(xpath = "//div[@class='checkbox']/label/input[@type='checkbox' and @name='option[223][]' and @value='9']")
	public WebElement checkbox1;

	@FindBy(xpath = "//div[@class='checkbox']/label/input[@type='checkbox' and @name='option[223][]' and @value='10']")
	public WebElement checkbox2;

	@FindBy(xpath = "//select[@name='option[217]' and @id='input-option217']")
	public WebElement select;

	@FindBy(xpath = "//select[@name='option[217]' and @id='input-option217']//option[@value='2']")
	public WebElement yellow;

	@FindBy(xpath = "//textarea[@id='input-option209' and @class='form-control']")
	public WebElement textbox;

	@FindBy(xpath = "//button[@id='button-upload222']")
	public WebElement uploadfile;

	@FindBy(xpath = "//button[@id='button-cart' and @class='btn btn-primary btn-lg btn-block']")
	public WebElement addtocart;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	public WebElement successtext;

	@FindBy(xpath = "//span[@class='hidden-xs hidden-sm hidden-md' and text()='Shopping Cart']")
	public WebElement gotocart;

	@FindBy(xpath = "//div[@class='btn-group']//button[@data-original-title='Compare this Product']")
	public WebElement appcomparebtn;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	public WebElement productcomparetext;

	public AppleCinema(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	List<String> testData = new ArrayList<String>();
	ReadExcel dataObj = new ReadExcel();

	public void radiobtn() {
		try {
			mediumradio.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void checkbox1() {
		try {
			checkbox1.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void checkbox2() {
		try {
			checkbox2.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void selectcolor() {
		try {
			select.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void yellowcolor() {
		try {
			yellow.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void textbox() {

		try {
			testData = dataObj.readData();
			textbox.sendKeys(testData.get(10));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void fileupload() {
		try {
			//uploadfile.sendKeys("C:\\Users\\acer\\Documents\\ElseIf");
			JavascriptExecutor js= ((JavascriptExecutor)driver);
			js.executeScript("arguments[0].value='C:\\Users\\acer\\Documents\\ElseIf';",uploadfile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addtocart() {
		try {
			addtocart.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void successtext() {
		try {
			successtext.getText();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void gotocart() {
		try {
			gotocart.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void comparebtn() {
		try {
			appcomparebtn.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void comparedtext() {
		try {
			productcomparetext.getText();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
