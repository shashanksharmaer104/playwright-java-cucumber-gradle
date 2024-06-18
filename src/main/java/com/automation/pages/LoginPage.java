package com.automation.pages;

import com.microsoft.playwright.Page;

public class LoginPage {

    private Page page;

    private final String usernameTxtBox = "//input[@id='input-email']";
    private final String passwordTxtBox = "//input[@id='input-password']";
    private final String submitBtn = "//input[@id='input-password']";

    //Constructor
    public LoginPage(final Page page) {
        this.page = page;
    }

    public void enterUsername(String username) {
        page.fill(usernameTxtBox, username);
    }

    public void enterPassword(String password) {
        page.fill(passwordTxtBox, password);
    }

    public void clickSubmit() {
        page.click(submitBtn);
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickSubmit();
    }


}
