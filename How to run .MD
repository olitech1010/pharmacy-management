### DCIT 308 GROUP 6
1. Clement Mensah - 10975134
2. Sharif Mohammed - 10952524
3. Gabriel Daniels- 10965753
4. Derrick Ofori Mensah - 10976765
5. Martin Obeng Nti - 10966340
6. 
7.
8.

# Pharmacy Management System

This is a Java-based Pharmacy Management System application that helps manage drug inventory, sales, customers, suppliers, and purchase history. The application uses a Swing-based user interface.

## Project Structure

pharmacy-management/
│
├── pom.xml
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/
│   │   │   │   ├── pharmacy/
│   │   │   │   │   ├── management/
│   │   │   │   │   │   ├── dao/
│   │   │   │   │   │   │   ├── SalesDAO.java
│   │   │   │   │   │   │   ├── DrugDAO.java
│   │   │   │   │   │   │   ├── CustomerDAO.java
│   │   │   │   │   │   │   ├── SupplierDAO.java
│   │   │   │   │   │   │   ├── PurchaseHistoryDAO.java
│   │   │   │   │   │   ├── model/
│   │   │   │   │   │   │   ├── Sales.java
│   │   │   │   │   │   │   ├── Drug.java
│   │   │   │   │   │   │   ├── Customer.java
│   │   │   │   │   │   │   ├── Supplier.java
│   │   │   │   │   │   │   ├── PurchaseHistory.java
│   │   │   │   │   │   ├── service/
│   │   │   │   │   │   │   ├── SalesService.java
│   │   │   │   │   │   │   ├── DrugService.java
│   │   │   │   │   │   │   ├── CustomerService.java
│   │   │   │   │   │   │   ├── SupplierService.java
│   │   │   │   │   │   │   ├── PurchaseHistoryService.java
│   │   │   │   │   │   ├── util/
│   │   │   │   │   │   │   ├── DatabaseConnection.java
│   │   │   │   │   ├── ui/
│   │   │   │   │   │   ├── SalesPanel.java
│   │   │   │   │   │   ├── DrugPanel.java
│   │   │   │   │   │   ├── CustomerPanel.java
│   │   │   │   │   │   ├── SupplierPanel.java
│   │   │   │   │   │   ├── PurchaseHistoryPanel.java
│   │   │   │   │   │   ├── PharmacyApp.java
│   ├── resources/
│   ├── test/
│   │   ├── java/
│   │   ├── resources/


## Prerequisites

- Java Development Kit (JDK) 8 or higher
- Apache Maven 3.6.0 or higher
- MySQL Database Server

## Setting Up the Database

1. Install MySQL and start the MySQL server.
2. Create a new database:
   
   CREATE DATABASE pharmacy_management;
   
3. Create the necessary tables:
   
   USE pharmacy_management;

   CREATE TABLE drugs (
       id INT AUTO_INCREMENT PRIMARY KEY,
       name VARCHAR(255) NOT NULL,
       manufacturer VARCHAR(255),
       price DOUBLE,
       stock INT
   );

   CREATE TABLE customers (
       id INT AUTO_INCREMENT PRIMARY KEY,
       name VARCHAR(255) NOT NULL,
       email VARCHAR(255),
       phone VARCHAR(20)
   );

   CREATE TABLE suppliers (
       id INT AUTO_INCREMENT PRIMARY KEY,
       name VARCHAR(255) NOT NULL,
       contact VARCHAR(255)
   );

   CREATE TABLE sales (
       id INT AUTO_INCREMENT PRIMARY KEY,
       drug_id INT,
       customer_id INT,
       sales_date DATE,
       quantity INT,
       amount DOUBLE,
       FOREIGN KEY (drug_id) REFERENCES drugs(id),
       FOREIGN KEY (customer_id) REFERENCES customers(id)
   );

   CREATE TABLE purchase_history (
       id INT AUTO_INCREMENT PRIMARY KEY,
       drug_id INT,
       supplier_id INT,
       purchase_date DATE,
       quantity INT,
       price DOUBLE,
       FOREIGN KEY (drug_id) REFERENCES drugs(id),
       FOREIGN KEY (supplier_id) REFERENCES suppliers(id)
   );
   ```

4. Update the `DatabaseConnection.java` file with your MySQL database credentials.

## Building the Project

1. Navigate to the project directory:
   
   cd pharmacy-management
   
2. Use Maven to build the project:
   
   mvn clean install
   

## Running the Application

1. After successfully building the project, run the `PharmacyApp` class:
   
   mvn exec:java -Dexec.mainClass="com.pharmacy.ui.PharmacyApp"
   ```

2. Alternatively, you can run the application from your IDE by setting the main class to `com.pharmacy.ui.PharmacyApp`.

## Features

- **Drug Management**: Add, update, and delete drugs.
- **Customer Management**: Add, update, and delete customers.
- **Supplier Management**: Add, update, and delete suppliers.
- **Sales Management**: Record sales and view sales history.
- **Purchase History Management**: Record and view purchase history.

## Contributing

If you would like to contribute to this project, please fork the repository and submit a pull request.

## License

This project is licensed under the MIT License.