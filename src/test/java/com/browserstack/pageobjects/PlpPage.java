package com.browserstack.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PlpPage {

    private WebDriver webDriver;

    private String selectedProductName;

    public PlpPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.selectedProductName = "";
    }

    private By productTitles = By.xpath("//p[@class='shelf-item__title']");

    public By vendorBtn(String vendor) {
        return By.xpath("//span[@class='checkmark' and text()='" + vendor + "']");
    }

//    public By productName(String productKeyword) {
//        return By.xpath("//p[@class='shelf-item__title' and contains(text(),'" + productKeyword + "'))]");
//    }

    public List<WebElement> getProductTitles() {
        List<WebElement> products = webDriver.findElements(productTitles);
        return products;
    }

}
