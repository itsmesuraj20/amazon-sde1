# Java Object-Oriented Programming: Zero to Advanced

## Table of Contents
1. [Introduction to OOP](#introduction-to-oop)
2. [Classes and Objects](#classes-and-objects)
3. [Access Modifiers](#access-modifiers)
4. [Method Parameters and Return Types](#method-parameters-and-return-types)
5. [Constructors](#constructors)
6. [Inheritance](#inheritance)
7. [Polymorphism](#polymorphism)
8. [Encapsulation](#encapsulation)
9. [Abstraction](#abstraction)
10. [Interfaces](#interfaces)
11. [Advanced Topics](#advanced-topics)

---

## Introduction to OOP

Object-Oriented Programming (OOP) is a programming paradigm based on the concept of "objects" which contain data (attributes) and code (methods). Java is a pure object-oriented language.

### Four Pillars of OOP:
1. **Encapsulation** - Bundling data and methods together
2. **Inheritance** - Creating new classes based on existing ones
3. **Polymorphism** - Same interface, different implementations
4. **Abstraction** - Hiding complex implementation details

---

## Classes and Objects

### What is a Class?
A class is a blueprint or template for creating objects. It defines what data an object will hold and what operations it can perform.

```java
// Basic class structure
public class Car {
    // Fields (attributes/properties)
    String brand;
    String model;
    int year;
    
    // Methods (behaviors)
    void startEngine() {
        System.out.println("Engine started!");
    }
    
    void stopEngine() {
        System.out.println("Engine stopped!");
    }
}
```

### What is an Object?
An object is an instance of a class. It's the actual entity created from the class blueprint.

```java
public class Main {
    public static void main(String[] args) {
        // Creating objects (instances)
        Car myCar = new Car();        // Object 1
        Car friendsCar = new Car();   // Object 2
        
        // Setting values
        myCar.brand = "Toyota";
        myCar.model = "Camry";
        myCar.year = 2023;
        
        friendsCar.brand = "Honda";
        friendsCar.model = "Civic";
        friendsCar.year = 2022;
        
        // Calling methods
        myCar.startEngine();     // Output: Engine started!
        friendsCar.startEngine(); // Output: Engine started!
    }
}
```

### Real-World Example: Student Class

```java
public class Student {
    // Fields
    String name;
    int rollNumber;
    String course;
    double gpa;
    
    // Methods
    void study() {
        System.out.println(name + " is studying");
    }
    
    void attendClass() {
        System.out.println(name + " is attending class");
    }
    
    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Course: " + course);
        System.out.println("GPA: " + gpa);
    }
}

// Usage
public class StudentTest {
    public static void main(String[] args) {
        Student student1 = new Student();
        student1.name = "Alice";
        student1.rollNumber = 101;
        student1.course = "Computer Science";
        student1.gpa = 3.8;
        
        student1.displayInfo();
        student1.study();
    }
}
```

---

## Access Modifiers

Access modifiers control the visibility and accessibility of classes, methods, and variables.

### Types of Access Modifiers:

#### 1. **public** - Accessible from anywhere
```java
public class PublicExample {
    public String publicField = "Everyone can see this";
    
    public void publicMethod() {
        System.out.println("This method is accessible from anywhere");
    }
}
```

#### 2. **private** - Accessible only within the same class
```java
public class PrivateExample {
    private String secretData = "Only this class can access";
    private int privateNumber = 42;
    
    private void secretMethod() {
        System.out.println("This is a private method");
    }
    
    // Public method to access private data
    public String getSecretData() {
        return secretData;
    }
    
    public void callSecretMethod() {
        secretMethod(); // Can call private method from within same class
    }
}
```

#### 3. **protected** - Accessible within same package and subclasses
```java
public class ProtectedExample {
    protected String protectedData = "Package and subclasses can access";
    
    protected void protectedMethod() {
        System.out.println("Protected method");
    }
}
```

#### 4. **default (package-private)** - Accessible within same package only
```java
class DefaultExample {  // No access modifier = default
    String packageData = "Only same package can access";
    
    void packageMethod() {
        System.out.println("Package-private method");
    }
}
```

### Access Modifier Comparison Table:

| Modifier | Same Class | Same Package | Subclass | Different Package |
|----------|------------|--------------|----------|-------------------|
| public   | ✓          | ✓            | ✓        | ✓                 |
| protected| ✓          | ✓            | ✓        | ✗                 |
| default  | ✓          | ✓            | ✗        | ✗                 |
| private  | ✓          | ✗            | ✗        | ✗                 |

### Best Practices Example:

```java
public class BankAccount {
    private double balance;        // Private - sensitive data
    private String accountNumber;  // Private - sensitive data
    
    public String ownerName;       // Public - can be accessed freely
    
    // Public methods to interact with private data
    public double getBalance() {
        return balance;
    }
    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        }
    }
    
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Invalid withdrawal amount");
        }
    }
    
    private void logTransaction(String type, double amount) {
        // Private method for internal use only
        System.out.println("Transaction: " + type + " - $" + amount);
    }
}
```

---

## Method Parameters and Return Types

### Method Syntax:
```java
accessModifier returnType methodName(parameterType parameterName) {
    // method body
    return value; // if return type is not void
}
```

### 1. Methods with No Parameters and No Return (void)

```java
public class MethodExamples {
    public void sayHello() {
        System.out.println("Hello!");
    }
    
    public void showCurrentTime() {
        System.out.println("Current time: " + new java.util.Date());
    }
}
```

### 2. Methods with Parameters but No Return

```java
public class Calculator {
    public void printSum(int a, int b) {
        int sum = a + b;
        System.out.println("Sum: " + sum);
    }
    
    public void greetUser(String name, int age) {
        System.out.println("Hello " + name + ", you are " + age + " years old");
    }
    
    public void displayStudentInfo(String name, int rollNo, double gpa) {
        System.out.println("Student: " + name);
        System.out.println("Roll No: " + rollNo);
        System.out.println("GPA: " + gpa);
    }
}
```

### 3. Methods with Return Types but No Parameters

```java
public class DataProvider {
    public int getCurrentYear() {
        return 2024;
    }
    
    public String getWelcomeMessage() {
        return "Welcome to our application!";
    }
    
    public double getPiValue() {
        return 3.14159;
    }
    
    public boolean isSystemReady() {
        return true;
    }
}
```

### 4. Methods with Both Parameters and Return Types

```java
public class MathOperations {
    public int add(int a, int b) {
        return a + b;
    }
    
    public double multiply(double x, double y) {
        return x * y;
    }
    
    public String concatenateStrings(String first, String second) {
        return first + " " + second;
    }
    
    public boolean isEven(int number) {
        return number % 2 == 0;
    }
    
    public int findMaximum(int a, int b, int c) {
        int max = a;
        if (b > max) max = b;
        if (c > max) max = c;
        return max;
    }
}
```

### 5. Methods with Different Return Types

```java
public class Employee {
    private String name;
    private int id;
    private double salary;
    private boolean isActive;
    
    // String return type
    public String getName() {
        return name;
    }
    
    // int return type
    public int getId() {
        return id;
    }
    
    // double return type
    public double getSalary() {
        return salary;
    }
    
    // boolean return type
    public boolean isActive() {
        return isActive;
    }
    
    // Object return type
    public Employee createNewEmployee(String name, int id, double salary) {
        Employee emp = new Employee();
        emp.name = name;
        emp.id = id;
        emp.salary = salary;
        emp.isActive = true;
        return emp;
    }
    
    // Array return type
    public int[] getWorkingHours() {
        return new int[]{8, 9, 8, 8, 7}; // Mon-Fri hours
    }
}
```

### 6. Method Overloading (Same name, different parameters)

```java
public class OverloadingExample {
    // Different number of parameters
    public int add(int a, int b) {
        return a + b;
    }
    
    public int add(int a, int b, int c) {
        return a + b + c;
    }
    
    // Different parameter types
    public double add(double a, double b) {
        return a + b;
    }
    
    public String add(String a, String b) {
        return a + b;
    }
    
    // Different parameter order
    public void displayInfo(String name, int age) {
        System.out.println("Name: " + name + ", Age: " + age);
    }
    
    public void displayInfo(int age, String name) {
        System.out.println("Age: " + age + ", Name: " + name);
    }
}
```

### 7. Practical Example: Library Management System

```java
public class Book {
    private String title;
    private String author;
    private int pages;
    private boolean isAvailable;
    
    // Constructor
    public Book(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.isAvailable = true;
    }
    
    // Getter methods (return values, no parameters)
    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public int getPages() {
        return pages;
    }
    
    public boolean isAvailable() {
        return isAvailable;
    }
    
    // Setter methods (no return, take parameters)
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    // Business logic methods
    public boolean borrowBook(String borrowerName) {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Book '" + title + "' borrowed by " + borrowerName);
            return true;
        } else {
            System.out.println("Book is not available");
            return false;
        }
    }
    
    public void returnBook() {
        isAvailable = true;
        System.out.println("Book '" + title + "' has been returned");
    }
    
    public String getBookInfo() {
        return "Title: " + title + ", Author: " + author + 
               ", Pages: " + pages + ", Available: " + isAvailable;
    }
    
    // Method with multiple parameters and return
    public double calculateReadingTime(int readingSpeed) {
        // readingSpeed in pages per hour
        return (double) pages / readingSpeed;
    }
}

// Usage example
public class LibraryTest {
    public static void main(String[] args) {
        Book book1 = new Book("Java Programming", "John Doe", 500);
        
        System.out.println(book1.getBookInfo());
        
        boolean borrowed = book1.borrowBook("Alice");
        System.out.println("Borrowed successfully: " + borrowed);
        
        double readingTime = book1.calculateReadingTime(50);
        System.out.println("Estimated reading time: " + readingTime + " hours");
        
        book1.returnBook();
    }
}
```

---

## Constructors

Constructors are special methods used to initialize objects when they are created.

### Default Constructor
```java
public class Student {
    String name;
    int age;
    
    // Default constructor (no parameters)
    public Student() {
        name = "Unknown";
        age = 0;
        System.out.println("Default constructor called");
    }
}
```

### Parameterized Constructor
```java
public class Student {
    String name;
    int age;
    String course;
    
    // Parameterized constructor
    public Student(String studentName, int studentAge, String studentCourse) {
        name = studentName;
        age = studentAge;
        course = studentCourse;
        System.out.println("Student created: " + name);
    }
}
```

### Constructor Overloading
```java
public class Student {
    String name;
    int age;
    String course;
    double gpa;
    
    // Default constructor
    public Student() {
        this("Unknown", 0, "Not Assigned", 0.0);
    }
    
    // Constructor with name only
    public Student(String name) {
        this(name, 0, "Not Assigned", 0.0);
    }
    
    // Constructor with name and age
    public Student(String name, int age) {
        this(name, age, "Not Assigned", 0.0);
    }
    
    // Full constructor
    public Student(String name, int age, String course, double gpa) {
        this.name = name;
        this.age = age;
        this.course = course;
        this.gpa = gpa;
    }
}
```

---

## Inheritance

Inheritance allows a class to inherit properties and methods from another class.

### Basic Inheritance
```java
// Parent class (Superclass)
public class Animal {
    protected String name;
    protected int age;
    
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public void eat() {
        System.out.println(name + " is eating");
    }
    
    public void sleep() {
        System.out.println(name + " is sleeping");
    }
}

// Child class (Subclass)
public class Dog extends Animal {
    private String breed;
    
    public Dog(String name, int age, String breed) {
        super(name, age); // Call parent constructor
        this.breed = breed;
    }
    
    public void bark() {
        System.out.println(name + " is barking");
    }
    
    // Override parent method
    @Override
    public void eat() {
        System.out.println(name + " the dog is eating dog food");
    }
}
```

### Method Overriding
```java
public class Vehicle {
    public void start() {
        System.out.println("Vehicle is starting");
    }
    
    public void stop() {
        System.out.println("Vehicle is stopping");
    }
}

public class Car extends Vehicle {
    @Override
    public void start() {
        System.out.println("Car engine is starting with a key");
    }
    
    public void honk() {
        System.out.println("Car is honking");
    }
}

public class Motorcycle extends Vehicle {
    @Override
    public void start() {
        System.out.println("Motorcycle is kick-started");
    }
    
    public void wheelie() {
        System.out.println("Motorcycle doing a wheelie");
    }
}
```

---

## Polymorphism

Polymorphism allows objects of different classes to be treated as objects of a common base class.

### Runtime Polymorphism
```java
public class Shape {
    public void draw() {
        System.out.println("Drawing a shape");
    }
    
    public double getArea() {
        return 0;
    }
}

public class Circle extends Shape {
    private double radius;
    
    public Circle(double radius) {
        this.radius = radius;
    }
    
    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }
    
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}

public class Rectangle extends Shape {
    private double width, height;
    
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    
    @Override
    public void draw() {
        System.out.println("Drawing a rectangle");
    }
    
    @Override
    public double getArea() {
        return width * height;
    }
}

// Polymorphism in action
public class PolymorphismDemo {
    public static void main(String[] args) {
        Shape[] shapes = {
            new Circle(5),
            new Rectangle(4, 6),
            new Circle(3)
        };
        
        for (Shape shape : shapes) {
            shape.draw();           // Calls appropriate draw method
            System.out.println("Area: " + shape.getArea());
        }
    }
}
```

---

## Encapsulation

Encapsulation is bundling data and methods together while restricting access to internal details.

```java
public class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private String pin;
    
    public BankAccount(String accountNumber, String accountHolder, String pin) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.pin = pin;
        this.balance = 0.0;
    }
    
    // Controlled access to balance
    public double getBalance(String enteredPin) {
        if (validatePin(enteredPin)) {
            return balance;
        } else {
            System.out.println("Invalid PIN");
            return -1;
        }
    }
    
    public void deposit(double amount, String enteredPin) {
        if (validatePin(enteredPin) && amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid PIN or amount");
        }
    }
    
    public void withdraw(double amount, String enteredPin) {
        if (validatePin(enteredPin) && amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Invalid PIN, amount, or insufficient funds");
        }
    }
    
    private boolean validatePin(String enteredPin) {
        return pin.equals(enteredPin);
    }
    
    // Getters for safe access
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public String getAccountHolder() {
        return accountHolder;
    }
}
```

---

## Abstraction

Abstraction hides implementation details and shows only essential features.

### Abstract Classes
```java
public abstract class Employee {
    protected String name;
    protected int id;
    protected double baseSalary;
    
    public Employee(String name, int id, double baseSalary) {
        this.name = name;
        this.id = id;
        this.baseSalary = baseSalary;
    }
    
    // Concrete method
    public void displayInfo() {
        System.out.println("Name: " + name + ", ID: " + id);
    }
    
    // Abstract methods - must be implemented by subclasses
    public abstract double calculateSalary();
    public abstract void performDuties();
}

public class Manager extends Employee {
    private double bonus;
    
    public Manager(String name, int id, double baseSalary, double bonus) {
        super(name, id, baseSalary);
        this.bonus = bonus;
    }
    
    @Override
    public double calculateSalary() {
        return baseSalary + bonus;
    }
    
    @Override
    public void performDuties() {
        System.out.println(name + " is managing the team");
    }
}

public class Developer extends Employee {
    private String programmingLanguage;
    
    public Developer(String name, int id, double baseSalary, String language) {
        super(name, id, baseSalary);
        this.programmingLanguage = language;
    }
    
    @Override
    public double calculateSalary() {
        return baseSalary * 1.1; // 10% tech bonus
    }
    
    @Override
    public void performDuties() {
        System.out.println(name + " is coding in " + programmingLanguage);
    }
}
```

---

## Interfaces

Interfaces define contracts that implementing classes must follow.

### Basic Interface
```java
public interface Drawable {
    // Interface methods are public and abstract by default
    void draw();
    void setColor(String color);
    
    // Default method (Java 8+)
    default void display() {
        System.out.println("Displaying the drawable object");
    }
    
    // Static method (Java 8+)
    static void printInfo() {
        System.out.println("This is a drawable interface");
    }
}

public class Circle implements Drawable {
    private String color;
    private double radius;
    
    public Circle(double radius) {
        this.radius = radius;
    }
    
    @Override
    public void draw() {
        System.out.println("Drawing a " + color + " circle with radius " + radius);
    }
    
    @Override
    public void setColor(String color) {
        this.color = color;
    }
}
```

### Multiple Interface Implementation
```java
public interface Flyable {
    void fly();
    void land();
}

public interface Swimmable {
    void swim();
    void dive();
}

public class Duck implements Flyable, Swimmable {
    private String name;
    
    public Duck(String name) {
        this.name = name;
    }
    
    @Override
    public void fly() {
        System.out.println(name + " is flying");
    }
    
    @Override
    public void land() {
        System.out.println(name + " is landing");
    }
    
    @Override
    public void swim() {
        System.out.println(name + " is swimming");
    }
    
    @Override
    public void dive() {
        System.out.println(name + " is diving");
    }
}
```

---

## Advanced Topics

### 1. Static Members
```java
public class Counter {
    private static int count = 0;  // Static variable
    private int instanceNumber;
    
    public Counter() {
        count++;                   // Increment static variable
        instanceNumber = count;    // Set instance number
    }
    
    public static int getCount() { // Static method
        return count;
    }
    
    public int getInstanceNumber() {
        return instanceNumber;
    }
    
    // Static block - runs when class is first loaded
    static {
        System.out.println("Counter class loaded");
    }
}
```

### 2. Inner Classes
```java
public class OuterClass {
    private String outerField = "Outer Field";
    
    // Non-static inner class
    public class InnerClass {
        public void display() {
            System.out.println("Accessing: " + outerField);
        }
    }
    
    // Static nested class
    public static class StaticNestedClass {
        public void display() {
            System.out.println("Static nested class method");
        }
    }
    
    // Method with local inner class
    public void methodWithLocalClass() {
        class LocalClass {
            public void localMethod() {
                System.out.println("Local class method");
            }
        }
        
        LocalClass local = new LocalClass();
        local.localMethod();
    }
}
```

### 3. Final Keyword
```java
public final class FinalClass {  // Cannot be extended
    private final int CONSTANT = 100;  // Cannot be changed
    
    public final void finalMethod() {  // Cannot be overridden
        System.out.println("This method cannot be overridden");
    }
}
```

### 4. Object Class Methods
```java
public class Person {
    private String name;
    private int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return age == person.age && name.equals(person.name);
    }
    
    @Override
    public int hashCode() {
        return name.hashCode() + age;
    }
}
```

---

## Complete Example: E-commerce System

```java
// Abstract base class
public abstract class Product {
    protected String name;
    protected double price;
    protected String category;
    
    public Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }
    
    public abstract double calculateDiscountedPrice();
    public abstract void displayProductInfo();
    
    // Getters
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }
}

// Interface for discountable items
public interface Discountable {
    double applyDiscount(double discountPercentage);
    boolean isEligibleForDiscount();
}

// Concrete product class
public class Electronics extends Product implements Discountable {
    private String brand;
    private int warrantyMonths;
    
    public Electronics(String name, double price, String brand, int warrantyMonths) {
        super(name, price, "Electronics");
        this.brand = brand;
        this.warrantyMonths = warrantyMonths;
    }
    
    @Override
    public double calculateDiscountedPrice() {
        if (isEligibleForDiscount()) {
            return applyDiscount(10); // 10% discount for electronics
        }
        return price;
    }
    
    @Override
    public void displayProductInfo() {
        System.out.println("Electronics: " + name);
        System.out.println("Brand: " + brand);
        System.out.println("Price: $" + price);
        System.out.println("Warranty: " + warrantyMonths + " months");
    }
    
    @Override
    public double applyDiscount(double discountPercentage) {
        return price * (1 - discountPercentage / 100);
    }
    
    @Override
    public boolean isEligibleForDiscount() {
        return price > 100; // Electronics over $100 get discount
    }
}

// Shopping cart class
public class ShoppingCart {
    private java.util.List<Product> products;
    
    public ShoppingCart() {
        products = new java.util.ArrayList<>();
    }
    
    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Added: " + product.getName());
    }
    
    public double calculateTotal() {
        double total = 0;
        for (Product product : products) {
            total += product.calculateDiscountedPrice();
        }
        return total;
    }
    
    public void displayCart() {
        System.out.println("\n--- Shopping Cart ---");
        for (Product product : products) {
            product.displayProductInfo();
            System.out.println("Discounted Price: $" + product.calculateDiscountedPrice());
            System.out.println("---");
        }
        System.out.println("Total: $" + calculateTotal());
    }
}

// Main class to test the system
public class ECommerceTest {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        
        Electronics laptop = new Electronics("Gaming Laptop", 1200.0, "ASUS", 24);
        Electronics phone = new Electronics("Smartphone", 800.0, "Samsung", 12);
        
        cart.addProduct(laptop);
        cart.addProduct(phone);
        
        cart.displayCart();
    }
}
```

---

## Key Takeaways

1. **Classes** are blueprints; **Objects** are instances
2. **Access Modifiers** control visibility: private → default → protected → public
3. **Methods** can have parameters and return types in various combinations
4. **Encapsulation** protects data through private fields and public methods
5. **Inheritance** promotes code reuse through extends keyword
6. **Polymorphism** allows treating different objects uniformly
7. **Abstraction** hides complexity through abstract classes and interfaces
8. **Interfaces** define contracts that classes must implement

### Best Practices:
- Use private fields with public getter/setter methods
- Follow naming conventions (PascalCase for classes, camelCase for methods/variables)
- Write meaningful method and variable names
- Keep methods focused on single responsibilities
- Use inheritance and interfaces appropriately
- Always override toString(), equals(), and hashCode() when needed

This guide covers the fundamental to advanced OOP concepts in Java. Practice these concepts with real-world examples to master object-oriented programming!