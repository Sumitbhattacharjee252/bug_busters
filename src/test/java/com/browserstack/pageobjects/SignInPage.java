package com.browserstack.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {

    private WebDriver webDriver;

    private String selectedProductName;

    public SignInPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.selectedProductName = "";
    }

    private By signInUsername = By.xpath("(//div[@id='username'])[1]");
    private By signInPassword = By.xpath("(//div[@id='password']");
    private By signInButton = By.xpath("//button[@id='login-btn']");
    private By usernameOption = By.xpath("//li[text()='your-username']");
    private By passwordOption = By.xpath("//li[text()='your-password']");


    public void selectUsername(String username) {
        webDriver.findElement(signInButton).click();
        webDriver.findElement(By.xpath("//li[text()='" + username + "']")).click();
    }

    public void selectPassword(String password) {
        webDriver.findElement(signInPassword).click();
        webDriver.findElement(By.xpath("//li[text()='" + password + "']")).click();
    }

    public void submitSignIn() {
        webDriver.findElement(signInButton).click();
    }





}
