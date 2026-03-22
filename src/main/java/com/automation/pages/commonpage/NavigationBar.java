package com.automation.pages.commonpage;

import com.automation.pages.AbstractComponent;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

/**
 * Component representing the main horizontal navigation bar (Categories menu).
 * Provides methods to navigate through various product categories.
 */
public class NavigationBar extends AbstractComponent {

    private final Page page;

    /** Selector for the main navigation menu container */
    private final String menuContainer = "nav#menu";

    /**
     * Initializes the NavigationBar component.
     * @param page The Playwright Page instance.
     */
    public NavigationBar(final Page page) {
        this.page = page;
    }

    /**
     * Helper method to locate a category link within the navigation bar by its name.
     * @param name The text content of the category link.
     * @return A Playwright Locator for the specific category link.
     */
    private Locator getCategoryLink(String name) {
        return this.page.locator(this.menuContainer).getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName(name).setExact(true));
    }

    /** Clicks the 'Desktops' category link. */
    public void clickDesktops() {
        getCategoryLink("Desktops").click();
    }

    /** Clicks the 'Laptops & Notebooks' category link. */
    public void clickLaptopsAndNotebooks() {
        getCategoryLink("Laptops & Notebooks").click();
    }

    /** Clicks the 'Components' category link. */
    public void clickComponents() {
        getCategoryLink("Components").click();
    }

    /** Clicks the 'Tablets' category link. */
    public void clickTablets() {
        getCategoryLink("Tablets").click();
    }

    /** Clicks the 'Software' category link. */
    public void clickSoftware() {
        getCategoryLink("Software").click();
    }

    /** Clicks the 'Phones & PDAs' category link. */
    public void clickPhonesAndPDAs() {
        getCategoryLink("Phones & PDAs").click();
    }

    /** Clicks the 'Cameras' category link. */
    public void clickCameras() {
        getCategoryLink("Cameras").click();
    }

    /** Clicks the 'MP3 Players' category link. */
    public void clickMP3Players() {
        getCategoryLink("MP3 Players").click();
    }

    /**
     * Checks if the navigation bar is visible on the page.
     * @return true if visible, false otherwise.
     */
    @Override
    public boolean isDisplayed() {
        return this.page.locator(this.menuContainer).isVisible(new Locator.IsVisibleOptions().setTimeout(3000));
    }
}
