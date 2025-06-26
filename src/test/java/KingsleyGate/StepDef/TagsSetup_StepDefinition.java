package KingsleyGate.StepDef;

import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.Scenario;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.testng.Assert;

import UtilityFile.ExcelReader;

public class TagsSetup_StepDefinition {

    SharedContext Context;
    static final String excelPath = "D:\\Automation\\IgnyetFrameworkNamrataBranch\\TestData\\TestData.xlsx";
    static final String sheetName = "TagSetUp";

    private List<Map<String, String>> currentScenarioData;

    public TagsSetup_StepDefinition(SharedContext Context) {
        this.Context = Context;
    }

    @Before("@TagSetUp")
    public void beforeScenario(Scenario scenario) throws FileNotFoundException, IOException {
        String scenarioName = scenario.getName();
        System.out.println("Scenario name is : " + scenarioName);

        ExcelReader reader = new ExcelReader(excelPath);
        currentScenarioData = reader.readExcelData(sheetName, scenarioName);

        System.out.println("Data extracted for scenario in Step definition is :");
        if (currentScenarioData != null && !currentScenarioData.isEmpty()) {
            for (Map<String, String> row : currentScenarioData) {
                System.out.println("Current Scenario data :" + row);
            }
        } else {
            System.out.println("No data found for this scenario.");
        }
    }

    @When("User navigate to Setup module and select Tags Setup")
    public void user_navigate_to_setup_module_and_select_tags_setup() {
        System.out.println("Inside User navigate to Setup module and select Tags Setup ");
        Context.tagsSetupPage.Navigate_Setup_TagsSetup();
    }

    @Then("User clicks on Add button to create a new tag")
    public void user_clicks_on_add_button_to_create_a_new_tag() {
        System.out.println("Inside User clicks on Add button to create a new tag");
        Context.tagsSetupPage.clickOnAddTag();
    }

    @Then("^User fill the TagName (.+) Field and select a Color for Tag (.+)$")
    public void user_fill_the_tag_name_tag_name_field_and_select_a_color_for_tag_color(String TagName, String Color) {
        for (Map<String, String> row : currentScenarioData) {
            String tag = row.get("TagName");
            String color = row.get("Color");
            System.out.println("Filling tag details - TagName: " + tag + ", Color: " + color);
            Context.tagsSetupPage.GiveDetailsOfTags(tag, color);
        }
    }

    //@Then("^User selects the modules for the tag and saves the tag$")
    //public void User_selects_the_modules_for_the_tag_and_saves_the_tag() 
    //{
    	//Context.tagsSetupPage.selectTagModulesAndSaveTag();
        //for (Map<String, String> row : currentScenarioData) {
            //String expectedPopup = row.get("PopupMsg");
            //System.out.println("Verifying tag creation with popup message: " + expectedPopup);
            //String actualPopup = Context.tagsSetupPage.selectTagModulesAndSaveTag();
            //Assert.assertEquals(actualPopup, expectedPopup);
        //}
    //}

    @Then("^User navigates to Contacts module and select any contact$")
    public void User_Navigates_to_Contacts_Module_and_select_any_company() {
        System.out.println("Inside navigating to Contacts module and selecting a contact");
        Context.tagsSetupPage.navigatesToContactModuleAndSelectAnyContact();
    }

    @Then("^User Add tag (.+) to Contact and then verifies PopupMsg (.+)$")
    public void User_Add_Tag_To_Contact_Then_Verifies_PopupMsg(String Tagname, String TagAssignedPopupMsg) {
        for (Map<String, String> row : currentScenarioData) {
            String tag = row.get("TagName");
            String popup = row.get("PopupMsg"); // Assuming this is reused
            System.out.println("Adding tag: " + tag + " and expecting popup: " + popup);
            String actualPopup = Context.tagsSetupPage.AddTagToContacts(tag);
            Assert.assertEquals(actualPopup, popup);
        }
    }

    @Then("^User search for TagName (.+) and then delete the Tag$")
    public void userSearchForTagNameTagNameAndThenDeleteTheTag(String Tagname) {
        for (Map<String, String> row : currentScenarioData) {
            String tag = row.get("TagName");
            System.out.println("Searching and deleting tag: " + tag);
            Context.tagsSetupPage.SearchAndDeleteTag(tag);
        }
    }
}
