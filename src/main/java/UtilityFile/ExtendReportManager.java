package UtilityFile;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtendReportManager implements ITestListener
{
	// Below three classes come from Extend report itself
	public static ExtentSparkReporter sparkReporter;	 // responsible for UI of the report
	public static ExtentReports extent; 				 // show common data like env infor, user infor, os, project name, module name
	public static ExtentTest test;                      // for writing test or creating entries in the report, if any test fail then to add that entry in the report
	
	static String repName;
	
	public void onStart(ITestContext testContext)
	{		
		if(extent == null)
		{
		//String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
		repName="Igyte_Automation_Report.html";
				
		sparkReporter=new ExtentSparkReporter("/ext_reports/"+repName);//specify location of the report
		System.out.println("Testing extend report execution");		
		sparkReporter.config().setDocumentTitle("Ignyte Project"); // Title of report
		sparkReporter.config().setReportName("Ignyte API"); // name of the report
		sparkReporter.config().setTheme(Theme.DARK);
				
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "Ignyte API");
		extent.setSystemInfo("Operating System", System.getProperty("os.name"));
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		extent.setSystemInfo("Environemnt","QA");
		extent.setSystemInfo("user","Namrata");
		}
	}
	
	//Below methods actual make entries in the report
	
	public void onTestSuccess(ITestResult result)
	{
		System.out.println("Test Passed: " + result.getName());
		test=extent.createTest(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.createNode(result.getName());
		test.log(Status.PASS, "Test Passed");
	}
	
	public void onTestFailure(ITestResult result)
	{
		System.out.println("Test Failed: " + result.getName());
		test=extent.createTest(result.getName()); 
		test.createNode(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL, "Test Failed");
		test.log(Status.FAIL, result.getThrowable().getMessage());
	}
	
	public void onTestSkipped(ITestResult result)
	{
		System.out.println("Test Skipped: " + result.getName());

		test=extent.createTest(result.getName()); 
		test.createNode(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, "Test Skipped");
		test.log(Status.SKIP, result.getThrowable().getMessage());
	}
	
	public void onFinish(ITestContext testContext)
	{
		System.out.println("Test Completed");

		if (extent != null) {
		extent.flush(); // this make everything ready in the report. If we dont call this method, report will not be generated
	}}

}
 