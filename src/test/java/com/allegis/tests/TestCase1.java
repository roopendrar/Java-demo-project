package com.allegis.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.allegis.pages.AddAddress;
import com.allegis.pages.AdressBookEntries;
import com.allegis.pages.AppleCinema;
import com.allegis.pages.CheckoutPage;
import com.allegis.pages.ComponentsPage;
import com.allegis.pages.ConfirmationPage;
import com.allegis.pages.DesktopsPage;
import com.allegis.pages.HomePage;
import com.allegis.pages.LaptopPage;
import com.allegis.pages.LoginPage;
import com.allegis.pages.MonitorsPage;
import com.allegis.pages.PalmPhone;
import com.allegis.pages.PhonesPage;
import com.allegis.pages.SamsungMonitorPage;
import com.allegis.pages.ShoppingCart;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import datautils.ReadExcel2;
import datautils.UpdatedReadExcel;


/**
 * 	
 * This class contains test methods for YOUR SHOP
 */

@Listeners(ListenersClass.class)

public class TestCase1 extends TestBase {
	
	ExtentHtmlReporter htmlreports = new ExtentHtmlReporter(
			"C:\\Users\\ror\\eclipse-workspace\\allegisqa-allegis-automation-SeleniumTask\\src\\main\\resources\\html\\TestCase1report.html");
	ExtentReports extent = new ExtentReports();

	
	@DataProvider(name ="excel-data")
  	public Object[][] excelDP() throws IOException{
        	Object[][] arrObj = ReadExcel2.getExcelData();
        	return arrObj;
  	}
	
	//Used keyboard actions and fluent waits
	@Test(priority = 1, enabled = false, description = "Registration of account in YourShop website by giving all the user credentials", dataProvider="excel-data")
	public void registration(String firstname, String lastname, String emailid,String phonenumber,
			String password, String confirmpassword) throws IOException {
		
		//creating the objects for the class required for the testcase method.
		HomePage homepage = new HomePage(driver);
		//RegisterAccount account = new RegisterAccount(driver);
		ConfirmationPage confirmpage = new ConfirmationPage(driver);
		 List<Map<String, String>> testDataupdated = UpdatedReadExcel.readstringdata();
			Actions action=new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 90);

		//adding the extent html reports
		extent.attachReporter(htmlreports);
		ExtentTest test = extent.createTest("Account Registration");

		//Navigation to the Homepage
		wait.until(ExpectedConditions.visibilityOf(homepage.myaccount));
		homepage.myaccountbtn();
		wait.until(ExpectedConditions.visibilityOf(homepage.register));
		homepage.registerbtn();
		String title = driver.getTitle();
		Assert.assertEquals(title, "Register Account");
		
		

