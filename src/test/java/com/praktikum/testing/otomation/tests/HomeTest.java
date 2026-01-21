package com.praktikum.testing.otomation.tests;

import com.praktikum.testing.otomation.base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest {

    // 1️⃣ Verify Home Page Title
    @Test
    public void testHomePageTitle() {
        Assert.assertTrue(driver.getTitle().contains("STORE"),
                "Home page title tidak sesuai");
    }

    // 2️⃣ Verify Navbar Exists
    @Test
    public void testNavbarVisible() {
        Assert.assertTrue(
                driver.findElement(By.id("navbarExample")).isDisplayed(),
                "Navbar tidak tampil"
        );
    }

    // 3️⃣ Verify Categories Section Visible
    @Test
    public void testCategoriesSectionVisible() {
        Assert.assertTrue(
                driver.getPageSource().contains("CATEGORIES"),
                "Section Categories tidak ditemukan"
        );
    }

    // 4️⃣ Verify Phones Category Clickable
    @Test
    public void testPhonesCategoryClickable() throws InterruptedException {
        driver.findElement(By.linkText("Phones")).click();
        Thread.sleep(1500);

        Assert.assertTrue(
                driver.getPageSource().contains("Samsung") ||
                        driver.getPageSource().contains("Nokia"),
                "Produk Phones tidak muncul"
        );
    }

    // 5️⃣ Verify Laptops Category Clickable
    @Test
    public void testLaptopsCategoryClickable() throws InterruptedException {
        driver.findElement(By.linkText("Laptops")).click();
        Thread.sleep(1500);

        Assert.assertTrue(
                driver.getPageSource().contains("Sony") ||
                        driver.getPageSource().contains("Dell"),
                "Produk Laptops tidak muncul"
        );
    }
}
