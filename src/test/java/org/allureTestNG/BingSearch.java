package org.allureTestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestContext;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.net.URL;

@Listeners({AllureListenerNew.class})

public class BingSearch {

    WebDriver driver;
    private URL pathFile = GoogleSearch.class.getResource("/files/");

    @BeforeClass(description = "BROWSER START UP")
    public void setUpNEW(ITestContext iTestContext) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        this.setDriverToContext(iTestContext, driver);
        driver.get("https://www.bing.com");
    }

    @AfterClass(description = "BROWSER TEAR DOWN")
    public void tearDownNEW(ITestContext iTestContext) {
        driver.close();
    }

    @Epic("EPIC - Bing Search Epic")
    @Feature("FEATURE - Doing Bing Search")
    @Step("Searching Allure report in Bing")
    @Link("https://www.bing.com")
    @Description("Description of the Method - Doing Bing Search")
    @Test(priority = 1, description = "DOING BING SEARCH")
    public void bingSearch(ITestContext iTestContext) {
        Assert.assertEquals("Bing", driver.getTitle());
        driver.findElement(By.name("q")).sendKeys("Allure Report " + Keys.ENTER);
    }

    @Epic("EPIC - Bing Search Epic")
    @Feature("FEATURE - Doing Bing Search")
    @Step("Bing Navigate Back")
    @Link("https://www.bing.com")
    @Description("Description - Bing Navigate Back")
    @Test(priority = 2, description = "BING NAVIGATE BACK")
    public void bingBackToPage(ITestContext iTestContext) {

        driver.navigate().back();
    }

    @Epic("EPIC - Bing Search Epic")
    @Feature("FEATURE - Doing Bing Search")
    @Step("Bing Navigate Forward")
    @Link("https://www.bing.com")
    @Description("Description - Bing Navigate Forward")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 3, description = "BING NAVIGATE FORWARD")
    public void bingForwardToPage(ITestContext iTestContext) {

        driver.navigate().forward();
        Assert.assertEquals("Bingg",driver.getTitle());
    }

    public static void setDriverToContext(ITestContext iTestContext, WebDriver driver) {
        iTestContext.setAttribute("WebDriver", driver);
    }
    public static WebDriver getDriverFromContext(ITestContext iTestContext) {
        return (WebDriver) iTestContext.getAttribute("Webriver");
    }

}
