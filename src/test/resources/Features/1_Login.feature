@Login
Feature:Login Page

  @regression
  Scenario Outline: Logging in Ignyte Website using Valid Credentials
    Given User landed on Ignyte App
    When User logged in With valid Email <Email> and Password <Password>
    Then User Logged in succesfully in Ignyte App and match the title <Title> of the home page

    Examples:
    | Email                                  | Password      | Title           |
    |ykadam+automationtester@kingsleygate.com| fSog0P3kEP03! | Welcome - Ignyte|