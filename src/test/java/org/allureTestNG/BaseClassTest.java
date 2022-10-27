package org.allureTestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.pageObjects.LoginPage;
import io.tests.utilities.ReadConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.util.logging.Logger;


public class BaseClassTest {

    public WebDriver driver;
    public static Logger logR;
    public LoginPage logInP;

    public String userName;
    public String userID;
    public String password;
    public String url;

    ReadConfig readConfig = new ReadConfig();

    /////////////////////////////////////////
    //WebDriver driver;
    //private URL pathFile = LoginTC.class.getResource("/files/");

    @BeforeClass(description = "BROWSER START UP")
    public void setUpNEW(ITestContext iTestContext) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        this.setDriverToContext(iTestContext, driver);
        driver.get("http://demo.guru99.com/V4/");
    }

    @AfterClass(description = "BROWSER TEAR DOWN")
    public void tearDownNEW(ITestContext iTestContext) {
        driver.close();
    }

    public static void setDriverToContext(ITestContext iTestContext, WebDriver driver) {
        iTestContext.setAttribute("WebDriver", driver);
    }
    public static WebDriver getDriverFromContext(ITestContext iTestContext) {
        return (WebDriver) iTestContext.getAttribute("Webriver");
    }
}
