# TripGo Rentify - Car Rental Management System

## 📋 Project Overview

**TripGo Rentify** is a desktop-based Car Rental Management System built using **Java Swing** GUI. It provides a comprehensive platform to manage car rentals, customers, car owners, and booking operations.

### Key Features:
- 🚗 **Car Management** - Add, update, remove, and view cars
- 👤 **Customer Management** - Register and manage customers
- 👨‍💼 **Car Owner Management** - Manage car owners and their vehicles
- 📅 **Booking System** - Book and un-book cars with automated billing
- 💾 **Data Persistence** - All data is saved using Java serialization (.ser files)
- 🔐 **User Authentication** - Login system for secure access

---

## 🛠️ System Requirements

### Prerequisites:
1. **Java Development Kit (JDK)** - Version 22 or higher
   - [Download JDK](https://www.oracle.com/java/technologies/downloads/)
   
2. **Operating System** - Windows, Linux, or macOS

3. **RAM** - Minimum 512 MB

4. **Disk Space** - Minimum 100 MB for project and data files

### Required Libraries:
- Built-in Java Swing (included with JDK)
- Custom NetBeans layout library (already included in project)

---

## 📦 Project Structure

```
tripgo-rentify-car/
│
├── src/                          # Source code directory
│   ├── BackendCode/              # Core business logic
│   │   ├── Person.java           # Abstract base class for users
│   │   ├── Customer.java         # Customer management
│   │   ├── CarOwner.java         # Car owner management
│   │   ├── Car.java              # Car details and operations
│   │   └── Booking.java          # Booking management
│   │
│   └── GUI/                       # User interface (Swing)
│       ├── Runner.java           # Application entry point
│       ├── Login.java            # Login window
│       ├── MainMenu.java         # Main menu
│       ├── Customer_*.java       # Customer operations UI
│       ├── Car_*.java            # Car operations UI
│       ├── CarOwner_*.java       # Car owner operations UI
│       ├── Booking_*.java        # Booking operations UI
│       └── ResourceHelper.java   # Resource loading utility
│
├── build/                         # Compiled files
│   └── classes/                   # Compiled Java classes
│
├── build.xml                      # NetBeans build configuration
├── Dockerfile                     # Docker containerization
└── *.ser                          # Serialized data files (runtime generated)
```

---

## 🚀 Installation & Setup

### Step 1: Clone or Download the Project
```bash
git clone https://github.com/Suhel33/TripGo-Rentify-Car-Management-System.git
```

### Step 2: Verify Java Installation
```bash
java -version
javac -version
```

Output should show Java 22 or higher.

### Step 3: Compile the Project
```bash
# For Windows (PowerShell)
javac -d build/classes src/BackendCode/*.java src/GUI/*.java src/org/netbeans/lib/awtextra/*.java

# For Linux/macOS
javac -d build/classes src/BackendCode/*.java src/GUI/*.java src/org/netbeans/lib/awtextra/*.java
```

---

## ▶️ Running the Application

### Method 1: Direct Java Execution
```bash
java -cp build/classes GUI.Runner
```

### Method 2: Using NetBeans (if installed)
1. Open NetBeans IDE
2. File → Open Project
3. Select the project directory
4. Click Run (F6) or Build & Run

### Method 3: Using Command Line with Build Script
```bash
# Windows
ant run

# Linux/macOS
ant run
```

---

## 🎯 Application Usage Guide

### 1. **Starting the Application**
   - Run the application using any method above
   - A welcome screen will appear
   - After 1 second, the login window will display

### 2. **Login Screen**
   - Default credentials are configured by admin
   - Access Credentials
         Username: suhel@admin
         Password: 123456
   - First-time users need to register as a Customer or Car Owner

### 3. **Main Menu Operations**

#### **Customer Operations:**
   - **Add Customer** - Register a new customer
   - **View Customer Details** - Search and view customer information
   - **Update Customer** - Modify customer information
   - **Remove Customer** - Delete a customer record

#### **Car Operations:**
   - **Add Car** - Register a new car with owner
   - **View Car Details** - Search and view car information
   - **Update Car** - Modify car details
   - **Remove Car** - Delete a car record

#### **Car Owner Operations:**
   - **Add Car Owner** - Register a new car owner
   - **View Car Owner Details** - Search and view owner information
   - **Update Car Owner** - Modify owner details
   - **Remove Car Owner** - Delete an owner record

#### **Booking Operations:**
   - **Book Car** - Create a new booking
   - **View Booking Details** - Search booking history
   - **Un-Book Car** - Cancel a booking

---

## 💾 Data Storage

All data is automatically saved in serialized format:
- `Customer.ser` - Customer records
- `Car.ser` - Car records
- `CarOwner.ser` - Car owner records
- `Booking.ser` - Booking records

**Note:** These files are created automatically in the project root directory when you add data.
