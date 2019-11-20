package com.booksmart.Utilities;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Sync {
	final public static Logger logger = LogManager.getLogger(Sync.class);
	static WebDriver driver=SeleniumLib.driver;
	public static long waitSeconds = Long.parseLong(com.booksmart.Utilities.ProjProperties.getProperty(ProjProperties.waitTIME));

	public static void waitforPageLoad(long time) throws Exception {
		try{
			driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);}
		catch(Exception e){
			e.printStackTrace();
			//Driver.getLogger().info("waitPageLoad  is throwing exception ");
		}
	}
	public static void waitforPageLoad() throws Exception {
		try{
			driver.manage().timeouts()
			.pageLoadTimeout(Long.parseLong(com.booksmart.Utilities.ProjProperties.getProperty(ProjProperties.waitTIME)), TimeUnit.SECONDS);
			//Driver.logger.info("Sync waitPageLoad Completed successfully");
		}catch(Exception e){
			e.printStackTrace();
			//Driver.getLogger().info("waitPageLoad  is throwing exception ");
		}		
	}
	
	final public static void waitForElemToBeInvisible(final By by, long waitseconds) {
		WebElement waitElement = null;
		// Sets FluentWait Setup
		FluentWait<WebDriver> fwait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(2))
				.pollingEvery(Duration.ofMillis(100)).ignoring(NoSuchElementException.class)
				.ignoring(TimeoutException.class);
		try {
			waitElement = fwait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(by);
				}
			});
		} catch (Exception e) {
		}
		if (waitElement != null) {
			WebDriverWait wait = new WebDriverWait(driver, waitseconds);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
		}
		
	}
	
	public static void waitImplicitTime(long waitSeconds) throws Exception {
		driver.manage().timeouts().implicitlyWait(waitSeconds, TimeUnit.SECONDS);
		Sync.logger.info("Sync waitImplicit Completed successfully");
	}
	
	
	public static void waitforAlert(long waitSeconds) throws Exception {
		WebDriverWait syncWait = new WebDriverWait(driver, waitSeconds);
		syncWait.withTimeout(Duration.ofSeconds(Sync.waitSeconds));
		syncWait.pollingEvery(Duration.ofMillis(300));
		syncWait.until(ExpectedConditions.alertIsPresent());
		Sync.logger.info("Sync waitAlert Completed successfully");
	}
	
		
	public static boolean waitforElementisDisplayed(String elemfindBY, String elemfindText) throws Exception {
		return SeleniumLib.findElement(elemfindBY, elemfindText).isDisplayed();
	}
	
	public static boolean waitforElementisSelected(String elemfindBY, String elemfindText) throws Exception {
		return SeleniumLib.findElement(elemfindBY, elemfindText).isSelected();
	}
	
	public static boolean waitforElementisEnabled(String elemfindBY, String elemfindText) throws Exception {
		return SeleniumLib.findElement(elemfindBY, elemfindText).isEnabled();
	}
	
	

}
