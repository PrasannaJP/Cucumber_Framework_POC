package com.webuitests.cuketests.POC;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

import com.webuiframework.oua.uitests.utils.TestBaseWebDriver;
import com.webuiframework.oua.uitests.utils.WebDriverWrapper;
import com.webuitests.base.TestBase;
import com.webuitests.pages.LMSPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LearningManagementSystem  extends TestBase {
		
	@Then("^Groups Panel should be displayed$")
	public void groups_Panel_should_be_displayed() throws Throwable {
	   Assert.assertTrue(LMSPage.get().grouppanel.isExists());
	}

	@When("^Select Groups radio button$")
	public void select_Groups_radio_button() throws Throwable {
		LMSPage.get().selectGroup.check();
	}

	@When("^Enter Group Name as \"([^\"]*)\" to search$")
	public void enter_Group_Name_as_to_search(String searchText) throws Throwable {
	    LMSPage.get().searchBox.setText(searchText);
	}

	@When("^Click on Search Button$")
	public void click_on_Search_Button() throws Throwable {
	    LMSPage.get().searchButton.click();
	}

	@Then("^\"([^\"]*)\" should be displayed as search results$")
	public void should_be_displayed_as_search_results(String groupName) throws Throwable {
		WebDriverWrapper.waitForExpectedCondition(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver geWebDriver) {
				return new Boolean(LMSPage.get().searchResults.isVisibleWebElementAvailable());
			}
		});
	    WebDriverWrapper.waitForTextToBePresent(groupName);
	    Assert.assertEquals("The "+ groupName + " is not displayed as Search Results" ,groupName, LMSPage.get().searchResults.getText(LMSPage.get().searchResults.getIndexByText(groupName)));
	}
	
	@Given("^Admin is viewing LMS \"([^\"]*)\"$")
	public void admin_is_viewing_LMS(String menuitem) throws Throwable {
		LMSPage.get().menuButton.waitForClickableAndClick();
		LMSPage.get().menuitems.getWebElement(LMSPage.get().menuitems.getIndexByText(menuitem)).click();
		WebDriverWrapper.waitForAjaxJQueryProcess();
	}
	
	@When("^Enter group name \"([^\"]*)\" in Filter Groups & Accounts placeholder$")
	public void enter_group_name_in_Filter_Groups_Accounts_placeholder(String groupName) throws Throwable {
		LMSPage.get().searchBoxIngroupsPanel.setText(groupName);
	}


	@Then("^\"([^\"]*)\" should be displayed as search results in Groups Panel$")
	public void should_be_displayed_as_search_results_in_Groups_Panel(String groupName) throws Throwable {
		LMSPage.get().searchResultsInGroupsPanel.getText(LMSPage.get().searchResultsInGroupsPanel.getIndexByText(groupName));
	}
	
	@When("^Admin click on Create New Group button$")
	public void Click_On_New_Group() throws Throwable {
	    LMSPage.get().createNewGroup.click();
	}

	@Then("^\"([^\"]*)\" deatils page should be displayed$")
	public void new_Group_Details_deatils_page_should_be_displayed(String pageHeader) throws Throwable {
		WebDriverWrapper.waitForExpectedCondition(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver geWebDriver) {
				return new Boolean(LMSPage.get().groupDetailsContainer.isVisibleWebElementAvailable());
			}
		});
		Assert.assertEquals("Group Header is not displayed as expected", pageHeader, LMSPage.get().groupPageHeader.getText());
	    
	}

	@When("^Below details should be entered as as part of group details$")
	public void below_details_should_be_displayed_as_as_part_of_group_details(Map<String,String> groupDeatils) throws Throwable {
		LMSPage.get().groupName.setText(groupDeatils.get("Group_Name"));
		LMSPage.get().groupDescription.setText(groupDeatils.get("Description"));
		LMSPage.get().browseButton.click();
		String autoItCommand = "";
		if(TestBaseWebDriver.browserType.equalsIgnoreCase(Browsers.CHROME.toString()))
		{
			autoItCommand = String.format("%s  %s %s",new File("src/test/resources/AutoITScripts/FileUpload.exe").getAbsolutePath(),"Open",new File(groupDeatils.get("Upload_group_photo")).getAbsolutePath());
		}
		
		if(TestBaseWebDriver.browserType.equalsIgnoreCase(Browsers.FIREFOX.toString()))
		{
			autoItCommand = String.format("%s  %s %s",new File("src/test/resources/AutoITScripts/FileUpload.exe").getAbsolutePath(),"File Upload",new File(groupDeatils.get("Upload_group_photo")).getAbsolutePath());
		}
		if(TestBaseWebDriver.browserType.equalsIgnoreCase(Browsers.IE.toString()))
		{
			autoItCommand = String.format("%s  %s %s",new File("src/test/resources/AutoITScripts/FileUpload.exe").getAbsolutePath(),"Choose File to Upload",new File(groupDeatils.get("Upload_group_photo")).getAbsolutePath());
			
		}
		Runtime.getRuntime().exec(autoItCommand);
		Thread.sleep(10000);
		LMSPage.get().groupphototUpload.click();
		WebDriverWrapper.waitForExpectedCondition(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver geWebDriver) {
				return new Boolean(LMSPage.get().imagecropElements.isVisibleWebElementAvailable());
			}
		});
		LMSPage.get().imageCropButton.click();
	}
	
	@Then("^All above group details should be saved$")
	public void all_above_group_details_should_be_saved() throws Throwable {
		LMSPage.get().savegroup.waitForClickableAndClick();
		 WebDriverWrapper.waitForAjaxJQueryProcess();
	}
	
	@Then("^\"([^\"]*)\" should be displayed in group panel$")
	public void should_be_displayed_in_group_panel(String groupName) throws Throwable {
	    Assert.assertTrue(LMSPage.get().groupNameinEditPage.getText().contains(groupName));
	}
	
	@When("^Select \"([^\"]*)\" from 'GROUPS & ACCOUNTS' context menu$")
	public void select_Groups_from_GROUPS_ACCOUNTS_context_menu(String Groups) throws Throwable {
		if(!Boolean.parseBoolean(LMSPage.get().groupsandAccContextMenu.getAttribute("aria-expanded"))){
			LMSPage.get().groupsandAccContextMenu.click();
		}
		WebDriverWrapper.waitForExpectedCondition(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver geWebDriver) {
				return new Boolean(LMSPage.get().groupsandAccountscontextMenuItems.isVisibleWebElementAvailable());
			}
		});
		LMSPage.get().groupsandAccountscontextMenuItems.getWebElement(LMSPage.get().groupsandAccountscontextMenuItems.getIndexByText(Groups)).click();
		
	}
	
	@When("^Admin click on \"([^\"]*)\" link$")
	public void admin_click_on_link(String account_details_link) throws Throwable {
	    LMSPage.get().accountdetailsLink.click();
		WebDriverWrapper.waitForExpectedCondition(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver geWebDriver) {
				return new Boolean(LMSPage.get().allTabs.isVisibleWebElementAvailable());
			}
		});

	}

	@Then("^Account Details Page should be displayed with the below Tabs$")
	public void account_Details_Page_should_be_displayed_with_the_below_Tabs(List<String> tabs) throws Throwable {
		for(int index = 1; index < LMSPage.get().allTabs.getWebElementsCount();index++){
			Assert.assertTrue(LMSPage.get().allTabs.getWebElementByTextContains(tabs.get(index)).isDisplayed());
		}
	}
	
	@Then("^\"([^\"]*)\" tab should be \"([^\"]*)\" by default$")
	public void tab_should_be_by_default(String default_tab, String selected_tab_class) throws Throwable {
		Assert.assertTrue("By Default "+ default_tab + "is not selected",LMSPage.get().defaultSelectedTab.getAttribute("class").contains(selected_tab_class));
	}
	
	@When("^Admin Click on \"([^\"]*)\" tab in group details page$")
	public void admin_Click_on_tab_in_group_details_page(String tab_to_click) throws Throwable {
		WebDriverWrapper.waitForAjaxJQueryProcess();
		LMSPage.get().allTabs.getWebElementByText(tab_to_click).click();	
				
	}

	@When("^Admin click on \"([^\"]*)\" in 'Learning Activity' Tab$")
	public void admin_click_on_in_Learning_Activity_Tab(String add_learning_activity_button) throws Throwable {
		Thread.sleep(3000);
		WebDriverWrapper.waitForExpectedCondition(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver geWebDriver) {
				return new Boolean(LMSPage.get().detailesContainer.isVisibleWebElementAvailable());
			}
		});
		LMSPage.get().addlearningactivity.click();
	}

	@When("^Admin Enroll course \"([^\"]*)\"$")
	public void admin_Enroll_course(String course_to_enroll) throws Throwable {
		WebDriverWrapper.waitForExpectedCondition(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver geWebDriver) {
				return new Boolean(LMSPage.get().enrollcourseinput.isExists());
			}
		});
		LMSPage.get().enrollcourseinput.isDisplayed();
		LMSPage.get().enrollcourseinput.setText(course_to_enroll);
		LMSPage.get().enrolCourseOption.click();
		LMSPage.get().enrollcourseinput.waitForTextContains(course_to_enroll);
		LMSPage.get().addenrolcourse.click();
	}

	@Then("^Enroled \"([^\"]*)\" course should be displayed$")
	public void enroled_course_should_be_displayed(String enrolled_course) throws Throwable {
		WebDriverWrapper.waitForExpectedCondition(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver geWebDriver) {
				return new Boolean(LMSPage.get().enroledCourse.isDisplayed());
			}
		});
		Assert.assertTrue(LMSPage.get().enroledCourse.getText().contains(enrolled_course));
	}
	
	@When("^Admin Delete \"([^\"]*)\" enrolled course$")
	public void admin_Delete_enrolled_course(String arg1) throws Throwable {
	    LMSPage.get().removeCourse.click();
	}
	
	@Then("^Confirmation window should be displayed with message \"([^\"]*)\"$")
	public void confirmation_window_should_be_displayed_with_message(String confirmation_message) throws Throwable {
		WebDriverWrapper.waitForExpectedCondition(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver geWebDriver) {
				return new Boolean(LMSPage.get().courseDeleteConfirmationMessage.isDisplayed());
			}
		});
	    Assert.assertTrue(LMSPage.get().courseDeleteConfirmationMessage.getText().contains(confirmation_message)); 
	    
	}

	@When("^Admin Click on \"([^\"]*)\" on confirmation window$")
	public void admin_Click_on_on_confirmation_window(String arg1) throws Throwable {
	   LMSPage.get().confirmationMessageAccept.click();
	}

	@Then("^Enrolled Course \"([^\"]*)\" should not be displayed$")
	public void enrolled_Course_should_not_be_displayed(String arg1) throws Throwable {
		LMSPage.get().enroledCourse.waitForExistsThenVanish();
	}
	
	@Then("^Below Permission container should be displayed$")
	public void below_Permission_container_should_be_displayed(List<String> modules) throws Throwable {
		WebDriverWrapper.waitForExpectedCondition(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver geWebDriver) {
				return new Boolean(LMSPage.get().permissionListContainerElements.isVisibleWebElementAvailable());
			}
		});
		for(int index = 0; index < LMSPage.get().permissionListContainerElements.getWebElementsCount();index++){
			if(index==2){
				continue;
			}
			Assert.assertEquals("All the modules are displayed as Expected",LMSPage.get().permissionListContainerElements.getWebElementByText(modules.get(index)).getText(), modules.get(index));
		}
	}

	@When("^Click on \"([^\"]*)\" for \"([^\"]*)\" container in Permission tab$")
	public void click_on_for_container_in_Permission_tab(String controller, String module) throws Throwable {
		WebDriverWrapper.getWebElementByXpath(String.format(LMSPage.showModuleXpath, module)).click();
		//LMSPage.get().showModule.click();
	}

	@Then("^Reporting button should be displayed to provide permission$")
	public void reporting_button_should_be_displayed_to_provide_permission() throws Throwable {
		Assert.assertTrue(LMSPage.get().currentReportingStatus.isExists());
	}

	@When("^Provide 'REPORTING' permisssion for logged in user$")
	public void provide_REPORTING_permisssion_for_logged_in_user() throws Throwable {
		if(!LMSPage.get().currentReportingStatus.getAttribute("style").contains("margin-left: 0px;")){
			LMSPage.get().providereportingpermissionON.click();
			LMSPage.get().permissionConfirmationMessage.waitForElementToVanish();
		}
	}

	@Then("^Reporting permission should be provided for the logged in user$")
	public void reporting_permission_should_be_provided_for_the_logged_in_user() throws Throwable {
		if(!LMSPage.get().currentReportingStatus.getAttribute("style").contains("margin-left: 0px;"))
		{
			Assert.assertTrue(LMSPage.get().currentReportingStatus.getAttribute("style").contains("margin-left: 0px;"));
		}
	}



}
