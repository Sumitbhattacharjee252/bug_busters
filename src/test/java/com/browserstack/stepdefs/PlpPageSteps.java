package com.browserstack.stepdefs;

import com.browserstack.pageobjects.PlpPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import java.net.URL;
import java.util.HashMap;
import java.util.List;

/**
 * Step definitions for Product Listing Page (PLP) feature.
 * Uses Cucumber and Selenium WebDriver with the Page Object Model.
 */
public class PlpPageSteps {

    private WebDriver driver;
    private PlpPage plpPage;

    /**
     * Initializes WebDriver and PlpPage before each scenario.
     */
    @Before
    public void setUp() throws Exception {
        MutableCapabilities capabilities = new MutableCapabilities();
        HashMap<String, String> bstackOptions = new HashMap<>();
        bstackOptions.putIfAbsent("source", "cucumber-java:sample-master:v1.2");
        capabilities.setCapability("bstack:options", bstackOptions);
        driver = new RemoteWebDriver(
                new URL("https://hub.browserstack.com/wd/hub"), capabilities);
        plpPage = new PlpPage(driver);
    }

    /**
     * Selects the vendor filter on the PLP.
     * @param vendor the vendor name to filter by
     */
    @When("^I select vendor '(.+)' filter$")
    public void i_select_vendor_filter(String vendor) {
        // Click the vendor filter button
        WebElement vendorElement = driver.findElement(plpPage.vendorBtn(vendor));
        vendorElement.click();
    }

    /**
     * Verifies that only products matching the keyword are displayed.
     * @param productKeyword the keyword expected in product names
     */
    @Then("^I should see '(.+)' products only$")
    public void i_should_see_products_only(String productKeyword) {
        // Find all product title elements
        List<WebElement> products = plpPage.getProductTitles();
        Assert.assertFalse(products.isEmpty(), "No products found for the selected vendor.");
        for (WebElement product : products) {
            // Assert each product contains the expected keyword
            Assert.assertTrue(product.getText().contains(productKeyword),
                    "Product does not contain the expected keyword: " + productKeyword);
        }
    }

    /**
     * Quits the WebDriver after each scenario.
     */
    @After
    public void tearDown() throws Exception {
        if (driver != null) {
            driver.quit();
        }
    }
}