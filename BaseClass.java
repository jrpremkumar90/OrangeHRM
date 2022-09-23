package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {

	public static WebDriver driver;
	public static Properties properties=null;
	public static ExtentReports reports;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentTest test;
	
	static Logger logger= Logger.getLogger(BaseClass.class);
	
	public Properties readpropertyfile() throws IOException {

		FileInputStream fileInputStream = new FileInputStream("config.properties");
		properties = new Properties();
		properties.load(fileInputStream);
		return properties;
	}

	@BeforeSuite
	public void launch() throws IOException {
		reports = new ExtentReports();
		htmlReporter = new ExtentHtmlReporter("Extentreport.html");
		reports.attachReporter(htmlReporter);
		PropertyConfigurator.configure("log4j.properties");
		//BasicConfigurator.configure();
		logger.info("OrangeHRM has begins");
		logger.info("Loading the property file");
		readpropertyfile();
		String driverlocation = properties.getProperty("driverlocation");
		String browser = properties.getProperty("browser");
		String url = properties.getProperty("url");

		System.setProperty("webdriver.chrome.driver", driverlocation);
		driver= new ChromeDriver();


		driver.manage().window().maximize();
		logger.info("Open the Application");
		driver.get(url);
	}
	
	@AfterSuite
	public void teardown() {
		logger.info("Closing the application");
		reports.flush();
	}
}
