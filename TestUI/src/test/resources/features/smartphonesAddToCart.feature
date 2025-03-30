Feature: Adding smartphone to cart

  Scenario: Add a phone without subscription to the cart
    Given user open a Web Browser
    When go to main page
    And click "Smartphones" from the section "No subscription"
    And click at product number 1
    And add product to cart
    And returns to the main page
    Then cart must contains exactly one product