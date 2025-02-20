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
* [Builder Pattern](#builder-pattern)


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
* Singleton design pattern restricts the instantiation of a class and ensures that only one instance of the class exists in the jvm.
  
🔹 **Why use Singleton in test automation?**  

✅ Ensures that only **one instance** of **WebDriver** is created during the test execution.  
✅ Prevents unnecessary browser or session duplications.  
✅ Improves memory efficiency and resource management. 

In our case, we want to ensure that we have only one instance of WebDriver  
throughout the test execution.  

Implementation in the UI part:  

In the `utils` package, we have a class named `DriverFactory`, which manages the  
WebDriver instance using the Singleton Design Pattern.  


 ```java
private static WebDriver driver;

public static WebDriver getDriver(String browserName) {
        if (driver == null) {
            if (browserName.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
            } else if (browserName.equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();
            } else if (browserName.equalsIgnoreCase("edge")) {
                driver = new EdgeDriver();
            }
        }
        return driver;
    }
```
* You can read more about singleton design pattern on:
  - [TutorialsPoint](https://www.tutorialspoint.com/design_pattern/singleton_pattern.htm)
  - [GeeksForGeeks](https://www.geeksforgeeks.org/java-singleton-design-pattern-practices-examples/)
  - [Medium](https://medium.com/geekculture/introduction-to-design-patterns-understanding-singleton-design-pattern-5a4d49960444#:~:text=The%20Singleton%20Design%20Pattern%20is,%3B%20in%20case%20of%20Java)

## Method Chaining Concept 🔗
* Method Chaining is the practice of calling different methods in a single line instead of calling other methods with the same object reference separately. Under this procedure, we have to write the object reference once and then call the methods by separating them with a (dot.).
* Syntax -> `obj.method1().method2().method3();`
* So in our case we made those methods return `this` which refers to the current object.
```java
  public HomePage clickOnLeftSideMenu(){
        clickOnElement(leftSideMenuLocator);
        return this;
    }

    public HomePage clickOnVideoGames(){
        clickOnElement(seeAllMenuButtonLocator);
        clickOnElement(videoGamesLocator);
        return this;
    }

    public void clickOnAllVideoGames(){
        clickOnElement(allVideoGamesLocator);
    }
```
* So in our Test part instead of calling methods like this:
```java
public void test() {
    homePage.clickOnLeftSideMenu();
    homePage..clickOnVideoGames();
    homePage.clickOnAllVideoGames();
}
```
* We do this:
```java
public void test() {
     homePage.clickOnLeftSideMenu()
                .clickOnVideoGames()
                .clickOnAllVideoGames();
}
```

## Static Factory Method 🏭
* The most widely used technique to allow other parts of our Java programs, to get objects of a certain type, is to create public constructors.
* There is also another technique which is that provides various advantages and it would be highly recommendable for every programmer to know. Classes can provide static factory methods. This methods are another way of returning instances.
* #### Advantages of static factory method
  - The static factory method can have a meaningful name.
  - Static factory methods can return the same type that implements the method, a subtype, and also primitives.
  - Inside static factory method other than initialization if we want to perform any activity for every object creation like increasing count value for every object creation we can do this in the static factory method.
  - Encapsulate the construction logic.
* So How we will benefit from this in our framework ?
  - If we are testing the UI of application , we might have 50 screen or more 
  - And we had 50 test classes , we would have this new login screen called 50 times:
  ```java 
   public class HomePage {

    public  HomePage{
        
    }
  }
  ```
  - Imagine if we decide to change the constructor of this class , we will have to change it in 50 different places
  - But with this, it's only one place:
  ```java 
    public class HomePage {

    //Prevent instance
    private HomePage() {

    }

    public static HomePage getHomePage() {
        return new HomePage();
    }
   ```
* You can read more about Static Factory Method on:
  - [Medium](https://medium.com/javarevisited/static-factory-methods-an-alternative-to-public-constructors-73cbe8b9fda)
  - [GeeksForGeeks](https://www.geeksforgeeks.org/difference-between-constructor-and-static-factory-method-in-java/#:~:text=The%20static%20factory%20methods%20are,cached%20and%20reused%20if%20required)
  - [Baeldung](https://www.baeldung.com/java-constructors-vs-static-factory-methods)
  - [StackOverFlow](https://stackoverflow.com/questions/929021/what-are-static-factory-methods)

## Data Driven Techniques 📊
* Data Driven Testing is a software testing method in which test data is stored in table or spreadsheet format.
* Data Driven Framework is an automation testing framework in which input values are read from data files and stored into variables in test scripts.
* Data Driven Testing is important because testers frequently have multiple data sets for a single test and creating individual tests for each data set can be time-consuming.
* In our case we will use JSON files for data driven.
#### Why JSON over Excel?
 - Most of data driven testing framework we have used Excel – Apache POI But there is other medium as well to store data into files such as csv, xml, json, text file, etc.
 - Excel is good to manage data and to use but it comes with its own limitations. Like MS Office needs to be installed on the system where the tests are being executed. 
 - As the test servers has never bound to have such dependencies.
 - If test is run on Mac, then again there is a different problem.
#### Read From JSON File
* This function for reading JSON file can be found at ```src/main/java/file_handling/FileManager.java```:
  ```java
   ppublic static JSONObject readJsonFile(String jsonFilePath){
      ............................................
  }
  ```
## Builder Pattern 🏗️


[product-screenshot]: images/screenshot.png
[Java]: https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white
[Java-url]: https://docs.oracle.com/en/java/
[Selenium]: https://img.shields.io/badge/selenium-webdriver-43B02A?style=for-the-badge&logo=selenium&logoColor=white
[Selenium-url]: https://www.selenium.dev/documentation/webdriver/
[RestAssured]: https://img.shields.io/badge/RestAssured-%234CAF50.svg?style=for-the-badge&logoColor=white
[RestAssured-url]: https://rest-assured.io/
[TestNG]: https://img.shields.io/badge/TestNg-FF7F00?style=for-the-badge&logo=testng&logoColor=white
[TestNG-url]: https://testng.org/
[JsonSimple]: https://img.shields.io/badge/JSON_Simple-000000?style=for-the-badge&logo=json&logoColor=white
[JsonSimple-url]: https://www.digitalocean.com/community/tutorials/json-simple-example
