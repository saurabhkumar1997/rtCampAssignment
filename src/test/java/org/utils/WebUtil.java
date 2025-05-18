package org.Utils;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.Core.TestContext;

public class WebUtil extends TestContext {
    public static void webInit() {
         playwright = Playwright.create();
         browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

         page = browser.newPage();
        page.navigate("https://www.saucedemo.com/");


    }

    public static void webTearDown(){
        browser.close();
        playwright.close();
    }
}
