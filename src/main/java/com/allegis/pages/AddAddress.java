package com.allegis.pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import datautils.UpdatedReadExcel;

public class AddAddress extends DriverClass {

	@FindBy(css = "input#input-firstname")
	public WebElement firstname;

	@FindBy(css = "input#input-lastname")
	public WebElement lastname;

	@FindBy(css = "input[id='input-company']")
	public WebElement company;

	@FindBy(css = "input#input-address-1.form-control")
	public WebElement address1;

	@FindBy(css = "input[id='input-city']")
	public WebElement city;

	@FindBy(css = "input[name='postcode']")
	public WebElement postcode;

	@FindBy(css = "select[name='country_id']")
	public WebElement selectcountry;
	
	public void country(WebDriver driver) {
		Select cc = new Select(selectcountry);
		cc.selectByVisibleText("United Kingdom");
		}

	/*
	 * @FindBy(xpath =
	 * "//select[@id='input-country' and @class='form-control']//option[@value='222']"
	 * ) public WebElement country;
	 */

	@FindBy(css = "select[class='form-control'][name='zone_id']")
	public WebElement selectstate;
	
	public void state(WebDriver driver) {
		Select ss = new Select(selectstate);
		ss.selectByValue("3513");
		}
	/*
	 * @FindBy(xpath =
	 * "//select[@id='input-zone' and @class='form-control']//option[@value='3513']"
	 * ) public WebElement state;
	 */

	@FindBy(css = "input[value='Continue']")
	public WebElement continuebtn;

	public AddAddress(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/*
	 * List<String> testData = new ArrayList<String>(); ReadExcel dataObj = new
	 * ReadExcel();
	 */
	JavascriptExecutor jss = (JavascriptExecutor) driver;

	public void fname() {

		try {
			 List<Map<String, String>> testDataupdated = UpdatedReadExcel.readstringdata();
			firstname.sendKeys(testDataupdated.get(0).get("firstname"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void lname() {

		try {
			 List<Map<String, String>> testDataupdated = UpdatedReadExcel.readstringdata();
			lastname.sendKeys(testDataupdated.get(0).get("lastname"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void companyname() {

		try {
			 List<Map<String, String>> testDataupdated = UpdatedReadExcel.readstringdata();
			company.sendKeys(testDataupdated.get(0).get("companyname"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setaddress1() {

		try {
			 List<Map<String, String>> testDataupdated = UpdatedReadExcel.readstringdata();
			address1.sendKeys(testDataupdated.get(0).get("permanentaddress"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setcity() {

		try {
			 List<Map<String, String>> testDataupdated = UpdatedReadExcel.readstringdata();
			city.sendKeys(testDataupdated.get(0).get("city"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void postcode() {

		try {
			 List<Map<String, String>> testDataupdated = UpdatedReadExcel.readstringdata();
			postcode.sendKeys(testDataupdated.get(0).get("postcode"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void selectcountry() {
		try {
			selectcountry.click();
			//jss.executeScript("arguments[0].click();", selectcountry);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * public void countryname() { try { //country.click();
	 * jss.executeScript("arguments[0].click();", country); } catch (Exception e) {
	 * // TODO Auto-generated catch block e.printStackTrace(); } }
	 */

	public void selectstate() {
		try {
			selectstate.click();
			//jss.executeScript("arguments[0].click();", selectstate);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * public void statename() { try { //state.click();
	 * jss.executeScript("arguments[0].click();", state); } catch (Exception e) { //
	 * TODO Auto-generated catch block e.printStackTrace(); } }
	 */

	public void continuebutton() {
		try {
			continuebtn.click();
			//jss.executeScript("arguments[0].click();", continuebtn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
