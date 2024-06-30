### Project: Pharmacy Management System
# DCIT 308, GROUP 6

#### Overview
The goal of this project is to develop a comprehensive Pharmacy Management System for a local pharmacy. This system will handle various operations such as managing drugs, suppliers, customers, and sales. The project will use data structures like LinkedLists, lists, stacks, arrays, and queues to manage these operations efficiently. Additionally, appropriate searching and sorting algorithms will be employed to manage and retrieve data from the database.

#### Tasks
1. **Add Drugs**: Allow the pharmacist to add new drugs to the system.
2. **Search for a Drug**: Enable searching for a specific drug using various parameters.
3. **View All Drugs and Their Suppliers**: Display all drugs along with their associated suppliers.
4. **View Purchase History**: Provide detailed information on the purchase history of each drug, including time, date, and buyer details.

#### Requirements
1. Use suitable data structures to represent the collection of drugs.
2. Outline the mode of addition, removal, and selection of a drug from the collection.
3. Use suitable data structures to represent the purchase history of each drug, implementing sorting based on the time and date of purchase and the total amount per purchase.
4. Link each drug to a group of suppliers using suitable data structures and implement algorithms for searching for a supplier of a drug based on certain parameters such as location.
5. Use iterators, recursion, stack, and queue implementations for collections and other techniques for managing drugs, purchased drugs by customers, and viewing drugs and purchase history.
6. Use appropriate data structures to keep track of drug sales.
7. Use appropriate data structures to store information about suppliers and customers.

#### Other Requirements
1. Maintain a balance between too high and too low stock.
2. Generate reports to show how the data structure implementations were performed.
3. Generate or allow users to view reports.
4. Creativity will attract extra marks.
5. Analyze and report on the performance of your algorithms using Big O and Omega Notation.
6. Document all sections of your code.
7. Design suitable and efficient algorithms to support your implementation.
8. Implement in Java with a user-friendly and interactive UI.
9. Use MySQL, MSSQL, PostgreSQL, or Oracle for the backend.



 ### What we've accomplished so far and what's left in the project

### Completed Tasks:
1. **Database Setup:** Created tables for `Drugs`, `Customers`, `Suppliers`, `Sales`, and `PurchaseHistory`.
2. **Model Classes:** Implemented Java classes representing the database tables: `Drug`, `Customer`, `Supplier`, `Sales`, and `PurchaseHistory`.
3. **DAO Classes:** Developed Data Access Object (DAO) classes for database operations: `DrugDAO`, `CustomerDAO`, `SupplierDAO`, `SalesDAO`, and `PurchaseHistoryDAO`.
4. **Service Classes:** Implemented business logic in service classes: `DrugService`, `CustomerService`, `SupplierService`, `SalesService`, and `PurchaseHistoryService`.
5. **GUI Panels:** Created GUI panels for managing data: `DrugPanel`, `CustomerPanel`, `SupplierPanel`, `SalesPanel`, and `PurchaseHistoryPanel`.


1. **Implement Main Application Class:** Create the main application class to run the project.
2. **Balance Stock:** Implement logic to maintain the balance between too high and too low stock.
3. **Generate Reports:** Develop functionality to generate reports on data structure implementation and sales/purchases.

### Remaining Tasks:
4. **View Reports:** Allow users to view generated reports.
5. **Performance Analysis:** Analyze and report on the performance of algorithms using Big O Notation and Omega Notation.
6. **Documentation:** Document all sections of the code for clarity and maintainability.
7. **Design Efficient Algorithms:** Design and implement suitable algorithms to support the project's functionalities efficiently.

