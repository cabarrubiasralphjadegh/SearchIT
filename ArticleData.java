
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

    }
}
