package KingsleyGate.StepDef;

import KingsleyGate.StepDef.Pages.ContactsPage;
import io.cucumber.java.en.Then;

public class Contacts_StepDefinition
{
    SharedContext Context;

    public Contacts_StepDefinition (SharedContext Context)
    {
        this.Context = Context;
    }

    @Then("User navigates to Contacts Page and click on add a new contact")
    public void user_navigates_to_contacts_page()
    {
        Context.CP.NavigatingToContactsPageAndClickOnAddContact();
    }

    @Then("^User provides a valid linkedin (.+) profile$")
    public void user_provides_a_valid_linkedin_profile(String profile)
    {
        Context.CP.AddingContactUsingLinkedinProfile(profile);
    }
}
