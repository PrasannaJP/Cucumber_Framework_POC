package com.webuitests.cuketests.LearningActivityBuilder;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.WebElementHandler;

import com.webuiframework.oua.uitests.utils.TestBaseWebDriver;
import com.webuiframework.oua.uitests.utils.WebDriverWrapper;
import com.webuitests.base.TestBase;
import com.webuitests.base.TestBase.Browsers;
import com.webuitests.pages.LABPage;
import com.webuitests.pages.LearningActivityBuilder_DashboardPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PublishingLearningActivity extends TestBase {

	@When("^Admin click \"([^\"]*)\" button$")
	public void admin_click_button(String publishButton) throws Throwable {
		Thread.sleep(2000);
		LABPage.get().PublishButton.click();
	}

	@Then("^Warning message should be displayed as \"([^\"]*)\" with \"([^\"]*)\" and \"([^\"]*)\" buttons$")
	public void warning_message_should_be_displayed_as_with_and_buttons(String warningMessage, String yesbutton,
			String nobutton) throws Throwable {
		Assert.assertTrue(warningMessage + " message is displaying",
				LABPage.get().PublishWarningMessage.getText().trim().contains(warningMessage));
		Assert.assertTrue(yesbutton + " button is displaying",
				WebDriverWrapper.getWebElementByXpath(String.format(LABPage.warningmesageXpath, yesbutton)).getText()
						.trim().contains(yesbutton));
		Assert.assertTrue(nobutton + " button is displaying",
				WebDriverWrapper.getWebElementByXpath(String.format(LABPage.warningmesageXpath, nobutton)).getText()
						.trim().contains(nobutton));
	}

	@When("^Admin click \"([^\"]*)\" on warning message$")
	public void admin_click_on_on_warning_message(String msgbuttons) throws Throwable {
		if (WebDriverWrapper.getWebElementByXpath(String.format(LABPage.warningmesageXpath, msgbuttons)).getText()
				.trim().contains(msgbuttons)) {
			WebDriverWrapper.getWebElementByXpath(String.format(LABPage.warningmesageXpath, msgbuttons)).click();
		}
		if (TestBaseWebDriver.browserType.equalsIgnoreCase(Browsers.CHROME.toString())) {
			String script = String.format("$(\"button:contains(%s)\").click()", msgbuttons);
			WebDriverWrapper.executeScript(script);
		}
	}

	@Then("^\"([^\"]*)\" activity should get displyed without publishing$")
	public void activity_should_get_displyed_without_publishing(String activity) throws Throwable {
		Assert.assertFalse(activity + " is not published",
				LABPage.get().ValidatePublish.getText().trim().contains("Unit"));
		WebDriverWrapper.waitForAjaxJQueryProcess();
	}

	@Then("^Below message should be displayed$")
	public void below_message_should_be_displayed(List<String> messages) throws Throwable {
		for (String message : messages)
			Assert.assertTrue(message + " is displyed", LABPage.get().saveMessage.getText().trim().contains(message));
	}

	@Then("^\"([^\"]*)\" activity should get displayed with published Activity-ID$")
	public void activity_should_get_displayed_with_published_Activity_ID(String activity, List<String> activityIds)
			throws Throwable {
		for (String activityId : activityIds) {
			Assert.assertTrue(activityId + " is displyed",
					LABPage.get().ValidatePublish.getText().trim().contains(activityId));
		}
	}
}