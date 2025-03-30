Feature: Validation of course data

  Scenario: API response and rate data verification
    Given I am getting the exchange rates from table A
    Then Check if the currency list is not empty
    And Check that the number of currencies with a rate below 3.0 is 28
    And Check that the number of currencies with a rate above 5.0 is 2
    Then Displaying the exchange rate for the currency with code "USD"
    And Displaying the exchange rate for the currency named "dolar amerykański"
    And Displaying currencies with rates above 5.0
    And Displaying currencies with rates below 3.0
