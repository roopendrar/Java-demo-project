package com.allegis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComponentsPage {

	@FindBy(xpath = "//div[@class='col-sm-3']//a[text()='Monitors (2)']")
	public WebElement monitorlist;

	public ComponentsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void monitorlistbtn() {
		try {
			monitorlist.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
