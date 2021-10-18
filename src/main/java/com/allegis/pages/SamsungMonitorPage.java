package com.allegis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SamsungMonitorPage {

	@FindBy(xpath = "//button[@data-original-title='Compare this Product']")
	public WebElement samcomparebutton;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	public WebElement samcomparebuttontext;

	@FindBy(xpath = "//span[@class='hidden-xs hidden-sm hidden-md' and text()='Add to Cart']")
	public WebElement addtocart;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	public WebElement addedtext;

	@FindBy(xpath = "//span[@class='hidden-xs hidden-sm hidden-md' and text()='Shopping Cart']")
	public WebElement shoppingcart;

	public SamsungMonitorPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void samsungcomparebtn() {
		try {
			samcomparebutton.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void samsungcomparetext() {
		try {
			samcomparebuttontext.getText();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addtocartbtn() {
		try {
			addtocart.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void textadded() {
		try {
			addedtext.getText();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void shoppingcartbtn() {
		try {
			shoppingcart.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
