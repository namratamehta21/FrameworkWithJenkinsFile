package KingsleyGate.StepDef;

import UtilityFile.ExtendReportManager;
import io.cucumber.java.en.Then;

public class StageSetUp_StepDefinition 
{
	 SharedContext Context;

	    public StageSetUp_StepDefinition (SharedContext Context)
	    {
	        this.Context = Context;
	    }

	    @Then("User navigates to Set Up menu and click on add a new stage")
	    public void user_navigates_to_setUp_page() throws InterruptedException
	    {
	    	ExtendReportManager.test = ExtendReportManager.extent.createTest("Navigated to Add stage - setup tags");
			Context.StageSetUpPage.Navigating_To_StageSetupClickOnAddStage();
	    }

	    @Then("^User provides a valid stage set up details (.+) (.+) (.+) (.+) (.+) and (.+)$")
	    public void user_provides_a_valid_details(String StageCode, String StageLabel, String Colour, String SequenceNumber, String ReasonLookup, String ShortDescription)
	    {
	    	ExtendReportManager.test = ExtendReportManager.extent.createTest("Enter details on stage setup tags");
			Context.StageSetUpPage.CreatingStageWithDetails(StageCode,StageLabel,Colour,SequenceNumber,ReasonLookup,ShortDescription);
	    }

	@Then("^User navigates to Set Up menu and search for the stage (.+)$")
	public void userNavigatesToSetUpMenuAndSearchForTheStageStageCode(String StageCode)
	{
		ExtendReportManager.test = ExtendReportManager.extent.createTest("Search for stage code");
		Context.StageSetUpPage.SearchStage(StageCode);
	}

	@Then("User disable the stage")
	public void userDisableTheStage()
	{
		Context.StageSetUpPage.disableStage();
	}
}
