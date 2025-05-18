package org.Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class PriceSorting extends org.Pages.PriceSortingPage {


    @And("the user extract all items price on the page.")
    public void theUserExtractAllItemsPriceOnThePage() {
        getPriceList();

    }


    @Then("the product price should be displayed in descending order.")
    public void theProductPriceShouldBeDisplayedInDescendingOrder() {
        assertPricesSortedHighToLow();
    }
}
