package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Userpage {
    
	@FindBy(xpath = "//*[@id=\"menu_admin_viewAdminModule\"]/b")
	public static WebElement adminlink;
	@FindBy(xpath = "//*[@id=\"menu_admin_UserManagement\"]")
	public static WebElement usermgmtlink;
	@FindBy(xpath = "//*[@id=\"menu_admin_viewSystemUsers\"]")
	public static WebElement userlink;
	@FindBy(id = "searchSystemUser_userType")
	public static WebElement userrole;
	@FindBy(id = "searchSystemUser_status")
	public static WebElement userstatus;
	@FindBy(id = "searchBtn")
	public static WebElement search;
	@FindBy(xpath = "//*[@id=\"resultTable\"]/tbody/tr[1]/td[3]")
	public static WebElement role;
	@FindBy(xpath = "//*[@id=\"resultTable\"]/tbody/tr[1]/td[5]")
	public static WebElement status;
}
