package com.loginToWebpage;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

public class TC_12_Gabrielle extends BaseClass03{
    @Test
    public void loginTest12() {
        userName = "Gabrielle";

        //Login Details
        userID = "mngr423969";
        password = "UbazuqY";

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
        config.setProperty("userName", "Gabrielle");
        config.setProperty("userID", "mngr423969");
        config.setProperty("password", "UbazuqY");

        System.out.println(">>> " + userName + " insert login details successfully!! <<<");
    }
}
