package com.loginToWebpage;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import pageObjects.LoginPage;

import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseClass03 {

    public String userName;
    public String userID;
    public String password;
    public WebDriver driver;
    public static Logger logR;
    public String url;
    public LoginPage logInP;
    PropertiesConfiguration config;

    ExtentSparkReporter htmlReporter;
//    ExtentHtmlReporter htmlReporter;
    ExtentReports extent;
    ExtentTest test;                     //helps to generate the logs in the test report.

    @BeforeSuite
    public void startReport() {
        // initialize the HtmlReporter
        htmlReporter = new ExtentSparkReporter("LoginReportsSParkd.html");

//        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"\\LoginReports.html");
        //\\ExtentReportResults.html

        //initialize ExtentReports and attach the HtmlReporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        //configuration items to change the look and feel
        //add content, manage tests etc
//        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("Automation Report Login-Details ");
        htmlReporter.config().setReportName("Test Report ");
//        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.DARK);
        //htmlReporter.config().setTimeStamp("dd/MM/yyyy HH:mm:ss");
    }

    @BeforeTest
    public void setup03() throws ConfigurationException {
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
        config = new PropertiesConfiguration("src/main/resources/configDetails.properties");
    }


    @AfterTest
    public void afterTestO3() throws ConfigurationException {

        //to write or update test information to reporter
        extent.flush();

        driver.quit();
        config.save();
        System.out.println(">>>>> configDetails.properties FILE<<<<< SUCCESSFULLY UPDATED!!");
    }
}
