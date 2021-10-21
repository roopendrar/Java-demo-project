package com.allegis.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import datautils.UpdatedReadExcel;

public class TestBase {
	public  WebDriver driver;

	@BeforeMethod()
	public void setup() throws IOException {
		String projectpath = System.getProperty("user.dir");
		Properties property = new Properties();
		FileInputStream fis = new FileInputStream(projectpath+"/src/main/resources/Testcase1.properties");
		property.load(fis);
		System.setProperty("webdriver.chrome.driver", (projectpath+"/src/main/resources/drivers/chromedriver(94).exe"));
		driver = new ChromeDriver();
		String yourstore = property.getProperty("yourstore");
		driver.get(yourstore);
		driver.manage().window().maximize();
	}
	
	
	@AfterMethod()
	public void close() {
		driver.quit();
	}

}
