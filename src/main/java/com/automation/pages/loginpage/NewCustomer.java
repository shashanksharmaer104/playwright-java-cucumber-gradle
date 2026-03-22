package com.automation.pages.loginpage;

import com.automation.pages.AbstractComponent;
import com.automation.pages.commonpage.ContinueButton;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

/**
 * Component representing the 'New Customer' section on the login page.
 * Provides access to the registration path via the Continue button.
 */
public class NewCustomer extends AbstractComponent {

    private final Page page;
    private final ContinueButton continueButton;

    /** Selector for the New Customer section container */
    private final String newCustomerSection = "//div[@class='well' and h2[text()='New Customer']]";

    /**
     * Initializes the NewCustomer component.
     * @param page The Playwright Page instance.
     */
    public NewCustomer(final Page page) {
        this.page = page;
        this.continueButton = new ContinueButton(page);
    }

    /**
     * Gets the ContinueButton component within this section.
     * @return The ContinueButton instance.
     */
    public ContinueButton getContinueButton() {
        return this.continueButton;
    }

    /**
     * Checks if the New Customer section is visible on the page.
     * @return true if visible, false otherwise.
     */
    @Override
    public boolean isDisplayed() {
        return this.page.locator(this.newCustomerSection).isVisible(new Locator.IsVisibleOptions().setTimeout(3000));
    }
}
