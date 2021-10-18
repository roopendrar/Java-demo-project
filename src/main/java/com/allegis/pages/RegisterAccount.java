package com.allegis.pages;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import datautils.UpdatedReadExcel;

public class RegisterAccount extends DriverClass{
	@FindBy(css = "input[id='input-firstname']")
	public WebElement firstname;
	
	@FindBy(css = "input[id='input-lastname']")
	public WebElement lastname;

	@FindBy(css = "input[name='email']")
	public WebElement email;

	@FindBy(css = "input#input-telephone")
	public WebElement telephone;

	@FindBy(css = "input[type='password'][id='input-password']")
	public WebElement password;

	@FindBy(css = "input.form-control#input-confirm")
	public WebElement confirmpassword;

	@FindBy(css = "input[type='checkbox']")
	public WebElement privacypolicy;

	@FindBy(css = "input[class='btn btn-primary']")
	public WebElement continuebutton;

	public RegisterAccount(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/*
	 * List<String> testData = new ArrayList<String>(); ReadExcel dataObj = new
	 * ReadExcel();
	 */


	public void setfname() throws IOException {

		try {
			 List<Map<String, String>> testDataupdated = UpdatedReadExcel.readstringdata();
			firstname.sendKeys(testDataupdated.get(0).get("firstname"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setlname() {

		try {
			 List<Map<String, String>> testDataupdated = UpdatedReadExcel.readstringdata();
			lastname.sendKeys(testDataupdated.get(0).get("lastname"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setmail() {

		try {
			 List<Map<String, String>> testDataupdated = UpdatedReadExcel.readstringdata();
			email.sendKeys(testDataupdated.get(0).get("emialid"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setphnumber() {

		try {
			 List<Map<String, String>> testDataupdated = UpdatedReadExcel.readstringdata();
			telephone.sendKeys(testDataupdated.get(0).get("phonenumber"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setpassword() {
		try {
			 List<Map<String, String>> testDataupdated = UpdatedReadExcel.readstringdata();
			password.sendKeys(testDataupdated.get(0).get("password"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void confirmpsw() {

		try {
			 List<Map<String, String>> testDataupdated = UpdatedReadExcel.readstringdata();
			confirmpassword.sendKeys(testDataupdated.get(0).get("confirmpassword"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickprivacy() {
		try {
			privacypolicy.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickcontinue() {
		try {
			continuebutton.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void createaccountkeyevent() throws IOException {
		 List<Map<String, String>> testDataupdated = UpdatedReadExcel.readstringdata();
		Actions action=new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 90);
		/*
		 * Wait<WebDriver> wait=new
		 * FluentWait<WebDriver>((driver)).withTimeout(Duration.ofSeconds(60))
		 * .pollingEvery(Duration.ofSeconds(5)) .ignoring(Exception.class);
		 */
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='input-firstname']")));
		 driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys(testDataupdated.get(0).get("firstname"));
		 action.sendKeys(Keys.TAB).sendKeys(testDataupdated.get(0).get("lastname"))
		 .sendKeys(Keys.TAB).sendKeys(testDataupdated.get(0).get("emialid"))
		 .sendKeys(Keys.TAB).sendKeys(testDataupdated.get(0).get("phonenumber"))
		 .sendKeys(Keys.TAB).sendKeys(testDataupdated.get(0).get("password"))
		 .sendKeys(Keys.TAB).sendKeys(testDataupdated.get(0).get("confirmpassword"))
		 .build().perform();
		  Wait<WebDriver> wait1 = new FluentWait<WebDriver>(driver)
				  .withTimeout(Duration.ofSeconds(50))
				  .pollingEvery(Duration.ofSeconds(5))
				  .ignoring(Exception.class);
		  
		  WebElement clickprivacy=wait1.until(new Function<WebDriver, WebElement>(){
			  public WebElement apply(WebDriver driver) {
				  return driver.findElement(By.xpath("//input[@type='checkbox' and @name='agree']"));
			  }
		  });
		  
		  clickprivacy.click();
		  
		  WebElement clickcontinue=wait1.until(new Function<WebDriver, WebElement>(){
			  public WebElement apply(WebDriver driver) {
				  return driver.findElement(By.xpath("//input[@class='btn btn-primary' and @value='Continue']"));
			  }
		  });
		  
		  clickcontinue.click();
		
	}
}
