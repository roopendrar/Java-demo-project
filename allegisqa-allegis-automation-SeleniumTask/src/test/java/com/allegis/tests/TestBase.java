package com.allegis.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

	public WebDriver driver;

	@BeforeMethod()
	public void setup() throws IOException {
		Properties property = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\mrajendra\\eclipse-workspace\\allegisqa-allegis-automation-SeleniumTask\\allegisqa-allegis-automation-SeleniumTask\\src\\main\\resources\\testcase.properties");
	property.load(fis);
		System.setProperty("webdriver.chrome.driver", property.getProperty("Driver"));
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		String telerik = property.getProperty("telerik");
		driver.get(telerik);
		driver.manage().window().maximize();
	}

	@AfterMethod()
	public void close() {
		driver.quit();
	}

}
