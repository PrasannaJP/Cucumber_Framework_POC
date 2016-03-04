package com.webuitests.pages;

import com.webuiframework.oua.uitests.control.Button;
import com.webuiframework.oua.uitests.control.Element;
import com.webuiframework.oua.uitests.control.Elements;
import com.webuiframework.oua.uitests.control.Input;
import com.webuiframework.oua.uitests.control.Select;
import com.webuiframework.oua.uitests.panel.BasePanel;

public class CourseStructurePage extends BasePanel<CourseStructurePage> {

	private static CourseStructurePage courseStructurePage;
	
	public static String activityTitleXpath = "//a[contains(@class,'ng-binding active')]";
	public static String courseXpath = "//h2/span[contains(@class,'')]";
	public static String changenameActivityXpath = "//div[contains(@ng-model,'metaData.title')]";
	public static String saveXpath = "//button[contains(@class,'btn btn-primary')]";

	
	public final Element<CourseStructurePage> newactivityTitle = new Element<CourseStructurePage>("element", activityTitleXpath,"xpath", this);
	public final Element<CourseStructurePage> courseStructure = new Element<CourseStructurePage>("element", courseXpath,"xpath", this);
	public final Input<CourseStructurePage> changenameActivity = new Input<CourseStructurePage>("div", changenameActivityXpath,"xpath", this);
	public final Button<CourseStructurePage> saveButton = new Button<CourseStructurePage>("button", saveXpath,"xpath", this);

	public static CourseStructurePage get() {
	        if (courseStructurePage == null) {
	        	courseStructurePage = new CourseStructurePage();
	        }
	        return courseStructurePage;
	    }

}
