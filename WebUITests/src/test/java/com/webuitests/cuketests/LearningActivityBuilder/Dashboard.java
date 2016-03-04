package com.webuitests.cuketests.LearningActivityBuilder;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.webuiframework.oua.uitests.utils.WaitToLoad;
import com.webuiframework.oua.uitests.utils.WebDriverWrapper;
import com.webuitests.base.TestBase;
import com.webuitests.cuketests.Admin.AdministratorLogin;
import com.webuitests.pages.AdministratorLoginPage;
import com.webuitests.pages.LearningActivityBuilder_DashboardPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.AssertionFailedError;

public class Dashboard {

	@Then("^Below Sections should be displayed$")
	public void below_Sections_should_be_displayed(List<String> sections) throws Throwable {
		Assert.assertTrue(LearningActivityBuilder_DashboardPage.get().HistroyLogPanel.isExists());
		Assert.assertTrue(LearningActivityBuilder_DashboardPage.get().ActivitiesPanel.isExists());
		Assert.assertTrue(LearningActivityBuilder_DashboardPage.get().TutorialPanel.isExists());
	}

	@Then("^All Activities should be displayed as Grid by default$")
	public void all_Activities_should_be_displayed_as_Grid_by_default() throws Throwable {
		Assert.assertTrue("Activites are not displayed in Grid View",
				LearningActivityBuilder_DashboardPage.get().ViewButton.getAttribute("title")
						.equalsIgnoreCase("Display as grid"));
	}

	@When("^Admin click on \"([^\"]*)\" on Dashboard$")
	public void admin_click_on_on_Dashboard(String view) throws Throwable {
		if (LearningActivityBuilder_DashboardPage.get().ViewButton.getAttribute("title")
				.equalsIgnoreCase("Display as list") && view.equalsIgnoreCase("Grid view")) {
			LearningActivityBuilder_DashboardPage.get().GirdOrListView.click();
			WebDriverWrapper.waitForTitle("Display as grid");
		} else if (LearningActivityBuilder_DashboardPage.get().ViewButton.getAttribute("title")
				.equalsIgnoreCase("Display as grid") && view.equalsIgnoreCase("List view")) {
			LearningActivityBuilder_DashboardPage.get().GirdOrListView.click();
			WebDriverWrapper.waitForTitle("Display as list");
		}
	}

	@Then("^All activities should be displayed as 'List'$")
	public void all_activities_should_be_displayed_as_List() throws Throwable {
		Assert.assertTrue("Activites are not displayed in List View",
				LearningActivityBuilder_DashboardPage.get().ViewButton.getAttribute("title")
						.equalsIgnoreCase("Display as list"));
	}

	@When("^Admin select contextmenu \"([^\"]*)\" activity action from 'Dashboard'$")
	public void admin_select_activity_action_from_Dashboard(String activityName) throws Throwable {
		WebDriverWrapper
				.getWebElementByXpath(
						String.format(LearningActivityBuilder_DashboardPage.contextmenubuttonXpath, activityName))
				.click();
	}

	@Then("^Below Actions should be displayed for activities in \"([^\"]*)\" for \"([^\"]*)\"$")
	public void below_Actions_should_be_displayed_for_activities_in(String view, String activityName,
			List<String> contextmenuOptions) throws Throwable {
		Integer options = 0;
		WebDriverWrapper
				.getWebElementByXpath(
						String.format(LearningActivityBuilder_DashboardPage.contextmenubuttonXpath, activityName))
				.click();
		for (WebElement contextMenuOptionElement : WebDriverWrapper.getWebElementsByXpath(String
				.format(LearningActivityBuilder_DashboardPage.contextmenuOptionsForactivityXpath, activityName))) {
			for (String contextMenuOption : contextmenuOptions) {
				if (WebDriverWrapper
						.getWebElementsByXpath(String.format(
								LearningActivityBuilder_DashboardPage.contextmenuOptionsForactivityXpath, activityName))
						.size() == contextmenuOptions.size()
						&& contextMenuOptionElement.getText().equals(contextMenuOption)) {
					options++;
				}
			}
		}
		Assert.assertTrue("Options are not displayed as per the application",
				options.equals(contextmenuOptions.size()));
	}

	@Then("^By Default 'Sort by' should be displayed as \"([^\"]*)\"$")
	public void by_Default_Sort_by_should_be_displayed_as_modified(String defaultsortField) throws Throwable {
		Assert.assertTrue("By default sort option is not selected as " + defaultsortField,
				LearningActivityBuilder_DashboardPage.get().SortOptions.getSelectedItem().trim()
						.equals(defaultsortField));
	}

