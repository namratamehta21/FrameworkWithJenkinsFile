@Login
Feature:Contacts Page

  @NewContact
  Scenario Outline: Adding a new contact using Linkedin Profile
    Given User landed on Ignyte App
    When User logged in With valid Email <Email> and Password <Password>
    Then User navigates to Contacts Page and click on add a new contact
    Then User provides a valid linkedin <Profile> profile


    Examples:
      | Email                                  | Password      |Profile                                  |Message    |
      |ykadam+automationtester@kingsleygate.com| fSog0P3kEP03! |https://www.linkedin.com/in/vineetasingh/|           |

#  @DeleteNewContact
#  Scenario Outline: Deleting a new contact using Linkedin Profile
#    Given User landed on Ignyte App
#    When User logged in With valid Email <Email> and Password <Password>
#    Then User navigates to Contacts Page and Search for the new contact created
#    Then User open the contact and deletes it
#    And User verify the Pop-up Message <Message>
#
#
#    Examples:
#      | Email                                  | Password      |
#      |ykadam+automationtester@kingsleygate.com| fSog0P3kEP03! |