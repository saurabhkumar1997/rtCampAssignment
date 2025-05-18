package org.Pages;

import com.microsoft.playwright.Locator;
import org.Utils.ScreenshotHelper;
import org.junit.jupiter.api.Assertions;
import org.Core.TestContext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class OrderSortingPage extends TestContext {

    private final Locator usernameInput = page.locator("#user-name");
    private final Locator passwordInput = page.locator("#password");
    private final Locator loginButton= page.locator("#login-button");
    private final Locator homePageTitle = page.locator("text=Swag Labs");
    private final String sortDropdown = "select[data-test='product-sort-container']";
    private final Locator productList =page.locator( "//div[@class='inventory_item_name ']");
    // Actions
    public void login(String username, String password) {
        usernameInput.fill(username);
        passwordInput.fill(password);
        loginButton.click();

        // Assertion: Verify the home page title is displayed after login
        String actualTitle = homePageTitle.textContent();
      //  System.out.println("actualTitle "+ actualTitle);
        Assertions.assertEquals("Swag Labs", actualTitle, "Home page title mismatch after login");
    }
    public void selectFilteroption(String value){
        page.selectOption(sortDropdown, value);

    }
    public static  List<String> productname;
    public void getProductList()
    {
         productname= productList.allInnerTexts();

    }

    public static void assertListInDescendingOrder() {
        List<String> sortedList = new ArrayList<>(productname);
        sortedList.sort(Collections.reverseOrder());

        if (!productname.equals(sortedList)) {
            throw new AssertionError("List is not in descending order.\nExpected: " +
                    sortedList + "\nActual: " + productname);
        } else {
            System.out.println("List is in descending alphabetical order.");
        }
    }
}
