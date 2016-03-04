package com.webuitests.cuketests.LearningActivityBuilder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.webuiframework.oua.uitests.utils.TestBaseWebDriver;
import com.webuiframework.oua.uitests.utils.WaitToLoad;
import com.webuiframework.oua.uitests.utils.WebDriverWrapper;
import com.webuitests.base.TestBase;
import com.webuitests.base.TestBase.Browsers;
import com.webuitests.pages.AdministratorLoginPage;
import com.webuitests.pages.CourseStructurePage;
import com.webuitests.pages.LABPage;
import com.webuitests.pages.LMSPage;
import com.webuitests.pages.LearningActivityBuilder_DashboardPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.AssertionFailedError;

public class LearningActivityBuilder extends TestBase {
	WebElement sourceWebElement;
	WebElement destinationWebElement;
	int fieldindexbeforechange = 0;
	int fielddisplayedbelowdisplayedindexbeforechange = 0;
	int fielddisplayedbelowdisplayedindex = 0;
	int field = 0;

	@Then("^LMS Page should be displayed$")
	public void lms_Page_should_be_displayed() throws Throwable {
		LMSPage.get().userFullName.getText().contains(adminFullname);
	}

	@When("^Admin navigate to Activity Builder Page$")
	public void admin_navigate_to_Learning_activity_builder_Page() throws Throwable {
		LMSPage.get().learningManagement.click();
		LMSPage.get().activityBuilder.click();
	}

	@Then("^Learn Force Activity Builder Page should be displayed$")
	public void learn_Force_Activity_Builder_Page_should_be_displayed() throws Throwable {
		WebDriverWrapper.waitForAjaxJQueryProcess();
		LABPage.get().latestActivity.isDisplayed();
		Assert.assertTrue(LABPage.get().latestActivity.isDisplayed());

	}

	@Given("^Admin is viewing Learn Force Activity Builder Page$")
	public void admin_is_viewing_Learn_Force_Activity_Builder_Page() throws Throwable {
		WebDriverWrapper.open(CourseCatalogueLMSURL);
		WebDriverWrapper.waitForAjaxJQueryProcess();
		WebDriverWrapper.waitForTextToBePresent(AdministratorLoginPage.get().usernameinput.getText());
		AdministratorLoginPage.get().usernameinput.setText(adminuserName);
		AdministratorLoginPage.get().passwordinput.setTextSecure(coursecatalogueadminPassword);
		AdministratorLoginPage.get().loginButton.click();
		WebDriverWrapper.waitForAjaxJQueryProcess();
	}

	@When("^Admin open \"([^\"]*)\" tab for the \"([^\"]*)\" \"([^\"]*)\"$")
	public void admin_open_tab_for_activity(String tab, String componentName, String component) throws Throwable {
		LABPage.get().ExpandComponent.click();
		String script = String.format("$('span:contains(%s)').click()", componentName);
		WebDriverWrapper.executeScript(script);
		Thread.sleep(1000);
		for (WebElement tabElement : LABPage.get().TabsForCourse.getWebElements()) {
			if (tabElement.getAttribute("heading").toLowerCase().contains(tab.toLowerCase())) {
				tabElement.click();
			}
		}
	}

	@Then("^\"([^\"]*)\" should be displayed in LAB dashboard page$")
	public void should_be_displayed_in_LAB_dashboard_page(String activityName) throws Throwable {
		for (WebElement activityElement : LearningActivityBuilder_DashboardPage.get().ActivityTitles.getWebElements()) {
			if (activityElement.getText().contains(activityName)) {
				Assert.assertTrue(activityName + " is not displayed LAB dashboard", true);
			}
		}
	}

	@Then("^Below options should be displayed under \"([^\"]*)\"$")
	public void below_options_should_be_displayed_under_for_the_activity(String sectionName,
			Map<String, String> advancedOptions) throws Throwable {
		WebDriverWrapper.waitForTextToBePresent("Hide Navigation");
		Assert.assertFalse(advancedOptions.get("Hide Navigation") + " is not displayed as expected",
				(Boolean) WebDriverWrapper.getjavascritExecutor()
						.executeScript(String.format(
								"return $('label').filter(function(index) { return $(this).text() === \"%s\"; }).parent().find(\"input:checked\").length > 0",
								advancedOptions.get("Hide Navigation"))));
		Assert.assertFalse(advancedOptions.get("Hide") + " is not displayed as expected",
				(Boolean) WebDriverWrapper.getjavascritExecutor()
						.executeScript(String.format(
								"return $('label').filter(function(index) { return $(this).text() === \"%s\"; }).parent().find(\"input:checked\").length > 0",
								advancedOptions.get("Hide"))));
		Assert.assertFalse(advancedOptions.get("Hide Progress") + " is not displayed as expected",
				(Boolean) WebDriverWrapper.getjavascritExecutor()
						.executeScript(String.format(
								"return $('label').filter(function(index) { return $(this).text() === \"%s\"; }).parent().find(\"input:checked\").length > 0",
								advancedOptions.get("Hide Progress"))));
	}

	@When("^Admin click on \"([^\"]*)\" button for 'Test Complete' activity$")
	public void admin_click_on_button_for_Test_Complete_activity(String preview) throws Throwable {
		WebDriverWrapper.waitForElementPresent(By.xpath(LABPage.previewcourseXpath));
		LABPage.get().PreviewCourse.click();
	}

	@Then("^Course \"([^\"]*)\" should be displayed in preview mode$")
	public void course_should_be_displayed_in_preview_mode(String activityName) throws Throwable {
		WebDriverWrapper.waitForTextToBePresent(activityName);
		String activityNameFromApp = (String) WebDriverWrapper.executeScript("return $('h1').text()");
		Assert.assertTrue(activityName + " is not displayed in preview mode as expected",
				activityNameFromApp.trim().contains(activityName));
	}

	@Then("^Below Options should be displayed preview mode for \"([^\"]*)\" activity$")
	public void below_Options_should_be_displayed_preview_mode_for_activity(String activityName,
			Map<String, String> options) throws Throwable {
		WebDriverWrapper.waitForTextToBePresent(activityName);
		Assert.assertTrue(activityName + " is not displayed in preview mode",
				LearningActivityBuilder_DashboardPage.get().ActivityTitleInPreview.getText().trim()
						.contains(activityName));
		LABPage.get().BeginCourseInPreview.click();
	}

	@Then("^\"([^\"]*)\" button should be displayed in preview mode$")
	public void button_should_be_displayed_in_preview_mode(String buttonInPreview) throws Throwable {
		if (buttonInPreview.equals("Back to edit")) {
			Assert.assertTrue(buttonInPreview + " is not displayed in Preview mode for course",
					LABPage.get().BackToEditInPreview.isExists());
		}
		if (buttonInPreview.equals("Previous")) {
			Assert.assertTrue(buttonInPreview + " is not displayed in Preview mode for course",
					LABPage.get().PreviousInPreview.isExists());
		}
		if (buttonInPreview.equals("Finish")) {
			Assert.assertTrue(buttonInPreview + " is not displayed in Preview mode for course",
					LABPage.get().FinishInPreview.isExists());
		}
		if (buttonInPreview.equals("Next")) {
			Assert.assertTrue(buttonInPreview + " is not displayed in Preview mode for course",
					LABPage.get().NextInPreview.isExists());
		}

	}

