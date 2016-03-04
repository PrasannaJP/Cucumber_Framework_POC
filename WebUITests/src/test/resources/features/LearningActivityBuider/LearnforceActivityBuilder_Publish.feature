@LAB_Publish
Feature: LearnforceActivityBuilder_Publish
  As admin,
  I want to publish Learnforce Activity Builder course 
  So I can assign course to user or groups

  Background: 
    Given Admin is viewing Learning Activity Builder "Dashboard"
    And Admin click on "Selenium" Activity which 'activity-status' is "In Development"

  @publishActivityfromInDevelopmentStatus
  Scenario: Publish_Activity_From_In_Development_Status
    When Admin click "Publish" button
    Then Warning message should be displayed as "Are you sure you want to publish this activity?" with "Yes" and "No" buttons
    When Admin click "No" on warning message
    Then "Selenium" activity should get displyed without publishing
    When Admin click "Publish" button
    And Admin click "Yes" on warning message
    Then Below message should be displayed
      | Course has been published |
    And "Selenium" activity should get displayed with published Activity-ID
      | Unit #100019 |