package com.automation.factory;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.PlaywrightException;

public class BrowserFactory {

    public static Browser getBrowser(String browserType) {
        Playwright playwright = null;
        Browser browser = null;
        try {
            playwright = Playwright.create();
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
        } catch (PlaywrightException e) {
            System.err.println("Failed to launch browser: " + e.getMessage());
            if (playwright != null) {
                playwright.close();
            }
        } finally {
            if (playwright != null && browser == null) {
                playwright.close();
            }
        }
        return browser;
    }
}
