package io.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.tests.utilities.ReadConfig;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;
import io.pageObjects.LoginPage;

import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseClassIO {

    //ONLY CHANGE THE VALUES prop FILE//
    ReadConfig readConfig = new ReadConfig();
//    public String url = readConfig.getAppUrl();
//    public String userName = readConfig.getUserName();
//    public String userID = readConfig.getUserID();
//    public String password = readConfig.getPassword();

    //ONLY CHANGE THE VALUES prop FILE//

    public WebDriver driver;
    public static Logger logR;
    public LoginPage logInP;

    public String userName;
    public String userID;
    public String password;
    public String url;

    PropertiesConfiguration config;
    ExtentSparkReporter htmlReporter;
    ExtentReports extent;
    ExtentTest test;            //helps to generate the logs in the test report.

    @BeforeSuite
    public void startReport() {
        // initialize the HtmlReporter
        htmlReporter = new ExtentSparkReporter("LoginReportSpark.html");

        //initialize ExtentReports and attach the HtmlReporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        htmlReporter.config().setDocumentTitle("Automation Report Login-Details ");
        htmlReporter.config().setReportName("Test Report ");
        htmlReporter.config().setTheme(Theme.DARK);
    }


    @BeforeTest
    public void setup() throws ConfigurationException {
        url = "http://demo.guru99.com/V4/";
        logR = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        try {
            FileHandler fh = new FileHandler("myLogger.log");
            fh.setLevel(Level.ALL);
            logR.addHandler(fh);

        } catch (Exception e) {
            logR.log(Level.SEVERE, ">>>>File Logger not working<<<<");
        }

        //propertiesFile path
        config = new PropertiesConfiguration("src/main/resources/Config.properties");


//            if(br.equals("chrome")) {
//                System.setProperty("webdriver.chrome.driver",readConfig.getChromeDr());
//                driver = new ChromeDriver();
//            }
//            else if (br.equals("Firefox")) {
//                System.setProperty("webdriver.gecko.driver",readConfig.getFireFoxDr());
//                driver = new FirefoxDriver();
//            }
//            else if (br.equals("ie")) {
//                System.setProperty("webdriver.ie.driver",readConfig.getIEDriver());
//                driver = new InternetExplorerDriver();
//            }
//            driver.get(url);

    }




    @AfterTest
    public void afterTest() throws ConfigurationException {

        //to write or update test information to reporter
        extent.flush();
        driver.quit();
        config.save();
        System.out.println(">>>>> configDetails.properties FILE<<<<< SUCCESSFULLY UPDATED!!");
    }
}