	@When("^Admin click on \"([^\"]*)\" for 'Test Complete' course$")
	public void admin_click_on_for_Test_Complete_course(String previousbutton) throws Throwable {
		LABPage.get().BackToEditInPreview.click();
	}

	@Then("^\"([^\"]*)\" course should be displayed in Edit mode$")
	public void course_should_be_displayed_in_Edit_mode(String activityName) throws Throwable {
		Assert.assertTrue(activityName + " is not displayed in Edit mode",
				LearningActivityBuilder_DashboardPage.get().NewActivitySection.getText().trim().toLowerCase()
						.equals(activityName.toLowerCase()));
	}

	@When("^Admin \"([^\"]*)\" option \"([^\"]*)\" for 'General Information' Topic$")
	public void admin_option_for_General_Information_Topic(String checkboxaction, String checkboxName)
			throws Throwable {
		String script = String.format(
				"return $('label').filter(function(index) { return $(this).text() === \"%s\"; }).parent().find(\"input:checked\").length > 0",
				checkboxName);
		Boolean status = (Boolean) WebDriverWrapper.executeScript(script);
		if (checkboxaction.contains("Turn ON") && !status) {
			WebDriverWrapper.getWebElementByXpath(String.format(LABPage.hideOptionsXpath, checkboxName)).click();
		}
		if (checkboxaction.contains("Turn OFF") && status) {
			WebDriverWrapper.getWebElementByXpath(String.format(LABPage.hideOptionsXpath, checkboxName)).click();
		}
	}

	@When("^Admin Click on \"([^\"]*)\" on 'Test Complete' activity page$")
	public void admin_Click_on_on_Test_Complete_activity_page(String actionbutton) throws Throwable {
		Thread.sleep(1000);
		String script = "$('button:contains(Save)').click()";
		WebDriverWrapper.executeScript(script);
	}

	@Then("^\"([^\"]*)\" button should not be displayed for 'Test Complete' Course$")
	public void button_should_not_be_displayed_for_Test_Complete_Course(String buttonInPreview) throws Throwable {
		if (buttonInPreview.equals("Back to edit")) {
			try {
				Assert.assertFalse(buttonInPreview + " is not displayed in Preview mode for course",
						LABPage.get().BackToEditInPreview.getAttribute("class").contains("ng-hide"));
			} catch (Exception e) {
				Assert.assertTrue(true);
			}

		}
		if (buttonInPreview.equals("Previous")) {
			try {
				Assert.assertFalse(buttonInPreview + " is not displayed in Preview mode for course",
						LABPage.get().PreviousInPreview.getAttribute("class").contains("ng-hide"));
			} catch (Exception e) {
				Assert.assertTrue(true);
			}

		}
		if (buttonInPreview.equals("Next")) {
			try {
				Assert.assertFalse(buttonInPreview + " is not displayed in Preview mode for course",
						LABPage.get().NextInPreview.getAttribute("class").contains("ng-hide"));
			} catch (NullPointerException e) {
				Assert.assertTrue(true);
			}

		}
		if (buttonInPreview.equals("Finish")) {
			try {
				Assert.assertFalse(buttonInPreview + " is not displayed in Preview mode for course",
						LABPage.get().FinishInPreview.getAttribute("class").contains("ng-hide"));
			} catch (NullPointerException e) {
				Assert.assertTrue(true);
			}

		}
	}

	@Then("^\"([^\"]*)\" topic should not be displayed in preview mode for 'Test Complete' activity$")
	public void topic_should_not_be_displayed_in_preview_mode_for_Test_Complete_activity(String topicName)
			throws Throwable {
		try {
			Assert.assertFalse(topicName + " is not displayed in preview mode",
					LABPage.get().TopicNameInPreview.getAttribute("class").contains("hide"));
		} catch (Exception e) {
			Assert.assertTrue(true);
		}
	}

	@Then("^\"([^\"]*)\" link should be displayed at the top of Course$")
	public void link_should_be_displayed_at_the_top_of_Course(String linkName) throws Throwable {
		try {
			Assert.assertFalse(linkName + " is not displayed in Preview mode for course",
					LABPage.get().BackToEditLinkInPreview.getAttribute("class").contains("ng-hide"));
		} catch (NullPointerException e) {
			Assert.assertTrue(true);
		}
	}

	@When("^Admin select \"([^\"]*)\" name \"([^\"]*)\" from the Course Structure$")
	public void admin_select_name_from_the_Course_Structure(String component, String componentName) throws Throwable {
		WebDriverWrapper.waitForAjaxJQueryProcess();
		String script = String.format("$('a[title*=\"%s\"]').click()", componentName);
		WebDriverWrapper.executeScript(script);

	}

	@When("^Admin enter 'Page' name as \"([^\"]*)\"$")
	public void admin_enter_Page_name_as(String pagetitle) throws Throwable {
		WebDriverWrapper.waitForTextToBePresent("New Page");
		LABPage.get().newTopic.setText(pagetitle);
	}

	@Then("^\"([^\"]*)\" should be displayed under \"([^\"]*)\"$")
	public void should_be_displayed_under(String page, String topic) throws Throwable {

	}

	@When("^Admin selects \"([^\"]*)\" as \"([^\"]*)\" from activity edit page$")
	public void admin_selects_as_from_activity_edit_page(String component, String componentName) throws Throwable {
		if (component.equals("Activity Name")) {
			if (TestBaseWebDriver.browserType.equalsIgnoreCase(Browsers.FIREFOX.toString())) {
				LABPage.get().ActivityNameInEdit.click();
			} else {
				WebDriverWrapper.waitForTextToBePresent(componentName);
				Thread.sleep(1000);
				String script = String.format("$('a[ui-sref*=\"lab.activities.edit\"]').click()");
				WebDriverWrapper.executeScript(script);
			}

		} else {
			LABPage.get().ExpandComponent.click();
			if (TestBaseWebDriver.browserType.equalsIgnoreCase(Browsers.FIREFOX.toString())) {
				if (component.contains("Assessment")) {
					if (componentName.contains("Test Complete Assessment")) {
						componentName = "Test Complete Assess…";
						LABPage.get().ComponentsInCourseStructure.getWebElementByTextContains(componentName).click();
					} else {
						LABPage.get().ComponentsInCourseStructure.getWebElementByTextContains(componentName).click();
					}

				}

			}
			if (TestBaseWebDriver.browserType.equalsIgnoreCase(Browsers.CHROME.toString())) {
				if (component.contains("Assessment") && componentName.contains("Test Complete Assessment")) {
					String script = String.format("$('a[title*=\"%s\"]').click()", componentName);
					WebDriverWrapper.executeScript(script);
				} else {
					String script = String.format("$('span:contains(%s)').click()", componentName);
					WebDriverWrapper.executeScript(script);
				}

			}
			Thread.sleep(1000);

		}

	}