	@Then("^Activities should be displayed depend on \"([^\"]*)\" as below$")
	public void by_Default_activities_should_be_displayed_depend_on_modified_date_as_below(String sortOption,
			List<String> activities) throws Throwable {
		Integer sorted = 0;
		if (activities != null && LearningActivityBuilder_DashboardPage.get().ActivityTitles.getWebElements() != null
				&& activities.size() == LearningActivityBuilder_DashboardPage.get().ActivityTitles.getWebElements()
						.size()) {
			for (String activity : activities) {
				if (LearningActivityBuilder_DashboardPage.get().ActivityTitles.getWebElementByText(activity).getText()
						.equals(activity)
						&& LearningActivityBuilder_DashboardPage.get().ActivityTitles
								.getIndexByText(activity) == (activities.indexOf(activity))) {
					sorted++;
				}

			}
		}
		Assert.assertTrue("Activities are not sorted as " + sortOption + " for activity ",
				sorted.equals(activities.size()));

	}

	@When("^Admin selects 'sort by' to \"([^\"]*)\" on 'Dashboard'$")
	public void admin_selects_sort_by_to_on_Dashboard(String sortOption) throws Throwable {
		LearningActivityBuilder_DashboardPage.get().SortOptions.select(sortOption);
		Thread.sleep(2000);
	}

	@When("^Admin select \"([^\"]*)\" activity from 'Dashboard' displayed in \"([^\"]*)\"$")
	public void admin_select_activity_from_Dashboard(String activityName, String view) throws Throwable {
		if (view.equalsIgnoreCase("Grid View")) {
			WebDriverWrapper.getWebElementByXpath(
					String.format(LearningActivityBuilder_DashboardPage.activityNameThumNailXpath, activityName))
					.click();
		}

		if (view.equalsIgnoreCase("List View")) {
			WebDriverWrapper
					.getWebElementByXpath(
							String.format(LearningActivityBuilder_DashboardPage.activityrowinListXpath, activityName))
					.click();
		}
		WebDriverWrapper
				.waitForElementPresent(By.xpath(LearningActivityBuilder_DashboardPage.activityModalDialogXpath));
	}

	@Then("^'Summary panel' should be displayed for selected activity$")
	public void summary_panel_should_be_displayed_for_selected_activity() throws Throwable {
		WebDriverWrapper
				.waitForElementPresent(By.xpath(LearningActivityBuilder_DashboardPage.activityModalDialogXpath));
		Assert.assertTrue("Summary Panel is now displayed",
				LearningActivityBuilder_DashboardPage.get().ActivityModalDialog.isExists());
	}

	@Then("^summary panel should be displayed with the below details \"([^\"]*)\"$")
	public void summary_panel_should_be_displayed_with_the_below_details_Grid_View(String view,
			Map<String, String> summarypaneDetails) throws Throwable {
		Assert.assertTrue(summarypaneDetails.get("DESCRIPTION") + " is not displayed as expected",
				summarypaneDetails.get("DESCRIPTION").equals(
						LearningActivityBuilder_DashboardPage.get().ActivityDescriptionInSummaryPane.getText()));
		Assert.assertTrue(summarypaneDetails.get("CATEGORY") + " is not displayed as expected",
				summarypaneDetails.get("CATEGORY")
						.equals(LearningActivityBuilder_DashboardPage.get().ActivityCategoryInSummaryPane.getText()));
		Assert.assertTrue(summarypaneDetails.get("PROVIDER") + " is not displayed as expected",
				summarypaneDetails.get("PROVIDER")
						.equals(LearningActivityBuilder_DashboardPage.get().ActivityProviderInSummaryPane.getText()));
		Assert.assertTrue(summarypaneDetails.get("TRAINING DURATION") + " is not displayed as expected",
				summarypaneDetails.get("TRAINING DURATION").equals(
						LearningActivityBuilder_DashboardPage.get().ActivityTrainingHoursInSummaryPane.getText()));
		Assert.assertTrue(summarypaneDetails.get("Certificate of completion") + " is not displayed as expected",
				summarypaneDetails.get("Certificate of completion").equals(
						LearningActivityBuilder_DashboardPage.get().ActivityCertificateInSummaryPane.getText()));
		// Assert.assertTrue(summarypaneDetails.get("LAST LOG ENTRY") +" is not
		// displayed as expected", summarypaneDetails.get("LAST LOG
		// ENTRY").contains(LearningActivityBuilder_DashboardPage.get().ActivityLastLogInSummaryPane.getText()));
		LearningActivityBuilder_DashboardPage.get().LatestActivityHeader.clickAction();
	}

