package com.loginToWebpage;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

public class TC_10_Malcom extends BaseClass03{

    @Test
    public void loginTest10() {
        userName = "Malcom";

        //Login Details
        userID = "mngr423967";
        password = "utytuga";

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
        config.setProperty("userName", "Malcom");
        config.setProperty("userID", "mngr423967");
        config.setProperty("password", "utytuga");

        System.out.println(">>> " + userName + " insert login details successfully!! <<<");
    }
}
