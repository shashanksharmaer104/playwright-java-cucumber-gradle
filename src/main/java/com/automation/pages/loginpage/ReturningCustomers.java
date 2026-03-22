package com.automation.pages.loginpage;

import com.automation.pages.AbstractComponent;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

/**
 * Component representing the 'Returning Customers' section on the login page.
 * Provides methods for user authentication including entering credentials and submitting the login form.
 */
public class ReturningCustomers extends AbstractComponent {

    private final Page page;

    private final String returningCustomersSection = "(//div[@class='well'])[2]";
    private final String emailTextBox = "E-Mail Address";
    private final String passwordTextBox = "Password";
    private final String submitBtn = "//input[@id='input-password']";

    /**
     * Initializes the ReturningCustomers component.
     * @param page The Playwright Page instance.
     */
    public ReturningCustomers(final Page page) {
        this.page = page;
    }

    /**
     * Enters the email address into the email input field.
     * @param email The email address to enter.
     */
    public void enterEmail(final String email) {
        this.page.getByPlaceholder(this.emailTextBox).fill(email);
    }

    /**
     * Enters the password into the password input field.
     * @param password The password to enter.
     */
    public void enterPassword(final String password) {
        this.page.getByPlaceholder(this.passwordTextBox).fill(password);
    }

    /**
     * Clicks the login submit button.
     */
    public void clickSubmitBtn() {
        this.page.click(this.submitBtn);
    }

    /**
     * Checks if the Returning Customers section is displayed and enabled.
     * @return true if enabled, false otherwise.
     */
    @Override
    public boolean isDisplayed() {
        return this.page.locator(this.returningCustomersSection).isEnabled(new Locator.IsEnabledOptions().setTimeout(3000));
    }

}
