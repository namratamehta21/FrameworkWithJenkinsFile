package KingsleyGate.StepDef;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class TagsSetup_StepDefinition
{
    SharedContext Context;

    public TagsSetup_StepDefinition (SharedContext Context)

    {
        this.Context = Context;
    }

    @When("User navigate to Setup module and select Tags Setup")
    public void user_navigate_to_setup_module_and_select_tags_setup()
    {
        Context.tagsSetupPage.Navigate_Setup_TagsSetup();
    }
    @Then("User clicks on Add button to create a new tag")
    public void user_clicks_on_add_button_to_create_a_new_tag()
    {
        Context.tagsSetupPage.clickOnAddTag();
    }
    @Then("^User fill the TagName (.+) Field and select a Color for Tag (.+)$")
    public void user_fill_the_tag_name_tag_name_field_and_select_a_color_for_tag_color(String TagName, String Color)
    {
        Context.tagsSetupPage.GiveDetailsOfTags(TagName,Color);
    }

    @Then("^User selects the modules for the tag and saves the tag and verifies the tag is created (.+)$")
    public void User_selects_the_modules_for_the_tag_and_saves_the_tag(String PopupMsg)
    {
        Assert.assertEquals(Context.tagsSetupPage.selectTagModulesAndSaveTag(),PopupMsg);

    }

    @Then("User navigates to Contacts module and select any contact")
    public void User_Navigates_to_Contacts_Module_and_select_any_company()
    {
        Context.tagsSetupPage.navigatesToContactModuleAndSelectAnyContact();
    }

    @Then("^User Add tag (.+) to Contact and then verifies PopupMsg (.+)$")
    public void User_Add_Tag_To_Contact_Then_Verifies_PopupMsg(String Tagname, String TagAssignedPopupMsg)
    {
        Context.tagsSetupPage.AddTagToContacts(Tagname);
        //Assert.assertEquals(Context.tagsSetupPage.AddTagToContacts(Tagname),TagAssignedPopupMsg);
    }

    @Then("^User search for TagName (.+) and then delete the Tag$")
    public void userSearchForTagNameTagNameAndThenDeleteTheTag(String Tagname)
    {
        Context.tagsSetupPage.SearchAndDeleteTag(Tagname);
    }
}
