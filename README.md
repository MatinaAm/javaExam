# 🌌 Galaxy Management System

A Java-based console application for managing galaxies and planets. This project demonstrates Object-Oriented Programming (OOP), file handling, inheritance, enums, abstraction, and data persistence in Java.

## 📋 Overview

The Galaxy Management System allows users to manage planetary information within different galaxies through an interactive command-line interface.

The application stores planet information in a text file and provides features for creating, updating, and viewing planetary data.

## ✨ Features

### 🌍 Planet Management
- Add new planets
- Assign planets to galaxies
- Define planet type (Rock or Gas)
- Set distance from the sun
- Specify natural resources
- Define habitability status
- Manage moon counts

### 🌌 Galaxy Operations
- Display all available galaxies
- Associate planets with existing or custom galaxies

### 💾 Data Persistence
- Store planet information in a text file
- Prevent duplicate planet records
- Update existing planet information
- Load saved data automatically

### 🔍 Search & Display
- Display detailed information about a specific planet
- View all stored galaxy data
- Retrieve planet information by name

## 🏗️ Project Structure

```text
javaExam/
│
├── galaxy/
│   └── Galaxy.java
│
├── src/
│   ├── Main.java
│   └── InstancePlanet.java
│
├── utils/
│   ├── abstracts/
│   ├── enums/
│   └── functions/
│
├── data.txt
└── README.md
```

## 🧩 Technologies Used

- Java
- Object-Oriented Programming (OOP)
- File Handling
- Collections Framework
- Enums
- Abstract Classes
- Inheritance
- Exception Handling

## 📚 OOP Concepts Demonstrated

### Abstraction
The project uses abstract classes to define common behavior for planets.

### Inheritance
`InstancePlanet` extends the abstract `Planet` class and provides concrete implementations.

### Encapsulation
Planet properties are managed through controlled access methods.

### Polymorphism
Overridden methods such as:

```java
displayPlanetInfo()
calculateOrbitalPeriod()
addMoons()
```

allow different implementations of shared behavior.

## 🚀 How to Run

### Clone the Repository

```bash
git clone https://github.com/MatinaAm/javaExam.git
```

### Navigate to the Project

```bash
cd javaExam
```

### Compile

```bash
javac src/*.java
```

### Run

```bash
java src.Main
```

## 🖥️ Menu Options

When the application starts, the following menu is displayed:

```text
Galaxy Management System:

1. Display Galaxies
2. Add New Planet
3. Change Moon Count of a Planet
4. Display Planet Information
5. Save and Exit
```

## 📄 Sample Planet Data

```text
Planet {
    name='Earth',
    galaxy='Milky Way',
    moons=1,
    type=ROCK,
    distanceFromSun=149.6,
    resources=[WATER, IRON],
    lifeStatus=HABITABLE
}
```

## 🔄 Functional Workflow

1. User selects a menu option.
2. Planet information is collected.
3. Data validation is performed.
4. Information is stored in `data.txt`.
5. Existing records can be updated.
6. Users can retrieve and display saved data.

## 🎯 Learning Objectives

This project was created to practice:

- Java Fundamentals
- Object-Oriented Design
- File I/O Operations
- Data Persistence
- Collections and Sets
- Enums and Abstract Classes
- Console-Based Application Development



## 📜 License

This project is created for educational and learning purposes.
