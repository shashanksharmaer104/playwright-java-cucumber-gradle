package com.automation.pages.loginpage;

import com.microsoft.playwright.Page;

public class LoginPage {

    private Page page;

    private ReturningCustomers returningCustomers;
    private NewCustomer newCustomer;
    private RightColumnNavigation rightColumnNavigation;

    //Constructor
    public LoginPage(final Page page) {
        this.page = page;
        this.returningCustomers = new ReturningCustomers(page);
        this.newCustomer = new NewCustomer(page);
        this.rightColumnNavigation = new RightColumnNavigation(page);
    }

    public ReturningCustomers getReturningCustomers() {
        return this.returningCustomers;
    }

    public NewCustomer getNewCustomer() {
        return this.newCustomer;
    }

    public RightColumnNavigation getRightColumnNavigation() {
        return this.rightColumnNavigation;
    }

}
