package com.loginToWebpage;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

public class TC_13_Mindy extends BaseClass03{
    @Test
    public void loginTest13() {
        userName = "Mindy";

        //Login Details
        userID = "mngr423970";
        password = "Amepapu";

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
        config.setProperty("userName", "Mindy");
        config.setProperty("userID", "mngr423970");
        config.setProperty("password", "Amepapu");

        System.out.println(">>> " + userName + " insert login details successfully!! <<<");
    }
}
