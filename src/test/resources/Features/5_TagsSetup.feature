@SetUp
Feature:Tags Setup

  @SetUp
  Scenario Outline: User navigates to Tags Setup page and add a new Tag
    Given User landed on Ignyte App
    When User logged in with valid Email <Email> and Password <Password>
    Then User navigate to Setup module and select Tags Setup
    Then User clicks on Add button to create a new tag
    Then User fill the TagName <TagName> Field and select a Color for Tag <Color>
    Then User selects the modules for the tag and saves the tag and verifies the tag is created <PopupMsg>
    Then User navigates to Contacts module and select any contact
    Then User Add tag <TagName> to Contact and then verifies PopupMsg <PopupMsg>

    Examples:
    | Email                                  | Password      | TagName   | Color  |PopupMsg                 |
    |user_email                              | user_password | Testing161| #333   |Tag created successfully!|

  @SetUp
  Scenario Outline: User navigates to Tags Setup page and deletes a Tag
    Given User landed on Ignyte App
    When User logged in with valid Email <Email> and Password <Password>
    Then User navigate to Setup module and select Tags Setup
    Then User search for TagName <TagName> and then delete the Tag
    Examples:
       | Email                                  | Password      | TagName   |
       |user_email                              | user_password | Testing161|