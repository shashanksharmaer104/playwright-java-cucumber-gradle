# Playwright Java Cucumber Gradle

A robust end-to-end automation framework built with Java, Playwright, Cucumber, and TestNG, managed by Gradle.

## Features
- **Playwright:** Fast and reliable browser automation.
- **Cucumber:** BDD-style testing with Gherkin scenarios.
- **Gradle:** Flexible build automation.
- **POM:** Implements Page Object Model for maintainable code.

## Prerequisites
- Java 17 or higher
- Gradle 7.x

## Running Tests

### Run All Tests
Execute the predefined `e2eTest` task:
```bash
./gradlew e2eTest
```

### Run with Specific Tags
Pass custom tags and browser parameters to the task:
```bash
./gradlew e2eTest -Dcucumber.filter.tags="@SignUp" -Dbrowser="firefox"
```

## Project Structure
- `src/main/java`: Page Object Models.
- `src/test/java`: Step definitions, hooks, and Cucumber runner.
- `src/test/resources`: Feature files and configuration.

## Reports
Test results and Cucumber HTML reports are generated in the `target/cucumber-reports` directory.
