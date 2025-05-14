SpringBootCRUD - 
Product-Category
Overview ->
This project implements a Product-Category CRUD Application using Spring Boot, JPA/Hibernate, and MySQL. It provides APIs to manage categories and products with a one-to-many relationship, server-side pagination, and category details included in the product response.

Technologies Used:->

Spring Boot: Framework for creating RESTful web applications.

MySQL: Relational Database for storing category and product data.

JPA/Hibernate: ORM framework for managing entities and relationships.

Postman: Tool for testing and making API requests.

Dependencies Added:->

Spring Web

Spring Data JPA

MySQL Driver

Spring Boot Starter Validation

Setup Instructions :->
1. Set Up MySQL Database:
Create a MySQL database (e.g., crud_db) using a MySQL client or command line.

Ensure that your MySQL server is running and you have the necessary permissions to create databases and tables.

2. Update application.properties:
Open the application.properties file located in src/main/resources.

Update the database credentials (username, password, URL) for MySQL.

Configure the database details as per your setup.

3. Run the Spring Boot Application:
Run the Spring Boot application by executing the main class Application.java in your IDE or via the command line using mvn spring-boot:run.

4. API Testing with Postman:
Use Postman to test the CRUD operations for categories and products.

Ensure the server is running at http://localhost:8080.

Required Functionalities:->
Category CRUD Operations:->

GET /api/categories?page={page}: Fetch all categories with pagination.

POST /api/categories: Create a new category.

GET /api/categories/{id}: Fetch category by ID.

PUT /api/categories/{id}: Update category by ID.

DELETE /api/categories/{id}: Delete category by ID.

Product CRUD Operations:

GET /api/products?page={page}: Fetch all products with pagination.

POST /api/products: Create a new product.

GET /api/products/{id}: Fetch product by ID.

PUT /api/products/{id}: Update product by ID.

DELETE /api/products/{id}: Delete product by ID.

Relationships:->

Implement a one-to-many relationship between Category and Product (one category can have multiple products).

Pagination:->

Server-side pagination for both categories and products to handle large datasets efficiently.

Response Structure:->

When fetching a single product, the response should also include its associated category details.

Conclusion ->
This project demonstrates CRUD operations for a product and category management system, with server-side pagination, 
JPA/Hibernate for ORM, and MySQL for relational database management. It satisfies all the requirements 
