package com.booksmart.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumLib {
	
	public static WebDriver driver; 
	
	public static void initdriver() {
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path+"\\drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");;
		driver= new ChromeDriver(options); 	
		String baseURI=com.booksmart.Utilities.ProjProperties.getProperty(ProjProperties.BASEURL);
		driver.navigate().to(baseURI);
	}
	
	
	public static WebElement findElement(String elemfindBY,String elemfindText) throws Exception {
		WebElement element = null;
		if (elemfindBY.equals("id")) {
			element = driver.findElement(By.id(elemfindText));
		} else if (elemfindBY.equals("name")) {
			element = driver.findElement(By.name(elemfindText));
		} else if (elemfindBY.equals("className")) {
			element = driver.findElement(By.className(elemfindText));
		} else if (elemfindBY.equals("linkText")) {
			element = driver.findElement(By.linkText(elemfindText));
		} else if (elemfindBY.equals("xpath")) {
			element = driver.findElement(By.xpath(elemfindText));
		} else if (elemfindBY.equals("css")) {
			element = driver.findElement(By.cssSelector(elemfindText));
		} else if (elemfindBY.equals("pLinkText")) {
			element = driver.findElement(By.partialLinkText(elemfindText));
		} else if (elemfindBY.equals("tagName")) {
			element = driver.findElement(By.tagName(elemfindText));
		}
		return element;
	}
	
	public static WebElement findElement(By by) throws Exception {
		WebElement element = null;
		element = driver.findElement(by);
		return element;
	}
	
	public static void click(By by) throws Exception {
		WebElement element = findElement(by);
		element.click();
	}
	
	public static void textBoxInput(By by, String inputText) throws Exception {
		WebElement element = findElement(by);
		element.clear();
		element.sendKeys(inputText);
	}	
	
	public static void driverquit() throws Exception {
		driver.quit();		
	}
	
	public static void executeJS(String js, Object arg1) {
		if (arg1 != null)
			((JavascriptExecutor) driver).executeScript(js, arg1);
	}

}
