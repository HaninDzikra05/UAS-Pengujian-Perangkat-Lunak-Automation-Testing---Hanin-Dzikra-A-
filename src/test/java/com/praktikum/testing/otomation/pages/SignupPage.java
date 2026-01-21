package com.praktikum.testing.otomation.pages;

import com.praktikum.testing.otomation.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignupPage extends BasePage {

    @FindBy(id = "sign-username")
    WebElement username;

    @FindBy(id = "sign-password")
    WebElement password;

    @FindBy(xpath = "//button[text()='Sign up']")
    WebElement signupBtn;

    public SignupPage(WebDriver driver) {
        super(driver);
    }

    public void signup(String user, String pass) {
        username.sendKeys(user);
        password.sendKeys(pass);
        signupBtn.click();
    }
}
