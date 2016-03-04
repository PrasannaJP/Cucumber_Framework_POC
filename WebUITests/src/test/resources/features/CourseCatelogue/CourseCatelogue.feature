@Course_Catalogue
Feature: Course Catalogue
  As admin,
  I want to create catalogue and products 
  So that student can able see in the portal to enrol

  @Default_Setting_for_Course_Catalog
  Scenario: Default_Setting_for_Course_Catalog
    Given Admin is viewing the Course Catalogue Page
    When Admin click on "Settings" in the catalogue pane
    Then Settings Page should be displayed with the below field details
      | field_type | field_name                   |
      | Header     | Catalogue: Settings          |
      | Checkbox   | Turn Course Catalogue on/off |
      | button     | Save                         |
    And By default 'Turn Course Catalogue on/off' should be unchecked

  @Adding_Products_and_Categories_on_turning_off_catalogue
  Scenario: Adding_Products_and_Categories_on_turning_off_catalogue
    Given Admin is viewing the Course Catalogue Page
    When Admin click on add "Products" in Catalogue page
    Then "You must enable the catalogue first" should be displayed as notofication
    Then Settings Page should be displayed
    And By default 'Turn Course Catalogue on/off' should be unchecked

  @Trun_ON_Course_Catalogue_Option
  Scenario: Trun_ON_Course_Catalogue_Option
    Given Admin is viewing "Settings" Page
    When Admin Turn "ON" Course catalogue option in settings Page
    Then 'Catalogue Details' field section should be displayed
    When Admin Click on 'Save' in Settings Page of Course Catalogue
    Then "Catalogue has been updated." should be displayed as notofication

  @Validating_New_Product_Controllers_Default_Settings
  Scenario: Validating_New_Product_Controllers_Default_Settings
    Given Admin is viewing "New_Product" Page
    Then "Enable training points" check box should be "OFF"
    And "Enable training hours" check box should be "OFF"
    And Below Enrolment Type should be displayed
      | Free              |
      | Requires Approval |

  @Adding_Catelog_Details
  Scenario: Adding_Catelog_Details
    Given Admin is viewing "Settings" Page
    When Admin enter below Fields in 'Catalogue Details' field section
      | Title       | Course Catalogue - Automation Testing |
      | Description | Course Catalogue - Automation Testing |
    And Admin update 'Request Approval Details' section for below tab
      | Add a User           | e3l-Testing          |
      | Add a Group and Role | Team India           |
      | Add a Group Role     | Admin                |
      | Add Direct Manager   | Team India - Manager |
    And Admin Set 'Reminder days' to "12"
    And Admin enter "E3LAuto" for 'Type of training points' text box
    Then "E3LAuto" should be displayed in 'Current Types'
    When Admin Click on 'Save' in Settings Page of Course Catalogue
    Then "Catalogue has been updated" should be displayed as notofication

  @Validate_Creation_of_Type_of_Training_point_In_Lab
  Scenario: Validate_Creation_of_Type_of_Training_point_In_Lab
    Given Admin is viewing Learn Force Activity Builder Page
    When Admin should navigate to "Settings" page
    Then Lab 'settings' page should be displayed
    When Admin Click on "Training Points" in Lab
    Then 'Training Points' page should displayed with exsting 'Training Point'
    Then "E3LAuto" should be displayed in 'Training Point' table

  @Add_Training_Point_Type_In_Lab
  Scenario: Add_Training_Point_Type_In_Lab
    Given Admin is viewing Learn Force Activity Builder Page
    When Admin should navigate to "Settings" page
    Then Lab 'settings' page should be displayed
    When Admin Click on "Training Points" in Lab
    Then 'Training Points' page should displayed with exsting 'Training Point'
    When Admin Click on "Add new training point type" in Training Point tab
    Then New text field should be displayed in 'Training Point' Table
    When Admin enter 'Training Point Type' as "E3Learn"
    Then "Saved successfully" notification should be displayed with "E3Learn" training point in Training Point

  @Validate_Training_Point_Type_In_Course_Catalogue
  Scenario: Validate_Training_Point_Type_In_Course_Catalogue
    Given Admin is viewing the Course Catalogue Page
    When Admin click on "Settings" in the catalogue pane
    Then "E3Learn" should be displayed in 'Current Types'

  @Validate_Delete_Training_Point_Type_In_Course_Catalogue
  Scenario: Validate_Delete_Training_Point_Type_In_Course_Catalogue_Not_In_Use
    Given Admin is viewing the Course Catalogue Page
    When Admin click on "Settings" in the catalogue pane
    And Admin delete "E3LAuto" Type of trainig point
    Then "E3LAuto" should not be displayed in 'Current Types'
    When Admin Click on 'Save' in Settings Page of Course Catalogue
    Then "Catalogue has been updated." should be displayed as notofication

  @Validating_Created_Course_Catelog_Details
  Scenario: Validating_Created_Course_Catelog_Details_in_Student_portal
    Given Student is viewing E3L portal
    Then "Course Catalogue- E3Learning" should be displayed as tab
    When Student click on "Course Catalogue- E3Learning" tab
    Then No 'Products' and 'Catagories' should be displayed

  @Validating_Course_Catalogue_UI
  Scenario: Validating_Course_Catalogue_UI
    Given Admin is viewing the Course Catalogue Page
    When Admin click on add "Categories" in Catalogue page
    Then "Catalogue: New Category" Page should be displayed
    Then Below sections should be displayed with the header
      | CATEGORY DETAILS |
      | PRODUCTS         |
    Then "Create new category" button should be displayed
    When Admin Click on "Create new category" button in 'New Category Page'
    Then "Your form is invalid please fix the errors and try again." should be displayed as notofication

  @Validating_New_Product_Page_UI
  Scenario: Validating_New_Product_Page_UI
    Given Admin is viewing the Course Catalogue Page
    When Admin click on add "Products" in Catalogue page
    Then "Catalogue: New Product" Page should be displayed
    Then Below sections should be displayed with the header in Products
      | COURSES                   |
      | PRODUCT DETAILS           |
      | CATEGORIES                |
      | GROUP RESTRICTIONS        |
      | PRODUCT ENROLMENT DETAILS |
    Then "Create new product" button should be displayed

  @Validating_mandatory_fields
  Scenario: Validating_mandatory_fields
    Given Admin is viewing the Course Catalogue Page
    When Admin click on add "Products" in Catalogue page
    When Admin Click on "Create new product" button in 'New Product Page'
    Then "Your form is invalid please fix the errors and try again." should be displayed as notofication
    And Mandatory message should be displayed as "You must add at least one course" for field 'Add a course to this product'

  @Add_Free_Product
  Scenario: Add_Free_Product
    Given Admin is viewing "Catalogue: New Product" Page
    When Select course "Selenium Training - Free" from 'Add a course to this product'
    And Enter field details in 'Product Details' section as specified below
      | Product title       | Selenium Introduction                 |
      | Product description | Introduction to Selenium Tool         |
      | Upload pic          | src/test/resources/TestData/avtar.jpg |
    And Turn on "Enable training points"
    And 'Select point' type as "E3LAuto"
    And Enter 'Number of points' to 30
    And Select "Team India" group from 'Add a group' drop down
    And Select "Free" enrolment type from 'Enrolment Type' drop down
    And Admin Click on "Create new product" button in 'New Product Page'
    Then "The Product Selenium Introduction is created!" should be displayed as notification
    Then 'Product status' should be displayed as "New" in 'Catalogue:Edit Product' Page
    And Information Message should be displayed as "Students won't be able to see this product until you publish it."
    And Below button should be displayed in 'Catalogue: Edit Product'
      | Update product     |
      | Update and publish |
      | Duplicate product  |
      | Delete product     |
    And "Selenium Introduction" should be displayed in 'Catalogue' pane under 'PRODUCTS'

  @Create_New_Category
  Scenario: Create_New_Category
    Given Admin viewing 'Catalogue: New Category' Page
    When Admin enter field details in 'CATEGORY DETAILS' section as specified below
      | Title       | Automation Testing                    |
      | Description | Course Catalogue - Automation Testing |
    When Admin select "Selenium Introduction" from 'Add a product' drop down
    Then "Selenium Introduction" should be displayed in 'Products'
    When Admin click on "Create new category" button
    Then "Category Selenium Introduction created!" message should be displayed in 'CATALOGUE' panel
    Then Below button should be displayed in 'Catalogue: Edit Category'
      | Update category |
      | Delete category |
    Then "Automation Testing" should be displayed in 'Catalogue' pane under 'CATEGORIES'

  @Update_Product_For_Catagory
  Scenario: Update_Product_For_Catagory
    Given Admin is viewing the Course Catalogue Page
    When Admin click on "Selenium Introduction" Category from "CATEGORIES" under 'PRODUCTS' pane
    And Select "Automation Testing" category from 'Add a category' drop down
    And Admin Click on "Update product" in 'Catalogue: Edit Product' Page
    And "Product Updated" should be displayed as notification
    Then "Automation Testing" should be displayed under 'Categories'

  @Validate_Student_portal
  Scenario: Validate_Student_portal_Without_Publish_Product
    Given Student is viewing E3L portal
    Then "Course Catalogue- E3Learning" should be displayed as tab
    When Student click on "Course Catalogue- E3Learning" tab
    Then Student should be viewing "All products" and "Automation Testing" as categories in left panel
    When Student click on "Automation Testing" category from left panel
    Then "Automation Testing" should be displayed as header
    Then Catalogue description should be displayed as "Course Catalogue - Automation Testing"
    Then 'Automation Testing' should be displayed as "This category is empty."

  @Publish_Product
  Scenario: Publish_Product
    Given Admin is viewing the Course Catalogue Page
    When Admin click on "Selenium Introduction" Category from "CATEGORIES" under 'PRODUCTS' pane
    And Admin Change Product Status to "Published" in 'Catalogue: Edit Product'
    Then Information Message should be displayed as "Students will be able to enrol into the product. A published product cannot be deleted and you cannot modify it's courses."
    And Below button should be displayed in 'Catalogue: Edit Product'
      | Update product     |
      | Update and publish |
      | Duplicate product  |
    When Admin Click on "Update and publish" in 'Catalogue: Edit Product' Page
    Then Browser warning message should be displayed "Are you sure you want to mark this product as published?" with "OK" and "Cancel" button
    When Admin Click on "OK" in Browser warning message
    And "Product Updated" should be displayed as notification
    And Below button should be displayed in 'Catalogue: Edit Product'
      | Update product    |
      | Duplicate product |

  @Validate_Student_portal
  Scenario: Validate_Student_portal
    Given Student is viewing E3L portal
    Then "Course Catalogue- E3Learning" should be displayed as tab
    When Student click on "Course Catalogue- E3Learning" tab
    Then Student should be viewing "All products" and "Automation Testing" as categories in left panel
    When Student click on "Automation Testing" category from left panel
    Then Student should view "Automation Testing" as header
    Then "Course Catalogue - Automation Testing" category description should be displayed above "Selenium Introduction" product name
    Then Product Type "FREE" and "Enrol now" buttons should be displayed
    Then Product name "Selenium Introduction" should be displayed with the product description as "Introduction to Selenium Tool"
    Then "Total Training points" should be displayed as 30

  @Add_Free_Product
  Scenario: Add_Product_Requires_Approval
    Given Admin is viewing "Catalogue: New Product" Page
    Then 'Product status' should be displayed as "New" in 'Catalogue:Edit Product' Page
    When Select course "Quick Test Preffesional - Approval to Enroll" from 'Add a course to this product'
    And Enter field details in 'Product Details' section as specified below
      | Product title       | Quick Test Preffesional                      |
      | Product description | Introduction to Quick Test Preffesional Tool |
      | Upload pic          | src/test/resources/TestData/avtar.jpg        |
    And Turn on "Enable training points"
    And 'Select point' type as "E3LAuto"
    And Enter 'Number of points' to 50
    And Turn on "Enable training hours"
    And Enter 'Number of hours' to 80
    And Select "Automation Testing" category from 'Add a category' drop down
    And Select "Team Ninja" group from 'ADD A GROUP AND ROLE' drop down
    And Select "Requires Approval" enrolment type from 'Enrolment Type' drop down
    Then 'REQUEST APPROVAL DETAILS' should display default aprover as ""
    When Admin Click on "Create new product" button in 'New Product Page'
    Then Information Message should be displayed as "Students won't be able to see this product until you publish it."
    And "Selenium Introduction" should be displayed in 'Catalogue' pane under 'PRODUCTS'

  @Update_Category
  Scenario: Update_Category
    Given Admin is viewing the Course Catalogue Page
    When Admin click on "Automation Testing" Category from "CATEGORIES" under 'Catalogue' pane
    Then 'Catalogue: Edit Category' page should be displayed
    When Admin select "Quick Test Preffesional" from 'Add a product' drop down
    Then "Quick Test Preffesional" should be displayed in 'Products'
    When Admin click on 'Update category' button
    Then "Product Updated" should be displayed as notification

  @Validate_Removal_of_Product_From_Category
  Scenario: Validate_Removal_of_Product_From_Category
    Given Admin is viewing the Course Catalogue Page
    When Admin click on "Automation Testing" Category from "CATEGORIES" under 'Catalogue' pane
    Then 'Catalogue: Edit Category' page should be displayed
    When Admin select "Bullying and Harassment for Managers and Supervisors (published)" from 'Add a product' drop down
    When Admin click on 'Update category' button
    Then "Bullying and Harassment for Managers and Supervisors (published)" should be displayed in 'Products'
    When Admin remove added product "Bullying and Harassment for Managers and Supervisors (published)" from 'Products'
    When Admin click on 'Update category' button
    Then Product "Bullying and Harassment for Managers and Supervisors (published)" should not be displayed under 'Products'

  @Validate_Portal_User_Diffrent_Group
  Scenario: Validate_Portal_User_Diffrent_Group
    Given Student is viewing E3L portal as diffrent 'group_user'
    When Student click on "Course Catalogue- E3Learning" tab
    Then Student should be viewing "All products" and "Automation Testing" as categories in left panel
    When Student click on "Automation Testing" category from left panel
    Then The Product "Quick Test Preffesional" should not be displayed under 'Automation Testing'

  @Validate_Product_display_in_Catalogue_Pane
  Scenario: Validate_Product_display_in_Catalogue_Pane
    Given Admin is viewing the Course Catalogue Page
    Then "Showing All Products" should be dsiplayed under 'Product' in 'Catalogue' pane by default
    And "Selenium Introduction" should be displayed under 'Products'
    And "Quick Test Proffesional" should be displayed under 'Products'
    When Select "New" from 'Product' filter in 'Catalogue' pane
    And "Quick Test Proffesional" should be displayed under 'Products'
    When Select "Published" from 'Product' filter in 'Catalogue' pane
    Then "Selenium Introduction" should not be displayed under 'Products'
    When Select "Archived" from 'Product' filter in 'Catalogue' pane
    Then No product should not be displayed under 'Products'

  @Publish_Product
  Scenario: Publish_Product_Requires_Approval
    Given Admin is viewing the Course Catalogue Page
    When Admin click on "Quick Test Proffesional" Category from "CATEGORIES" under 'PRODUCTS' pane
    And Admin Change Product Status to "Published" in 'Catalogue: Edit Product'
    Then Information Message should be displayed as "Students will be able to enrol into the product. A published product cannot be deleted and you cannot modify it's courses."
    And Below button should be displayed in 'Catalogue: Edit Product'
      | Update product     |
      | Update and publish |
      | Duplicate product  |
    When Admin Click on "Update and publish" in 'Catalogue: Edit Product' Page
    Then Browser warning message should be displayed "Are you sure you want to mark this product as published?" with "OK" and "Cancel" button
    When Admin Click on "OK" in warning message
    And "Product Updated" should be displayed as notification
    And Below button should be displayed in 'Catalogue: Edit Product'
      | Update product    |
      | Duplicate product |

  @Validate_Training_Type_In_Product
  Scenario: Validate_Training_Type_In_Product_
    Given Admin is viewing the Course Catalogue Page
    When Admin click on "Selenium Introduction" Category from "CATEGORIES" under 'PRODUCTS' pane
    Then "Type of Product" should be displayed as "Free"
    When Admin click on "Quick Test Proffesional" Category from "CATEGORIES" under 'PRODUCTS' pane
    Then "Type of Product" should be displayed as "requires approval"

  @Validate_Student_portal
  Scenario: Validate_Student_portal_For_Updated_Category
    Given Student is viewing E3L portal
    Then "Course Catalogue- E3Learning" should be displayed as tab
    When Student click on "Course Catalogue- E3Learning" tab
    Then Student should be viewing "All products" and "Automation Testing" as categories in left panel
    When Student click on "Automation Testing" category from left panel
    Then Below Products should be displayed in 'Automation Testing' category
      | Category Description                  | Product Name            |
      | Course Catalogue - Automation Testing | Selenium Introduction   |
      | Quick Test Preffesional               | Quick Test Preffesional |
    Then Product Type "FREE" and "Enrol now" buttons should be displayed for below Products
      | Selenium Introduction |
    Then Product Type "Requires Approval" and "Enrol now" buttons should be displayed for below Products
      | Quick Test Proffesional |
    Then Product name "Selenium Introduction" should be displayed with the product description as "Introduction to Selenium Tool"
    Then "Total Training points" should be displayed as 30
    And "Total training hours" should be displayed as 80

  @Delete_Published_Product
  Scenario: Delete_Published_Product
    Given Admin is viewing the Course Catalogue Page
    When Admin click on "Selenium Introduction" Category from "CATEGORIES" under 'PRODUCTS' pane
    Then 'Delete product' should not be displayed in 'Catalogue: Edit Product'

  @Duplicate_Product
  Scenario: Duplicate_Product
    Given Admin is viewing the Course Catalogue Page
    When Admin click on "Quick Test Proffesional" Category from "CATEGORIES" under 'PRODUCTS' pane
    And Admin click on "Duplicate product" button
    Then 'Course assigned to this product' should be displayed as "Quick Test Proffesional"
    And Below 'Product Details' should be displayed as below
      | Product Title       | (New) Quick Test Proffesional                |
      | Product Description | Introduction to Quick Test Preffesional Tool |
      | Product thumbnail   | blank                                        |
    And "Enable training points" should be "ON"
    And 'Select point type' should be displayed as "E3LAuto"
    And 'Number of points' should be displayed as 50
    And "Enable training hours" should be "ON"
    And "Number of hours" should be displayed as 80
    And "Automation Testing" should be displayed for 'Categories'
    And "Team Ninja" should be displayed under "Current Groups"
    And "Enrolment Type" should be displayed as "Free"
    When Admin Click on "Create new product" button in 'New Product Page'
    Then "The Product (New) Quick Test Proffesional is created!" should be displayed as notification
    Then 'Product status' should be displayed as "New" in 'Catalogue:Edit Product' Page
    And "(New) Quick Test Proffesional" should be displayed in 'Catalogue' pane under 'PRODUCTS'

  @Archived_Product
  Scenario: Archive_Published_Product
    Given Admin is viewing the Course Catalogue Page
    When Admin click on "Selenium Introduction" Category from "CATEGORIES" under 'PRODUCTS' pane
    And Admin Change Product Status to "Archived" in 'Catalogue: Edit Product'
    And Admin Click on "Update product" in 'Catalogue: Edit Product' Page
    Then "Product Updated" should be displayed as notification
    And "Automation Testing" should be displayed under 'Categories'

  @Validate_Archieved_Product_In_Student_Portal
  Scenario: Validate_Archieved_Product_In_Student_Portal
    Given Student is viewing E3L portal
    Then "Course Catalogue- E3Learning" should be displayed as tab
    When Student click on "Course Catalogue- E3Learning" tab
    And Student click on "Automation Testing" category from left panel
    Then "Selenium Introduction" product should not be displayed under 'Course Catalogue- E3Learning' tab

  @Validate_Product_display_in_Catalogue_Pane
  Scenario: Validate_Archived_Product_display_in_Catalogue_Pane
    Given Admin is viewing the Course Catalogue Page
    Then "Showing All Products" should be dsiplayed under 'Product' in 'Catalogue' pane by default
    When Select "Archived" from 'Product' filter in 'Catalogue' pane
    Then "Selenium Introduction" should not be displayed under 'Products'

  @Add_Request_Approval_Details
  Scenario: Validate_Request_Approval_Details
    Given Admin is viewing the Course Catalogue Page
    When Admin click on "Settings" in the catalogue pane
    And Select "Automation_User" group from 'ADD A USER' drop down
    And Select "Team Ninjas Plus Plus" group from 'ADD A GROUP AND ROLE' drop down
    Then Below Roles should be displayed in 'Settings' Page
      | Team Ninjas Plus Plus |
      | Automation_User       |
      | Team Ninja            |

  @Validate_Request_Approval_Details_In_Product
  Scenario: Validate_Request_Approval_Details_In_Product
    Given Admin is viewing the Course Catalogue Page
    When Admin click on "Quick Test Proffesional" Category from "CATEGORIES" under 'PRODUCTS' pane
    Then Below Roles should be displayed in 'Product' Page
      | Team Ninjas Plus Plus |
      | Automation_User       |
      | Team Ninja            |

  @Delete_Training_Point_In_Lab
  Scenario: Delete_Training_Point_In_Lab
    Given Admin is viewing Learn Force Activity Builder Page
    When Admin should navigate to 'Settings' page
    Then Lab 'settings' page should be displayed
    When Admin Click on "Training Points" in Lab
    And Admin Delete Training Point "E3Learn" in 'Lab' settings page
    Then Warning msaage should be displayed as "Are you sure you want to delete this?" with "OK" and "Cancel" button
    When Admin Click on "Yes" in setings page
    Then Error message should be displayed as "There was an error when deleting Training Point Type is in use"

  @Delete_Training_Point_Type_In_Course_Catalogue_Product_In_Use
  Scenario: Delete_Training_Point_Type_In_Course_Catalogue
    Given Admin viewing the course catalogue 'Settings' Page
    When Admin delete Training Point Type "E3Learn" settings page
    Then Admin should not be able to delete "E3Learn" Trainig Point Type in settings page

  @Delete_Category
  Scenario: Delete_Category
    Given Admin is viewing the Course Catalogue Page
    When Admin click on "Automation Testing" Category from "CATEGORIES" under 'Catalogue' pane
    Then 'Catalogue: Edit Category' page should be displayed
    When Admin click on "Delete category" in 'Catalogue: Edit Category' page
    Then Browser warning message should be displayed "Are you sure you want to delete 'Automation Testing'?" with "OK" and "Cancel" button
    When Admin Click on "OK" in Browser warning message
    Then "Automation Testing" should not be displayed in 'Catalogue' pane under 'CATEGORIES'

  @Validated_Deleted_Category_In_Portal
  Scenario: Validated_Deleted_Category_In_Portal
    Given Student is viewing E3L portal
    Then "Course Catalogue- E3Learning" should be displayed as tab
    When Student click on "Course Catalogue- E3Learning" tab
    Then "Automation Testing" should not be displayed in student portal
