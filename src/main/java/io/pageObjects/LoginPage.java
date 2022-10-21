package io.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name ="uid")
    @CacheLookup
    WebElement txtUserID;

    @FindBy(name ="password")
    @CacheLookup
    WebElement txtPassword;

    @FindBy(name ="btnLogin")
    @CacheLookup
    WebElement btnLogin;

    public void setUserID(String uID) {
        txtUserID.sendKeys(uID);
    }

    public void setPassword(String pwd) {
        txtPassword.sendKeys(pwd);
    }

    public void clickSubmit() {
        btnLogin.click();
    }
}
