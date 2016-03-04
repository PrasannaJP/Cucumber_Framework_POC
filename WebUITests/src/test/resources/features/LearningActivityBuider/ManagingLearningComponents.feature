@LearningActivityBuilder_Managing_Learning_Components
Feature: LearningActivityBuilder_Managing_Learning_Components
  	As admin,
  	I want to create activity with Topic/Page/Video/Assessment  
  	So I can assign created activities to user or groups

  @Validate_Add_Topic
  Scenario: Validate_Add_Topic
    Given Admin is viewing Learning Activity Builder "Dashboard"
    When Admin click on 'Create new activity' on 'Dashboard'
    Then "New Activity" should be displayed under 'Course Structure'
    When Admin enter activity name as "Test Complete"
    Then "Test Complete" should be displayed under 'Course Structure'
    When Admin click on "Change cover image" on 'New Activity' page
    Then Page should be displayed to browse file
    When Admin click on "browse for a file" to upload image
    When Admin Upload "TestComplete.jpeg" image for 'activity'
    Then Image should be displayed activity cover page
    When Admin add "Topic" as Learning component for activity
    And Admin enter "Topic" name as "General Information"
    Then "General Information" as 'Topic Name' should be displayed under 'Test Complete'
    When Admin Change Template to "Image Right" from top
    When Admin enter "Topic Description" from "General_Information.txt" file
    When Admin Click on 'Save' on new activity page
    Then "Your changes were saved" should be displayed as notification
    When Admin navigate to "Dashboard" from activity page
    Then "Test Complete" should be displayed in LAB dashboard page

  @Validate_Display_Topic_Options
  Scenario: Validate_Display_Topic_Options
    Given Admin open "Test Complete" activity from 'Latest Activity'
    When Admin open "OPTIONS" tab for the "General Information" "Topic"
    Then Below options should be displayed under "ADVANCED OPTIONS"
      | Options         | Default behavior |
      | Hide Navigation | OFF              |
      | Hide            | OFF              |
      | Hide Progress   | OFF              |

  @Validate_Topic_Option_Hide_Navigation_Turn_Off_In_Preview
  Scenario: Validate_Topic_Option_Hide_Navigation_Turn_Off_In_Preview
    Given Admin open "Test Complete" activity from 'Latest Activity'
    When Admin click on "preview the course" button for 'Test Complete' activity
    Then Course "Test Complete" should be displayed in preview mode
    And Below Options should be displayed preview mode for "Test Complete" activity
      | Course Name       | Test Complete           |
      | Topic Description | General_Information.txt |
      | Image             | TestComplete.jpeg       |
    And "Back to edit" button should be displayed in preview mode
    And "Previous" button should be displayed in preview mode
    And "Finish" button should be displayed in preview mode
    When Admin click on "Back To Edit" for 'Test Complete' course
    Then "Test Complete" course should be displayed in Edit mode

  @Validate_Topic_Options_Turn_On
  Scenario: Validate_Topic_Options_Turn_On
    Given Admin open "Test Complete" activity from 'Latest Activity'
    When Admin open "OPTIONS" tab for the "General Information" "Topic"
    And Admin "Turn ON" option "Hide Navigation" for 'General Information' Topic
    And Admin Click on "Save" on 'Test Complete' activity page
    Then "Your changes were saved" should be displayed as notification

  @Validate_Topic_Option_Hide_Navigation_Turn_On_In_Preview
  Scenario: Validate_Topic_Option_Hide_Navigation_Turn_On_In_Preview
    Given Admin open "Test Complete" activity from 'Latest Activity'
    When Admin click on "preview the course" button for 'Test Complete' activity
    Then Course "Test Complete" should be displayed in preview mode
    And Below Options should be displayed preview mode for "Test Complete" activity
      | Course Name       | Test Complete           |
      | Topic Description | General_Information.txt |
      | Image             | TestComplete.jpeg       |
    And "Back to edit" button should be displayed in preview mode
    And "Previous" button should not be displayed for 'Test Complete' Course
    And "Next" button should not be displayed for 'Test Complete' Course
    And "Finish" button should not be displayed for 'Test Complete' Course
    When Admin click on "Back to edit" for 'Test Complete' course
    Then "Test Complete" course should be displayed in Edit mode

  @Validate_Topic_Options_Hide_Turn_On
  Scenario: Validate_Topic_Options_Hide_Turn_On
    Given Admin open "Test Complete" activity from 'Latest Activity'
    When Admin open "OPTIONS" tab for the "General Information" "Topic"
    And Admin "Turn ON" option "Hide" for 'General Information' Topic
    And Admin Click on "Save" on 'Test Complete' activity page
    Then "Your changes were saved" should be displayed as notification

  @Validate_Topic_Option_Hide_Turn_ON_In_Preview
  Scenario: Validate_Topic_Option_Hide_Turn_ON_In_Preview
    Given Admin open "Test Complete" activity from 'Latest Activity'
    When Admin click on "preview the course" button for 'Test Complete' activity
    Then Course "Test Complete" should be displayed in preview mode
    And "General Information" topic should not be displayed in preview mode for 'Test Complete' activity
    And "Back to edit" button should not be displayed for 'Test Complete' Course
    And "Previous" button should not be displayed for 'Test Complete' Course
    And "Next" button should not be displayed for 'Test Complete' Course
    And "Finish" button should not be displayed for 'Test Complete' Course
    And "Back to edit" link should be displayed at the top of Course

  @Validate_Topic_Options_Hide_Turn_Off
  Scenario: Validate_Topic_Options_Hide_Turn_Off
    Given Admin open "Test Complete" activity from 'Latest Activity'
    When Admin open "OPTIONS" tab for the "General Information" "Topic"
    And Admin "Turn OFF" option "Hide" for 'General Information' Topic
    And Admin Click on "Save" on 'Test Complete' activity page
    Then "Your changes were saved" should be displayed as notification

  @Validate_Page_To_Topic
  Scenario: Validate_Page_To_Topic
    Given Admin open "Test Complete" activity from 'Latest Activity'
    When Admin select "Topic" name "General Information" from the Course Structure
    And Admin add "Page" as Learning component for activity
    And Admin enter 'Page' name as "About TestComplete"
    Then "About TestComplete" should be displayed under "General Information"
    When Admin click on "browse for a file" to upload image
    When Admin Upload "AboutTestComplete.jpeg" image for 'activity'
    Then Image should be displayed activity cover page
    When Admin enter "Page Description" from "About_TestComplete.txt" file
    And Admin Click on "Save" on 'Test Complete' activity page
    When Admin navigate to "Dashboard" from activity page
    Then "Test Complete" should be displayed in LAB dashboard page

  @Add_Multiple_Page_To_Topic
  Scenario: Add_Multiple_Page_To_Topic
    Given Admin open "Test Complete" activity from 'Latest Activity'
    And Admin add "Page" as Learning component for activity
    And Admin enter 'Page' name as "What's New in TestComplete 11.11"
    When Admin click on "browse for a file" to upload image
    When Admin Upload "AboutTestComplete.jpeg" image for 'activity'
    Then Image should be displayed activity cover page
    When Admin enter "Page Description" from "Whats_New.txt" file
    And Admin Click on "Save" on 'Test Complete' activity page
    Then "Your changes were saved" should be displayed as notification

  @Validate_Multiple_Page_In_Proview
  Scenario: Validate_Multiple_Page_In_Proview
    Given Admin open "Test Complete" activity from 'Latest Activity'
    When Admin selects "Activity Name" as "Test Complete" from activity edit page
    When Admin click on "preview the course" button for 'Test Complete' activity
    Then Course "Test Complete" should be displayed in preview mode
    Then Activity Page should be displayed with below fields
      | Activity Name   | Test Complete                    |
      | Status          | In Progress                      |
      | Button          | Begin Course                     |
      | Topic Name      | General Information              |
      | About Page      | About TestComplete               |
      | What's New Page | What's New in TestComplete 11.11 |

  @Validate_Acknowledgement_Text_And_Action_In_Proview_For_Page
  Scenario: Validate_Acknowledgement_Text_And_Action_In_Proview_For_Page
    Given Admin open "Test Complete" activity from 'Latest Activity'
    When Admin selects "Page" as "About TestComplete" from activity edit page
    When Admin open "EVENTS" tab for the "About TestComplete" "Page"
    Then "Completion Condition" should be selected as "The learning component has been viewed" by default
    When Admin select 'Completion Condition' to "Acknowledgement" for "About TestComplete" Page
    And Admin enter 'Acknowledgement text' as "Is Tool is exciting?"
    When Admin open "OPTIONS" tab for the "General Information" "Topic"
    And Admin "Turn OFF" option "Hide Navigation" for 'General Information' Topic
    When Admin selects "Activity Name" as "Test Complete" from activity edit page
    When Admin click on "preview the course" button for 'Test Complete' activity
    Then Course "Test Complete" should be displayed in preview mode
    When Admin Click on "Begin Course" from priview home page
    Then "General Information" "Topic" should be displayed in preview mode
    When Admin click on "Next" button
    Then "About TestComplete" page should be displayed in preview mode
    Then Check box should be displayed with text "Is Tool is exciting?"
    When Admin checks the check box for the 'About TestComplete' Page
    When Admin click on "Next" button
    Then "What's New in TestComplete 11.11" page should be displayed in preview mode
    When Admin click on "Finish" button
    Then "Test Complete" course should be displayed in Edit mode

  @Add_Video_To_Activity
  Scenario: Add_Video_To_Activity
    Given Admin open "Test Complete" activity from 'Latest Activity'
    When Admin add "Video" as Learning component for activity
    When Admin provide youtube URL as "https://www.youtube.com/watch?v=OmbA2S_wU-k" in edit mode
    And Admin Click on "Save" on 'Test Complete' activity page
    When Admin selects "Video" as "New Video" from activity edit page
    And Admin click on "preview the course" button for 'Test Complete' activity
    Then "New Video" "Video" should be displayed in preview mode

  @Validate_Assesment_And_Question_Type_For_Activity
  Scenario: Validate_Assesment_And_Question_Type_For_Activity
    Given Admin open "Test Complete" activity from 'Latest Activity'
    When Admin add "Assessment" as Learning component for activity
    Then "New Assessment" and "Question" should be added
    When Admin enter "Assessment" name as "Test Complete Assessment"
    Then Below tab should be displayed for the 'Assessment'
      | EDITING |
      | OPTIONS |
      | RESULTS |
      | EVENTS  |
    When Admin selects "Assessment" as "Question" from activity edit page
    Then Questions Type option should be displayed as below
      | Multiple Choice True/False |
      | Multiple Choice Single     |
      | Multiple Choice Multiple   |
    When Admin Click on "Save" on 'Test Complete' activity page

  @Add_Assessment_Type_Multiple_Choice_True_False
  Scenario: Add_Assessment_Type_Multiple_Choice_True_False
    Given Admin open "Test Complete" activity from 'Latest Activity'
    When Admin selects "Assessment" as "Question" from activity edit page
    And Admin enter question as "Test Complete is Functional Automation Tool?"
    And By default answer should be selected as "True"
    When Admin Click on "Save" on 'Test Complete' activity page
    Then "Your changes were saved" should be displayed as notification

  @Add_Multiple_Assessment_Type_Multiple_Choice_True_False
  Scenario: Add_Multiple_Assessment_Type_Multiple_Choice_True_False
    Given Admin open "Test Complete" activity from 'Latest Activity'
    When Admin selects "Assessment" as "Test Complete Assessment" from activity edit page
    When Admin add "Question" as Learning component for activity
    When Admin selects "Assessment" as "Question" from activity edit page
    And Admin enter question as "Test Complete is Performance Tool?"
    And Admin should select "False" as correct answer for 'Multiple Choice True/False'
    When Admin Click on "Save" on 'Test Complete' activity page
    Then "Your changes were saved" should be displayed as notification

  @Add_Assessment_Type_Multiple_Choice_Single
  Scenario: Add_Assessment_Type_Multiple_Choice_Single
    Given Admin open "Test Complete" activity from 'Latest Activity'
    When Admin selects "Assessment" as "Test Complete Assessment" from activity edit page
    When Admin add "Question" as Learning component for activity
    And Admin select 'Question Type' to "Multiple Choice Single"
    And Admin enter question as "Test Complete best suited for Testing Type?"
    And Admin enter below answer for "Multiple Choice Single"
      | Answer0 | Regression Testing    |
      | Answer1 | Accessibility Testing |
      | Answer2 | Reference Testing     |
      | Answer3 | None                  |
    And Admin should select "Regression Testing" as correct answer for 'Multiple Choice Single'
    And Admin Click on "Save" on 'Test Complete' activity page

  @Add_Assessment_Type_Multiple_Choice_Multiple
  Scenario: Add_Assessment_Type_Multiple_Choice_Multiple
    Given Admin open "Test Complete" activity from 'Latest Activity'
    When Admin selects "Assessment" as "Test Complete Assessment" from activity edit page
    When Admin add "Question" as Learning component for activity
    And Admin select 'Question Type' to "Multiple Choice Multiple"
    And Admin enter question as "Test Complete support Testing Type?"
    And Admin enter below answer for "Multiple Choice Multiple"
      | Answer0 | Regression Testing |
      | Answer1 | Functional Testing |
      | Answer2 | Coverage Testing   |
      | Answer3 | Database Testing   |
    And Admin should select "Regression Testing" as correct answer for 'Multiple Choice Single'
    And Admin should select "Functional Testing" as correct answer for 'Multiple Choice Single'
    And Admin Click on "Save" on 'Test Complete' activity page

  @Validate_Assessment_Correct_Answers_In_Preview
  Scenario: Validate_Assessment_Correct_Answers_In_Preview
    Given Admin open "Test Complete" activity from 'Latest Activity'
    When Admin selects "Assessment" as "Test Complete Assessment" from activity edit page
    When Admin open "OPTIONS" tab for the "Test Complete Assessment" "Assessment"
    When Admin sets "Question Display Ordering" field value to "In Order"
    When Admin click on "preview the course" button for 'Test Complete' activity
    When Admin navigate to "Assessment: Test Complete Assessment" section in preview
    When Admin sets answer "True" for the question "Test Complete is Functional Automation Tool?"
    And Admin click on "Submit Answer"
    Then Result should be displayed as "Correct"
    When Admin click on "Next" button
    When Admin sets answer "False" for the question "Test Complete is Performance Tool?"
    And Admin click on "Submit Answer"
    Then Result should be displayed as "Correct"
    When Admin click on "Next" button
    When Admin sets answer "Regression Testing" for the question "Test Complete best suited for Testing Type?"
    And Admin click on "Submit Answer"
    Then Result should be displayed as "correct"
    When Admin click on "Next" button
    When Admin sets answer "Regression Testing" for the question "Test Complete support Testing Type?"
    When Admin sets answer "Functional Testing" for the question "Test Complete support Testing Type?"
    And Admin click on "Submit Answer"
    Then Result should be displayed as "correct"
    When Admin click on "Next" button
    Then Assessment result should be displayed as "You passed with a score of 100%"
    And Below should be the results of the question for "Assessment: Test Complete Assessment"
      | Test Complete is Functional Automation Tool? | Correct |
      | Test Complete is Performance Tool?           | Correct |
      | Test Complete best suited for Testing Type?  | Correct |
      | Test Complete support Testing Type?          | Correct |
    And PASS percentage should be displayed as "PASS 80%"
    And "Finish" button should be displayed in preview mode
    And "Back to edit " button should be displayed in preview mode
    And "Previous" button should be displayed in preview mode
    When Admin click on "Back To Edit" for 'Test Complete' course
    Then "Test Complete" course should be displayed in Edit mode

  @Validate_Assessment_Incorrect_Answers_In_Preview
  Scenario: Validate_Assessment_Incorrect_Answers_In_Preview
    Given Admin open "Test Complete" activity from 'Latest Activity'
    When Admin select "Test Complete Assessment" displayed under 'Test Complete'
    And Admin click on "preview the course" button for 'Test Complete' activity
    Then Course "Test Complete" should be displayed in preview mode
    When Admin navigate to 'Assessment' section in preview
    When Admin sets answer "True" for the question "Test Complete is Functional Automation Tool?"
    And Admin click on "Submit Answer"
    Then Result should be displayed as "correct"
    Then Admin should be able to click on "Next" button
    When Admin sets answer "True" for the question "Test Complete is Performance Tool?"
    And Admin click on "Submit Answer"
    Then Result should be displayed as "incorrect"
    Then Admin should be able to click on "Next" button
    When Admin sets answer "Regression Testing" for the question "Test Complete best suited for Testing Type?"
    And Admin click on "Submit Answer"
    Then Result should be displayed as "correct"
    Then Admin should be able to click on "Next" button
    When Admin sets answer "Regression Testing" for the question "Test Complete support Testing Type?"
    And Admin click on "Submit Answer"
    Then Result should be displayed as "Incorrect"
    When Admin click on "Next" button
    Then Assessment result should be displayed as "You failed with a score of 50%"
    And Below should be the results of the question for "Assessment: Test Complete Assessment"
      | Test Complete is Functional Automation Tool? | Correct   |
      | Test Complete is Performance Tool?           | Incorrect |
      | Test Complete best suited for Testing Type?  | Correct   |
      | Test Complete support Testing Type?          | Incorrect |
    When Admin click on "Restart Assessment" from Assessment Summary Page
    Then "You did not pass the assessment, it has been restarted." should be displayed as notification
    When Admin navigate to 'Assessment' section in preview
    When Admin sets answer "True" for the question "Test Complete is Functional Automation Tool?"
    And Admin click on "Submit Answer"
    Then Result should be displayed as "correct"
    Then Admin should be able to click on "Next" button
    When Admin sets answer "False" for the question "Test Complete is Performance Tool?"
    And Admin click on "Submit Answer"
    Then Result should be displayed as "correct"
    Then Admin should be able to click on "Next" button
    When Admin sets answer "Regression Testing" for the question "Test Complete best suited for Testing Type?"
    And Admin click on "Submit Answer"
    Then Result should be displayed as "correct"
    Then Admin should be able to click on "Next" button
    When Admin sets answer "Regression Testing" for the question "Test Complete support Testing Type?"
    And Admin click on "Submit Answer"
    Then Result should be displayed as "Incorrect"
    When Admin click on "Next" button
    Then Assessment result should be displayed as "You failed with a score of 75%"
    And Below should be the results of the question for "Assessment: Test Complete Assessment"
      | Test Complete is Functional Automation Tool? | Correct   |
      | Test Complete is Performance Tool?           | Correct   |
      | Test Complete best suited for Testing Type?  | Correct   |
      | Test Complete support Testing Type?          | Incorrect |
    And Below devices option should be displayed 'Assessment Summary' Page
      | Desktop |
      | Mobile  |
      | Tablet  |

  @Duplicate_Questions_From_Assessment
  Scenario: Duplicate_Questions_From_Assessment
    Given Admin open "Test Complete" activity from 'Latest Activity'
    When Admin click "Duplicate" question "Test Complete is Functional Automation Tool?" from 'Course Structure'
    Then New Question should be added with the title "Copy of Test Complete is Functional Automation Tool?"
    And Answer should be selected "True" same as for question "Test Complete is Functional Automation Tool?"
    When Admin Click on 'Save' on new activity page

  @Delete_Questions_From_Assessment
  Scenario: Delete_Questions_From_Assessment
    Given Admin open "Test Complete" activity from 'Latest Activity'
    When Admin click "Delete" question "Test Complete is Performance Tool?" from 'Course Structure'
    When Admin click "Delete" question "Test Complete best suited for Testing Type?" from 'Course Structure'
    When Admin click "Delete" question "Copy of Test Complete is Functional Automation Tool?" from 'Course Structure'
    When Admin click "Delete" question "Test Complete support Testing Type?" from 'Course Structure'
    Then Below 1 question should be displayed under 'Test Complete Assessment'
      | Test Complete is Functional Automation Tool? |
    When Admin Click on 'Save' on new activity page

  @Validate_Assessment_Options_In_Preview
  Scenario: Validate_Assessment_Options_In_Preview
    Given Admin open "Test Complete" activity from 'Latest Activity'
    When Admin select "Test Complete Assessment" displayed under 'Test Complete'
    And Admin open "OPTIONS" tab for "Test Complete Assessment" Assessment
    And Admin modify 'Pass Score(%)' to 90
    And Restrict 'Number of Questions Asked' to 1
    And Admin Click on "Save" on 'Test Complete' activity page
    When Admin select "Test Complete Assessment" displayed under 'Test Complete'
    And Admin click on "preview the course" button for 'Test Complete' activity
    Then Assessment "Test Complete Assessment" should be displayed in preview mode
    When Admin navigate to 'Assessment' section in preview
    And Admin sets answer "True" for the question "Test Complete is Functional Automation Tool?"
    And Admin click on "Submit Answer"
    Then Result should be displayed as "correct"
    And Admin should be able to click on "Next" button
    Then Assessment result should be displayed as "You passed with a score of 100%"
    And PASS percentage should be displayed as 90%
    And Below 1 should be the results of the question for "Assessment: Test Complete Assessment"
      | Test Complete is Functional Automation Tool? | Correct |

  @Re_Add_Multiple_Assessment_Type_Multiple_Choice_True_False
  Scenario: Re_Add_Multiple_Assessment_Type_Multiple_Choice_True_False
    Given Admin open "Test Complete" activity from 'Latest Activity'
    When Admin selects "Assessment" as "Test Complete Assessment" from activity edit page
    When Admin add "Question" as Learning component for activity
    When Admin selects "Assessment" as "Question" from activity edit page
    And Admin enter question as "Test Complete is Performance Tool?"
    And Admin should select "False" as correct answer for 'Multiple Choice True/False'
    When Admin Click on "Save" on 'Test Complete' activity page
    Then "Your changes were saved" should be displayed as notification

  @Validate_Allow_Skip_Question
  Scenario: Validate_Allow_Skip_Question
    Given Admin is viewing "OPTIONS" tab for the "Test Complete Assessment" assessment
    When Restrict 'Number of Questions Asked' to 2
    And "Turn ON" the "Allow Skip Question" for 'Test Complete' activity
    And Admin Click on "Save" on 'Test Complete' activity page
    And Admin click on "preview the course" button for 'Test Complete' activity
    Then Assessment "Test Complete Assessment" should be displayed in preview mode
    When Admin navigate to 'Assessment' section in preview
    Then "Skip Question" link should be displayed next to "Submit Answer"
    When Admin click on "Skip Question" in assessment question
    And Next Assessment question "Test Complete is Performance Tool?" should be displayed

  @Validate_Cant_progress_untill_answered_correctly_In_preview
  Scenario: Validate_Cant_progress_untill_answered_correctly_In_preview
    Given Admin is viewing "OPTIONS" tab for the "Test Complete Assessment" assessment
    When "Turn OFF" the "Allow Skip Question" for 'Test Complete' activity
    And "Turn ON" the "Can't progress until answered correctly" checkbox for 'Test Complete' activity
    And Admin Click on "Save" on 'Test Complete' activity page
    And Admin click on "preview the course" button for 'Test Complete' activity
    Then Course 'Test Complete Assessment' should be displayed in preview mode
    And Admin should not be able to move to next question on clicking on "Next" button
    When Admin sets answer "False" for the question "Test Complete is Functional Automation Tool?"
    And Admin click on "Submit Answer"
    Then Result should be displayed as "Incorrect"
    And Admin should not be able to move to next question on clicking on "Next" button

  @Validate_Show_Result_Summary_Page_In_Preview
  Scenario: Validate_Show_Result_Summary_Page_In_Preview
    Given Admin is viewing "RESULTS" tab for the "Test Complete Assessment" assessment
    When Admin "Turn OFF" the option "Show Results Summary Page"
    And Admin open "OPTIONS" tab for "Test Complete Assessment" Assessment
    And "Turn OFF" the "Can't progress until answered correctly" checkbox for 'Test Complete' activity
    And Admin Click on "Save" on 'Test Complete' activity page
    And Admin click on "preview the course" button for 'Test Complete' activity
    Then Course 'Test Complete Assessment' should be displayed in preview mode
    And Admin should be able to move to next question on clicking on "Next" button
    When Admin sets answer "True" for the question "Test Complete is Functional Automation Tool?"
    And Admin click on "Submit Answer"
    Then Result should be displayed as "correct"
    Then Admin should be able to click on "Next" button
    When Admin sets answer "False" for the question "Test Complete is Performance Tool?"
    And Admin click on "Submit Answer"
    Then Result should be displayed as "correct"
    Then Admin should be able to click on "Next" button
    And Assessment Summary Page should not displayed for 'Test Complete' activity
    When Admin click on "Finish" button
    Then Activity should be displayed as 'Edit Mode'

  @Validate_Results_Tab_Options_In_Preview
  Scenario: Validate_Results_Tab_Options_In_Preview
    Given Admin is viewing "RESULTS" tab for the "Test Complete Assessment" assessment
    When Admin "Turn ON" the option "Show Results Summary Page"
    And Admin "Turn ON" the option "Show Result Summary After Each Question"
    And Admin "Turn ON" the option "Show Total Score"
    And Admin enter "Pass Text" as "Correct Answer for Question"
    And Admin enter "Fail Text" as "Incorrect Answer for Question"
    And Admin Click on "Save" on 'Test Complete' activity page
    And Admin click on "preview the course" button for 'Test Complete' activity
    Then Course 'Test Complete Assessment' should be displayed in preview mode
    Then Admin should be able to click on "Next" button
    When Admin sets answer "True" for the question "Test Complete is Functional Automation Tool?"
    And Admin click on "Submit Answer"
    Then Admin should be able to click on "Next" button
    When Admin sets answer "True" for the question "Test Complete is Performance Tool?"
    And Admin click on "Submit Answer"
    Then Admin should be able to click on "Next" button
    And "Incorrect Answer for Question" should be displayed in Assessment Summary Page
    When Admin click on "Restart Assessment" from Assessment Summary Page
    Then Admin should be able to click on "Next" button
    When Admin sets answer "True" for the question "Test Complete is Functional Automation Tool?"
    And Admin click on "Submit Answer"
    Then Admin should be able to click on "Next" button
    When Admin sets answer "False" for the question "Test Complete is Performance Tool?"
    And Admin click on "Submit Answer"
    Then Admin should be able to click on "Next" button
    And "Correct Answer for Question" should be displayed in Assessment Summary Page

  @Validate_Result_Summary_For_Each_Question
  Scenario: Validate_Result_Summary_For_Each_Question
    Given Admin is viewing "RESULTS" tab for the "Test Complete Assessment" assessment
    When Admin open "OPTIONS" tab for "Test Complete Assessment" Assessment
    And "Turn OFF" the "Can't progress until answered correctly" checkbox for 'Test Complete' activity
    And Admin click on "preview the course" button for 'Test Complete' activity
    Then Admin should be able to click on "Next" button
    When Admin sets answer "True" for the question "Test Complete is Functional Automation Tool?"
    And Admin click on "Submit Answer"
    Then Result should be displayed as "correct"
    Then Admin should be able to click on "Next" button
    When Admin sets answer "True" for the question "Test Complete is Performance Tool?"
    And Admin click on "Submit Answer"
    Then Result should be displayed as "incorrect"
    Then Admin should be able to click on "Next" button
    And Assessment Summary Page should be displayed for 'Test Complete' activity
    When Admin click on question "Test Complete is Functional Automation Tool?"
    Then Below options should be displayed for the question "Test Complete is Functional Automation Tool?"
      | Your Answers | Correct Answers |
      | True         | True            |
      | False        | False           |
    Then For the question "Test Complete is Functional Automation Tool?" should be marked as "correct"

  @Validate_Hide_Option_In_Preview
  Scenario: Validate_Hide_Option_In_Preview
    Given Admin is viewing "OPTIONS" tab for the "Test Complete Assessment" assessment
    When Admin "Turn ON" the option "Hide"
    And Admin Click on "Save" on 'Test Complete' activity page
    And Admin click on "preview the course" button for 'Test Complete' activity
    Then "Test Complete Assessment" should not be displayed in the Course main page in preview

  @Validate_Question_Display_Hide_In_Preview
  Scenario: Validate_Question_Display_Hide_In_Preview
    Given Admin is viewing "OPTIONS" tab for the "Test Complete Assessment" assessment
    When Admin "Turn OFF" the option "Hide"
    And Admin select "Hide" from "Question Display" drop down from "RESULTS" tab
    And Admin Click on "Save" on 'Test Complete' activity page
    And Admin click on "preview the course" button for 'Test Complete' activity
    Then Course 'Test Complete Assessment' should be displayed in preview mode
    Then Admin should be able to click on "Next" button
    When Admin sets answer "True" for the question "Test Complete is Functional Automation Tool?"
    And Admin click on "Submit Answer"
    Then Admin should be able to click on "Next" button
    When Admin sets answer "False" for the question "Test Complete is Performance Tool?"
    And Admin click on "Submit Answer"
    Then Admin should be able to click on "Next" button
    And Assessment Summary Page should be displayed without question results section

  @Validate_Question_Display_For_Correct_Answers_Only_In_Preview
  Scenario: Validate_Question_Display_For_Correct_Answers_Only_In_Preview
    Given Admin is viewing "RESULTS" tab for the "Test Complete Assessment" assessment
    When Admin select "Show correctly answered questions" from "Question Display" drop down from "RESULTS" tab
    And Admin Click on "Save" on 'Test Complete' activity page
    And Admin click on "preview the course" button for 'Test Complete' activity
    Then Course "Test Complete Assessment" should be displayed in preview mode
    Then Admin should be able to click on "Next" button
    When Admin sets answer "True" for the question "Test Complete is Functional Automation Tool?"
    And Admin click on "Submit Answer"
    Then Admin should be able to click on "Next" button
    When Admin sets answer "True" for the question "Test Complete is Performance Tool?"
    And Admin click on "Submit Answer"
    Then Admin should be able to click on "Next" button
    Then For the question "Test Complete is Functional Automation Tool?" should be marked as "correct"

  @Validate_Question_Display_For_Incorrect_Answers_Only_In_Preview
  Scenario: Validate_Question_Display_For_Incorrect_Answers_Only_In_Preview
    Given Admin is viewing "RESULTS" tab for the "Test Complete Assessment" assessment
    When Admin select "Show incorrectly answered questions" from "Question Display" drop down from "RESULTS" tab
    And Admin Click on "Save" on 'Test Complete' activity page
    And Admin click on "preview the course" button for 'Test Complete' activity
    Then Course "Test Complete Assessment" should be displayed in preview mode
    Then Admin should be able to click on "Next" button
    When Admin sets answer "True" for the question "Test Complete is Functional Automation Tool?"
    And Admin click on "Submit Answer"
    Then Admin should be able to click on "Next" button
    When Admin sets answer "True" for the question "Test Complete is Performance Tool?"
    And Admin click on "Submit Answer"
    Then Admin should be able to click on "Next" button
    Then For the question "Test Complete is Performance Tool?" should be marked as "incorrect"

  @Create_Question_In_Assessment
  Scenario: Create_Question_In_Assessment
    Given Admin open "Test Complete" activity from 'Latest Activity'
    When Admin selects "Assessment" as "Test Complete Assessment" from activity edit page
    When Admin add "Question" as Learning component for activity
    And Admin enter question as "Test Complete can be used for Database Testing?"
    And Admin should select "False" as correct answer for 'Multiple Choice True/False'
    And Admin Click on "Save" on 'Test Complete' activity page
    Then "Your changes were saved" should be displayed as notification

  @Validate_Questions_Display_Order_In_Preview
  Scenario: Validate_Questions_Display_Order_In_Preview
    Given Admin is viewing "RESULTS" tab for the "Test Complete Assessment" assessment
    When Admin select "Show all questions" from "Question Display" drop down from "RESULTS" tab
    When Admin select "In order asked" from "Question Display Order" drop down from "RESULTS" tab
    When Admin select "Random" from "Question Display Ordering" drop down from "OPTIONS" tab
    And Restrict 'Number of Questions Asked' to 3
    And Admin Click on "Save" on 'Test Complete' activity page
    When Admin click on "preview the course" button for 'Test Complete' activity
    Then Course "Test Complete Assessment" should be displayed in preview mode
    Then Admin should be able to click on "Next" button
    When Admin set answer to the question as "True"
    And Admin click on "Submit Answer"
    Then Admin should be able to click on "Next" button
    When Admin set answer to the question as "True"
    And Admin click on "Submit Answer"
    Then Admin should be able to click on "Next" button
    When Admin set answer to the question as "True"
    And Admin click on "Submit Answer"
    Then Admin should be able to click on "Next" button
    Then Questions should be displayed in random order not the same as below
      | Test Complete is Functional Automation Tool?    |
      | Test Complete is Performance Tool?              |
      | Test Complete can be used for Database Testing? |

  @Validate_Question_Display_Order_As_Assessment_In_Results_In_Preview
  Scenario: Validate_Question_Display_Order_As_Assessment_In_Results_In_Preview
    Given Admin is viewing "RESULTS" tab for the "Test Complete Assessment" assessment
    When Admin select "As defined in assessment" from "Question Display Order" drop down from "RESULTS" tab
    When Admin select "In Order" from "Question Display Ordering" drop down from "OPTIONS" tab
    And Admin Click on "Save" on 'Test Complete' activity page
    When Admin click on "preview the course" button for 'Test Complete' activity
    Then Course "Test Complete Assessment" should be displayed in preview mode
    Then Admin should be able to click on "Next" button
    When Admin set answer to the question as "True"
    And Admin click on "Submit Answer"
    Then Admin should be able to click on "Next" button
    When Admin set answer to the question as "True"
    And Admin click on "Submit Answer"
    Then Admin should be able to click on "Next" button
    When Admin set answer to the question as "True"
    And Admin click on "Submit Answer"
    Then Admin should be able to click on "Next" button
    And Below question order should same as question asked in assessment
      | Test Complete is Functional Automation Tool?    |
      | Test Complete is Performance Tool?              |
      | Test Complete can be used for Database Testing? |

  @Validate_Question_Display_Order_In_Results_In_Preview
  Scenario: Validate_Question_Display_Order_In_Results_In_Preview
    Given Admin is viewing "RESULTS" tab for the "Test Complete Assessment" assessment
    When Admin select "In order asked" from "Question Display Order" drop down from "RESULTS" tab
    When Admin select "Random" from "Question Display Ordering" drop down from "OPTIONS" tab
    And Admin Click on "Save" on 'Test Complete' activity page
    When Admin click on "preview the course" button for 'Test Complete' activity
    Then Course "Test Complete Assessment" should be displayed in preview mode
    Then Admin should be able to click on "Next" button
    When Admin set answer to the question as "True"
    And Admin click on "Submit Answer"
    Then Admin should be able to click on "Next" button
    When Admin set answer to the question as "True"
    And Admin click on "Submit Answer"
    Then Admin should be able to click on "Next" button
    When Admin set answer to the question as "True"
    And Admin click on "Submit Answer"
    Then Admin should be able to click on "Next" button
    Then Questions should be displayed in random order not the same as below
      | Test Complete is Functional Automation Tool?    |
      | Test Complete is Performance Tool?              |
      | Test Complete can be used for Database Testing? |
