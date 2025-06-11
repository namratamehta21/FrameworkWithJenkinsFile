package KingsleyGate.StepDef;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import UtilityFile.ExtendReportManager;


public class TagsSetup_StepDefinition
{
    SharedContext Context;
	//public ExtendReportManager reportManager;
	

    public TagsSetup_StepDefinition (SharedContext Context)

    {
        this.Context = Context;
        //reportManager = new ExtendReportManager();  
        //reportManager.onStart(null);
    }

    @When("User navigate to Setup module and select Tags Setup")
    public void user_navigate_to_setup_module_and_select_tags_setup()
    {
    	ExtendReportManager.test = ExtendReportManager.extent.createTest("Navigated to setup tags");
        Context.tagsSetupPage.Navigate_Setup_TagsSetup();
        //reportManager.extent.flush();
    }
    @Then("User clicks on Add button to create a new tag")
    public void user_clicks_on_add_button_to_create_a_new_tag()
    {
    	ExtendReportManager.test = ExtendReportManager.extent.createTest("Create a new tag");
        Context.tagsSetupPage.clickOnAddTag();
       // reportManager.extent.flush();
    }
    @Then("^User fill the TagName (.+) Field and select a Color for Tag (.+)$")
    public void user_fill_the_tag_name_tag_name_field_and_select_a_color_for_tag_color(String TagName, String Color)
    {
    	ExtendReportManager.test = ExtendReportManager.extent.createTest("Enter tag Details");
        Context.tagsSetupPage.GiveDetailsOfTags(TagName,Color);
        //reportManager.extent.flush();
    }

    @Then("^User selects the modules for the tag and saves the tag and verifies the tag is created (.+)$")
    public void User_selects_the_modules_for_the_tag_and_saves_the_tag(String PopupMsg)
    {
    	ExtendReportManager.test = ExtendReportManager.extent.createTest("Verify tag created message");
        Assert.assertEquals(Context.tagsSetupPage.selectTagModulesAndSaveTag(),PopupMsg);

    }

    @Then("User navigates to Contacts module and select any contact")//Fail - report name
    public void User_Navigates_to_Contacts_Module_and_select_any_company()
    {
    	ExtendReportManager.test = ExtendReportManager.extent.createTest("select contact and company");
        Context.tagsSetupPage.navigatesToContactModuleAndSelectAnyContact();
    }

    @Then("^User Add tag (.+) to Contact and then verifies PopupMsg (.+)$")
    public void User_Add_Tag_To_Contact_Then_Verifies_PopupMsg(String Tagname, String TagAssignedPopupMsg)
    {
    	ExtendReportManager.test = ExtendReportManager.extent.createTest("Assinged tag to contact");
        Context.tagsSetupPage.AddTagToContacts(Tagname);
        //Assert.assertEquals(Context.tagsSetupPage.AddTagToContacts(Tagname),TagAssignedPopupMsg);
    }

    @Then("^User search for TagName (.+) and then delete the Tag$")
    public void userSearchForTagNameTagNameAndThenDeleteTheTag(String Tagname)
    {
    	ExtendReportManager.test = ExtendReportManager.extent.createTest("Delete tag");
        Context.tagsSetupPage.SearchAndDeleteTag(Tagname);
    }
}
