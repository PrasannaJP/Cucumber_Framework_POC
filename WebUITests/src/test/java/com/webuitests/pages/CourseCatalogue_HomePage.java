package com.webuitests.pages;

import com.webuiframework.oua.uitests.control.Element;
import com.webuiframework.oua.uitests.control.Elements;

public class CourseCatalogue_HomePage {
	
	private static CourseCatalogue_HomePage courseCatalogueHomePage;
	
	public static String homepageXpath = "//aside[@class='side-panel']/../../descendant::*";
	public String seetingsXpath = "//span[text()='%s']";
	public static String settingsXpath = "//span[text()='Settings']";
	public static String addcategoriesorproductsXpath = "//nav[contains(@class,'ng-isolate-scope')]/section/div/h3/a[@href='#/%s/new']";
	
	
	
	public final Elements<CourseCatalogue_HomePage> coursecataloguehomepage = new Elements<CourseCatalogue_HomePage>("Page", homepageXpath,"xpath", this);
	public final Element<CourseCatalogue_HomePage> settings = new Element<CourseCatalogue_HomePage>("link", settingsXpath,"xpath", this);
	
	public static CourseCatalogue_HomePage get() {
        if (courseCatalogueHomePage == null) {
        	courseCatalogueHomePage = new CourseCatalogue_HomePage();
        }
        return courseCatalogueHomePage;
    }

}
