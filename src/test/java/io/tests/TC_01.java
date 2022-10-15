package io.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.pageObjects.LoginPage;

public class TC_01 extends BaseClassIO {

    @Test
    public void loginTest() {
        System.out.println("Test begin");
        userName = "Emily";

        test = extent.createTest("Login Test 01", "Emily Login test case passed");

        //Login Details
        userID = "mngr445439";
        password = "YgAvyhA";

        driver.get(url);

        logInP = new LoginPage(driver);
        logR.info("URL is open");

        logInP.setUserID(userID);
        logR.info("Entered UserName");

        logInP.setPassword(password);
        logR.info("Entered Password");

        logInP.clickSubmit();

        if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
            Assert.assertTrue(true);
            logR.info("Get the Title");
        }
        else {
            Assert.assertTrue(false);
            logR.info("Login test failed");
        }

        //insert details in properties file
//        config.setProperty("userName","Emily");
//        config.setProperty("userID", "mngr429800");
//        config.setProperty("password","EhudysU");

        System.out.println(">>> " + userName + " Login details operation <<<");
        System.out.println("Test end");
    }
}
