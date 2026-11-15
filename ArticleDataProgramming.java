package org.example;

import java.util.Arrays;

public class ArticleDataProgramming {

    public static void load(ArticleManager manager) {

        manager.addArticle(new Article(

            9,

            "Python Programming",

            "Programming",

            "An introduction to Python, including its history, main features, basic syntax, data types, control structures, functions, applications, and why it is popular for beginners.",

            // DEFINITION
            "Python is a high-level, general-purpose programming language known for its clear and readable syntax. It supports several programming styles, including procedural, object-oriented, and functional programming. Python code is usually run by an interpreter, which reads and executes the program line by line.",

            // HISTORY
            "Python was created by Guido van Rossum and first released in 1991. The name comes from the British comedy group Monty Python, not from the snake. Python 2 was released in 2000, and Python 3 followed in 2008 with changes that were not fully compatible with Python 2. Python 2 reached its end of life in 2020, so new programs use Python 3.",

            // CORE CONCEPTS
            "1. Interpreter: The program that reads Python code and runs it directly.\n\n" +
            "2. Indentation: Python uses spaces at the start of a line to show which statements belong together, instead of curly braces.\n\n" +
            "3. Dynamic Typing: A variable does not need a declared type. Its type is decided by the value it holds.\n\n" +
            "4. Built-in Data Types: Numbers (int, float), text (str), True or False (bool), and collections such as list, tuple, dict, and set.\n\n" +
            "5. Functions: Reusable blocks of code defined with the def keyword.\n\n" +
            "6. Modules and Libraries: Files of ready-made code that you load with import.\n\n" +
            "7. Standard Library: A large set of modules that come with Python, such as math and random.",

            // HOW IT WORKS
            "When you run a Python program, the interpreter first translates the source code into an intermediate form called bytecode. It then executes that bytecode using the Python Virtual Machine. Because this happens each time the program runs, you can write a line of code and see its result immediately, which makes Python good for learning and quick testing. Python also manages memory automatically through garbage collection.",

            // TYPES AND CLASSIFICATIONS
            "Python is used in several styles and environments:\n\n" +
            "1. Procedural Programming: Writing a program as a sequence of steps and functions.\n\n" +
            "2. Object-Oriented Programming: Organizing code into classes and objects.\n\n" +
            "3. Functional Programming: Using functions as values, such as passing a function to another function.\n\n" +
            "Python is also commonly used for scripting, which means writing short programs that automate tasks.",

            // PRACTICAL EXAMPLES
            "Example 1: Display a message.\n\n" +
            "print(\"Hello, World!\")\n\n" +
            "Example 2: A conditional statement and a loop.\n\n" +
            "score = 85\n" +
            "if score >= 75:\n" +
            "    print(\"Passed\")\n" +
            "else:\n" +
            "    print(\"Failed\")\n\n" +
            "for i in range(1, 6):\n" +
            "    print(i)\n\n" +
            "Example 3: A function.\n\n" +
            "def add(a, b):\n" +
            "    return a + b\n\n" +
            "print(add(2, 3))\n\n" +
            "Explanation:\n" +
            "- print() displays a value on the screen.\n" +
            "- The indented lines belong to the if, else, for, and def statements above them.\n" +
            "- range(1, 6) produces the numbers 1 to 5.\n" +
            "- return sends a value back to the code that called the function.",

            // APPLICATIONS
            "1. Web Development: Server-side programs built with frameworks such as Django and Flask.\n\n" +
            "2. Data Science and Analysis: Working with data using libraries such as pandas and NumPy.\n\n" +
            "3. Artificial Intelligence and Machine Learning: Libraries such as TensorFlow and scikit-learn.\n\n" +
            "4. Automation and Scripting: Renaming files, collecting data, and repeating routine tasks.\n\n" +
            "5. Education: Python is widely used to teach programming to beginners.",

            // ADVANTAGES
            "Python has simple, readable syntax that is easy to learn, a very large collection of libraries, and an active community. It runs on common operating systems and lets programmers build working programs with fewer lines of code than many other languages.",

            // LIMITATIONS
            "Python programs usually run more slowly than programs written in compiled languages such as C++ or Java. Because types are checked while the program runs, some errors only appear at that time. Python is also less common for mobile apps and for work that needs very close control of hardware.",

            // RELATED TOPICS
            "Java Programming, Object-Oriented Programming, Data Structures and Algorithms, Data Science, Machine Learning, Web Frameworks, Automation.",

            // REFERENCES
            Arrays.asList(
                "The Python Tutorial - Python.org: https://docs.python.org/3/tutorial/",
                "Python (programming language) - Wikipedia: https://en.wikipedia.org/wiki/Python_(programming_language)",
                "Python - Encyclopaedia Britannica: https://www.britannica.com/technology/Python-computer-language"
            )

        ));

        manager.addArticle(new Article(

            10,

            "Object-Oriented Programming",

            "Programming",

            "An introduction to object-oriented programming, including classes and objects, the four main principles, how they work together, a Java example, and the benefits and limits of the approach.",

            // DEFINITION
            "Object-oriented programming (OOP) is a way of designing programs around objects instead of only functions and steps. An object combines data, called fields or attributes, with the actions that work on that data, called methods. Objects are created from classes, which act as blueprints.",

            // HISTORY
            "The ideas behind OOP began with the Simula language in the 1960s, which introduced classes and objects. In the 1970s, Smalltalk developed the approach further. C++ added object-oriented features to C in the 1980s, and Java, released in 1995, made OOP a standard way of teaching and building software. Languages such as Python and C# also support OOP.",

            // CORE CONCEPTS
            "1. Class: A blueprint that defines the fields and methods that its objects will have.\n\n" +
            "2. Object: A specific instance created from a class. For example, a Student class can create many Student objects.\n\n" +
            "3. Field (Attribute): A variable that stores the state of an object, such as a name or an age.\n\n" +
            "4. Method: A block of code that defines what an object can do.\n\n" +
            "5. Constructor: A special method that sets up a new object when it is created.\n\n" +
            "6. Access Modifiers: Keywords such as public and private that control who can use a field or a method.\n\n" +
            "7. Instance: Another word for an object that was created from a class.",

            // HOW IT WORKS
            "In an OOP program, the developer first writes classes to describe the kinds of things the program deals with. While the program runs, objects are created from those classes, and the objects interact by calling each other's methods. Each object keeps its own data, so two Student objects can hold different names while sharing the same methods. Programmers can build new classes on top of existing ones, which saves effort and keeps related code together.",

            // TYPES AND CLASSIFICATIONS
            "The four principles of OOP are:\n\n" +
            "1. Encapsulation: Keeping data private inside a class and allowing access only through public methods such as getters and setters. This protects the data from accidental changes.\n\n" +
            "2. Inheritance: Letting a class reuse the fields and methods of another class. For example, a Student class can inherit from a Person class.\n\n" +
            "3. Polymorphism: Letting the same method name behave differently for different object types. For example, a speak() method can produce different sounds for a Dog and a Cat.\n\n" +
            "4. Abstraction: Showing only the essential features of an object and hiding the internal details. Abstract classes and interfaces are tools for this.",

            // PRACTICAL EXAMPLES
            "Example: A Java class with encapsulation and a constructor.\n\n" +
            "public class Student {\n" +
            "    private String name;\n\n" +
            "    public Student(String name) {\n" +
            "        this.name = name;\n" +
            "    }\n\n" +
            "    public String getName() {\n" +
            "        return name;\n" +
            "    }\n" +
            "}\n\n" +
            "Student s = new Student(\"Alex\");\n" +
            "System.out.println(s.getName());\n\n" +
            "Explanation:\n" +
            "- The name field is private, so other classes cannot change it directly.\n" +
            "- The constructor sets the name when the object is created.\n" +
            "- getName() is a public method that lets other code read the name.\n" +
            "- new Student(\"Alex\") creates an object from the class.\n\n" +
            "This is the same pattern used by the Article class in Search IT.",

            // APPLICATIONS
            "1. Business Applications: Modeling customers, products, and orders as objects.\n\n" +
            "2. Games: Players, enemies, and items are often objects.\n\n" +
            "3. Graphical User Interfaces: Buttons, windows, and menus are objects.\n\n" +
            "4. Large Software Systems: Dividing a big program into classes makes it easier for teams to work on.\n\n" +
            "5. Mobile and Web Applications: Common frameworks are built around classes and objects.",

            // ADVANTAGES
            "OOP makes code easier to organize, reuse, and maintain. Encapsulation protects data, inheritance reduces repeated code, and modeling real-world things as objects often makes programs easier to understand. Large programs can be divided among several developers.",

            // LIMITATIONS
            "OOP can add extra complexity for small programs, and a poorly planned class design can become hard to change. Beginners may find the concepts harder to learn than simple step-by-step programming. Programs with many objects can also use more memory than simpler designs.",

            // RELATED TOPICS
            "Java Programming, Python Programming, Classes and Objects, Inheritance, Polymorphism, Design Patterns, UML Diagrams, Data Structures and Algorithms.",

            // REFERENCES
            Arrays.asList(
                "Object-oriented programming - Wikipedia: https://en.wikipedia.org/wiki/Object-oriented_programming",
                "Lesson: Object-Oriented Programming Concepts - Oracle: https://docs.oracle.com/javase/tutorial/java/concepts/",
                "Object-oriented programming - Encyclopaedia Britannica: https://www.britannica.com/technology/object-oriented-programming"
            )

        ));

    }
}