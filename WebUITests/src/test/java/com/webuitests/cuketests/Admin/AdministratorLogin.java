package com.webuitests.cuketests.Admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.webuiframework.oua.uitests.utils.TestBaseWebDriver;
import com.webuiframework.oua.uitests.utils.WaitToLoad;
import com.webuiframework.oua.uitests.utils.WebDriverWrapper;
import com.webuitests.base.TestBase;
import com.webuitests.pages.AdministratorLoginPage;
import com.webuitests.pages.CourseCatalogue_HomePage;
import com.webuitests.pages.CourseCatalogue_ProductsPage;
import com.webuitests.pages.LABPage;
import com.webuitests.pages.LMSPage;
import com.webuitests.pages.LearningActivityBuilder_DashboardPage;
import com.webuitests.pages.LearningActivityBuilder_TemplatesPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class AdministratorLogin extends TestBase {

	@Given("^Admin is viewing LMS home Page$")
	public void admin_is_viewing_LMS_home_Page() throws Throwable {
		WebDriverWrapper.open(LMSURL);
		WebDriverWrapper.waitForAjaxJQueryProcess();
		AdministratorLoginPage.get().usernameinput.setText(adminuserName);
		AdministratorLoginPage.get().passwordinput.setTextSecure(adminPassword);
		AdministratorLoginPage.get().loginButton.click();
		WebDriverWrapper.waitForAjaxJQueryProcess();
	}

	@Given("^Admin is viewing LMS Page$")
	public void admin_is_viewing_LMS_Page() {
		WebDriverWrapper.open(LMSURL);
		WebDriverWrapper.waitForAjaxJQueryProcess();
		AdministratorLoginPage.get().usernameinput.setText(adminuserName);
		AdministratorLoginPage.get().passwordinput.setTextSecure(adminPassword);
		AdministratorLoginPage.get().loginButton.click();
		WebDriverWrapper.waitForAjaxJQueryProcess();
		WebDriverWrapper.waitForExpectedCondition(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver geWebDriver) {
				return new Boolean(LMSPage.get().coursecompletion.isExists());
			}
		});
	}

	@Given("^Admin is viewing Learning Activity Builder \"([^\"]*)\"$")
	public void admin_is_viewing_Learning_Activity_Builder(String LABOption) throws Throwable {
		WebDriverWrapper.open(LABURL);
		WebDriverWrapper.waitForAjaxJQueryProcess();
		Thread.sleep(10000);
		WebDriverWrapper.waitForElementPresent(By.xpath(AdministratorLoginPage.userinputXpath));
		WebDriverWrapper.waitForElementPresent(By.xpath(AdministratorLoginPage.loginbuttontypeXpath));
		AdministratorLoginPage.get().usernameinput.setText(adminuserName);
		AdministratorLoginPage.get().passwordinput.setTextSecure(adminPassword);
		AdministratorLoginPage.get().loginButton.click();
		WebDriverWrapper.waitForAjaxJQueryProcess();
		WebDriverWrapper
				.waitForvisibilityofElementLocated(By.xpath(LearningActivityBuilder_DashboardPage.TutprialsPaneXpath));
	}

	@Given("^Admin is viewing \"([^\"]*)\" page$")
	public void admin_is_viewing_page(String activity) throws Throwable {
		WebDriverWrapper.open(LABURL);
		WebDriverWrapper.waitForAjaxJQueryProcess();
		WebDriverWrapper.waitForElementPresent(By.xpath(AdministratorLoginPage.userinputXpath));
		WebDriverWrapper.waitForElementPresent(By.xpath(AdministratorLoginPage.loginbuttontypeXpath));
		AdministratorLoginPage.get().usernameinput.setText(adminuserName);
		AdministratorLoginPage.get().passwordinput.setTextSecure(adminPassword);
		AdministratorLoginPage.get().loginButton.click();
		WebDriverWrapper.waitForAjaxJQueryProcess();
		WebDriverWrapper.waitForElementPresent(By.xpath(LearningActivityBuilder_DashboardPage.TutprialsPaneXpath));
		LearningActivityBuilder_TemplatesPage.get().activityButton.click();
		WebDriverWrapper.waitForAjaxJQueryProcess();
	}

	@Given("^Admin open \"([^\"]*)\" activity from 'Latest Activity'$")
	public void admin_open_activity_from_Latest_Activity(String activity) throws Throwable {
		WebDriverWrapper.open(LABURL);
		WebDriverWrapper.waitForAjaxJQueryProcess();
		WebDriverWrapper.waitForTextToBePresent("Login");
		Thread.sleep(10000);
		AdministratorLoginPage.get().usernameinput.setText(adminuserName);
		AdministratorLoginPage.get().passwordinput.setTextSecure(adminPassword);
		AdministratorLoginPage.get().loginButton.waitForClickableAndClick();
		WebDriverWrapper.waitForAjaxJQueryProcess();
		WebDriverWrapper.waitForElementPresent(By.xpath(LearningActivityBuilder_DashboardPage.TutprialsPaneXpath));
		LearningActivityBuilder_TemplatesPage.get().Allactivities.clickByText(activity);
		WebDriverWrapper.waitForAjaxJQueryProcess();
	}

	@Given("^Admin is viewing the Course Catalogue Page$")
	public void admin_is_viewing_the_Course_Catalogue_Page() throws Throwable {
		WebDriverWrapper.open(CourseCatalogueURL);
		WebDriverWrapper.waitForAjaxJQueryProcess();
		AdministratorLoginPage.get().usernameinput.setText(adminuserName);
		AdministratorLoginPage.get().passwordinput.setTextSecure(coursecatalogueadminPassword);
		AdministratorLoginPage.get().loginButton.click();
		WebDriverWrapper.waitForAjaxJQueryProcess();
		WaitToLoad.wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(CourseCatalogue_HomePage.settingsXpath)));
		WebDriverWrapper.waitForElementPresent(By.xpath(CourseCatalogue_HomePage.settingsXpath));
		Thread.sleep(3000);
	}

	@Given("^Admin is viewing \"([^\"]*)\" Page$")
	public void admin_is_viewing_Page(String page) throws Throwable {
		WebDriverWrapper.open(CourseCatalogueURL);
		WebDriverWrapper.waitForAjaxJQueryProcess();
		AdministratorLoginPage.get().usernameinput.setText(adminuserName);
		AdministratorLoginPage.get().passwordinput.setTextSecure(coursecatalogueadminPassword);
		AdministratorLoginPage.get().loginButton.click();
		WebDriverWrapper.waitForAjaxJQueryProcess();
		WebDriverWrapper.waitForTextToBePresent(CourseCatalogue_HomePage.get().settings.getText());
		WebDriverWrapper.waitForExpectedCondition(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver geWebDriver) {
				return new Boolean(CourseCatalogue_HomePage.get().coursecataloguehomepage.isExists());

			}
		});
		Thread.sleep(5000);
		if (page.equals("New_Product")) {
			CourseCatalogue_ProductsPage.get().newProductButton.click();
			WebDriverWrapper.waitForExpectedCondition(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver geWebDriver) {
					return new Boolean(
							CourseCatalogue_ProductsPage.get().ProductPageElements.isVisibleWebElementAvailable());
				}
			});

		} else if (page.equals("Settings")) {
			CourseCatalogue_HomePage.get().settings.click();
			WebDriverWrapper.waitForExpectedCondition(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver geWebDriver) {
					return new Boolean(
							CourseCatalogue_ProductsPage.get().ProductPageElements.isVisibleWebElementAvailable());
				}
			});

		}

	}

	@Given("^Admin is viewing \"([^\"]*)\" tab for the \"([^\"]*)\" assessment$")
	public void admin_is_viewing_tab_for_the_assessment(String tabs, String assessment) throws Throwable {
		WebDriverWrapper.open(LABURL);
		WebDriverWrapper.waitForAjaxJQueryProcess();
		Thread.sleep(500);
		AdministratorLoginPage.get().usernameinput.setText(adminuserName);
		AdministratorLoginPage.get().passwordinput.setTextSecure(adminPassword);
		AdministratorLoginPage.get().loginButton.click();
		WebDriverWrapper.waitForAjaxJQueryProcess();
		WebDriverWrapper.waitForElementPresent(By.xpath(LearningActivityBuilder_DashboardPage.TutprialsPaneXpath));
		LearningActivityBuilder_TemplatesPage.get().Allactivities.clickByText("Test Complete");
		WebDriverWrapper.waitForAjaxJQueryProcess();
		Thread.sleep(3000);
		if (TestBaseWebDriver.browserType.equalsIgnoreCase(Browsers.FIREFOX.toString())) {
			LABPage.get().LabAssessment.click();
			LABPage.get().AssessmetsOptions.clickByText(tabs);
		}
		if (TestBaseWebDriver.browserType.equalsIgnoreCase(Browsers.CHROME.toString())) {
			String script = String.format("$('a[title*=\"%s\"]').click()", assessment);
			WebDriverWrapper.executeScript(script);
			String buttonscript = String.format("$(\"a:contains(%s)\").click()", tabs);
			WebDriverWrapper.executeScript(buttonscript);
		}

	}

	@Given("^Admin click on \"([^\"]*)\" Activity which 'activity-status' is \"([^\"]*)\"$")
	public void admin_click_on_Activity_which_activity_status_is(String activityName, String activityStatus)
			throws Throwable {
		WebDriverWrapper.waitForElementPresent(By.xpath(LearningActivityBuilder_DashboardPage.TutprialsPaneXpath));
		if (WebDriverWrapper
				.getWebElementByXpath(
						String.format(LearningActivityBuilder_DashboardPage.activitystatusXpath, activityName))
				.getText().contains(activityStatus)) {
			WebDriverWrapper.waitForAjaxJQueryProcess();
			WebDriverWrapper.waitForElementPresent(By.xpath(LearningActivityBuilder_DashboardPage.TutprialsPaneXpath));
			WebDriverWrapper
					.getWebElementByXpath(
							String.format(LearningActivityBuilder_DashboardPage.dashboardactivityXpath, activityName))
					.click();
			WebDriverWrapper.waitForAjaxJQueryProcess();
		}
	}

	@Given("^Admin is viewing 'Groups Global Learning Activities' page$")
	public void admin_is_viewing_Groups_Global_Learning_Activities_page() throws Throwable {
		WebDriverWrapper.open(LMSURL);
		WebDriverWrapper.waitForAjaxJQueryProcess();
		AdministratorLoginPage.get().usernameinput.setText(adminuserName);
		AdministratorLoginPage.get().passwordinput.setTextSecure(adminPassword);
		AdministratorLoginPage.get().loginButton.click();
		WebDriverWrapper.waitForAjaxJQueryProcess();
		WebDriverWrapper.waitForElementPresent(By.xpath(String.format(LMSPage.groupsinlmsXpath, groupglobal)));
		String script = String.format("$('span:contains(%s)').click()", groupglobal);
		WebDriverWrapper.executeScript(script);
		String scriptLAB = String.format("$('a:contains(%s)').click()", permissiontab);
		WebDriverWrapper.executeScript(scriptLAB);
	}

	@Given("^Admin is viewing 'Srikanth  Manne \\(srikmann@e(\\d+)\\)' page$")
	public void admin_is_viewing_Srikanth_Manne_srikmann_e_page(int userName) throws Throwable {
		WebDriverWrapper.open(LMSURL);
		WebDriverWrapper.waitForAjaxJQueryProcess();
		AdministratorLoginPage.get().usernameinput.setText(adminuserName);
		AdministratorLoginPage.get().passwordinput.setTextSecure(adminPassword);
		AdministratorLoginPage.get().loginButton.click();
		WebDriverWrapper.waitForAjaxJQueryProcess();
		WebDriverWrapper.waitForElementPresent(By.xpath(String.format(LMSPage.groupsinlmsXpath, groupglobal)));
		String script = String.format("$('span:contains(%s)').click()", groupglobal);
		WebDriverWrapper.executeScript(script);
		String scriptLearning = String.format("$('a:contains(%s)').click()", permissiontab);
		WebDriverWrapper.executeScript(scriptLearning);
		WebDriverWrapper.waitForAjaxJQueryProcess();
		String scriptAccount = String.format("$('span:contains(%s)').click()", lmsuser);
		WebDriverWrapper.executeScript(scriptAccount);
	}

	@Given("^Learner is viewing \"([^\"]*)\" index page$")
	public void learner_is_viewing_index_page(String e3page) throws Throwable {
		WebDriverWrapper.open(E3URL);
		WebDriverWrapper.waitForAjaxJQueryProcess();
		AdministratorLoginPage.get().SignIninput.click();
		AdministratorLoginPage.get().usernameinput.setText(e3adminuserName);
		AdministratorLoginPage.get().passwordinput.setTextSecure(e3adminPassword);
		AdministratorLoginPage.get().signinbuttontype.click();
		WebDriverWrapper.waitForAjaxJQueryProcess();
	}
	
	@Given("^Admin is viewing Admin home Page$")
	public void admin_is_viewing_Admin_home_Page() throws Throwable {
		WebDriverWrapper.open(AdminURL);
		WebDriverWrapper.waitForAjaxJQueryProcess();
		AdministratorLoginPage.get().AdminUserName.setText(e3adminuserName);
		AdministratorLoginPage.get().AdminPwd.setTextSecure(e3adminPassword);
		AdministratorLoginPage.get().loginButton.click();
		WebDriverWrapper.waitForAjaxJQueryProcess();
	}
	
	@Given("^Admin is viewing \"([^\"]*)\" admin page$")
	public void admin_is_viewing_admin_page(String adminUser) throws Throwable {
		WebDriverWrapper.open(AdminURL);
		WebDriverWrapper.waitForAjaxJQueryProcess();
		AdministratorLoginPage.get().AdminUserName.setText(e3adminuserName);
		AdministratorLoginPage.get().AdminPwd.setTextSecure(e3adminPassword);
		AdministratorLoginPage.get().loginButton.click();
		WebDriverWrapper.waitForAjaxJQueryProcess();
		String script = String.format("$('span:contains(%s)').click()", groupglobal);
		WebDriverWrapper.executeScript(script);
		String scriptLearning = String.format("$('a:contains(%s)').click()", admincourse);
		WebDriverWrapper.executeScript(scriptLearning);
		WebDriverWrapper.waitForAjaxJQueryProcess();
		String scriptAccount = String.format("$('a:contains(%s)').click()", adminuser);
		WebDriverWrapper.executeScript(scriptAccount);
		WebDriverWrapper.waitForAjaxJQueryProcess();
	}
	
	@Given("^Admin is viewing 'Global: Group Enrolled Courses' page$")
	public void admin_is_viewing_Global_Group_Enrolled_Courses_page() throws Throwable {
		WebDriverWrapper.open(AdminURL);
		WebDriverWrapper.waitForAjaxJQueryProcess();
		AdministratorLoginPage.get().AdminUserName.setText(e3adminuserName);
		AdministratorLoginPage.get().AdminPwd.setTextSecure(e3adminPassword);
		AdministratorLoginPage.get().loginButton.click();
		WebDriverWrapper.waitForAjaxJQueryProcess();
		String script = String.format("$('span:contains(%s)').click()", groupglobal);
		WebDriverWrapper.executeScript(script);
		String scriptLAB = String.format("$('a:contains(%s)').click()", admincourse);
		WebDriverWrapper.executeScript(scriptLAB);
	}
	
	@Given("^Admin is viewing 'Srikanth Manne \\(srikmann@e(\\d+)\\): Course Enrolment' page$")
	public void admin_is_viewing_Srikanth_Manne_srikmann_e_Course_Enrolment_page(int userid) throws Throwable {
		WebDriverWrapper.open(AdminURL);
		WebDriverWrapper.waitForAjaxJQueryProcess();
		AdministratorLoginPage.get().AdminUserName.setText(e3adminuserName);
		AdministratorLoginPage.get().AdminPwd.setTextSecure(e3adminPassword);
		AdministratorLoginPage.get().loginButton.click();
		WebDriverWrapper.waitForAjaxJQueryProcess();
		String script = String.format("$('span:contains(%s)').click()", groupglobal);
		WebDriverWrapper.executeScript(script);
		String scriptLAB = String.format("$('a:contains(%s)').click()", admincourse);
		WebDriverWrapper.executeScript(scriptLAB);
		WebDriverWrapper.waitForAjaxJQueryProcess();
		String scriptuser = String.format("$('a:contains(%s)').click()", adminuser);
		WebDriverWrapper.executeScript(scriptuser);
	}
	
	@Given("^Admin is viewing 'Learn Force Activity Builder' Page$")
	public void admin_is_viewing_Learn_Force_Activity_Builder_Page() throws Throwable {
		WebDriverWrapper.open(LABURL);
		WebDriverWrapper.waitForAjaxJQueryProcess();
		Thread.sleep(3000);
		WebDriverWrapper.waitForTextToBePresent("Login");
		AdministratorLoginPage.get().usernameinput.setText(e3adminuserName);
		AdministratorLoginPage.get().passwordinput.setTextSecure(e3adminPassword);
		AdministratorLoginPage.get().loginButton.waitForClickableAndClick();
		WebDriverWrapper.waitForAjaxJQueryProcess();
	}
	
	
	
}