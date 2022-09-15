Feature: MMT Page Validation


@Testing
  Scenario: Verify the fields and Errors of the Contact Page
    Given user is on the HomePage of the MMT site
    When user click on the "from" and enter "Delhi" on flight page
    And  user click on the "to" and enter "Mumbai" on  flight page
    Then user click on Search
    When user click on Sort by "Departure"
    Then user print the airline Name
    And print the second lowest Price
    #Then Close the browser
