package com.webuitests.cuketests.POC;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.webuiframework.oua.uitests.utils.TestBaseWebDriver;
import com.webuiframework.oua.uitests.utils.WebDriverWrapper;
import com.webuitests.base.TestBase.Browsers;
import com.webuitests.pages.LABPage;
import com.webuitests.pages.LearningActivityBuilder_DashboardPage;
import com.webuitests.pages.LearningActivityBuilder_TemplatesPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ManagingLearningComponents {

	BufferedReader reader = null;
	String generalinformation;

	@Then("^\"([^\"]*)\" should be displayed under 'Course Structure'$")
	public void should_be_displayed_under_Course_Structure(String defaultactivityName) throws Throwable {
		WebDriverWrapper.waitForTextToBePresent("NEW ACTIVITY");
		Assert.assertTrue(defaultactivityName + " is not displayed for new Activity",
				LearningActivityBuilder_DashboardPage.get().NewActivitySection.getText().trim().toLowerCase()
						.equals(defaultactivityName.toLowerCase()));
	}

	@When("^Admin enter activity name as \"([^\"]*)\"$")
	public void admin_enter_activity_name(String qtpimage) throws Throwable {
		WebDriverWrapper.waitForAjaxJQueryProcess();
		LearningActivityBuilder_TemplatesPage.get().activityname.click();
		LearningActivityBuilder_TemplatesPage.get().activityname.clear();
		LearningActivityBuilder_TemplatesPage.get().activityname.setText(qtpimage);
	}

	@When("^Admin enter \"([^\"]*)\" name as \"([^\"]*)\"$")
	public void admin_enter_Topic_name_as(String component, String topicName) throws Throwable {
		WebDriverWrapper.waitForTextToNotBePresent("Your changes were saved");
		LABPage.get().newTopic.setText(topicName);

	}

	@Then("^\"([^\"]*)\" as 'Topic Name' should be displayed under 'Test Complete'$")
	public void should_be_displayed_under_Test_Complete(String topicName) throws Throwable {
		WebDriverWrapper.waitForTextToBePresent(topicName);
		Assert.assertTrue(topicName + " is not displayed as expected",
				LABPage.get().newTopic.getText().contains(topicName));
	}

	@When("^Admin enter \"([^\"]*)\" from \"([^\"]*)\" file$")
	public void admin_enter_topic_description(String component, String fileName) throws Throwable {
		String path = new File(String.format("src/test/resources/TestData/%s", fileName)).getAbsolutePath();
		reader = new BufferedReader(new FileReader(path));
		WebDriverWrapper.executeScript("$('p').click");
		WebDriverWrapper.waitForElementPresent(By.xpath(LearningActivityBuilder_TemplatesPage.qtpimagetextXpath));
		LearningActivityBuilder_TemplatesPage.get().qtpimagetext.click();
		while ((generalinformation = reader.readLine()) != null) {
			WebDriverWrapper.executeScript("$('p').text('" + generalinformation + "')");
		}

		WebDriverWrapper.executeScript("$('p').click");
	}

	

}
