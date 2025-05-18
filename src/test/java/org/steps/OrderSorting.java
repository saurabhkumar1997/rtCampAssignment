package org.Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.Core.TestContext;
import org.Utils.TestDataUtil;

public class OrderSorting extends org.Pages.OrderSortingPage {

    @Given("the user is logged in")
    public void theUserIsLoggedIn() {
       String UserName = TestDataUtil.gettestdata(fileName,scenarioName,"UserName");
        String Password = TestDataUtil.gettestdata(fileName,scenarioName,"Password");

        login(UserName, Password);
    }
    @When("the user clicks on the Filter icon and selects the {string} filter option.")
    public void theUserClicksOnTheIconAndSelectsTheFilterOption(String value) {
        selectFilteroption(value);
    }


    @And("the user captures the list of product names displayed on the page")
    public void theUserCapturesTheListOfProductNamesDisplayedOnThePage() {
        getProductList();
    }

    @Then("the product names should be displayed in descending alphabetical order")
    public void theProductNamesShouldBeDisplayedInDescendingAlphabeticalOrder() {
        assertListInDescendingOrder();
    }


}
