package com.browserstack.pageobjects;

import org.openqa.selenium.WebDriver;

public class checkoutPage {

    private WebDriver webDriver;

    private String selectedProductName;

    public checkoutPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.selectedProductName = "";
    }


}