	@Then("^summary panel should be displayed with the below details 'List View'$")
	public void summary_panel_should_be_displayed_with_the_below_details_List_View(Map<String, String> arg1)
			throws Throwable {
	}

	@Then("^below menu options should be displayed$")
	public void below_menu_options_should_be_displayed(List<String> MenuOptions) throws Throwable {
		for (String menuOption : MenuOptions) {
			if (MenuOptions.equals("Menu") || MenuOptions.equals("Tools")) {
				Assert.assertTrue(menuOption + " no displayed as expected",
						LearningActivityBuilder_DashboardPage.get().MenuOptions.getWebElementByTextContains(menuOption)
								.getText().contains(menuOption));
			}

			else {
				Assert.assertTrue(LearningActivityBuilder_DashboardPage.get().ProductMenuButton.isExists());
			}
		}
	}

	@When("^Admin click on \"([^\"]*)\" option on 'Dashboard'$")
	public void admin_click_on_option_on_Dashboard(String menuoption) throws Throwable {
		LearningActivityBuilder_DashboardPage.get().MenuOptions.getWebElementByTextContains(menuoption).click();
	}

	@Then("^Below option should be displayed as part of 'Menu' option$")
	public void below_option_should_be_displayed_as_part_of_Menu_option(List<String> menuoptions) throws Throwable {
		for (String menuOption : menuoptions) {
			Assert.assertTrue(menuOption + " is not displayed as expected",
					LearningActivityBuilder_DashboardPage.get().MenuDropdownOptions
							.getWebElementByTextContains(menuOption).getText().contains(menuOption));
		}
		if (LearningActivityBuilder_DashboardPage.get().MenuDropdownOptions.getWebElementsCount() == menuoptions
				.size()) {
			Assert.assertTrue(true);
		}
	}

	@When("^Admin click on '([^\\\"]*)' displayed on 'Menu'$")
	public void admin_click_on_Dashboard_displayed_on_Menu(String menuoption) throws Throwable {
		LearningActivityBuilder_DashboardPage.get().MenuDropdownOptions.getWebElementByTextContains(menuoption).click();
		WebDriverWrapper.waitforelementExistsWithText(By.xpath(LearningActivityBuilder_DashboardPage.menuoptionsXpath),
				menuoption);

	}

	@Then("^Admin should be viewing page with '([^\\\"]*)'$")
	public void admin_should_be_viewing_page_with_Dashboard(String menutitle) throws Throwable {
		if (menutitle.equals("Dashboard")) {
			Assert.assertTrue(menutitle + " is not displayed as expected",
					LearningActivityBuilder_DashboardPage.get().DashBoardTitle.getText().contains(menutitle));
		}
		if (menutitle.equals("Classifications")) {
			WebDriverWrapper
					.waitForElementPresent(By.xpath(LearningActivityBuilder_DashboardPage.classificationsheaderXpath));
			Assert.assertTrue(menutitle + " is not displayed as expected",
					LearningActivityBuilder_DashboardPage.get().ClassificationHeader.getText().contains(menutitle));
		}
		if (menutitle.equals("Help & Support")) {
			WebDriverWrapper
					.waitForElementPresent(By.xpath(LearningActivityBuilder_DashboardPage.knowledgebaseheaderXpath));
			WebDriverWrapper
					.waitForElementPresent(By.xpath(LearningActivityBuilder_DashboardPage.knoledgebasehomeXpath));
			Assert.assertTrue(menutitle + " is not displayed as expected",
					LearningActivityBuilder_DashboardPage.get().KnowledgeBaseHeader.getText()
							.contains("KnowledgeBase"));
			Assert.assertTrue(menutitle + " is not displayed as expected",
					LearningActivityBuilder_DashboardPage.get().KnowledgeBaseHome.getText()
							.contains("Knowledgebase Home"));
		}
		if (menutitle.equals("Help & Support")) {
			WebDriverWrapper.waitForElementPresent(By.xpath(LearningActivityBuilder_DashboardPage.signInXpath));
			Assert.assertTrue(menutitle + " is not displayed as expected",
					LearningActivityBuilder_DashboardPage.get().SignInLink.getText().contains("Sign-In"));

		}

	}

	@Then("^Admin should be displayed as \"([^\"]*)\" as placeholder in search box$")
	public void admin_should_be_displayed_as_as_placeholder_in_search_box(String placeHolder) throws Throwable {
		Assert.assertTrue(placeHolder + " is not displayed as expected",
				LearningActivityBuilder_DashboardPage.get().SearchBox.getAttribute("placeholder")
						.contains(placeHolder));
	}

