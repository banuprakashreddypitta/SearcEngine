# Search Engine Test Automation

This project demonstrates test automation for performing searches on different search engines using Selenium and Cucumber.

## Prerequisites

- Java Development Kit (JDK) installed (version 8 or higher)
- Maven build tool installed
- WebDriver executable for your preferred browser (Chrome, Firefox, etc.)

## Getting Started

1. Clone the repository to your local machine:

   ```bash
   git clone https://github.com/banuprakashreddypitta/SearchEngineTestAutomation.git

   ```bash
    cd SearchEngineTestAutomation
   ```bash
    mvn clean install
   ```bash
    mvn test

This will trigger the Cucumber tests, and the results will be available in the target/cucumber-reports

**Configuration**

Web browser configuration and other settings can be modified in the src/test/resources/config.properties file.

**Project Structure**

src/main/java: Contains the application code (Page Objects, Base classes, etc.)
src/test/java: Contains the Cucumber step definitions and test runners.
src/test/resources/features: Contains the Gherkin feature files.
