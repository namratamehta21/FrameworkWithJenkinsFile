Feature: Tags Setup
  I want to create a new tag and delete the same

  Background:
    Given User landed on Ignyte App
    Then User logged in with valid email and password

  @TagSetUp
  Scenario: User navigates to Tags Setup page and add a new Tag
    Then User navigate to Setup module and select Tags Setup
    Then User clicks on Add button to create a new tag
    Then User fill the TagName "TagName" Field and select a Color for Tag "Color"
    #Then User navigates to Contacts module and select any contact
    #Then User Add tag "TagName" to Contact and then verifies PopupMsg "PopupMsg"

  @TagSetUp
  Scenario: Navigates to Tags Setup page and deletes a Tag
    Then User navigate to Setup module and select Tags Setup
    Then User search for TagName "TagName" and then delete the Tag

