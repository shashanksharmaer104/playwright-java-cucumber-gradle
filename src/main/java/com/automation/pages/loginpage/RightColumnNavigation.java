package com.automation.pages.loginpage;

import com.automation.pages.AbstractComponent;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

/**
 * Component representing the right navigation column found on login and account pages.
 * Provides methods to interact with various account-related links.
 */
public class RightColumnNavigation extends AbstractComponent {

    private final Page page;

    /** Selector for the right column container */
    private final String columnRight = "#column-right";

    /**
     * Initializes the RightColumnNavigation component.
     * @param page The Playwright Page instance.
     */
    public RightColumnNavigation(final Page page) {
        this.page = page;
    }

    /**
     * Helper method to locate a link within the right column by its accessible name.
     * @param name The text content or aria-label of the link.
     * @return A Playwright Locator for the specific link.
     */
    private Locator getLink(String name) {
        return this.page.locator(this.columnRight).getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName(name).setExact(true));
    }

    /** Clicks the 'Login' link in the right column. */
    public void clickLogin() {
        getLink("Login").click();
    }

    /** Clicks the 'Register' link in the right column. */
    public void clickRegister() {
        getLink("Register").click();
    }

    /** Clicks the 'Forgotten Password' link in the right column. */
    public void clickForgottenPassword() {
        getLink("Forgotten Password").click();
    }

    /** Clicks the 'My Account' link in the right column. */
    public void clickMyAccount() {
        getLink("My Account").click();
    }

    /** Clicks the 'Address Book' link in the right column. */
    public void clickAddressBook() {
        getLink("Address Book").click();
    }

    /** Clicks the 'Wish List' link in the right column. */
    public void clickWishList() {
        getLink("Wish List").click();
    }

    /** Clicks the 'Order History' link in the right column. */
    public void clickOrderHistory() {
        getLink("Order History").click();
    }

    /** Clicks the 'Downloads' link in the right column. */
    public void clickDownloads() {
        getLink("Downloads").click();
    }

    /** Clicks the 'Recurring payments' link in the right column. */
    public void clickRecurringPayments() {
        getLink("Recurring payments").click();
    }

    /** Clicks the 'Reward Points' link in the right column. */
    public void clickRewardPoints() {
        getLink("Reward Points").click();
    }

    /** Clicks the 'Returns' link in the right column. */
    public void clickReturns() {
        getLink("Returns").click();
    }

    /** Clicks the 'Transactions' link in the right column. */
    public void clickTransactions() {
        getLink("Transactions").click();
    }

    /** Clicks the 'Newsletter' link in the right column. */
    public void clickNewsletter() {
        getLink("Newsletter").click();
    }

    /**
     * Checks if the right column navigation container is visible on the page.
     * @return true if visible, false otherwise.
     */
    @Override
    public boolean isDisplayed() {
        return this.page.locator(this.columnRight).isVisible(new Locator.IsVisibleOptions().setTimeout(3000));
    }
}
