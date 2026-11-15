package org.example;

import java.util.Arrays;

public class ArticleData {

    public static void loadArticles(ArticleManager manager) {

        manager.addArticle(new Article(

            1,

            "Introduction to Programming",

            "Programming",

            "A comprehensive introduction to computer programming, including its definition, fundamental principles, execution process, programming language classifications, practical applications, and importance in software development.",

            // DEFINITION
            "Computer programming is the process of designing, writing, testing, and maintaining instructions that tell a computer how to perform specific tasks. These instructions are expressed using programming languages that follow defined syntax and rules. Programming involves problem analysis, algorithm design, implementation, testing, debugging, and maintenance. It is an essential activity in developing software, applications, websites, operating systems, and automated systems.",

            // HISTORY
            "The development of programming began with early ideas for representing computational instructions. In the nineteenth century, Ada Lovelace wrote an algorithm intended for Charles Babbage's proposed Analytical Engine. During the twentieth century, electronic computers introduced the need for practical machine instructions. Early programs were written using machine code and assembly language. Later, high-level languages such as FORTRAN, COBOL, BASIC, C, and Java made programming more accessible and supported increasingly complex software development.",

            // CORE CONCEPTS
            "1. Algorithms: A defined sequence of steps for solving a problem.\n\n" +
            "2. Variables: Named storage locations used to hold program data.\n\n" +
            "3. Data Types: Classifications that determine what kind of values data can represent and what operations are appropriate.\n\n" +
            "4. Operators: Symbols or keywords used to perform operations such as addition, comparison, and logical evaluation.\n\n" +
            "5. Conditional Statements: Structures that allow a program to make decisions based on conditions.\n\n" +
            "6. Loops: Structures that repeat instructions while a condition is satisfied or for a specified number of iterations.\n\n" +
            "7. Methods and Functions: Reusable blocks of code designed to perform particular tasks.\n\n" +
            "8. Debugging: The process of identifying, analyzing, and correcting errors in a program.",

            // HOW IT WORKS
            "Programming generally follows a problem-solving process. First, the developer identifies and analyzes the problem. Second, an algorithm or solution plan is designed. Third, the algorithm is translated into source code using a programming language. Depending on the language and its execution model, the code may be compiled, interpreted, or processed using a combination of techniques. The program is then tested to identify errors and verify its behavior. Finally, the software is maintained and improved as requirements change.",

            // TYPES AND CLASSIFICATIONS
            "Programming languages can be classified in several ways:\n\n" +
            "1. Machine Language: Instructions represented in binary form that a processor can execute directly.\n\n" +
            "2. Assembly Language: A low-level language that uses symbolic instructions corresponding closely to machine operations.\n\n" +
            "3. High-Level Languages: Languages that provide abstractions designed to make programming easier for humans. Examples include Java, Python, and C#.\n\n" +
            "Programming can also be organized by paradigm, including procedural, object-oriented, functional, and declarative programming.",

            // PRACTICAL EXAMPLES
            "Example: A simple Java program that displays a message:\n\n" +
            "public class Main {\n" +
            "    public static void main(String[] args) {\n" +
            "        System.out.println(\"Hello, World!\");\n" +
            "    }\n" +
            "}\n\n" +
            "Explanation:\n" +
            "- public class Main declares a class named Main.\n" +
            "- main() is the entry point of this Java application.\n" +
            "- System.out.println() displays text in the console.\n\n" +
            "This example demonstrates how source code expresses instructions that a Java runtime environment can execute.",

            // APPLICATIONS
            "Programming is used in many areas of technology:\n\n" +
            "1. Web Development: Creating websites, web applications, and server-side systems.\n\n" +
            "2. Mobile Development: Building applications for smartphones and tablets.\n\n" +
            "3. Business Systems: Developing inventory, payroll, accounting, and information management software.\n\n" +
            "4. Scientific Computing: Processing data, performing calculations, and modeling complex systems.\n\n" +
            "5. Automation: Controlling repetitive tasks and coordinating software or hardware operations.\n\n" +
            "6. Game Development: Creating game mechanics, graphics systems, and interactive experiences.",

            // ADVANTAGES
            "Programming allows developers to automate tasks, process large amounts of data, create customized software, solve complex problems, and build systems that can be maintained and improved. It also encourages logical thinking, structured problem-solving, and computational reasoning.",

            // LIMITATIONS
            "Programming requires technical knowledge, careful planning, testing, and ongoing maintenance. Software may contain errors, security weaknesses, or performance problems. Different languages and platforms also have different capabilities, limitations, and development requirements. A program must be designed and tested appropriately for its intended purpose.",

            // RELATED TOPICS
            "Algorithms, Flowcharts, Pseudocode, Programming Languages, Java Programming, Python Programming, Variables, Data Types, Control Structures, Object-Oriented Programming, Software Development.",

            // REFERENCES
            Arrays.asList(
                "Computer programming - Encyclopaedia Britannica: https://www.britannica.com/technology/computer-programming",
                "Java Documentation - Oracle: https://docs.oracle.com/en/java/",
                "Programming concepts - MDN Web Docs: https://developer.mozilla.org/en-US/docs/Learn_web_development"
            )

        ));
        
        manager.addArticle(new Article(

            4,

            "Introduction to Cybersecurity",

            "Cybersecurity",

            "An introduction to cybersecurity, including the goals of information security, common threats, how attacks happen, major defenses, practical examples, and why protecting systems and data matters.",

            // DEFINITION
            "Cybersecurity is the practice of protecting computers, networks, software, and data from unauthorized access, damage, theft, or disruption. Its purpose is to keep information and systems trustworthy and available to the people who are allowed to use them. Cybersecurity covers technology (such as firewalls and encryption), processes (such as backup and incident response), and people (such as training users to recognize scams).",

            // HISTORY
            "In 1971, a research program called Creeper moved between computers on the ARPANET and displayed a message, and it is often cited as an early example of a self-replicating program. In 1988, the Morris worm spread across the early Internet and slowed or disabled a large number of connected computers, which made organizations take network security seriously. As the Internet expanded in the 1990s and 2000s, viruses, online fraud, and large-scale data breaches became common, and cybersecurity grew into a major profession.",

            // CORE CONCEPTS
            "1. Confidentiality: Only authorized people can see the information. Example: only you and your school can view your grades.\n\n" +
            "2. Integrity: Information stays accurate and is not changed without permission. Example: no one can secretly alter a bank balance.\n\n" +
            "3. Availability: Systems and data can be used when needed. Example: a school portal still works during enrollment week.\n\n" +
            "These three goals are commonly called the CIA triad.\n\n" +
            "4. Authentication: Proving who you are, such as with a password or fingerprint.\n\n" +
            "5. Authorization: Deciding what a verified user is allowed to do.\n\n" +
            "6. Encryption: Converting data into a coded form so that only someone with the correct key can read it.\n\n" +
            "7. Vulnerability: A weakness in a system that an attacker might use.\n\n" +
            "8. Threat: Anything that could exploit a vulnerability, such as a hacker or malware.",

            // HOW IT WORKS
            "Cybersecurity works by using several layers of protection, an approach often called defense in depth. If one layer fails, another can still stop or limit the attack. For example, a firewall filters network traffic, antivirus software checks files, encryption protects stored and transmitted data, and access controls limit what each user can do. Organizations also monitor systems for unusual activity, keep software updated to fix known weaknesses, and keep backups so they can recover if an attack succeeds.",

            // TYPES AND CLASSIFICATIONS
            "Common threats include:\n\n" +
            "1. Malware: Harmful software such as viruses, worms, spyware, and ransomware. Ransomware locks files and demands payment to unlock them.\n\n" +
            "2. Phishing: Fake emails, messages, or websites that trick people into giving passwords or personal information.\n\n" +
            "3. Social Engineering: Manipulating people, rather than computers, into giving access or information.\n\n" +
            "4. Denial of Service (DoS/DDoS): Flooding a system with traffic so legitimate users cannot use it.\n\n" +
            "5. Injection Attacks: Sending specially crafted input, such as SQL injection, to make an application run unintended commands.\n\n" +
            "Cybersecurity is also divided into areas such as network security, application security, information security, and cloud security.",

            // PRACTICAL EXAMPLES
            "Example: A phishing attempt.\n\n" +
            "1. A student receives an email saying their school account will be closed unless they log in through a link.\n" +
            "2. The link opens a page that looks like the real login page but belongs to an attacker.\n" +
            "3. The student types their username and password, and the attacker now has them.\n\n" +
            "How to defend:\n" +
            "- Check the sender address and the website address before logging in.\n" +
            "- Do not click links in unexpected urgent messages. Open the official website yourself instead.\n" +
            "- Turn on multi-factor authentication so a stolen password alone is not enough.",

            // APPLICATIONS
            "1. Banking and Finance: Protecting accounts, transactions, and payment systems.\n\n" +
            "2. Healthcare: Protecting patient records and medical devices.\n\n" +
            "3. Education: Protecting student records and online learning platforms.\n\n" +
            "4. Government: Protecting public services and sensitive information.\n\n" +
            "5. Personal Use: Protecting email, social media, and mobile devices.",

            // ADVANTAGES
            "Good cybersecurity protects private information, prevents financial loss, keeps services running, and builds trust between users and organizations. It also helps organizations meet legal and professional requirements for protecting data.",

            // LIMITATIONS
            "No system can be made completely secure. Attackers keep finding new methods, security measures can make systems less convenient, and people may still make mistakes such as reusing weak passwords. Security also requires continuing cost, updates, and monitoring.",

            // RELATED TOPICS
            "Network Security, Cryptography, Ethical Hacking, Digital Forensics, Firewalls, Authentication, Data Privacy, Malware Analysis, Secure Software Development.",

            // REFERENCES
            Arrays.asList(
                "Computer security - Encyclopaedia Britannica: https://www.britannica.com/technology/computer-security",
                "Computer security - Wikipedia: https://en.wikipedia.org/wiki/Computer_security",
                "OWASP Top Ten: https://owasp.org/www-project-top-ten/"
            )

        ));

        manager.addArticle(new Article(

            5,

            "Introduction to Web Development",

            "Web Development",

            "An introduction to web development, including how websites work, the roles of HTML, CSS, and JavaScript, the difference between frontend and backend, practical examples, and applications.",

            // DEFINITION
            "Web development is the process of building and maintaining websites and web applications that run in a web browser. It combines designing how a page looks, programming how it behaves, and building the server-side systems that store data and respond to requests.",

            // HISTORY
            "The World Wide Web was proposed by Tim Berners-Lee at CERN in 1989, and the first website went online in 1991. Berners-Lee also created HTML, the HTTP protocol, and the first web browser. In the 1990s, CSS was introduced to style pages and JavaScript was introduced to make them interactive. Later, technologies for dynamic pages, databases, and mobile-friendly design turned simple documents into full applications such as online stores and social networks.",

            // CORE CONCEPTS
            "1. HTML (HyperText Markup Language): Defines the structure and content of a page, such as headings, paragraphs, and buttons.\n\n" +
            "2. CSS (Cascading Style Sheets): Controls appearance, such as colors, fonts, and layout.\n\n" +
            "3. JavaScript: Adds behavior, such as reacting to clicks and loading new data without reloading the page.\n\n" +
            "4. Browser: The program that downloads and displays web pages.\n\n" +
            "5. Server: A computer that stores website files or runs the code that answers requests.\n\n" +
            "6. HTTP: The protocol browsers and servers use to communicate.\n\n" +
            "7. API: A defined way for one program to request data or actions from another, often returning data as JSON.",

            // HOW IT WORKS
            "When you open a website, your browser sends an HTTP request to a server. The server finds or builds the correct response and sends it back, usually as HTML, CSS, and JavaScript files. The browser reads the HTML to build the page, applies the CSS to style it, and runs the JavaScript to make it interactive. If the page needs data, such as search results, the JavaScript can send another request to an API and update the page with the answer.",

            // TYPES AND CLASSIFICATIONS
            "1. Frontend Development: Everything the user sees and interacts with in the browser, using HTML, CSS, and JavaScript.\n\n" +
            "2. Backend Development: The server-side logic, databases, and APIs that process requests. It can be written in languages such as Java, Python, PHP, or JavaScript (Node.js).\n\n" +
            "3. Full-Stack Development: Working on both the frontend and the backend.\n\n" +
            "Websites are also described as static (the same files are sent to everyone) or dynamic (content is generated for each request).",

            // PRACTICAL EXAMPLES
            "Example: A small web page with structure, style, and behavior.\n\n" +
            "HTML:\n" +
            "<h1>Hello, Search IT</h1>\n\n" +
            "CSS:\n" +
            "h1 { color: blue; }\n\n" +
            "JavaScript:\n" +
            "console.log('Page loaded');\n\n" +
            "Explanation:\n" +
            "- The HTML creates a main heading.\n" +
            "- The CSS makes the heading blue.\n" +
            "- The JavaScript prints a message in the browser console.\n\n" +
            "Search IT itself works this way: its HTML page uses JavaScript to send a request to a Java server, and the server replies with article data in JSON.",

            // APPLICATIONS
            "1. E-Commerce: Online stores with products, carts, and payments.\n\n" +
            "2. Education: Learning platforms and school portals.\n\n" +
            "3. Social Media: Platforms for sharing posts and messages.\n\n" +
            "4. Business: Company websites and online booking systems.\n\n" +
            "5. Information Services: News sites, encyclopedias, and tools such as Search IT.",

            // ADVANTAGES
            "Web applications run in a browser, so users do not need to install them and can reach them from many devices. Updates are made once on the server and everyone receives them. Web technologies are widely documented and have large communities.",

            // LIMITATIONS
            "Web applications usually need an internet connection and can behave differently across browsers and screen sizes. They must be protected against attacks such as cross-site scripting and injection, and heavy pages can load slowly. Some device features are more limited than in native apps.",

            // RELATED TOPICS
            "HTML, CSS, JavaScript, HTTP, REST APIs, JSON, Responsive Design, Web Frameworks, Web Security, Databases.",

            // REFERENCES
            Arrays.asList(
                "Learn web development - MDN Web Docs: https://developer.mozilla.org/en-US/docs/Learn_web_development",
                "An overview of HTTP - MDN Web Docs: https://developer.mozilla.org/en-US/docs/Web/HTTP/Overview",
                "Web development - Wikipedia: https://en.wikipedia.org/wiki/Web_development"
            )

        ));

        manager.addArticle(new Article(

            2,

            "Introduction to Computer Networks",

            "Networking",

            "An introduction to computer networks, including their definition, components, network types, how data travels between devices, practical examples, and why networks matter in modern computing.",

            // DEFINITION
            "A computer network is a group of interconnected devices that can communicate and share resources such as files, printers, and internet access. Devices exchange information by following agreed rules called protocols. Networks may use cables, radio signals, or other transmission media to carry data.",

            // HISTORY
            "Computer networking developed from research in the 1960s. ARPANET, funded by the United States Department of Defense, connected research institutions and became an important predecessor of the Internet. In the 1970s and 1980s, the TCP/IP protocols were developed and adopted, allowing different networks to connect to one another. The growth of the World Wide Web in the 1990s made networks part of everyday life.",

            // CORE CONCEPTS
            "1. Node: Any device connected to a network, such as a computer, phone, or printer.\n\n" +
            "2. Protocol: A set of rules that defines how devices send, receive, and interpret data.\n\n" +
            "3. IP Address: A numerical label that identifies a device on a network.\n\n" +
            "4. Router: A device that forwards data between different networks.\n\n" +
            "5. Switch: A device that connects devices within the same local network.\n\n" +
            "6. Bandwidth: The maximum amount of data that can be transferred in a given time.\n\n" +
            "7. Topology: The arrangement of devices and connections in a network.",

            // HOW IT WORKS
            "When a device sends data, the data is divided into small units called packets. Each packet carries the address of the sender and the receiver. Switches and routers read these addresses and forward the packets toward their destination. At the destination, the packets are put back together into the original data. Protocols such as TCP and IP manage addressing, delivery, and error handling during this process.",

            // TYPES AND CLASSIFICATIONS
            "Networks are commonly classified by the area they cover:\n\n" +
            "1. PAN (Personal Area Network): A very small network around one person, such as Bluetooth devices.\n\n" +
            "2. LAN (Local Area Network): A network within a home, school, or office.\n\n" +
            "3. MAN (Metropolitan Area Network): A network covering a city or a large campus.\n\n" +
            "4. WAN (Wide Area Network): A network covering a large geographic area. The Internet is the largest example.",

            // PRACTICAL EXAMPLES
            "Example: Visiting a website.\n\n" +
            "1. Your device connects to a router through Wi-Fi.\n" +
            "2. The router sends your request through your internet service provider.\n" +
            "3. The request travels across several networks to the web server.\n" +
            "4. The server sends the web page back to your device as packets.\n\n" +
            "This shows how many separate networks cooperate by using shared protocols.",

            // APPLICATIONS
            "1. Internet Access: Browsing, streaming, and online communication.\n\n" +
            "2. Resource Sharing: Sharing printers, files, and storage in schools and offices.\n\n" +
            "3. Cloud Services: Accessing remote servers and applications.\n\n" +
            "4. Communication: Email, messaging, and video conferencing.\n\n" +
            "5. Business Operations: Connecting branches, databases, and point-of-sale systems.",

            // ADVANTAGES
            "Networks allow resources to be shared, support fast communication, make centralized data management possible, and let many users work together. They can also reduce costs because several users can share the same hardware and software.",

            // LIMITATIONS
            "Networks require equipment, configuration, and maintenance. They can be targets of security threats, and a failure in a central device may affect many users. Performance can also be reduced by congestion, interference, or limited bandwidth.",

            // RELATED TOPICS
            "TCP/IP, OSI Model, IP Addressing, Routers and Switches, Wireless Networks, Network Security, Internet, Cloud Computing.",

            // REFERENCES
            Arrays.asList(
                "Computer network - Encyclopaedia Britannica: https://www.britannica.com/technology/computer-network",
                "Computer network - Wikipedia: https://en.wikipedia.org/wiki/Computer_network",
                "OSI model - Wikipedia: https://en.wikipedia.org/wiki/OSI_model"
            )

        ));

                manager.addArticle(new Article(

            3,

            "Introduction to Databases",

            "Database Management",

            "An introduction to databases, including their definition, database management systems, tables and keys, SQL, practical examples, and why they are important for storing and managing data.",

            // DEFINITION
            "A database is an organized collection of data that is stored and accessed electronically. A Database Management System (DBMS) is the software used to create, store, retrieve, update, and manage the data in a database. Databases keep large amounts of information consistent, searchable, and secure.",

            // HISTORY
            "Early computer systems stored data in separate files, which caused duplication and inconsistency. In the 1960s, hierarchical and network database models were developed. In 1970, Edgar F. Codd proposed the relational model, which organizes data into tables. This led to relational database systems and the SQL language, which became the dominant way to work with business data.",

            // CORE CONCEPTS
            "1. Table: A collection of related data arranged in rows and columns.\n\n" +
            "2. Record (Row): One complete entry in a table.\n\n" +
            "3. Field (Column): One attribute of the data, such as name or age.\n\n" +
            "4. Primary Key: A field that uniquely identifies each record.\n\n" +
            "5. Foreign Key: A field that links one table to another.\n\n" +
            "6. Query: A request to retrieve or change data.\n\n" +
            "7. Normalization: Organizing data to reduce duplication and improve consistency.",

            // HOW IT WORKS
            "A user or application sends a request, usually written in SQL, to the DBMS. The DBMS interprets the request, finds the needed data, and returns the result or applies the change. The DBMS also enforces rules such as unique keys, controls who may access the data, and protects the data when several users work at the same time.",

            // TYPES AND CLASSIFICATIONS
            "1. Relational Databases: Store data in tables linked by keys. Examples include MySQL, PostgreSQL, and SQLite.\n\n" +
            "2. NoSQL Databases: Store data in flexible formats such as documents, key-value pairs, or graphs. An example is MongoDB.\n\n" +
            "3. Centralized and Distributed Databases: Data may be kept in one location or spread across several locations.",

            // PRACTICAL EXAMPLES
            "Example: A table named Students and a query that retrieves records.\n\n" +
            "SELECT name, course\n" +
            "FROM Students\n" +
            "WHERE course = 'BSIT';\n\n" +
            "Explanation:\n" +
            "- SELECT chooses which fields to display.\n" +
            "- FROM names the table to read.\n" +
            "- WHERE filters the records so only BSIT students are returned.",

            // APPLICATIONS
            "1. School Systems: Student records, grades, and enrollment.\n\n" +
            "2. Business: Inventory, sales, payroll, and customer information.\n\n" +
            "3. Banking: Accounts and transactions.\n\n" +
            "4. Healthcare: Patient records and appointments.\n\n" +
            "5. Websites: Storing user accounts, posts, and products.",

            // ADVANTAGES
            "Databases reduce data duplication, keep data consistent, allow fast searching, support many users at once, and provide security and backup features. They make it easier to manage large amounts of information than separate files.",

            // LIMITATIONS
            "Databases require careful design, skilled administration, and regular backups. Large systems can be costly and complex, and poorly designed databases or queries can perform slowly. A failure or security breach can affect a large amount of important data.",

            // RELATED TOPICS
            "SQL, Relational Model, Normalization, Data Modeling, NoSQL, Database Security, Data Warehousing, JDBC.",

            // REFERENCES
            Arrays.asList(
                "Database - Encyclopaedia Britannica: https://www.britannica.com/technology/database",
                "Database - Wikipedia: https://en.wikipedia.org/wiki/Database",
                "Relational model - Wikipedia: https://en.wikipedia.org/wiki/Relational_model"
            )

        ));

                manager.addArticle(new Article(

            6,

            "Java Programming",

            "Programming",

            "A comprehensive introduction to Java, including its history, architecture, basic syntax, variables, control structures, methods, object-oriented programming, and practical applications.",

            // DEFINITION
            "Java is a high-level, general-purpose, class-based, object-oriented programming language. It is designed so that developers can create applications that run on different platforms through the Java Virtual Machine (JVM). Java source code is compiled into bytecode, and a compatible JVM executes that bytecode, which supports Java's platform-independent approach.",

            // HISTORY
            "Java originated from the Green Project at Sun Microsystems in the early 1990s. James Gosling led the development team. The language was initially called Oak and was later renamed Java. It was publicly released in 1995. Oracle acquired Sun Microsystems in 2010 and became the steward of Java, which continues to evolve through regular releases and community-led development.",

            // CORE CONCEPTS
            "1. JDK (Java Development Kit): The software development package. It includes the Java compiler, runtime components, and development tools.\n\n" +
            "2. JRE (Java Runtime Environment): The runtime environment made up of the JVM and the libraries needed to run Java applications. Modern JDK distributions package runtime components differently, so a separate JRE download is not always provided.\n\n" +
            "3. JVM (Java Virtual Machine): Loads, verifies, and executes Java bytecode, manages memory, and provides runtime services.\n\n" +
            "4. Variables and Data Types: A variable is a named storage location. Java is statically typed, so every variable has a declared type. The eight primitive types are byte, short, int, long, float, double, char, and boolean. String is a reference type.\n\n" +
            "5. Operators: Arithmetic (+, -, *, /, %), comparison (==, !=, <, >), logical (&&, ||, !), and assignment (=, +=, -=).\n\n" +
            "6. Control Structures: Conditional statements (if/else) and loops (for, while) decide the order in which instructions run.\n\n" +
            "7. Methods: Named blocks of code that perform a task and may accept parameters and return values.\n\n" +
            "8. Classes and Objects: A class is a definition used to create objects, and an object is an instance of a class.",

            // HOW IT WORKS
            "Java programs follow four steps:\n\n" +
            "1. A developer writes source code in a .java file.\n" +
            "2. The Java compiler (javac) compiles the source code.\n" +
            "3. The compiler produces bytecode in a .class file.\n" +
            "4. The JVM loads and executes the bytecode.\n\n" +
            "Because the JVM runs the bytecode instead of the operating system, the same compiled program can run on any platform that has a compatible JVM. Java also provides automatic memory management through garbage collection, which reclaims memory used by objects that can no longer be reached.",

            // TYPES AND CLASSIFICATIONS
            "Java supports object-oriented programming (OOP). Its four commonly taught principles are:\n\n" +
            "1. Encapsulation: Bundling data and methods while controlling access to an object's state, usually with private fields and public getter methods.\n\n" +
            "2. Inheritance: Creating a class based on another class so that it reuses and extends existing behavior.\n\n" +
            "3. Polymorphism: Allowing a common parent type or interface to represent different implementations.\n\n" +
            "4. Abstraction: Exposing essential behavior while hiding implementation details.",

            // PRACTICAL EXAMPLES
            "Example 1: A basic Java program.\n\n" +
            "public class Main {\n" +
            "    public static void main(String[] args) {\n" +
            "        System.out.println(\"Hello, World!\");\n" +
            "    }\n" +
            "}\n\n" +
            "Explanation:\n" +
            "- public class Main declares a class named Main.\n" +
            "- main is the standard entry point of an application.\n" +
            "- String[] args receives command-line arguments.\n" +
            "- System.out.println prints text followed by a new line.\n\n" +
            "Example 2: A conditional statement.\n\n" +
            "int score = 85;\n" +
            "if (score >= 75) {\n" +
            "    System.out.println(\"Passed\");\n" +
            "} else {\n" +
            "    System.out.println(\"Failed\");\n" +
            "}\n\n" +
            "Example 3: A class and an object.\n\n" +
            "class Student {\n" +
            "    String name;\n\n" +
            "    void introduce() {\n" +
            "        System.out.println(\"Hello, \" + name);\n" +
            "    }\n" +
            "}\n\n" +
            "Student student = new Student();\n" +
            "student.name = \"Alex\";\n" +
            "student.introduce();",

            // APPLICATIONS
            "1. Enterprise and business applications.\n\n" +
            "2. Backend services and web applications.\n\n" +
            "3. Android applications, including many existing projects.\n\n" +
            "4. Financial and transaction processing systems.\n\n" +
            "5. Development tools and server software.",

            // ADVANTAGES
            "Java runs on platforms with a compatible JVM, uses strong type checking and structured programming, has a large ecosystem of libraries and tools, and provides built-in memory management through garbage collection.",

            // LIMITATIONS
            "Java can have higher runtime and memory overhead than some native applications. Some tasks require more code than in scripting languages, and performance depends on the JVM, the application, and the environment.",

            // RELATED TOPICS
            "Object-Oriented Programming, JVM, Data Types, Control Structures, Methods, Classes and Objects, Collections, Exception Handling, JDBC, Spring Framework.",

            // REFERENCES
            Arrays.asList(
                "Java Documentation - Oracle: https://docs.oracle.com/en/java/",
                "Dev.java Learning Materials: https://dev.java/learn/",
                "Java Tutorial - W3Schools: https://www.w3schools.com/java/"
            )));

        Article javaArticle = manager.getArticleByTitle("Java Programming");

        javaArticle.addSection("Introduction to Java",
            "Java is a high-level, general-purpose, class-based, object-oriented programming language. It is designed to allow developers to create applications that can run on different platforms through the Java Virtual Machine (JVM).\n" +
            "Java source code is compiled into bytecode. A compatible JVM executes that bytecode, which supports Java's platform-independent approach.");

        javaArticle.addSection("History and Development",
            "Java originated from the Green Project at Sun Microsystems in the early 1990s. James Gosling led the development team. The language was initially called Oak and was later renamed Java. It was publicly released in 1995.\n" +
            "Oracle acquired Sun Microsystems in 2010 and became the steward of Java. Java continues to evolve through regular releases and community-led development.");

        javaArticle.addSection("Java Architecture",
            "### Java Development Kit (JDK)\n" +
            "The JDK is the software development package. It includes tools such as the Java compiler, runtime components, and development utilities.\n" +
            "### Java Runtime Environment (JRE)\n" +
            "The JRE is the runtime environment made up of the JVM and the supporting libraries needed to run Java applications. Modern JDK distributions package runtime components differently, so a separate JRE download is not always provided.\n" +
            "### Java Virtual Machine (JVM)\n" +
            "The JVM loads, verifies, and executes Java bytecode. It manages memory and provides runtime services.\n" +
            "### How Java Runs\n" +
            "1. A developer writes source code in a .java file.\n" +
            "2. The Java compiler (javac) compiles the source code.\n" +
            "3. The compiler produces bytecode in a .class file.\n" +
            "4. The JVM loads and executes the bytecode.");

        javaArticle.addSection("Basic Java Program",
            "```java\n" +
            "public class Main {\n" +
            "    public static void main(String[] args) {\n" +
            "        System.out.println(\"Hello, World!\");\n" +
            "    }\n" +
            "}\n" +
            "```\n" +
            "**Explanation:**\n" +
            "- **public class Main:** Declares a class named Main.\n" +
            "- **main:** The standard application entry point.\n" +
            "- **String[] args:** Receives command-line arguments.\n" +
            "- **System.out.println:** Prints text followed by a new line.");

        javaArticle.addSection("Variables and Data Types",
            "A variable is a named storage location that holds a value. Java is statically typed, meaning variables have declared types.\n" +
            "```java\n" +
            "int age = 18;\n" +
            "double price = 99.50;\n" +
            "char grade = 'A';\n" +
            "boolean isStudent = true;\n" +
            "String name = \"Alex\";\n" +
            "```\n" +
            "Java's eight primitive types are byte, short, int, long, float, double, char, and boolean. String is a reference type, not a primitive type.");

        javaArticle.addSection("Operators",
            "Operators perform operations on values and variables.\n" +
            "- Arithmetic: +, -, *, /, %\n" +
            "- Comparison: ==, !=, greater than, less than\n" +
            "- Logical: &&, ||, !\n" +
            "- Assignment: =, +=, -=, *=");

        javaArticle.addSection("Control Structures",
            "Control structures determine the order in which instructions execute.\n" +
            "### Conditional statements\n" +
            "```java\n" +
            "int score = 85;\n" +
            "\n" +
            "if (score >= 75) {\n" +
            "    System.out.println(\"Passed\");\n" +
            "} else {\n" +
            "    System.out.println(\"Failed\");\n" +
            "}\n" +
            "```\n" +
            "### Loops\n" +
            "A loop repeats instructions while a condition is satisfied or for a specified number of iterations.\n" +
            "```java\n" +
            "for (int i = 1; i <= 5; i++) {\n" +
            "    System.out.println(i);\n" +
            "}\n" +
            "```");

        javaArticle.addSection("Methods",
            "A method is a named block of code that performs a particular task. Methods can accept parameters and return values.\n" +
            "```java\n" +
            "public static int add(int a, int b) {\n" +
            "    return a + b;\n" +
            "}\n" +
            "```");

        javaArticle.addSection("Object-Oriented Programming",
            "Java supports object-oriented programming (OOP). Its four commonly taught principles are:\n" +
            "- **Encapsulation:** Bundling data and methods while controlling access to an object's state.\n" +
            "- **Inheritance:** Creating a class based on another class.\n" +
            "- **Polymorphism:** Allowing a common interface or parent type to represent different implementations.\n" +
            "- **Abstraction:** Exposing essential behavior while hiding implementation details.\n" +
            "### Class and Object Example\n" +
            "```java\n" +
            "class Student {\n" +
            "    String name;\n" +
            "\n" +
            "    void introduce() {\n" +
            "        System.out.println(\"Hello, \" + name);\n" +
            "    }\n" +
            "}\n" +
            "\n" +
            "public class Main {\n" +
            "    public static void main(String[] args) {\n" +
            "        Student student = new Student();\n" +
            "        student.name = \"Alex\";\n" +
            "        student.introduce();\n" +
            "    }\n" +
            "}\n" +
            "```");

        javaArticle.addSection("Applications of Java",
            "- Enterprise and business applications.\n" +
            "- Backend services and web applications.\n" +
            "- Android applications, including many existing projects.\n" +
            "- Financial and transaction processing systems.\n" +
            "- Development tools and server software.");

        javaArticle.addSection("Advantages and Limitations",
            "### Advantages\n" +
            "- Runs on platforms with compatible JVM implementations.\n" +
            "- Strong type checking and structured programming.\n" +
            "- Large ecosystem of libraries and tools.\n" +
            "- Built-in memory management and garbage collection.\n" +
            "### Limitations\n" +
            "- Runtime and memory overhead can be higher than some native applications.\n" +
            "- Some tasks require more code than in scripting languages.\n" +
            "- Performance depends on the JVM, application, and environment.");

        javaArticle.addSection("Glossary",
            "- **Compiler:** A tool that translates source code into another form, such as Java bytecode.\n" +
            "- **Bytecode:** Instructions stored in class files for execution by a JVM.\n" +
            "- **Class:** A definition used to create objects.\n" +
            "- **Object:** An instance of a class.\n" +
            "- **Garbage Collection:** Automatic reclamation of memory occupied by objects that are no longer reachable.");

        javaArticle.addSection("Practical Exercises",
            "1. Write a program that displays your name and course.\n" +
            "2. Create two integer variables and display their sum.\n" +
            "3. Write a program that checks whether a number is even or odd.\n" +
            "4. Use a loop to display numbers from 1 to 10.\n" +
            "5. Create a Student class with a name field and an introduction method.");

        javaArticle.addSection("Knowledge Check",
            "1. Who led the development of Java?\n" +
            "2. What does JVM stand for?\n" +
            "3. What is Java bytecode?\n" +
            "4. What is the difference between a class and an object?\n" +
            "5. Name the four commonly taught principles of OOP.");
              
        manager.addArticle(new Article(

            7,

            "Introduction to Computer Fundamentals",

            "Computer Fundamentals",

            "An introduction to how computers work, including their definition, main hardware components, software, binary data, the way a computer processes instructions, and the roles computers play today.",

            // DEFINITION
            "A computer is an electronic device that accepts data as input, processes it by following a set of instructions called a program, stores the results, and produces output. Computers work with two kinds of components: hardware, the physical parts you can touch, and software, the programs that tell the hardware what to do.",

            // HISTORY
            "In the 1830s, Charles Babbage designed the Analytical Engine, a mechanical machine that is considered an early concept of a general-purpose computer. Electronic computers appeared in the 1940s, and ENIAC, completed in 1945, was one of the first large electronic general-purpose computers. The transistor, invented in 1947, and later the integrated circuit made computers smaller, faster, and cheaper. In 1971 the first commercial microprocessor, the Intel 4004, placed a processor on a single chip, which led to personal computers in the late 1970s and 1980s.",

            // CORE CONCEPTS
            "1. CPU (Central Processing Unit): The part that carries out instructions and performs calculations. It is often called the brain of the computer.\n\n" +
            "2. Memory (RAM): Fast, temporary storage that holds the programs and data currently in use. Its contents are lost when the power is turned off.\n\n" +
            "3. Storage: Permanent storage for files and programs, such as a hard disk drive or a solid-state drive (SSD).\n\n" +
            "4. Input Devices: Devices used to send data into the computer, such as a keyboard, mouse, or microphone.\n\n" +
            "5. Output Devices: Devices that present results to the user, such as a monitor, speaker, or printer.\n\n" +
            "6. Motherboard: The main circuit board that connects the CPU, memory, storage, and other components.\n\n" +
            "7. Operating System: The system software that manages the hardware and runs other programs. Examples are Windows, macOS, Linux, and Android.\n\n" +
            "8. Bit and Byte: A bit is a single binary digit, either 0 or 1. A byte is a group of 8 bits, and it can represent one character such as the letter A.",

            // HOW IT WORKS
            "Computers represent all data, including numbers, text, images, and sound, in binary form using 0s and 1s. To run a program, the CPU repeats a cycle: it fetches an instruction from memory, decodes it to find out what it means, and executes it. The results are stored back in memory or sent to an output device. Most modern computers follow the stored-program idea, often called the von Neumann architecture, in which both the program and its data are kept in the same memory.",

            // TYPES AND CLASSIFICATIONS
            "Computers are commonly grouped by size and purpose:\n\n" +
            "1. Personal Computers: Desktops and laptops used by one person at a time.\n\n" +
            "2. Mobile Devices: Smartphones and tablets.\n\n" +
            "3. Servers: Powerful computers that provide services such as websites and databases to many users over a network.\n\n" +
            "4. Supercomputers: Extremely fast systems used for scientific simulations and large calculations.\n\n" +
            "5. Embedded Computers: Small computers built into other devices, such as washing machines, cars, and smart TVs.\n\n" +
            "Software is also divided into system software, such as the operating system, and application software, such as a word processor or a web browser.",

            // PRACTICAL EXAMPLES
            "Example: Saving a typed document.\n\n" +
            "1. You type on the keyboard (input), and the keystrokes are sent to the CPU.\n" +
            "2. The CPU runs the word processor program, which is loaded in RAM, and places the text in memory.\n" +
            "3. The text appears on the monitor (output).\n" +
            "4. When you press Save, the operating system copies the document from RAM to the SSD (storage).\n\n" +
            "If the computer loses power before you save, the text in RAM is lost, while the saved file on the SSD remains.",

            // APPLICATIONS
            "1. Education: Online classes, research, and digital learning materials.\n\n" +
            "2. Business: Accounting, inventory, communication, and record keeping.\n\n" +
            "3. Healthcare: Patient records, medical imaging, and diagnostic equipment.\n\n" +
            "4. Communication: Email, messaging, and video calls.\n\n" +
            "5. Entertainment: Games, music, and video streaming.\n\n" +
            "6. Science and Engineering: Simulations, data analysis, and design.",

            // ADVANTAGES
            "Computers process data quickly and accurately, store very large amounts of information, run many tasks at the same time, and can repeat the same operation without getting tired. They also make communication and access to information much faster.",

            // LIMITATIONS
            "A computer can only follow the instructions it is given, so wrong data or a faulty program produces wrong results. Computers depend on electric power, can fail or be attacked by malware, and need regular maintenance and updates. They also do not understand meaning or make judgments the way people do.",

            // RELATED TOPICS
            "Operating Systems, Computer Hardware, Computer Software, Binary Number System, Computer Architecture, Memory and Storage, Networking, Programming.",

            // REFERENCES
            Arrays.asList(
                "Computer - Encyclopaedia Britannica: https://www.britannica.com/technology/computer",
                "Computer - Wikipedia: https://en.wikipedia.org/wiki/Computer",
                "Von Neumann architecture - Wikipedia: https://en.wikipedia.org/wiki/Von_Neumann_architecture"
            )

        ));  
    }
}
