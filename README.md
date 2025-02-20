# Foodics_Task
Amazon.eg Test Automation &amp; API Testing with Selenium and RestAssured

A Selenium-Java and RestAssured API test automation framework for automating product search, filtering, cart validation on Amazon.eg, and API testing using Reqres API.

📖 Table of Contents

📌 About The Project
⚙️ Built With
📋 Prerequisites
🚀 Installation and Run
📐 Design Patterns & Concepts
📂 Project Structure
✅ Test Scenarios
📌 About The Project

This project automates a complete user journey on Amazon.eg, including:
✅ Logging in and navigating the website.
✅ Filtering and sorting products under "Video Games."
✅ Adding items to the cart based on price conditions.
✅ Validating the cart total and ensuring correct checkout details (without order confirmation).

Additionally, API automation is implemented using RestAssured, covering:
✅ Creating, retrieving, and updating a user via Reqres API.

⚙️ Built With

This framework is built using:

🔹 Selenium WebDriver – UI automation.
🔹 TestNG – Test execution & reporting.
🔹 Maven – Dependency management.
🔹 RestAssured – API automation.
🔹 Java 11+ – Core programming language.
🔹 Extent Reports – Test reporting.

📋 Prerequisites

Before running the project, ensure you have:

1️⃣ Java 11+ installed
2️⃣ Maven installed (mvn -version to check)
3️⃣ Google Chrome installed with ChromeDriver
4️⃣ Git installed (git --version to check)

🚀 Installation and Run

Step 1: Clone the repository
git clone https://github.com/your-username/amazon-eg-automation.git
cd amazon-eg-automation
Step 2: Install dependencies
mvn clean install
Step 3: Run UI Tests (Amazon.eg)
mvn test -Dtest=AmazonTestSuite
Step 4: Run API Tests (Reqres API)
mvn test -Dtest=ApiTestSuite
📐 Design Patterns & Concepts

The framework follows industry-standard best practices:

✔ Page Object Model (POM) – Separates test logic from UI elements.
✔ Singleton Pattern – Ensures a single instance of WebDriver.
✔ Factory Pattern – Used for driver and test data management.
✔ Data-Driven Testing – Supports externalized test data.
✔ Logger & Exception Handling – Ensures robust error tracking.

📂 Project Structure

📂 src
 ┣ 📂 main
 ┃ ┣ 📂 java
 ┃ ┃ ┣ 📂 utils                # Utility classes (e.g., config, logging)
 ┃ ┃ ┣ 📂 pages                # Page Object Model classes
 ┃ ┃ ┣ 📂 api                  # API testing scripts using RestAssured
 ┣ 📂 test
 ┃ ┣ 📂 java
 ┃ ┃ ┣ 📂 tests                # Test cases for UI and API
 ┣ 📄 pom.xml                  # Maven dependencies
 ┣ 📄 testng.xml               # TestNG suite configuration
 ┣ 📄 README.md                # Project documentation
✅ Test Scenarios

🖥️ Selenium Web Automation (Amazon.eg)
✅ Login to Amazon.eg
✅ Navigate to Video Games → All Video Games
✅ Apply filters:

Free Shipping
Condition: New
✅ Sort by Price: High to Low
✅ Add items below 15K EGP to the cart
✅ Validate items in the cart
✅ Ensure total price (with shipping) is correct
✅ Proceed to payment (Cash on Delivery) without order confirmation
🔗 API Testing (Reqres API)
✅ Create a User (POST /api/users)
✅ Retrieve a User (GET /api/users/{id})
✅ Update a User (PUT /api/users/{id})
✅ Validate responses and error handling
