package com.webuitests.pages;


import com.webuiframework.oua.uitests.control.Element;
import com.webuiframework.oua.uitests.control.Elements;
import com.webuiframework.oua.uitests.control.Input;
import com.webuiframework.oua.uitests.panel.BasePanel;

public class AdminPage extends BasePanel<LMSPage>{
	private static AdminPage adminpage; 
	
	public static String coursedetailsXpath = "//table[contains(@class,'genericTable objectivesTable')]/thead/tr/th";
	public static String coursecompletiondetailsXpath = "//table[contains(@class,'genericTable objectivesTable')]/tbody/tr/td";
	public static String inheritedgroupXpath = "//div[contains(@class,'inherited')]/a";
	public static String completionhistoryvaluesXpath = "//table[contains(@class,'genericTable objectiveHistory')]/tbody/tr/td";
	public static String quizattemptsdetailsXpath = "//table[contains(@class,'genericTable quizAttempts')]/thead/tr/th";
	public static String quizattemptsvaluesXpath = "//table[contains(@class,'genericTable quizAttempts')]/tbody/tr/td";
	public static String extraquizesXpath = "//div[@class='tools']/a";
	public static String admingroupsXpath = "//div[contains(@class,'groupsblock category')]/descendant::*/span[text()='%s']";
	public static String admingroupsaccountsXpath = "//div[contains(@class,'scroll activescroller')]/div/h3";
	public static String adminpermissionXpath = "//div[@class='introblock']/h2";
	public static String permissionadminXpath = "//a[contains(@data-role,'admin')]";
	public static String addpermissionXpath = "//select[contains(@id,'permperm')]";
	public static String permissiontoassignunitXpath = "//optgroup[contains(@label,'Unit')]/option[text()='%s']";
	public static String addpermissiontoassignunitXpath = "//div[contains(@class,'actionPanel')]/form/button/span";
	public static String permissiontabXpath = "//li[contains(@id,'perms')]";
	public static String admincourseXpath = "//div[contains(@id,'groupCourses')]/descendant::*/span[contains(text(),'%s')]";
	public static String admincourseheaderXpath = "//div[contains(@class,'courseUser')]/h2";
	public static String resetvaluesXpath = "//form[contains(@class,'genericForm')]/fieldset/div/label";
	public static String resetdateXpath = "//input[contains(@id,'startdeadline')]";
	public static String detailpageXpath = "//table[contains(@class,'genericTable')]/thead/tr/th";
	public static String quizattemptXpath = "//table[contains(@class,'genericTable quizAttempts')]/thead/tr/th";
	public static String availablecourseXpath = "//div[@id='detailsContainer']/../descendant::*/table/tbody/tr/td[contains(text(),'%s')]";
	
	
	public final Elements<AdminPage> CourseDetails = new Elements<AdminPage>("class", coursedetailsXpath,"xpath", this);
	public final Elements<AdminPage> CourseCompletionDetails = new Elements<AdminPage>("class", coursecompletiondetailsXpath,"xpath", this);
	public final Elements<AdminPage> InheritedGroup = new Elements<AdminPage>("class", inheritedgroupXpath,"xpath", this);
	public final Elements<AdminPage> CompletionHistoryValues = new Elements<AdminPage>("class", completionhistoryvaluesXpath,"xpath", this);
	public final Elements<AdminPage> QuizAttemptsDetails = new Elements<AdminPage>("class", quizattemptsdetailsXpath,"xpath", this);
	public final Elements<AdminPage> QuizAttemptsValues = new Elements<AdminPage>("class", quizattemptsvaluesXpath,"xpath", this);
	public final Elements<AdminPage> ExtraQuizes = new Elements<AdminPage>("class", extraquizesXpath,"xpath", this);
	public final Elements<AdminPage> AdminGroupsAccounts = new Elements<AdminPage>("class", admingroupsaccountsXpath,"xpath", this);
	public final Element<AdminPage> AdminPermission = new Element<AdminPage>("class", adminpermissionXpath,"xpath", this);
	public final Element<AdminPage> PermissionAdmin = new Element<AdminPage>("class", permissionadminXpath,"xpath", this);
	public final Element<AdminPage> AddPermission = new Element<AdminPage>("class", addpermissionXpath,"xpath", this);
	public final Element<AdminPage> AddPermissiontoAssignUnit = new Element<AdminPage>("class", addpermissiontoassignunitXpath,"xpath", this);
	public final Element<AdminPage> PermissionTab = new Element<AdminPage>("class", permissiontabXpath,"xpath", this);
	public final Element<AdminPage> AdminCourse = new Element<AdminPage>("class", admincourseXpath,"xpath", this);
	public final Element<AdminPage> AdminCourseHeader = new Element<AdminPage>("class", admincourseheaderXpath,"xpath", this);
	public final Elements<AdminPage> ResetValues = new Elements<AdminPage>("class", resetvaluesXpath,"xpath", this);
	public final Input<AdminPage> ResetDate = new Input<AdminPage>("id", resetdateXpath,"xpath", this);
	public final Elements<AdminPage> DetailPage = new Elements<AdminPage>("class", detailpageXpath,"xpath", this);
	public final Elements<AdminPage> QuizAttempt = new Elements<AdminPage>("class", quizattemptXpath,"xpath", this);
	public final Elements<AdminPage> AvailableCourse = new Elements<AdminPage>("class", availablecourseXpath,"xpath", this);
	
	
	public static AdminPage get() {
        if (adminpage == null) {
        	adminpage = new AdminPage();
        }
        return adminpage;
    }

}
