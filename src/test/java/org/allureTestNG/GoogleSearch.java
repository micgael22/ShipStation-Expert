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

import java.io.IOException;
import java.net.URL;

@Listeners({AllureListenerNew.class})
public class GoogleSearch {
    WebDriver driver;
    private URL pathFile = GoogleSearch.class.getResource("/files/");

    @BeforeClass(description = "BROWSER START UP")
    public void setUpNEW(ITestContext iTestContext) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        this.setDriverToContext(iTestContext, driver);
        driver.get("https://www.google.com");
    }

    @AfterClass(description = "BROWSER TEAR DOWN")
    public void tearDownNEW(ITestContext iTestContext) throws IOException {
        driver.close();
    }

    @Epic("EPIC - Google Search Epic")
    @Feature("FEATURE - Doing Google Search")
    @Step("Searching Allure report in Google")
    @Link("https://www.google.com")
    @Description("Description of the Method - Doing Google Search")
    @Test(priority = 1, description = "DOING GOOGLE SEARCH")
    public void googleSearch(ITestContext iTestContext) {

        Assert.assertEquals("Google", driver.getTitle());
        driver.findElement(By.name("q")).sendKeys("Allure Report " + Keys.ENTER);
    }

    @Epic("EPIC - Google Search Epic")
    @Feature("FEATURE - Doing Google Search")
    @Step("Google Navigate Back")
    @Link("https://www.google.com")
    @Description("Description - Google Navigate Back")
    @Test(priority = 2, description = "GOOGLE NAVIGATE BACK")
    public void googleBackToPage(ITestContext iTestContext) {

        driver.navigate().back();
    }

    @Epic("EPIC - Google Search Epic")
    @Feature("FEATURE - Doing Google Search")
    @Step("Google Navigate Forward")
    @Link("https://www.google.com")
    @Description("Description - Google Navigate Forward")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 3, description = "GOOGLE NAVIGATE FORWARD")
    public void googleForwardToPage(ITestContext iTestContext) {

        driver.navigate().forward();
        Assert.assertEquals("Googleee",driver.getTitle());
    }

    public static void setDriverToContext(ITestContext iTestContext, WebDriver driver) {
        iTestContext.setAttribute("WebDriver", driver);
    }
    public static WebDriver getDriverFromContext(ITestContext iTestContext) {
        return (WebDriver) iTestContext.getAttribute("Webriver");
    }

}
