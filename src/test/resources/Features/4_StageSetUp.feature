Feature: Set Up Page
  I want to create a new stage and disable the same

  Background:
    Given User landed on Ignyte App
    Then User logged in with valid email and password
    
  @StageSetUp
  Scenario Outline: Add a new stage in application
    Then User navigates to Set Up menu and click on add a new stage
    Then User provides a valid stage set up details <StageCode> <StageLabel> <Colour> <SequenceNumber> <ReasonLookup> and <ShortDescription>

    Examples:
      | StageCode   | StageLabel | Colour  | SequenceNumber | ReasonLookup       | ShortDescription   |
      | Testing011  | Testing01  | #03ebeb | 1111           | COMPANY_ATTRIBUTES | Automation Purpose |

  @StageSetUp
  Scenario Outline: Disabling the Newly added stage in the application
    Then User navigates to Set Up menu and search for the stage <StageCode>
    Then User disable the stage

    Examples:
      | StageCode  |
      | Testing010 |
