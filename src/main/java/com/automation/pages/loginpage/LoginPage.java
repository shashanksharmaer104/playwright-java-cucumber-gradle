package com.automation.pages.loginpage;

import com.microsoft.playwright.Page;

public class LoginPage {

    private Page page;

    private ReturningCustomers returningCustomers;

    //Constructor
    public LoginPage(final Page page) {
        this.page = page;
        this.returningCustomers = new ReturningCustomers(page);
    }

    public ReturningCustomers getReturningCustomers() {
        return this.returningCustomers;
    }

}
