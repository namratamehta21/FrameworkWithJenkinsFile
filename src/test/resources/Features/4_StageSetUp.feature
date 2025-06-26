Feature: Stage Set Up Page
  I want to create a new stage and disable the same

  Background:
    Given User landed on Ignyte App
    Then User logged in with valid email and password
    
  @StageSetUp
  Scenario: Add a new stage in application
    Then User navigates to Set Up menu and click on add a new stage
    Then User provides a valid stage set up details "StageCode" "StageLabel" "Colour" "SequenceNumber" "ReasonLookup" and "ShortDescription"

  @StageSetUp
  Scenario: Disabling the Newly added stage in the application
    Then User navigates to Set Up menu and search for the stage "StageCode" and disable the stage
