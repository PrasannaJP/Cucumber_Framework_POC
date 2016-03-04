package com.webuitests.cuketests.LearningActivityBuilder;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.thoughtworks.selenium.Wait;
import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad;
import com.webuiframework.oua.uitests.utils.TestBaseWebDriver;
import com.webuiframework.oua.uitests.utils.WaitToLoad;
import com.webuiframework.oua.uitests.utils.WebDriverWrapper;
import com.webuitests.base.TestBase;
import com.webuitests.pages.AdministratorLoginPage;
import com.webuitests.pages.LearningActivityBuilder_TemplatesPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Templates extends TestBase {
	@When("^Admin click on \"([^\"]*)\" on 'New Activity' page$")
	public void admin_click_on_on_New_Activity_page(String coverimage) throws Throwable {
		LearningActivityBuilder_TemplatesPage.get().changecoverimage.click();
	}

	@Then("^Page should be displayed to browse file$")
	public void page_should_be_displayed_to_browse_file() throws Throwable {
		WebDriverWrapper.waitForElementPresent(By.xpath(LearningActivityBuilder_TemplatesPage.browsefileXpath));
		Assert.assertTrue(LearningActivityBuilder_TemplatesPage.get().browsefile.isDisplayed());
	}

	@When("^Admin click on \"([^\"]*)\" to upload image$")
	public void admin_click_on_to_upload_image(String browseFile) throws Throwable {
		WebDriverWrapper.waitForAjaxJQueryProcess();
		LearningActivityBuilder_TemplatesPage.get().browsefile.getText().contains(browseFile);
		LearningActivityBuilder_TemplatesPage.get().browsefile.click();
	}

	@When("^Admin Upload \"([^\"]*)\" image for 'activity'$")
	public void admin_Upload_image_for_activity(String autoimage) throws Throwable {
		WebDriverWrapper.waitForAjaxJQueryProcess();
		String autoItCommand = "";
		if(TestBaseWebDriver.browserType.equalsIgnoreCase(Browsers.CHROME.toString()))
		{
			autoItCommand = String.format("%s  %s %s",new File("src/test/resources/AutoITScripts/FileUpload.exe").getAbsolutePath(),"Open",new File(String.format("src/test/resources/TestData/%s", autoimage)).getAbsolutePath());
		}
		
		if(TestBaseWebDriver.browserType.equalsIgnoreCase(Browsers.FIREFOX.toString()))
		{
			autoItCommand = String.format("%s %s",new File("src/test/resources/AutoITScripts/FileUploadFirefox.exe").getAbsolutePath(),new File(String.format("src/test/resources/TestData/%s", autoimage)).getAbsolutePath());
		}
		if(TestBaseWebDriver.browserType.equalsIgnoreCase(Browsers.IE.toString()))
		{
			autoItCommand = String.format("%s  %s %s",new File("src/test/resources/AutoITScripts/FileUpload.exe").getAbsolutePath(),"Choose File to Upload",new File(String.format("src/test/resources/TestData/%s", autoimage)).getAbsolutePath());
			
		}
		Runtime.getRuntime().exec(autoItCommand);
		Thread.sleep(20000);
	}

	@Then("^Image should be displayed activity cover page$")
	public void image_should_be_displayed_activity_cover_page() throws Throwable {
		WebDriverWrapper.waitForAjaxJQueryProcess();
		Thread.sleep(10000);
		WebDriverWrapper.waitForinvisibilityofElement(By.xpath(LearningActivityBuilder_TemplatesPage.progressbarXpath));
		Assert.assertTrue(LearningActivityBuilder_TemplatesPage.get().verifyimage.isExists());
	}

	
	@When("^Admin Click on 'Save' on new activity page$")
	public void admin_Click_on_Save_on_new_activity_page() throws Throwable {
		WebDriverWrapper.waitForAjaxJQueryProcess();
		LearningActivityBuilder_TemplatesPage.get().saveTopic.click();
	}

	@Then("^\"([^\"]*)\" should be displayed as notification$")
	public void should_be_displayed_as_notification(String savemsg) throws Throwable {
		WebDriverWrapper.waitForTextToBePresent(savemsg);
		Assert.assertTrue(LearningActivityBuilder_TemplatesPage.get().saveMessage.getText().contains(savemsg));
		WebDriverWrapper.waitForTextToNotBePresent(savemsg);
	}

	@Then("^Admin navigate to 'Dashboard' page$")
	public void admin_navigate_to_Dashboard_page() throws Throwable {
		LearningActivityBuilder_TemplatesPage.get().menu.click();
		LearningActivityBuilder_TemplatesPage.get().activitydashboard.click();
	}

	@Then("^\"([^\"]*)\" activity should be displayed in 'History Log'$")
	public void activity_should_be_displayed_in_History_Log(String activity) throws Throwable {
		LearningActivityBuilder_TemplatesPage.get().activityhistorylog.getWebElementByTextContains(activity);
		LearningActivityBuilder_TemplatesPage.get().activityhistorylog.getWebElementByText(activity).isDisplayed();
	}

	@Then("^\"([^\"]*)\" activity should be displayed in 'Latest Activities'$")
	public void activity_should_be_displayed_in_Latest_Activities(String activity) throws Throwable {
		LearningActivityBuilder_TemplatesPage.get().savedActivity.getWebElementByTextContains(activity);
		LearningActivityBuilder_TemplatesPage.get().savedActivity.getWebElementByText(activity).isDisplayed();
	}

	@Then("^Image \"([^\"]*)\" should be displayed for the activity \"([^\"]*)\"$")
	public void image_should_be_displayed_for_the_activity(String image, String activity) throws Throwable {
		LearningActivityBuilder_TemplatesPage.get().qtpimagessataus.getWebElementByTextContains(activity).isDisplayed();
		LearningActivityBuilder_TemplatesPage.get().qtpimagessatausimage.isExists();
	}

	@Given("^Admin open \"([^\"]*)\" activity from 'History Log'$")
	public void admin_open_activity_from_History_Log(String activity) throws Throwable {
		WebDriverWrapper.open(BaseURL);
		WebDriverWrapper.waitForAjaxJQueryProcess();
		Thread.sleep(10000);
		AdministratorLoginPage.get().usernameinput.setText(adminuserName);
		AdministratorLoginPage.get().passwordinput.setTextSecure(adminPassword);
		AdministratorLoginPage.get().loginButton.click();
		WebDriverWrapper.waitForAjaxJQueryProcess();
		for(int index = 0; index < LearningActivityBuilder_TemplatesPage.get().qtphistorylog.getWebElementsCount();index++){
				LearningActivityBuilder_TemplatesPage.get().qtphistorylog.clickByText(activity);
		}
		
	}

	@When("^Admin click on 'Context Menu' of \"([^\"]*)\" activity$")
	public void admin_click_on_Context_Menu_of_activity(String activity) throws Throwable {
		LearningActivityBuilder_TemplatesPage.get().contextmenu.click();
	}

	@Then("^Below action should be displayed as 'Context Menu' options$")
	public void below_action_should_be_displayed_as_Context_Menu_options(List<String> actions) throws Throwable {
		actions = new ArrayList<String>();
		for(String i: actions){
		Assert.assertTrue(LearningActivityBuilder_TemplatesPage.get().editimage.getTextList().contains(i));
		}
	}

	@When("^Admin Click on 'Delete' from the 'Context Menu'$")
	public void admin_Click_on_Delete_from_the_Context_Menu() throws Throwable {
		LearningActivityBuilder_TemplatesPage.get().deleteimage.click();
	}

	@Then("^Warning message should be displayed as \"([^\"]*)\" with \"([^\"]*)\" and \"([^\"]*)\" button$")
	public void warning_message_should_be_displayed_as_with_and_button(String msg, String yes, String no) throws Throwable {
		for(int index = 0; index < LearningActivityBuilder_TemplatesPage.get().warningmessage.getWebElementsCount();index++){
			LearningActivityBuilder_TemplatesPage.get().warningmessage.getTextList().contains(msg);
			LearningActivityBuilder_TemplatesPage.get().warningmessage.getTextList().contains(yes);
			LearningActivityBuilder_TemplatesPage.get().warningmessage.getTextList().contains(no);
		}
	}

	@When("^Admin click on \"([^\"]*)\" on warning message$")
	public void admin_click_on_on_warning_message(String msg) throws Throwable {
		LearningActivityBuilder_TemplatesPage.get().yesmessage.click();
		Thread.sleep(10000);
	}

	@Then("^Image should not be displayed as activity cover page$")
	public void image_should_not_be_displayed_as_activity_cover_page() throws Throwable {
		try{
		Assert.assertTrue(LearningActivityBuilder_TemplatesPage.get().verifyimage.getAttribute("style").isEmpty());
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	@Then("^Image \"([^\"]*)\" should not be displayed for the activity \"([^\"]*)\"$")
	public void image_should_not_be_displayed_for_the_activity(String image, String activity) throws Throwable {
		Assert.assertFalse(LearningActivityBuilder_TemplatesPage.get().savedActivity.getAttribureList(activity).contains(image));
	}

	@When("^Admin Uploads \"([^\"]*)\" image for 'activity'$")
	public void admin_Uploads_image_for_activity(String image) throws Throwable {
		WebDriverWrapper.waitForAjaxJQueryProcess();
		String autoItCommand = "";
		if(TestBaseWebDriver.browserType.equalsIgnoreCase(Browsers.CHROME.toString()))
		{
			autoItCommand = String.format("%s  %s %s",new File("src/test/resources/AutoITScripts/FileUpload.exe").getAbsolutePath(),"Open",new File("src/test/resources/TestData/QTP.jpeg").getAbsolutePath());
		}
		
		if(TestBaseWebDriver.browserType.equalsIgnoreCase(Browsers.FIREFOX.toString()))
		{
			autoItCommand = String.format("%s  %s %s",new File("src/test/resources/AutoITScripts/FileUpload.exe").getAbsolutePath(),"File Upload",new File("src/test/resources/TestData/QTP.jpeg").getAbsolutePath());
		}
		if(TestBaseWebDriver.browserType.equalsIgnoreCase(Browsers.IE.toString()))
		{
			autoItCommand = String.format("%s  %s %s",new File("src/test/resources/AutoITScripts/FileUpload.exe").getAbsolutePath(),"Choose File to Upload",new File("src/test/resources/TestData/QTP.jpeg").getAbsolutePath());
			
		}
		Runtime.getRuntime().exec(autoItCommand);
		Thread.sleep(40000);
	}
	
	@When("^Admin change Activity Name to \"([^\"]*)\" from \"([^\"]*)\"$")
	public void admin_change_Activity_Name_to_from(String newTitle, String oldTitle) throws Throwable {
		LearningActivityBuilder_TemplatesPage.get().renameactivity.isDisplayed();
		LearningActivityBuilder_TemplatesPage.get().renameactivity.click();
		LearningActivityBuilder_TemplatesPage.get().renameactivity.clear();
		LearningActivityBuilder_TemplatesPage.get().renameactivity.setText(newTitle);
	}

	@When("^Admin close activity without saving activity$")
	public void admin_close_activity_without_saving_activity() throws Throwable {
		LearningActivityBuilder_TemplatesPage.get().closeactivity.click();
	}

	@When("^Admin add \"([^\"]*)\" for activity 'QTP - Image'$")
	public void admin_add_for_activity_QTP_Image(String topic) throws Throwable {
		LearningActivityBuilder_TemplatesPage.get().addbtton.click();
		LearningActivityBuilder_TemplatesPage.get().addbtton.getText().contains(topic);
		LearningActivityBuilder_TemplatesPage.get().addtopic.click();
	}

	@Then("^\"([^\"]*)\" page should be displayed below activity name \"([^\"]*)\"$")
	public void page_should_be_displayed_below_activity_name(String topic, String activity) throws Throwable {
		LearningActivityBuilder_TemplatesPage.get().coursestructure.getText().contains(topic);
		LearningActivityBuilder_TemplatesPage.get().coursestructure.getText().contains(activity);
	}

	@When("^Admin change topic name to \"([^\"]*)\" for 'QTP - Image' activity$")
	public void admin_change_topic_name_to_for_QTP_Image_activity(String topic) throws Throwable {
		LearningActivityBuilder_TemplatesPage.get().newTopic.click();
		LearningActivityBuilder_TemplatesPage.get().newTopic.clear();
		LearningActivityBuilder_TemplatesPage.get().newTopic.setText(topic);
	}

	@Then("^By default Template should be displayed as \"([^\"]*)\"$")
	public void by_default_Template_should_be_displayed_as(String header) throws Throwable {
		Assert.assertTrue(LearningActivityBuilder_TemplatesPage.get().header.getText().contains(header));
	}

	@Then("^No image should be displayed for the Topic 'Welcome'$")
	public void no_image_should_be_displayed_for_the_Topic_Welcome() throws Throwable {
		Assert.assertFalse(LearningActivityBuilder_TemplatesPage.get().editContent.getWebElements().contains(".jpg"));
	}

	@When("^Admin Click on 'preview the course' for the topic$")
	public void admin_Click_on_preview_the_course_for_the_topic() throws Throwable {
		LearningActivityBuilder_TemplatesPage.get().preview.click();
	}

	@Then("^Activity name should be displayed as \"([^\"]*)\"$")
	public void activity_name_should_be_displayed_as(String activity) throws Throwable {
		LearningActivityBuilder_TemplatesPage.get().previecoursename.getText().contains(activity);
	}

	@Then("^Topic \"([^\"]*)\" should be displayed below activity name$")
	public void topic_should_be_displayed_below_activity_name(String topic) throws Throwable {
		LearningActivityBuilder_TemplatesPage.get().topicname.getText().contains(topic);
	}

	@When("^Admin Change Template to \"([^\"]*)\" from top$")
	public void admin_Change_Template_to_from_top(String header) throws Throwable {
		LearningActivityBuilder_TemplatesPage.get().gototopic.click();
		WebDriverWrapper.waitForElementPresent(By.xpath(LearningActivityBuilder_TemplatesPage.headerXpath));
		LearningActivityBuilder_TemplatesPage.get().header.click();
		LearningActivityBuilder_TemplatesPage.get().headerlayout.getWebElements().contains(header);
		LearningActivityBuilder_TemplatesPage.get().headerlayout.clickByText(header);
	}

	@Then("^(\\d+) below sections should be displayed$")
	public void below_sections_should_be_displayed(int noOfResult, List<String> data) throws Throwable {
		if(LearningActivityBuilder_TemplatesPage.get().topicimageright.getWebElementsCount() == noOfResult){
			Assert.assertTrue("No.of results " + noOfResult + "displayed as expected", true);
		}
			LearningActivityBuilder_TemplatesPage.get().splash.getWebElements().contains(LearningActivityBuilder_TemplatesPage.get().imageid);
			LearningActivityBuilder_TemplatesPage.get().splash.getWebElements().contains("Drag an image file here to upload");
	}

	@When("^Admin Upload \"([^\"]*)\" image for 'Topic'$")
	public void admin_Upload_image_for_Topic(String image) throws Throwable {
		LearningActivityBuilder_TemplatesPage.get().topicbrowse.click();	
		String autoItCommand = "";
		if(TestBaseWebDriver.browserType.equalsIgnoreCase(Browsers.CHROME.toString()))
		{
			autoItCommand = String.format("%s  %s %s",new File("src/test/resources/AutoITScripts/FileUpload.exe").getAbsolutePath(),"Open",new File("src/test/resources/TestData/QTP.jpeg").getAbsolutePath());
		}
		
		if(TestBaseWebDriver.browserType.equalsIgnoreCase(Browsers.FIREFOX.toString()))
		{
			autoItCommand = String.format("%s  %s %s",new File("src/test/resources/AutoITScripts/FileUpload.exe").getAbsolutePath(),"File Upload",new File("src/test/resources/TestData/QTP.jpeg").getAbsolutePath());
		}
		if(TestBaseWebDriver.browserType.equalsIgnoreCase(Browsers.IE.toString()))
		{
			autoItCommand = String.format("%s  %s %s",new File("src/test/resources/AutoITScripts/FileUpload.exe").getAbsolutePath(),"Choose File to Upload",new File("src/test/resources/TestData/QTP.jpeg").getAbsolutePath());
			
		}
		Runtime.getRuntime().exec(autoItCommand);
		Thread.sleep(10000);
	}

	@Then("^Image should be displayed in image section$")
	public void image_should_be_displayed_in_image_section() throws Throwable {
		Assert.assertTrue(LearningActivityBuilder_TemplatesPage.get().verifytopicimage.isExists());
	}
				
	@When("^Admin enter text as \"([^\"]*)\" in Text area$")
	public void admin_enter_text_as_in_Text_area(String message) throws Throwable {
		Thread.sleep(5000);
		WebDriverWrapper.executeScript("$('p').click");
		LearningActivityBuilder_TemplatesPage.get().qtpimagetext.click();
		WebDriverWrapper.executeScript("$('p').text('"+message+"')");
		WebDriverWrapper.executeScript("$('p').click");
		Thread.sleep(5000);
	}

	@Then("^Below component should be displayed$")
	public void below_component_should_be_displayed(Map<String,String> previewDetails) throws Throwable {
		previewDetails = new HashMap<String, String>();
		Iterator entries = previewDetails.entrySet().iterator();
		while (entries.hasNext()) {
		Map.Entry entry = (Map.Entry) entries.next();
		Assert.assertTrue("Topic Header" + entry.getKey() + "should be displayed as part of preview", LearningActivityBuilder_TemplatesPage.get().previewtopic.getText().contains(entry.getValue().toString())); 
		Assert.assertTrue("Splash " + entry.getKey() + "should be displayed as part of preview", LearningActivityBuilder_TemplatesPage.get().previewtopictext.getText().contains(entry.getValue().toString()));
		Assert.assertTrue("Image " + entry.getKey() + "should be displayed as part of preview", LearningActivityBuilder_TemplatesPage.get().previewimages.getText().contains(entry.getValue().toString()));
		}
	}

	@Then("^(\\d+) section should be displayed as Description field$")
	public void section_should_be_displayed_as_Description_field(int noOfResults) throws Throwable {
		if(LearningActivityBuilder_TemplatesPage.get().topictext.getWebElementsCount() == noOfResults){
			Assert.assertTrue("No.of results " + noOfResults + "displayed as expected", true);
			Assert.assertTrue(LearningActivityBuilder_TemplatesPage.get().topictext.isExists());
		}
	}

	@Then("^(\\d+) section should be displayed to upload image$")
	public void section_should_be_displayed_to_upload_image(int noOfResults) throws Throwable {
		if(LearningActivityBuilder_TemplatesPage.get().topicimages.getWebElementsCount() == noOfResults){
			Assert.assertTrue("No.of results " + noOfResults + "displayed as expected", true);
			Assert.assertTrue(LearningActivityBuilder_TemplatesPage.get().topicimages.isExists());
		}
	}

	@When("^Upload image \"([^\"]*)\" for another section$")
	public void upload_image_for_another_section(String arg1) throws Throwable {
		LearningActivityBuilder_TemplatesPage.get().topicbrowsesecondimage.click();	
		String autoItCommand = "";
		if(TestBaseWebDriver.browserType.equalsIgnoreCase(Browsers.CHROME.toString()))
		{
			autoItCommand = String.format("%s  %s %s",new File("src/test/resources/AutoITScripts/FileUpload.exe").getAbsolutePath(),"Open",new File("src/test/resources/TestData/Automation_QTP.jpeg").getAbsolutePath());
		}
		
		if(TestBaseWebDriver.browserType.equalsIgnoreCase(Browsers.FIREFOX.toString()))
		{
			autoItCommand = String.format("%s  %s %s",new File("src/test/resources/AutoITScripts/FileUpload.exe").getAbsolutePath(),"File Upload",new File("src/test/resources/TestData/Automation_QTP.jpeg").getAbsolutePath());
		}
		if(TestBaseWebDriver.browserType.equalsIgnoreCase(Browsers.IE.toString()))
		{
			autoItCommand = String.format("%s  %s %s",new File("src/test/resources/AutoITScripts/FileUpload.exe").getAbsolutePath(),"Choose File to Upload",new File("src/test/resources/TestData/Automation_QTP.jpeg").getAbsolutePath());
			
		}
		Runtime.getRuntime().exec(autoItCommand);
		Thread.sleep(10000);
	}

	@Then("^Images should be displayed for both the sections$")
	public void images_should_be_displayed_for_both_the_sections() throws Throwable {
		if(LearningActivityBuilder_TemplatesPage.get().topicbrowsebothimages.getWebElementsCount() == 2){
			Assert.assertTrue(LearningActivityBuilder_TemplatesPage.get().topicbrowsebothimages.isExists());
		}
	}
}
