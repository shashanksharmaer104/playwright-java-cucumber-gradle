# Gemini Context: Playwright-Java-Cucumber-Gradle Project

This project is a test automation framework built using **Java**, **Playwright**, and **Cucumber**, managed by **Gradle**. It follows a structured Page Object Model (POM) and uses dependency injection for managing test state across Cucumber steps.

## Project Overview

*   **Main Technologies:**
    *   **Java:** Core programming language.
    *   **Playwright:** Browser automation library.
    *   **Cucumber:** BDD framework for defining test scenarios in Gherkin.
    *   **TestNG:** Test runner used to execute Cucumber scenarios.
    *   **PicoContainer:** Dependency injection for sharing state (like the Playwright `Page` object) between step definition classes.
    *   **Gradle:** Build and dependency management tool.

*   **Architecture:**
    *   **`src/main/java`**: Contains Page Objects and components.
        *   `com.automation.pages`: Root package for POM.
        *   `com.automation.pages.commonpage`: Shared components like `NavigationBar` and `ContinueButton`.
        *   `com.automation.pages.loginpage`: Specific components for the Login page, including `ReturningCustomers`, `NewCustomer`, and `RightColumnNavigation`.
    *   **`src/test/java`**: Contains test-related code.
        *   `com.automation.factory`: Browser instantiation logic (`BrowserFactory`).
        *   `com.automation.hooks`: Cucumber hooks for scenario setup and teardown (`Hooks`).
        *   `com.automation.runner`: TestNG runner configuration (`CucumberRunner`).
        *   `com.automation.stepdefs`: Gherkin step implementations.
    *   **`src/test/resources`**:
        *   `features`: Gherkin feature files.
        *   `config`: Configuration files (e.g., `base-config.yml`).

## Playwright MCP Support

This project is configured to support the **Model Context Protocol (MCP)** using the Playwright MCP server. This allows AI tools (like Gemini CLI) to use browser automation capabilities directly within the workspace.

*   **Configurations Added:**
    *   `.gemini/config.json`: Local MCP server definition for Gemini CLI.
    *   `.vscode/settings.json`: VS Code settings for compatible MCP extensions.
*   **Usage:**
    The server is launched on-demand via `npx @playwright/mcp@latest`. No Node.js dependencies are required in the Java project itself.

## Building and Running

*   **Build Project:**
    ```bash
    ./gradlew build
    ```

*   **Run E2E Tests:**
    The project includes a custom Gradle task `e2eTest` configured in `build.gradle`.
    ```bash
    ./gradlew e2eTest
    ```
    *By default, this task runs tests with the `@Login` tag on `chromium`.*

*   **Running with Parameters:**
    You can override browser or tag configurations via system properties:
    ```bash
    ./gradlew e2eTest -Dbrowser=firefox -Dcucumber.filter.tags="@Login"
    ```

*   **Test Reports:**
    Cucumber HTML reports are generated in `target/cucumber-reports`.

## Development Conventions

*   **Page Object Model (POM):**
    *   **Components:** Logic is divided into small, reusable component classes (e.g., `RightColumnNavigation`, `NavigationBar`).
    *   **Composition:** Page classes (like `LoginPage`) compose these components to build their interface.
    *   **Base Class:** Components should extend `AbstractComponent` to ensure consistent behavior like `isDisplayed()`.
    *   **Documentation:** All public methods and classes must include Javadoc comments explaining their purpose.

*   **Locators:**
    *   Prefer user-facing locators like `getByRole`, `getByPlaceholder`, or `getByText` over brittle XPaths or CSS selectors when possible.
    *   Locators should be scoped within their respective component container (e.g., using a specific `#id` as a root).

*   **Step Definitions & DI:**
    *   Do **not** instantiate `Page` or `Browser` inside step definitions.
    *   Inject the `Hooks` class into step definition constructors to access the shared `Page` instance.

*   **Hooks:**
    *   The `Hooks` class manages the browser lifecycle (`setUp` and `tearDown`).
    *   Browser type is determined by the `browser` system property (defaults to `chrome` if not specified).



