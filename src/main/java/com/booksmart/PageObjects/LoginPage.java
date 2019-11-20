package com.booksmart.PageObjects;

import org.apache.log4j.xml.DOMConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.booksmart.Utilities.ProjProperties;
import com.booksmart.Utilities.SeleniumLib;
import com.booksmart.Utilities.Sync;

public class LoginPage {
		
	By username= By.id("identifierId");
	By password= By.id("PASSWORD");
	By signon= By.id("NEXT");
	
	final public static Logger logger = LogManager.getLogger(LoginPage.class);
	
	public LoginPage() {
		SeleniumLib.initdriver();
		DOMConfigurator.configure("log4j2.xml");
	}
	
	public void login() throws Exception {
		setUsername(com.booksmart.Utilities.ProjProperties.getProperty(ProjProperties.UNAME));
		setPassword(com.booksmart.Utilities.ProjProperties.getProperty(ProjProperties.PWD));
		clickLogin();
		LoginPage.logger.error("Log4j initiated");
	}
	
	public void setUsername(String userName) throws Exception {
		SeleniumLib.textBoxInput(username,userName);
		LoginPage.logger.error("Log4j initiated");
	}
	
	public void setPassword(String passWord) throws Exception {
		SeleniumLib.textBoxInput(password,passWord);
	}
	
	public void clickLogin() throws Exception {
		SeleniumLib.click(signon);
	}
	
	public void driverclose() throws Exception {
		SeleniumLib.driverquit();
	}

}
