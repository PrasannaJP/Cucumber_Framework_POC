@LAB
Feature: Learning Activity Builder
  As admin,
  I want to create activity 
  So that I can manage my course

  Background: 
    Given Admin is viewing LMS Page

  @navigatingtoadmin
  Scenario: Navigating to Activity Builder
    Then LMS Page should be displayed
    When Admin navigate to Activity Builder Page
    Then Learn Force Activity Builder Page should be displayed

  @validatingcreatingtestactivity
  Scenario: Create Activity UI Validation
    Given Admin is viewing Learn Force Activity Builder Page
    Then 'Create new activity' button should be displayed in LAB Page
    When Admin Click on 'Create new activity' button
    Then 'New Activity' should be displayed under 'Course Structure'
    When Admin named activity as "Test Activity" and save the details
    And Admin should navigate to "Dashboad" page
    Then "Test Activity" should be displayed under 'Latest Activities'

  @createactivity
  Scenario: Create Activity
    Given Admin is viewing Learn Force Activity Builder Page
    When Admin Click on "Test Activity" button
    When Admin added 'Topic' as a "Selenium Introduction"
    Then "Your changes were saved" should be display as notification on Save
    When Admin added 'Page' as "Welcome to Selenium"
    Then "Your changes were saved" should be displayed as notification on Save
    When Admin added 'video' URL as "https://www.youtube.com/watch?v=aOR6GNP_qYw"
    Then "Your changes were saved" message should be displayed as notification on Save
