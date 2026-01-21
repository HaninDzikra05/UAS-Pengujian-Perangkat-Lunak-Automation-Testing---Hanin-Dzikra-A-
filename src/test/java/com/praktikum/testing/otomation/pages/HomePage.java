package com.praktikum.testing.otomation.pages;

import com.praktikum.testing.otomation.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(id = "login2")
    WebElement loginMenu;

    @FindBy(id = "signin2")
    WebElement signupMenu;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickLogin() {
        loginMenu.click();
    }

    public void clickSignup() {
        signupMenu.click();
    }
}
