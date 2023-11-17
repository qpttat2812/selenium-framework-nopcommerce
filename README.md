# Build Framework with NopCommerce
NopCommerce is open-source Ecommerce platform, including [Frontend](https://demo.nopcommerce.com/) area and [Admin](https://admin-demo.nopcommerce.com/login) area. 

These areas are not interconnected. 

The site is reset to its original state every hour.

## Framework Structure:

Apply `Page Object Model (POM)` with 4 main layers:

 1. testcases: contains modules of project, one module is one package. It also contains common testcase (for example, register account) to avoid creating too many accounts for each class. 
 2. actions: contains some specific packages
    - commons package: contains common functions for pages and testcases, constructors management and global constants.
    - pagesObject package: contains functions for each page.
    - reportsConfig package: contains reports configuration
    - utilities package: contains utilities such as: datafaker, ...
 3. interfaces: contains page UIs of each module.
 4. resources: files management, data test, environment files of project.

<pre>
├── <b>testcases</b>
  ├── admin
    ├── Admin_01_SearchWithProduct.java
  ├── user
    ├── User_01_LoginAccount.java
    ├── ...
  ├── common
    ├── Common_RegisterAccount.java
├── <b>actions</b>
  ├── commons
    ├── BasePage.java (used by pagesObject)
    ├── BaseTest.java (used by testcases)
    ├── PageGeneratorManagement.java (contains all construtors)
    ├── GlobalConstants.java
  ├── pageObjects
    ├── LoginPageObject.java
    ├── HomePagePageObject.java
    ├── ...
  ├── reportsConfig
    ├── AllureTestListener.java
    ├──...
  ├── utilities
    ├── DataHelper.java
├── <b>interfaces</b>
  ├── user
    ├── LoginPageUI.java
    ├── HomePageUI.java
    ├── ...
  ├── admin
    ├── SearchPageUI.java
    ├── ...
├── <b>resources</b>
  ├── runNopCommerce.xml
  ├── environment.properties
  ├── ...
</pre>

## Tools & Libraries:
- Eclipse
- TestNG 6.14.3
- Selenium Server 4.14.0
- WebDriverManager 5.5.3
- Allure 2.24.0
- JavaFaker 1.0.2

## Diagram of Frontend Site

