# Foodics-Automation-Task
![image](https://github.com/user-attachments/assets/e3236f41-1866-42a4-96c7-e129e94e93d2)
## Table of contents
* [About The Project](#about-the-project)
* [Built With](#built-with)
* [Prerequisites](#prerequisites)
* [Installation and Run](#installation-and-run)
* [Design Patterns & Concepts](#design-patterns-and-concepts)
* [Project Structure](#project-structure)
* [Test Scenarios](#test-scenarios)
## 📌About The Project

This project is a **Selenium-Java** and **RestAssured API** test automation framework designed to automate product search, filtering, cart validation on [Amazon.eg](https://www.amazon.eg/), and API testing using [Reqres API](https://reqres.in).  

### 🔹 **Key Features:**  
✅ **Selenium Web Automation:** Automates the user journey on **Amazon.eg**, including login, product filtering, sorting, and cart validation.  
✅ **API Testing with RestAssured:** Covers **Create, Retrieve, and Update User** functionalities using **Reqres API**.  
✅ **TestNG for Execution & Validation:** Ensures structured test execution.  
✅ **Page Object Model (POM):** Implements a modular and maintainable test structure.  
✅ **Robust Error Handling & Logging:** Ensures stability and debugging efficiency.  
✅ **Maven for Dependency Management:** Simplifies project setup and execution.  

This framework follows industry best practices to ensure **scalability, reusability, and reliability** in test automation. 🚀 


## 🛠Built With

This section should list any major dependencies/libraries used to bootstrap this project.

* [![Java][Java]][Java-url]
* [![Selenium][Selenium]][Selenium-url]
* [![RestAssured][RestAssured]][RestAssured-url]
* [![TestNG][TestNG]][TestNG-url]
* [![JsonSimple][JsonSimple]][JsonSimple-url]


## 📌Prerequisites

Before setting up the project, ensure you have the following installed on your system:  

✅ **Operating System:** Windows, macOS, or Linux  
✅ **Java Development Kit (JDK 11+)** – [Download Here](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)  
✅ **Maven (Latest Version)** – [Download Here](https://maven.apache.org/download.cgi)

## 🚀Installation and Run

Below is an example of how you can install and set up the project.

1️⃣ Clone the repo
   ```sh
   git clone https://github.com/FadyWaheed11/Foodics_Task.git
   ```
2️⃣ Install Dependencies
```sh
mvn clean install
```
3️⃣ Configure Environment Variables
Ensure the following are set in your system:

* JAVA_HOME → Path to JDK 11+
* MAVEN_HOME → Path to Maven installation
* PATH → Add Maven and Java bin directories
  
4️⃣ Run UI Tests (Selenium)
To execute web automation tests on Amazon.eg, run:
```sh
mvn test -Dtest=AddProductTest
```

5️⃣ Run API Tests (RestAssured)
To execute API test cases using Reqres API, run:
```sh
mvn test -Dtest=ApiTest
```
OR run all tests:
```sh
mvn test
```

## 🎯Design Patterns and Concepts
* [Page-Object-Model Pattern **POM**](#pom)
* [Singleton Design Pattern](#singleton-design-pattern)
* [Method Chaining Concept](#method-chaining-concept)
* [Static Factory Method](#static-factory-method)
* [Data Driven Techniques](#data-driven-techniques)


## POM 🏗️
* Page Object Model (POM) is a design pattern, popularly used in test automation that creates Object Repository for UI elements.
* The advantage of the model is that it reduces code duplication and improves test maintenance.
* We separate the framework (coding part) from the testing part.
* We represent each screen in our application by Class in the framework.
* You can read more about POM structure on:
  - [Guru99](https://www.guru99.com/page-object-model-pom-page-factory-in-selenium-ultimate-guide.html)
  - [GeeksForGeeks](https://www.geeksforgeeks.org/page-object-model-pom/)
  - [Official Selenium](https://www.selenium.dev/documentation/test_practices/encouraged/page_object_models/)
  - [BrowserStack](https://www.browserstack.com/guide/page-object-model-in-selenium)


## Singleton Design Pattern 🔄
* Singleton design pattern restricts the instantiation of a class and ensures that only one instance of the class exists in the jvm
* So in our case we want to ensure that we have only one instance of AppiumDriver

 ```java
private static AppiumDriver driver;

public static AppiumDriver getAppiumDriver() {
    if (driver == null) {
        driver = new AppiumDriver(getAppiumServerUrl(), getCapabilities());
        return driver;
    }
    return driver;
}
```













[stars-shield]: https://img.shields.io/github/stars/othneildrew/Best-README-Template.svg?style=for-the-badge
[stars-url]: https://github.com/othneildrew/Best-README-Template/stargazers
[issues-shield]: https://img.shields.io/github/issues/othneildrew/Best-README-Template.svg?style=for-the-badge
[issues-url]: https://github.com/othneildrew/Best-README-Template/issues
[license-shield]: https://img.shields.io/github/license/othneildrew/Best-README-Template.svg?style=for-the-badge
[license-url]: https://github.com/othneildrew/Best-README-Template/blob/master/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/othneildrew
[product-screenshot]: images/screenshot.png
[Java]: https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white
[Java-url]: https://docs.oracle.com/en/java/
[Selenium]: https://img.shields.io/badge/selenium-webdriver-43B02A?style=for-the-badge&logo=selenium&logoColor=white
[Selenium-url]: https://www.selenium.dev/documentation/webdriver/
[RestAssured]: https://img.shields.io/badge/RestAssured-%234CAF50.svg?style=for-the-badge&logoColor=white
[RestAssured-url]: https://rest-assured.io/
[Appium-url]: https://appium.io/docs/en/latest/
[TestNG]: https://img.shields.io/badge/TestNg-FF7F00?style=for-the-badge&logo=testng&logoColor=white
[TestNG-url]: https://testng.org/
[JsonSimple]: https://img.shields.io/badge/JSON_Simple-000000?style=for-the-badge&logo=json&logoColor=white
[JsonSimple-url]: https://www.digitalocean.com/community/tutorials/json-simple-example
