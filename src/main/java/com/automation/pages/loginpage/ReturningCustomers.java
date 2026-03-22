package com.automation.pages.loginpage;

import com.automation.pages.AbstractComponent;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ReturningCustomers extends AbstractComponent {

    private Page page;

    private final String returningCustomersSection = "(//div[@class='well'])[2]";
    private final String emailTextBox = "E-Mail Address";
    private final String passwordTextBox = "Password";
    private final String submitBtn = "//input[@id='input-password']";

    public ReturningCustomers(final Page page) {
        this.page = page;
    }

    public void enterEmail(final String email) {
        this.page.getByPlaceholder(this.emailTextBox).fill(email);
    }

    public void enterPassword(final String password) {
        this.page.getByPlaceholder(this.passwordTextBox).fill(password);
    }

    public void clickSubmitBtn() {
        this.page.click(this.submitBtn);
        this.page.waitForTimeout(3000);
    }

    @Override
    public boolean isDisplayed() {
        return this.page.locator(this.returningCustomersSection).isEnabled(new Locator.IsEnabledOptions().setTimeout(3000));
    }

}
