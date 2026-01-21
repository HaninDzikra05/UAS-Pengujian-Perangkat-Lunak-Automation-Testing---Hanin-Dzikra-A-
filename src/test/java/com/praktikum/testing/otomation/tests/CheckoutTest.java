package com.praktikum.testing.otomation.tests;

import com.praktikum.testing.otomation.base.BaseTest;
import com.praktikum.testing.otomation.pages.CartPage;
import com.praktikum.testing.otomation.pages.CheckoutPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    @Test
    public void testCheckout() throws InterruptedException {
        driver.findElement(By.id("cartur")).click();
        Thread.sleep(2000);

        CartPage cart = new CartPage(driver);
        cart.clickPlaceOrder();
        Thread.sleep(1000);

        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.fillForm();
        Thread.sleep(2000);

        Assert.assertTrue(driver.getPageSource().contains("Thank you"));
    }
}

