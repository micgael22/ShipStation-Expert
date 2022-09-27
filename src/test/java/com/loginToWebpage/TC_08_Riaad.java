package com.loginToWebpage;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

public class TC_08_Riaad extends BaseClass03{
    @Test
    public void loginTest08() {
        userName = "Riaad";

        //Login Details
        userID = "mngr423965";
        password = "esehesU";

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
        config.setProperty("userName", "Riaad");
        config.setProperty("userID", "mngr423965");
        config.setProperty("password", "esehesU");

        System.out.println(">>> " + userName + " insert login details successfully!! <<<");
    }
}
