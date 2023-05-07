![STOCKMAN](https://user-images.githubusercontent.com/112793753/236413005-44badfe6-f862-4ea8-a2d1-87b9f230a380.jpg)
# StockMan

The Stock Broker Application built using the Spring Boot framework is a powerful web-based tool that enables customers to invest in the stock market seamlessly. It provides customers with a secure and intuitive platform that facilitates buying and selling of shares of various companies.With the ability to create and manage their demat account, customers can easily add funds and store their investments in a virtual wallet. They can track their transaction history, view stock market analysis, and stay updated with real-time price updates to make informed decisions while investing.

The application leverages the robustness and scalability of the Spring Boot framework to ensure the efficient handling of large volumes of transactions. It also implements robust security measures to protect the confidentiality of customer information and ensure the safety of transactions.Whether you're an experienced investor or a novice in the stock market, the Stock Trading Application using Spring Boot provides an intuitive and user-friendly interface that makes investing accessible to everyone. It's a reliable and efficient tool that enables customers to grow their wealth over time.

### ER Diagram.

![StockMan (1)](https://user-images.githubusercontent.com/112793753/236673794-e0a3425a-8437-46aa-8edb-5b0e9107d69c.png)

### Flow Chart

![marketing tactics to grow your company](https://user-images.githubusercontent.com/112793753/236677792-86dc5d0a-c91e-4f74-8c38-8879040b175b.png)

![marketing tactics to grow your company (1)](https://user-images.githubusercontent.com/112793753/236677813-1569ac4c-3bfc-430e-b973-d08fb80a9641.png)

## Users:

- Broker
- Customer

## Roles for the Broker:

1. Broker logs in with their username and password.
2. Broker can view all customers.
3. Broker can add new stocks.
4. Broker can view all stocks.
5. Broker can view a consolidated report of a stock, which shows how many pieces of a stock have been sold and how many are yet to be sold.
6. Broker can delete a customer, which credits the total amount of all stocks to the customer's wallet and marks the account inactive.
7. Broker can delete a stock, which credits the total amount for that stock to the customer's wallet and marks the stock as deleted from the database.
8. Broker logs out.

<br/>

![image](https://user-images.githubusercontent.com/112793753/236678054-523b0d4a-66b6-45d0-907a-b6098534ef19.png)
![image](https://user-images.githubusercontent.com/112793753/236678087-0f8714a3-f353-47b7-b921-02f64f9b0974.png)

## Roles of Customers:

1. Customer signs up with their first name, last name, username, password, address, mobile number, and email.
2. Customer logs in with their username and password.
3. Customer can view all stocks.
4. Customer can buy and sell stocks.
5. Customer can view their own transaction history.
6. Customer can add and withdraw funds to and from their wallet.
7. Customer logs out and can delete their account.

![image](https://user-images.githubusercontent.com/112793753/236678247-01bdf2e1-7c02-479c-8ddf-b237f805b51b.png)
![image](https://user-images.githubusercontent.com/112793753/236678279-db5886a3-2008-41dd-a6e2-314ae01fb4e0.png)


### Technologies Used
#### Spring Boot
1. Spring Core – Dependency Injection and Inversion of Control
2. Web MVC architectural pattern
3. Validation – Validator
4. Password using unquie key generating
5. JSON Binding
8. Rest Template
9. Apache Common Email
10. Java 17 Stream API
11. Server – Embedded Tomcat Server
12. Maven Plugin and dependencies
13. Session Management using Session Object

#### Hibernate
1. Entity Manager
2. Relationship Mapping
3. Hibernate Validator
4. Criteria Query

# Setup Required
- Eclipse / Intellij IDE
- JDK (jdk 10 and above)
- JRE(any latest versions)
- Tomcat Server
- Web Browser(Google Crome, Mozilla Firefox, Microsoft Edge)

# Running the Project
- Clone the repository as a maven project.
- Import all the dependencies.
- Run Application.java to run the application.
- You will see the processing and verification of the process during the Application run.
- Open Browser and Type in [localhost:{server_port}](https://locallhost.com/). <br/>(Server Port Depends on local System you can change it by going here [server.port](https://github.com/modhtanmay/Stock-Trading-Management/blob/master/Share-Data/src/main/resources/application.properties))
- That's it You are Good to go!!!.








