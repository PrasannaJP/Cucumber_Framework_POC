package com.webuitests.pages;

import com.webuiframework.oua.uitests.control.Button;
import com.webuiframework.oua.uitests.control.Element;
import com.webuiframework.oua.uitests.control.Elements;

public class CourseCatalogue_CategoriesPage {
	
	private static CourseCatalogue_CategoriesPage courseCatalogueCategoriesPage;
	
	public static String newcategorypageelementsXpath = "//form//descendant::*";
	public static String createnewCategorybuttonXpath = "//button[@value='Save']/span";
	public static String pagesectionsXpath = "//h5";
	public static String pageheaderXpath = "//h2";
	
	public final Elements<CourseCatalogue_CategoriesPage> NewCategoryPageElements = new Elements<CourseCatalogue_CategoriesPage>("pageelements", newcategorypageelementsXpath,"xpath", this);
	public final Button<CourseCatalogue_CategoriesPage> Createnewcategory = new Button<CourseCatalogue_CategoriesPage>("button", createnewCategorybuttonXpath,"xpath", this);
	public final Elements<CourseCatalogue_CategoriesPage> SectionHeaders = new Elements<CourseCatalogue_CategoriesPage>("header", pagesectionsXpath,"xpath", this);
	public final Element<CourseCatalogue_CategoriesPage> PageHeader = new Element<CourseCatalogue_CategoriesPage>("header", pageheaderXpath,"xpath", this);
	
	public static CourseCatalogue_CategoriesPage get() {
        if (courseCatalogueCategoriesPage == null) {
        	courseCatalogueCategoriesPage = new CourseCatalogue_CategoriesPage();
        }
        return courseCatalogueCategoriesPage;
    }

}
