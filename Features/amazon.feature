Feature: Amazon Search
  Scenario: Search Nikon and verify product details
    Given I launch chrome browser and navigate to "https://www.amazon.com/"
    When I search for "Nikon" and sort results by highest price
    And I select the second product
    Then I verify that the product topic contains "Nikon D3X" and close the browser
