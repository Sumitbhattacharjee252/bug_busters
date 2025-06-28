Feature: Product Listing Page (PLP)

  Scenario Outline: Verify single vendor filter functionality
    Given I am on the website 'https://kolkata.bugbash.live/'
    When I select 'Single Vendor' filter
    Then I should see products from a single vendor only
    Examples:
      | vendor |
    | Vendor A |
