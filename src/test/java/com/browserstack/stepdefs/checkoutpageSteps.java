package com.browserstack.stepdefs;

import com.browserstack.pageobjects.CheckoutPage;
import com.browserstack.pageobjects.HomePage;
import com.browserstack.pageobjects.PlpPage;
import com.browserstack.pageobjects.SignInPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;



public class checkoutpageSteps {

    private WebDriver driver;
    private HomePage homePage;
    private SignInPage signInPage;
    private PlpPage plpPage;
    private CheckoutPage checkoutPage;

    @Given("I am on the website {string}")
    public void i_am_on_the_website(String string) {
        driver.get(string);


    }

    @When("Navigate to Sign In page")
    public void navigate_to_sign_in_page() {
        homePage = new HomePage(driver);
        homePage.clickSignInButton();
    }
    @When("I sign in with valid credentials using <username> and <password>")
    public void i_sign_in_with_valid_credentials(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> credentials = dataTable.asMaps(String.class, String.class);
        String username = credentials.get(0).get("username");
        String password = credentials.get(0).get("password");




    }
    @When("I select a product and click on {string} button")
    public void i_select_a_product_and_click_on_button(String string) {

        plpPage = new PlpPage(driver);
        plpPage.selectProductByName(string);
        plpPage.clickAddToCartButton();


    }
    @When("I proceed to checkout")
    public void i_proceed_to_checkout() {

        plpPage.clickCheckoutButtonFromMiniCart();
        checkoutPage.enterFirstName();
        checkoutPage.enterLastName();
        checkoutPage.enterAddress();
        checkoutPage.enterProvince();
        checkoutPage.enterPostalCode();
        checkoutPage.clickSubmitButton();



    }
    @Then("I should see the order confirmation page")
    public void i_should_see_the_order_confirmation_page() {
        checkoutPage.verifyOrderSuccessMessage();



    }
}
