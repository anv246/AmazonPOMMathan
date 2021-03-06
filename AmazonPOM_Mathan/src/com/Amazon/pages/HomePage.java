package com.Amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.TestCase.HomePage_TestCase;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import utilites.Wrapper;

public class HomePage {
	
	By searchTextBox = By.xpath("//*[@id='twotabsearchtextbox']");
	By signInLink = By.xpath("//a[contains(@id,'nav-link')]/*[contains(text(),'Sign in')]");
	HomePage_TestCase oHome;
	private WebDriver driver;
	static Wrapper oWrapper;
	ExtentReports logger;
		public HomePage(WebDriver driver) {
		this.driver = driver;
		oWrapper = new Wrapper(driver);
		logger = new ExtentReports();
		logger.init("./Report/Amazon_Application.html", false);
	}
	
public void Home_Page_Title() { 
		
	logger.startTest("Amazon Title Validation", "Validating the Amazon Title");
		
		String sTitle = oWrapper.getPageTitle();
		System.out.println("Page title is : " + sTitle);
		if(sTitle.contains("Amazon")){
			System.out.println("User Reaches to the Amazon Home Page");
			logger.log(LogStatus.PASS,"User Reaches to the Amazon Home Page");
		}else{
			System.out.println("Amazon home page is not loaded");
			logger.log(LogStatus.FAIL,"User Not Reaches to the Amazon Home Page");
		}
	logger.endTest();
	}

public void clickSignOn(){
	logger.startTest("Home Page UI Validation", "Validate the Element Presence in Home Page");
	oWrapper.waituntilVisible(searchTextBox,10);
	boolean search_Textbox = oWrapper.verifyElementpresent(searchTextBox);
	oWrapper.waituntilVisible(signInLink, 30);
	boolean signon_Link = oWrapper.verifyElementpresent(signInLink);
	if(search_Textbox==true){
		logger.log(LogStatus.PASS,"Search Textbox is presence in Amazon Home Page");
	}else{
		logger.log(LogStatus.FAIL,"Search Textbox is not presence in Amazon Home Page");
	}
	
	if(signon_Link==true){
		logger.log(LogStatus.PASS,"Sign-In Link is presence in Amazon Home Page");
		oWrapper.clickElement(signInLink);
	}else{
		logger.log(LogStatus.FAIL,"Sign-In Link is not presence in Amazon Home Page");
	}
	logger.endTest();
	
	
}



}
