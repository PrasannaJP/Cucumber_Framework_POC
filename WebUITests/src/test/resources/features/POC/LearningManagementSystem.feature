@LMS
Feature: Learning_Management_System
  As admin,
  I want to work on Learning Management System 
  So that I can manage admin activities

  @searchGroup
  Scenario: Search_Group
    Given Admin is viewing LMS Page
    Then LMS Page should be displayed
    Then Groups Panel should be displayed
    When Select Groups radio button
    And Enter Group Name as "Team Ninjas Plus Plus" to search
    And Click on Search Button
    Then "Team Ninjas Plus Plus" should be displayed as search results

  @SearchGroupInPanel
  Scenario: Search_Group_In_Panel
  Given Admin is viewing LMS Page
    Given Admin is viewing LMS "Dashboard"
    When Enter group name "Team Ninjas Plus Plus" in Filter Groups & Accounts placeholder
    Then "Team Ninjas Plus Plus" should be displayed as search results in Groups Panel

  @CreatenewGroup
  Scenario: Create New Group
  Given Admin is viewing LMS Page
    Given Admin is viewing LMS "Dashboard"
    When Admin click on Create New Group button
    Then "New Group Details" deatils page should be displayed
    When Below details should be entered as as part of group details
      | Group Details      | Value                                 |
      | Upload_group_photo | src/test/resources/TestData/avtar.jpg |
      | Group_Name         | Team India                            |
      | Description        | Team Banglore e3Learning              |
    Then All above group details should be saved
	Then "Team India" should be displayed in group panel
	
  @View_account_Details
  Scenario: View_Account_Details
  Given Admin is viewing LMS Page
    Given Admin is viewing LMS "Dashboard"
    When Admin click on "View your account details" link
    Then Account Details Page should be displayed with the below Tabs
      | Tabs                |
      | EDIT                |
      | GROUPS              |
      | PERMISSIONS         |
      | FLAGS               |
      | ACTIVITY            |
      | LEARNING ACTIVITIES |
      | EXTERNAL TRAINING   |
      | TRANSCRIPT          |
      | CLASSROOM TRAINING  |
    Then "LEARNING ACTIVITIES" tab should be "selected" by default

  @set_permission_for_reports
  Scenario: Set_Permission_for_reports
  Given Admin is viewing LMS Page
    Given Admin is viewing LMS "Dashboard"
    When Admin click on "View your account details" link
    And Admin Click on "PERMISSIONS" tab in group details page
    Then Below Permission container should be displayed
      | GLOBAL ADMIN               |
      | LEARNING MANAGEMENT SYSTEM |
      | XXXXXXX                    |
      | REPORTING                  |
      | COURSE CATALOGUE           |
      | LEARNING ACTIVITY BUILDER  |
    When Click on "Hide Modules" for "Reporting" container in Permission tab
    Then Reporting button should be displayed to provide permission
    When Provide 'REPORTING' permisssion for logged in user
    Then Reporting permission should be provided for the logged in user

  @enroll_activity
  Scenario: Enrolling_Learning_Activities
  Given Admin is viewing LMS Page
    Given Admin is viewing LMS "Dashboard"
    When Admin click on "View your account details" link
    And Admin Click on "LEARNING ACTIVITIES" tab in group details page
    And Admin click on "ADD LEARNING ACTIVITY" in 'Learning Activity' Tab
    And Admin Enroll course "activity admin"
    Then Enroled "activity admin" course should be displayed

  @Delete_enrolled_course
  Scenario: Delete_Enrolled_Course
  Given Admin is viewing LMS Page
    Given Admin is viewing LMS "Dashboard"
    When Admin click on "View your account details" link
    And Admin Click on "LEARNING ACTIVITIES" tab in group details page
    And Admin Delete "activity admin" enrolled course
    Then Confirmation window should be displayed with message "Are you sure you want to remove activity admin(10185)"
    When Admin Click on "OK" on confirmation window
    Then Enrolled Course "activity admin" should not be displayed
