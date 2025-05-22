package TestComponents;

import KingsleyGate.StepDef.Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class HooksClass
{
    WebDriver driver;
    LoginPage LP;

    public WebDriver initializeDriver() throws IOException
    {

        Properties prop = new Properties();
        FileInputStream FIS=new FileInputStream(System.getProperty("user.dir")
                +"//src//main//java//Resources//Global.properties");
        prop.load(FIS);
        String browser = System.getProperty("browser") != null ? System.getProperty("browser") : prop.getProperty("browser");
        String URL=prop.getProperty("url");

        if(browser.equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage");
            driver= new ChromeDriver(options);
        }
        else if(browser.equalsIgnoreCase("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();
        }
        else if(browser.equalsIgnoreCase("edge"))
        {
            WebDriverManager.edgedriver().setup();
            driver=new EdgeDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(URL);
        System.out.println("Selected browser: " + browser);
        return driver;
    }

    public LoginPage launchApp() throws IOException

    {
        this.driver=initializeDriver();
        LP=new LoginPage(driver);
        return LP;

    }

    public void CloseWindow()
    {
        driver.close();
    }

}
