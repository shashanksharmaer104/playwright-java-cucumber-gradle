package com.automation.factory;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

public class BrowserFactory {

    // Static method to get a browser instance
    public static Browser getBrowser(String browserType) {
        Playwright playwright = Playwright.create();
        Browser browser;
        switch (browserType.toLowerCase()) {
            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "webkit":
                browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "chromium":
            default:
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
        }
        return browser;
    }
}
