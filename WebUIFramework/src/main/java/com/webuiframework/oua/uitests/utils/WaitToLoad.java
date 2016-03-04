package com.webuiframework.oua.uitests.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public final class WaitToLoad {
	
	public static Wait<WebDriver> wait = new FluentWait<WebDriver>(WebDriverWrapper.getDriver())
    		.withTimeout( WebDriverWrapper.TIMEOUT, TimeUnit.SECONDS )
    		.pollingEvery( 1, TimeUnit.SECONDS )
    		.ignoring( NoSuchElementException.class, StaleElementReferenceException.class );

}
