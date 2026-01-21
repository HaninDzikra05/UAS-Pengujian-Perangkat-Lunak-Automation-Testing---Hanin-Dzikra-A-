package com.praktikum.testing.otomation.pages;

import com.praktikum.testing.otomation.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    @FindBy(id = "loginusername")
    WebElement username;

    @FindBy(id = "loginpassword")
    WebElement password;

    @FindBy(xpath = "//button[text()='Log in']")
    WebElement loginBtn;

    // 🔥 untuk testLoginModalDisplayed
    public static final By LOGIN_MODAL_TITLE = By.id("logInModalLabel");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String user, String pass) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // ✅ tunggu field benar-benar bisa diketik
        wait.until(ExpectedConditions.elementToBeClickable(username));
        username.clear();
        username.sendKeys(user);

        password.clear();
        password.sendKeys(pass);

        wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        loginBtn.click();
    }
}