	@Then("^Activity Page should be displayed with below fields$")
	public void activity_Page_should_be_displayed_with_below_fields(Map<String, String> fields) throws Throwable {
		Assert.assertTrue(fields.get("Activity Name") + "  is not displayed in preview mode",
				fields.get("Activity Name").contains(LearningActivityBuilder_DashboardPage.get().ActivityTitleInPreview
						.getAttribute("title").trim()));

		Assert.assertTrue(fields.get("Status") + "  is not displayed in preview mode", fields.get("Status")
				.contains(LearningActivityBuilder_DashboardPage.get().ActivityStatusInPreview.getText().trim()));

		Assert.assertTrue(fields.get("Button") + "  is not displayed in preview mode",
				LearningActivityBuilder_DashboardPage.get().BeginCourseButton.isExists());

		Assert.assertTrue(fields.get("Topic Name") + "  is not displayed in preview mode",
				fields.get("Topic Name").contains(LearningActivityBuilder_DashboardPage.get().ComponentsInPreview
						.getWebElementByText(fields.get("Topic Name")).getText().trim()));

		Assert.assertTrue(fields.get("About Page") + "  is not displayed in preview mode",
				fields.get("About Page").contains(LearningActivityBuilder_DashboardPage.get().ComponentsInPreview
						.getWebElementByText(fields.get("About Page")).getText().trim()));

		Assert.assertTrue(fields.get("What's New Page") + "  is not displayed in preview mode",
				fields.get("What's New Page").contains(LearningActivityBuilder_DashboardPage.get().ComponentsInPreview
						.getWebElementByText(fields.get("What's New Page")).getText().trim()));
	}

	@Then("^\"([^\"]*)\" should be selected as \"([^\"]*)\" by default$")
	public void should_be_selected_as_by_default(String selectlabel, String selectedElement) throws Throwable {
		Assert.assertTrue(selectedElement, LABPage.get().CompleteCondition.getSelectedItem().contains(selectedElement));
	}

	@When("^Admin select 'Completion Condition' to \"([^\"]*)\" for \"([^\"]*)\" Page$")
	public void admin_select_Completion_Condition_to_for_Page(String completecondition, String pageName)
			throws Throwable {
		LABPage.get().CompleteCondition.select(completecondition);
	}

	@When("^Admin enter 'Acknowledgement text' as \"([^\"]*)\"$")
	public void admin_enter_Acknowledgement_text_as(String acknoledgementText) throws Throwable {
		WebDriverWrapper.waitForTextToBePresent("Acknowledgement text");
		LABPage.get().AcklodgementText.setText(acknoledgementText);
	}

	@Then("^\"([^\"]*)\" \"([^\"]*)\" should be displayed in preview mode$")
	public void topic_should_be_displayed_in_preview_mode(String componentName, String topicname) throws Throwable {
		if (componentName.contains("Topic")) {
			Assert.assertTrue(topicname + " is not displayed in preview",
					LABPage.get().TopiHeaderInPreview.getText().contains(topicname));
		}
		if (componentName.contains("Vedio")) {
			Thread.sleep(500);
			WebDriverWrapper.switchToFrame(WebDriverWrapper.getWebElementByXpath(LABPage.youtubeframeinpreviewXpath));
			Assert.assertTrue(LABPage.get().EmbededVideoInPreview.isExists());
			WebDriverWrapper.switchToDefault();
		}

	}

	@When("^Admin Click on \"([^\"]*)\" from priview home page$")
	public void admin_Click_on_from_priview_home_page(String buttonName) throws Throwable {
		LABPage.get().BeginCourseInPreview.click();
	}

	@When("^Admin click on \"([^\"]*)\" button$")
	public void admin_click_on_button(String buttonName) throws Throwable {
		if (buttonName.contains("Next")) {
			LABPage.get().NextInPreview.click();
		}
		if (buttonName.contains("Finish")) {
			LABPage.get().FinishInPreview.click();
		}
	}

	@Then("^\"([^\"]*)\" page should be displayed in preview mode$")
	public void page_should_be_displayed_in_preview_mode(String pageName) throws Throwable {
		Assert.assertTrue(pageName + " is not displayed in preview",
				LABPage.get().TopiHeaderInPreview.getText().contains(pageName));
	}

	@Then("^Check box should be displayed with text \"([^\"]*)\"$")
	public void check_box_should_be_displayed_with_text(String checkboxLabel) throws Throwable {
		Assert.assertTrue(checkboxLabel + " is not displayed in preview mode",
				LABPage.get().AcklodgementLabelInPreview.getText().contains(checkboxLabel));
		Assert.assertTrue(checkboxLabel + " is not displayed in preview mode",
				LABPage.get().AcklodgementCheckboxInPreview.isExists());
	}

	@When("^Admin checks the check box for the 'About TestComplete' Page$")
	public void admin_checks_the_check_box_for_the_About_TestComplete_Page() throws Throwable {
		String script = "$(\'input#acknowledgement\').click()";
		WebDriverWrapper.executeScript(script);
	}

	@When("^Admin provide youtube URL as \"([^\"]*)\" in edit mode$")
	public void admin_provide_youtube_URL_as(String URL) throws Throwable {
		WebDriverWrapper.waitForTextToBePresent("URL");
		LABPage.get().VedioURL.setText(URL);
	}

	@Then("^\"([^\"]*)\" and \"([^\"]*)\" should be added$")
	public void and_should_be_added(String assementname, String question) throws Throwable {
		WebDriverWrapper.waitForTextToBePresent(question);
		Assert.assertTrue(assementname + " is not displayed on adding the assesment",
				LABPage.get().ComponentsInCourseStructure.getWebElementByTextContains(assementname)
						.getAttribute("title").contains(assementname));
		Assert.assertTrue(question + " is not displayed on adding the assesment",
				LABPage.get().ComponentsInCourseStructure.getWebElementByTextContains(question).getAttribute("title")
						.contains(question));
	}

	@Then("^Below tab should be displayed for the 'Assessment'$")
	public void below_tab_should_be_displayed_for_the_Assessment(java.util.List<String> tabs) throws Throwable {
		Integer tabsExists = 0;
		for (WebElement tabElement : LABPage.get().TabsForCourse.getWebElements()) {
			for (String tab : tabs) {
				if (tabElement.getAttribute("heading").toLowerCase().contains(tab.toLowerCase())) {
					tabsExists++;
				}
			}
		}
		Assert.assertTrue(tabsExists.equals(LABPage.get().TabsForCourse.getWebElementsCount()));
	}

	@Then("^Questions Type option should be displayed as below$")
	public void questions_Type_option_should_be_displayed_as_below(java.util.List<String> questionsOptions)
			throws Throwable {
		LABPage.get().QuestionsType.click();
		Integer questionTypeOptions = 0;
		for (WebElement questionTypeOptionElement : LABPage.get().QuestionsTypeOptions.getWebElements()) {
			for (String questionOption : questionsOptions) {
				if (questionTypeOptionElement.getText().toLowerCase().contains(questionOption.toLowerCase())) {
					questionTypeOptions++;
				}
			}
		}
		Assert.assertTrue(questionTypeOptions.equals(LABPage.get().QuestionsTypeOptions.getWebElementsCount()));
	}

