package com.webuitests.cuketests.CourseCatalogue;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.webuiframework.oua.uitests.utils.WaitToLoad;
import com.webuiframework.oua.uitests.utils.WebDriverWrapper;
import com.webuitests.base.TestBase;
import com.webuitests.pages.CourseCatalogue_CategoriesPage;
import com.webuitests.pages.CourseCatalogue_HomePage;
import com.webuitests.pages.CourseCatalogue_ProductsPage;
import com.webuitests.pages.CourseCatalogue_SettingsPage;
import com.webuitests.pages.LABPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CourseCatalogue extends TestBase {
	
	@When("^Admin click on \"([^\"]*)\" in the catalogue pane$")
	public void admin_click_on_in_the_catalogue_pane(String seetingslink) throws Throwable {
		WaitToLoad.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(CourseCatalogue_HomePage.get().seetingsXpath, seetingslink))));
		WaitToLoad.wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(CourseCatalogue_HomePage.homepageXpath)));
		WebDriverWrapper.getWebElementByXpath(String.format(CourseCatalogue_HomePage.get().seetingsXpath, seetingslink)).click();
	}

	@Then("^Settings Page should be displayed with the below field details$")
	public void settings_Page_should_be_displayed_with_the_below_field_details(Map<String,String> UIElements) throws Throwable {
		Assert.assertTrue("Seetings Page Header does not match with the expected",CourseCatalogue_SettingsPage.get().SettingsPageHeader.getText().contains(UIElements.get("Header")));
		Assert.assertTrue("Checkbox Header is not expected as expected",CourseCatalogue_SettingsPage.get().CourseCataloguecheckboxStatusHeader.getAttribute("label").contains(UIElements.get("Checkbox")));
		Assert.assertTrue("Save button is not displayed as expected",CourseCatalogue_SettingsPage.get().SaveSettings.getAttribute("value").equals(UIElements.get("button")));
	}

	@Then("^By default 'Turn Course Catalogue on/off' should be unchecked$")
	public void by_default_Turn_Course_Catalogue_on_off_should_be_unchecked() throws Throwable {
		Assert.assertFalse("Turn Course Catalogue is OFF", CourseCatalogue_SettingsPage.get().CatalogueDetailsSection.isExists());
	}
	
	@Then("^\"([^\"]*)\" check box should be \"([^\"]*)\"$")
	public void check_box_should_be(String checkBoxHeader, String statusofCheckbox) throws Throwable {
		if(checkBoxHeader.equals("Enable training points")){
		if(checkBoxHeader.contains(CourseCatalogue_ProductsPage.get().trainingPointHeader.getText())){
			Assert.assertFalse(CourseCatalogue_ProductsPage.get().pointType.isExists());
			Assert.assertFalse("Training Point Section is displayed",CourseCatalogue_ProductsPage.get().TrainingPointSection.isExists());
		}
		}
		else if(checkBoxHeader.equals("Enable training hours")){
			if(checkBoxHeader.contains(CourseCatalogue_ProductsPage.get().trainingHourHeader.getText())){
				Assert.assertFalse(CourseCatalogue_ProductsPage.get().numberofHours.isExists());
				Assert.assertFalse("Number of Hours Section is displayed",CourseCatalogue_ProductsPage.get().numberofHours.isExists());
			}
		}
		
	}
	
	@Then("^Below Enrolment Type should be displayed$")
	public void below_Enrolment_Type_should_be_displayed(List<String> enrollmentType) throws Throwable {
		for(String enroltype:enrollmentType ){
			enroltype.contains(CourseCatalogue_ProductsPage.get().enrolmenttype.getWebElement().getText());
		}
	}
	
	@When("^Admin Turn \"([^\"]*)\" Course catalogue option in settings Page$")
	public void admin_Turn_Course_catalogue_option_in_settings_Page(String CheckBoxAction) throws Throwable {
		if(CheckBoxAction.equals("ON") && !(CourseCatalogue_SettingsPage.get().CatalogueDetailsSection.isExists())){
			CourseCatalogue_SettingsPage.get().CourseCatalogueCheckBox.clickAction();
		}
		
	}

	@Then("^'Catalogue Details' field section should be displayed$")
	public void catalogue_Details_field_section_should_be_displayed() throws Throwable {
		WaitToLoad.wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(CourseCatalogue_SettingsPage.approvalTabLoaderXpath)));
		Assert.assertTrue("Catalogue Details is not displayed", CourseCatalogue_SettingsPage.get().CatalogueDetailsSection.isExists());
	}
	
	@When("^Admin enter below Fields in 'Catalogue Details' field section$")
	public void admin_enter_below_Fields_in_Catalogue_Details_field_section(Map<String,String> CatalogueDetails) throws Throwable {
		CourseCatalogue_SettingsPage.get().CatalogueTitle.setText(CatalogueDetails.get("Title"));
		CourseCatalogue_SettingsPage.get().CatalogueDescription.setText(CatalogueDetails.get("Description"));
	}

	@When("^Admin update 'Request Approval Details' section for below tab$")
	public void admin_update_Request_Approval_Details_section_for_below_tab(Map<String,String> requestApprovalDetails) throws Throwable {
	}

	@When("^Admin Set 'Reminder days' to \"([^\"]*)\"$")
	public void admin_Set_Reminder_days_to(String reminderDays) throws Throwable {
		CourseCatalogue_SettingsPage.get().ReminderDays.setText(reminderDays);
	    
	}

	@When("^Admin enter \"([^\"]*)\" for 'Type of training points' text box$")
	public void admin_enter_for_Type_of_training_points_text_box(String tariningPoint) throws Throwable {
	    CourseCatalogue_SettingsPage.get().TypeOfTrainingPoint.setText(tariningPoint);
	    CourseCatalogue_SettingsPage.get().AddTrainingPointType.click();
	}

	@Then("^\"([^\"]*)\" should be displayed in 'Current Types'$")
	public void should_be_displayed_in_Current_Types(String currentType) throws Throwable {
	    WaitToLoad.wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(CourseCatalogue_SettingsPage.approvalTabLoaderXpath)));
		Assert.assertEquals("Training Type is not selected", currentType.trim(), CourseCatalogue_SettingsPage.get().CurrentTrainingPointType.getWebElementByText(currentType).getText().trim()); 
	}

	@When("^Admin Click on 'Save' in Settings Page of Course Catalogue$")
	public void admin_Click_on_Save_in_Settings_Page_of_Course_Catalogue() throws Throwable {
		WaitToLoad.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CourseCatalogue_SettingsPage.SavebuttonXpath)));
		CourseCatalogue_SettingsPage.get().SaveSettings.click();
	}

	@Then("^\"([^\"]*)\" should be displayed as notofication$")
	public void should_be_displayed_as_notofication(String notificationMessage) throws Throwable {
		WaitToLoad.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CourseCatalogue_SettingsPage.notificationmessageXpath)));
		CourseCatalogue_SettingsPage.get().NotificationMessage.getText().contains(notificationMessage);
	}
	
	@When("^Admin click on add \"([^\"]*)\" in Catalogue page$")
	public void admin_click_on_add_in_Catalogue_page(String catalogueOption) throws Throwable {
	    WaitToLoad.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(CourseCatalogue_HomePage.addcategoriesorproductsXpath, catalogueOption.toLowerCase()))));
		if(catalogueOption.equals("Products")){
	    	WebDriverWrapper.getWebElementByXpath(String.format(CourseCatalogue_HomePage.addcategoriesorproductsXpath, catalogueOption.toLowerCase())).click();
	    }
	    if(catalogueOption.equals("Categories")){
	    	WebDriverWrapper.getWebElementByXpath(String.format(CourseCatalogue_HomePage.addcategoriesorproductsXpath, catalogueOption.toLowerCase())).click();
	    }
	}

	@Then("^Settings Page should be displayed$")
	public void settings_Page_should_be_displayed() throws Throwable {
		Assert.assertTrue("Seetings Page is not displayed", CourseCatalogue_SettingsPage.get().CourseCatalogueCheckBox.isExists());
	    
	}
	
	@Then("^Lab 'settings' page should be displayed$")
	public void lab_settings_page_should_be_displayed() throws Throwable {
		WaitToLoad.wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(LABPage.settingsPageHeaderXpath)));
		Assert.assertTrue(LABPage.get().SettingsPageHeader.isExists()); 
	}
	

	@When("^Admin Click on \"([^\"]*)\" in Lab$")
	public void admin_Click_on_in_Lab(String arg1) throws Throwable {
	   LABPage.get().TrainingPoint.click();
	}

	@Then("^'Training Points' page should displayed with exsting 'Training Point'$")
	public void training_Points_page_should_displayed_with_exsting_Training_Point() throws Throwable {
		WaitToLoad.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LABPage.trainigpointTableElementsXpath)));
	}

	@Then("^\"([^\"]*)\" should be displayed in 'Training Point' table$")
	public void should_be_displayed_in_Training_Point_table(String trainingPintType) throws Throwable {
		for(WebElement trainingPointtype:LABPage.get().TrainingTablePoint.getWebElements()){
			trainingPointtype.getAttribute("value").contains(trainingPintType);
		}
	}
	
	@When("^Admin Click on \"([^\"]*)\" in Training Point tab$")
	public void admin_Click_on_in_Training_Point_tab(String arg1) throws Throwable {
		WaitToLoad.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LABPage.addtrainingpointXpath)));
		LABPage.get().AddTrainigPoint.click();
	}

	@Then("^New text field should be displayed in 'Training Point' Table$")
	public void new_text_field_should_be_displayed_in_Training_Point_Table() throws Throwable {
	    WaitToLoad.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LABPage.newtrainingpointXpath)));
	    Assert.assertTrue(LABPage.get().NewTrainingPoint.isExists());
	}

	@When("^Admin enter 'Training Point Type' as \"([^\"]*)\"$")
	public void admin_enter_Training_Point_Type_as(String tariningPointType) throws Throwable {
	    LABPage.get().NewTrainingPoint.setText(tariningPointType);
	    LABPage.get().SearchTrainingPoint.click();
	}

	@Then("^\"([^\"]*)\" notification should be displayed with \"([^\"]*)\" training point in Training Point$")
	public void notification_should_be_displayed_with_training_point_in_Training_Point(String notificationMessage, String trainingType) throws Throwable {
		WaitToLoad.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LABPage.addedsucessfullynotificationMessageXpath)));
		Assert.assertEquals("Notification message displayed is not same as in application", notificationMessage, LABPage.get().NotificationMessage.getText());
		for(WebElement trainingPointtype:LABPage.get().TrainingTablePoint.getWebElements()){
			trainingPointtype.getAttribute("value").trim().contains(trainingType);
		}
	}
	
	@When("^Admin delete \"([^\"]*)\" Type of trainig point$")
	public void admin_delete_Type_of_trainig_point(String arg1) throws Throwable {
	    CourseCatalogue_SettingsPage.get().RemoveCurrentTrainingPoint.click();
	}

	@Then("^\"([^\"]*)\" should not be displayed in 'Current Types'$")
	public void should_not_be_displayed_in_Current_Types(String currentType) throws Throwable {
		Assert.assertEquals("Training Type is not selected", currentType.trim(), CourseCatalogue_SettingsPage.get().CurrentTrainingPointType.getWebElementByText(currentType).getText().trim());
	}
	
	@Then("^\"([^\"]*)\" Page should be displayed$")
	public void page_should_be_displayed(String pageHeader) throws Throwable {
		WebDriverWrapper.waitForElementPresent(By.xpath(CourseCatalogue_CategoriesPage.pageheaderXpath));
		Assert.assertEquals("The Page Header displayed is not expected", pageHeader, CourseCatalogue_CategoriesPage.get().PageHeader.getText().trim());
	}

	@Then("^Below sections should be displayed with the header$")
	public void below_sections_should_be_displayed_with_the_header(List<String> sections) throws Throwable {
	    for(String section:sections){
	    	CourseCatalogue_CategoriesPage.get().SectionHeaders.getWebElementByText(section).getText().equals(section);
	    }
	}

	@Then("^\"([^\"]*)\" button should be displayed$")
	public void button_should_be_displayed(String buttonName) throws Throwable {
		Assert.assertTrue("Button is not displayed Category Page", CourseCatalogue_CategoriesPage.get().Createnewcategory.getText().contains(buttonName));
	}

	@When("^Admin Click on \"([^\"]*)\" button in 'New Category Page'$")
	public void admin_Click_on_button_in_New_Category_Page(String arg1) throws Throwable {
		CourseCatalogue_CategoriesPage.get().Createnewcategory.click();
	}
	
	@Then("^Below sections should be displayed with the header in Products$")
	public void below_sections_should_be_displayed_with_the_header_in_Products(List<String> sections) throws Throwable {
		for(String section:sections){
			CourseCatalogue_ProductsPage.get().NewProductSections.getWebElementByText(section).getText().equals(section);
		}
	}	
	
	@When("^Admin Click on \"([^\"]*)\" button in 'New Product Page'$")
	public void admin_Click_on_button_in_New_Product_Page(String arg1) throws Throwable {
	    CourseCatalogue_ProductsPage.get().CreateNewProductButton.click();
	}

	@Then("^Mandatory message should be displayed as \"([^\"]*)\" for field 'Add a course to this product'$")
	public void mandatory_message_should_be_displayed_as_for_field_Add_a_course_to_this_product(String mandatoryMessage) throws Throwable {
		Assert.assertEquals(CourseCatalogue_ProductsPage.get().MandatoryMessage.getText(), mandatoryMessage); 
	}

}
