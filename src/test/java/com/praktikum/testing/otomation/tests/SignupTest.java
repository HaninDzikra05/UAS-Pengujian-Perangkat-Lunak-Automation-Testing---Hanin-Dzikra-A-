package com.praktikum.testing.otomation.tests;

import com.praktikum.testing.otomation.base.BaseTest;
import com.praktikum.testing.otomation.pages.HomePage;
import com.praktikum.testing.otomation.pages.SignupPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTest extends BaseTest {

    // 1️⃣ Positive - Signup dengan data valid
    @Test
    public void testSignupValid() throws InterruptedException {
        HomePage home = new HomePage(driver);
        home.clickSignup();
        Thread.sleep(1000);

        SignupPage signup = new SignupPage(driver);
        signup.signup("user" + System.currentTimeMillis(), "password123");
        Thread.sleep(2000);

        Assert.assertTrue(driver.switchTo().alert().getText().contains("Sign up successful"));
        driver.switchTo().alert().accept();
    }

    // 2️⃣ Negative - Password kosong
    @Test
    public void testSignupEmptyPassword() throws InterruptedException {
        HomePage home = new HomePage(driver);
        home.clickSignup();
        Thread.sleep(1000);

        SignupPage signup = new SignupPage(driver);
        signup.signup("userEmptyPass", "");
        Thread.sleep(2000);

        Assert.assertTrue(driver.switchTo().alert().getText().contains("Please fill out"));
        driver.switchTo().alert().accept();
    }

    // 3️⃣ Negative - Username kosong
    @Test
    public void testSignupEmptyUsername() throws InterruptedException {
        HomePage home = new HomePage(driver);
        home.clickSignup();
        Thread.sleep(1000);

        SignupPage signup = new SignupPage(driver);
        signup.signup("", "password123");
        Thread.sleep(2000);

        Assert.assertTrue(driver.switchTo().alert().getText().contains("Please fill out"));
        driver.switchTo().alert().accept();
    }

    // 4️⃣ Negative - Username sudah terdaftar
    @Test
    public void testSignupExistingUser() throws InterruptedException {
        HomePage home = new HomePage(driver);
        home.clickSignup();
        Thread.sleep(1000);

        SignupPage signup = new SignupPage(driver);
        signup.signup("existinguser", "password123");
        Thread.sleep(2000);

        Assert.assertTrue(driver.switchTo().alert().getText().contains("already exist"));
        driver.switchTo().alert().accept();
    }

    // 5️⃣ UI Validation - Modal signup tampil
    @Test
    public void testSignupModalDisplayed() throws InterruptedException {
        HomePage home = new HomePage(driver);
        home.clickSignup();
        Thread.sleep(1000);

        Assert.assertTrue(driver.getPageSource().contains("Sign up"),
                "Modal Sign up tidak tampil");
    }
}