	@When("^Admin enter question as \"([^\"]*)\"$")
	public void admin_enter_question_as(String question) throws Throwable {
		LABPage.get().QuestionInputBox.setText(question);
	}

	@When("^By default answer should be selected as \"([^\"]*)\"$")
	public void by_default_answer_should_be_selected_as(String selectedAnswer) throws Throwable {
		Assert.assertTrue(selectedAnswer + " is not displayed as default answer for question",
				(Boolean) WebDriverWrapper.getjavascritExecutor()
						.executeScript(String.format(
								"return $('span').filter(function(index) { return $(this).text() === \"%s\"; }).parent().find(\"input:checked\").length > 0",
								selectedAnswer)));
	}

	@When("^Admin should select \"([^\"]*)\" as correct answer for 'Multiple Choice True/False'$")
	public void admin_should_select_as_correct_answer_for_Multiple_Choice_True_False(String answerToSelect)
			throws Throwable {
		Thread.sleep(1000);
		WebDriverWrapper.executeScript(String.format(
				"$('span').filter(function(index) { return $(this).text() === \"%s\"; }).parent().find(\"span.checkbox-tick-label\").click()",
				answerToSelect));
	}

	@When("^Admin select 'Question Type' to \"([^\"]*)\"$")
	public void admin_select_Question_Type_to(String questionType) throws Throwable {
		LABPage.get().QuestionsType.click();
		LABPage.get().QuestionsTypeOptions.getWebElementByTextContains(questionType).click();
	}

	@When("^Admin enter below answer for \"([^\"]*)\"$")
	public void admin_enter_below_answer_for_Multiple_Choice_Single(String questionType, Map<String, String> answers)
			throws Throwable {
		Thread.sleep(1000);
		for (WebElement DeleteLink : LABPage.get().DeleteLinksForAnswers.getWebElements()) {
			DeleteLink.click();
		}
		Thread.sleep(1000);
		System.out.println(answers.size());
		for (int element = 0; element < answers.size(); element++) {
			LABPage.get().AddAnswerButton.click();
			Thread.sleep(1000);
			LABPage.get().EditableAnswerTextBox.getWebElement(element)
					.sendKeys(answers.get(String.format("Answer%s", element)));
		}

	}

	@When("^Admin should select \"([^\"]*)\" as correct answer for 'Multiple Choice Single'$")
	public void admin_should_select_as_correct_answer_for_Multiple_Choice_Single(String answer) throws Throwable {
		String script = String.format(
				"$('div').filter(function(index) { return $(this).text() === \"%s\"; }).parent().find(\"span.checkbox-tick-label\").click()",
				answer);
		WebDriverWrapper.executeScript(script);
	}

	@When("^Admin navigate to \"([^\"]*)\" section in preview$")
	public void admin_navigate_to_Assessment_section_in_preview(String assementTitle) throws Throwable {
		if (!LABPage.get().TopiHeaderInPreview.getText().contains(assementTitle)) {
			LABPage.get().NextInPreview.click();
		}
		Assert.assertTrue(assementTitle + "is not diaplayed in preview mode",
				LABPage.get().TopiHeaderInPreview.getText().contains(assementTitle));
	}

	@When("^Admin sets \"([^\"]*)\" field value to \"([^\"]*)\"$")
	public void admin_sets_field_value_to(String field, String fieldValue) throws Throwable {
		if (field.contains("Question Display Ordering")) {
			LABPage.get().QuestionOrdering.select(fieldValue);
		}
	}

	@When("^Admin sets answer \"([^\"]*)\" for the question \"([^\"]*)\"$")
	public void admin_sets_answer_for_the_question(String answer, String question) throws Throwable {
		if (LABPage.get().QauestionInPreview.getText().trim().contains(question)) {
			String script = String.format(
					"$('div').filter(function(index) { return $(this).text() === \"%s\"; }).parent().find(\"span.checkbox-tick-label\").click()",
					answer);
			WebDriverWrapper.executeScript(script);
		}
	}

	@When("^Admin click on \"([^\"]*)\"$")
	public void admin_click_on(String buttonName) throws Throwable {
		if (buttonName.contains("Submit Answer")) {
			String script = "return $('div.question-answers').find('input:checked').length > 0";
			Boolean statusofAnswer = (Boolean) WebDriverWrapper.executeScript(script);
			if (statusofAnswer) {
				WebDriverWrapper.waitForTextToBePresent(buttonName);
				LABPage.get().SubmitAnswerButton.click();
			}
		}
	}

	@Then("^Result should be displayed as \"([^\"]*)\"$")
	public void result_should_be_displayed_as(String arg1) throws Throwable {
		String script = "return $('div.correct-or-incorrect').children(\":visible\").text()";
		String returnedvalue = (String) WebDriverWrapper.executeScript(script);
		Assert.assertTrue("Result " + returnedvalue + " is not correct for the question",
				returnedvalue.equals(returnedvalue));
	}

	@Then("^Assessment result should be displayed as \"([^\"]*)\"$")
	public void assessment_result_should_be_displayed_as(String passscore) throws Throwable {
		Assert.assertTrue(passscore + " is not displayed as expected",
				LABPage.get().PassScore.getText().contains(passscore));
	}

	@Then("^Below should be the results of the question for \"([^\"]*)\"$")
	public void below_should_be_the_results_of_the_question_for(String assesmentTitle,
			Map<String, String> questionAndAnswers) throws Throwable {
		for (int index = 0; questionAndAnswers.size() < 4; index++) {
			if (LABPage.get().QuestionsInResultSummaryPage.getWebElement(index).getAttribute("heading")
					.contains("Test Complete is Functional Automation Tool?")) {
				Assert.assertTrue(
						"For the question Test Complete is Functional Automation Tool?"
								+ questionAndAnswers.get("Test Complete is Functional Automation Tool?")
								+ " is not displayed as expected",
						LABPage.get().QuestionsInResultSummaryPage.getWebElement(index).getAttribute("class")
								.contains(questionAndAnswers.get("Test Complete is Functional Automation Tool?")));
			}

			if (LABPage.get().QuestionsInResultSummaryPage.getWebElement(index).getAttribute("heading")
					.contains("Test Complete is Performance Tool?")) {
				Assert.assertTrue(
						"For the question Test Complete is Performance Tool?"
								+ questionAndAnswers.get("Test Complete is Performance Tool?")
								+ " is not displayed as expected",
						LABPage.get().QuestionsInResultSummaryPage.getWebElement(index).getAttribute("class")
								.contains(questionAndAnswers.get("Test Complete is Performance Tool?")));
			}

			if (LABPage.get().QuestionsInResultSummaryPage.getWebElement(index).getAttribute("heading")
					.contains("Test Complete best suited for Testing Type?")) {
				Assert.assertTrue(
						"For the question Test Complete best suited for Testing Type?"
								+ questionAndAnswers.get("Test Complete best suited for Testing Type?")
								+ " is not displayed as expected",
						LABPage.get().QuestionsInResultSummaryPage.getWebElement(index).getAttribute("class")
								.contains(questionAndAnswers.get("Test Complete best suited for Testing Type?")));
			}

			if (LABPage.get().QuestionsInResultSummaryPage.getWebElement(index).getAttribute("heading")
					.contains("Test Complete support Testing Type?")) {
				Assert.assertTrue(
						"For the question Test Complete support Testing Type?"
								+ questionAndAnswers.get("Test Complete support Testing Type?")
								+ " is not displayed as expected",
						LABPage.get().QuestionsInResultSummaryPage.getWebElement(index).getAttribute("class")
								.contains(questionAndAnswers.get("Test Complete support Testing Type?")));
			}
		}

	}

