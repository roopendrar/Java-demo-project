package com.allegis.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends DriverClass{

	@FindBy(xpath = "//div[@class='pull-right']/input[@class='btn btn-primary']")
	public WebElement billing;

	@FindBy(xpath = "//input[@id='button-shipping-address']")
	public WebElement delivery;

	@FindBy(xpath = "//input[@id='button-shipping-method']")
	public WebElement deliverymethod;

	@FindBy(xpath = "//div[@class='pull-right']//input[@value='1' and @name='agree']")
	public WebElement tcagree;

	@FindBy(xpath = "//div[@class='pull-right']//input[@id='button-payment-method']")
	public WebElement payment;

	@FindBy(xpath = "//div[@class='pull-right']//input[@id='button-confirm']")
	public WebElement confirmorder;

	@FindBy(xpath = "//div[@id='content' and @class='col-sm-12']/h1")
	public WebElement confirmordertext;

	public CheckoutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	JavascriptExecutor jss = (JavascriptExecutor) driver;
  

	public void billingbtn() {
		try {
			billing.click();
			//jss.executeScript("arguments[0].click();", billing);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deliverybtn() {
		try {
			delivery.click();
			//jss.executeScript("arguments[0].click();", delivery);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deliverymethodbtn() {
		try {
			deliverymethod.click();
			//jss.executeScript("arguments[0].click();", deliverymethod);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void tcbtn() {
		try {
		    tcagree.click();
		//jss.executeScript("arguments[0].click();", tcagree);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void paymentbtn() {
		try {
			payment.click();
			//jss.executeScript("arguments[0].click();", payment);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void confirmorderbtn() {
		try {
			confirmorder.click();
			//jss.executeScript("arguments[0].click();", confirmorder);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void successtext() {
		try {
			confirmordertext.getText();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
