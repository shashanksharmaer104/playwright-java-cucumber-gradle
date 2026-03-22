package com.automation.pages.commonpage;

import com.automation.pages.AbstractComponent;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ContinueButton extends AbstractComponent {

    private Page page;

    private final String continueBtn = "Continue";

    public ContinueButton(final Page page) {
        this.page = page;
    }

    public void clickContinueBtn() {
        this.page.click(this.continueBtn);
    }

    @Override
    public boolean isDisplayed() {
        return this.page.locator(this.continueBtn).isEnabled(new Locator.IsEnabledOptions().setTimeout(3000));
    }
}
