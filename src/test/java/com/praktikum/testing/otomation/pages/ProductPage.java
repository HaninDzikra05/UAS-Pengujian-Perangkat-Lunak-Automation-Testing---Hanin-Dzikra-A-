package com.praktikum.testing.otomation.pages;

import com.praktikum.testing.otomation.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    @FindBy(linkText = "Add to cart")
    WebElement addToCart;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void addProductToCart() {
        addToCart.click();
    }
}