		Reporter.log("Creating a account in YourShop website");

		
		//Enter the required credentials to Register the account
		/*
		 * wait.until(ExpectedConditions.visibilityOf(account.firstname));
		 * account.setfname(); Reporter.log("firstname added successfully");
		 * account.setlname(); Reporter.log("lastname added successfully");
		 * account.setmail(); Reporter.log("email added successfully");
		 * account.setphnumber(); Reporter.log("mobile number added successfully");
		 * account.setpassword(); Reporter.log("password added successfully");
		 * account.confirmpsw(); Reporter.log("password confirmed  successfully");
		 */
		//account.createaccountkeyevent();
		
		
		//keyborad actions
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		  "//input[@id='input-firstname']")));
		  driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys(
		  testDataupdated.get(0).get("firstname"));
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
		 
			/*
			 * wait.until(ExpectedConditions.visibilityOf(account.privacypolicy));
			 * account.clickprivacy();
			 * wait.until(ExpectedConditions.visibilityOf(account.continuebutton));
			 * account.clickcontinue();
			 */
		wait.until(ExpectedConditions.visibilityOf(confirmpage.confirmtext));
		Assert.assertEquals(confirmpage.confirmtext.getText(), "Your Account Has Been Created!");
		

		Reporter.log("Account Created Successfully in yourShop Website");

		
		test.log(Status.INFO, "Account Created successfully");
		extent.flush();
		driver.close();
	}
	
	
	//dropdown select
	@Test(priority = 2, enabled = false, description = "Adding address to the account holder by logging into his account")
	public void address() throws IOException {
		
		//creating the objects for the class required for the testcase method.
		HomePage homepage = new HomePage(driver);
		LoginPage logpage = new LoginPage(driver);
		AddAddress address = new AddAddress(driver);
		AdressBookEntries ade = new AdressBookEntries(driver);
		WebDriverWait wait = new WebDriverWait(driver, 90);

		//adding the extent html reports
		extent.attachReporter(htmlreports);
		ExtentTest test = extent.createTest("Adding new address");

		//Navigation to the Homepage.
		wait.until(ExpectedConditions.visibilityOf(homepage.myaccount));
		homepage.myaccountbtn();
		wait.until(ExpectedConditions.visibilityOf(homepage.login));
		homepage.loginbtn();
		String title1 = driver.getTitle();
		Assert.assertEquals(title1, "Account Login");

		//Login into the account.
		wait.until(ExpectedConditions.visibilityOf(logpage.loginmail));
		logpage.setusername();
		logpage.setpassword();
		logpage.login();
		Reporter.log("Logged into the account successfully");

		//Page to add the new address.
		wait.until(ExpectedConditions.visibilityOf(ade.address));
		ade.address();
		wait.until(ExpectedConditions.visibilityOf(ade.newaddress));
		ade.newaddressbtn();
		String title2 = driver.getTitle();
		Assert.assertEquals(title2, "Address Book");

		//Adding the address to the Registered account.
		wait.until(ExpectedConditions.visibilityOf(address.firstname));
		Reporter.log("Adding address to the account");
		address.fname();
		address.lname();
		address.companyname();
		address.setaddress1();
		address.setcity();
		address.postcode();
		address.selectcountry();
		address.country(driver);
		/*
		 * wait.until(ExpectedConditions.visibilityOf(address.country));
		 * address.countryname();
		 */		
		address.selectstate();
		address.state(driver);
		/*
		 * wait.until(ExpectedConditions.visibilityOf(address.state));
		 * address.statename();
		 */		
		
		address.continuebutton();
		wait.until(ExpectedConditions.visibilityOf(ade.successtext));
		Assert.assertEquals(ade.successtext.getText(), "Your address has been successfully added");

		Reporter.log("Address added Successfully in yourShop Website");

		test.log(Status.INFO, "New address added successfully");
		extent.flush();
		driver.close();
	}
	
	
	//unchanged
	@Test(priority = 3, enabled = true, description = "Logging into the account")
	public void login() throws IOException, InterruptedException {
		
		//creating the objects for the class required for the testcase method.
		HomePage homepage = new HomePage(driver);
		LoginPage logpage = new LoginPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 90);

		//adding the extent html reports
		extent.attachReporter(htmlreports);
		ExtentTest test = extent.createTest("Looging functionality");
	
		//Navigation to the Homepage
		wait.until(ExpectedConditions.visibilityOf(homepage.myaccount));
		homepage.myaccountbtn();
		wait.until(ExpectedConditions.visibilityOf(homepage.login));
		homepage.loginbtn();
		String title1 = driver.getTitle();
		Assert.assertEquals(title1, "Account Login");

		
		//Enter the login credentials
		wait.until(ExpectedConditions.visibilityOf(logpage.loginmail));
		logpage.setusername();
		Reporter.log("email added successfully");
		logpage.setpassword();
		Reporter.log("password added successfully");
		logpage.login();
		Reporter.log("Logged into the account successfully");
		Thread.sleep(5000);

		test.log(Status.INFO, "Logged into the account successfully");
		extent.flush();
		driver.close();
	}

	
	//unchanged
	@Test(priority = 4, enabled = false, description = "Check the availability of the Apple cinema 30")
	public void availability() throws IOException, InterruptedException {
		
		//creating the objects for the class required for the testcase method.
		HomePage homepage = new HomePage(driver);
		LoginPage logpage = new LoginPage(driver);
		AdressBookEntries ade = new AdressBookEntries(driver);
		AppleCinema applecinema = new AppleCinema(driver);
		ShoppingCart shop = new ShoppingCart(driver);
		WebDriverWait wait = new WebDriverWait(driver, 90);

		//adding the extent html reports
		extent.attachReporter(htmlreports);
		ExtentTest test = extent.createTest("checking the availability of Apple cinema 30");

		Reporter.log("Check Apple cinema 30 is available in stock.?");
		

		//Navigation to the Homepage
		wait.until(ExpectedConditions.visibilityOf(homepage.myaccount));
		homepage.myaccountbtn();
		wait.until(ExpectedConditions.visibilityOf(homepage.login));
		homepage.loginbtn();
		String title1 = driver.getTitle();
		Assert.assertEquals(title1, "Account Login");

		//Login into the account
		wait.until(ExpectedConditions.visibilityOf(logpage.loginmail));
		logpage.setusername();
		logpage.setpassword();
		logpage.login();
		Reporter.log("Logged into the account successfully");

		//Assertion of the homepage.
		wait.until(ExpectedConditions.visibilityOf(ade.home));
		ade.homebtn();
		String title2 = driver.getTitle();
		Assert.assertEquals(title2, "Your Store");

		//Assertion of the applecinema 30" page.
		wait.until(ExpectedConditions.visibilityOf(homepage.applecinema));
		homepage.applecinemabtn();
		String title3 = driver.getTitle();
		Assert.assertEquals(title3, "Apple Cinema 30");

		applecinema.radiobtn();
		applecinema.checkbox1();
		applecinema.checkbox2();
		applecinema.selectcolor();
		applecinema.yellowcolor();
		applecinema.textbox();
		wait.until(ExpectedConditions.visibilityOf(applecinema.uploadfile));
		applecinema.fileupload();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.switchTo().alert().accept();
		applecinema.addtocart();
		wait.until(ExpectedConditions.visibilityOf(applecinema.successtext));
		Assert.assertEquals(applecinema.successtext.getText(),
				"Success: You have added Apple Cinema 30\" to your shopping cart!");
		applecinema.successtext();

		wait.until(ExpectedConditions.visibilityOf(shop.availabilitytext));
		shop.availabilitytext.getText();
		Assert.assertEquals(shop.availabilitytext.getText(),
				" Products marked with *** are not available in the desired quantity or not in stock!");

		Reporter.log("The apple product Apple cinema 30 is not currently available in stock checked successfully");

		test.log(Status.INFO, "New address added successfully");
		extent.flush();
		driver.close();
	}

	
	//unchanged
	@Test(priority = 5, enabled = false, description = "Add HP laptop3065 to the shopping cart")
	public void addtocart() throws IOException {
		
		//creating the objects for the class required for the testcase method.
		HomePage homepage = new HomePage(driver);
		LoginPage logpage = new LoginPage(driver);
		AdressBookEntries ade = new AdressBookEntries(driver);
		DesktopsPage deskpage = new DesktopsPage(driver);
		LaptopPage lappage = new LaptopPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 60);

		//adding the extent html reports
		extent.attachReporter(htmlreports);
		ExtentTest test = extent.createTest("Adding Hplaptop to shopping cart");

		Reporter.log("Add HP laptop 3065 to the shopping cart");

		
		//Navigation to the Homepage
		wait.until(ExpectedConditions.visibilityOf(homepage.myaccount));
		homepage.myaccountbtn();
		wait.until(ExpectedConditions.visibilityOf(homepage.login));
		homepage.loginbtn();
		String title1 = driver.getTitle();
		Assert.assertEquals(title1, "Account Login");

		
		//Login into the account
		wait.until(ExpectedConditions.visibilityOf(logpage.loginmail));
		logpage.setusername();
		logpage.setpassword();
		logpage.login();
		Reporter.log("Logged into the account successfully");

		
		//Assertion of homepage
		wait.until(ExpectedConditions.visibilityOf(ade.home));
		ade.homebtn();
		String title2 = driver.getTitle();
		Assert.assertEquals(title2, "Your Store");

		wait.until(ExpectedConditions.visibilityOf(homepage.desktops));
		homepage.desktopsbtn();
		homepage.allcomponentsbtn();
		
		wait.until(ExpectedConditions.visibilityOf(deskpage.hplaptop));
		deskpage.hplaptop();

		wait.until(ExpectedConditions.visibilityOf(lappage.addtoshop));
		lappage.addtoshop();

		wait.until(ExpectedConditions.visibilityOf(lappage.lapconfirm));
		lappage.lapconfirm.getText();
		Assert.assertTrue(lappage.lapconfirm.isDisplayed());

		Reporter.log("The laptop HP3065 added successfully to the cart");

		test.log(Status.INFO, "laptop added to the cart successfully");
		extent.flush();
		driver.close();
	}

	
	//action classes
	@Test(priority = 6, enabled = false, description = "By changes some filter methods the phone Palm Treo pro should be added to the wishlist")
	public void wishlist() throws IOException {
		
		//creating the objects for the class required for the testcase method.
		HomePage homepage = new HomePage(driver);
		LoginPage logpage = new LoginPage(driver);
		AdressBookEntries ade = new AdressBookEntries(driver);
		PhonesPage phones = new PhonesPage(driver);
		PalmPhone palmphone = new PalmPhone(driver);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		Actions action=new Actions(driver);

		//adding the extent html reports
		extent.attachReporter(htmlreports);
		ExtentTest test = extent.createTest("Adding palmtreo phone to wishlist");

		Reporter.log("Add palm treo pro phone to wish list");

		
		//Navigation to the Homepage
		wait.until(ExpectedConditions.visibilityOf(homepage.myaccount));
		homepage.myaccountbtn();
		wait.until(ExpectedConditions.visibilityOf(homepage.login));
		homepage.loginbtn();
		String title1 = driver.getTitle();
		Assert.assertEquals(title1, "Account Login");

		//Login into the account
		wait.until(ExpectedConditions.visibilityOf(logpage.loginmail));
		logpage.setusername();
		logpage.setpassword();
		logpage.login();
		Reporter.log("Logged into the account successfully");

		
		//Assertion of homepage
		wait.until(ExpectedConditions.visibilityOf(ade.home));
		ade.homebtn();
		String title2 = driver.getTitle();
		Assert.assertEquals(title2, "Your Store");

		wait.until(ExpectedConditions.visibilityOf(homepage.phonespda));
		homepage.phonespdabtn();

		wait.until(ExpectedConditions.visibilityOf(phones.list));
		phones.listbtn();
		Reporter.log("view changed from grid to list");
		phones.sortbybtn();
		//action.moveToElement(phones.lowtohigh).perform();
		phones.lowtohigh();
		Reporter.log("cost changed to low-high");
		phones.showbtn();
		//action.moveToElement(phones.fifty).perform();
		phones.fifty();
		wait.until(ExpectedConditions.visibilityOf(phones.mobile));
		phones.mobile();

		palmphone.wishlistbtn();
		wait.until(ExpectedConditions.visibilityOf(palmphone.phonesuccesstext));
		palmphone.successtext();
		Assert.assertTrue(palmphone.phonesuccesstext.isDisplayed());

		Reporter.log("Palm Treo pro is added successfully to the wishlist and success message is displayed ");

		test.log(Status.INFO, "Palm Treo pro phone added successfully to the wishlist");
		extent.flush();
		driver.close();
	}

	
	//action class and java csript executor
	@Test(priority = 7, enabled = false, description = "Comparison of Apple cinema30 and Samsung monitor")
	public void productcomparision() throws IOException {
		
		//creating the objects for the class required for the testcase method.
		HomePage homepage = new HomePage(driver);
		LoginPage logpage = new LoginPage(driver);
		AdressBookEntries ade = new AdressBookEntries(driver);
		ComponentsPage components = new ComponentsPage(driver);
		MonitorsPage monitors = new MonitorsPage(driver);
		AppleCinema apple = new AppleCinema(driver);
		SamsungMonitorPage samsung = new SamsungMonitorPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		Actions action=new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
       

		

		//adding the extent html reports
		extent.attachReporter(htmlreports);
		ExtentTest test = extent.createTest("Adding two products to the comparelist");

		Reporter.log("Add Apple cinema 30 and samsung monitor to the  comparelist");

		
		//Navigation to the Homepage
		wait.until(ExpectedConditions.visibilityOf(homepage.myaccount));
		homepage.myaccountbtn();
		wait.until(ExpectedConditions.visibilityOf(homepage.login));
		homepage.loginbtn();
		String title1 = driver.getTitle();
		Assert.assertEquals(title1, "Account Login");

		//login into the account
		wait.until(ExpectedConditions.visibilityOf(logpage.loginmail));
		logpage.setusername();
		logpage.setpassword();
		logpage.login();
		Reporter.log("Logged into the account successfully");

		//Assertion of homepage.
		wait.until(ExpectedConditions.visibilityOf(ade.home));
		ade.homebtn();
		String title2 = driver.getTitle();
		Assert.assertEquals(title2, "Your Store");

		homepage.currencybtn();
		action.moveToElement(homepage.pound).perform();
		homepage.poundsbtn();
		Reporter.log("The currency changed to pounds");

		//Adding apple cinema 30" to the compared list.
		wait.until(ExpectedConditions.visibilityOf(homepage.components));
		homepage.componentsbtn();
		//action.moveToElement(homepage.allcomponents).perform();
		homepage.showallbtn();
		wait.until(ExpectedConditions.visibilityOf(components.monitorlist));
		components.monitorlistbtn();
		wait.until(ExpectedConditions.visibilityOf(monitors.applemonitor));
		js.executeScript("arguments[0].scrollIntoView();", monitors.applemonitor);
		monitors.applemonitorbtn();
		wait.until(ExpectedConditions.visibilityOf(apple.appcomparebtn));
		apple.comparebtn();
		wait.until(ExpectedConditions.visibilityOf(apple.productcomparetext));
		apple.comparedtext();
		Assert.assertTrue(apple.productcomparetext.isDisplayed());
		Reporter.log("Apple cinema 30 added successfully to the compare list");
		driver.navigate().back();
		String title3 = driver.getTitle();
		Assert.assertEquals(title3, "Monitors");

		
		//Adding samsung monitor to the compare list.
		wait.until(ExpectedConditions.visibilityOf(monitors.samsungmonitor));
		js.executeScript("arguments[0].scrollIntoView();", monitors.samsungmonitor);
		monitors.samsungmonitorbtn();
		wait.until(ExpectedConditions.visibilityOf(samsung.samcomparebutton));
		samsung.samsungcomparebtn();
		wait.until(ExpectedConditions.visibilityOf(samsung.samcomparebuttontext));
		samsung.samcomparebuttontext.getText();
		Assert.assertTrue(samsung.samcomparebuttontext.isDisplayed());
		Reporter.log("samsung monitor added successfully to the compare list");
		driver.navigate().back();
		String title4 = driver.getTitle();
		Assert.assertEquals(title4, "Monitors");

		wait.until(ExpectedConditions.visibilityOf(monitors.productcompare));
		monitors.productcomparebtn();
		String title5 = driver.getTitle();
		Assert.assertEquals(title5, "Product Comparison");

		Reporter.log("Apple cinema 30 monitor and samsung monitor compared successfully");

		test.log(Status.INFO, "Two products added successfully to the compare list");
		extent.flush();
		driver.close();
	}

	
	
	//action class and js executor
	@Test(priority = 8, enabled = false, description = "search a new Samsung SyncMaster 941BW  and confirm the order and verify the confirm text")
	public void confirmorder() throws IOException {
		
		//creating the objects for the class required for the testcase method.
		HomePage homepage = new HomePage(driver);
		LoginPage logpage = new LoginPage(driver);
		AdressBookEntries ade = new AdressBookEntries(driver);
		SamsungMonitorPage samsung = new SamsungMonitorPage(driver);
		ShoppingCart shopcart = new ShoppingCart(driver);
		CheckoutPage checkout = new CheckoutPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions action=new Actions(driver);

		//adding the extent html reports
		extent.attachReporter(htmlreports);
		ExtentTest test = extent.createTest("Search and order Samsung SyncMaster 941BW");

		Reporter.log("Order a new Samsung SyncMaster 941BW confirm the order and verify the confirm text");

		
		//Navigation to the Homepage
		wait.until(ExpectedConditions.visibilityOf(homepage.myaccount));
		homepage.myaccountbtn();
		wait.until(ExpectedConditions.visibilityOf(homepage.login));
		homepage.loginbtn();
		String title1 = driver.getTitle();
		Assert.assertEquals(title1, "Account Login");

		//Login into the account.
		wait.until(ExpectedConditions.visibilityOf(logpage.loginmail));
		logpage.setusername();
		logpage.setpassword();
		logpage.login();
		Reporter.log("Logged into the account successfully");

		//Assertion of the homepage.
		wait.until(ExpectedConditions.visibilityOf(ade.home));
		ade.homebtn();
		String title2 = driver.getTitle();
		Assert.assertEquals(title2, "Your Store");

		//Search a samsung laptop and add to cart
		homepage.searchbar();
		homepage.searchbtn();
		wait.until(ExpectedConditions.visibilityOf(samsung.addtocart));
		String title3 = driver.getTitle();
		Assert.assertEquals(title3, "Search - Samsung SyncMaster 941BW");
		js.executeScript("arguments[0].scrollIntoView();", samsung.addtocart);
		samsung.addtocartbtn();
		wait.until(ExpectedConditions.visibilityOf(samsung.addedtext));
		samsung.addedtext.getText();
		Assert.assertTrue(samsung.addedtext.isDisplayed());
		wait.until(ExpectedConditions.visibilityOf(samsung.shoppingcart));
		action.sendKeys(Keys.PAGE_UP).build().perform();
		samsung.shoppingcartbtn();

		wait.until(ExpectedConditions.visibilityOf(shopcart.checkout));
		shopcart.finalchekout();

		//Checkout credentials
		wait.until(ExpectedConditions.visibilityOf(checkout.billing));
		String title4 = driver.getTitle();
		Assert.assertEquals(title4, "Checkout");
		checkout.billingbtn();
		wait.until(ExpectedConditions.visibilityOf(checkout.delivery));
		checkout.deliverybtn();
		wait.until(ExpectedConditions.visibilityOf(checkout.deliverymethod));
		checkout.deliverymethodbtn();
		wait.until(ExpectedConditions.visibilityOf(checkout.tcagree));
		checkout.tcbtn();
		wait.until(ExpectedConditions.visibilityOf(checkout.payment));
		checkout.paymentbtn();
		wait.until(ExpectedConditions.visibilityOf(checkout.confirmorder));
		checkout.confirmorderbtn();

		wait.until(ExpectedConditions.visibilityOf(checkout.confirmordertext));
		checkout.confirmordertext.getText();
		Assert.assertTrue(checkout.confirmordertext.isDisplayed());

		Reporter.log("Your order of Samsung SyncMaster 941BW is confirmed and the text is verified");

		test.log(Status.INFO, "Order Successfull");
		extent.flush();
		driver.close();

	}

}