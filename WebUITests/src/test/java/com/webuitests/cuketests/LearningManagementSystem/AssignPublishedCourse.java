package com.webuitests.cuketests.LearningManagementSystem;

import java.io.File;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import com.webuiframework.oua.uitests.utils.TestBaseWebDriver;
import com.webuiframework.oua.uitests.utils.WebDriverWrapper;
import com.webuitests.base.TestBase;
import com.webuitests.base.TestBase.Browsers;
import com.webuitests.pages.AdminPage;
import com.webuitests.pages.LABPage;
import com.webuitests.pages.LMSPage;
import com.webuitests.pages.TrainingPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AssignPublishedCourse extends TestBase {


	@When("^Admin click on \"([^\"]*)\" group under 'Groups & Accounts'$")
	public void admin_click_on_group_under_Groups_Accounts(String group) throws Throwable {
		//WebDriverWrapper.waitForElementPresent(By.xpath(String.format(LMSPage.groupsinlmsXpath, group)));
		WebDriverWrapper.waitForElementPresent(By.xpath(String.format(AdminPage.admingroupsXpath, group)));
		String script = String.format("$('span:contains(%s)').click()", group);
		WebDriverWrapper.executeScript(script);

	}

	@Then("^\"([^\"]*)\" group should open with \"([^\"]*)\" and \"([^\"]*)\" fields$")
	public void group_should_open_with_and_fields(String parentGroup, String childGroups, String accounts)
			throws Throwable {
		WebDriverWrapper.waitForAjaxJQueryProcess();
		Assert.assertTrue(childGroups + " not displaying",
				AdminPage.get().AdminGroupsAccounts.getTextList().contains(childGroups));
		Assert.assertTrue(childGroups + " not displaying", AdminPage.get().AdminGroupsAccounts.getTextList().contains(accounts));
	}

	@When("^Admin click on \"([^\"]*)\" tab$")
	public void admin_click_on_tab(String permissions) throws Throwable {
		String script = String.format("$('li:contains(%s)').click()", permissions);
		WebDriverWrapper.executeScript(script);
	}

	@Then("^\"([^\"]*)\" page should display$")
	public void page_should_display(String pageName) throws Throwable {
		WebDriverWrapper.waitForAjaxJQueryProcess();
		Assert.assertTrue(pageName + " is not displayed", AdminPage.get().AdminPermission.getText().trim().contains(pageName));
	}

	@When("^Admin select 'Select a role' as \"([^\"]*)\"$")
	public void admin_select_Select_a_role_as(String role) throws Throwable {
		AdminPage.get().PermissionAdmin.click();
	}
	
	@When("^Admin select \"([^\"]*)\" and '(\\d+)'$")
	public void admin_select_and(String units, int courseId) throws Throwable {
		AdminPage.get().AddPermission.click();
		if (WebDriverWrapper.getWebElementByXpath(String.format(AdminPage.permissiontoassignunitXpath, units)).getText()
				.trim().contains(units)) {
			WebDriverWrapper.getWebElementByXpath(String.format(AdminPage.permissiontoassignunitXpath, units)).click();
		}
		LMSPage.get().CourseId.setText(String.valueOf(courseId));
		AdminPage.get().AddPermissiontoAssignUnit.click();
	}

	@Then("^\"([^\"]*)\" with \"([^\"]*)\" and \"([^\"]*)\" should display under 'Courses' with 'Course ID'$")
	public void with_and_should_display_under_Courses_with_Course_ID(String course, String assign, String enrol)
			throws Throwable {
		WebDriverWrapper.waitForElementPresent(By.xpath(String.format(LMSPage.assainandenrollcourseXpath, course)));
		if (WebDriverWrapper.getWebElementByXpath(String.format(LMSPage.assainandenrollcourseXpath, course)).getText()
				.trim().contains(course)) {
			Assert.assertTrue(assign + " is not displaying",
					WebDriverWrapper.getWebElementByXpath(String.format(LMSPage.assainandenrollcourseXpath, course))
							.getText().trim().contains(assign));
			Assert.assertTrue(enrol + " is not displaying",
					WebDriverWrapper.getWebElementByXpath(String.format(LMSPage.assainandenrollcourseXpath, course))
							.getText().trim().contains(enrol));
		}
	}

	@When("^Admin click on \"([^\"]*)\" account$")
	public void admin_click_on_account(String adminUser) throws Throwable {
		WebDriverWrapper.waitForAjaxJQueryProcess();
		String script = String.format("$('a:contains(%s)').click()", adminUser);
		WebDriverWrapper.executeScript(script);
	}

	@Then("^\"([^\"]*)\" page should get displayed$")
	public void page_should_get_displayed(String pageName) throws Throwable {
		Assert.assertTrue(pageName + " is not displayed",
				AdminPage.get().AdminCourseHeader.getText().trim().contains(pageName));
	}

	@Then("^\"([^\"]*)\" should display under 'Add Learning Activity'$")
	public void should_display_under_Add_Learning_Activity(String activity) throws Throwable {
		Assert.assertTrue(activity + " is not displayed", LMSPage.get().AdminActivity.getTextList().contains(activity));
	}

	@When("^Admin click on \"([^\"]*)\" under 'Add Learning Activity'$")
	public void admin_click_on_under_Add_Learning_Activity(String activity) throws Throwable {
		LMSPage.get().AdminActivity.clickByText(activity);
	}

	@Then("^Below component should be displayed in 'Accounts Srikanth Manne Activities'$")
	public void below_component_should_be_displayed_in_Accounts_Srikanth_Manne_Activities(
			Map<String, String> activityDetails) throws Throwable {
		Set<String> activityDetail = activityDetails.keySet();
		for (String data : activityDetail) {
			WebDriverWrapper.waitForAjaxJQueryProcess();
			Assert.assertTrue(data +" is not displayed", LMSPage.get().ActivityValidation.getTextList().contains(data));
		}
		for (Entry<String, String> entry : activityDetails.entrySet()) {
			String list = entry.getValue();
			WebDriverWrapper.waitForAjaxJQueryProcess();
			Assert.assertTrue(list +" is not displayed", LMSPage.get().ActivityElements.getTextList().contains(list));
		}
	}

	@When("^Admin click on \"([^\"]*)\" under 'Actions'$")
	public void admin_click_on_under_Actions(String reset) throws Throwable {
		LMSPage.get().Reset.click();
	}

	@Then("^Below components display in 'Reset Training Module' with \"([^\"]*)\" and \"([^\"]*)\" buttons$")
	public void below_components_display_in_Reset_Training_Module_with_and_buttons(String reset, String cancel,
			List<String> activityData) throws Throwable {
		String scriptReset = String.format("$('button:contains(%s)')", reset);
		String scriptCacel = String.format("$('button:contains(%s)')", cancel);
		Assert.assertTrue(reset + " is not displaying", scriptReset.contains(reset));
		Assert.assertTrue(cancel + " is not displaying", scriptCacel.contains(cancel));
		Assert.assertTrue(activityData + " is not displaying",
				activityData.contains(LMSPage.get().ResetActivity.getText().trim()));
		Assert.assertTrue(activityData + " is not displaying",
				activityData.contains(LMSPage.get().ResetActivityName.getText().trim()));
		for(String data:AdminPage.get().ResetValues.getTextList()){
			Assert.assertTrue(activityData + " is not displaying",
					activityData.contains(data.trim()));
		}
	}

	@When("^Admin change date to \"([^\"]*)\" and click on \"([^\"]*)\"$")
	public void admin_change_date_to_and_click_on(String date, String reset) throws Throwable {
		AdminPage.get().ResetDate.setText(date);
		String script = String.format("$('button:contains(%s)').click()", reset);
		WebDriverWrapper.executeScript(script);
	}

	@When("^Admin click on \"([^\"]*)\" under \"([^\"]*)\"$")
	public void admin_click_on_under(String adminActivity, String activity) throws Throwable {
		WebDriverWrapper.waitForAjaxJQueryProcess();
		if (WebDriverWrapper.getWebElementByXpath(String.format(AdminPage.admincourseXpath, activity)).getText()
				.trim().contains(activity)) {
			WebDriverWrapper.getWebElementByXpath(String.format(AdminPage.admincourseXpath, activity)).click();
		}
		WebDriverWrapper.waitForAjaxJQueryProcess();
		String script = String.format("$('a:contains(%s)').click()", adminActivity);
		WebDriverWrapper.executeScript(script);
	}

	@Then("^Below details displayed for \"([^\"]*)\" activity$")
	public void below_details_displayed_for_course(String activity, List<String> blockTabs) throws Throwable {
		for (String tab : blockTabs) {
			Assert.assertTrue(tab + " is not displayed", LMSPage.get().LMSBlockTabs.getTextList().contains(tab));
		}
	}

	@Then("^By default \"([^\"]*)\" selected$")
	public void by_default_selected(String completionTab) throws Throwable {
		Assert.assertTrue(completionTab + " is not selected", LMSPage.get().SelectedTab.getText().contains(completionTab));
	}

	@Then("^Below details displayed for \"([^\"]*)\"$")
	public void below_details_displayed_for(String blockTabs, List<String> tabValues) throws Throwable {
		if (blockTabs.equals("Completion History")) {
			for (String tab : tabValues) {
				WebDriverWrapper.waitForAjaxJQueryProcess();
				Assert.assertTrue(tab + " is not displayed", LMSPage.get().CompletionValues.getTextList().contains(tab));
			}
		}

		if (blockTabs.equals("Detailed Page Progress")) {
			for (String tab : tabValues) {
				WebDriverWrapper.waitForAjaxJQueryProcess();
				Assert.assertTrue(tab + " is not displayed", AdminPage.get().DetailPage.getTextList().contains(tab));
			}
		}
		
		if (blockTabs.equals("Quiz Attempts")) {
			for (String tab : tabValues) {
				WebDriverWrapper.waitForAjaxJQueryProcess();
				Assert.assertTrue(tab + " is not displayed", AdminPage.get().QuizAttempt.getTextList().contains(tab));
			}
		}
	}

	@When("^Admin click on Remove Course for \"([^\"]*)\" in 'Add a course' under 'Assignable Learning Activities'$")
	public void admin_click_on_Remove_Course_for_in_Add_a_course_under_Assignable_Learning_Activities(
			String activityName) throws Throwable {
		WebDriverWrapper.waitForAjaxJQueryProcess();
		WebDriverWrapper.getWebElementByXpath(String.format(LMSPage.removeactivityXpath, activityName)).click();
	}

	@Then("^\"([^\"]*)\" warning message should get displayed with \"([^\"]*)\" and \"([^\"]*)\" buttons$")
	public void warning_message_should_get_displayed_with_and_buttons(String message, String removeButton,
			String cancelButton) throws Throwable {
		Assert.assertTrue(message + " is not displayed", LMSPage.get().RemoveMessage.getText().contains(message));
		Assert.assertTrue(removeButton + " is not displayed",
				String.format(LMSPage.removemessagebuttonsXpath, removeButton).contains(removeButton));
		Assert.assertTrue(cancelButton + " is not displayed",
				String.format(LMSPage.removemessagebuttonsXpath, cancelButton).contains(cancelButton));
	}

	@When("^Admin click on \"([^\"]*)\" warning message$")
	public void admin_click_on_warning_message(String cancelButton) throws Throwable {
		WebDriverWrapper.waitForAjaxJQueryProcess();
		String script = String.format("$('button:contains(%s)').click()", cancelButton);
		WebDriverWrapper.executeScript(script);
	}

	@Then("^\"([^\"]*)\" should be displayed without any change$")
	public void should_be_displayed_without_any_change(String activity) throws Throwable {
		Assert.assertTrue(activity + " Activity is not displaying", WebDriverWrapper
				.getWebElementByXpath(String.format(LMSPage.validatectivityXpath, activity)).isDisplayed());
	}

	@Then("^\"([^\"]*)\" should be removed in 'Add a course' under 'Assignable Learning Activities'$")
	public void should_be_removed_in_Add_a_course_under_Assignable_Learning_Activities(String activity)
			throws Throwable {
		Assert.assertFalse(activity + "is available", String.format(LMSPage.validatectivityXpath, activity).isEmpty());
	}

	@When("^Learner click on \"([^\"]*)\" tab$")
	public void learner_click_on_tab(String training) throws Throwable {
		TrainingPage.get().MyTrainingTab.clickByText(training);
	}

	@Then("^Below course should be displayed in 'My Training' page$")
	public void below_course_should_be_displayed_in_My_Training_page(List<String> trainingcourse) throws Throwable {
		for (String course : trainingcourse) {
			Assert.assertTrue(trainingcourse + " is not displayed",
					String.format(TrainingPage.mytrainingactivityXpath, course).contains(course));
		}
	}

	@When("^Learner select one \"([^\"]*)\" course from 'My Training'$")
	public void learner_select_one_course_from_My_Training(String trainingcourse) throws Throwable {
		WebDriverWrapper.getWebElementByXpath(String.format(TrainingPage.mytrainingactivityXpath, trainingcourse))
				.click();
	}

	@Then("^\"([^\"]*)\" should display as course$")
	public void should_display_as_course(String course) throws Throwable {
		Assert.assertTrue(course + " is not displayed",
				String.format(TrainingPage.mytrainingactivityXpath, course).contains(course));
	}

		@Then("^Below component should display$")
	public void below_component_should_display(Map<String, String> courseData) throws Throwable {
		WebDriverWrapper.waitForAjaxJQueryProcess();
		Thread.sleep(3000);
		Set<String> activityDetail = courseData.keySet();
		Assert.assertTrue(TrainingPage.get().MyTrainingCourse.getText()+" is not displayed",
				activityDetail.contains(TrainingPage.get().MyTrainingCourse.getText().trim()));
		Assert.assertTrue(TrainingPage.get().MyTrainingCourseProgress.getText() +" is not displayed",
				activityDetail.contains(TrainingPage.get().MyTrainingCourseProgress.getText().trim()));
		for (String duration : TrainingPage.get().MyTrainingDurationTime.getTextList()) {
			Assert.assertTrue(duration+" is not displayed", activityDetail.contains(duration.trim()));
			Assert.assertTrue(duration+" is not displayed", activityDetail.contains(duration.trim()));
		}
		for (String trainingdata : TrainingPage.get().MyTrainingCourseValues.getTextList()) {
			Assert.assertTrue(trainingdata+" is not displayed", activityDetail.contains(trainingdata));
		}

		Collection<String> entry = courseData.values();
		Assert.assertTrue(TrainingPage.get().MyTrainingProgress.getText()+" is not displayed",
				entry.contains(TrainingPage.get().MyTrainingProgress.getText().trim()));
		Assert.assertTrue(TrainingPage.get().MyTrainingDeadline.getText()+" is not displayed",
				entry.contains(TrainingPage.get().MyTrainingDeadline.getText().trim()));
		for (String traininglist : TrainingPage.get().MyTrainingHours.getTextList()) {
			Assert.assertTrue(traininglist+" is not displayed", entry.contains(traininglist));
		}
		for (String trainingdata : TrainingPage.get().MyTrainingCourseStatus.getTextList()) {
			Assert.assertTrue(trainingdata+" is not displayed", entry.contains(trainingdata));
		}
	}

	@When("^Learner complete the \"([^\"]*)\" course$")
	public void learner_complete_the_course(String course) throws Throwable {
		TrainingPage.get().MyTrainingTab.clickByText(training);
		WebDriverWrapper.getWebElementByXpath(String.format(TrainingPage.mytrainingactivityXpath, testactivity))
				.click();
		TrainingPage.get().MyTrainingCourseCompleted.isDisplayed();
	}

	@Then("^Below component should display in \"([^\"]*)\" course$")
	public void below_component_should_display_in_course(String course, Map<String, String> courseData)
			throws Throwable {
		Thread.sleep(3000);
		WebDriverWrapper.waitForAjaxJQueryProcess();
		Set<String> activityDetail = courseData.keySet();
		Assert.assertTrue(TrainingPage.get().MyTrainingCourse.getText()+" is not displayed",
				activityDetail.contains(TrainingPage.get().MyTrainingCourse.getText().trim()));
		for (String duration : TrainingPage.get().MyTrainingDurationTime.getTextList()) {
			Assert.assertTrue(duration+" is not displayed", activityDetail.contains(duration.trim()));
			Assert.assertTrue(duration+" is not displayed", activityDetail.contains(duration.trim()));
		}
		for (String trainingdata : TrainingPage.get().MyTrainingCourseValues.getTextList()) {
			Assert.assertTrue(trainingdata+" is not displayed", activityDetail.contains(trainingdata));
		}

		Collection<String> entry = courseData.values();
		Assert.assertTrue(TrainingPage.get().MyTrainingProgress.getText()+" is not displayed",
				entry.contains(TrainingPage.get().MyTrainingProgress.getText().trim()));
		for (String traininglist : TrainingPage.get().MyTrainingHours.getTextList()) {
			Assert.assertTrue(traininglist+" is not displayed", entry.contains(traininglist));
		}
		for (String trainingdata : TrainingPage.get().MyTrainingDoneCourse.getTextList()) {
			Assert.assertTrue(trainingdata+" is not displayed", entry.contains(trainingdata));
		}
	}

	@Then("^\"([^\"]*)\" with \"([^\"]*)\" option displayed$")
	public void with_option_displayed(String certificate, String download) throws Throwable {
		for (String certifictelist : TrainingPage.get().MyTrainingCourseAward.getTextList()) {
			Assert.assertTrue(certificate + "  is not displaying",
					TrainingPage.get().MyTrainingCourseAward.getTextList().contains(certificate));
			if (certifictelist.equals(download)) {
				Assert.assertTrue(download + "  is not displaying",
						TrainingPage.get().MyTrainingCourseAward.getTextList().contains(download));
			}
		}
	}

	@When("^Learner click on \"([^\"]*)\"$")
	public void learner_click_on(String tutor) throws Throwable {
		TrainingPage.get().MyTrainingTab.clickByText(training);
		WebDriverWrapper.waitForAjaxJQueryProcess();
		WebDriverWrapper.getWebElementByXpath(String.format(TrainingPage.mytrainingactivityXpath, testactivity))
				.click();
		WebDriverWrapper.waitForElementPresent(By.xpath(TrainingPage.mytrainingtutorXpath));
		WebDriverWrapper.waitForAjaxJQueryProcess();
		String script = String.format("$('a:contains(%s)').click()", tutor);
		WebDriverWrapper.executeScript(script);
	}

	@Then("^Below component should be displayed with \"([^\"]*)\" button$")
	public void below_component_should_be_displayed_with_button(String questionButton, Map<String, String> tutorData)
			throws Throwable {
		Set<String> activityDetail = tutorData.keySet();
		Assert.assertTrue(TrainingPage.get().MyTrainingTutorMail.getText()+" Mail is not Displayed",
				activityDetail.contains(TrainingPage.get().MyTrainingTutorMail.getText()));
		Assert.assertTrue(TrainingPage.get().MyTrainingNumber.getText()+"Number is not Displayed",
				activityDetail.contains(TrainingPage.get().MyTrainingNumber.getText()));
		Assert.assertTrue(TrainingPage.get().MyTrainingQuestion.getText()+" Question is not Displayed",
				activityDetail.contains(TrainingPage.get().MyTrainingQuestion.getText()));
		Collection<String> entry = tutorData.values();
		Assert.assertTrue(TrainingPage.get().MyTrainingTutorDefaultMailh.getText() +" Tutor Mail is not Displayed",
				entry.contains(TrainingPage.get().MyTrainingTutorDefaultMailh.getText()));
	}

	@When("^Learner enter 'Your Contact Number' as \"([^\"]*)\"$")
	public void learner_enter_Your_Contact_Number_as(String number) throws Throwable {
		WebDriverWrapper.waitForAjaxJQueryProcess();
		TrainingPage.get().MyTrainingTutorPhone.click();
		TrainingPage.get().MyTrainingTutorPhone.setText(number);
	}

	@When("^'Your question' as \"([^\"]*)\"$")
	public void your_question_as(String question) throws Throwable {
		WebDriverWrapper.waitForAjaxJQueryProcess();
		TrainingPage.get().MyTrainingTutorQuestion.click();
		TrainingPage.get().MyTrainingTutorQuestion.setText(question);
	}

	@When("^click on \"([^\"]*)\" button$")
	public void click_on_button(String arg1) throws Throwable {
		WebDriverWrapper.waitForAjaxJQueryProcess();
		TrainingPage.get().MyTrainingTutorSubmit.click();
	}

	@Then("^below text should display with \"([^\"]*)\" message$")
	public void below_text_should_display_with_message(String message, List<String> text) throws Throwable {
		Assert.assertTrue(message + " is not displayed",
				TrainingPage.get().MyTrainingQuestionSubmit.getText().contains(message));
		for (String messageText : text) {
			Assert.assertTrue(messageText + " is not displayed",
					TrainingPage.get().MyTrainingQuestionMessage.getTextList().contains(messageText));
		}
	}
	
	@Then("^Below component should display in \"([^\"]*)\"$")
	public void below_component_should_display_in(String activity, Map<String,String> activityDetails) throws Throwable {
		WebDriverWrapper.waitForAjaxJQueryProcess();
		Set<String> activityDetail = activityDetails.keySet();
		for (String data : activityDetail) {
			WebDriverWrapper.waitForAjaxJQueryProcess();
			Assert.assertTrue(data +" is not displayed", AdminPage.get().CourseDetails.getTextList().contains(data));
		}
		for (Entry<String, String> entry : activityDetails.entrySet()) {
			String list = entry.getValue();
			WebDriverWrapper.waitForAjaxJQueryProcess();
			Assert.assertTrue(list +" is not displayed", AdminPage.get().CourseCompletionDetails.getTextList().contains(list));
		}
	}
	
	@When("^\"([^\"]*)\" should display group name \"([^\"]*)\"$")
	public void should_display_group_name(String inherit, String group) throws Throwable {
		Assert.assertTrue(inherit + group +" is not displayed", AdminPage.get().InheritedGroup.getTextList().contains(group));
	}
	
	@Then("^Below details displayed$")
	public void below_details_displayed(List<String> blockTabs) throws Throwable {
		for (String tab : blockTabs) {
			Assert.assertTrue(tab + " is not displayed", LMSPage.get().LMSBlockTabs.getTextList().contains(tab));
		}
	}

	@Then("^Below history details displayed$")
	public void below_history_details_displayed(Map<String, String> completiondetails) throws Throwable {
		WebDriverWrapper.waitForAjaxJQueryProcess();
		Set<String> activityDetail = completiondetails.keySet();
		for (String data : activityDetail) {
			Assert.assertTrue(data +" is not displayed", LMSPage.get().CompletionValues.getTextList().contains(data));
		}
		for (Entry<String, String> entry : completiondetails.entrySet()) {
			String list = entry.getValue();
			if(!list.equals("")){
				Assert.assertTrue(list +" is not displayed", AdminPage.get().CompletionHistoryValues.getTextList().contains(list));
			}
		}
	}

	@Then("^Below Attempts details should display$")
	public void below_Attempts_details_should_display(Map<String,String> quizattempts) throws Throwable {
		WebDriverWrapper.waitForAjaxJQueryProcess();
		Set<String> activityDetail = quizattempts.keySet();
		for (String data : activityDetail) {
			WebDriverWrapper.waitForAjaxJQueryProcess();
			Assert.assertTrue(data +" is not displayed", AdminPage.get().QuizAttemptsDetails.getTextList().contains(data));
		}
		for (Entry<String, String> entry : quizattempts.entrySet()) {
			String list = entry.getValue();
			WebDriverWrapper.waitForAjaxJQueryProcess();
			Assert.assertTrue(list +" is not displayed", AdminPage.get().QuizAttemptsValues.getTextList().contains(list));
		}
	}

	@When("^Admin click on \"([^\"]*)\" under \"([^\"]*)\" activity$")
	public void admin_click_on_under_activity(String extraQuizes, String activity) throws Throwable {
		LMSPage.get().AdminActivity.clickByText(activity);
		WebDriverWrapper.waitForAjaxJQueryProcess();
		AdminPage.get().ExtraQuizes.clickByText(extraQuizes);
	}

	@Then("^Below details displayed in \"([^\"]*)\"$")
	public void below_details_displayed_in(String activity, List<String> extraQuizDetails) throws Throwable {
		for(String extraQuizDetail : extraQuizDetails){
			Assert.assertTrue(extraQuizDetail+" is not displayed", AdminPage.get().QuizAttemptsDetails.getTextList().contains(extraQuizDetail));
		}
	}
	
	@Then("^\"([^\"]*)\" should display under 'Group Enrolled Courses'$")
	public void should_display_under_Group_Enrolled_Courses(String course) throws Throwable {
		if (WebDriverWrapper.getWebElementByXpath(String.format(AdminPage.admincourseXpath, course)).getText()
				.trim().contains(course)) {
			Assert.assertTrue(course+" is not displayed", WebDriverWrapper.getWebElementByXpath(String.format(AdminPage.admincourseXpath, course)).getText().trim().contains(course));
		}
	}

	@When("^Admin click on \"([^\"]*)\" under 'Group Enrolled Courses'$")
	public void admin_click_on_under_Group_Enrolled_Courses(String course) throws Throwable {
		WebDriverWrapper.waitForAjaxJQueryProcess();
		if (WebDriverWrapper.getWebElementByXpath(String.format(AdminPage.admincourseXpath, course)).getText()
				.trim().contains(course)) {
			WebDriverWrapper.getWebElementByXpath(String.format(AdminPage.admincourseXpath, course)).click();
		}
	}

	@Then("^Below component should be displayed in \"([^\"]*)\"$")
	public void below_component_should_be_displayed_in(String course, Map<String,String> activityDetails) throws Throwable {
			Set<String> activityDetail = activityDetails.keySet();
			for (String data : activityDetail) {
				WebDriverWrapper.waitForAjaxJQueryProcess();
				Assert.assertTrue(data +" is not displayed", LMSPage.get().ActivityValidation.getTextList().contains(data));
			}
			for (Entry<String, String> entry : activityDetails.entrySet()) {
				String list = entry.getValue();
				WebDriverWrapper.waitForAjaxJQueryProcess();
				Assert.assertTrue(list +" is not displayed", LMSPage.get().ActivityElements.getTextList().contains(list));
			}
	}
	
	@When("^Admin click on Remove Course for \"([^\"]*)\" in 'Course' under 'Courses available to Admin Role'$")
	public void admin_click_on_Remove_Course_for_in_Course_under_Courses_available_to_Admin_Role(String activityName) throws Throwable {
		WebDriverWrapper.waitForAjaxJQueryProcess();
		WebDriverWrapper.getWebElementByXpath(String.format(LMSPage.removeactivityXpath, activityName)).click();
	
	}
	
	@When("^Admin Click on \"([^\"]*)\" activity in LAB$")
	public void admin_Click_on_activity_in_LAB(String activity) throws Throwable {
		WebDriverWrapper.waitForAjaxJQueryProcess();
		LABPage.get().savedActivity.clickByText(activity);
	}

	@When("^Admin navigates to \"([^\"]*)\" tab$")
	public void admin_navigates_to_tab(String options) throws Throwable {
		WebDriverWrapper.waitForAjaxJQueryProcess();
		if (WebDriverWrapper.getWebElementByXpath(String.format(LABPage.optionsXpath, options)).getText()
				.trim().contains(options)) {
			WebDriverWrapper.getWebElementByXpath(String.format(LABPage.optionsXpath, options)).click();
		}
	}

	@Then("^\"([^\"]*)\" field 'Hours' are \"([^\"]*)\" hours$")
	public void field_Hours_are_hours(String traininghours, String trainingtime) throws Throwable {
		Assert.assertTrue(trainingtime + traininghours + " is not displaying", LABPage.get().TrainingHours.getAttribureList("value").contains(trainingtime));
	}

	@Then("^\"([^\"]*)\" are \"([^\"]*)\"$")
	public void are(String arg1, String trainingpoints) throws Throwable {
		Assert.assertTrue(trainingpoints  + " is not displaying", LABPage.get().TrainingPoints.getAttribute("value").contains(trainingpoints));
	}
	
	@When("^Learner is viewing 'e(\\d+)Learning' index page$")
	public void learner_is_viewing_e_Learning_index_page(int arg1) throws Throwable {
		WebDriverWrapper.open(E3URL);
		WebDriverWrapper.waitForAjaxJQueryProcess();
	}
	
	@When("^click on \"([^\"]*)\" course$")
	public void click_on_course(String arg1) throws Throwable {
		WebDriverWrapper.waitForAjaxJQueryProcess();
		TrainingPage.get().MyTrainingTab.clickByText(training);
		WebDriverWrapper.getWebElementByXpath(String.format(TrainingPage.mytrainingactivityXpath, testactivity))
		.click();
	}

	@Then("^'Training Points' should be \"([^\"]*)\"$")
	public void training_Points_should_be(String trainingpoints) throws Throwable {
		WebDriverWrapper.waitForAjaxJQueryProcess();
		Assert.assertTrue(trainingpoints  + " is not displaying", TrainingPage.get().TrainingPoints.getTextList().contains(trainingpoints));
	}

	@Then("^'Duration' should be \"([^\"]*)\"$")
	public void duration_should_be(String duration) throws Throwable {
		WebDriverWrapper.waitForAjaxJQueryProcess();
		Assert.assertTrue(duration  + " is not displaying", TrainingPage.get().TrainingPoints.getTextList().contains(duration));
	}

	@When("^'Completion Condition' is \"([^\"]*)\"$")
	public void completion_Condition_is(String options) throws Throwable {
		WebDriverWrapper.waitForAjaxJQueryProcess();
		LABPage.get().CompletionCondition.click();
		if (WebDriverWrapper.getWebElementByXpath(String.format(LABPage.completionconditionoptionsXpath, options)).getText()
				.trim().contains(options)) {
			WebDriverWrapper.getWebElementByXpath(String.format(LABPage.completionconditionoptionsXpath, options)).click();
		}
	}

	@When("^Learner click on \"([^\"]*)\" course$")
	public void learner_click_on_course(String course) throws Throwable {
		WebDriverWrapper.waitForAjaxJQueryProcess();
		WebDriverWrapper.getWebElementByXpath(String.format(TrainingPage.mytrainingactivityXpath, course))
		.click();
	}

	@When("^Learner click on 'Download' button$")
	public void learner_click_on_Download_button() throws Throwable {
		WebDriverWrapper.waitForAjaxJQueryProcess();
		Thread.sleep(2000);
		TrainingPage.get().MyTrainingDownload.click();
	}

	@Then("^\"([^\"]*)\" should download$")
	public void should_download(String coursePDF) throws Throwable {
		WebDriverWrapper.waitForAjaxJQueryProcess();	
		String home = System.getProperty("user.dir");
		File dir = new File(home+"\\src\\test\\resources\\TestData");
		    File[] dir_contents = dir.listFiles();
		    for (int i = 0; i < dir_contents.length; i++) {
		    	if(dir_contents[i].getName().trim().contains(coursePDF)){
		    		Assert.assertTrue(coursePDF+" is not available", dir_contents[i].getName().trim().contains(coursePDF));
		    	}
		    }
		Thread.sleep(2000);
	}

	@Then("^Below details displayed in 'Test_Activity_certificate\\.pdf'$")
	public void below_details_displayed_in_Test_Activity_certificate_pdf(Map<String,String> certificationDetails) throws Throwable {
		WebDriverWrapper.waitForAjaxJQueryProcess();
		String home = System.getProperty("user.dir");
		PdfReader reader = new PdfReader(home+"\\src\\test\\resources\\TestData\\Test_Activity_certificate.pdf");
		String page = PdfTextExtractor.getTextFromPage(reader, 1);
		Set<String> activityDetail = certificationDetails.keySet();
		for(String certificateDetail:activityDetail){
			Assert.assertTrue(certificateDetail+" is not displayed", page.contains(certificateDetail));
		}
		Collection<String> activityUserDetails = certificationDetails.values();
		for(String activityUserDetail: activityUserDetails)
		Assert.assertTrue(activityUserDetail+" is not displayed", page.contains(activityUserDetail));
		new File(home+"\\src\\test\\resources\\TestData\\Test_Activity_certificate.pdf").delete();
	}


}