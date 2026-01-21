package com.praktikum.testing.otomation.pages;

import com.praktikum.testing.otomation.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    @FindBy(xpath = "//button[text()='Place Order']")
    WebElement placeOrderBtn;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void clickPlaceOrder() {
        placeOrderBtn.click();
    }
}
