package com.loginToWebpage;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

public class TC_11_Shannon extends BaseClass03{

    @Test
    public void loginTest11() {
        userName = "Shannon";

        //Login Details
        userID = "mngr423968";
        password = "dupYtUd";

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
        config.setProperty("userName", "Shannon");
        config.setProperty("userID", "mngr423968");
        config.setProperty("password", "dupYtUd");

        System.out.println(">>> " + userName + " insert login details successfully!! <<<");
    }
}
