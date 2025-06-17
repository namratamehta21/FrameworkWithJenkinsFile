Feature: Set Up Page
  I want to create a new stage and disable the same

  Background:
    Given User landed on Ignyte App
    

  @StageSetUp
  Scenario Outline: Add a new stage in application
  	When User logged in with valid Email <Email> and Password <Password>
    Then User navigates to Set Up menu and click on add a new stage
    Then User provides a valid stage set up details <StageCode> <StageLabel> <Colour> <SequenceNumber> <ReasonLookup> and <ShortDescription>

    Examples:
      | Email      | Password      | StageCode   | StageLabel | Colour  | SequenceNumber | ReasonLookup      | ShortDescription   |
      | user_email | user_password | Testing014  | Testing014 | #03ebeb | 1111           | COMPANY_ATTRIBUTES | Automation Purpose |

  @StageSetUp
  Scenario Outline: Disabling the Newly added stage in the application
    When User logged in with valid Email <Email> and Password <Password>
    Then User navigates to Set Up menu and search for the stage <StageCode>
    Then User disable the stage

    Examples:
      | Email      | Password      | StageCode  |
      | user_email | user_password | Testing014 |
