# Employee Leave Management System API

## Project Overview
A REST API developed using Java and Spring Boot to manage employees and their leave requests. It uses MySQL to store employee and leave information.

## Technologies Used
- Java 21
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- Postman

## Features

### Employee Management
- Add a new employee
- View all employees
- View employee by ID
- Update employee details
- Delete an employee

### Leave Management
- Apply for leave
- View all leave requests
- View leaves by employee ID
- View pending leave requests
- Approve leave requests
- Reject leave requests

### Additional Features
- Basic leave-date validation
- Employee existence validation
- Global exception handling
- MySQL database integration

## Database Configuration

Create a MySQL database:

```sql
CREATE DATABASE employee_leave_db;
```

Configure `src/main/resources/application.properties`:

```properties
spring.application.name=level-management

spring.datasource.url=jdbc:mysql://localhost:3306/employee_leave_db
spring.datasource.username=root
spring.datasource.password=YOUR_MYSQL_PASSWORD
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

server.port=8080
```

Replace `YOUR_MYSQL_PASSWORD` with your own local MySQL password.

## How to Run

1. Install Java 21 and MySQL.
2. Create the database.
3. Configure your database credentials.
4. Open the project folder in the terminal.
5. Run:

```powershell
.\mvnw.cmd spring-boot:run
```

The API runs at:

`http://localhost:8080`

## API Endpoints

### Employee APIs

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/employees` | Add employee |
| GET | `/api/employees` | Get all employees |
| GET | `/api/employees/{id}` | Get employee by ID |
| PUT | `/api/employees/{id}` | Update employee |
| DELETE | `/api/employees/{id}` | Delete employee |

### Leave APIs

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/leaves` | Apply for leave |
| GET | `/api/leaves` | Get all leave requests |
| GET | `/api/leaves/employee/{employeeId}` | Get leaves by employee |
| GET | `/api/leaves/pending` | Get pending leaves |
| PUT | `/api/leaves/{id}/approve` | Approve leave |
| PUT | `/api/leaves/{id}/reject` | Reject leave |

## Sample Employee Request

```json
{
  "name": "Rahul Sharma",
  "email": "rahul@gmail.com",
  "department": "IT",
  "designation": "Java Developer"
}
```

## Sample Leave Request

```json
{
  "employeeId": 3,
  "leaveType": "SICK",
  "startDate": "2026-11-25",
  "endDate": "2026-11-26",
  "reason": "Not feeling well"
}
```

## Learning Outcomes
- REST API development
- Spring Boot application structure
- CRUD operations
- Spring Data JPA
- MySQL integration
- Exception handling
- API testing using Postman