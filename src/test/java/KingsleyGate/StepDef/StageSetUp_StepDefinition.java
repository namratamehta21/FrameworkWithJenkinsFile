package KingsleyGate.StepDef;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import UtilityFile.ExcelReader;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;

public class StageSetUp_StepDefinition 
{
	 SharedContext Context;
	 	static final String excelPath = System.getProperty("user.dir") + "/TestData/TestData.xlsx";
	 			//"D:\\Automation\\IgnyetFrameworkNamrataBranch\\\\";
	    static final String sheetName = "StageSetUp";

	    private List<Map<String, String>> currentScenarioData;

	    public StageSetUp_StepDefinition (SharedContext Context)
	    {
	        this.Context = Context;
	    }
	    
	    @Before("@StageSetUp")
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

	    @Then("User navigates to Set Up menu and click on add a new stage")
	    public void user_navigates_to_setUp_page() throws InterruptedException
	    {
			Context.StageSetUpPage.Navigating_To_StageSetupClickOnAddStage();
	    }

	    @Then("^User provides a valid stage set up details (.+) (.+) (.+) (.+) (.+) and (.+)$")
	    public void user_provides_a_valid_details(String StageCode, String StageLabel, String Colour, String SequenceNumber, String ReasonLookup, String ShortDescription)
	    {
	    	for (Map<String, String> row : currentScenarioData) 
	    	{
	            String stageCode = row.get("StageCode");
	            String stageLabel = row.get("StageLabel");
	            String colour = row.get("Colour");
	            String sequenceNumber = row.get("SequenceNumber");
	            String reasonLookup = row.get("ReasonLookup");
	            String shortDescription = row.get("ShortDescription");
	            System.out.println("Filling stage details - StageCode: " + stageCode + ", StageLabel: " + stageLabel);
	            Context.StageSetUpPage.CreatingStageWithDetails(stageCode,stageLabel,colour,sequenceNumber,reasonLookup,shortDescription);
	    	}
	    }

		@Then("^User navigates to Set Up menu and search for the stage (.+) and disable the stage$")
		public void userNavigatesToSetUpMenuAndSearchForTheStageStageCode(String StageCode)
		{
			for (Map<String, String> row : currentScenarioData) 
			{
	            String stageCode = row.get("StageCode");
	            System.out.println("Stage to disabled -: " + stageCode);
	            Context.StageSetUpPage.SearchStageAndDisable(stageCode);
			}
		}

}
