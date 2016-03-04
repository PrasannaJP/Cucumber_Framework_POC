package com.webuitests.pages;

import com.webuiframework.oua.uitests.control.Button;
import com.webuiframework.oua.uitests.control.Element;
import com.webuiframework.oua.uitests.control.Elements;
import com.webuiframework.oua.uitests.control.Input;
import com.webuiframework.oua.uitests.panel.BasePanel;

public class TrainingPage extends BasePanel<LMSPage>{
	private static TrainingPage trainingpage;
	
	public static String mytrainingtabXpath = "//ul[@id='nav']/li/a/span";
	public static String mytrainingactivityXpath = "//div[contains(@class,'container')]/h3/a[contains(text(),'%s')]";
	public static String mytrainingcourseXpath = "//h1[contains(@class,'ng-binding')]";
	public static String mytrainingcourseprogressXpath = "//p[contains(@class,'activityInProgress ng-scope')]";
	public static String mytrainingdeadlineXpath = "//p[contains(@class,'deadline ng-binding ng-scope')]";
	public static String mytrainingdurationXpath = "//i[contains(@class,'fa-star-o fa ico')]";
	public static String mytrainingdurationtimeXpath = "//div[contains(@class,'activity-info')]/span";
	public static String mytrainingcoursevaluesXpath = "//a[contains(@class,'page-title ng-binding')]";
	public static String mytrainingprogressXpath ="//p[contains(@class,'progress-value ng-binding')]";
	public static String mytraininghoursXpath = "//div[contains(@class,'number')]";
	public static String mytrainingcoursestatusXpath = "//span[@class='progress activity-started ng-scope']";
	public static String mytrainingcoursecompletedXpath = "//p[contains(@class,'activity-completed ng-scope')]";
	public static String mytrainingdonecourseXpath = "//span[@class='progress activity-complete ng-scope']";
	public static String mytrainingcourseawardXpath = "//div[contains(@class,'certificate')]/span";
	public static String mytrainingtutorXpath = "//a[@href='#']";
	public static String mytrainingtutormailXpath = "//label[@for='your-email']";
	public static String mytrainingnumberXpath = "//label[@for='your-number']";
	public static String mytrainingquestionXpath = "//label[@for='your-question']";
	public static String mytrainingtutordefaultmailXpath = "//input[contains(@id,'your-email')]";
	public static String mytrainingtutorphoneXpath = "//input[contains(@id,'your-number')]";
	public static String mytrainingtutorquestionXpath = "//textarea[contains(@id,'your-question')]";
	public static String mytrainingtutorsubmitXpath = "//input[contains(@type,'submit')]";
	public static String mytrainingquestionsubmitXpath = "//h2";
	public static String mytrainingquestionmessageXpath = "//p[@class='lead']";
	public static String trainingpointsXpath = "//div[contains(@class,'activity-info')]/div[contains(@class,'number')]";
	public static String mytrainingdownloadXpath = "//a[contains(@title,'Open or save certificate as PDF')]";
	
	public final Elements<TrainingPage> MyTrainingTab = new Elements<TrainingPage>("id", mytrainingtabXpath,"xpath", this);
	public final Element<TrainingPage> MyTrainingActivity = new Element<TrainingPage>("class", mytrainingactivityXpath,"xpath", this);
	public final Element<TrainingPage> MyTrainingCourse = new Element<TrainingPage>("class", mytrainingcourseXpath,"xpath", this);
	public final Element<TrainingPage> MyTrainingCourseProgress = new Element<TrainingPage>("class", mytrainingcourseprogressXpath,"xpath", this);
	public final Element<TrainingPage> MyTrainingDeadline = new Element<TrainingPage>("class", mytrainingdeadlineXpath,"xpath", this);
	public final Element<TrainingPage> MyTrainingDuration = new Element<TrainingPage>("class", mytrainingdurationXpath,"xpath", this);
	public final Elements<TrainingPage> MyTrainingDurationTime = new Elements<TrainingPage>("class", mytrainingdurationtimeXpath,"xpath", this);
	public final Elements<TrainingPage> MyTrainingCourseValues = new Elements<TrainingPage>("class", mytrainingcoursevaluesXpath,"xpath", this);
	public final Element<TrainingPage> MyTrainingProgress = new Element<TrainingPage>("class", mytrainingprogressXpath,"xpath", this);
	public final Elements<TrainingPage> MyTrainingHours = new Elements<TrainingPage>("class", mytraininghoursXpath,"xpath", this);
	public final Elements<TrainingPage> MyTrainingCourseStatus = new Elements<TrainingPage>("class", mytrainingcoursestatusXpath,"xpath", this);
	public final Element<TrainingPage> MyTrainingCourseCompleted = new Element<TrainingPage>("class", mytrainingcoursecompletedXpath,"xpath", this);
	public final Elements<TrainingPage> MyTrainingDoneCourse = new Elements<TrainingPage>("class", mytrainingdonecourseXpath,"xpath", this);
	public final Elements<TrainingPage> MyTrainingCourseAward = new Elements<TrainingPage>("class", mytrainingcourseawardXpath,"xpath", this);
	public final Element<TrainingPage> MyTrainingTutor = new Element<TrainingPage>("tag", mytrainingtutorXpath,"xpath", this);
	public final Element<TrainingPage> MyTrainingTutorMail = new Element<TrainingPage>("label", mytrainingtutormailXpath,"xpath", this);
	public final Element<TrainingPage> MyTrainingNumber = new Element<TrainingPage>("label", mytrainingnumberXpath,"xpath", this);
	public final Element<TrainingPage> MyTrainingQuestion = new Element<TrainingPage>("label", mytrainingquestionXpath,"xpath", this);
	public final Element<TrainingPage> MyTrainingTutorDefaultMailh = new Element<TrainingPage>("class", mytrainingtutordefaultmailXpath,"xpath", this);
	public final Input<TrainingPage> MyTrainingTutorPhone = new Input<TrainingPage>("class", mytrainingtutorphoneXpath,"xpath", this);
	public final Input<TrainingPage> MyTrainingTutorQuestion = new Input<TrainingPage>("class", mytrainingtutorquestionXpath,"xpath", this);
	public final Button<TrainingPage> MyTrainingTutorSubmit = new Button<TrainingPage>("button", mytrainingtutorsubmitXpath,"xpath", this);
	public final Element<TrainingPage> MyTrainingQuestionSubmit = new Element<TrainingPage>("button", mytrainingquestionsubmitXpath,"xpath", this);
	public final Elements<TrainingPage> MyTrainingQuestionMessage = new Elements<TrainingPage>("button", mytrainingquestionmessageXpath,"xpath", this);
	public final Elements<TrainingPage> TrainingPoints = new Elements<TrainingPage>("button", trainingpointsXpath,"xpath", this);
	public final Element<TrainingPage> MyTrainingDownload = new Element<TrainingPage>("class", mytrainingdownloadXpath,"xpath", this);
	
	
	public static TrainingPage get() {
        if (trainingpage == null) {
        	trainingpage = new TrainingPage();
        }
        return trainingpage;
    }

}