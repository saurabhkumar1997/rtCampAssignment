package org.Pages;

import com.microsoft.playwright.Locator;
import org.Core.TestContext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PriceSortingPage extends TestContext {

    private final Locator priceList = page.locator("//div[@class='inventory_item_price']");

    // Declare this to hold parsed prices (usable for assertions)
    public static List<Double> priceText;

    // Method to get the price list and convert to List<Double>
    public void getPriceList() {
        List<String> rawPrices = priceList.allInnerTexts();  // <-- This is a local variable

        // Parse string prices like "$49.99" to Double
        priceText = rawPrices.stream()
                .map(p -> Double.parseDouble(p.replace("$", "").trim()))
                .collect(Collectors.toList());

        System.out.println("Prices from page: " + priceText);
    }

    // Assertion to check prices sorted from high to low
    public static void assertPricesSortedHighToLow() {
        List<Double> sortedPrices = new ArrayList<>(priceText);
        sortedPrices.sort(Collections.reverseOrder());

        if (!priceText.equals(sortedPrices)) {
            throw new AssertionError("Prices are NOT sorted from high to low.\nExpected: " +
                    sortedPrices + "\nActual: " + priceText);
        } else {
            System.out.println("Prices are sorted from high to low.");
        }
    }
}

