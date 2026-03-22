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
        *   Follows a component-based approach (e.g., `LoginPage` uses `ReturningCustomers` component).
    *   **`src/test/java`**: Contains test-related code.
        *   `com.automation.factory`: Browser instantiation logic (`BrowserFactory`).
        *   `com.automation.hooks`: Cucumber hooks for scenario setup and teardown (`Hooks`).
        *   `com.automation.runner`: TestNG runner configuration (`CucumberRunner`).
        *   `com.automation.stepdefs`: Gherkin step implementations.
    *   **`src/test/resources`**:
        *   `features`: Gherkin feature files.
        *   `config`: Configuration files (e.g., `base-config.yml`).

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
    *   Initialize pages by passing the Playwright `Page` instance to the constructor.
    *   Use components (like `ReturningCustomers`) for better modularity within page classes.
    *   Inherit from `AbstractComponent` for shared component behavior.

*   **Step Definitions & DI:**
    *   Do **not** instantiate `Page` or `Browser` inside step definitions.
    *   Inject the `Hooks` class into step definition constructors to access the shared `Page` instance.
    ```java
    public class MyStepDef {
        private final Page page;
        public MyStepDef(Hooks hooks) {
            this.page = hooks.getPage();
        }
    }
    ```

*   **Hooks:**
    *   The `Hooks` class manages the browser lifecycle (`setUp` and `tearDown`).
    *   Browser type is determined by the `browser` system property (defaults to `chrome` if not specified).

*   **Feature Files:**
    *   Located in `src/test/resources/features`.
    *   Use tags (e.g., `@Login`, `@SignUp`) to organize and filter scenario execution.
