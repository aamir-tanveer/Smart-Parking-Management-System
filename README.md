# Smart Parking Management System

A simple console-based application for managing vehicle parking, developed using Java and Object-Oriented Programming (OOP) concepts.

## Table of Contents

- About
- Features
- Project Structure
- OOP Concepts Used
- Technologies Used
- How to Run
- Author

## About

The Smart Parking Management System is a Java console application that manages parking spaces for cars and bikes. It allows users to park vehicles, check available slots, remove vehicles, and calculate parking fees based on parking hours.

The project was developed as part of the Object-Oriented Programming (OOP) course.

## Features

**Vehicle Management**
- Park cars and bikes
- Enter vehicle registration numbers
- Prevent duplicate vehicle entries
- Remove parked vehicles

**Parking Slot Management**
- Manage 5 parking slots
- Check available and occupied slots
- Automatically assign an available slot
- Display all parked vehicles

**Parking Fee Calculation**
- Car parking: Rs. 100 per hour
- Bike parking: Rs. 50 per hour
- Calculate fees based on parking hours

## Project Structure

- `Main.java` — Contains the Java classes and main program
- `README.md` — Project information and instructions
- `.gitignore` — Excludes compiled Java files

## OOP Concepts Used

| Concept | Where Applied |
|---|---|
| Inheritance | Car and Bike inherit from Vehicle |
| Abstraction | Vehicle is an abstract class |
| Encapsulation | Private variables and getter methods |
| Polymorphism | getRate() and getType() are overridden |
| Classes and Objects | Vehicle, Car, Bike, ParkingSlot, ParkingManager |

## Technologies Used

- Java — Programming language
- VS Code — Code editor
- Ubuntu Linux — Development environment
- Java JDK — Compilation and execution

## How to Run

**Prerequisites**

- Java JDK installed
- Terminal or VS Code

**Steps**

1. Clone the repository:

   `git clone https://github.com/aamir-tanveer/Smart-Parking-Management-System.git`

2. Open the project directory:

   `cd Smart-Parking-Management-System`

3. Compile the program:

   `javac Main.java`

4. Run the program:

   `java Main`

The parking system menu will appear in the terminal.

**Note:** Parking records are stored temporarily in memory and reset when the program closes.

## Author

**Aamir Tanveer**

Computer Science — IMCS, University of Sindh

GitHub: [@aamir-tanveer](https://github.com/aamir-tanveer)
