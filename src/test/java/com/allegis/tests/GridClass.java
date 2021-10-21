package com.allegis.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class GridClass {
	public  WebDriver driver;

	@BeforeMethod()
	public void setup() throws IOException {
		try {
			DesiredCapabilities dcap=new DesiredCapabilities();
			dcap.setBrowserName("chrome");
			dcap.setPlatform(Platform.WINDOWS);
			ChromeOptions options=new ChromeOptions();
			options.merge(dcap);
			driver=new RemoteWebDriver(new URL("http://192.168.1.100:4444/wd/hub"),options);
			String projectpath = System.getProperty("user.dir");
			Properties property = new Properties();
			FileInputStream fis = new FileInputStream(
					projectpath+"/src/main/resources/Testcase1.properties");
			property.load(fis);
			System.setProperty("webdriver.chrome.driver", (projectpath+"/src/main/resources/drivers/chromedriver(94).exe"));
			String yourstore = property.getProperty("yourstore");
			driver.get(yourstore);
			driver.manage().window().maximize();
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterMethod()
	public void close() {
		driver.quit();
	}
}
