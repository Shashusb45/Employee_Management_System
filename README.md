# Employee Management System

A simple Employee Management System built with **Spring Boot** and **MySQL**.  
This project helps manage employees and provides authentication through login and registration.

---

## 🚀 Features
- User Registration & Login  
- Add new employees  
- View employee details  
- Update employee information  
- Delete employees  
- Connects to MySQL database  

---

## 🛠️ Tech Stack
- Java 17
- Spring Boot  
- Spring Data JPA  
- Spring Security (for login & registration)  
- MySQL  
- Thymeleaf
- Maven

---

## ⚙️ Installation & Setup

1. Clone the repository:
   ```bash
   git clone https://github.com/Shashusb45/Employee_Management_System.git

2. Configure your MySQL database in application.properties:

   spring.datasource.url=jdbc:mysql://localhost:3306/employee_db
   spring.datasource.username=root
   spring.datasource.password=yourpassword
   spring.jpa.hibernate.ddl-auto=update

3. Run the application:
   
   mvn spring-boot:run

4. Open your browser and go to:

   http://localhost:8080


