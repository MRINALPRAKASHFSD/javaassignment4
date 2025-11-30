# Assignment 4 – Student Management System (Java)

Repository: **Assignment_4_2401010182**  
Name: **Mrinal Prakash**  
Roll No: **2401010182**  
Course: **B.Tech CSE (Semester III)**  
Subject: **Java Programming**  

---

## 1. Problem Statement

Design and implement a **Student Management System** using core object‑oriented concepts in Java.  
The system should store and manage student records, and must demonstrate:

- Inheritance using an abstract base class `Person`
- A concrete class `Student` extending `Person`
- An interface `RecordActions` describing CRUD operations
- A `StudentManager` class implementing `RecordActions` using collections
- Method overriding and method overloading
- Proper use of packages and modular code design

The application runs as a console program and provides a menu to add, view, search, update, and delete student records.

---

## 2. Features

- Add a new student with:
  - Roll number
  - Name
  - Email
  - Course
  - Marks
- Automatically calculate and store grade based on marks
- View all students currently stored
- Search a student by roll number
- Update an existing student’s details (course/marks etc.)
- Delete a student by roll number
- Prevent insertion of duplicate roll numbers
- Demonstrate:
  - Inheritance (`Student` extends `Person`)
  - Method overriding (`displayInfo()`)
  - Method overloading (`displayInfo(String note)`)
  - Interface implementation (`RecordActions` implemented by `StudentManager`)
  - Use of a Java Collection (`HashMap<Integer, Student>`)

---


### 3.1 model package

- `Person`  
  - Abstract class containing common person fields: `name`, `email`.  
  - Provides constructors and an abstract method `displayInfo()`.

- `Student`  
  - Extends `Person`.  
  - Additional fields: `rollNo`, `course`, `marks`, `grade`.  
  - Constructors for initializing student details.  
  - `calculateGrade()` method to set `grade` based on `marks`.  
  - Overrides `displayInfo()` to print all student details.  
  - Overloaded `displayInfo(String note)` to show details with an extra message.

### 3.2 service package

- `RecordActions` (interface)  
  - Declares operations for managing students:  
    `addStudent`, `deleteStudent`, `updateStudent`, `searchStudent`, `viewAllStudents`.

- `StudentManager`  
  - Implements `RecordActions`.  
  - Uses a `HashMap<Integer, Student>` to store student objects with `rollNo` as key.  
  - Ensures no duplicate roll numbers are added.  
  - Provides logic for adding, updating, deleting, searching, and listing students.

### 3.3 ui package

- `MainApp`  
  - Contains `public static void main(String[] args)`.  
  - Creates a `StudentManager` object and a `Scanner` for user input.  
  - Displays a looped menu:
    - `1` – Add Student  
    - `2` – View All Students  
    - `3` – Search Student  
    - `4` – Delete Student  
    - `5` – Update Student  
    - `6` – Exit  
  - Calls the appropriate `StudentManager` methods based on user choice.

---





