@IgnyteApplication
Feature: Set Up Page

  @AddStage
  Scenario Outline: Add a new stage in application
    Given User landed on Ignyte App
    When User logged in with valid Email <Email> and Password <Password>
    Then User navigates to Set Up menu and click on add a new stage
    Then User provides a valid stage set up details <StageCode> <StageLabel> <Colour> and <SequenceNumber>


    Examples:
     |Email      |Password      | StageCode   | StageLabel    |Colour  |SequenceNumber |
     |user_email |user_password |111          | Lable1        | 000078 |  1111         |