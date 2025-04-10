package com.automation.hooks;

import com.automation.factory.BrowserFactory;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    private Browser browser;
    private BrowserContext context;
    private Page page;

    @Before
    public void setUp() {
        // Use the static method to get the browser
        browser = BrowserFactory.getBrowser("firefox");
        context = browser.newContext();
        page = context.newPage();
    }

    // Provide access for DI
    public Page getPage() {
        return page;
    }

    @After
    public void tearDown() {
        if (page != null) {
            page.close();
            context.close();
            browser.close();
        }
    }
}
