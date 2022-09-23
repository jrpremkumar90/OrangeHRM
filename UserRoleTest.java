package com.qa.test;

import org.apache.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;
import com.qa.pages.Loginpage;
import com.qa.pages.Userpage;

public class UserRoleTest extends BaseClass{
	     
	   Logger logger = Logger.getLogger(UserRoleTest.class);
	    
	    public void movetouser() {
		logger.info("Clicking the admin link");	
		Actions actions = new Actions(driver);
		actions.moveToElement(Userpage.adminlink);
		actions.moveToElement(Userpage.usermgmtlink);
		actions.moveToElement(Userpage.userlink);
		actions.click().build().perform();
	    }
		public void selectrole() {
			logger.info("Selecting Admin role");
		Select select = new Select(Userpage.userrole);
		select.selectByIndex(1);
		}
	
	    public void selectstatus() { 
	    	logger.info("Selecting Enabled status");
		Select select1 = new Select(Userpage.userstatus);
		select1.selectByIndex(1);
	    }
	    @Test
		public void verifyuserrole() {
	    test= reports.createTest("Verify User Role Test");
		PageFactory.initElements(driver, Userpage.class);
		movetouser();
		selectrole();
		selectstatus();
		Userpage.search.click();
		String actualrole = Userpage.role.getText();
		String actualstatus= Userpage.status.getText();
		Assert.assertEquals(actualrole, "Admin");
		Assert.assertEquals(actualstatus, "Enabled");
	}
}