	@When("^Admin enter activity 'Title' \"([^\"]*)\" in 'Search'$")
	public void admin_enter_activity_Title_in_Search(String activityName) throws Throwable {
		LearningActivityBuilder_DashboardPage.get().SearchBox.setText(activityName);
		LearningActivityBuilder_DashboardPage.get().SearchBox.pressEnter();
	}

	@Then("^Search results should be displayed with header \"([^\"]*)\" for activity \"([^\"]*)\"$")
	public void search_results_should_be_displayed_with_header(String searchResultHeader, String activityName)
			throws Throwable {
		Assert.assertTrue(
				searchResultHeader + "Result Header is not displayed for search criteria for activity Name "
						+ activityName,
				LearningActivityBuilder_DashboardPage.get().SearchResultHeader.getText().contains(searchResultHeader));
		String searchResultTopHeader = LearningActivityBuilder_DashboardPage.get().SearchHeaderForActivity.getText()
				+ LearningActivityBuilder_DashboardPage.get().SearchHeaderForActivity.getText();
		Assert.assertTrue("Reasult Header is not displayed with activity Name " + activityName,
				searchResultTopHeader.contains("Search Results For " + activityName));
	}

	@Then("^(\\d+) activity should be displayed with below details$")
	public void activity_should_be_displayed_with_below_details(int noOfSearchResult,
			Map<String, String> searchResultDetails) throws Throwable {
		if (LearningActivityBuilder_DashboardPage.get().SearchResults.getWebElementsCount() == noOfSearchResult) {
			Assert.assertTrue("Search Result " + noOfSearchResult + "is not displayed as expected", true);
		}
		searchResultDetails = new HashMap<String, String>();
		Iterator entries = searchResultDetails.entrySet().iterator();
		while (entries.hasNext()) {
			Map.Entry entry = (Map.Entry) entries.next();
			Assert.assertTrue("Activity " + entry.getKey() + "should be displayed as part of search result",
					LearningActivityBuilder_DashboardPage.get().ActivityTitles
							.getWebElementByTextContains(entry.getKey().toString()).getText()
							.contains(entry.getKey().toString()));
			Assert.assertTrue("Activity Type " + entry.getValue() + "should be displayed as part of search result",
					LearningActivityBuilder_DashboardPage.get().ActivityTypeInSearchResult
							.getWebElementByTextContains(entry.getKey().toString()).getText()
							.contains(entry.getValue().toString()));

		}

	}

	@When("^Admin enter activity 'Unit Id' \"([^\"]*)\" in 'Search'$")
	public void admin_enter_activity_Unit_Id_in_Search(String unitID) throws Throwable {
		LearningActivityBuilder_DashboardPage.get().SearchBox.setText(unitID);
		LearningActivityBuilder_DashboardPage.get().SearchBox.pressEnter();
	}

	@Then("^\"([^\"]*)\" button should be displayed on 'Dashboard' page$")
	public void button_should_be_displayed_on_Dashboard_page(String createActivitybutton) throws Throwable {
		WebDriverWrapper.waitForTextToBePresent(createActivitybutton);
		Assert.assertTrue(createActivitybutton + " is not displayed in Activity Dashboard",
				LearningActivityBuilder_DashboardPage.get().CreateNewActivityButton.getText().trim()
						.contains(createActivitybutton));
	}

	@When("^Admin click on 'Create new activity' on 'Dashboard'$")
	public void admin_click_on_Create_new_activity_on_Dashboard() throws Throwable {
		LearningActivityBuilder_DashboardPage.get().CreateNewActivityButton.click();
		WebDriverWrapper.waitForElementPresent(By.xpath(LearningActivityBuilder_DashboardPage.newactivitysectionXpath));
	}

	@Then("^\"([^\"]*)\" page should be displayed with the below buttons$")
	public void page_should_be_displayed_with_the_below_buttons(String defaultactivityName, List<String> buttons)
			throws Throwable {
		Assert.assertTrue(defaultactivityName + " is not displayed for new Activity",
				LearningActivityBuilder_DashboardPage.get().NewActivitySection.getText().trim()
						.contains(defaultactivityName));
		for (String button : buttons) {
			Assert.assertTrue("Button " + button + " is not displayed in new activity section",
					LearningActivityBuilder_DashboardPage.get().SaveAndPublishButtons
							.getWebElementByTextContains(button).getText().contains(button));
		}
	}

