Feature: Search on different search engines

  Scenario: Perform a search on Google
    Given I am on the "google" search engine homepage
    When I search for "Cucumber testing"
    Then the first result should contain "Cucumber"

  Scenario: Perform a search on Yahoo
    Given I am on the "yahoo" search engine homepage
    When I search for "Java programming"
    Then the first result should contain "Java"
