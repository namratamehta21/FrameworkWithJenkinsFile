@Login
Feature:CompaniesPage

  @CompaniesPage
  Scenario Outline: Navigating to Companies Page
    Given User landed on Ignyte App
    When User logged in with valid Email <Email> and Password <Password>
    Then User Navigates to Companies Page
    Then Verifies the Page Title <Companies_PageTitle>

    Examples:
      | Email    | Password      | Companies_PageTitle|
      |user_email| user_password |Companies - Ignyte  |

  @CompaniesPage
  Scenario Outline: Navigating to Companies Page and user select any one company
    Given User landed on Ignyte App
    When User logged in with valid Email <Email> and Password <Password>
    Then User Navigates to Companies Page
    Then User select any one company

    Examples:
      | Email      | Password      |
      | user_email | user_password |

  @CompaniesPage
  Scenario Outline: Navigating to Companies Page and user search for a company
    Given User landed on Ignyte App
    When User logged in with valid Email <Email> and Password <Password>
    Then User Navigates to Companies Page
    Then User search for a Company <Company_Name>

    Examples:
      | Email    | Password      |Company_Name |
      |user_email| user_password | Google      |

  @CompaniesPage
  Scenario Outline: Navigating to Companies Page and user clicks on column tab
    Given User landed on Ignyte App
    When User logged in with valid Email <Email> and Password <Password>
    Then User Navigates to Companies Page
    Then User click on column tab and verify the list of columns

    Examples:
      | Email    | Password      |
      |user_email| user_password |

#  @CompaniesPage
#  Scenario Outline: Navigating to Companies Page and user clicks on column tab and add columns
#    Given User landed on Ignyte App
#    When User logged in with valid Email <Email> and Password <Password>
#    Then User Navigates to Companies Page
#    Then User click on column tab and verify the list of columns
#    Then User unselect all and add column to the grid
#    Then User verifies the column selected are shown in the grid
#
#    Examples:
#      | Email     | Password      |
#      |user_email| user_password |

  @CompaniesPage
  Scenario Outline: Navigating to Companies Page and user adds a new company
    Given User landed on Ignyte App
    When User logged in with valid Email <Email> and Password <Password>
    Then User Navigates to Companies Page
#    Then User clicks on Add Company button to add a company
#    Then User give Company Name <Name>, Website URL <URL>,

    Examples:
      | Email    | Password      |
      |user_email| user_password |