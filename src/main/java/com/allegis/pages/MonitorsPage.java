package com.allegis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MonitorsPage {
	@FindBy(xpath = "//div[@class='caption']/h4/a[text()='Apple Cinema 30\"']")
	public WebElement applemonitor;

	@FindBy(xpath = "//div[@class='caption']/h4/a[text()='Samsung SyncMaster 941BW']")
	public WebElement samsungmonitor;

	@FindBy(xpath = "//div[@class='form-group']//a[@id='compare-total']")
	public WebElement productcompare;

	public MonitorsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void applemonitorbtn() {
		try {
			applemonitor.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void samsungmonitorbtn() {
		try {
			samsungmonitor.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void productcomparebtn() {
		try {
			productcompare.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
