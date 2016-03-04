package com.webuitests.pages;

import com.webuiframework.oua.uitests.control.Button;
import com.webuiframework.oua.uitests.control.Element;
import com.webuiframework.oua.uitests.control.Elements;
import com.webuiframework.oua.uitests.control.Input;
import com.webuiframework.oua.uitests.control.Label;
import com.webuiframework.oua.uitests.control.RadioButton;
import com.webuiframework.oua.uitests.panel.BasePanel;

public class LMSPage extends BasePanel<LMSPage>{
	
	private static LMSPage lMSPage;
	
	public static String learningManagementXpath = "//i[contains(@class,'fa-caret-down')]";
	public static String activityBuilderXpath = "//a[contains(@class,'Activity BuilderMenu')]";
	public static String userFullNameXpath = "//div[@id='contentPanel']/div/div/h2";
	public static String groupsPanelXpath = "//div[contains(@class,'container')]";
	public static String allgroupsinPanelXpath = "//div[contains(@class,'container')]/descendant::*";
	public static String selectGroupId = "group_radio";
	public static String searchBoxId = "searchBox";
	public static String searchButtonXpath = "//button[@type='submit']";
	public static String groupsearchResultsXpath = "//table[contains(@id,'searchResultsTable')]/descendant::*/a";
	public static String groupPhotoUploadId = "groupPhotoUpload";
	public static String lmsmenuXpath = "//div[@id='system_menu']/a/i";
	public static String menuitemsXpath = "//ul[contains(@class,'dropdown-menu')]/descendant::*/span[@bo-text='item.title']";
	public static String searchBoxInGroupsPanelXpath = "//input[contains(@placeholder,'Filter Groups & Accounts')]";
	public static String searchResultsInGroupsPanelXpath = "//div[@class='container']/ul/li/descendant::*/span";
	public static String createNewGroupXpath = "//div[@class='container']/h3/a[contains(@class,'new ng-scope')]";
	public static String newgroupDetailsPageId = "detailsContainer";
	public static String groupPageheaderXpath = "//div[@id='detailsContainer']/h2";
	public static String groupDetailsContainerXpath = "//div[@id ='detailsContainer']/descendant::*";
	public static String browsebuttonId = "file";
	public static String groupNameId = "group-name";
	public static String groupDescriptionId = "group-description";
	public static String SaveGroupXpath = "//button[@class='save']";
	public static String viewaccountdetailslinkXpath = "//a[text()='View your account details']";
	public static String coursecompletiongraphId = "chartDiv2";
	public static String groupTabsXpath = "//ul[contains(@class,'tabs')]/li/a"; 
	public static String defaultSelectedTabXpath = "//ul[contains(@class,'tabs')]/li/a[contains(text(),'LEARNING ACTIVITIES')]/..";
	public static String addlearningactivityXpath = "//div[contains(@class,'addCourse')]/h6/a";
	public static String addenrolcoursebuttonXpath = "//div[contains(@class,'addCourse')]/descendant::*/button[@type='submit']";
	public static String enrollcourseinputboxXpath = "//span[@id='EG-unit']/input[@placeholder='Search..']";
	public static String enrolledCourseXpath = "//h6[@class='course-title']/span[@class='titletext']";
	public static String detailscontainerXpath = "//div[@id='detailsContainer']/descendant::*";
	public static String enrolCourseOptionXpath = "//li[contains(text(),'activity admin')]";
	public static String removeCourseXpath = "//a[contains(@class,'removeCourse')]";
	public static String confirmationMessageXpath = "//div[contains(@class,'message')]";
	public static String deleteactivityConfirmationOkButtonXpath = "//button[contains(@class,'default')]";
	public static String permissionListContainerElementsXpath = "//div[@id='parentListContainer']/descendant::*/h5";
	public static String showModuleXpath = "//h5[contains(text(),'%s')]/../a";
	public static String currentReportingstatusXpath = "//div[contains(@class,'existingPermission')]/descendant::*/label[text()='ON']/..";
	public static String reportingONXpath = "//div[contains(@class,'existingPermission')]//div[contains(@class,'ibutton-container')]//div[contains(@class,'ibutton-label')]//span/label[contains(text(),'OFF')]";
	public static String permissionConfirmationmessage = "//div[@class='message']";
	public static String ImageCropXpath = "//div[@class ='croppable']/descendant::*";
	public static String imageCropbuttonXpath = "//div[@class ='controls-bottom']//div[@class='save']/i";
	public static String groupsandaccountsContextMenuXpath = "//a[@class ='context-menu-toggle']";
	public static String groupsandaccountsContextMenuitemsXpath = "//ul[contains(@class,'context-menu-dropdown')]/descendant::*/a";
	public static String groupnameinEditpageXpath = "//div[@id='detailsContainer']/h2";
	public static String groupsinlmsXpath = "//div[contains(@class,'container')]/descendant::*/span[text()='%s']";
	public static String groupsandaccountsXpath = "//div[contains(@class,'container')]/h3[contains(@class,'nav-section-title ng-binding newlink')]";
	public static String blocktabsXpath = "//ul[contains(@class,'block tabs')]/li/a[text()='%s']";
	public static String permissionspageXpath = "//header[contains(@class,'lf-header--breadcrumbs')]";
	public static String clickonselectroleXpath = "//label[(text()='Select a role')]/../select";
	public static String selectroleXpath = "//label[(text()='Select a role')]/../select/../descendant::*/option[text()='%s']";
	public static String addapermissionXpath = "//div[contains(@class,'actionPanel')]/h6/a";
	public static String permissiontypeXpath = "//div[contains(@class,'input-group')]/select";
	public static String permissiontoassignunitXpath = "//div[contains(@class,'input-group')]/select/optgroup/option[text()='%s']";
	public static String courseidXpath = "//span[contains(@class,'hidecreateperm')]/input";
	public static String addbuttonXpath = "//button[contains(@class,'primary')]";
	public static String assainandenrollcourseXpath = "//div[contains(@id,'permList')]/table/tbody/tr/td[text()='%s']/../td/span";
	public static String adminactivityXpath = "//span[contains(@class,'titletext')]";
	public static String activityelementvalidationXpath = "//div[@class='objectives']";
	public static String activityvalidationXpath = "//div[@class='objectives']/table/thead/tr/th";
	public static String activityelementsXpath = "//div[@class='objectives']/table/tbody/tr/td";
	public static String resetXpath = "//a[contains(@class,'action setReset')]";
	public static String resetbuttonsXpath = "//div[contains(@class,'buttons')]/button";
	public static String resetactivityXpath = "//div[contains(@class,'message')]/h2";
	public static String resetdateXpath = "//input[contains(@class,'dateField')]";
	public static String resetactivitynameXpath = "//div[contains(@class,'message')]/p";
	public static String lmsblocktabsXpath = "//div[@id='detailstabs']/ul/li/a";
	public static String selectedtabXpath = "//div[@id='detailstabs']/ul/li[contains(@class,'tab selectedTab')]";
	public static String completionvaluesXpath ="//table[contains(@class,'genericTable objectiveHistory')]/thead/tr/th";
	public static String detailpagevaluesXpath = "//table[contains(@class,'genericTable')]/thead/tr/th";
	public static String removeactivityXpath = "//tbody[@id='groupEnrolContainer']/tr/td[contains(text(),'%s')]/../td/a[contains(@title,'Remove Course')]";
	public static String removemessageXpath = "//div[@class='message']";
	public static String removemessagebuttonsXpath = "//button[text()='%s']";
	public static String validatectivityXpath = "//tbody[@id='groupEnrolContainer']/tr/td[contains(text(),'%s')]";
	
