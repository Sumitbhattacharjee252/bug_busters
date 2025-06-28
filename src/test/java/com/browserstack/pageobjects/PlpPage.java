package com.browserstack.pageobjects;

import org.openqa.selenium.WebDriver;

public class PlpPage {

    private WebDriver webDriver;

    private String selectedProductName;

    public PlpPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.selectedProductName = "";
    }


}
