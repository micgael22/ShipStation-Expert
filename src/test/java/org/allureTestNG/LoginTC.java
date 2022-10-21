package org.allureTestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.pageObjects.LoginPage;
import io.qameta.allure.*;
import io.tests.utilities.ReadConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.logging.Logger;

@Listeners({AllureListenerNew.class})

public class LoginTC extends BaseClassTest {

    @Epic("EPIC - Employees Login Test")
    @Feature("FEATURE - Find URL")
    @Step("Step 1")
    @Link("http://demo.guru99.com/V4/")
    @Description("Description of the Method - Find Heading")
    @Test(priority = 1, description = "NAVIGATE TO WEBSITE & AND FIND HEADING")
    public void openURL(ITestContext iTestContext) {

        System.out.println("OPEN URL TEST");

        Assert.assertEquals("Guru99 Bank Home Page", driver.getTitle());
        driver.findElement(By.xpath("/html/body/div[2]/h2"));
        logInP = new LoginPage(driver);
        //logR.info("URL is open");
//        driver.findElement(By.name("q")).sendKeys("Allure Report " + Keys.ENTER);

        System.out.println("END OF URL TEST");
    }

    @Epic("EPIC - Employees Login Test")
    @Feature("FEATURE - Employees Emily")
    @Step("Step 2")
    @Link("http://demo.guru99.com/V4/")
    @Description("Description - Enter User-ID and Password")
    @Test(priority = 2, description = "PRIVATE DETAILS")
    public void enterDetails(ITestContext iTestContext) {

        System.out.println("OPEN enterDetails TEST");

        //Login Details
        userID = "mngr445439";
        password = "YgAvyhA";

        logInP.setUserID(userID);
        //logR.info("Entered User ID");
//        driver.findElement(By.name("uid"))
//                .sendKeys("Login details" + Keys.ENTER);

        logInP.setPassword(password);
        //logR.info("Entered Password");
//        driver.findElement(By.name("password"))
//                .sendKeys(password + Keys.ENTER);

        logInP.clickSubmit();

        if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
            Assert.assertTrue(true);
            System.out.println("Find page title");
            //logR.info("Get the Title");
        }
        else {
            Assert.assertTrue(false);
            System.out.println("Login test failed");
            //logR.info("Login test failed");
        }

        System.out.println("CLOSE enterDetails TEST");

    }

    @Epic("EPIC - Employees Login Test")
    @Feature("FEATURE - Doing Google Search")
    @Step("Step 3")
    @Link("http://demo.guru99.com/V4/")
    @Description("Description - Navigate Back")
    @Test(priority = 3, description = "NAVIGATE BACK HOME")
    public void backToPage(ITestContext iTestContext) {

        System.out.println("OPEN enterDetails TEST");

        Assert.assertEquals("Welcome To Manager's Page of Guru99 Bank", driver.getTitle());
        driver.findElement(By.name("Welcome To Manager's Page of Guru99 Bank"));
        driver.navigate().back();

        System.out.println("OPEN enterDetails TEST");

    }
}

