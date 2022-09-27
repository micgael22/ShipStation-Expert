package com.loginToWebpage;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

public class TC_01_Emily extends BaseClass03{

    @Test
    public void loginTest01() {
        userName = "Emily";

        test = extent.createTest("Login Test 01", "Emily Login test case passed");

        //Login Details
        userID = "mngr429800";
        password = "EhudysU";

        driver.get(url);

        logR.info("URL is open");
        logInP = new LoginPage(driver);

        logInP.setUserID(userID);
        logR.info("Entered UserName");

        logInP.setPassword(password);
        logR.info("Entered Password");

        logInP.clickSubmit();

        if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
            Assert.assertTrue(true);
            logR.info("Login test Password");
        } else {
            Assert.assertTrue(false);
            logR.info("Login test failed");
        }

        //insert details in properties file
        config.setProperty("userName","Emily");
        config.setProperty("userID", "mngr429800");
        config.setProperty("password","EhudysU");

        System.out.println(">>> " + userName + " insert login details successfully!! <<<");
    }
}
