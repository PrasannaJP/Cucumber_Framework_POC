package com.webuitests.pages;

import com.webuiframework.oua.uitests.control.Button;
import com.webuiframework.oua.uitests.control.Element;
import com.webuiframework.oua.uitests.control.Elements;
import com.webuiframework.oua.uitests.control.Input;

public class CourseCatalogue_SettingsPage {
	
	private static CourseCatalogue_SettingsPage courseCatalogueSettingsPage;
	
	public static String settingspageXpath = "//div[@class='detailsContainer']/descendant::*";
	public static String settingsPageElementsXpath = "//section[@class='main-content']/descendant::*";
	public static String SettingsPageTitleXpath = "//span[@class='tab-title']";
	public static String SettingsPageHeaderXpath = "//h2[@class='ng-scope']";
	public static String coursecataloguecheckboxstatusheaderXpath = "//checkbox-field";
	public static String SavebuttonXpath = "//input[contains(@type,'submit')]";
	public static String CourseCatalogueCheckBoxXpath = "//div[@class='noticePanel']/descendant::*/span[@class='switch-handle']";
	public static String CatalogueTitleXpath = "//input[contains(@placeholder,'enter a catalogue title')]";
	public static String CatalogueDescriptionXpath = "//textarea[contains(@placeholder,'enter a catalogue description')]";
	public static String trainingReminderDaysid = "n5ky";
	public static String typeOfTrainingPointTypeid = "training-points-type";
	public static String selectUserXpath = "//div[contains(@class,'new-approver')]/descendant::*/input[contains(@class,'ui-select-search ui-select-toggle ng-valid ng-dirty')]";
	public static String requestapprovaldetailsTabXpath = "//div[contains(@class,'user-group-role')]/descendant::*/li/a[starts-with(text(),'%s')]";
	public static String selectgroupXpath ="//div[contains(@placeholder,'Select a group')]/../input";
	public static String selectrolexpath = "//div[contains(@placeholder,'Select a role')]/../input";
	public static String reminderdaysxpath = "//text-field[@label='Reminder days']/descendant::*/input";
	public static String trainingpointtypeid = "training-points-type";
	public static String addtrainingpointtypeXpath = "//button[contains(@class,'add-type')]";
	public static String currenttrainingtypeXpath = "//ul[contains(@class,'traning-point-types')]/li/span";
	public static String removecurrenttrainingtypeXpath = "//ul[contains(@class,'traning-point-types')]/li/a";
	public static String notificationmessageXpath ="//strong[contains(@class, 'message ng-binding')]";
	public static String cataloguedetailssectionXPath = "//div[contains(@class,'fx-fade-normal')]";
	public static String approvalTabLoaderXpath = "//div[contains(@class,'loading')]";
	
	public final Elements<CourseCatalogue_SettingsPage> settingsPage = new Elements<CourseCatalogue_SettingsPage>("Page", settingspageXpath,"xpath", this);
	public final Elements<CourseCatalogue_SettingsPage> settingsUIElements = new Elements<CourseCatalogue_SettingsPage>("Page", settingspageXpath,"xpath", this);
	public final Element<CourseCatalogue_SettingsPage> seetingsPageTab = new Element<CourseCatalogue_SettingsPage>("Page", SettingsPageTitleXpath,"xpath", this);
	public final Element<CourseCatalogue_SettingsPage> SettingsPageHeader = new Element<CourseCatalogue_SettingsPage>("Page", SettingsPageHeaderXpath,"xpath", this);
	public final Element<CourseCatalogue_SettingsPage> CourseCataloguecheckboxStatusHeader = new Element<CourseCatalogue_SettingsPage>("label", coursecataloguecheckboxstatusheaderXpath,"xpath", this);
	public final Element<CourseCatalogue_SettingsPage> SaveSettings = new Element<CourseCatalogue_SettingsPage>("button", SavebuttonXpath,"xpath", this);
	public final Input<CourseCatalogue_SettingsPage> CourseCatalogueCheckBox = new Input<CourseCatalogue_SettingsPage>("checkbox", CourseCatalogueCheckBoxXpath,"xpath", this);
	public final Input<CourseCatalogue_SettingsPage> CatalogueTitle = new Input<CourseCatalogue_SettingsPage>("input", CatalogueTitleXpath,"xpath", this);
	public final Input<CourseCatalogue_SettingsPage> CatalogueDescription = new Input<CourseCatalogue_SettingsPage>("input", CatalogueDescriptionXpath,"xpath", this);
	public final Input<CourseCatalogue_SettingsPage> TrainingReminderDays = new Input<CourseCatalogue_SettingsPage>("input", trainingReminderDaysid,"id", this);
	public final Input<CourseCatalogue_SettingsPage> TypeOfTrainingPoint = new Input<CourseCatalogue_SettingsPage>("input", typeOfTrainingPointTypeid,"id", this);
	public final Input<CourseCatalogue_SettingsPage> SelectUser = new Input<CourseCatalogue_SettingsPage>("input", selectUserXpath,"xpath", this);
	public final Element<CourseCatalogue_SettingsPage> RequestapprovaldetailsTab = new Element<CourseCatalogue_SettingsPage>("div", requestapprovaldetailsTabXpath,"xpath", this);
	public final Input<CourseCatalogue_SettingsPage> SelectGroup = new Input<CourseCatalogue_SettingsPage>("input", selectgroupXpath,"xpath", this);
	public final Input<CourseCatalogue_SettingsPage> SelectRole = new Input<CourseCatalogue_SettingsPage>("input", selectrolexpath,"xpath", this);
	public final Input<CourseCatalogue_SettingsPage> ReminderDays = new Input<CourseCatalogue_SettingsPage>("input", reminderdaysxpath,"xpath", this);
	public final Input<CourseCatalogue_SettingsPage> TrainingpointType = new Input<CourseCatalogue_SettingsPage>("input", trainingpointtypeid,"id", this);
	public final Button<CourseCatalogue_SettingsPage> AddTrainingPointType = new Button<CourseCatalogue_SettingsPage>("button", addtrainingpointtypeXpath,"xpath", this);
	public final Elements<CourseCatalogue_SettingsPage> CurrentTrainingPointType = new Elements<CourseCatalogue_SettingsPage>("elemnts", currenttrainingtypeXpath,"xpath", this);
	public final Element<CourseCatalogue_SettingsPage> RemoveCurrentTrainingPoint = new Element<CourseCatalogue_SettingsPage>("button", removecurrenttrainingtypeXpath,"xpath", this);
	public final Element<CourseCatalogue_SettingsPage> NotificationMessage = new Element<CourseCatalogue_SettingsPage>("element", notificationmessageXpath,"xpath", this);
	public final Element<CourseCatalogue_SettingsPage> CatalogueDetailsSection = new Element<CourseCatalogue_SettingsPage>("element", cataloguedetailssectionXPath,"xpath", this);
	
	
	public static CourseCatalogue_SettingsPage get() {
        if (courseCatalogueSettingsPage == null) {
        	courseCatalogueSettingsPage = new CourseCatalogue_SettingsPage();
        }
        return courseCatalogueSettingsPage;
    }
}
