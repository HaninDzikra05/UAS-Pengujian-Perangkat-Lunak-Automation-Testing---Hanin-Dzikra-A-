package com.praktikum.testing.otomation.pages;

import com.praktikum.testing.otomation.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {

    @FindBy(id = "name")
    WebElement name;
    @FindBy(id = "country")
    WebElement country;
    @FindBy(id = "city")
    WebElement city;
    @FindBy(id = "card")
    WebElement card;
    @FindBy(id = "month")
    WebElement month;
    @FindBy(id = "year")
    WebElement year;
    @FindBy(xpath = "//button[text()='Purchase']")
    WebElement purchaseBtn;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void fillForm() {
        name.sendKeys("Hanindya");
        country.sendKeys("Indonesia");
        city.sendKeys("Cilacap");
        card.sendKeys("1234567890");
        month.sendKeys("12");
        year.sendKeys("2026");
        purchaseBtn.click();
    }
}