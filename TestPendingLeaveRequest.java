package com.qa.test;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.qa.base.BaseClass;
import com.qa.pages.DashboardPage;
import com.qa.pages.Loginpage;

public class TestPendingLeaveRequest extends BaseClass{
	String actualmessage=null;
    Logger logger = Logger.getLogger(TestPendingLeaveRequest.class);
	
	public void login() {

		PageFactory.initElements(driver, Loginpage.class);
        logger.info("Logging into the aplication");
		Loginpage.username.sendKeys(properties.getProperty("username"));
		Loginpage.password.sendKeys(properties.getProperty("password"));
		Loginpage.submit.click();
	}
	
	public void getpendingLeaverequest() {
		PageFactory.initElements(driver, DashboardPage.class);
		actualmessage = DashboardPage.leaverequest.getText();
	
	}
	@Test
	public void verifypendingleaverequest()
	{
		test= reports.createTest("Login Test");
		login();
		getpendingLeaverequest();
		Assert.assertEquals(actualmessage, "No Records are Available");
	}


}

