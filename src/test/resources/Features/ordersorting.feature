Feature: Sorting items on the All Items page

  Background:
    Given the user is logged in
@smoke
  Scenario: Verify the sorting order displayed for Z-A on the “All Items” page
    When the user clicks on the Filter icon and selects the "Name (Z to A)" filter option.
    And the user captures the list of product names displayed on the page
    Then the product names should be displayed in descending alphabetical order
