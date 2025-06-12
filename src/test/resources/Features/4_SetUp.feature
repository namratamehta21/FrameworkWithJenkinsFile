@IgnyteApplication
Feature: Set Up Page

  @AddStage
  Scenario Outline: Add a new stage in application
    Given User landed on Ignyte App
    When User logged in with valid Email <Email> and Password <Password>
    Then User navigates to Set Up menu and click on add a new stage
    Then User provides a valid stage set up details <StageCode> <StageLabel> <Colour> <SequenceNumber> <ReasonLookup> and <ShortDescription>


    Examples:
     |Email      |Password      | StageCode   | StageLabel    |Colour   |SequenceNumber | ReasonLookup     | ShortDescription |
     |user_email |user_password |Testing002   | Testing002    | #03ebeb |  1111         |COMPANY_ATTRIBUTES|Automation Purpose|


  @AddStage
  Scenario Outline: Disabling the Newly added stage in the application
    Given User landed on Ignyte App
    When User logged in with valid Email <Email> and Password <Password>
    Then User navigates to Set Up menu and search for the stage <StageCode>
    Then User disable the stage

    Examples:
      |Email      |Password      | StageCode   |
      |user_email |user_password |Testing002   |