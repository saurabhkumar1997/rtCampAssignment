Feature: Verify the price order on the “All Items” page.
  Background:
    Given the user is logged in
    @smoke
    Scenario: Verify the price order (high-low) displayed on the “All Items” page.
      When the user clicks on the Filter icon and selects the "Price (high to low)" filter option.
      And the user extract all items price on the page.
      Then the product price should be displayed in descending order.
