package com.praktikum.testing.otomation.tests;

import com.praktikum.testing.otomation.base.BaseTest;
import com.praktikum.testing.otomation.pages.HomePage;
import com.praktikum.testing.otomation.pages.LoginPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends BaseTest {

    // 1 Negative - Username tidak terdaftar
    @Test
    public void testLoginUnregisteredUser() {
        HomePage home = new HomePage(driver);
        home.clickLogin();

        LoginPage login = new LoginPage(driver);
        login.login("userTidakAda123", "password123");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        String alertText = alert.getText();
        Assert.assertTrue(
                alertText.toLowerCase().contains("not exist"),
                "Pesan alert tidak sesuai: " + alertText
        );

        alert.accept();
    }

    // 2 Negative - Username & Password kosong
    @Test
    public void testLoginEmptyCredentials() {
        HomePage home = new HomePage(driver);
        home.clickLogin();

        LoginPage login = new LoginPage(driver);
        login.login("", "");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        String alertText = alert.getText();
        Assert.assertTrue(
                alertText.toLowerCase().contains("fill"),
                "Pesan alert tidak sesuai: " + alertText
        );

        alert.accept();
    }

    // 3 UI Validation - Modal Login tampil
    @Test
    public void testLoginModalDisplayed() {
        HomePage home = new HomePage(driver);
        home.clickLogin();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        boolean isDisplayed = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        LoginPage.LOGIN_MODAL_TITLE
                )
        ).isDisplayed();

        Assert.assertTrue(isDisplayed, "Modal Login tidak tampil");
    }
}