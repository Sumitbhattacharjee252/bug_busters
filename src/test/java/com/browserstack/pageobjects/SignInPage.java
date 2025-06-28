package com.browserstack.pageobjects;

import org.openqa.selenium.WebDriver;

public class SignInPage {

    private WebDriver webDriver;

    private String selectedProductName;

    public SignInPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.selectedProductName = "";
    }


}
