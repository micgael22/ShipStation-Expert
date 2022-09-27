package org.allureTestNG;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.ByteArrayInputStream;
import java.util.UUID;

public class AllureListenerNew extends TestListenerAdapter {

   @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Executing Listener on failure");
        WebDriver driver = GoogleSearch.getDriverFromContext(result.getTestContext());

        try {
            Allure.addAttachment(UUID.randomUUID().toString(),
                    new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
