package KingsleyGate.StepDef;

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
	        Context.stageSetUpPage.goToStageScreen();
	    }

	    @Then("^User provides a valid stage set up details (.+) (.+) (.+) and (.+)$")
	    public void user_provides_a_valid_details(String StageCode, String StageLabel, String Colour, String SequenceNumber)
	    {
	        Context.stageSetUpPage.enterStageDetails(StageCode, StageLabel, Colour, SequenceNumber);
	    }
}