	@Then("^PASS percentage should be displayed as \"([^\"]*)\"$")
	public void pass_percentage_should_be_displayed_as(String passpercentage) throws Throwable {
		Assert.assertTrue(passpercentage + " is not displayed in assessment summaryPage",
				LABPage.get().PassPercentage.getText().contains(passpercentage));
	}

	@When("^Admin select \"([^\"]*)\" displayed under 'Test Complete'$")
	public void admin_select_displayed_under_Test_Complete(String assessment) throws Throwable {
		LABPage.get().ExpandComponent.click();
		if (TestBaseWebDriver.browserType.equalsIgnoreCase(Browsers.FIREFOX.toString())) {
			LABPage.get().LabAssessment.click();
		}
		if (TestBaseWebDriver.browserType.equalsIgnoreCase(Browsers.CHROME.toString())) {
			WebDriverWrapper.waitForTextToBePresent(assessment);
			String script = String.format("$('a[title*=\"%s\"]').click()", assessment);
			WebDriverWrapper.executeScript(script);
		}
	}

	@When("^Admin navigate to 'Assessment' section in preview$")
	public void admin_navigate_to_Assessment_section_in_preview() throws Throwable {
		WebDriverWrapper.waitForElementPresent(By.xpath(LABPage.navigatetoquestionXpath));
		LABPage.get().NavigateToQuestion.click();
	}

	@Then("^Admin should be able to click on \"([^\"]*)\" button$")
	public void admin_should_be_able_to_click_on_button(String arg1) throws Throwable {
		LABPage.get().NavigateToQuestion.click();
	}

	@Then("^\"([^\"]*)\" should be displayed in Assessment Summary Page$")
	public void should_be_displayed_in_Assessment_Summary_Page(String passOrFailText) throws Throwable {
		WebDriverWrapper.waitForTextToBePresent(passOrFailText);
		Assert.assertTrue(passOrFailText + " is not displayed as expected",
				passOrFailText.equals(LABPage.get().PassorFailText.getText().trim()));
	}

	@When("^Admin click on \"([^\"]*)\" from Assessment Summary Page$")
	public void admin_click_on_from_Assessment_Summary_Page(String retartassessment) throws Throwable {
		Assert.assertTrue(LABPage.get().RestartAssessment.getText().contains(retartassessment));
		LABPage.get().RestartAssessment.click();
	}

	@Then("^Below devices option should be displayed 'Assessment Summary' Page$")
	public void below_devices_option_should_be_displayed_Assessment_Summary_Page(List<String> availableDevices)
			throws Throwable {
		Integer deviceTypeOptions = 0;
		for (WebElement devicesElement : LABPage.get().Devices.getWebElements()) {
			for (String deviceData : availableDevices) {
				if (devicesElement.getText().trim().contains(deviceData)) {
					deviceTypeOptions++;
				}
			}
		}
	}

	@When("^Admin click \"([^\"]*)\" question \"([^\"]*)\" from 'Course Structure'$")
	public void admin_click_question_from_Course_Structure(String duplicate, String question) throws Throwable {
		LABPage.get().ExpandComponent.click();
		if (TestBaseWebDriver.browserType.equalsIgnoreCase(Browsers.FIREFOX.toString())) {
			for (WebElement webElement : LABPage.get().ComponentsInCourseStructure.getWebElements()) {
				if (webElement.getAttribute("title").contains(question)) {
					webElement.click();
				}
			}
		}
		if (TestBaseWebDriver.browserType.equalsIgnoreCase(Browsers.CHROME.toString())) {
			String script = String.format("$('a[title*=\"%s\"]').click()", question);
			WebDriverWrapper.executeScript(script);
			WebDriverWrapper.waitForTextToBePresent(question);
			if (TestBaseWebDriver.browserType.equalsIgnoreCase(Browsers.CHROME.toString())) {
				Thread.sleep(200);
			}

		}
		WebDriverWrapper.getWebElementByXpath(String.format(LABPage.dropdowncontrolforQuestionXpath, question)).click();
		WebDriverWrapper.waitForTextToBePresent(duplicate);
		for (WebElement Element : WebDriverWrapper
				.getWebElementsByXpath(String.format(LABPage.dropdownvaluesforquestionXpath, question))) {
			if (Element.getText().contains(duplicate)) {
				Element.click();
			}
		}
	}

	@Then("^New Question should be added with the title \"([^\"]*)\"$")
	public void new_Question_should_be_added_with_the_title(String question) throws Throwable {
		if (TestBaseWebDriver.browserType.equalsIgnoreCase(Browsers.FIREFOX.toString())
				&& LABPage.get().ComponentsInCourseStructure.getWebElements().contains(question)) {
			LABPage.get().ComponentsInCourseStructure.clickByText(question);
		}
		if (TestBaseWebDriver.browserType.equalsIgnoreCase(Browsers.CHROME.toString())) {
			String script = String.format("$('a[title*=\"%s\"]').click()", question);
			WebDriverWrapper.executeScript(script);
		}
		for (WebElement duplicatedElement : LABPage.get().CourseQuestion.getWebElements()) {
			if (duplicatedElement.getAttribute("title").contains(question)) {
				Assert.assertTrue(question + " is not duplicated as expected", true);
				Assert.assertTrue("True" + " is displayed as expected",
						(Boolean) WebDriverWrapper.getjavascritExecutor().executeScript(String.format(
								"return $('span').filter(function(index) { return $(this).text() === \"True\"; }).parent().find(\"input:checked\").length > 0")));
			}
		}
	}

	@Then("^Answer should be selected \"([^\"]*)\" same as for question \"([^\"]*)\"$")
	public void answer_should_be_selected_same_as_for_question(String answer, String question) throws Throwable {
		if (TestBaseWebDriver.browserType.equalsIgnoreCase(Browsers.FIREFOX.toString())
				&& LABPage.get().ComponentsInCourseStructure.getWebElements().contains(question)) {
			LABPage.get().ComponentsInCourseStructure.clickByText(question);

		}
		if (TestBaseWebDriver.browserType.equalsIgnoreCase(Browsers.CHROME.toString())) {
			String script = String.format("$('a[title*=\"%s\"]').click()", question);
			WebDriverWrapper.executeScript(script);
		}
		for (WebElement duplicatedElement : LABPage.get().CourseQuestion.getWebElements()) {
			if (duplicatedElement.getAttribute("title").contains(question)) {
				Assert.assertTrue("True" + " is displayed as expected",
						(Boolean) WebDriverWrapper.getjavascritExecutor().executeScript(String.format(
								"return $('span').filter(function(index) { return $(this).text() === \"True\"; }).parent().find(\"input:checked\").length > 0")));
			}
		}
	}

