Feature: Add highest priced item to cart

  Scenario: User adds highest priced item to cart
    Given user login to SauceDemo with username "standard_user" and password "secret_sauce"
    When user add the highest priced item to the cart
    Then user see correct item should be displayed in the cart