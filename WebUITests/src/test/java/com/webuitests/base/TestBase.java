package com.webuitests.base;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.webuiframework.oua.uitests.utils.TestBaseWebDriver;
import com.webuiframework.oua.uitests.utils.WebDriverWrapper;

public class TestBase extends TestBaseWebDriver {
	public static final String screenshotDirectory = "target/screenshots";
	public Properties testproperties;
	String Propertiesfilename = "config.properties";
	public InputStream inputstream;
	public static String ExampleBaseURL = "";
	public static String CourseCatalogueURL = "";
	public static String CourseCatalogueLMSURL = "";
	public static String CourseCatalogueStudentPortalURL = "";
	public static String BaseURL = "";
	public static String LMSURL = "";
	public static String LABURL = "";
	public static String E3URL = "";
	public static String AdminURL = "";
	public static String adminuserName = "";
	public static String adminPassword = "";
	public static String adminFullname = "";
	public static String e3adminuserName = "";
	public static String e3adminPassword = "";
	public static String coursecatalogueadminPassword = "";
	public static String groupglobal = "";
	public static String permissiontab = "";
	public static String lmsuser = "";
	public static String training = "";
	public static String testactivity= "";
	public static String admincourse = "";
	public static String adminuser = "";
	public static Boolean loggen_In = false;

	public void Initalise() {

		testproperties = new Properties();
		InputStream inputstream = getClass().getClassLoader().getResourceAsStream(Propertiesfilename);
		if (inputstream != null) {
			try {
				testproperties.load(inputstream);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		setBrowserType(testproperties.getProperty("webuitests.browser"));
		if (TestBaseWebDriver.browserType.equalsIgnoreCase(Browsers.IE.toString())) {
			System.setProperty("webdriver.ie.driver",
					new File("src/test/resources/Drivers/IEDriverServer.exe").getAbsolutePath());
			WebDriverWrapper.TIMEOUT = Integer.parseInt(testproperties.getProperty("webuitests.defaultTimeout.ie"));
		}
		if (TestBaseWebDriver.browserType.equalsIgnoreCase(Browsers.CHROME.toString())) {
			System.setProperty("webdriver.chrome.driver",
					new File("src/test/resources/Drivers/chromedriver.exe").getAbsolutePath());
			WebDriverWrapper.TIMEOUT = Integer.parseInt(testproperties.getProperty("webuitests.defaultTimeout.chrome"));
		}
		if (TestBaseWebDriver.browserType.equalsIgnoreCase(Browsers.FIREFOX.toString())) {
			WebDriverWrapper.TIMEOUT = Integer
					.parseInt(testproperties.getProperty("webuitests.defaultTimeout.firefox"));
		}
		initWebDriver();
		takePassedScreenshot(Boolean.parseBoolean(testproperties.getProperty("webuitests.takePassedScreenshot")));
		ExampleBaseURL = testproperties.getProperty("webuitests.ExampleURL");
		BaseURL = testproperties.getProperty("webuitests.admin");
		LMSURL = testproperties.getProperty("webuitests.lms");
		LABURL = testproperties.getProperty("webuitests.lab");
		AdminURL = testproperties.getProperty("webuitests.adminurl");
		E3URL = testproperties.getProperty("webuitests.home");
		CourseCatalogueURL = testproperties.getProperty("webuitests.coursecatalogueURL");
		CourseCatalogueLMSURL = testproperties.getProperty("webuitests.coursecatalogueLMSURL");
		e3adminuserName = testproperties.getProperty("webuitests.e3adminUser");
		e3adminPassword = testproperties.getProperty("webuitests.e3adminpassword"); 
		adminuserName = testproperties.getProperty("webuitests.adminUser");
		adminPassword = testproperties.getProperty("webuitests.adminpassword");
		adminFullname = testproperties.getProperty("webuitests.adminFullName");
		coursecatalogueadminPassword = testproperties.getProperty("webuitests.coursecatalogueadminPassword");
		groupglobal = testproperties.getProperty("webuitests.lms.group");
		permissiontab = testproperties.getProperty("webuitests.lms.permissions");
		lmsuser = testproperties.getProperty("webuitests.lms.adminUser");
		training = testproperties.getProperty("webuitests.lms.training");
		testactivity = testproperties.getProperty("webuitests.lms.activity");
		admincourse = testproperties.getProperty("webuitests.admin.course");
		adminuser = testproperties.getProperty("webuitests.admin.adminUser");
	}

	public static enum Browsers {
		FIREFOX, CHROME, IE
	}
}