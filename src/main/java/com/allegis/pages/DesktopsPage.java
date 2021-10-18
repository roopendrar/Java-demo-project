package com.allegis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DesktopsPage {

	@FindBy(xpath = "//div[@class='caption']/h4/a[text()='HP LP3065']")
	public WebElement hplaptop;

	public DesktopsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void hplaptop() {
		try {
			hplaptop.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
