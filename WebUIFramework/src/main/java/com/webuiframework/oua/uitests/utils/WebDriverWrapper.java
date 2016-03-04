package com.webuiframework.oua.uitests.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.webuiframework.oua.uitests.autoit.UAutoItX;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public final class WebDriverWrapper {

    public static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    private WebDriverWrapper(){}

    public static int TIMEOUT = 30; //seconds
    public static boolean CHECKCONDITION = true;
        
    public static WebDriver getDriver() {
        return threadDriver.get();
    }

    public static void setWebDriver(WebDriver webDriver) {
        threadDriver.set(webDriver);
    }

    public static JavascriptExecutor getjavascritExecutor(){
    	JavascriptExecutor executor = (JavascriptExecutor)getDriver();
    	return executor;
    }
    /**
     * Set Default timeout for WebDriver
     *
     * @param timeout - seconds to wait web element
     */
    public static void setDefaultTimeout(int timeout) {
        TIMEOUT = timeout;
    }

    /**
     * Set Default check condition for wait methods
     *
     * @param checkCondition log assert for expected conditions.
     */
    public static void setDefaultCheckCondition(boolean checkCondition) {
        CHECKCONDITION = checkCondition;
    }


    /**
     * initialization RemoteWebDriver
     *
     * @param remoteUrl - remote host
     * @param capabilities - desired capabilities
     * @throws MalformedURLException - exception
     */
    public static void initRemoteWebDriver(String remoteUrl, Capabilities capabilities) throws MalformedURLException {
        setWebDriver(new RemoteWebDriver(new URL(remoteUrl), capabilities));
        setTimeout(TIMEOUT);
        getDriver().manage().window().maximize();
    }

    /**
     * initialization FirefoxDriver
     *
     * @param capabilities - desired capabilities
     */
    public static void initFirefoxDriver(Capabilities capabilities) {
        setWebDriver(new FirefoxDriver(capabilities));
        setTimeout(TIMEOUT);
        getDriver().manage().window().maximize();
    }

    /**
     * initialization ChromeDriver
     *
     * @param capabilities - desired capabilities
     */
    public static void initChromeDriver(Capabilities capabilities) {
        setWebDriver(new ChromeDriver(capabilities));
        setTimeout(TIMEOUT);
        getDriver().manage().window().maximize();
    }

    /**
     * initialization SafariDriver
     *
     * @param capabilities - desired capabilities
     */
    public static void initSafariDriver(Capabilities capabilities) {
        setWebDriver(new SafariDriver(capabilities));
        setTimeout(TIMEOUT);
        getDriver().manage().window().maximize();
    }

    /**
     * initialization InternetExplorerDriver
     *
     * @param capabilities - desired capabilities
     */
    public static void initInternetExplorerDriver(Capabilities capabilities) {
        setWebDriver(new InternetExplorerDriver(capabilities));
        setTimeout(TIMEOUT);
        getDriver().manage().window().maximize();
    }

    /**
     * initialization HtmlUnitDriver
     *
     * @param capabilities - desired capabilities
     */
    public static void initHtmlUnitDriver(Capabilities capabilities) {
        setWebDriver(new HtmlUnitDriver(capabilities));
        setTimeout(TIMEOUT);
        getDriver().manage().window().maximize();
    }

    /**
     * initialization FF with some profile
     * Use it if you want to use your profile for FF. It doesn't work remotely.
     * Before running create your profile. Use cmd : firefox.exe -ProfileManager -no-remote
     * @param path - profile path
     */
    public static void initFFProfile(String path) {
        File profileDir = new File(path);
        FirefoxProfile ffprofile = new FirefoxProfile(profileDir);
        ffprofile.setEnableNativeEvents(true);
        setWebDriver(new FirefoxDriver(ffprofile));
        getDriver().manage().window().maximize();
    }
    
     /**
     * initialization FirefoxDriver
     */
    public static void initFirefoxDriver() {
        FirefoxProfile profile = new FirefoxProfile();
        profile.setAcceptUntrustedCertificates(true);
        profile.setAssumeUntrustedCertificateIssuer(true);
        profile.setEnableNativeEvents(true);
        profile.setPreference("javascript.enabled", true);
        profile.setPreference("dom.max_script_run_time", 0);
        profile.setPreference("dom.max_chrome_script_run_time", 0);
        profile.setPreference("browser.download.folderList", 2);
		profile.setPreference("browser.download.manager.showWhenStarting", false);
		profile.setPreference("browser.download.dir", new WebDriverWrapper().fileDirLocation().toString());
		profile.setPreference("browser.helperApps.neverAsk.openFile", "application/pdf");
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");
		profile.setPreference("pdfjs.disabled", true);
		profile.setPreference("plugin.scan.plid.all", false);
		profile.setPreference("plugin.scan.Acrobat", "99.0");
        setWebDriver(new FirefoxDriver(profile));
        setTimeout(TIMEOUT);
        getDriver().manage().window().maximize();
    }
    
     /**
     * initialization InternetExplorerDriver
     */
    public static void initInternetExplorerDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setPlatform(Platform.WINDOWS);
        capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        capabilities.setCapability(CapabilityType.HAS_NATIVE_EVENTS, false);
        capabilities.setJavascriptEnabled(true);
        capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
        capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
        setWebDriver(new InternetExplorerDriver(capabilities));
        setTimeout(TIMEOUT);
        getDriver().manage().window().maximize();
    }
    
     /**
     * initialization ChromeDriver
     *
     */
    public static void initChromeDriver() {
    	HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", new WebDriverWrapper().fileDirLocation().toString());
        ChromeOptions options = new ChromeOptions();
        options.addArguments(Arrays.asList("--start-maximized", "--test-type", "--ignore-certificate-errors", "--disable-popup-blocking", "--allow-running-insecure-content", "--disable-translate", "--always-authorize-plugins"));
        options.setExperimentalOption("prefs", chromePrefs);
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        cap.setCapability(ChromeOptions.CAPABILITY, options);
        setWebDriver(new ChromeDriver(cap));
        setTimeout(TIMEOUT);
    }
    
    /**
     * initialization SafariDriver
     */
    public File fileDirLocation(){
    	String path=System.getProperty("user.dir");
    	return new File(path+"\\src\\test\\resources\\TestData");
    }
    
     /**
     * initialization SafariDriver
     */
    public static void initSafariDriver() {
        setWebDriver(new SafariDriver());
        setTimeout(TIMEOUT);
        getDriver().manage().window().maximize();
    }

    /**
     * Set Wait and Script timeouts for WebDriver
     *
     * @param timeout - seconds to wait element and running script
     */
    public static void setTimeout(int timeout) {
        getDriver().manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        getDriver().manage().timeouts().setScriptTimeout(timeout, TimeUnit.SECONDS);
    }

    /**
     * Set Wait and Script timeouts for WebDriver
     *
     * @param timeout - milliseconds to wait element and running script
     */
    public static void setTimeoutMls(int timeout) {
    	getDriver().manage().timeouts().implicitlyWait(timeout, TimeUnit.MILLISECONDS);
    	getDriver().manage().timeouts().setScriptTimeout(timeout, TimeUnit.MILLISECONDS);
    }

    /**
     * Remove all cookies from browser
     */
    public static void deleteAllCookies() {
        getDriver().manage().deleteAllCookies();
    }

    public static WebElement getWebElementByXpath(String xpath){
    	return getDriver().findElement(By.xpath(xpath));
    }
    
    public static List<WebElement> getWebElementsByXpath(String xpath){
    	return getDriver().findElements(By.xpath(xpath));
    }
    
    public static void mouseover(WebElement webElement){
    	Actions mouseroveraction = new Actions(getDriver());
    	mouseroveraction.moveToElement(webElement).build().perform();
    }
    /**
     * Delete the named cookie from the current domain. This is equivalent to setting the named
     * cookie's expiry date to some time in the past.
     *
     * @param cookieName The name of the cookie to delete
     */
    public static void deleteCookieNamed(String cookieName){
        getCookieNamed(cookieName);
        getDriver().manage().deleteCookieNamed(cookieName);
        getCookieNamed(cookieName);
    }

    /**
     * Log cookie.
     *
     * @param cookieName The name of the cookie to log.
     */
    public static void getCookieNamed(String cookieName){
        if((getDriver().manage().getCookieNamed(cookieName))!=null) {
        }
        else{
        }
    }


    public static void dragAnddrop(WebElement sourceWebElement,WebElement destinationWebElement){
    	Actions builder = new Actions(getDriver());
    	builder.dragAndDrop(sourceWebElement, destinationWebElement).build().perform();
    }
    /**
     * Open web page
     *
     * @param page - target for navigate
     */
    public static void open(String page) {
    	getDriver().get(page);
    }

    /**
     * Quit from WebDriver (Closes all browser windows and safely ends the session).
     */
    public static void quit() {
        if (getDriver() != null) {
            getDriver().quit();
        }
    }


    /**
     *  Close the WebDriver (Close the browser window that the driver has focus of).
     */
    public static void close() {
        if (getDriver() != null) {
            getDriver().close();
        }
    }

    /**
     * Execute JavaScript code.
     *
     * @param script - target for execution
     * @return Execution results
     */
    public static Object executeScript(String script) {
        return (getjavascritExecutor().executeScript(script));
    }

    /**
     * Switch to frame.
     *
     * @param frame - target frame
     */
    public static void switchToFrame(String frame) {
        getDriver().switchTo().frame(frame);
    }
    
    /**
     * Switch to frame.
     *
     * @param frame - target frame
     */
    public static void switchToFrame(WebElement frameElement) {
        getDriver().switchTo().frame(frameElement);
    }

    /**
     * Switch to window.
     *
     * @param window - target window
     */
    public static void switchToWindow(String window) {
        getDriver().switchTo().window(window);
    }

    /**
     * Switch to active element.
     *
     * @return active WebElement
     */
    public static WebElement switchToActive() {
        return getDriver().switchTo().activeElement();
    }

    /**
     * Switch to the next window.
     */
    public static void switchWindow() {
        Set<String> handles = getDriver().getWindowHandles();
        if (handles.size() > 1 ){
            String current = getDriver().getWindowHandle();
            handles.remove(current);
        }
        else{
        }
        String newTab = handles.iterator().next();
        getDriver().switchTo().window(newTab);
    }

    /**
     * Close active and switch to the next window.
     */
    public static void switchCloseWindow() {
        new WebDriverWait(getDriver(), TIMEOUT) {
        }.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver wDriver) {
                return (wDriver.getWindowHandles().size() > 1);
            }
        });
        Set<String> handles = getDriver().getWindowHandles();
        if (handles.size() == 1 ){
            return;
        }
        getDriver().close();
        Sleeper.sleepTight(500);
        handles = getDriver().getWindowHandles();
        getDriver().switchTo().window(handles.iterator().next());
    }

    public static boolean waitWindowsCount(final int numberOfWindows){
        new WebDriverWait(getDriver(), TIMEOUT) {
        }.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver wDriver) {
                return (wDriver.getWindowHandles().size() == numberOfWindows);
            }
        });
        return false;
    }

    /**
     * Wait until all windows not empty.
     *
     * @param numberOfWindows - number of existing windows
     */
    public static void waitAllWindowsFullLoaded(final int numberOfWindows) {
    	new WebDriverWait(getDriver(), TIMEOUT) {
    	     }.until(new ExpectedCondition<Boolean>() { 
    	         @Override 
    	         public Boolean apply(WebDriver wDriver) {
    	             return (wDriver.getWindowHandles().size() == numberOfWindows);
    	         } 
    	     });
    	     
        new WebDriverWait(getDriver(), TIMEOUT) {
        }.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver wDriver) {
                boolean fullLoaded = true;
                for (String window : wDriver.getWindowHandles()) {
                    if (window.isEmpty()) {
                        fullLoaded = false;
                        break;
                    }
                }
                return (fullLoaded);
            }
        });
        Sleeper.sleepTight(1000);
    }

    /**
     * Switch to the default window.
     */
    public static void switchToDefault() {
        getDriver().switchTo().defaultContent();
    }

    /**
     * Switch to the window with title.
     *
     * @param title - Expected active window title.
     * @return True if window is switched, otherwise False
     */
    public static boolean switchToWindowUsingTitle(String title) {
        Set<String> availableWindows = getDriver().getWindowHandles();
        if (!availableWindows.isEmpty() && availableWindows.contains(title)) {
            getDriver().switchTo().window(title);
            return true;
        }
        return false;
    }

    /**
     * Get active window handle.
     *
     * @return Active window handle.
     */
    public static String getWindowHandle() {
        return getDriver().getWindowHandle();
    }

    /**
     * Get windows handles.
     *
     * @return Window handles.
     */
    public static Set<String> getWindowHandles() {
        return getDriver().getWindowHandles();
    }

    /**
     * Get window title.
     *
     * @return Window title.
     */
    public static String getWindowTitle() {
        return getDriver().getTitle();
    }

    /**
     * Click "go Back" button on the current page
     */
    public static void goBack() {
        getDriver().navigate().back();
    }

    /**
     * Click "go Forward" button on the current page
     */
    public static void goForward() {
        getDriver().navigate().forward();
    }

    /**
     * Click "Refresh" button on the current page
     */
    public static void refresh() {
        getDriver().navigate().refresh();
    }

    /**
     * Sleep by seconds.
     *
     * @param seconds to sleeping.
     */
    public static void sleep(int seconds) {
        Sleeper.sleepTightInSeconds(seconds);
    }

    /**
     * Scroll page to top by JS
     */
    public static void scrollPageToTop() {
        WebDriverWrapper.executeScript("window.scrollTo(0, 0);");
    }
    /**
     * Scroll page down by JS
     *
     * @param iHeight - height
     */
    public static void scrollPageDown(int iHeight) {
        WebDriverWrapper.executeScript("window.scrollTo(0, " + iHeight + ");");
    }
    /**
     * Scroll page up by JS
     *
     * @param iHeight - height
     */
    public static void scrollPageUp(int iHeight) {
        WebDriverWrapper.executeScript("window.scrollTo(0, " + iHeight + ");");
    }
    /**
     * Scroll page to end by JS
     */
    public static void scrollPageToEnd() {
        WebDriverWrapper.executeScript("window.scrollTo(0, document.body.clientHeight )");
    }

    /**
     * Wait until windows has title.
     *
     * @param title - Expected window title.
     */
    public static void waitForTitle(String title) {
        waitForTitle(title, TIMEOUT, false);
    }
    /**
     * Wait until windows has title.
     *
     * @param timeoutSec to wait until windows has title.
     * @param title - Expected window title.
     * @param checkCondition log assert for expected conditions.
     */
    public static void waitForTitle(String title, int timeoutSec, boolean checkCondition) {
        long start = System.currentTimeMillis()/1000;
        WebDriverWait wait = (WebDriverWait) new WebDriverWait(getDriver(), timeoutSec)
                .ignoring(StaleElementReferenceException.class);
        try {
            wait.until(ExpectedConditions.titleIs(title));
        }catch (TimeoutException ignored){
        }
        if (checkCondition) {
        }
    }
    /**
     * Wait until windows title contains text.
     *
     * @param title - Expected window title contains text.
     */
    public static void waitForTitleContains(String title) {
        waitForTitleContains(title, TIMEOUT, false);
    }
    /**
     * Wait until windows title contains text.
     *
     * @param timeoutSec to wait until windows title contains text.
     * @param title - Expected window title contains text.
     * @param checkCondition - log assert for expected conditions.
     */
    public static void waitForTitleContains(String title, int timeoutSec, boolean checkCondition) {
        long start = System.currentTimeMillis()/1000;
        WebDriverWait wait = (WebDriverWait) new WebDriverWait(getDriver(), timeoutSec)
                .ignoring(StaleElementReferenceException.class);
        try{
            wait.until(ExpectedConditions.titleContains(title));
        }catch (TimeoutException ignored){
        }
        if (checkCondition) {
        }
    }
    /**
     * Wait until windows title not contains text.
     *
     * @param title - Expected window title not contains text.
     */
    public static void waitForTitleNotContains(String title) {
        waitForTitleNotContains(title, TIMEOUT, false);
    }
    /**
     * Wait until windows title not contains text.
     *
     * @param timeoutSec to wait until windows title not contains text.
     * @param title - Expected window title not contains text.
     * @param checkCondition log assert for expected conditions.
     */
    public static void waitForTitleNotContains(String title, int timeoutSec, boolean checkCondition) {
        long start = System.currentTimeMillis()/1000;
        WebDriverWait wait = (WebDriverWait) new WebDriverWait(getDriver(), timeoutSec)
                .ignoring(StaleElementReferenceException.class);
        try{
            wait.until(ExpectedConditions.not(ExpectedConditions.titleContains(title)));
        }catch (TimeoutException ignored){
        }
        if (checkCondition) {
        }
    }

    /**
     * Wait until title is changed text
     *
     * @param title before change
     */
    public static void waitForTitleChanged(final String title) {
        waitForTitleChanged(title, TIMEOUT, false);
    }

    /**
     * Wait until element is changed text
     *
     * @param title before change
     * @param timeoutSec seconds to wait until element is changed text
     * @param checkCondition - log assert for expected conditions.
     */
    public static void waitForTitleChanged(final String title, int timeoutSec, boolean checkCondition) {
        boolean isChanged;
        long start = System.currentTimeMillis() / 1000;
        WebDriverWait wait = (WebDriverWait) new WebDriverWait(getDriver(), timeoutSec)
                .ignoring(StaleElementReferenceException.class);
        try{
            isChanged = wait.until(ExpectedConditions.not(ExpectedConditions.titleIs(title)));
        }catch (TimeoutException e){
            isChanged = false;
        }
        if (checkCondition) {
        }
    }

    /**
     * Wait until any element with text presents at web page.
     *
     * @param text - element text to be presents..
     */
    public static void waitForTextToBePresent(String text) {
        waitForTextToBePresent(text, TIMEOUT, false);
    }
    /**
     * Wait until any element with text presents at web page.
     *
     * @param text - element text to be presents.
     * @param timeoutSec to wait until presents.
     * @param checkCondition log assert for expected conditions.
     */
    public static void waitForTextToBePresent(String text, int timeoutSec, boolean checkCondition) {
        boolean isPresent;
        long start = System.currentTimeMillis()/1000;
        WebDriverWait wait = (WebDriverWait) new WebDriverWait(getDriver(), timeoutSec)
                .ignoring(StaleElementReferenceException.class);
        setTimeout(timeoutSec);
        try {
            isPresent = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*"), text));
        }catch (TimeoutException ignored){
            isPresent = false;
        }
        setTimeout(TIMEOUT);
        if (checkCondition) {
        }
    }
    /**
     * Wait until any element with text not presents at web page.
     *
     * @param text - element text to not be presents.
     */
    public static void waitForTextToNotBePresent(String text) {
        waitForTextToNotBePresent(text, TIMEOUT, false);
    }
    /**
     * Wait until any element with text not presents at web page.
     *
     * @param text - element text to not be presents.
     * @param timeoutSec to wait until not presents.
     * @param checkCondition log assert for expected conditions.
     */
    public static void waitForTextToNotBePresent(String text, int timeoutSec, boolean checkCondition) {
        boolean isNotPresent;
        long start = System.currentTimeMillis()/1000;
        WebDriverWait wait = (WebDriverWait) new WebDriverWait(getDriver(), timeoutSec)
                .ignoring(StaleElementReferenceException.class);
        setTimeout(timeoutSec);
        try {
            isNotPresent = wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*"), text)));
        }catch (TimeoutException ignored){
            isNotPresent = false;
        }
        setTimeout(TIMEOUT);
        if (checkCondition) {
        }
    }
    /**
     * Wait until link presents at web page.
     *
     * @param linkText - link to be presents.
     */
    public static void waitForLinkToBePresent(String linkText) {
        waitForLinkToBePresent(linkText, TIMEOUT, false);
    }
    /**
     * Wait until link presents at web page.
     *
     * @param linkText - linkText to be presents.
     * @param timeoutSec to wait until presents.
     * @param checkCondition log assert for expected conditions.
     */
    public static void waitForLinkToBePresent(String linkText, int timeoutSec, boolean checkCondition) {
        boolean isPresent;
        long start = System.currentTimeMillis()/1000;
        WebDriverWait wait = (WebDriverWait) new WebDriverWait(getDriver(), timeoutSec)
                .ignoring(StaleElementReferenceException.class);
        setTimeout(timeoutSec);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(linkText)));
            isPresent = true;
        }catch (TimeoutException ignored){
            isPresent = false;
        }
        setTimeout(TIMEOUT);
        if (checkCondition) {
        }
    }
    /**
     * Wait until link not presents at web page.
     *
     * @param linkText - link to not be presents.
     */
    public static void waitForLinkToNotBePresent(String linkText) {
        waitForLinkToNotBePresent(linkText, TIMEOUT, false);
    }
    /**
     * Wait until link not presents at web page.
     *
     * @param linkText - linkText to not be presents.
     * @param timeoutSec to wait until not presents.
     * @param checkCondition log assert for expected conditions.
     */
    public static void waitForLinkToNotBePresent(String linkText, int timeoutSec, boolean checkCondition) {
        boolean isNotPresent;
        long start = System.currentTimeMillis()/1000;
        WebDriverWait wait = (WebDriverWait) new WebDriverWait(getDriver(), timeoutSec)
                .ignoring(StaleElementReferenceException.class);
        setTimeout(timeoutSec);
        try {
            isNotPresent = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.linkText(linkText)));
        }catch (TimeoutException ignored){
            isNotPresent = false;
        }
        setTimeout(TIMEOUT);
        if (checkCondition) {
        }
    }
    /**
     * Wait until native window is not exists.
     *
     * @param title of native window
     */
    public static void waitForNativeWindow(final String title) {
        waitForNativeWindow(title, TIMEOUT, false);
    }
    /**
     * Wait until native window is not exists.
     *
     * @param title of native window
     * @param timeoutSec to wait until native window is not exists.
     * @param checkCondition log assert for expected conditions.
     */
    public static void waitForNativeWindow(final String title, int timeoutSec, boolean checkCondition) {
        boolean isPresent;
        long start = System.currentTimeMillis()/1000;
        WebDriverWait wait = new WebDriverWait(getDriver(), timeoutSec);
        try {
            isPresent = wait.until(
                    new ExpectedCondition<Boolean>() {
                        @Override
                        public Boolean apply(WebDriver driver) {
                            UAutoItX UIMethods = new UAutoItX();
                            return UIMethods.WinExists(title, "") > 0;
                        }
                    }
            );
        } catch (TimeoutException e) {
            isPresent = false;
        }
        if (checkCondition) {
        }
    }

    /**
     * Wait until Expected Condition.
     *
     * @param condition - Expected Condition
     */
    public static void waitForExpectedCondition(final ExpectedCondition<Boolean> condition) {
        waitForExpectedCondition(condition, TIMEOUT, false);
    }

    /**
     * Wait until Expected Condition.
     *
     * @param condition - Expected Condition
     * @param timeoutSec - the maximum time to wait in seconds
     */
    public static void waitForExpectedCondition(final ExpectedCondition<Boolean> condition, final int timeoutSec) {
        waitForExpectedCondition(condition, timeoutSec, CHECKCONDITION);
    }

    /**
     * Wait until Expected Condition.
     *
     * @param condition - Expected Condition
     * @param timeoutSec - the maximum time to wait in seconds
     * @param checkCondition log assert for expected conditions.
     */
    public static void waitForExpectedCondition(final ExpectedCondition<Boolean> condition, final int timeoutSec, final boolean checkCondition) {
        boolean isTrue;
        WebDriverWait wait = (WebDriverWait) new WebDriverWait(getDriver(), timeoutSec)
                     .ignoring(NoSuchElementException.class)
                     .ignoring(StaleElementReferenceException.class)
                    .pollingEvery(timeoutSec, TimeUnit.MILLISECONDS);
       	setTimeout(timeoutSec);
        try {
            wait.until(condition);
            isTrue = false;
        } catch (TimeoutException e) {
            isTrue = true;
        }
        setTimeout(TIMEOUT);
        if (checkCondition){
        }
    }

    public static Boolean waitforelementExistsWithText(By locator, String text)
    {
        ExpectedCondition<Boolean> textToBePresentInElement = ExpectedConditions.textToBePresentInElementLocated(locator, text);
        WebDriverWait wait = (WebDriverWait) new WebDriverWait(getDriver(), TIMEOUT)
                .ignoring(NoSuchElementException.class)
               .ignoring(StaleElementReferenceException.class)
               .pollingEvery(TIMEOUT, TimeUnit.MILLISECONDS);
        try {
            wait.until(textToBePresentInElement);
            return Boolean.TRUE;
        } catch ( TimeoutException te ) {
            return Boolean.FALSE;
        }
    }
    
	public static void waitForElementPresent(final By by) {
		WebDriverWait wait = (WebDriverWait) new WebDriverWait(getDriver(), TIMEOUT)
				.ignoring(StaleElementReferenceException.class);
		wait.until(new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver webDriver) {
				WebElement element = webDriver.findElement(by);
				return element != null && element.isDisplayed();
			}
		});
	}
	
	public static void waitForvisibilityofElementLocated(final By by) {
		WebDriverWait wait = (WebDriverWait) new WebDriverWait(getDriver(), TIMEOUT)
				.ignoring(StaleElementReferenceException.class);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	public static void waitForelemnetToBEclickable(final By by) {
		WebDriverWait wait = (WebDriverWait) new WebDriverWait(getDriver(), TIMEOUT)
				.ignoring(StaleElementReferenceException.class);
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}
	
	public static void waitForinvisibilityofElement(final By by) {
		WebDriverWait wait = (WebDriverWait) new WebDriverWait(getDriver(), TIMEOUT)
				.ignoring(StaleElementReferenceException.class);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}
	
	public static void waitForpresenceOfElement(final By by) {
		WebDriverWait wait = (WebDriverWait) new WebDriverWait(getDriver(), TIMEOUT)
				.ignoring(StaleElementReferenceException.class);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}
	
	
    /**
     * Wait until JavaScript Condition.
     *
     * @param javaScript - JavaScript Condition e.g. return (xmlhttp.readyState==4) or (xmlhttp.status==200)
     */
    public static void waitForJavaScriptCondition(final String javaScript) {
        waitForJavaScriptCondition(javaScript, TIMEOUT, false);
    }

    /**
     * Wait until JavaScript Condition.
     *
     * @param javaScript - JavaScript Condition e.g. return (xmlhttp.readyState==4) or (xmlhttp.status==200)
     * @param timeoutSec - the maximum time to wait in seconds
     */
    public static void waitForJavaScriptCondition(final String javaScript, final int timeoutSec) {
        waitForJavaScriptCondition(javaScript, timeoutSec, CHECKCONDITION);
    }

    /**
     * Wait until JavaScript Condition.
     *
     * @param javaScript - JavaScript Condition e.g. return (xmlhttp.readyState==4) or (xmlhttp.status==200)
     * @param timeoutSec - the maximum time to wait in seconds
     * @param checkCondition log assert for expected conditions.
     */
    public static void waitForJavaScriptCondition(final String javaScript, final int timeoutSec, final boolean checkCondition) {
        boolean isTrue;
        long start = System.currentTimeMillis() / 1000;
        WebDriverWait wait = new WebDriverWait(getDriver(), timeoutSec);
        try {
            wait.until(new ExpectedCondition<Boolean>() {
                @Override
                public Boolean apply(WebDriver driverObject) {
                    return (Boolean) (getjavascritExecutor().executeScript(javaScript));
                }
            });
            isTrue = false;
        } catch (TimeoutException e) {
            isTrue = true;
        }
        if (checkCondition){
        }
    }

    /**
     * Wait until Ajax JQuery Process finished.
     */
    public static void waitForAjaxJQueryProcess() {
        waitForAjaxJQueryProcess(TIMEOUT, false);
    }

    /**
     * Wait until Ajax JQuery Process finished.
     *
     * @param timeoutSec - the maximum time to wait in seconds
     */
    public static void waitForAjaxJQueryProcess(final int timeoutSec) {
        waitForAjaxJQueryProcess(timeoutSec, CHECKCONDITION);
    }

    /**
     * Wait until Ajax JQuery Process finished.
     *
     * @param timeoutSec - the maximum time to wait in seconds
     * @param checkCondition log assert for expected conditions.
     */
    public static void waitForAjaxJQueryProcess(final int timeoutSec, final boolean checkCondition) {
        boolean isTrue;
        long start = System.currentTimeMillis() / 1000;
        WebDriverWait wait = new WebDriverWait(getDriver(), timeoutSec);
        try {
            wait.until(new ExpectedCondition<Boolean>() {
                @Override
                public Boolean apply(WebDriver driverObject) {
                    return (Boolean) (getjavascritExecutor().executeScript("return window.jQuery != undefined && jQuery.active === 0"));
                }
            });
            isTrue = false;
        } catch (TimeoutException e) {
            isTrue = true;
        }
        if (checkCondition){
        }
    }


}
