# Project Overview - Playwright Java Cucumber Gradle

## Architecture
E2E automation framework using **Page Object Model (POM)** with component-based design for testing OpenCart application.

## Tech Stack
- **Playwright 1.58.0** - Browser automation (Chromium/Firefox/WebKit)
- **Cucumber 7.15.0/7.22.0** - BDD with Gherkin
- **TestNG** - Test execution
- **PicoContainer 7.22.0** - Dependency injection
- **Gradle 7.x** - Build automation
- **Java 17+**

## Project Structure
```
src/main/java/com/automation/pages/
├── AbstractComponent.java (Base class with isDisplayed() contract)
├── commonpage/
│   ├── NavigationBar.java (Main menu navigation)
│   └── ContinueButton.java (Reusable button component)
└── loginpage/
    ├── LoginPage.java (Composite page object)
    ├── ReturningCustomers.java (Login form component)
    ├── NewCustomer.java (Registration section)
    └── RightColumnNavigation.java (Account links)

src/test/java/com/automation/
├── factory/BrowserFactory.java (Browser instance creation)
├── hooks/Hooks.java (Setup/teardown, DI provider)
├── runner/CucumberRunner.java (TestNG + Cucumber integration)
└── stepdefs/
    ├── LoginStepDef.java (Login scenario steps)
    └── SignUpStepDef.java (Empty - pending implementation)

src/test/resources/
├── config/base-config.yml (UI/API config - not yet integrated)
└── features/
    ├── LoginScenario.feature (@Login tag - implemented)
    └── signup/SignUp.feature (Empty - pending)
```

## Key Design Patterns

### 1. Component Composition
Pages are composed of reusable components. Example:
```java
LoginPage contains: ReturningCustomers + NewCustomer + RightColumnNavigation
```

### 2. Dependency Injection
- `Hooks` class provides `Page` instance to step definitions via PicoContainer
- Step definitions receive `Hooks` in constructor

### 3. Factory Pattern
- `BrowserFactory.getBrowser(String)` creates browser instances based on type

## Test Execution

### Run Tests
```bash
./gradlew e2eTest
```

### With Custom Tags/Browser
```bash
./gradlew e2eTest -Dcucumber.filter.tags="@Login" -Dbrowser="firefox"
```

### Default Configuration
- Tags: `@Login`
- Browser: `chromium`
- Headless: `false`
- Parallel: `false`

## Browser Lifecycle
1. `@Before` hook creates browser → context → page
2. Step definitions use injected `Page` instance
3. `@After` hook closes page → context → browser

## Current Test Coverage
- **Login Flow**: Fully implemented with `@Login` tag
- **SignUp Flow**: Placeholder only (empty feature and step def)

## Configuration Files
- `build.gradle` - Dependencies, e2eTest task configuration
- `base-config.yml` - UI/API settings (not currently used in code)
- `CucumberRunner.java` - Features path, glue, tags, plugins

## Reports
- HTML: `target/cucumber-reports/`
- JSON: `target/cucumber.json`

## Known Considerations
- Browser selection via system property: `-Dbrowser=<chromium|firefox|webkit>`
- All browsers launch in non-headless mode
- `Playwright` instance in `BrowserFactory` needs proper lifecycle management
- Credentials are hardcoded in step definitions
- `base-config.yml` exists but not integrated into framework
- No assertions in current test steps (only console output)

## Application Under Test
**OpenCart Demo**: https://naveenautomationlabs.com/opencart/