	@Then("^Below (\\d+) question should be displayed under 'Test Complete Assessment'$")
	public void below_question_should_be_displayed_under_Test_Complete_Assessment(int noofQuestions,
			List<String> questions) throws Throwable {
		if (LABPage.get().CourseQuestion.getWebElementsCount() == noofQuestions) {
			Assert.assertTrue("Questions Result " + noofQuestions + "is displayed as expected", true);
		}
		for (String question : questions) {
			Assert.assertTrue(
					LABPage.get().CourseQuestion.getWebElement(0).getAttribute("title").trim().contains(question));
		}

	}

	@When("^Admin open \"([^\"]*)\" tab for \"([^\"]*)\" Assessment$")
	public void admin_open_tab_for_Assessment(String tabs, String assessment) throws Throwable {
		LABPage.get().AssessmetsOptions.clickByText(tabs);
	}

	@When("^Admin modify 'Pass Score\\(%\\)' to (\\d+)$")
	public void admin_modify_Pass_Score_to(int score) throws Throwable {
		LABPage.get().PassScoreChange.click();
		LABPage.get().PassScoreChange.clear();
		LABPage.get().PassScoreChange.setText(String.valueOf(score));
	}

	@When("^Restrict 'Number of Questions Asked' to (\\d+)$")
	public void restrict_Number_of_Questions_Asked_to(int questionsasked) throws Throwable {
		String script = "return $('label.option-label').filter(function(index) { return $(this).text() === \"Number of Questions Asked\"; }).parent().find('input.inline-editable').val()";
		String noOfQuestions = (String) WebDriverWrapper.executeScript(script);
		if (!(String.valueOf(questionsasked).equals(noOfQuestions))) {
			LABPage.get().NoofQuestionsAsked.click();
			LABPage.get().NoofQuestionsAsked.clear();
			LABPage.get().NoofQuestionsAsked.setText(String.valueOf(questionsasked));
		}
	}

	@Then("^Assessment \"([^\"]*)\" should be displayed in preview mode$")
	public void assessment_should_be_displayed_in_preview_mode(String assessmentTitle) throws Throwable {
		Assert.assertTrue(assessmentTitle + "is displaying",
				LABPage.get().PreviewAssessmentTitle.getText().contains(assessmentTitle));
	}

	@Then("^PASS percentage should be displayed as (\\d+)%$")
	public void pass_percentage_should_be_displayed_as(int percentage) throws Throwable {
		LABPage.get().PassScoreDisplay.getText().contains(String.valueOf(percentage));
	}

	@Then("^Below (\\d+) should be the results of the question for \"([^\"]*)\"$")
	public void below_should_be_the_results_of_the_question_for(int noofQuestions, String assessmentName,
			Map<String, String> questionAndAnswers) throws Throwable {

		if (LABPage.get().NoofQuestions.getWebElementsCount() == noofQuestions) {
			Assert.assertTrue("Questions Result " + noofQuestions + "is displayed as expected", true);
		}
		for (String key : questionAndAnswers.keySet()) {
			System.out.println(key);
			Assert.assertTrue("Question is displayed is displayed as expected",
					LABPage.get().NoofQuestions.getTextList().contains(key));
		}
		Assert.assertTrue("Progressbar completion percentage", LABPage.get().ProgressBar.getText().contains("100%"));
	}

	@When("^\"([^\"]*)\" the \"([^\"]*)\" for 'Test Complete' activity$")
	public void the_for_Test_Complete_activity(String checkboxaction, String checkboxName) throws Throwable {
		if (checkboxName.equals("Allow Skip Question")) {
			LABPage.get().AllowSkipQuestion.click();
		}
	}

	@Then("^\"([^\"]*)\" link should be displayed next to \"([^\"]*)\"$")
	public void link_should_be_displayed_next_to(String skipQuestion, String submitAnswer) throws Throwable {
		Assert.assertTrue(skipQuestion + "is displaying", LABPage.get().SkipQuestion.getText().contains(skipQuestion));
	}

	@When("^Admin click on \"([^\"]*)\" in assessment question$")
	public void admin_click_on_in_assessment_question(String arg1) throws Throwable {
		LABPage.get().SkipQuestion.click();
	}

	@When("^\"([^\"]*)\" the \"([^\"]*)\" checkbox for 'Test Complete' activity$")
	public void the_checkbox_for_Test_Complete_activity(String checkboxaction, String checkboxName) throws Throwable {
		String script = String.format(
				"return $('label').filter(function(index) { return $(this).text() === \"%s\"; }).parent().find(\"input:checked\").length > 0",
				checkboxName);
		Boolean statusofCheckBox = (Boolean) WebDriverWrapper.executeScript(script);
		if (checkboxaction.contains("Turn ON") && !statusofCheckBox) {
			LABPage.get().CannotProgress.click();
		}

		if (checkboxaction.contains("Turn OFF") && statusofCheckBox) {
			LABPage.get().CannotProgress.click();
		}
	}

	@When("^Next Assessment question \"([^\"]*)\" should be displayed$")
	public void next_Assessment_question_should_be_displayed(String question) throws Throwable {
		Assert.assertTrue(question + "is displaying", LABPage.get().PreviewNextQuestion.getText().contains(question));
	}

	@Then("^Course 'Test Complete Assessment' should be displayed in preview mode$")
	public void course_Test_Complete_Assessment_should_be_displayed_in_preview_mode() throws Throwable {
		Assert.assertTrue("Test Complete Assessment is Previewed",
				LABPage.get().PreviewAssessment.getText().contains("Test Complete Assessment"));
	}

	@Then("^Admin should not be able to move to next question on clicking on \"([^\"]*)\" button$")
	public void admin_should_not_be_able_to_move_to_next_question_on_clicking_on_button(String nextButton)
			throws Throwable {
		LABPage.get().NavigateToQuestion.click();
		LABPage.get().NavigateToQuestion.click();
		Assert.assertTrue(nextButton + "is not navigating",
				LABPage.get().saveMessage.getText().contains("Cannot progress until you select the right answer."));
	}

	@When("^Admin \"([^\"]*)\" the option \"([^\"]*)\"$")
	public void admin_the_option(String checkboxaction, String checkboxName) throws Throwable {
		String script = String.format(
				"return $('label').filter(function(index) { return $(this).text() === \"%s\"; }).parent().find(\"input:checked\").length > 0",
				checkboxName);
		Boolean statusofCheckBox = (Boolean) WebDriverWrapper.executeScript(script);
		if (checkboxaction.contains("Turn ON") && !statusofCheckBox) {
			WebDriverWrapper.getWebElementByXpath(String.format(LABPage.showresultssummarypageXpath, checkboxName))
					.click();
		}

		if (checkboxaction.contains("Turn OFF") && statusofCheckBox) {
			WebDriverWrapper.getWebElementByXpath(String.format(LABPage.showresultssummarypageXpath, checkboxName))
					.click();
		}
	}

