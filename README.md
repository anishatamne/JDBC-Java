## Project Description

This Java-based Student Management System demonstrates how to perform CRUD operations (Create, Read, Update, Delete) using JDBC (Java Database Connectivity) to connect with a MySQL database. It allows users to manage student records including PRN, name, date of birth, and marks.

---

## Features

- Add a new student to the database  
- Display all student records  
- Search student by:
  - PRN
  - Name  
- Update student details  
- Delete a student record  
- Position-based search (not supported in DB, message displayed)

---

## Technologies Used

- Java  
- JDBC  
- MySQL  
- Command Line Interface  

---

## Database Structure

**Database Name:** `student_db`  
**Table Name:** `students`

```sql
CREATE DATABASE student_db;

USE student_db;

CREATE TABLE students (
    prn VARCHAR(20) PRIMARY KEY,
    name VARCHAR(100),
    dob VARCHAR(20),
    marks DOUBLE
);
