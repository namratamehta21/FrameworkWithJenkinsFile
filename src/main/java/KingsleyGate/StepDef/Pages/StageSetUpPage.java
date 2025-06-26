package KingsleyGate.StepDef.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import UtilityFile.AbstractComponents;

import java.util.List;

public class StageSetUpPage  extends AbstractComponents
{
	WebDriver driver;
	public StageSetUpPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath = "//div[@class='hamburger-span']//*[name()='svg']")
	WebElement Menu;

	@FindBy(xpath = "//div[contains(text(),'SETUP')]")
	WebElement SetupModule;

	@FindBy(xpath = "//div[normalize-space()='Stage Setup']")
	WebElement StageSetupIcon;

	@FindBy(xpath = "//div[@class='d-flex justify-content-between']/div[2]/button/div")
	WebElement AddStageBtn;

	@FindBy(xpath = "//div[@id='stage-name']//input[@id='outlined-basic']")
	WebElement stageCode;

	@FindBy(xpath = "(//legend/span[contains(normalize-space(), 'Stage Label')]/ancestor::div[contains(@class, 'MuiInputBase-root')]//input)[1]")
	WebElement stageLabel;

	@FindBy(xpath = "//input[@type='text' and @autocomplete='off' and contains(@class, 'MuiInputBase-inputAdornedStart')]")
	WebElement stageColor;

	@FindBy(xpath = "//div[@id='seq-no']//input[@id='outlined-basic']")
	WebElement stageSequenceNo;

	@FindBy(xpath = "//label[normalize-space()='Reason Lookup']/following::input[@role='combobox']")
	WebElement stageReasonLookupField;

	@FindBy(xpath = "//textarea[@id='outlined-basic']")
	WebElement stageShortDescription;

	@FindBy(xpath = "//button[.//div[normalize-space()='Save']]")
	WebElement StageSave;

	@FindBy(xpath = "//input[contains(@class, 'MuiAutocomplete-input')]")
	WebElement StageSearch;

	@FindBy(xpath = "(//li[@id='lock-button'])[1]")
	WebElement StageModificationBtn;

	@FindBy(xpath = "//li[normalize-space()='Disable']")
	WebElement StageDisableBtn;

	public void Navigating_To_StageSetupClickOnAddStage()
	{
		waitForWebElementToAppear(Menu);
		Menu.click();
		waitForWebElementToAppear(SetupModule);
		SetupModule.click();
		Menu.click();
		waitForWebElementToAppear(StageSetupIcon);
		StageSetupIcon.click();
		
	}

	public void CreatingStageWithDetails(String StageCode, String StageLabel, String StageColor, String StageSequencNo, String StageReasonLookup, String StageShortDecription)
	{
		try 
		{
			Thread.sleep(5000);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		waitForWebElementToAppear(AddStageBtn);
		AddStageBtn.click();
		waitForWebElementToAppear(stageCode);
		stageCode.sendKeys(StageCode);
		stageLabel.sendKeys(StageLabel);
		stageColor.sendKeys(StageColor);
		stageSequenceNo.sendKeys(StageSequencNo);
		stageReasonLookupField.sendKeys(StageReasonLookup);
		List<WebElement> options = driver.findElements(By.xpath("//ul[@role='listbox']//li"));
		System.out.println("---- DROPDOWN OPTIONS ----");
		for (WebElement opt : options) {
			System.out.println("• [" + opt.getText() + "]");
		}
		for (WebElement opt : options) {
			if (opt.getText().equalsIgnoreCase(StageReasonLookup)) {
				opt.click();
				break;
			}
		}
		stageShortDescription.sendKeys(StageShortDecription);
		StageSave.click();
	}

	public void SearchStage(String StageCode)
	{
		waitForWebElementToAppear(Menu);
		Menu.click();
		waitForWebElementToAppear(SetupModule);
		SetupModule.click();
		Menu.click();
		waitForWebElementToAppear(StageSetupIcon);
		StageSetupIcon.click();
		waitForWebElementToAppear(StageSearch);
		StageSearch.sendKeys(StageCode);
		try 
		{
			Thread.sleep(5000);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		waitForWebElementToAppear(StageModificationBtn);
		StageModificationBtn.click();
		waitForWebElementToAppear(StageDisableBtn);
		StageDisableBtn.click();
	}
}
