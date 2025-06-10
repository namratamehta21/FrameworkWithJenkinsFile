package KingsleyGate.StepDef.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import UtilityFile.AbstractComponents;

public class StageSetUpPage  extends AbstractComponents
{
    WebDriver driver;

    public StageSetUpPage(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "(//*[@class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-vubbuv'])[5]")
	public WebElement setUpIcon;

	@FindBy(xpath = "//div[contains(text(),'Stage Setup')]")
	public WebElement stageSetUpButton;

	@FindBy(xpath = "//div[@class='d-flex justify-content-between']/div[2]/button/div")
	public WebElement addStage;
	
	@FindBy(xpath = "(//input[@id='outlined-basic'])[1]")
	public WebElement stageCd;
	
	@FindBy(xpath = "(//input[@id='outlined-basic'])[2]")
	public WebElement stageLbl;
	
	@FindBy(xpath = "//div[@id='color']/div/div/input")
	public WebElement clr;
	
	@FindBy(xpath = "(//input[@id='outlined-basic'])[5]")
	public WebElement sequenceNum;
	
	@FindBy(xpath = "//textarea[@id='outlined-basic']")
	public WebElement shortDescription;
	
	@FindBy(xpath = "//div[@id='common-footer']/footer/div[2]/button/div")
	public WebElement saveBtn;
	
	public void goToStageScreen() throws InterruptedException
	{		
		setUpIcon.click();

		stageSetUpButton.click();
		
		addStage.click();
	}
	
	public void enterStageDetails(String stageCode, String stageLabel, String colour, String sequenceNumber)
	{
		
		stageCd.sendKeys(stageCode);
		
		stageLbl.sendKeys(stageLabel);
		
		clr.clear();
		clr.sendKeys(colour);
		
		sequenceNum.sendKeys(sequenceNumber);
		
		//saveBtn.click();
		//Thread.sleep(3000);
	}
}
