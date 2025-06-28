Feature: Checkout flow

  Scenario: Place order after sign in
    Given I am on the website 'https://kolkata.bugbash.live/'
    When Navigate to Sign In page
    Then I should see the Sign In page
    When I sign in with valid credentials using <username> and <password>
    Then I should see the home page
    When I sign in with valid credentials using <username> and <password>
    And I select a product and click on 'Add to cart' button
    And I proceed to checkout
    Then I should see the order confirmation page
      | username               | password       |
      | demouser               | testingisfun99 |
      | image_not_loading_user | testingisfun99 |
      | existing_orders_user   | testingisfun99 |
      | fav_user               | testingisfun99 |
      | locked_user            | testingisfun99 |