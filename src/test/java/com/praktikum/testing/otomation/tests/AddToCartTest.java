package com.praktikum.testing.otomation.tests;

import com.praktikum.testing.otomation.base.BaseTest;
import com.praktikum.testing.otomation.pages.ProductPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseTest {

    // 3️⃣ Positive - Add Laptop Sony Vaio
    @Test
    public void testAddLaptopToCart() throws InterruptedException {
        driver.findElement(By.linkText("Laptops")).click();
        Thread.sleep(1000);

        driver.findElement(By.linkText("Sony vaio i5")).click();
        Thread.sleep(2000);

        ProductPage product = new ProductPage(driver);
        product.addProductToCart();
        Thread.sleep(2000);

        Assert.assertTrue(driver.switchTo().alert().getText().contains("Product added"));
        driver.switchTo().alert().accept();
    }

    // 5️⃣ Navigation - Cart menu accessible
    @Test
    public void testNavigateToCartPage() throws InterruptedException {
        driver.findElement(By.id("cartur")).click();
        Thread.sleep(2000);

        Assert.assertTrue(
                driver.getCurrentUrl().contains("cart"),
                "Halaman Cart tidak terbuka"
        );
    }
}
