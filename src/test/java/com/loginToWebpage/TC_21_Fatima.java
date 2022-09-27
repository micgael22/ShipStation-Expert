package com.loginToWebpage;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

public class TC_21_Fatima extends BaseClass03 {

    @Test
    public void loginTest21() {
        userName = "Fatima";

        //Login Details
        userID = "mngr423978";
        password = "UbemutU";

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
        config.setProperty("userName", "Fatima");
        config.setProperty("userID", "mngr423978");
        config.setProperty("password", "UbemutU");

        System.out.println(">>> " + userName + " insert login details successfully!! <<<");
    }
}