	@Then("^Admin should be able to move to next question on clicking on \"([^\"]*)\" button$")
	public void admin_should_be_able_to_move_to_next_question_on_clicking_on_button(String nextButton)
			throws Throwable {
		LABPage.get().NavigateToQuestion.click();
	}

	@Then("^Assessment Summary Page should not displayed for 'Test Complete' activity$")
	public void assessment_Summary_Page_should_not_displayed_for_Test_Complete_activity() throws Throwable {
		Assert.assertFalse("Assessment Summary Page is not displayed as expected",
				LABPage.get().AssessmentSummaryProgressbar.isDisplayed());
	}

	@Then("^Activity should be displayed as 'Edit Mode'$")
	public void activity_should_be_displayed_as_Edit_Mode() throws Throwable {
		Assert.assertTrue("Test Complete" + " is displayed ",
				LearningActivityBuilder_DashboardPage.get().NewActivitySection.getText().trim()
						.contains("TEST COMPLETE"));

	}

	@When("^Admin enter \"([^\"]*)\" as \"([^\"]*)\"$")
	public void admin_enter_as(String label, String textToEnter) throws Throwable {
		String script = String.format(
				"$('label').filter(function(index) { return $(this).text() === \"%s\"; }).parent().find('textarea').click()",
				label);
		WebDriverWrapper.executeScript(script);
		WebDriverWrapper.getWebElementByXpath(String.format(LABPage.passandFailtextXpath, label)).clear();
		WebDriverWrapper.getWebElementByXpath(String.format(LABPage.passandFailtextXpath, label)).sendKeys(textToEnter);
	}

	@Then("^'Create new activity' button should be displayed in LAB Page$")
	public void create_new_activity_button_should_be_displayed_in_LAB_Page() throws Throwable {
		WebDriverWrapper.waitForAjaxJQueryProcess();
		LABPage.get().activityButton.isDisplayed();
	}

	@When("^Admin Click on 'Create new activity' button$")
	public void admin_Click_on_Create_new_activity_button() throws Throwable {
		LABPage.get().activityButton.click();
	}

	@Then("^'New Activity' should be displayed under 'Course Structure'$")
	public void new_Activity_should_be_displayed_under_Course_Structure() throws Throwable {
		CourseStructurePage.get().courseStructure.isExists();
		CourseStructurePage.get().newactivityTitle.isExists();
	}

	@When("^Admin named activity as \"([^\"]*)\" and save the details$")
	public void admin_named_activity_as_and_save_the_details(String text) throws Throwable {
		CourseStructurePage.get().changenameActivity.click();
		CourseStructurePage.get().changenameActivity.click();
		CourseStructurePage.get().changenameActivity.clear();
		CourseStructurePage.get().changenameActivity.click();
		WebDriverWrapper.waitForAjaxJQueryProcess();
		CourseStructurePage.get().changenameActivity.setText(text);
		WebDriverWrapper.waitForAjaxJQueryProcess();
		CourseStructurePage.get().saveButton.click();
	}

