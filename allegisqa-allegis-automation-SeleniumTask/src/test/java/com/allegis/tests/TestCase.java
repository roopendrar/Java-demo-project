package com.allegis.tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.allegis.pages.HomePage;
import com.allegis.pages.LoginAccount;
import com.allegis.pages.RegestrationSucessfull;
import com.allegis.pages.BillingInformation;
import com.allegis.pages.SearchFunctionality;
import com.allegis.pages.ShoppingCart;
import com.allegis.pages.Contactus;
import com.allegis.pages.Blogs;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


/**
 * @author acer
 * This class contains test methods for YOUR SHOP
 */
public class TestCase extends TestBase {
	
	ExtentHtmlReporter htmlreports = new ExtentHtmlReporter(
			"C:\\Users\\acer\\eclipse-workspace\\allegisqa-allegis-automation-SeleniumTask\\src\\main\\resources\\html\\TestCase1report.html");
	ExtentReports extent = new ExtentReports();

	
	
	@Test(priority = 1, enabled = true, description = "login Account with user credentials")
	public void LoginAccount() throws IOException {
		
		//creating the objects for the class required for the testcase method.
		HomePage homepage = new HomePage(driver);
		LoginAccount login = new LoginAccount(driver);
		RegestrationSucessfull regs = new RegestrationSucessfull(driver);
		WebDriverWait wait = new WebDriverWait(driver, 90);

		//adding the extent html reports
		extent.attachReporter(htmlreports);
		ExtentTest test = extent.createTest("Login Account");

		//Navigation to the Homepage
		wait.until(ExpectedConditions.visibilityOf(homepage.AcceptCookies));
		homepage.AcceptCookies();
		wait.until(ExpectedConditions.visibilityOf(homepage.Account));
		homepage.Account();
	//	wait.until(ExpectedConditions.visibilityOf(homepage.AcceptCookies));
	//	homepage.AcceptCookies();
		login.username();
		Reporter.log("email added successfully");
		login.password();
		Reporter.log("password added successfully");
		login.login();
		

		Reporter.log("login sucessfully");

		
		test.log(Status.INFO, "Account login sucessfully");
		extent.flush();
		driver.close();
	}
	
	
/*
	@Test(priority = 2, enabled = true, description = "Billing Information to his Account")
	public void BillingInformation() throws IOException {
		
		//creating the objects for the class required for the testcase method.
		HomePage homepage = new HomePage(driver);

		ShoppingCart cart = new ShoppingCart(driver);
		BillingInformation billinginfo = new BillingInformation(driver);
		WebDriverWait wait = new WebDriverWait(driver, 90);

		//adding the extent html reports
		extent.attachReporter(htmlreports);
		ExtentTest test = extent.createTest("Adding new address");

		//Navigation to the Homepage.
		wait.until(ExpectedConditions.visibilityOf(homepage.AcceptCookies));
		homepage.AcceptCookies();
		wait.until(ExpectedConditions.visibilityOf(homepage.ShoppingCart));
		homepage.ShoppingCart();
	    cart.Buy();
	    cart.Coupon();
	    cart.ApplyCoupon();
	    cart.Continue();
	    wait.until(ExpectedConditions.visibilityOf(homepage.ShoppingCart));
	    billinginfo.firstname();
	    billinginfo.lastname();
	    billinginfo.email();
	    billinginfo.Company();
	    billinginfo.phone();
	    billinginfo.Address();
	    billinginfo.country();
	    billinginfo.city();
	    billinginfo.zipcode();
	    billinginfo.Sameasbilling();
	    billinginfo.Continue();
		Reporter.log("Billing Information entered successfully");
		test.log(Status.INFO, "New address added successfully");
		extent.flush();
		driver.close();
	}
	
	
	
	@Test(priority = 3, enabled = true, description = "Shopping to product")
	public void ShoppingCart() throws IOException, InterruptedException {
		
		//creating the objects for the class required for the testcase method.
		HomePage homepage = new HomePage(driver);
		ShoppingCart cart = new ShoppingCart(driver);
		WebDriverWait wait = new WebDriverWait(driver, 90);

		//adding the extent html reports
		extent.attachReporter(htmlreports);
		ExtentTest test = extent.createTest("Shopping Product");
	
		//Navigation to the Homepage
		wait.until(ExpectedConditions.visibilityOf(homepage.AcceptCookies));
		homepage.AcceptCookies();
		wait.until(ExpectedConditions.visibilityOf(homepage.ShoppingCart));
		homepage.ShoppingCart();
        cart.Buy();
        cart.Coupon();
        cart.ApplyCoupon();
        cart.Continue();
		Reporter.log("Shopping Cart product");
		Thread.sleep(5000);

		test.log(Status.INFO, "buy a product successfully");
		extent.flush();
		driver.close();
	}

	
	
	@Test(priority = 4, enabled = false, description = "SearchFunctionality to product")
	public void SearchFunctionality() throws IOException, InterruptedException {
		
		//creating the objects for the class required for the testcase method.
		HomePage homepage = new HomePage(driver);
		SearchFunctionality search = new SearchFunctionality(driver);

		WebDriverWait wait = new WebDriverWait(driver, 90);

		//adding the extent html reports
		extent.attachReporter(htmlreports);
		ExtentTest test = extent.createTest("search products");

		Reporter.log("saerching teli craft product");
		

		//Navigation to the Homepage
		wait.until(ExpectedConditions.visibilityOf(homepage.AcceptCookies));
		homepage.AcceptCookies();;
		wait.until(ExpectedConditions.visibilityOf(homepage.Search));
		homepage.Search();
		search.SearchText();
		search.ClickSearch();
		
		String title1 = driver.getTitle();
		Assert.assertEquals(title1, "telidev craft");

		Reporter.log("saerched product successfully");

		test.log(Status.INFO, "saerched product sucessfully");
		extent.flush();
		driver.close();
	}

	
	
	@Test(priority = 5, enabled = true, description = "Contact us to support team")
	public void addtocart() throws IOException {
		
		//creating the objects for the class required for the testcase method.
		HomePage homepage = new HomePage(driver);
		Contactus contactus = new Contactus(driver);
		WebDriverWait wait= new WebDriverWait(driver, 60);

		//adding the extent html reports
		extent.attachReporter(htmlreports);
		ExtentTest test = extent.createTest("contact us to suppport team");
		

		Reporter.log("Add HP laptop 3065 to the shopping cart");

		
		//Navigation to the Homepage
		wait.until(ExpectedConditions.visibilityOf(homepage.AcceptCookies));
		homepage.AcceptCookies();
		wait.until(ExpectedConditions.visibilityOf(homepage.Contactus));
		homepage.Contactus();
		
		contactus.Selecthelp();
		contactus.generalinquires();
		contactus.SelectProduct();
		contactus.DevCraft();
		contactus.firstname();
		contactus.lastname();
		contactus.email();
		contactus.Company();
		contactus.country();
		contactus.India();
		contactus.Phonenumber();
		contactus.Comments();
		contactus.Contact();
		Reporter.log("contactus successfully");


		test.log(Status.INFO, "Contactus successfully");
		extent.flush();
		driver.close();
	}

	
	
	@Test(priority = 6, enabled = true, description = "Reading Blogs ")
	public void wishlist() throws IOException {
		
		//creating the objects for the class required for the testcase method.
		HomePage homepage = new HomePage(driver);
		Blogs blogs = new Blogs(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, 60);

		//adding the extent html reports
		extent.attachReporter(htmlreports);
		ExtentTest test = extent.createTest("Reading Blogs");

		Reporter.log("reading a blog");

		
		
		wait.until(ExpectedConditions.visibilityOf(homepage.AcceptCookies));
		homepage.AcceptCookies();;
		wait.until(ExpectedConditions.visibilityOf(homepage.Blogs));
		homepage.Blogs();

		blogs.Testing();
		blogs.Testingblog();
	
		wait.until(ExpectedConditions.visibilityOf(blogs.Title));
		blogs.Title();
		Assert.assertEquals(blogs.Title.getText(), "Your Account Has Been Created!");
		

		Reporter.log("Palm Treo pro is added successfully to the wishlist and success message is displayed ");

		test.log(Status.INFO, "Palm Treo pro phone added successfully to the wishlist");
		extent.flush();
		driver.close();
	}

	
*/
}