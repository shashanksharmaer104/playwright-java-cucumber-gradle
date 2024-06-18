package com.automation.stepdefs;

import com.automation.pages.LoginPage;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDef {

    private Playwright playwright;
    private Browser browser;
    private Page page;
    private LoginPage loginPage;

    @Before
    public void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );
        page = browser.newPage();
    }

    @After
    public void tearDown() {
        if (page != null) {
            // close sessions
            page.close();
            browser.close();
            playwright.close();
        }
    }

    @Given("I am on OpenCart login page")
    public void i_am_on_open_cart_login_page() {
        page.navigate("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
        loginPage = new LoginPage(page);
    }
    @Given("I have entered a valid username and password")
    public void i_have_entered_a_valid_username_and_password() {
        loginPage.enterUsername("qatestertest@gmail.com");
        loginPage.enterPassword("Test@123");
    }
    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        loginPage.clickSubmit();
    }
    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        System.out.println("Test");
    }

}