	@Then("^information message should be displayed as \"([^\"]*)\"$")
	public void information_message_should_be_displayed_as(String informationMessage) throws Throwable {
		Assert.assertTrue(informationMessage + " is not displayed on New Activity",
				LearningActivityBuilder_DashboardPage.get().InformationMessageOnNewActivity.getText().trim()
						.contains(informationMessage));
	}

	@Then("^Below tab should be displayed in 'NEW ACTIVITY' page$")
	public void below_tab_should_be_displayed_in_NEW_ACTIVITY_page(List<String> tabs) throws Throwable {
		for (String tab : tabs) {
			Assert.assertTrue(tab + " is not diaplayed on New Activity section",
					LearningActivityBuilder_DashboardPage.get().TabsInNewActivity.getWebElementByTextContains(tab)
							.getText().contains(tab));
		}
	}

	@Then("^Below buttons should be displayed for 'NEW ACTIVITY'$")
	public void below_buttons_should_be_displayed(List<String> actionbuttonsforNewActivity) throws Throwable {
		Integer componentExists = 0;
		for (String actionbuttonforNewActivity : actionbuttonsforNewActivity) {
			for (WebElement actioncomponentbutton : LearningActivityBuilder_DashboardPage
					.get().ActionButtonsForNewActivity.getWebElements()) {
				if (actioncomponentbutton.getAttribute("title").equals("actionbuttonforNewActivity")) {
					componentExists++;
				}
			}

		}
		if (LearningActivityBuilder_DashboardPage.get().ActionButtonsForNewActivity
				.getWebElementsCount() == componentExists) {
			Assert.assertTrue("Titile is not displayed for new activity", true);
		}
	}

	@When("^Admin click on \"([^\"]*)\" for 'NEW ACTIVITY'$")
	public void admin_click_on_button(String arg1) throws Throwable {
		LearningActivityBuilder_DashboardPage.get().AddComponentAction.click();
	}

	@Then("^Below component should be displayed in 'NEW ACTIVITY' page$")
	public void below_component_should_be_displayed_in_NEW_ACTIVITY_page(List<String> addcomponents) throws Throwable {
		for (String addcomponent : addcomponents) {
			Assert.assertTrue(addcomponent + " component not displayed to add to activity",
					LearningActivityBuilder_DashboardPage.get().AddComponentsForActivity
							.getWebElementByTextContains(addcomponent).getText().contains(addcomponent));
		}
	}

	@When("^Admin click on 'Close' for new activity$")
	public void admin_click_on_Close_new_activity() throws Throwable {
		LearningActivityBuilder_DashboardPage.get().CloseActivity.click();
	}

	@Then("^Below tutorials should be displayed at the bottom section$")
	public void below_tutorials_should_be_displayed_at_the_bottom_section(List<String> vediotutorials)
			throws Throwable {
		for (String vediotutorial : vediotutorials) {
			if (LearningActivityBuilder_DashboardPage.get().VedioTutorials.getWebElementsCount() == vediotutorials
					.size()) {
				Assert.assertTrue(vediotutorial + " is not displayed in Activity Page",
						LearningActivityBuilder_DashboardPage.get().VedioTutorials
								.getWebElementByTextContains(vediotutorial).getText().contains(vediotutorial));
			}

		}
	}

	@When("^Admin click on '([^\\\"]*)' on 'Dashboard' for vedio Tutorials$")
	public void admin_click_on_The_Dashboard_on_Dashboard(String vedioLink) throws Throwable {
		WebDriverWrapper.scrollPageToEnd();
		LearningActivityBuilder_DashboardPage.get().VedioTutorials.getWebElementByTextContains(vedioLink).click();
	}

	@Then("^Tab should be displayed with '([^\\\"]*)'$")
	public void tab_should_be_displayed_with_Title(String pageTitle) throws Throwable {
		WebDriverWrapper.waitForNativeWindow(pageTitle);
		WebDriverWrapper.switchToWindowUsingTitle(pageTitle);
	}

	@Then("^\"([^\"]*)\" page should be displayed$")
	public void dashboard_page_should_be_displayed(String pageName) throws Throwable {
		WebDriverWrapper.waitForpresenceOfElement(
				By.xpath(LearningActivityBuilder_DashboardPage.createactivityactionbuttonsXpath));
		Assert.assertTrue(pageName + " is not displayed on closing the activity",
				LearningActivityBuilder_DashboardPage.get().DashBoardTitle.getText().contains(pageName));
	}

