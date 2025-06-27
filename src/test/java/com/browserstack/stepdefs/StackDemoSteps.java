package com.browserstack.stepdefs;

import com.browserstack.pageobjects.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.testng.Assert;

public class StackDemoSteps {
    private WebDriver driver;
    private HomePage homePage;

    // This method runs before each scenario to set up the WebDriver and HomePage
    //Fpr Sumit Branch
    @Before
    public void setUp() throws MalformedURLException {
        MutableCapabilities capabilities = new MutableCapabilities();
        HashMap<String, String> bstackOptions = new HashMap<>();
        bstackOptions.putIfAbsent("source", "cucumber-java:sample-master:v1.2");
        capabilities.setCapability("bstack:options", bstackOptions);
        // Initialize the RemoteWebDriver with BrowserStack hub URL
        driver = new RemoteWebDriver(
                new URL("https://hub.browserstack.com/wd/hub"), capabilities);
        homePage = new HomePage(driver);
    }

    // Step definition for navigating to a given URL
    @Given("^I am on the website '(.+)'$")
    public void I_am_on_the_website(String url) throws Throwable {
        driver.get(url);
        Thread.sleep(2000); // Wait for the page to load
    }

    // Step definition for selecting a product and adding it to the cart
    @When("^I select a product and click on 'Add to cart' button")
    public void I_select_a_product_and_add_to_cart() throws Throwable {
        homePage.selectFirstProductName();
        homePage.clickAddToCartButton();
        Thread.sleep(2000); // Wait for the cart update
    }

    // Step definition for verifying the product is added to the cart
    @Then("the product should be added to cart")
    public void product_should_be_added_to_cart() {
        homePage.waitForCartToOpen();
        Assert.assertEquals(homePage.getSelectedProductName(), homePage.getProductCartText());
    }

    // Step definition for verifying the page title contains expected text
    @Then("the page title should contain '(.+)'$")
    public void page_title_should_contain(String expectedTitle) {
        Assert.assertTrue(driver.getTitle().contains(expectedTitle));
    }

    // This method runs after each scenario to clean up the WebDriver
    @After
    public void teardown(Scenario scenario) throws Exception {
        Thread.sleep(2000); // Optional wait before quitting
        driver.quit();
    }
}