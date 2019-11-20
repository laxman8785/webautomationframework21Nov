package com.booksmart.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ProjProperties {

	private static String configFile = "Global.properties";
	public static String testNG = "TestNG.xml";
	private static Properties _automation_properties = new Properties();
	public final static String BASEURL = "BASEURL";
	public final static String BROWSER = "BROWSER";
	//public final static String CHROMEVERSION = "CHROMEVERSION";
	public final static String UNAME = "UNAME";
	public final static String PWD = "PWD";
	public final static String CONN_STR = "CONN_STR";
	public final static String SQLJAVADriver = "SQLJAVADriver";
	public final static String waitTIME = "WAITTIME";
	
	public static void setTestNG(String testNGFile) {
		testNG = testNGFile;
	}

	public static String getTestNGFilePath() throws Exception {
		File testNGFile = new File(testNG);
		if (testNGFile.exists()) {
			return testNGFile.getAbsolutePath();
		}
		return System.getProperty("user.dir") + "/" + testNG;
	}


	public static String getConfigFile() {
		return configFile;
	}
	
	private static void loadProperties() {
		try {
			_automation_properties.clear();
			_automation_properties.load(new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/config/"+configFile));
		} catch (IOException e) {
			throw new RuntimeException("Failed to load the properties:"+e);
		}

		assert !_automation_properties.isEmpty();
	}
	
	public static String getProperty(final String key) {
		loadProperties();
		String property = _automation_properties.getProperty(key);
		return property != null ? property.trim() : property;
	}

	public void setProperty(String key, String value) {
		_automation_properties.setProperty(key, value);
	}

	public boolean isProperty(final String key) {
		String property = _automation_properties.getProperty(key);
		if (property != null)
			return true;
		else
			return false;

	}

	public int getNumOfProperties() {
		return _automation_properties.size();
	}

}