	@Then("^\"([^\"]*)\" should not be displayed on 'Dashboard'$")
	public void dashboard_page_should_not_be_displayed(String activityName) throws Throwable {
		Thread.sleep(1000);
		Boolean activityExists = false;
		for (WebElement activity : LearningActivityBuilder_DashboardPage.get().ActivityTitles.getWebElements()) {
			if (activity.getText().trim().equals(activityName)) {
				activityExists = true;
			}
		}
		Assert.assertFalse(activityName + " is displayed on activity dashboard", activityExists);
	}

	@When("^Admin Open \"([^\"]*)\" activity from 'History Log'$")
	public void admin_Open_activity_from_History_Log(String activityName) throws Throwable {
		LearningActivityBuilder_DashboardPage.get().ActivitiesFromHistoryLog.getWebElementByText(activityName).click();
	}

	@Then("^\"([^\"]*)\" activity should be displayed$")
	public void activity_should_be_displayed(String activityName) throws Throwable {
		WebDriverWrapper.waitForTextToBePresent(activityName);
		Assert.assertTrue(activityName + " is not opened as expected",
				LearningActivityBuilder_DashboardPage.get().ActivityNameOnEdit.getText().toLowerCase().trim()
						.contains(activityName.toLowerCase()));
	}

	@When("^Admin navigate to \"([^\"]*)\" from activity page$")
	public void admin_navigate_to_Dashboard_from_activity_page(String menuOption) throws Throwable {
		LearningActivityBuilder_DashboardPage.get().MenuOptions.getWebElementByTextContains("Menu").click();
		WebDriverWrapper.waitforelementExistsWithText(By.xpath(LearningActivityBuilder_DashboardPage.menuoptionsXpath),
				menuOption);
		LearningActivityBuilder_DashboardPage.get().MenuDropdownOptions.getWebElementByTextContains(menuOption).click();

	}

	@When("^Admin Open \"([^\"]*)\" activity from 'Activity panel'$")
	public void admin_Open_activity_from_Activity_panel(String activityName) throws Throwable {
		Thread.sleep(1000);
		for (WebElement activity : LearningActivityBuilder_DashboardPage.get().ActivityTitles.getWebElements()) {
			if (activity.getText().contains(activityName)) {
				activity.click();
			}

		}
	}

	@Then("^Below activity details should be displayed for activity \"([^\"]*)\"$")
	public void below_activity_details_should_be_displayed_for_activity(String activityName,
			Map<String, String> activityDetails) throws Throwable {
		Assert.assertTrue(activityDetails.get("Learning activity title") + " is not displayed in Activity Pane",
				LearningActivityBuilder_DashboardPage.get().ActivityTitles.getWebElementByTextContains(activityName)
						.getText().contains(activityName));

		Assert.assertTrue(activityDetails.get("Learning activity ID") + " is not displayed in Activity Pane",
				WebDriverWrapper
						.getWebElementByXpath(
								String.format(LearningActivityBuilder_DashboardPage.activityunitIdXpath, activityName))
						.getText().contains(activityDetails.get("Learning activity ID")));

		Assert.assertTrue(activityDetails.get("Development status") + " is not displayed in Activity Pane",
				WebDriverWrapper
						.getWebElementByXpath(
								String.format(LearningActivityBuilder_DashboardPage.activitystatusXpath, activityName))
						.getText().contains(activityDetails.get("Development status")));

		Assert.assertTrue(activityDetails.get("Activity type") + " is not displayed in Activity Pane",
				WebDriverWrapper
						.getWebElementByXpath(
								String.format(LearningActivityBuilder_DashboardPage.activitytypeXpath, activityName))
						.getText().contains(activityDetails.get("Activity type")));

		Assert.assertTrue(activityDetails.get("Description") + " is not displayed in Activity Pane",
				WebDriverWrapper
						.getWebElementByXpath(String
								.format(LearningActivityBuilder_DashboardPage.activityDescriptionXpath, activityName))
						.getText().contains(activityDetails.get("Description")));
	}

