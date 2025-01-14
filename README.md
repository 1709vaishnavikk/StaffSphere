# StaffSphere Backend

## Overview
This is the backend for the StaffSphere Employee Management System. It handles the employee data and the API for interacting with the employee records.

## Prerequisites
- Java 
- Spring Boot
- MySQL (or any other database configured)
- Maven (for dependency management)

## Setup
1. **Clone the repository:**
    ```bash
    git clone <repository-url>
    cd backend
    ```

2. **Install dependencies:**
    ```bash
    mvn clean install
    ```

3. **Configure the application:**
    Open `src/main/resources/application.properties` and set the database connection and credentials for your MySQL (or other database) server.

    Set the username and password for your application:
    ```properties
    spring.datasource.username=<your-db-username>
    spring.datasource.password=<your-db-password>
    ```

4. **Run the backend:**
    ```bash
    mvn spring-boot:run
    ```
    The backend will start running on `http://localhost:8080` (or any port you specify in `application.properties`).

## API Endpoints
- **GET /employees** - Get a list of all employees.
- **GET /employees/{id}** - Get details of a specific employee.
- **POST /employees** - Add a new employee.
- **PUT /employees/{id}** - Update an existing employee.
- **DELETE /employees/{id}** - Delete an employee.

## Features
- Employees can be filtered by **Job Role** and **Designation** in the "View Employee" section.
- Security features have not been implemented in this version.

## Troubleshooting
- Ensure that your database is properly set up and the credentials in `application.properties` are correct.
- If the application does not start, check the console logs for any errors related to database connectivity or missing dependencies.

   
        
