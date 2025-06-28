package com.browserstack.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    private WebDriver webDriver;

    private String selectedProductName;

    public CheckoutPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.selectedProductName = "";

    }

    private By checkoutpage_firstname = By.xpath("//input[@id='firstNameInput']");
    private By checkoutpage_lastname = By.xpath("//input[@id='lastNameInput']");
    private By checkoutpage_address = By.xpath("//input[@id='addressInput']");
    private By checkoutpage_province = By.xpath("//input[@id='provinceInput']");
    private By checkoutpage_postalcode = By.xpath("//input[@id='postalCodeInput']");
    private By getCheckoutpage_submitButton = By.xpath("//button[@id='submitOrderButton']");
    private By ordersuccess_message = By.xpath("//div[@class='order-success__message']");

    public void enterFirstName() {
        webDriver.findElement(checkoutpage_firstname).sendKeys("TestUser");
    }

    public void enterLastName() {
        webDriver.findElement(checkoutpage_lastname).sendKeys("LastName");
    }

    public void enterAddress() {
        webDriver.findElement(checkoutpage_address).sendKeys("Hyland Park");
    }

    public void enterProvince() {
        webDriver.findElement(checkoutpage_province).sendKeys("West Bengal");
    }

    public void enterPostalCode() {
        webDriver.findElement(checkoutpage_postalcode).sendKeys("700001");
    }
    public void clickSubmitButton() {
        webDriver.findElement(getCheckoutpage_submitButton).click();
    }

    public void verifyOrderSuccessMessage() {
        String successMessage = webDriver.findElement(ordersuccess_message).getText();
        if (!successMessage.contains("Your Order has been successfully placed.")) {
            throw new AssertionError("Order success message not displayed as expected.");
        }
    }




}