	@When("^Admin should navigate to \"([^\"]*)\" page$")
	public void admin_should_navigate_to_Dashboad_page(String menuItem) throws Throwable {
		WaitToLoad.wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath(LABPage.menuXpath))));
		LABPage.get().menu.click();
		if (menuItem.equals("Dashboard")) {
			LABPage.get().newActivitydashBoard.click();
		} else if (menuItem.equals("Settings")) {
			LABPage.get().seetingsMenu.click();
		}

	}

	@Then("^\"([^\"]*)\" should be displayed under 'Latest Activities'$")
	public void should_be_displayed_under_Latest_Activities(String activity) throws Throwable {
		WebDriverWrapper.waitForAjaxJQueryProcess();
		LABPage.get().savedActivity.getWebElementByText(activity).isDisplayed();

	}

	@When("^Admin Click on \"([^\"]*)\" button$")
	public void admin_Click_on_button(String activity) throws Throwable {
		WebDriverWrapper.waitForAjaxJQueryProcess();
		LABPage.get().savedActivity.clickByText(activity);
	}

	@When("^Admin added 'Topic' as a \"([^\"]*)\"$")
	public void admin_added_Topic_as_a(String topicname) throws Throwable {
		LABPage.get().addbtton.click();
		LABPage.get().addtopic.click();
		WebDriverWrapper.waitForAjaxJQueryProcess();
		LABPage.get().newTopic.click();
		LABPage.get().newTopic.clear();
		LABPage.get().newTopic.setText(topicname);
		WebDriverWrapper.waitForAjaxJQueryProcess();
		LABPage.get().saveTopic.click();
	}

	@Then("^\"([^\"]*)\" should be display as notification on Save$")
	public void should_be_display_as_notification_on_Save(String saveMsg) throws Throwable {
		LABPage.get().saveMessage.getText().endsWith(saveMsg);
	}

	@When("^Admin added 'Page' as \"([^\"]*)\"$")
	public void admin_added_Page_as(String pagename) throws Throwable {
		WebDriverWrapper.waitForAjaxJQueryProcess();
		LABPage.get().addbtton.click();
		LABPage.get().addPage.click();
		WebDriverWrapper.waitForAjaxJQueryProcess();
		LABPage.get().addParagraph.click();
		LABPage.get().addParagraph.click();
		LABPage.get().addParagraph.clear();
		WebDriverWrapper.waitForAjaxJQueryProcess();
		LABPage.get().addParagraph.setText(pagename);
		WebDriverWrapper.waitForAjaxJQueryProcess();
		LABPage.get().saveTopic.click();
	}

	@Then("^\"([^\"]*)\" should be displayed as notification on Save$")
	public void should_be_displayed_as_notification_on_Save(String saveMsg) throws Throwable {
		LABPage.get().saveMessage.getText().contains(saveMsg);
	}

	@When("^Admin added 'video' URL as \"([^\"]*)\"$")
	public void admin_added_video_URL_as(String videoURL) throws Throwable {
		WebDriverWrapper.waitForAjaxJQueryProcess();
		LABPage.get().addbtton.click();
		LABPage.get().addVideo.click();
		WebDriverWrapper.waitForAjaxJQueryProcess();
		LABPage.get().addVideoURL.click();
		LABPage.get().addVideoURL.setText(videoURL);
		WebDriverWrapper.waitForAjaxJQueryProcess();
		LABPage.get().saveTopic.click();
	}

	@Then("^\"([^\"]*)\" message should be displayed as notification on Save$")
	public void message_should_be_displayed_as_notification_on_Save(String saveMsg) throws Throwable {
		WebDriverWrapper.waitForAjaxJQueryProcess();
		LABPage.get().saveMessage.getText().contains(saveMsg);
		WebDriverWrapper.waitForAjaxJQueryProcess(1000);
	}

	@Then("^\"([^\"]*)\" should not be displayed in the Course main page in preview$")
	public void should_not_be_displayed_in_the_Course_main_page_in_preview(String pagetitle) throws Throwable {
		try {
			LABPage.get().PageTitlesInCourseIndexInPreview.getWebElementByTextContains(pagetitle);
		} catch (Exception e) {
			Assert.assertTrue(pagetitle + " is displayed in Course Page Index", true);
		}

	}

	@Then("^Assessment Summary Page should be displayed for 'Test Complete' activity$")
	public void assessment_Summary_Page_should_be_displayed_for_Test_Complete_activity() throws Throwable {
		Assert.assertTrue("Result Summary Page is not displayed for the assessment Test Complete",
				LABPage.get().QuestionsInResultSummaryPage.isExists());
	}

	@When("^Admin click on question \"([^\"]*)\"$")
	public void admin_click_on_question(String question) throws Throwable {
		WebDriverWrapper.waitForTextToBePresent(question);
		LABPage.get().QuestionLinkInSummaryPage.getWebElementByTextContains(question).click();
	}

	@Then("^Below options should be displayed for the question \"([^\"]*)\"$")
	public void below_options_should_be_displayed(String question, Map<String, String> answers) throws Throwable {
		String script = String.format("return $('div[heading*=\"%s\"]').find('tr.ng-scope').children().text()",
				question);
		String answersOptions = (String) WebDriverWrapper.executeScript(script);
		String answersdisplayedinsummarytable = "";
		boolean skipheader = true;
		for (Map.Entry<String, String> entry : answers.entrySet()) {
			if (skipheader) {
				skipheader = false;
				continue;
			}
			answersdisplayedinsummarytable += entry.getKey() + entry.getValue();
		}
		Assert.assertTrue("Answers are not displayed as expected in application",
				answersOptions.equals(answersdisplayedinsummarytable));
	}

	@Then("^For the question \"([^\"]*)\" should be marked as \"([^\"]*)\"$")
	public void for_the_question_should_be_marked_as(String question, String answer) throws Throwable {
		Thread.sleep(200);
		String script = String.format("return $('div[heading*=\"%s\"]').find('tr.ng-scope').children().attr('class')",
				question);
		String classnames = (String) WebDriverWrapper.executeScript(script);
		String[] classname = classnames.split(" ");
		for (String actualanswer : classname) {
			if (actualanswer.equals(answer)) {
				Assert.assertTrue("Question is not answered correctly in Assessment", true);
			}
		}
	}

	@Then("^Assessment Summary Page should be displayed without question results section$")
	public void assessment_Summary_Page_should_be_displayed_without_question_results_section() throws Throwable {
		try {
			LABPage.get().QuestionsInResultSummaryPage.isVisibleWebElementAvailable();
		} catch (Exception e) {
			Assert.assertTrue("Assessment Summary section is displayed for activity", true);
		}
	}

	@When("^Admin select \"([^\"]*)\" from \"([^\"]*)\" drop down from \"([^\"]*)\" tab$")
	public void admin_select_from_drop_down_from_tab(String dropdownOption, String dropdownName, String tab)
			throws Throwable {
		Thread.sleep(1000);
		for (WebElement tabElement : LABPage.get().TabsForCourse.getWebElements()) {
			if (tabElement.getAttribute("heading").toLowerCase().contains(tab.toLowerCase())) {
				tabElement.click();
			}
		}
		if (dropdownName.contains("Question Display")) {
			LABPage.get().QuestionDisplay.select(dropdownOption);
		}

		if (dropdownName.contains("Question Display Ordering")) {
			LABPage.get().QuestionDisplayOrdering.select(dropdownOption);
		}

		if (dropdownName.contains("Question Display Order")) {
			LABPage.get().QuestionDisplayOrder.select(dropdownOption);
		}
	}

	@When("^Admin drag \"([^\"]*)\" and drop on top of \"([^\"]*)\"$")
	public void admin_drag_and_drop_on_top_of(String sourcequestion, String destinationquestion) throws Throwable {
		for (int index = 0; index < LABPage.get().CourseQuestion.getWebElementsCount(); index++) {
			if (LABPage.get().CourseQuestion.getWebElement(index).getAttribute("title").contains(destinationquestion)) {
				fielddisplayedbelowdisplayedindexbeforechange = index;
			}
			if (LABPage.get().CourseQuestion.getWebElement(index).getAttribute("title").contains(sourcequestion)) {
				fieldindexbeforechange = index;
			}
		}
		Thread.sleep(5000);
		sourceWebElement = WebDriverWrapper
				.getWebElementByXpath(String.format(LABPage.questionincourseXpath, sourcequestion));
		destinationWebElement = WebDriverWrapper
				.getWebElementByXpath(String.format(LABPage.questionincourseXpath, destinationquestion));
		WebDriverWrapper.dragAnddrop(sourceWebElement, destinationWebElement);
		Thread.sleep(5000);
	}

	@Then("^The question \"([^\"]*)\" should be displayed under \"([^\"]*)\"$")
	public void the_question_should_be_displayed_under(String fielddisplayedbelow, String field) throws Throwable {
		int fieldindex = 0;
		int fielddisplayedbelowdisplayedindex = 0;
		for (int index = 0; index < LABPage.get().CourseQuestion.getWebElementsCount(); index++) {
			if (LABPage.get().CourseQuestion.getWebElement(index).getAttribute("title").contains(fielddisplayedbelow)) {
				fielddisplayedbelowdisplayedindex = index;
			}
			if (LABPage.get().CourseQuestion.getWebElement(index).getAttribute("title").contains(field)) {
				fieldindex = index;
			}
		}
		Assert.assertTrue("The Question " + field + " is not displayed " + fielddisplayedbelow,
				(fieldindex + 1) < (fielddisplayedbelowdisplayedindex + 1)
						&& (fieldindexbeforechange + 1 != fieldindex + 1)
						&& (fielddisplayedbelowdisplayedindexbeforechange + 1 != fielddisplayedbelowdisplayedindex
								+ 1));
	}

	@When("^Admin set answer to the question as \"([^\"]*)\"$")
	public void admin_set_answer_to_the_question_as(String answer) throws Throwable {
		WebDriverWrapper.waitForTextToBePresent(answer);
		String script = "$('div.option').filter(function(index) { return $(this).text() === \"True\"; }).parent().find('span.checkbox-tick-label').click()";
		WebDriverWrapper.executeScript(script);
	}

	@Then("^Questions should be displayed in random order not the same as below$")
	public void questions_should_be_displayed_in_random_order_not_the_same_as_below(List<String> questions)
			throws Throwable {
		for (int index = 0; index < LABPage.get().QuestionInSummaryPage.getWebElementsCount(); index++) {
			if (LABPage.get().QuestionInSummaryPage.getText(index).equals(questions.get(index))) {
				Assert.assertTrue("Questions " + index + "are displayed in same order as they asked in assessment",
						true);
			} else {
				Assert.assertFalse("Questions " + index + "are displayed in same order as they asked in assessment",
						false);
			}
		}

	}

	@Then("^Below question order should same as question asked in assessment$")
	public void below_question_order_should_same_as_question_asked_in_assessment(List<String> questions)
			throws Throwable {
		for (int index = 0; index < LABPage.get().QuestionInSummaryPage.getWebElementsCount(); index++) {
			Assert.assertTrue("Questions are not displayed in same order as they asked in assessment",
					LABPage.get().QuestionInSummaryPage.getText(index).equals(questions.get(index)));
		}
	}
}