	 public final Element<LMSPage> learningManagement = new Element<LMSPage>("element", learningManagementXpath,"xpath", this);
	 public final Element<LMSPage> activityBuilder = new Element<LMSPage>("element", activityBuilderXpath,"xpath", this);
	 public final Label<LMSPage> userFullName = new Label<LMSPage>("label", userFullNameXpath,"xpath", this);
	 public final Elements<LMSPage> allgroupsinPanel = new Elements<LMSPage>("allgroups", allgroupsinPanelXpath,"xpath", this);
	 public final Element<LMSPage> grouppanel = new Element<LMSPage>("groupPanel", groupsPanelXpath,"xpath", this);
	 public final Input<LMSPage> groupphototUpload = new Input<LMSPage>("inputgroupphoto", groupPhotoUploadId,"id", this);
	 public final RadioButton<LMSPage> selectGroup = new RadioButton<LMSPage>("groupradioButton", selectGroupId,"id", this);
	 public final Input<LMSPage> searchBox = new Input<LMSPage>("searchBoxInput", searchBoxId,"id", this);
	 public final Button<LMSPage> searchButton = new Button<LMSPage>("searchButton", searchButtonXpath,"xpath", this);
	 public final Elements<LMSPage> searchResults = new Elements<LMSPage>("searchresults", groupsearchResultsXpath,"xpath", this);
	 public final Button<LMSPage> menuButton = new Button<LMSPage>("lmsmenu", lmsmenuXpath,"xpath", this);
	 public final Elements<LMSPage> menuitems = new Elements<LMSPage>("menuitems", menuitemsXpath,"xpath", this);
	 public final Elements<LMSPage> searchResultsInGroupsPanel = new Elements<LMSPage>("searchresultsIngrouppanel", searchResultsInGroupsPanelXpath,"xpath", this);
	 public final Input<LMSPage> searchBoxIngroupsPanel = new Input<LMSPage>("searchBoxInputInSearchPanel", searchBoxInGroupsPanelXpath,"xpath", this);
	 public final Input<LMSPage> createNewGroup = new Input<LMSPage>("createNewGroup", createNewGroupXpath,"xpath", this);
	 public final Element<LMSPage> groupPagecontainer = new Element<LMSPage>("groupPagecontainer", newgroupDetailsPageId,"id", this);
	 public final Elements<LMSPage> groupDetailsContainer = new Elements<LMSPage>("groupPagecontainer", groupDetailsContainerXpath,"id", this);
	 public final Element<LMSPage> groupPageHeader = new Element<LMSPage>("groupPageHeader", groupPageheaderXpath,"xpath", this);
	 public final Button<LMSPage> browseButton = new Button<LMSPage>("browseButton", browsebuttonId,"id", this);
	 public final Input<LMSPage> groupName = new Input<LMSPage>("groupnameinput", groupNameId,"id", this);
	 public final Input<LMSPage> groupDescription = new Input<LMSPage>("groupdescription", groupDescriptionId,"id", this);
	 public final Button<LMSPage> savegroup = new Button<LMSPage>("savegroupbutton", SaveGroupXpath,"xpath", this);
	 public final Element<LMSPage> accountdetailsLink = new Element<LMSPage>("accountdetailsLink",viewaccountdetailslinkXpath,"xpath",this);
	 public final Element<LMSPage> coursecompletion = new Element<LMSPage>("coursecompletioncontainer",coursecompletiongraphId,"id",this);
	 public final Elements<LMSPage> allTabs = new Elements<LMSPage>("groupTabs",groupTabsXpath,"xpath",this);
	 public final Element<LMSPage> defaultSelectedTab = new Element<LMSPage>("defaultTab",defaultSelectedTabXpath,"xpath",this);
	 public final Element<LMSPage> addlearningactivity = new Element<LMSPage>("achor",addlearningactivityXpath,"xpath",this);
	 public final Button<LMSPage> addenrolcourse = new Button<LMSPage>("button", addenrolcoursebuttonXpath,"xpath", this);
	 public final Input<LMSPage> enrollcourseinput = new Input<LMSPage>("enrolcourseinputbox", enrollcourseinputboxXpath,"xpath", this);
	 public final Element<LMSPage> enroledCourse = new Element<LMSPage>("span",enrolledCourseXpath,"xpath",this);
	 public final Elements<LMSPage> detailesContainer = new Elements<LMSPage>("courseelements",detailscontainerXpath,"xpath",this);
	 public final Element<LMSPage> enrolCourseOption = new Element<LMSPage>("listitems",enrolCourseOptionXpath,"xpath",this);
	 public final Element<LMSPage> removeCourse = new Element<LMSPage>("achor",removeCourseXpath,"xpath",this);
	 public final Element<LMSPage> courseDeleteConfirmationMessage = new Element<LMSPage>("message",confirmationMessageXpath,"xpath",this);
	 public final Button<LMSPage> confirmationMessageAccept = new Button<LMSPage>("button", deleteactivityConfirmationOkButtonXpath,"xpath", this);
	 public final Elements<LMSPage> permissionListContainerElements = new Elements<LMSPage>("containerElements",permissionListContainerElementsXpath,"xpath",this);
	 public final Element<LMSPage> showModule = new Element<LMSPage>("container",showModuleXpath,"xpath",this);
	 public final Input<LMSPage> currentReportingStatus = new Input<LMSPage>("checkbox",currentReportingstatusXpath,"xpath",this);
	 public final Element<LMSPage> providereportingpermissionON = new Element<LMSPage>("checkbox",reportingONXpath,"xpath",this);
	 public final Element<LMSPage> permissionConfirmationMessage = new Element<LMSPage>("message",permissionConfirmationmessage,"xpath",this);
	 public final Elements<LMSPage> imagecropElements = new Elements<LMSPage>("imageCrop",ImageCropXpath,"xpath",this);
	 public final Element<LMSPage> imageCropButton = new Element<LMSPage>("imageCropButton",imageCropbuttonXpath,"xpath",this);
	 public final Element<LMSPage> groupsandAccContextMenu = new Element<LMSPage>("menu",groupsandaccountsContextMenuXpath,"xpath",this);
	 public final Elements<LMSPage> groupsandAccountscontextMenuItems = new Elements<LMSPage>("menuitems",groupsandaccountsContextMenuitemsXpath,"xpath",this);
	 public final Element<LMSPage> groupNameinEditPage = new Element<LMSPage>("header",groupnameinEditpageXpath,"xpath",this);
	 public final Elements<LMSPage> GroupsInLMS = new Elements<LMSPage>("class",groupsinlmsXpath,"xpath",this);
	 public final Elements<LMSPage> GroupsandAccounts = new Elements<LMSPage>("class",groupsandaccountsXpath,"xpath",this);
	 public final Elements<LMSPage> BlockTabs = new Elements<LMSPage>("class",blocktabsXpath,"xpath",this);
	 public final Element<LMSPage> PermissionsPage = new Element<LMSPage>("class",permissionspageXpath,"xpath",this);
	 public final Element<LMSPage> ClickOnSelectRole = new Element<LMSPage>("class",clickonselectroleXpath,"xpath",this);
	 public final Elements<LMSPage> SelectRole = new Elements<LMSPage>("class",selectroleXpath,"xpath",this);
	 public final Element<LMSPage> AddaPermission = new Element<LMSPage>("class",addapermissionXpath,"xpath",this);
	 public final Element<LMSPage> PermissionType = new Element<LMSPage>("class",permissiontypeXpath,"xpath",this);
	 public final Input<LMSPage> CourseId = new Input<LMSPage>("class",courseidXpath,"xpath",this);
	 public final Button<LMSPage> AddButton = new Button<LMSPage>("button",addbuttonXpath,"xpath",this); 
	 public final Elements<LMSPage> AdminActivity = new Elements<LMSPage>("class",adminactivityXpath,"xpath",this);
	 public final Elements<LMSPage> ActivityElementValidation = new Elements<LMSPage>("class",activityelementvalidationXpath,"xpath",this);
	 public final Elements<LMSPage> ActivityValidation = new Elements<LMSPage>("class",activityvalidationXpath,"xpath",this);
	 public final Elements<LMSPage> ActivityElements = new Elements<LMSPage>("class",activityelementsXpath,"xpath",this);
	 public final Button<LMSPage> Reset = new Button<LMSPage>("button",resetXpath,"xpath",this);
	 public final Elements<LMSPage> ResetButtons = new Elements<LMSPage>("class",resetbuttonsXpath,"xpath",this);
	 public final Element<LMSPage> ResetActivity = new Element<LMSPage>("class",resetactivityXpath,"xpath",this);
	 public final Element<LMSPage> ResetActivityName = new Element<LMSPage>("class",resetactivitynameXpath,"xpath",this);
	 public final Input<LMSPage> ResetDate = new Input<LMSPage>("class",resetdateXpath,"xpath",this);
	 public final Element<LMSPage> SelectedTab = new Element<LMSPage>("class",selectedtabXpath,"xpath",this);
	 public final Elements<LMSPage> LMSBlockTabs = new Elements<LMSPage>("class",lmsblocktabsXpath,"xpath",this);
	 public final Elements<LMSPage> CompletionValues = new Elements<LMSPage>("class",completionvaluesXpath,"xpath",this);
	 public final Elements<LMSPage> DetailPageValues = new Elements<LMSPage>("class",detailpagevaluesXpath,"xpath",this);
	 public final Element<LMSPage> RemoveActivity = new Element<LMSPage>("class",removeactivityXpath,"xpath",this);
	 public final Element<LMSPage> RemoveMessage = new Element<LMSPage>("class",removemessageXpath,"xpath",this);
	 public final Element<LMSPage> RemoveMessageButtons = new Element<LMSPage>("button",removemessagebuttonsXpath,"xpath",this);
	 
	 public static LMSPage get() {
	        if (lMSPage == null) {
	        	lMSPage = new LMSPage();
	        }
	        return lMSPage;
	    }
	

}