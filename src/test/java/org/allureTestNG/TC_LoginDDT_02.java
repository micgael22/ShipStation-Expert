package org.allureTestNG;

import io.pageObjects.LoginPage;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.utils.XLUtils;

import java.io.IOException;

public class TC_LoginDDT_02 extends BaseClassTest{
    @Test(dataProvider = "LoginData")
    public void loginDDT(String user, String pwd) {

        LoginPage logInP = new LoginPage(driver);
        logInP.setUserID(user);
        logR.info("user ID provided");
        logInP.setPassword(pwd);
        logR.info("user password provided");
        logInP.clickSubmit();

        if(isAlertPresent() == true) {

            driver.switchTo().alert().accept(); //close alert
            driver.switchTo().defaultContent();
            Assert.assertTrue(false);
            logR.info("Login Failed");
        }
        else {
            Assert.assertTrue(true);
            logR.info("Login Passed");
            logInP.clickLogout();
            driver.switchTo().alert().accept(); //close logout alert
            driver.switchTo().defaultContent();
        }
    }

    public boolean isAlertPresent() { //user defined method created to check alert is present or not
        try {
            driver.switchTo().alert();
        }
        catch (NoAlertPresentException e) {
        }
        return false;
    }

    @DataProvider(name = "LoginData")
    String [][] getData() throws IOException {

        String path = System.getProperty("user.dir") + ""; //filePath

        int rowNum = XLUtils.getRowCount(path, "Sheet1");
        int colNum = XLUtils.getCellCount(path, "Sheet1",1);

        String loginData[][] = new String[rowNum][colNum];

        for (int i = 0; i < rowNum; i++) {

            for (int j = 0; j < colNum; i++) {

                loginData[i-1][j] = XLUtils.getCellData(path,"Sheet1",i ,j); // 1 0
            }
        }
        return loginData;
    }
}
