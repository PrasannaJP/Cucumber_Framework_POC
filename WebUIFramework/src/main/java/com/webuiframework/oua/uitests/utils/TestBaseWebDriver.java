package com.webuiframework.oua.uitests.utils;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class TestBaseWebDriver {

    public static WebDriver driver;
    public static String browserType = "FIREFOX";
    public static boolean grid = false;
    public static String gridHub = "http://localhost:4444/wd/hub";
    public static final String screenshotDirectory = "target/screenshots";
    public static boolean simpleClassName = true;
    public static boolean takePassedScreenshot = false;
    public static boolean logFindElementLocator = true;
    public static boolean allure = false;
    public static boolean reportportal = false;

    /**
     * Set Browser for WebDriver.
     *
     * @param browser - browser to initialization.
     */
    public static void setBrowserType(String browser) {
    	browserType = browser.toUpperCase();
    }

    /**
     * Use Selenium Grid.
     *
     * @param useGrid - true for using selenium grid.
     */
    public static void useGrid(boolean useGrid) {
        grid = useGrid;
    }

    /**
     * Set Selenium Grid Hub.
     *
     * @param hub - selenium grid hub url.
     */
    public static void setGridHub(String hub) {
        gridHub = hub;
    }

    /**
     * Take screenshots at passed assertion.
     *
     * @param takeScreenshot - true for taking screenshots at passed assertion.
     */
    public static void takePassedScreenshot(boolean takeScreenshot) {
        takePassedScreenshot = takeScreenshot;
    }

    /**
     * Use simple or canonical class name.
     *
     * @param simple - true for using simple class name .
     */
    public static void useSimpleClassName(boolean simple) {
        simpleClassName = simple;
    }

    /**
     * WebDriver initialization.
     */
    public void initWebDriver() {
        if (grid) {
            initWebDriverGrid();
        } else {
            switch (browserType) {
                case "SAFARI":
                    WebDriverWrapper.initSafariDriver();
                    break;
                case "CHROME":
                    WebDriverWrapper.initChromeDriver();
                    break;
                case "FIREFOX":
                    WebDriverWrapper.initFirefoxDriver();
                    break;
                case "IE":
                case "IEEXPLORER":
                case "INTERNETEXPLORER":
                    WebDriverWrapper.initInternetExplorerDriver();
                    break;
            }
            driver = WebDriverWrapper.getDriver();
        }
        initScreenshotDirectory();
    }

    /**
     * WebDriver Grid initialization.
     */
    public void initWebDriverGrid() {

        Capabilities capabilities = null;
        switch (browserType) {
            case "SAFARI":
                capabilities = DesiredCapabilities.internetExplorer();
                break;
            case "CHROME":
                capabilities = DesiredCapabilities.chrome();
                break;
            case "FIREFOX":
                capabilities = DesiredCapabilities.firefox();
                break;
            case "IE":
            case "IEEXPLORER":
            case "INTERNETEXPLORER":
                capabilities = DesiredCapabilities.internetExplorer();
                break;
        }
        try {
            WebDriverWrapper.initRemoteWebDriver(gridHub, capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver = WebDriverWrapper.getDriver();

    }

    /**
     * Directory for Screenshot initialization.
     */
    public void initScreenshotDirectory() {
        MakeDir.makeDir(screenshotDirectory);
        ScreenShotMaker.setPath(screenshotDirectory);
    }
    
    
    
}

   