package org.Core;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import io.cucumber.java.Scenario;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;

public class TestContext {
    public static Playwright playwright;
    public static Browser browser;
    public static Page page;
    public static String fileName;
    public static Scenario scenario;
    public static String scenarioName;


}
