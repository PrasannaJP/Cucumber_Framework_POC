Feature: LearningActivityBuilder_ManagingActivity_Templates
  As admin,
  I want to create/manage activities  
  So I can assign created activites to user or groups

  @Upload_Image_For_Activity
  Scenario: Upload_Image_For_Activity
    Given Admin is viewing "NEW ACTIVITY" page
    When Admin click on "Change cover image" on 'New Activity' page
    Then Page should be displayed to browse file
    When Admin click on "browse for a file" to upload image
    And Admin Upload "Automation.jpeg" image for 'activity'
    Then Image should be displayed activity cover page
    When Admin enter activity name as "QTP - Image"
    And Admin Click on 'Save' on new activity page
    Then "Your changes were saved" should be displayed as notification
    And Admin navigate to 'Dashboard' page
    Then "QTP - Image" activity should be displayed in 'History Log'
    Then "QTP - Image" activity should be displayed in 'Latest Activities'
    Then Image "Automation.jpeg" should be displayed for the activity "QTP - Image"

  @Remove_Image_For_Activity
  Scenario: Remove_Image_For_Activity
    Given Admin open "QTP - Image" activity from 'History Log'
    When Admin click on 'Context Menu' of "QTP - Image" activity
    Then Below action should be displayed as 'Context Menu' options
      | Edit   |
      | Delete |
    When Admin Click on 'Delete' from the 'Context Menu'
    Then Warning message should be displayed as "Are you sure to delete this cover image" with "YES" and "NO" button
    When Admin click on "Yes" on warning message
    Then Image should not be displayed as activity cover page
    When Admin Click on 'Save' on new activity page
    Then "Your changes were saved" should be displayed as notification
    And Admin navigate to 'Dashboard' page
    Then Image "Automation.jpeg" should not be displayed for the activity "QTP - Image"

  @Replace_Image_For_Activity
  Scenario: Replace_Image_For_Activity
    Given Admin open "QTP - Image" activity from 'Latest Activity'
    When Admin click on "Change cover image" on 'New Activity' page
    Then Page should be displayed to browse file
    When Admin click on "browse for a file" to upload image
    And Admin Upload "Automation.jpeg" image for 'activity'
    Then Image should be displayed activity cover page
    When Admin Click on 'Save' on new activity page
    Then "Your changes were saved" should be displayed as notification
    And Admin navigate to 'Dashboard' page
    Then Image "Automation.jpeg" should be displayed for the activity "QTP - Image"

  @Validate_Closing_Activity_without_Save
  Scenario: Validate_Closing_Activity_without_Save
    Given Admin open "QTP - Image" activity from 'Latest Activity'
    When Admin click on "Change cover image" on 'New Activity' page
    Then Page should be displayed to browse file
    When Admin click on "browse for a file" to upload image
    And Admin Uploads "QTP.jpeg" image for 'activity'
    Then Image should be displayed activity cover page
    When Admin change Activity Name to "Quick Test" from "QTP - Image"
    And Admin close activity without saving activity
    Then "QTP - Image" activity should be displayed in 'History Log'
    Then "QTP - Image" activity should be displayed in 'Latest Activities'
    Then Image "Automation.jpeg" should be displayed for the activity "QTP - Image"

  @Validate_Template_Headers_Only
  Scenario: Validate_Template_Headers_Only
    Given Admin open "QTP - Image" activity from 'Latest Activity'
    When Admin add "Topic" for activity 'QTP - Image'
    Then "New Topic" page should be displayed below activity name "QTP - Image"
    When Admin change topic name to "Welcome" for 'QTP - Image' activity
    Then By default Template should be displayed as "Header only"
    Then No image should be displayed for the Topic 'Welcome'
    When Admin Click on 'Save' on new activity page
    Then "Your changes were saved" should be displayed as notification
    When Admin Click on 'preview the course' for the topic
    Then Activity name should be displayed as "QTP - Image"
    And Topic "Welcome" should be displayed below activity name

  @Validate_Template_Image_Right
  Scenario: Validate_Template_Image_Right
    Given Admin open "QTP - Image" activity from 'Latest Activity'
    When Admin Change Template to "Image Right" from top
    Then 2 below sections should be displayed
      | Splash       |
      | Upload Image |
    When Admin Upload "QTP.jpeg" image for 'Topic'
    Then Image should be displayed in image section
    When Admin enter text as "Welcome to QTP World" in Text area
    And Admin Click on 'Save' on new activity page
    Then "Your changes were saved" should be displayed as notification
    When Admin Click on 'preview the course' for the topic
    Then Below component should be displayed
      | Topic Header | Welcome              |
      | Splash       | Welcome to QTP World |
      | Image        | QTP  - Right         |

  @Validate_Template_Image_Left
  Scenario: Validate_Template_Image_Left
    Given Admin open "QTP - Image" activity from 'Latest Activity'
    When Admin Change Template to "Image Left" from top
    When Admin Click on 'preview the course' for the topic
    Then Below component should be displayed
      | Topic Header | Welcome              |
      | Splash       | Welcome to QTP World |
      | Image        | QTP  - Left          |

  @Validate_Template_No_Image
  Scenario: Validate_Template_No_Image
    Given Admin open "QTP - Image" activity from 'Latest Activity'
    When Admin Change Template to "No Image" from top
    Then 1 section should be displayed as Description field
    When Admin Click on 'preview the course' for the topic
    Then Below component should be displayed
      | Topic Header | Welcome              |
      | Splash       | Welcome to QTP World |
      | Image        | No Image             |

  @Validate_Template_No_Splash_And_Only_Image
  Scenario: Validate_Template_No_Splash_And_Only_Image
    Given Admin open "QTP - Image" activity from 'Latest Activity'
    When Admin Change Template to "No Splash" from top
    And Admin Click on 'preview the course' for the topic
    Then Below component should be displayed
      | Topic Header | Welcome     |
      | Image        | QTP - Image |

  @Validate_Template_Two_Image_Only
  Scenario: Validate_Template_Two_Image_Only
    Given Admin open "QTP - Image" activity from 'Latest Activity'
    When Admin Change Template to "Two Images" from top
    Then 2 section should be displayed to upload image
    When Upload image "Automation_QTP.jpeg" for another section
    Then Images should be displayed for both the sections
    When Admin Click on 'preview the course' for the topic
    Then Below component should be displayed
      | Topic Header | Welcome        |
      | Image        | QTP - Image    |
      | Image        | Automation_QTP |