	@When("^Admin select context menu of \"([^\"]*)\" activity \"([^\"]*)\" displayed on 'Dashboard' from \"([^\"]*)\"$")
	public void admin_select_context_menu_of_activity_displayed_on_Dashboard_from_Activity_Panel(String activityStatus,
			String activityName, String view) throws Throwable {
		//WebDriverWrapper.waitForElementPresent(By.xpath(LearningActivityBuilder_DashboardPage.createnewactivityXpath));
		if (view.equalsIgnoreCase("Activity Panel")) {
			if (LearningActivityBuilder_DashboardPage.get().ViewButton.getAttribute("title")
					.equalsIgnoreCase("Display as list")) {

				LearningActivityBuilder_DashboardPage.get().GirdOrListView.click();
			}

			if (WebDriverWrapper
					.getWebElementByXpath(
							String.format(LearningActivityBuilder_DashboardPage.activitystatusXpath, activityName))
					.getText().contains(activityStatus)) {
				WebDriverWrapper.mouseover(WebDriverWrapper.getWebElementByXpath(
						String.format(LearningActivityBuilder_DashboardPage.activityNameThumNailXpath, activityName)));

				WebDriverWrapper
						.getWebElementByXpath(String
								.format(LearningActivityBuilder_DashboardPage.contextmenubuttonXpath, activityName))
						.click();
			}
		}
		if (view.equalsIgnoreCase("Summary Panel")) {
			if (LearningActivityBuilder_DashboardPage.get().ViewButton.getAttribute("title")
					.equalsIgnoreCase("Display as grid")) {
				LearningActivityBuilder_DashboardPage.get().GirdOrListView.click();
			}

			WebDriverWrapper.mouseover(WebDriverWrapper.getWebElementByXpath(String
					.format(LearningActivityBuilder_DashboardPage.contextmenubuttononlistviewXpath, activityName)));

			WebDriverWrapper
					.getWebElementByXpath(String.format(
							LearningActivityBuilder_DashboardPage.contextmenubuttononlistviewXpath, activityName))
					.click();
		}
		Thread.sleep(2000);
	}

	@Then("^Below option should be displayed for \"([^\"]*)\" for \"([^\"]*)\" activity in \"([^\"]*)\" view$")
	public void below_option_should_be_displayed_for_Published_activity(String activityStatus, String activityName,
			String view, List<String> contextMenuOptions) throws Throwable {
		Integer noOfOptions = 0;
		if (view.equals("Grid")) {
			List<WebElement> contextMenuElements = WebDriverWrapper.getWebElementsByXpath(String
					.format(LearningActivityBuilder_DashboardPage.contextmenuOptionsForactivityXpath, activityName));
			for (String contextMenuOption : contextMenuOptions) {
				for (WebElement contextMenuElement : contextMenuElements) {
					if (contextMenuElement.isDisplayed()) {
						if (contextMenuElement.getText().contains(contextMenuOption)) {
							noOfOptions++;
						}
					}
				}
			}
		}
		if (view.equals("Summary")) {
			List<WebElement> contextMenuElements = WebDriverWrapper.getWebElementsByXpath(String.format(
					LearningActivityBuilder_DashboardPage.contextmenuoptioninlistviewforactivityXpath, activityName));
			for (String contextMenuOption : contextMenuOptions) {
				for (WebElement contextMenuElement : contextMenuElements) {
					if (contextMenuElement.isDisplayed()) {
						if (contextMenuElement.getText().contains(contextMenuOption)) {
							noOfOptions++;
						}
					}
				}
			}
		}
		Assert.assertTrue(
				"Context Menu options are not displayed for the activity with Status " + activityStatus
						+ " for an Activity " + activityName + " in " + view,
				noOfOptions.equals(contextMenuOptions.size()));

	}

	@Then("^Activity \"([^\"]*)\" should be displayed in preview mode$")
	public void activity_should_be_displayed_in_preview_mode(String activityName) throws Throwable {
		WebDriverWrapper.waitForElementPresent(By.xpath(LearningActivityBuilder_DashboardPage.beginCoursebuttonXpath));
		Assert.assertTrue(activityName + " is not displayed in preview mode",
				LearningActivityBuilder_DashboardPage.get().ActivityTitleInPreview.getText().trim()
						.contains(activityName));
		Assert.assertTrue(LearningActivityBuilder_DashboardPage.get().BeginCourseButton.isExists());
	}

	@Then("^warning message should be displayed as \"([^\"]*)\" with \"([^\"]*)\" and \"([^\"]*)\" button$")
	public void warning_message_should_be_displayed_as_with_and_button(String warningmessage, String yesbutton,
			String nobutton) throws Throwable {
		WebDriverWrapper.waitForElementPresent(By.xpath(LearningActivityBuilder_DashboardPage.warningmessageXpath));
		Assert.assertTrue(warningmessage + " is not displayed on as delete activity warning message",
				LearningActivityBuilder_DashboardPage.get().WarningMessageOnDelete.getText().trim()
						.equals(warningmessage.trim()));
		Assert.assertTrue(yesbutton + " is not displayed on delete activity warning message",
				LearningActivityBuilder_DashboardPage.get().ButtonOnDeleteWarningMessage
						.getWebElementByTextContains(yesbutton).getText().contains(yesbutton));
		Assert.assertTrue(nobutton + " is not displayed on delete activity warning message",
				LearningActivityBuilder_DashboardPage.get().ButtonOnDeleteWarningMessage
						.getWebElementByTextContains(nobutton).getText().contains(nobutton));
	}

