package com.loginToWebpage;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

public class TC_14_Nkosi extends BaseClass03{
    @Test
    public void loginTest14() {
        userName = "Nkosi";

        //Login Details
        userID = "mngr423971";
        password = "ApamAjE";

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
        config.setProperty("userName", "Nkosi");
        config.setProperty("userID", "mngr423971");
        config.setProperty("password", "ApamAjE");

        System.out.println(">>> " + userName + " insert login details successfully!! <<<");
    }
}
