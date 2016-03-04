package com.webuitests.pages;

import com.webuiframework.oua.uitests.control.Element;
import com.webuiframework.oua.uitests.control.Elements;
import com.webuiframework.oua.uitests.control.Input;
import com.webuiframework.oua.uitests.control.Select;

public class CourseCatalogue_ProductsPage {
	
	private static CourseCatalogue_ProductsPage courseCatalogueProductsPage;
	
	public static String newProductXpath = "//a[@ui-sref='catalogue.products.new']";
	public static String newProductPageElementsXpath = "//div[@class='detailsContainer']";
	public static String pointtypeXpath = "//div[@ng-if='product.model.trainingPointsEnabled']";
	public static String numberofHoursXpath = "//div[@ng-if='product.model.trainingHoursEnabled']";
	public static String trainingPointHeaderXpath = "//div[contains(@class,'inline-group')][1]/span";
	public static String trainingHoursHeaderXpath = "//div[contains(@class,'inline-group')][2]/span";
	public static String enrolmentTypeid = "product-enrolment-type";
	public static String trainingpointsectionXpath = "//div[contains(@class,'training-points')]";
	public static String newProductSectionsXpath = "//h5";
	public static String mandatorymessageXpath = "//p[@id='']";
	public static String createnewproductbuttonXpath = "//button[@value='Save']/span";
	
	public final Input<CourseCatalogue_ProductsPage> newProductButton = new Input<CourseCatalogue_ProductsPage>("anchor", newProductXpath,"xpath", this);
	public final Elements<CourseCatalogue_ProductsPage> ProductPageElements = new Elements<CourseCatalogue_ProductsPage>("pageElements", newProductPageElementsXpath,"xpath", this);
	public final Element<CourseCatalogue_ProductsPage> pointType = new Element<CourseCatalogue_ProductsPage>("divElemnts", pointtypeXpath,"xpath", this);
	public final Element<CourseCatalogue_ProductsPage> numberofHours = new Element<CourseCatalogue_ProductsPage>("divElemnts", numberofHoursXpath,"xpath", this);
	public final Element<CourseCatalogue_ProductsPage> trainingPointHeader = new Element<CourseCatalogue_ProductsPage>("anchor", trainingPointHeaderXpath,"xpath", this);
	public final Element<CourseCatalogue_ProductsPage> trainingHourHeader = new Element<CourseCatalogue_ProductsPage>("anchor", trainingHoursHeaderXpath,"xpath", this);
	public final Select<CourseCatalogue_ProductsPage> enrolmenttype = new Select<CourseCatalogue_ProductsPage>("id", enrolmentTypeid,"id", this);
	public final Element<CourseCatalogue_ProductsPage> TrainingPointSection = new Element<CourseCatalogue_ProductsPage>("anchor", trainingpointsectionXpath,"xpath", this);
	public final Elements<CourseCatalogue_ProductsPage> NewProductSections = new Elements<CourseCatalogue_ProductsPage>("sections", newProductSectionsXpath,"xpath", this);
	public final Element<CourseCatalogue_ProductsPage> MandatoryMessage = new Element<CourseCatalogue_ProductsPage>("anchor", mandatorymessageXpath,"xpath", this);
	public final Element<CourseCatalogue_ProductsPage> CreateNewProductButton = new Element<CourseCatalogue_ProductsPage>("anchor", createnewproductbuttonXpath,"xpath", this);
	
	
	public static CourseCatalogue_ProductsPage get() {
        if (courseCatalogueProductsPage == null) {
        	courseCatalogueProductsPage = new CourseCatalogue_ProductsPage();
        }
        return courseCatalogueProductsPage;
    }

}
