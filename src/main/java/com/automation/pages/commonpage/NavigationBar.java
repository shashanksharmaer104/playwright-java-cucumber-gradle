package com.automation.pages.commonpage;

import com.automation.pages.AbstractComponent;
import com.microsoft.playwright.Page;

public class NavigationBar extends AbstractComponent {

    private Page page;

    private final String navigationBar = "//*[@id='menu']";
    private final String subNavigationBar = "//ul[contains(@class,'navbar-nav')]";

    public NavigationBar(final Page page) {
        this.page = page;
    }

    public void clickDesktops() {
        this.page.locator(this.navigationBar)
                .locator(this.subNavigationBar)
                .locator("//a[text()='Desktops']");
    }

    @Override
    public boolean isDisplayed() {
        return false;
    }
}