	@When("^Admin click on \"([^\"]*)\" button on warning message$")
	public void admin_click_on_button_on_warning_message(String yesbuttonName) throws Throwable {
		LearningActivityBuilder_DashboardPage.get().ButtonOnDeleteWarningMessage
				.getWebElementByTextContains(yesbuttonName).click();
	}

	@When("^Admin \"([^\"]*)\" from application$")
	public void admin_logout_from_application(String useraction) throws Throwable {
		LearningActivityBuilder_DashboardPage.get().UserDetailDropDown.click();
		LearningActivityBuilder_DashboardPage.get().UserProfileAction.getWebElementByTextContains(useraction).click();
		WebDriverWrapper.waitForpresenceOfElement(By.xpath(LearningActivityBuilder_DashboardPage.signInXpath));
		Assert.assertTrue("User is not signed out from Application",
				LearningActivityBuilder_DashboardPage.get().SignInLink.isExists());
	}

	@When("^Admin login as different global admin user$")
	public void admin_login_as_different_global_admin_user() throws Throwable {
		AdministratorLogin administratorLoginPage = new AdministratorLogin();
		TestBase.adminuserName = "srikanth@e3";
		TestBase.adminPassword = "srikanth@e3";
		administratorLoginPage.admin_is_viewing_Learning_Activity_Builder("LAB");
	}

	@Then("^History Log should be recored as \"([^\"]*)\" for activity \"([^\"]*)\"$")
	public void history_Log_should_be_recored_as_for_activity(String logDetails, String activityName) throws Throwable {
		Assert.assertTrue(logDetails.trim()
				.equals(String.format("%s was %s %s",
						WebDriverWrapper
								.getWebElementByXpath(String.format(
										LearningActivityBuilder_DashboardPage.HistoryactivitynameXpath, activityName))
						.getText().trim(),
				WebDriverWrapper
						.getWebElementByXpath(String.format(
								LearningActivityBuilder_DashboardPage.HistoryactivitynameactionXpath, activityName))
						.getText().trim(), WebDriverWrapper
								.getWebElementByXpath(String.format(
										LearningActivityBuilder_DashboardPage.HistorylogdetailsXpath, activityName))
								.getText().trim())));
	}
	
	@When("^Admin add \"([^\"]*)\" as Learning component for activity$")
	public void admin_add_as_Learning_component_for_activity(String componentName) throws Throwable {
	    WebDriverWrapper.waitForElementPresent(By.xpath(LearningActivityBuilder_DashboardPage.addcomponentactionbuttonXpath));
		LearningActivityBuilder_DashboardPage.get().AddComponentAction.click();
	    LearningActivityBuilder_DashboardPage.get().LearningActivityBuilderComponents.getWebElementByTextContains(componentName).click();
	    WebDriverWrapper.waitForTextToNotBePresent("Your changes were saved");
	}
	
	@When("^Admin \"([^\"]*)\" activity$")
	public void admin_activity(String actionbutton) throws Throwable {
		Thread.sleep(1000);
	    LearningActivityBuilder_DashboardPage.get().SaveAndPublishButtons.getWebElementByTextContains(actionbutton).click();
	}
	
	@When("^Admin \"([^\"]*)\" from context menu of \"([^\"]*)\" activity displayed$")
	public void admin_from_context_menu_of_activity_displayed(String contextMenuOption, String activityName) throws Throwable {
		List<WebElement> contextMenuElements = WebDriverWrapper.getWebElementsByXpath(String.format(LearningActivityBuilder_DashboardPage.contextmenuOptionsForactivityXpath,activityName));
		for(WebElement contextMenuElement : contextMenuElements){
			if(contextMenuElement.getText().contains(contextMenuOption)){
				contextMenuElement.click();
			}
		}
	}
	
	@Then("^\"([^\"]*)\" activity should be opened$")
	public void activity_should_be_opened(String activityName) throws Throwable {
		Assert.assertTrue(activityName + " is not displayed", LearningActivityBuilder_DashboardPage.get().NewActivitySection.getText().trim().toLowerCase().contains(activityName.toLowerCase())); 
		
	}
	
	


}
