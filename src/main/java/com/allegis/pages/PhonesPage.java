package com.allegis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PhonesPage {

	@FindBy(xpath = "//button[@id='list-view']/i[@class='fa fa-th-list']")
	public WebElement list;

	@FindBy(xpath = "//select[@id='input-sort' and @class='form-control']")
	public WebElement sortby;

	@FindBy(xpath = "//select[@id='input-sort']//option[text()='Price (High > Low)']")
	public WebElement lowtohigh;

	@FindBy(xpath = "//select[@id='input-limit' and @class='form-control']")
	public WebElement show;

	@FindBy(xpath = "//select[@id='input-limit' and @class='form-control']//option[text()=50]")
	public WebElement fifty;

	@FindBy(xpath = "//div[@class='caption']/h4/a[text()='Palm Treo Pro']")
	public WebElement mobile;

	public PhonesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void listbtn() {
		try {
			list.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void sortbybtn() {
		try {
			sortby.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void lowtohigh() {
		try {
			lowtohigh.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void showbtn() {
		try {
			show.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void fifty() {
		try {
			fifty.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void mobile() {
		try {
			mobile.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
