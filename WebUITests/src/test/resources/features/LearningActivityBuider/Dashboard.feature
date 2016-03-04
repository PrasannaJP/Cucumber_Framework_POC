@Learning_Activity_Builder_Dashboard
Feature: LearningActivityBuilder_DashBoard
  As admin,
  I validate Learning Activity Builder Dashboard 
  So validate Dash Board functionality

  Background: 
    Given Admin is viewing Learning Activity Builder "Dashboard"

  @Validate_Section_Of_Dash_Board
  Scenario: Validate_Section_Of_Dash_Board
    Then Below Sections should be displayed
      | History Log       |
      | Latest Activities |
      | Tutorials         |

  @Validate_Activities_In_Grid
  Scenario: Validate_Activities_In_Grid
    Then All Activities should be displayed as Grid by default
    When Admin click on "List view" on Dashboard
    Then All activities should be displayed as 'List'

  @Sorting_Activites_In_DashBoard
  Scenario: Sorting_Activites_In_DashBoard
    Then By Default 'Sort by' should be displayed as "modified"
    Then Activities should be displayed depend on "modified date" as below
      | Quick Test Professional |
      | Quick Test              |
      | Selenium                |
      | SOAP_UI                 |
      | JMeter                  |
    When Admin selects 'sort by' to "activity id" on 'Dashboard'
    Then Activities should be displayed depend on "activity id" as below
      | JMeter                  |
      | SOAP_UI                 |
      | Selenium                |
      | Quick Test              |
      | Quick Test Professional |
    When Admin selects 'sort by' to "title" on 'Dashboard'
    Then Activities should be displayed depend on "title" as below
      | JMeter                  |
      | Quick Test              |
      | Quick Test Professional |
      | Selenium                |
      | SOAP_UI                 |
    When Admin selects 'sort by' to "description" on 'Dashboard'
    Then Activities should be displayed depend on "description" as below
      | Quick Test              |
      | Selenium                |
      | SOAP_UI                 |
      | JMeter                  |
      | Quick Test Professional |
    When Admin selects 'sort by' to "modified" on 'Dashboard'

  @Validating_Activity_Details
  Scenario: Validating_Activity_Details
    Then Below activity details should be displayed for activity "Quick Test Professional"
      | Learning activity title | Quick Test Professional                            |
      | Learning activity ID    | #100018                                            |
      | Development status      | Live                                               |
      | Activity type           | Automation                                         |
      | Description             | Quick Test Professional functional automation tool |

  @Validate_Summary_panel_For_Activity
  Scenario: Validate_Summary_panel_For_Activity
    When Admin select "JMeter" activity from 'Dashboard' displayed in "Grid View"
    Then 'Summary panel' should be displayed for selected activity
    Then summary panel should be displayed with the below details "Grid View"
      | DESCRIPTION               | Performance Testing Tool      |
      | CATEGORY                  | Automation                    |
      | PROVIDER                  | Open Source Code Management   |
      | TRAINING DURATION         | 30                            |
      | Certificate of completion | Yes                           |
      | LAST LOG ENTRY            | Published by Prasanna Purohit |
    When Admin click on "List view" on Dashboard
    When Admin select "JMeter" activity from 'Dashboard' displayed in "List View"
    Then summary panel should be displayed with the below details "List View"
      | DESCRIPTION               | Performance Testing Tool      |
      | CATEGORY                  | Automation                    |
      | PROVIDER                  | Open Source Code Management   |
      | TRAINING DURATION         | 30                            |
      | Certificate of completion | Yes                           |
      | LAST LOG ENTRY            | Published by Prasanna Purohit |

  @Validate_Tutorials_section
  Scenario Outline: Validate_Tutorials_section
    Then Below tutorials should be displayed at the bottom section
      | Getting Started       |
      | The Dashboard         |
      | Managing activities   |
      | Managing components   |
      | Publishing activities |
      | Previewing activities |
      | Assigning activities  |
      | Settings              |
    When Admin click on '<link>' on 'Dashboard' for vedio Tutorials
    Then Tab should be displayed with '<tlitle>'

    Examples: 
      | link                  | title                                                   |
      | Getting Started       | KnowledgeBase - Getting Started                         |
      | The Dashboard         | KnowledgeBase - Touring the Dashboard                   |
      | Managing activities   | KnowledgeBase - Creating and managing learning activity |
      | Managing components   | KnowledgeBase - Adding and Managing learning components |
      | Publishing activities | KnowledgeBase - Publishing a learning activity          |
      | Previewing activities | KnowledgeBase - Previewing a learning activity          |
      | Assigning activities  | KnowledgeBase - Assigning a learning activity           |
      | Settings              | KnowledgeBase - Settings                                |

  @Validate_Dashboard_Menu
  Scenario: Validate_Dashboard_Menu
    Then below menu options should be displayed
      | Menu         |
      | Tools        |
      | Product Menu |

  #Defect: Duplicate Menu options are displaying
  @Validate_Menu_Option_On_Dashboard
  Scenario Outline: Validate_Menu_Option_On_Dashboard
    When Admin click on "Menu" option on 'Dashboard'
    Then Below option should be displayed as part of 'Menu' option
      | Dashboard      |
      | Settings       |
      | Help & Support |
      | Logout         |
    When Admin click on '<Option>' displayed on 'Menu'
    Then Admin should be viewing page with '<title>'

    Examples: 
      | Option         | title           |
      | Dashboard      | Dashboard       |
      | Settings       | Classifications |
      | Help & Support | KnowledgeBase   |
      | Logout         | Sign-In         |

  #Defect: Search results are not displaying using unitID
  @Smoke_Test_Priority_1 @Search_Activity_By_Title
  Scenario: Search_Activity_By_Title
    Then Admin should be displayed as "enter search term" as placeholder in search box
    When Admin enter activity 'Title' "JMeter" in 'Search'
    Then Search results should be displayed with header "1 result found" for activity "JMeter"
    Then 1 activity should be displayed with below details
      | TITILE | TYPE       |
      | JMeter | Automation |
    When Admin enter activity 'Title' "Quick Test Professional" in 'Search'
    Then Search results should be displayed with header "1 result found" for activity "Quick Test Professional"
    Then 1 activity should be displayed with below details
      | TITILE                  | TYPE       |
      | Quick Test Professional | Automation |
    When Admin enter activity 'Title' "Quick" in 'Search'
    Then Search results should be displayed with header "2 results found" for activity "Quick"
    Then 2 activity should be displayed with below details
      | TITILE                  | TYPE       |
      | Quick Test Professional | Automation |
      | Quick Test              | Automation |
    When Admin enter activity 'Unit Id' "#100017" in 'Search'
    Then Search results should be displayed with header "1 result found" for activity "Quick Test Professional"
    Then 1 activity should be displayed with below details
      | TITILE                  | TYPE       |
      | Quick Test Professional | Automation |

  @Smoke_Test_Priority_1 @Sorting_Search_Results
  Scenario: Sorting_Search_Results
    When Admin enter activity 'Title' "Quick" in 'Search'
    Then Search results should be displayed with header "2 results found" for activity "Quick"
    Then By Default 'Sort by' should be displayed as "modified"
    Then Activities should be displayed depend on "modified date" as below
      | Quick Test Professional |
      | Quick Test              |
    When Admin selects 'sort by' to "activity id" on 'Dashboard'
    Then Activities should be displayed depend on "activity id" as below
      | Quick Test              |
      | Quick Test Professional |
    When Admin selects 'sort by' to "title" on 'Dashboard'
    Then Activities should be displayed depend on "title" as below
      | Quick Test              |
      | Quick Test Professional |
    When Admin selects 'sort by' to "description" on 'Dashboard'
    Then Activities should be displayed depend on "description" as below
      | Quick Test              |
      | Quick Test Professional |

  @Validate_Opening_Activity_from_Diffrent_Panel
  Scenario: Validate_Opening_Activity_from_Diffrent_Panel
    When Admin Open "Quick Test Professional" activity from 'History Log'
    Then "Quick Test Professional" activity should be displayed
    When Admin navigate to "Dashboard" from activity page
    When Admin Open "JMeter" activity from 'Activity panel'
    Then "JMeter" activity should be displayed

  @Validate_Context_Menu_Options_Activity_Panel
  Scenario: Validate_Context_Menu_Options_Activity_Panel
    When Admin select context menu of "In Development" activity "Quick Test" displayed on 'Dashboard' from "Activity Panel"
    Then Below option should be displayed for "In Development" for "Quick Test" activity in "Grid" view
      | Edit    |
      | Preview |
      | Delete  |
    When Admin select context menu of "Live" activity "Quick Test Professional" displayed on 'Dashboard' from "Activity Panel"
    Then Below option should be displayed for "In Development" for "Quick Test Professional" activity in "Grid" view
      | Edit    |
      | Preview |

  @Validate_Context_Menu_Options_Summary_Panel
  Scenario: Validate_Context_Menu_Options_Activity_Panel
    When Admin select context menu of "New" activity "Quick Test" displayed on 'Dashboard' from "Summary Panel"
    Then Below option should be displayed for "In Development" for "Quick Test" activity in "Summary" view
      | Edit    |
      | Preview |
      | Delete  |
    When Admin select context menu of "In Development" activity "Quick Test Professional" displayed on 'Dashboard' from "Summary Panel"
    Then Below option should be displayed for "In Development" for "Quick Test Professional" activity in "Summary" view
      | Edit    |
      | Preview |

  @Smoke_Test_Priority_1 @Validate_Create_New_Activity_UI
  Scenario: Validate_Create_New_Activity_UI
    Then "Create new activity" button should be displayed on 'Dashboard' page
    When Admin click on 'Create new activity' on 'Dashboard'
    Then "NEW ACTIVITY" page should be displayed with the below buttons
      | Save    |
      | Publish |
    Then information message should be displayed as "New Activity was added a few seconds ago"
    Then Below tab should be displayed in 'NEW ACTIVITY' page
      | EDITING |
      | OPTIONS |
      | EVENTS  |
    Then Below buttons should be displayed for 'NEW ACTIVITY'
      | Add                |
      | expand or minimise |
      | preview the course |
    When Admin click on "Add Component" for 'NEW ACTIVITY'
    Then Below component should be displayed in 'NEW ACTIVITY' page
      | Topic      |
      | Page       |
      | Video      |
      | Assessment |
      | Question   |
      | Classroom  |
      | Session    |
      | Scorm      |
    When Admin click on 'Close' for new activity
    Then "Dashboard" page should be displayed
    Then History Log should be recored as "New Activity was created by Prasanna Purohit a few seconds ago" for activity "New Activity"

  @Editing_Activity_From_Context_Menu
  Scenario: Editing_Activity_From_Context_Menu
    When Admin select context menu of "In Development" activity "New Activity" displayed on 'Dashboard' from "Activity Panel"
    When Admin "Edit" from context menu of "New Activity" activity displayed
    Then "New Activity" activity should be opened
    When Admin add "Topic" as Learning component for activity
    And Admin "Save" activity
    When Admin navigate to "Dashboard" from activity page
    Then History Log should be recored as "New Activity was modified by Prasanna Purohit a few seconds ago" for activity "New Activity"

  @Preview_Activity_From_Context_Menu
  Scenario: Preview_Activity_From_Context_Menu
    When Admin select context menu of "In Development" activity "New Activity" displayed on 'Dashboard' from "Activity Panel"
    When Admin "Preview" from context menu of "New Activity" activity displayed
    Then Activity "New Activity" should be displayed in preview mode

  @Delete_Activity_From_Context_Menu
  Scenario: Delete_Activity_From_Context_Menu
    When Admin select context menu of "In Development" activity "New Activity" displayed on 'Dashboard' from "Activity Panel"
    When Admin "Delete" from context menu of "New Activity" activity displayed
    Then warning message should be displayed as "Are you sure you want to delete this activity?" with "Yes" and "No" button
    When Admin click on "Yes" button on warning message
    Then "New Activity" should not be displayed on 'Dashboard'
    Then History Log should be recored as "New Activity was deleted by Prasanna Purohit a few seconds ago" for activity "New Activity"

  @Unlocking_Activity
  Scenario: Validating_Unlocking_Activity
    When Admin "Logout" from application
    And Admin login as different global admin user
    When Admin select context menu of "Live" activity "JMeter" displayed on 'Dashboard' from "Activity Panel"
    When Admin "Edit" from context menu of "JMeter" activity displayed
    Then warning message should be displayed as "This activity is locked by Prasanna Purohit, do you want to send an unlock request? " with "Yes" and "No" button
    When Admin click on "No" button on warning message
