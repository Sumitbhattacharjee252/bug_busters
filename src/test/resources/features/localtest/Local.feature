Feature: Verify Local test

  Scenario Outline: BStack Local Test - Navigate to Local App page
    Given I am on the website 'http://bs-local.com:45454/'
    Then the page title should contain 'BrowserStack Local'
    Examples:
      | browserName | browserVersion | os          | osVersion |
      | chrome      | latest         | Windows     | 10        |
      | firefox     | latest         | macOS       | 11.0      |
      | safari      | latest         | macOS       | 11.0      |
      | edge        | latest         | Windows     | 10        |
      | internet explorer | latest   | Windows     | 10        |
      | opera       | latest         | Windows     | 10        |
