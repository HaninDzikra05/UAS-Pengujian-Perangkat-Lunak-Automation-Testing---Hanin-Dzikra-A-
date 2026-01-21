package com.praktikum.testing.otomation.tests;

import com.praktikum.testing.otomation.base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    // 1️⃣ Navigation - Cart page bisa dibuka
    @Test
    public void testCartPageAccessible() throws InterruptedException {
        driver.findElement(By.id("cartur")).click();
        Thread.sleep(2000);

        Assert.assertTrue(driver.getCurrentUrl().contains("cart"),
                "Halaman Cart tidak terbuka");
    }



    // 5️⃣ Verify Place Order button tampil
    @Test
    public void testPlaceOrderButtonVisible() throws InterruptedException {
        driver.findElement(By.id("cartur")).click();
        Thread.sleep(2000);

        Assert.assertTrue(driver.getPageSource().contains("Place Order"),
                "Button Place Order tidak tampil");
    }
}
