package UtilityFile;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
    public static ExtentReports getReportObject() {
        String path = System.getProperty("user.dir") + "/ext_reports/index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        try 
        {
			reporter.loadXMLConfig("src/test/resources/extent-config.xml");
		} 
        catch (IOException e) 
        {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Namrata");
        return extent;
    }
}
