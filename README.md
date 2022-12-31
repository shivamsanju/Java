<div align='center'><h1>JAVA NOTES</h1></div>

# Java Architecture
- Object oriented programing language (although has primitive types)

- Both compiled and interpreted - code is compiled to byte code first then interpreted by JVM.

- Since the bytecode is interpreted by JVM, java code is platform independent.

- Source Code -> Compiler -> Byte Code -> JVM -> OS

- JDK (Java Development Kit) -> includes Compiler, Java runtime environment (JRE), Debuggers & Java documentation

- JRE (Java Runtime Environment) -> Java Virtual Machine + Java Class Libraries + Java Class Loaders (Doesn't have a compiler)

- Class Loaders are used to read .class files containing bytecode and put them into memory.

- JDK gives compiler which compiles Java code to byte code & then JVM runs that byte code.

- Earlier JVM's were slow and only interpreted one bytecode at a time. Nowadays the modern JVM's are much faster as they use JIT(just-in-time) compilation units. These JVMs can execute various tasks at the same time.

- Insode Java programmers cannot delete the objects so JVM has a garbage collector.

- Garbage Collector collects the objects which are no more refrenced and deletes it. So JVM makes it easy for programmers by managing memory.

- Classpath is a particular file path where both the Java runtime and Java compiler look for .class files to appear.
-----------
<br>

# Object Oriented Programming
- **Inheritance** -  Inheritance can be defined as an object acquiring all the behaviors and properties of a parent object.

- **Polymorphism** - When we perform a single task in multiple ways, it can be defined as polymorphism. Achieved via method overloading and method overriding.
    - **Method Overloading:** When multiple methods in a class have same name but different parameters.
    - **Method Overriding:** When method name and parameters are same in parent and child class we call it overriding.

- **Abstraction** - Abstraction is the concept of hiding internal implementation details and exposing only the required functionalities to the end users. Done using interfaces and abstract classes.

- **Encapsulation** - When data is bonded or wrapped together into one single unit, we can call it encapsulation. All the data and methods operating on the data are enclosed in the same unit.
--------------
<br>

# Java Benefits
- **Multithreaded:** Makes it easy for us to write programs that are able enough to perform multiple tasks simultaneously.

- **High Performance:** It uses the JIT(Java In Time) compiler where it only compiles the methods that we call which makes the applications execute faster.

- **Distributed:** It helps us to share the objects across two connected JVMs using Remote Method Invocation(RMI).
---------------
<br>

# Anatomy of Java Program

```Java
// Here, we import classes from the packages. 
import java.io.*;

// This is the main class.
public class Main {

    // This is the main driver method.
    public static void main(String[] args) {
        // This is the standard print statement
        System.out.println("Welcome to ScalerTopics");
    }
}
```
- ***import java.io*** - import is a keyword that includes classes we are using in the code. This is used to import all the classes from the io package.

- ***public class*** - The data and methods that need to be used in the program are included in the class. Methods define the behavior of the class.

- ***public static*** - Static methods do not require objects to get called. They can be executed using the dot operator with the class name.

- ***void*** - Does not return any value. It's an empty void.

- ***main()*** - Name of the method. Entry point method where JVM runs the program.

- ***(String[ ] args)*** - These are used as command-line arguments and are passed as strings.

- ***System.out.println*** - This command prints the contents provided within the print statement. 
-----------------
<br>

# Memory Management in Java
- Java Programs are executed in RAM of the computers. 

- This allocated memory in RAM is called Application Memory. 

- The amount of memory allocated to a Java process depends on multiple factors like Java Runtime Environment (JRE), operating system, processor, etc.
</br>

## Stack Memory
- Stack memory is the static memory allocation scheme where all the function calls, primitive data values and references to objects in the heap memory are stored. 

- Access to stack memory is based on Last in first out (LIFO) basis. It is faster than heap memory access.

- A new memory block is created in stack for each method call. All the primitive data values specific to this method and references to objects from the method are stored in this memory block.

- When the method completes execution, the stack memory is cleared and is availaible for use.

- The size of the stack memory is fixed and cannot grow or shrink once created.

- **StackOverflowError** - Since the stack memory is limited and cannot grow, when we use all of the stack memory and cannot store upcoming method calls, we get a stack overflow error.

- Each thread has a new stack allocated to it, so stack memory is thread safe. 


## Heap Memory 
- Heap memory is used for dynamic memory allocation of objects and classes created during program execution.

- The access to the heap memory is random and global thus slower than stack memory access.

- The size of the heap memory is larger compared to stack memory. The unused objects in heap are cleared automatically by the garbage collector.\

- **OutOfMemoryError** - It is thrown when there is no more space left in the heap to create and store a new object. This happens when the Garbage Collector could not freeup any space to store new objects.

- Heap memory is shated across threads so it is not thread safe.

- The heap memory can be divided into 3 parts:
    1. **New or Young Generation** - The newly created objects are stored into this memory.
    
    2. **Old or Tenured Generation** : The objects in new generation have a age set. When that age is met, the live objects in new generation is moved to old generation.
    3. **Permanent Generation** : Permanent generation is used by JVM to store metadata about the classes and methods. JVM also stores standard libraries in permanent generation.

------
</br>

# Classes and Objects in Java
- Java is a class manadatory programming language. As a result, we think of a problem in the world in terms of objects and perform actions through calling their associated set of methods.

- A Java program can have multiple classes, but only one public class.

## Class
- In terms of design, there are three types of classes in Java:

    1. **Concrete Class** - Represents a concrete form of an object that may or may not be extended. Once specified as final a concrete class can no longer be extended.

    2. **Abstract Class** - Represents a set of rules a concrete class must satisfy. An abstract class may contain default implementation and abstract methods. One cannot create an object of an abstract class as it is meant to be a prototype of a class not to create objects.

    3. **Base Class** - Represents a parent class which other classes can extend. 


    ```Java
    // Access modifiers - public, private, protected, default

    // Qualifier - static, final, abstract

    abstract class AbstractClass {...}

    class BaseClass extends AbstractClass {...}

    final class ConcreteClass extends BaseClass {...}

    ```

## Creating a class

- The process of grouping together common features is known as abstraction

    ```Java
    package PackageTwo;

    abstract class AbstractShape{
        abstract double surfaceArea();
        abstract double volume();
        public String nameOfObject(){
            return "AbstractShape"
        }
    }
    ```

    ```Java
    package PackageOne;

    import java.lang.Math;
    import PackageTwo.AbstractShape; 

    class Sphere extends AbstractShape{        
        private double radius = 0.0;
        private double pi = Math.PI;
        
        public Sphere(double radius){
            this.radius = radius;
            System.out.println("Sphere constructor is called");
        }
        
        public double getRadius(){
            return this.radius;
        }
        
        public void setRadius(double radius){
            this.radius = radius;
        }
        
        @Override
        public double surfaceArea(){
            return 4*pi*Math.pow(radius,2); 
        }
        
        @Override
        public double volume(){
            return 4/3*pi*Math.pow(radius,3); 
        }

        @Override
        public String nameOfObject(){
            return "Sphere";
        }
    }
    ```

## Constructor
- Java constructors initialize an instantiated object based on preconditions set by the caller. 

- Constructors can be parameterized or specified without parameters.

- A class may contain multiple constructors that configure an instantiated object accordingly.

- A constructor doesn't return an explicit type

- Cannot be abstract, synchonized, static and final

    ```Java
    class Cube{
        //...
        private double side = 1.0;
        
        public Cube(){
            System.out.println("Cube Default constructor is called");
        }
        
        public Cube(double side){
            System.out.println("Cube instantiated with a value " + side);
            this.side = side;
        }
    }
    ```

## Access Modifiers

- **Default** - When no access modifier is specified, then it is said to have the default access modifier. It cannot be accessed from outside the package and is only accessible within that package.

- **Public** - The public access modifier is defined using the public keyword. This has the widest scope among access modifiers and this can be accessed anywhere within the program like within the class, outside the class, within the package and outside the package.

- **Private** - The private access modifier is defined using the private keyword. Methods or classes defined as private can be accessed within that method or class and not outside it.

- **Protected** - The protected access modifier is defined using the protected keyword. Methods or classes defined as protected can be accessed within that package and outside package by subclasses.


## Interfaces
- Because Java does not support multiple inheritance, subclasses can only extend one superclass. This limitation is addressed by a Java construct known as Interfaces.

- If a class is implementing an interface, it must have all the attributes and methods in it.

    ```Java
    interface Resizeable{
        public abstract void resize(double scale);
    }

    class Sphere extends AbstractShape implements Resizeable{
        //...
        @Override
        public void resize(double scale){
            this.radius *= scale; 
        }
    }
    ```

## Main Method
- This is a compulsory part of the Java code. 

- This is the entry point of the compiler where the execution actually starts. It is called/invoked by the Java Virtual Machine or JVM.


## Objects

- Objects are instances of a class.

    ```Java
    // class 1
    public class Sphere {
        private int radius;
    
        public Sphere(int radius){
            this.radius = radius;
        }
    }

    public class Main {
        public static void main(String[] args){
            Sphere sphere = new Sphere(10); // creating objects
        }
    }
    ```

## Anonymous Objects

- Anonymous objects are nameless entities that may be used for calling a specific method defined in a class without ever needing the entire class

- Nameless objects mean the class instance does not have a reference.

    ```Java
    System.out.println(new Cube(5.5).surfaceArea());
    ```
------
</br>

# Packages in Java

- A Java package is a collection of similar types of sub-packages, interfaces, and classes. 

- In Java, there are two types of packages: built-in packages and user-defined packages.

- Packages inside a packages can be created and are called subpackages.

- Packages can be imported within another package using import keyword.

- We can even use it directly by saying package.Class.method(). In this case we don't need to import it.
--------
</br>




