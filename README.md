# Sauce Demo test automation framework
## Overview
This project is an automated testing framework for the Sauce Demo website (https://www.saucedemo.com) built using Selenium WebDriver, TestNG, and Java. 
The framework follows both the Page Object Model design pattern, aided by Page Factory. Both java and maven must be installed for the succesful execution of this testing framework.
### Tests overview
The following tests are included:
* Purchase a product: Follow the complete buyflow of the page, selecting a random product, adding it to the cart, adding the personal data, and check you are 
successfully arriving at the “Thank you for your purchase” page.
* Removing elements of the shopping cart: Add 3 different elements to the shopping cart, enter to the cart page, remove them and check the shopping cart is empty.
* Logout: try to log out and check if you are correctly redirected to the login page.

## Setup instruction
Clone the repository

```
git clone https://github.com/aparra29/SouceDemoAutomationProject.git
```

Navigate to the project directory

```
cd SouceDemoAutomationProject
```

Install the necessary dependencies

´´´
mvn clean install
´´´

## Running tests 

To run the tests, execute the following command inside the project directory

´´´
mvn clean test
´´´

