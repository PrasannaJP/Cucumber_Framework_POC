@Admin_Assign_Course
Feature: Assign course to user in Admin page
  As admin,
  I want to work on Learnforce Management System 
  So that I can manage admin activities

  @navigatetogroupsandassignpermissions
  Scenario Outline: Navigate_to_Groups_and_assign_Permissions
    Given Admin is viewing Admin home Page
    When Admin click on "Global" group under 'Groups & Accounts'
    Then "Global" group should open with "Groups" and "Accounts" fields
    When Admin click on "Permissions" tab
    Then "Global: Permissions" page should display
    When Admin select 'Select a role' as "admin"
    And Admin select "<Permission Type>" and '<Course ID>'
    Then "Software Testing (100020)" with "assign" and "enrol" should display under 'Courses' with 'Course ID'

    Examples: 
      | Permission Type          | Course ID |
      | Can Assign/Unassign Unit | 100020    |
      | Enrolled in Unit         | 100020    |

  @addingCoursetoAdmin
  Scenario: Adding_Course_to_Admin
    Given Admin is viewing 'Global: Group Enrolled Courses' page
    When Admin click on "Srikanth Manne" account
    Then "Srikanth Manne (srikmann@e3): Course Enrolment" page should get displayed
    And "Software Testing (100020)" should display under 'Group Enrolled Courses'
    When Admin click on "Software Testing (100020)" under 'Group Enrolled Courses'
    Then Below component should be displayed in "Software Testing (100020)"
      | Objective  | Software Testing (13145) |
      | Started    |                          |
      | Completed  |                          |
      | Status     |                          |
      | Deadline   | Set date                 |
      | Auto Reset | Set date                 |
      | Actions    |                          |
    And "Inherited from" should display group name "Global"

  @resetCourse
  Scenario: Reset_Course
    Given Admin is viewing 'Srikanth Manne (srikmann@e3): Course Enrolment' page
    When Admin click on "Software Testing (100020)" under 'Group Enrolled Courses'
    And Admin click on "Reset" under 'Actions'
    Then Below components display in 'Reset Training Module' with "Reset" and "Cancel" buttons
      | Reset Training Module          |
      | Reset Software Testing (13145) |
      | Delete Quiz Attempts           |
      | Delete Course Data             |
      | Deadline Date                  |
    When Admin change date to "23/12/2015" and click on "Reset"
    Then Below component should be displayed in "Software Testing (100020)"
      | Objective  | Software Testing (13145) |
      | Started    |                          |
      | Completed  |                          |
      | Status     |                          |
      | Deadline   | 23/12/2015               |
      | Auto Reset | Set date                 |
      | Actions    |                          |
    And "Inherited from" should display group name "Global"

  @beforeStartpublishedActivity
  Scenario: Before_Start_Published_Activity
    Given Admin is viewing 'Srikanth Manne (srikmann@e3): Course Enrolment' page
    When Admin click on "Software Testing (13145)" under "Software Testing (100020)"
    Then Below details displayed for "Software Testing (13145)" activity
      | Completion History     |
      | Detailed Page Progress |
      | Quiz Attempts          |
    And By default "Completion History" selected
    When Admin click on "Completion History" tab
    Then Below details displayed for "Completion History"
      | Started   |
      | Completed |
      | Score     |
      | Actions   |
    When Admin click on "Detailed Page Progress" tab
    Then Below details displayed for "Detailed Page Progress"
      | Path      |
      | Started   |
      | Completed |
      | Score     |
    When Admin click on "Quiz Attempts" tab
    Then Below details displayed for "Quiz Attempts"
      | Id        |
      | Attempt   |
      | Started   |
      | Completed |
      | Score     |
      | Actions   |

  @navigatetogroupsandreassignpermissions
  Scenario Outline: Navigate_to_Groups_and_Reassign_Permissions
    Given Admin is viewing Admin home Page
    When Admin click on "Global" group under 'Groups & Accounts'
    Then "Global" group should open with "Groups" and "Accounts" fields
    When Admin click on "Permissions" tab
    Then "Global: Permissions" page should display
    When Admin select 'Select a role' as "admin"
    And Admin select "<Permission Type>" and '<Course ID>'
    Then "Law and Public Policy (100026)" with "assign" and "enrol" should display under 'Courses' with 'Course ID'

    Examples: 
      | Permission Type          | Course ID |
      | Can Assign/Unassign Unit | 100026    |
      | Enrolled in Unit         | 100026    |

  @removeCourse
  Scenario: Remove_Course
    Given Admin is viewing 'Global: Group Enrolled Courses' page
    When Admin click on Remove Course for "Law and Public Policy (100026)" in 'Course' under 'Courses available to Admin Role'
    Then "Remove Course" warning message should get displayed with "Remove" and "Cancel" buttons
    When Admin click on "Cancel" warning message
    Then "Law and Public Policy (100026)" should be displayed without any change
    When Admin click on Remove Course for "Law and Public Policy (100026)" in 'Add a course' under 'Assignable Learning Activities'
    And Admin click on "Remove" warning message
    Then "Law and Public Policy (100026)" should be removed in 'Add a course' under 'Assignable Learning Activities'

  @learnerMyTrainingsection
  Scenario: Learner_MyTraining_Section
    Given Learner is viewing "e3Learning" index page
    When Learner click on "My Training" tab
    Then Below course should be displayed in 'My Training' page
      | Software Testing |
    When Learner select one "Software Testing" course from 'My Training'
    Then "Software Testing" should display as course
    And Below component should display
      | Software Testing                                                                   | 0%                    |
      | In Progress                                                                        | Deadline  23 Dec 2015 |
      | Training Points                                                                    | 10                    |
      | Duration                                                                           | 6 hours               |
      | Course Summary                                                                     | Incomplete            |
      | Syllabus                                                                           | Incomplete            |
      | Introduction to Software Engineering                                               | Incomplete            |
      | software engineering Assessment                                                    | Incomplete            |
      | software engineering New Assessment by Charles Antony Richard Hoare (C.A.R. Hoare) | Incomplete            |

  @learnercourseCompletionwithdefaultLABEvents
  Scenario: Learner_Course_Completion_with_default_LAB_Events
    Given Learner is viewing "e3Learning" index page
    When Learner complete the "Test Activity" course
    Then Below component should display in "Test Activity" course
      | Test Activity       | 100%      |
      |                     | Completed |
      | Training Points     | 10        |
      | Duration            | 6 hours   |
      | Add Page            | Done      |
      | New Video           | Done      |
      | Add Test Assessment | Done      |
    And "Certificate Awarded!" with "Download" option displayed

  @askTutor
  Scenario: Ask_Tutor
    Given Learner is viewing "e3Learning" index page
    When Learner click on "Ask a Tutor"
    Then Below component should be displayed with "Submit Question" button
      | Your Email Address  | srikanth.manne@e3learnig.com.au |
      | Your Contact Number |                                 |
      | Your question       |                                 |
    When Learner enter 'Your Contact Number' as "1234567890"
    And 'Your question' as "Detailed explanation required on Course"
    And click on "Submit Question" button
    Then below text should display with "Your question has been submitted!" message
      | We will contact you with a response as soon as possible. Please allow up to 24 hours (1 business day) for a response. |

  @downloadCertificate
  Scenario: Download_Certificate
    Given Learner is viewing "e3Learning" index page
    When Learner click on "My Training" tab
    And Learner click on "Test Activity" course
    And Learner click on 'Download' button
    Then "Test_Activity_certificate.pdf" should download
    And Below details displayed in 'Test_Activity_certificate.pdf'
      | This is to certify that      | SRIKANTH MANNE   |
      | has successfully completed   | TEST ACTIVITY    |
      | This course was completed on | 23 NOVEMBER 2015 |

  @validateCoursecompletioninAdmin
  Scenario: Validate_Course_Completion_in_Admin
    Given Admin is viewing "Srikanth  Manne (srikmann@e3)" admin page
    When Admin click on "Test Activity (100018)" under 'Add Learning Activity'
    Then Below component should display in "Test Activity (100018)"
      | Objective  | Test Activity (13143)                     |
      | Started    | 23/11/2015 08:49:29                       |
      | Completed  | On 23/11/2015 08:57:50 with score of 100% |
      | Status     | Completed                                 |
      | Deadline   | Set date                                  |
      | Auto Reset | Set date                                  |
      | Actions    |                                           |
    And "Inherited from" should display group name "Global"

  @publishActivityHistory
  Scenario: Publish_Activity_History
    Given Admin is viewing "Srikanth  Manne (srikmann@e3)" admin page
    When Admin click on "Test Activity (13143)" under "Test Activity (100018)"
    Then Below details displayed
      | Completion History |
      | Quiz Attempts      |
    And By default "Completion History" selected
    When Admin click on "Completion History" tab
    Then Below history details displayed
      | Started   | 23/Nov/2015 08:49:29 |
      | Completed | 23/Nov/2015 08:57:50 |
      | Score     | 100%                 |
      | Actions   |                      |
    When Admin click on "Quiz Attempts" tab
    Then Below Attempts details should display
      | Id        | 200064               |
      | Attempt   | 1                    |
      | Started   | 23/Nov/2015 08:57:16 |
      | Completed | 23/Nov/2015 08:57:27 |
      | Score     | 66%                  |
      | Actions   | Delete Show          |
      | Id        | 200064               |
      | Attempt   | 2                    |
      | Started   | 23/Nov/2015 08:57:42 |
      | Completed | 23/Nov/2015 08:57:49 |
      | Score     | 100%                 |
      | Actions   | Delete Show          |

  @viewExtraQuizzes
  Scenario: View_Extra_Quizzes
    Given Admin is viewing "Srikanth  Manne (srikmann@e3)" admin page
    When Admin click on "View Extra Quizzes" under "Test Activity (100018)" activity
    Then Below details displayed in "Test Activity"
      | Path      |
      | Attempt   |
      | Started   |
      | Completed |
      | Score     |
      | Actions   |

  @validatingLABandMyTrainingscreen
  Scenario: Validating_LAB_and_My_Training_Screen
    Given Admin is viewing 'Learn Force Activity Builder' Page
    When Admin Click on "Test Activity" activity in LAB
    And Admin navigates to "OPTIONS" tab
    Then "Training Hours" field 'Hours' are "6" hours
    And "Training Points" are "10"
    When Learner is viewing 'e3Learning' index page
    And click on "Test Activity" course
    Then 'Training Points' should be "10"
    And 'Duration' should be "6 hours"

  @validateLABEventswithMyTraininglearningcomponentsCompleted
  Scenario: Validate_LAB_Events_with_My_Training_Learning_Components_Completed
    Given Admin is viewing 'Learn Force Activity Builder' Page
    When Admin Click on "Test Activity" activity in LAB
    And Admin navigates to "EVENTS" tab
    And 'Completion Condition' is "All learning components completed"
    And Admin Click on 'Save' on new activity page
    And Admin click "Publish" button
    And Admin click "Yes" on warning message
    And Learner is viewing 'e3Learning' index page
    And click on "Test Activity" course
     Then Below component should display in "Test Activity" course
      | Test Activity       | 100%       |
      |                     | Completed  |
      | Training Points     | 10         |
      | Duration            | 6 hours    |
      | Add Page            | Done       |
      | New Video           | Done       |
      | Add Test Assessment | Incomplete |

  @validateLABEventswithMyTrainingAssessmentsPassed
  Scenario: Validate_LAB_Events_with_My_Training_Assessments_Passed
    Given Admin is viewing 'Learn Force Activity Builder' Page
    When Admin Click on "Test Activity" activity in LAB
    And Admin navigates to "EVENTS" tab
    And 'Completion Condition' is "All assessments passed"
    And Admin Click on 'Save' on new activity page
    And Admin click "Publish" button
    And Admin click "Yes" on warning message
    And Learner is viewing 'e3Learning' index page
    And click on "Test Activity" course
     Then Below component should display in "Test Activity" course
      | Test Activity       | 100%       |
      |                     | Completed  |
      | Training Points     | 10         |
      | Duration            | 6 hours    |
      | Add Page            | Incomplete |
      | New Video           | Incomplete |
      | Add Test Assessment | Done       |
