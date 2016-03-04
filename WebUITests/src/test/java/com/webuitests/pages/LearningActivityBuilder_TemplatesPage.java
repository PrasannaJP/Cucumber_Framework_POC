package com.webuitests.pages;

import com.webuiframework.oua.uitests.control.Button;
import com.webuiframework.oua.uitests.control.Element;
import com.webuiframework.oua.uitests.control.Elements;
import com.webuiframework.oua.uitests.control.Input;
import com.webuiframework.oua.uitests.control.Label;
import com.webuiframework.oua.uitests.panel.BasePanel;

public class LearningActivityBuilder_TemplatesPage extends BasePanel<LearningActivityBuilder_TemplatesPage>{

	private static LearningActivityBuilder_TemplatesPage lABTemplatesPage;
	
	public static String createnewactivitybuttonXpath = "//button[contains(@class,'btn btn-primary btn-create-activity')]";	
	public static String changecoverimageXpath = "//i[@class='fa fa-file-image-o']";
	public static String verifyimageXpath = "//div[contains(@style,'background-image: url')]";
	public static String activitynameXpath = "//div[@class='inline-editable ng-binding ng-pristine ng-valid']";
	public static String browsefileXpath = "//a[@class='button add ng-binding ng-isolate-scope']";
	public static String activitydashboardXpath = "//a[contains(@ng-href,'/lab/#/')]";
	public static String menuXpath ="//i[contains(@class,'fa fa-bars')]";
	public static String activityhistorylogXpath = "//div[@class='history-log side-bar-scroller']/descendant::*/div[@class='log-details']/a";
	public static String qtphistorylogXpath = "//div[contains(@class,'log-details')]/a";
	public static String contextmenuXpath = "//i[@class='fa fa-ellipsis-v']";
	public static String editimageXpath = "//ul[@class='dropdown-menu']";
	public static String deleteimageXpath = "//a[@class='ng-isolate-scope']";	
	public static String warningmessageXpath = "//div[@class='modal-content']";
	public static String yesmessageXpath = "//button[@ng-click='ok()']";
	public static String allactivityXpath = "//div[@class='activity-name']/a";
	public static String renameactivityXpath = "//h1/div[contains(@ng-show,'LAB_ACTIVITY')]";
	public static String closeactivityXpath = "//a[@class='close-activity']/i";
	public static String coursestructureXpath = "//div[@class='activity-nav']";
	public static String headerXpath = "//a[@class='action-button ng-binding']";
	public static String editContentXpath = "//div[@class='editContent']";
	public static String previewXpath = "//i[@class='fa fa-play']";
	public static String previecoursenameXpath = "//h1[@class='ng-binding']";
	public static String topicnameXpath = "//div[@class='component-header html-page-header ng-scope']/h1";
	public static String gototopicXpath = "//span[@class='component-title ng-binding']";
	public static String headerlayoutXpath = "//ul[@class='square-icon-menu nav nav-pills']/li";
	public static String saveTopicXpath =  "//button[contains(@ng-click, 'save()')]";
	public static String saveMessageXpath =  "//strong[contains(@class, 'message ng-binding')]";
	public static String savedXpath = "//div[contains(@class,'grid-wrapper')]/descendant::*/div[@class='activity-name']/a";
	public static String addbttonXpath = "//button[contains(@class,'action-button')]";
	public static String addtopicXpath = "//li[contains(@title,'Add New Topic')]";
	public static String newTopicXpath = "//div[contains(@ng-model,'component.title')]";
	public static String topicimagerightXpath = "//div[contains(@class,'gridster-content')]/ul/li";
	public static String splashXpath = "//div[@class='text ng-scope']";
	public static String imageidXpath = "//div[@id='uiTinymce58']";
	public static String verifytopicimageXpath = "//div[@class='image-container ng-scope']";
	public static String welcometextXpath = "div[ng-model='item.description'] > p";
	public static String topicbrowseXpath = "//a[@class='button add ng-binding ng-isolate-scope']";
	public static String previewtopicXpath ="//div[@class='component-header html-page-header ng-scope']";
	public static String previewtopictextXpath = "//div[@class='tinymce-editor ng-scope ng-isolate-scope ng-valid mce-content-body ng-dirty']";
	public static String previewimagesXpath = "//div[@class='ng-scope ng-isolate-scope gridster gridster-desktop gridster-loaded']";
	public static String topictextXpath = "//div[contains(@ng-model,'description')]";
	public static String topicimagesXpath = "//div[contains(@ng-switch-when,'image')]";
	public static String topicbrowsesecondimageXpath = "//a[contains(@class,'button add ng-binding ng-isolate-scope')]";
	public static String topicbrowsebothimagesXpath = "//div[contains(@class,'image-container ng-scope')]";	
	public static String courseimagesXpath = "//section[1]/div/div[1]/ul/li[1]/div/div[1]";
	public static String qtpimagessatausXpath = "//li[contains(@class,'activity ng-scope inactive')]/descendant::*/div[@class='activity-name']/a";
	public static String qtpimagessatausimageXpath = "//li[contains(@class,'activity ng-scope inactive')]/descendant::*/div[@class='thumbnail']";
	public static String qtpimagetextXpath = "//div[contains(@class,'text ng-scope')]/div/p";
	public static String progressbarXpath = "//div[contains(@class,'progress-bar')]";
	public static String componentNameXpath = "//li[contains(@class,'tree-item')]/a";
		
	
	public final Elements<LearningActivityBuilder_TemplatesPage> qtpimagessatausimage = new Elements<LearningActivityBuilder_TemplatesPage>("elements", qtpimagessatausimageXpath,"xpath", this);
	public final Elements<LearningActivityBuilder_TemplatesPage> qtpimagessataus = new Elements<LearningActivityBuilder_TemplatesPage>("elements", qtpimagessatausXpath,"xpath", this);
	public final Element<LearningActivityBuilder_TemplatesPage> menu = new Element<LearningActivityBuilder_TemplatesPage>("element", menuXpath,"xpath", this);	
	public final Element<LearningActivityBuilder_TemplatesPage> changecoverimage = new Element<LearningActivityBuilder_TemplatesPage>("class", changecoverimageXpath,"xpath", this);
	public final Element<LearningActivityBuilder_TemplatesPage> verifyimage = new Element<LearningActivityBuilder_TemplatesPage>("class", verifyimageXpath,"xpath", this);
	public final Input<LearningActivityBuilder_TemplatesPage> activityname = new Input<LearningActivityBuilder_TemplatesPage>("class", activitynameXpath,"xpath", this);
	public final Button<LearningActivityBuilder_TemplatesPage> browsefile = new Button<LearningActivityBuilder_TemplatesPage>("button", browsefileXpath,"xpath", this);
	public final Button<LearningActivityBuilder_TemplatesPage> activitydashboard = new Button<LearningActivityBuilder_TemplatesPage>("button", activitydashboardXpath,"xpath", this);
	public final Elements<LearningActivityBuilder_TemplatesPage> activityhistorylog = new Elements<LearningActivityBuilder_TemplatesPage>("class", activityhistorylogXpath,"xpath", this);
	public final Elements<LearningActivityBuilder_TemplatesPage> qtphistorylog = new Elements<LearningActivityBuilder_TemplatesPage>("class", qtphistorylogXpath,"xpath", this);
	public final Element<LearningActivityBuilder_TemplatesPage> contextmenu = new Element<LearningActivityBuilder_TemplatesPage>("class", contextmenuXpath,"xpath", this);
	public final Elements<LearningActivityBuilder_TemplatesPage> editimage = new Elements<LearningActivityBuilder_TemplatesPage>("class", editimageXpath,"xpath", this);
	public final Button<LearningActivityBuilder_TemplatesPage> deleteimage= new Button<LearningActivityBuilder_TemplatesPage>("class", deleteimageXpath,"xpath", this);
	public final Elements<LearningActivityBuilder_TemplatesPage> warningmessage = new Elements<LearningActivityBuilder_TemplatesPage>("class", warningmessageXpath,"xpath", this);
	public final Button<LearningActivityBuilder_TemplatesPage> yesmessage = new Button<LearningActivityBuilder_TemplatesPage>("class",yesmessageXpath, "xpath", this);
	public final Elements<LearningActivityBuilder_TemplatesPage> Allactivities = new Elements<LearningActivityBuilder_TemplatesPage>("class", allactivityXpath,"xpath", this);
	public final Input<LearningActivityBuilder_TemplatesPage> renameactivity = new Input<LearningActivityBuilder_TemplatesPage>("class", renameactivityXpath,"xpath", this);
	public final Button<LearningActivityBuilder_TemplatesPage> closeactivity = new Button<LearningActivityBuilder_TemplatesPage>("button", closeactivityXpath,"xpath", this);
	public final Button<LearningActivityBuilder_TemplatesPage> coursestructure = new Button<LearningActivityBuilder_TemplatesPage>("button", coursestructureXpath,"xpath", this);
	public final Button<LearningActivityBuilder_TemplatesPage> header = new Button<LearningActivityBuilder_TemplatesPage>("button", headerXpath,"xpath", this);
	public final Elements<LearningActivityBuilder_TemplatesPage> editContent = new Elements<LearningActivityBuilder_TemplatesPage>("class", editContentXpath,"xpath", this);
	public final Element<LearningActivityBuilder_TemplatesPage> preview = new Element<LearningActivityBuilder_TemplatesPage>("class", previewXpath,"xpath", this);
	public final Element<LearningActivityBuilder_TemplatesPage> previecoursename = new Element<LearningActivityBuilder_TemplatesPage>("class", previecoursenameXpath,"xpath", this);
	public final Element<LearningActivityBuilder_TemplatesPage> topicname = new Element<LearningActivityBuilder_TemplatesPage>("class", topicnameXpath,"xpath", this);
	public final Element<LearningActivityBuilder_TemplatesPage> gototopic = new Element<LearningActivityBuilder_TemplatesPage>("class", gototopicXpath,"xpath", this);
	public final Elements<LearningActivityBuilder_TemplatesPage> headerlayout = new Elements<LearningActivityBuilder_TemplatesPage>("class", headerlayoutXpath,"xpath", this);
	public final Button<LearningActivityBuilder_TemplatesPage> activityButton = new Button<LearningActivityBuilder_TemplatesPage>("button", createnewactivitybuttonXpath,"xpath", this);
	public final Button<LearningActivityBuilder_TemplatesPage> saveTopic = new Button<LearningActivityBuilder_TemplatesPage>("button", saveTopicXpath,"xpath", this);
	public final Label<LearningActivityBuilder_TemplatesPage> saveMessage = new Label<LearningActivityBuilder_TemplatesPage>("label", saveMessageXpath,"xpath", this);
	public final Elements<LearningActivityBuilder_TemplatesPage> savedActivity = new Elements<LearningActivityBuilder_TemplatesPage>("elements", savedXpath,"xpath", this);
	public final Button<LearningActivityBuilder_TemplatesPage> addbtton = new Button<LearningActivityBuilder_TemplatesPage>("button", addbttonXpath,"xpath", this);
	public final Element<LearningActivityBuilder_TemplatesPage> addtopic = new Element<LearningActivityBuilder_TemplatesPage>("element", addtopicXpath,"xpath", this);
	public final Input<LearningActivityBuilder_TemplatesPage> newTopic = new Input<LearningActivityBuilder_TemplatesPage>("input", newTopicXpath,"xpath", this);
	public final Elements<LearningActivityBuilder_TemplatesPage> topicimageright = new Elements<LearningActivityBuilder_TemplatesPage>("label", topicimagerightXpath,"xpath", this);
	public final Elements<LearningActivityBuilder_TemplatesPage> splash = new Elements<LearningActivityBuilder_TemplatesPage>("label", splashXpath,"xpath", this);
	public final Elements<LearningActivityBuilder_TemplatesPage> imageid = new Elements<LearningActivityBuilder_TemplatesPage>("label", imageidXpath,"xpath", this);
	public final Element<LearningActivityBuilder_TemplatesPage> verifytopicimage = new Element<LearningActivityBuilder_TemplatesPage>("class", verifytopicimageXpath,"xpath", this);
	public final Input<LearningActivityBuilder_TemplatesPage> welcometext = new Input<LearningActivityBuilder_TemplatesPage>("label", welcometextXpath,"css", this);
	public final Element<LearningActivityBuilder_TemplatesPage> topicbrowse = new Element<LearningActivityBuilder_TemplatesPage>("class", topicbrowseXpath,"xpath", this);
	public final Element<LearningActivityBuilder_TemplatesPage> previewtopic = new Element<LearningActivityBuilder_TemplatesPage>("class", previewtopicXpath,"xpath", this);
	public final Element<LearningActivityBuilder_TemplatesPage> previewtopictext =  new Element<LearningActivityBuilder_TemplatesPage>("class", previewtopictextXpath,"xpath", this);
	public final Element<LearningActivityBuilder_TemplatesPage> previewimages =  new Element<LearningActivityBuilder_TemplatesPage>("class", previewimagesXpath,"xpath", this);
	public final Elements<LearningActivityBuilder_TemplatesPage> topictext = new Elements<LearningActivityBuilder_TemplatesPage>("label", topictextXpath,"xpath", this);
	public final Elements<LearningActivityBuilder_TemplatesPage> topicimages = new Elements<LearningActivityBuilder_TemplatesPage>("label", topicimagesXpath,"xpath", this);
	public final Element<LearningActivityBuilder_TemplatesPage> topicbrowsesecondimage = new Element<LearningActivityBuilder_TemplatesPage>("label", topicbrowsesecondimageXpath,"xpath", this);
	public final Elements<LearningActivityBuilder_TemplatesPage> topicbrowsebothimages = new Elements<LearningActivityBuilder_TemplatesPage>("label", topicbrowsebothimagesXpath,"xpath", this);
	public final Element<LearningActivityBuilder_TemplatesPage> qtpimagetext = new Element<LearningActivityBuilder_TemplatesPage>("label", qtpimagetextXpath,"xpath", this);
	public final Element<LearningActivityBuilder_TemplatesPage> ProgressBar = new Element<LearningActivityBuilder_TemplatesPage>("label", progressbarXpath,"xpath", this);
	public final Elements<LearningActivityBuilder_TemplatesPage> LearningComponents = new Elements<LearningActivityBuilder_TemplatesPage>("span", componentNameXpath,"xpath", this);
	
	public static LearningActivityBuilder_TemplatesPage get() {
        if (lABTemplatesPage == null) {
        	lABTemplatesPage = new LearningActivityBuilder_TemplatesPage();
        }
        return lABTemplatesPage;
    }
}
