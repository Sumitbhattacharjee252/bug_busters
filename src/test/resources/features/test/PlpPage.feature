Feature: Product Listing Page (PLP)
  # This feature file tests the product listing page (PLP) functionality

  Background:
    Given I am on the website 'https://kolkata.bugbash.live/'

  @PLP
  Scenario Outline: Verify single vendor filter functionality
    When I select vendor '<vendor>' filter
    Then I should see '<productKeyword>' products only
    Examples:
      | vendor  | productKeyword |
      | Apple   | iPhone         |
      | Samsung | Galaxy         |
      | Google  | Pixel          |
      | OnePlus | One Plus       |