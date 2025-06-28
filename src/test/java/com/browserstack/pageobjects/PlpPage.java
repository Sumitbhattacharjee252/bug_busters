package com.browserstack.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PlpPage {

    private WebDriver webDriver;

    private String selectedProductName;

    private By ProductList = By.xpath("//p[@class='shelf-item__title']");
    private By AddToCartButton = By.xpath("//button[@class='shelf-item__buy-btn']");
    private By checkoutbuttonfromminicart = By.xpath("//div[@class='buy-btn']");

    public PlpPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.selectedProductName = "";


    }

    public void selectProductByName(String productName) {
        List<WebElement> products = webDriver.findElements(ProductList);
        for (WebElement product : products) {
            if (product.getText().equalsIgnoreCase(productName)) {
                selectedProductName = product.getText();
                product.click();
                break;
            }


        }

    }

    public void clickAddToCartButton() {
        webDriver.findElement(AddToCartButton).click();


    }

    public void clickCheckoutButtonFromMiniCart() {
        webDriver.findElement(checkoutbuttonfromminicart).click();
    }
}
