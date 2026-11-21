package org.example;

import java.util.Arrays;

public class ArticleDataMore {

    public static void load(ArticleManager manager) {

        manager.addArticle(new Article(

            13,

            "Cryptography",

            "Cybersecurity",

            "An introduction to cryptography, including encryption and decryption, symmetric and asymmetric keys, hashing, digital signatures, a worked example, and how it protects data in everyday systems.",

            // DEFINITION
            "Cryptography is the practice of protecting information by converting it into a form that only authorized people can read. The original readable data is called plaintext, and the protected version is called ciphertext. Modern cryptography is used to keep data private, to confirm that it has not been changed, and to prove who sent it.",

            // HISTORY
            "People have used secret writing for thousands of years. One well-known early method is the Caesar cipher, which was used by Julius Caesar and shifts each letter by a fixed number of places. In the twentieth century, machines such as the Enigma were used to encrypt military messages. In 1976, Whitfield Diffie and Martin Hellman published the idea of public-key cryptography, and in 1977 Rivest, Shamir, and Adleman created the RSA algorithm. The Advanced Encryption Standard (AES) was adopted by the United States government in 2001 and is now used worldwide.",

            // CORE CONCEPTS
            "1. Plaintext and Ciphertext: Plaintext is the readable message, and ciphertext is the scrambled result.\n\n" +
            "2. Encryption and Decryption: Encryption turns plaintext into ciphertext, and decryption turns it back.\n\n" +
            "3. Key: A secret value used by the algorithm. The security of a good system depends on keeping the key secret, not the algorithm.\n\n" +
            "4. Symmetric Encryption: The same key is used to encrypt and decrypt. It is fast, but both sides must share the key safely.\n\n" +
            "5. Asymmetric Encryption: A pair of keys is used. A public key encrypts, and only the matching private key can decrypt.\n\n" +
            "6. Hash Function: A function that turns any data into a fixed-length value called a hash. The same input always gives the same hash, and the original data cannot be recovered from it.\n\n" +
            "7. Digital Signature: A value created with a private key that lets others use the matching public key to check who signed the data and that it was not changed.",

            // HOW IT WORKS
            "In symmetric encryption, the sender and receiver agree on a key. The sender runs the plaintext and the key through an algorithm such as AES to produce ciphertext, and the receiver uses the same key to reverse the process. In asymmetric encryption, the receiver publishes a public key, and anyone can use it to encrypt a message that only the receiver's private key can open. In practice, the two methods are combined: asymmetric encryption is used first to share a secret key safely, and then fast symmetric encryption protects the actual data. This is how HTTPS protects websites.",

            // TYPES AND CLASSIFICATIONS
            "Common cryptographic tools include:\n\n" +
            "1. Symmetric Algorithms: AES is the most widely used. The older DES is no longer considered secure.\n\n" +
            "2. Asymmetric Algorithms: RSA and elliptic-curve cryptography.\n\n" +
            "3. Hash Functions: SHA-256 is widely used. MD5 and SHA-1 are no longer considered safe for security purposes.\n\n" +
            "4. Digital Signatures and Certificates: Used by websites to prove their identity.\n\n" +
            "5. Protocols: TLS, the protocol behind HTTPS, combines these tools to secure communication.",

            // PRACTICAL EXAMPLES
            "Example: The Caesar cipher with a shift of 3.\n\n" +
            "Each letter is replaced by the letter 3 places later in the alphabet.\n\n" +
            "Plaintext: HELLO\n" +
            "Ciphertext: KHOOR\n\n" +
            "H becomes K, E becomes H, L becomes O, and O becomes R. The key is the number 3. To decrypt, the receiver shifts each letter 3 places back.\n\n" +
            "This cipher is far too weak for real use, because there are only 25 possible shifts and an attacker can try all of them quickly. Modern algorithms such as AES use keys with 128 bits or more, which makes trying every key impractical.\n\n" +
            "A practical hashing example is storing passwords: a website stores the hash of your password instead of the password itself, and when you log in it hashes what you typed and compares the two hashes.",

            // APPLICATIONS
            "1. Secure Websites: HTTPS uses TLS to protect logins, payments, and personal data.\n\n" +
            "2. Messaging: Many messaging apps use end-to-end encryption so only the sender and receiver can read messages.\n\n" +
            "3. Password Storage: Systems store password hashes, not the passwords.\n\n" +
            "4. Digital Payments: Banks and payment systems protect transactions.\n\n" +
            "5. Software Updates: Digital signatures prove that an update came from the real publisher.\n\n" +
            "6. Storage: Disk and file encryption protect data if a device is lost.",

            // ADVANTAGES
            "Cryptography keeps information private, shows when data has been altered, confirms identity, and makes it safe to send sensitive information across public networks such as the Internet.",

            // LIMITATIONS
            "Cryptography is only as strong as its keys and its implementation. A weak password, a lost key, or a mistake in the software can make strong algorithms useless. Encryption also does not protect against attacks that happen before or after the data is encrypted, such as stealing a password with a phishing email. Algorithms that were once secure can become weak as computers improve, so they must be replaced over time.",

            // RELATED TOPICS
            "Network Security, HTTPS and TLS, Digital Certificates, Hash Functions, Authentication, Data Privacy, Blockchain, Quantum Computing.",

            // REFERENCES
            Arrays.asList(
                "Cryptography - Wikipedia: https://en.wikipedia.org/wiki/Cryptography",
                "Cryptography - Encyclopaedia Britannica: https://www.britannica.com/topic/cryptography",
                "Advanced Encryption Standard - Wikipedia: https://en.wikipedia.org/wiki/Advanced_Encryption_Standard"
            )

        ));

        manager.addArticle(new Article(

            14,

            "Malware",

            "Cybersecurity",

            "An introduction to malware, including its definition, major types such as viruses, worms, trojans, and ransomware, how infections happen, a real example, and ways to prevent and respond to it.",

            // DEFINITION
            "Malware, short for malicious software, is any program that is designed to harm a computer, steal information, or give an attacker unauthorized control of a system. Malware can damage files, spy on users, lock data, or use a computer to attack others.",

            // HISTORY
            "In 1982, a program called Elk Cloner spread between Apple II computers on floppy disks and is often named as one of the first viruses to spread outside a laboratory. In 1988, the Morris worm spread across the early Internet and slowed down thousands of computers. In 2000, the ILOVEYOU worm spread by email and affected millions of computers. In 2017, the WannaCry ransomware attack locked computers in many countries, including hospitals, and demanded payment.",

            // CORE CONCEPTS
            "1. Payload: The harmful action that the malware carries out, such as deleting files or encrypting data.\n\n" +
            "2. Infection Vector: The way malware reaches a system, such as an email attachment, a download, or a USB drive.\n\n" +
            "3. Vulnerability: A weakness in software that malware can use to get in.\n\n" +
            "4. Exploit: A piece of code that takes advantage of a vulnerability.\n\n" +
            "5. Antivirus Software: A program that scans for and removes known malware.\n\n" +
            "6. Signature and Behavior Detection: Antivirus tools can recognize known malware by its signature, and can also watch for suspicious behavior.\n\n" +
            "7. Patch: A software update that fixes a vulnerability.",

            // HOW IT WORKS
            "Malware usually reaches a computer when a user opens an infected file, clicks a harmful link, or installs a program from an untrusted source, or when it exploits an unpatched vulnerability. Once it runs, it can copy itself, hide, and carry out its payload. Some malware contacts an attacker's server to receive commands or to send stolen data. Other malware spreads automatically to other computers on the same network without any user action.",

            // TYPES AND CLASSIFICATIONS
            "Common types of malware include:\n\n" +
            "1. Virus: Attaches itself to a legitimate file or program and spreads when that file is shared or run.\n\n" +
            "2. Worm: Spreads by itself across networks without needing a host file.\n\n" +
            "3. Trojan: Pretends to be a useful program but performs harmful actions once installed.\n\n" +
            "4. Ransomware: Locks or encrypts a victim's files and demands payment to restore them.\n\n" +
            "5. Spyware: Secretly collects information about the user. A keylogger is spyware that records what is typed.\n\n" +
            "6. Adware: Shows unwanted advertisements, and may track browsing.\n\n" +
            "7. Rootkit: Hides malware and gives an attacker deep access to the system.\n\n" +
            "8. Botnet: A network of infected computers that an attacker controls remotely.",

            // PRACTICAL EXAMPLES
            "Example: A ransomware attack on a small office.\n\n" +
            "1. An employee receives an email that looks like an invoice and opens the attached file.\n" +
            "2. The file installs ransomware, which encrypts the documents on the computer and on shared drives.\n" +
            "3. A message appears demanding payment to unlock the files.\n" +
            "4. The office can recover without paying only if it has clean backups that the malware could not reach.\n\n" +
            "How to defend:\n" +
            "- Keep regular backups, and store at least one copy offline.\n" +
            "- Install software updates and security patches promptly.\n" +
            "- Do not open unexpected attachments or links.\n" +
            "- Use antivirus software and limit user permissions.",

            // APPLICATIONS
            "Studying malware helps in several areas:\n\n" +
            "1. Antivirus Development: Companies analyze malware to create detection rules.\n\n" +
            "2. Incident Response: Security teams investigate infections and remove them.\n\n" +
            "3. Security Awareness Training: Users learn how infections happen.\n\n" +
            "4. Digital Forensics: Investigators trace what an attacker did.\n\n" +
            "5. Network Defense: Firewalls and email filters block known threats.",

            // ADVANTAGES
            "Understanding malware helps organizations and individuals prevent infections, detect them earlier, and recover faster. Knowing how it spreads makes simple habits such as updating software and backing up data much more convincing.",

            // LIMITATIONS
            "No protection is perfect. New malware can avoid detection until its signature is known, and attackers often use social engineering to trick users. Antivirus software can slow a computer and may produce false alarms. Backups and updates also need continuing effort to be useful.",

            // RELATED TOPICS
            "Network Security, Phishing, Social Engineering, Antivirus Software, Ethical Hacking, Digital Forensics, Cryptography, Incident Response.",

            // REFERENCES
            Arrays.asList(
                "Malware - Wikipedia: https://en.wikipedia.org/wiki/Malware",
                "Computer virus - Encyclopaedia Britannica: https://www.britannica.com/technology/computer-virus",
                "Stop Ransomware - CISA: https://www.cisa.gov/stopransomware"
            )

        ));

        // ADD NEW ARTICLES ABOVE THIS LINE
                manager.addArticle(new Article(

            15,

            "Operating Systems",

            "Computer Fundamentals",

            "An introduction to operating systems, including their definition, main functions, key components such as the kernel and file system, common types, how they manage programs and memory, and popular examples.",

            // DEFINITION
            "An operating system (OS) is the main system software that manages a computer's hardware and provides services for other programs. It sits between the user, the applications, and the hardware. Without an operating system, every program would have to control the keyboard, screen, memory, and storage by itself.",

            // HISTORY
            "The earliest computers had no operating system, and operators loaded one program at a time. In the 1950s, batch systems were developed to run jobs one after another automatically. UNIX was created at Bell Labs in 1969 by Ken Thompson and Dennis Ritchie, and many later systems were influenced by it. MS-DOS appeared in 1981, and Windows 1.0 followed in 1985. Linus Torvalds released the first version of the Linux kernel in 1991. The Apple iPhone introduced iOS in 2007, and the first Android phones were sold in 2008.",

            // CORE CONCEPTS
            "1. Kernel: The core of the operating system. It has full control of the hardware and provides basic services to the rest of the system.\n\n" +
            "2. Process: A program that is currently running, together with the resources it uses.\n\n" +
            "3. Thread: A smaller unit of work inside a process. A process can have several threads that run at the same time.\n\n" +
            "4. Scheduling: Deciding which process gets the CPU and for how long.\n\n" +
            "5. Memory Management: Giving each program the memory it needs and keeping programs from interfering with one another.\n\n" +
            "6. File System: The method used to name, store, and organize files on a storage device.\n\n" +
            "7. Device Driver: A small program that lets the operating system communicate with a specific piece of hardware, such as a printer.\n\n" +
            "8. User Interface: The way people use the system. A command-line interface (CLI) uses typed commands, and a graphical user interface (GUI) uses windows, icons, and menus.",

            // HOW IT WORKS
            "When the computer starts, a small program in firmware loads the operating system from storage into memory. The kernel then starts the system services and the user interface. When you open an application, the OS creates a process for it, gives it memory, and schedules it to use the CPU. The CPU switches between processes many times per second, so several programs seem to run at once. When a program needs a service such as reading a file, it makes a request to the kernel called a system call, and the kernel performs the task using the correct device driver.",

            // TYPES AND CLASSIFICATIONS
            "Operating systems can be grouped by the devices they run on:\n\n" +
            "1. Desktop and Laptop Systems: Windows, macOS, and Linux distributions such as Ubuntu.\n\n" +
            "2. Mobile Systems: Android and iOS.\n\n" +
            "3. Server Systems: Windows Server and Linux, designed to run for long periods and serve many users.\n\n" +
            "4. Embedded Systems: Small systems inside devices such as routers, TVs, and cars.\n\n" +
            "5. Real-Time Systems: Systems that must respond within a strict time limit, such as those in medical devices and industrial machines.\n\n" +
            "They can also be grouped by how they run tasks: batch systems run jobs one after another, time-sharing systems let many users share the CPU, and distributed systems spread work across several computers.",

            // PRACTICAL EXAMPLES
            "Example: Listening to music while writing a document.\n\n" +
            "1. The OS runs two processes at once: a music player and a word processor.\n" +
            "2. The scheduler gives each one short turns on the CPU, switching so quickly that both seem to run at the same time.\n" +
            "3. The memory manager keeps each program in its own area of memory, so a crash in one does not damage the other.\n" +
            "4. When you press Save, the word processor asks the kernel to write the file, and the file system stores it on the drive.\n\n" +
            "You can see running processes in Windows Task Manager, or by running the command top in a Linux terminal.",

            // APPLICATIONS
            "1. Personal Computing: Running programs and managing files on laptops and desktops.\n\n" +
            "2. Mobile Devices: Running apps and managing battery, touch input, and sensors.\n\n" +
            "3. Servers and Cloud: Hosting websites, databases, and virtual machines.\n\n" +
            "4. Embedded Devices: Controlling routers, smart TVs, and vehicles.\n\n" +
            "5. Education and Development: Learning how computers work and building software.",

            // ADVANTAGES
            "An operating system lets many programs share the same hardware safely, hides hardware details from programmers, provides a consistent interface for users, and offers security features such as user accounts and file permissions.",

            // LIMITATIONS
            "An operating system uses some memory and processing power itself. It can have bugs and security weaknesses, so it needs regular updates. Programs written for one operating system often cannot run on another without changes, and a failure in the kernel can crash the whole system.",

            // RELATED TOPICS
            "Computer Hardware, File Systems, Processes and Threads, Memory Management, Linux, Windows, Android, Virtualization, Computer Architecture.",

            // REFERENCES
            Arrays.asList(
                "Operating system - Encyclopaedia Britannica: https://www.britannica.com/technology/operating-system",
                "Operating system - Wikipedia: https://en.wikipedia.org/wiki/Operating_system",
                "Kernel (operating system) - Wikipedia: https://en.wikipedia.org/wiki/Kernel_(operating_system)"
            )

        ));

        manager.addArticle(new Article(

            16,

            "Binary Number System",

            "Computer Fundamentals",

            "An introduction to the binary number system, including place values, converting between binary and decimal, binary addition, how computers store text, and why computers use binary.",

            // DEFINITION
            "The binary number system is a way of writing numbers using only two digits, 0 and 1. It is a base-2 system, while the decimal system that people use every day is base 10. Computers use binary because their electronic circuits have two clear states, such as on and off, which map directly to 1 and 0.",

            // HISTORY
            "Gottfried Wilhelm Leibniz described the modern binary number system in 1703. In 1847, George Boole published the algebra of logic, now called Boolean algebra, which works with true and false values. In 1937, Claude Shannon showed in his master's thesis that Boolean algebra could be used to design electrical switching circuits, which became the basis of digital computers. The ASCII character code, which assigns numbers to letters, was first published in 1963.",

            // CORE CONCEPTS
            "1. Bit: A single binary digit, either 0 or 1. The word comes from binary digit.\n\n" +
            "2. Byte: A group of 8 bits. One byte can hold 256 different values, from 0 to 255.\n\n" +
            "3. Place Value: Each position in a binary number is worth a power of 2, starting from 1 on the right, then 2, 4, 8, 16, and so on.\n\n" +
            "4. Most and Least Significant Bit: The leftmost bit has the largest value, and the rightmost bit has the smallest.\n\n" +
            "5. Hexadecimal: A base-16 system that uses the digits 0 to 9 and the letters A to F. One hexadecimal digit stands for exactly 4 bits, so it is a short way to write binary.\n\n" +
            "6. Character Encoding: A table that assigns a number to each character. ASCII and Unicode are the best known.\n\n" +
            "7. Kilobyte, Megabyte, and Gigabyte: Units of storage. In everyday use, 1 kilobyte is about 1,000 bytes, although some systems use 1,024.",

            // HOW IT WORKS
            "A binary number is read by adding up the place values of every position that holds a 1. For example, in 1101 the positions from the right are worth 1, 2, 4, and 8. The 1s are at the positions worth 8, 4, and 1, so the value is 8 + 4 + 1 = 13. To convert a decimal number to binary, repeatedly divide it by 2 and write down the remainders, then read the remainders from last to first. Inside the computer, all data, including numbers, text, images, and sound, is stored as patterns of bits.",

            // TYPES AND CLASSIFICATIONS
            "Number systems commonly used in computing:\n\n" +
            "1. Binary (base 2): Digits 0 and 1.\n\n" +
            "2. Octal (base 8): Digits 0 to 7. It was used in older systems.\n\n" +
            "3. Decimal (base 10): Digits 0 to 9.\n\n" +
            "4. Hexadecimal (base 16): Digits 0 to 9 and A to F. It is used for colors, memory addresses, and other values.\n\n" +
            "The same value written in each system: the number 255 is 11111111 in binary, 377 in octal, 255 in decimal, and FF in hexadecimal.",

            // PRACTICAL EXAMPLES
            "Example 1: Binary to decimal.\n\n" +
            "1011 = (1 x 8) + (0 x 4) + (1 x 2) + (1 x 1) = 8 + 0 + 2 + 1 = 11\n\n" +
            "Example 2: Decimal to binary. Convert 13.\n\n" +
            "13 divided by 2 is 6 remainder 1\n" +
            "6 divided by 2 is 3 remainder 0\n" +
            "3 divided by 2 is 1 remainder 1\n" +
            "1 divided by 2 is 0 remainder 1\n\n" +
            "Reading the remainders from last to first gives 1101.\n\n" +
            "Example 3: Binary addition. 0101 + 0011.\n\n" +
            "The rules are 0 + 0 = 0, 0 + 1 = 1, 1 + 1 = 10 (write 0, carry 1). Adding the two numbers gives 1000, which is 5 + 3 = 8 in decimal.\n\n" +
            "Example 4: Storing text. In ASCII, the letter A is the number 65, which is 01000001 in binary. A computer stores the word HI as the bytes for H (72) and I (73).",

            // APPLICATIONS
            "1. Computer Memory and Storage: All data is stored as bits.\n\n" +
            "2. Networking: IP addresses and subnet masks are binary numbers written in a readable form.\n\n" +
            "3. Digital Images: Each color is stored as numbers, often written in hexadecimal, such as #FF0000 for red.\n\n" +
            "4. Programming: Bitwise operations and flags use binary values directly.\n\n" +
            "5. Digital Electronics: Logic gates and circuits work with 0 and 1.",

            // ADVANTAGES
            "Binary is simple and reliable, because a circuit only needs to tell two states apart, which makes it resistant to small amounts of electrical noise. Binary arithmetic can be carried out with simple logic circuits, and it maps directly to Boolean logic.",

            // LIMITATIONS
            "Binary numbers are long and hard for people to read, so programmers often use hexadecimal instead. A fixed number of bits can only hold a limited range of values, and going past it causes overflow. Some decimal fractions, such as 0.1, cannot be stored exactly in binary, which leads to small rounding errors.",

            // RELATED TOPICS
            "Hexadecimal, Boolean Algebra, Logic Gates, ASCII and Unicode, Computer Memory, IP Addressing, Data Representation, Computer Architecture.",

            // REFERENCES
            Arrays.asList(
                "Binary number - Wikipedia: https://en.wikipedia.org/wiki/Binary_number",
                "Binary number system - Encyclopaedia Britannica: https://www.britannica.com/science/binary-number-system",
                "ASCII - Wikipedia: https://en.wikipedia.org/wiki/ASCII"
            )

        ));
                
        manager.addArticle(new Article(

            17,

            "HTML and CSS",

            "Web Development",

            "An introduction to HTML and CSS, including how HTML structures a web page, how CSS styles it, the basic syntax of both, a working example, and how browsers combine them.",

            // DEFINITION
            "HTML (HyperText Markup Language) is the standard language used to describe the structure and content of a web page, such as headings, paragraphs, images, links, and forms. CSS (Cascading Style Sheets) is the language used to describe how that content looks, including colors, fonts, spacing, and layout. HTML says what is on the page, and CSS says how it appears.",

            // HISTORY
            "Tim Berners-Lee created HTML at CERN around 1989 to 1991 as part of the first World Wide Web. The first formal specification, HTML 2.0, was published in 1995, and HTML 4 followed in 1997. CSS was proposed by Hakon Wium Lie in 1994, and the first CSS recommendation was published by the W3C in 1996. HTML5 became a W3C Recommendation in October 2014 and added elements for video, audio, and page structure.",

            // CORE CONCEPTS
            "1. Element: A building block of an HTML page, written with a start tag, content, and an end tag, such as a paragraph element containing text.\n\n" +
            "2. Tag: The markup that marks where an element starts and ends, written between angle brackets.\n\n" +
            "3. Attribute: Extra information inside a start tag, such as the address of a link or the source of an image.\n\n" +
            "4. Semantic Elements: Elements that describe their meaning, such as header, nav, main, and footer, which help browsers and search engines understand a page.\n\n" +
            "5. Selector: The part of a CSS rule that chooses which elements to style, such as an element name, a class, or an id.\n\n" +
            "6. Property and Value: A CSS declaration has a property, such as color, and a value, such as blue.\n\n" +
            "7. Box Model: CSS treats every element as a box made of content, padding, border, and margin.\n\n" +
            "8. Cascade and Specificity: The rules that decide which style wins when several rules apply to the same element.",

            // HOW IT WORKS
            "When a browser receives an HTML file, it reads the tags and builds a tree of elements called the Document Object Model (DOM). It then reads the CSS and works out which rules apply to each element. Finally, it calculates the size and position of every box and paints the page on the screen. If the HTML or the CSS changes, the browser repeats these steps for the affected parts. CSS can be written in a separate file linked from the page, inside a style element, or directly in an element's style attribute, and a separate file is usually preferred because several pages can share it.",

            // TYPES AND CLASSIFICATIONS
            "Ways to organize and apply styles:\n\n" +
            "1. External CSS: Rules in a separate file linked to the page. This is the most common method.\n\n" +
            "2. Internal CSS: Rules written inside a style element in the page.\n\n" +
            "3. Inline CSS: Rules written in the style attribute of one element.\n\n" +
            "Common kinds of CSS selectors:\n\n" +
            "1. Element selector: Matches every element of one type, such as all paragraphs.\n\n" +
            "2. Class selector: Written with a dot, it matches every element with that class.\n\n" +
            "3. ID selector: Written with a hash sign, it matches the one element with that id.\n\n" +
            "Modern CSS layout tools include Flexbox for one-dimensional layouts and Grid for two-dimensional layouts.",

            // PRACTICAL EXAMPLES
            "Example: A small page with a heading and a button.\n\n" +
            "HTML:\n" +
            "<h1>Search IT</h1>\n" +
            "<p class=\"note\">Search. Discover. Learn.</p>\n" +
            "<button>Search</button>\n\n" +
            "CSS:\n" +
            "h1 {\n" +
            "    color: #38bdf8;\n" +
            "}\n" +
            ".note {\n" +
            "    color: gray;\n" +
            "}\n" +
            "button {\n" +
            "    background: #2563eb;\n" +
            "    color: white;\n" +
            "    padding: 10px 20px;\n" +
            "}\n\n" +
            "Explanation:\n" +
            "- The h1 element is the main heading, and the rule h1 colors every h1 on the page.\n" +
            "- class=\"note\" gives the paragraph a class, and the rule .note styles every element with that class.\n" +
            "- padding adds space between the button text and its border.\n\n" +
            "The Search IT home page you are using is built this way: HTML for the search box and results, and CSS for the dark theme.",

            // APPLICATIONS
            "1. Websites: Every web page uses HTML for structure and CSS for appearance.\n\n" +
            "2. Web Applications: Interfaces for online stores, school portals, and dashboards.\n\n" +
            "3. Email Templates: Formatted emails are written in HTML.\n\n" +
            "4. Responsive Design: CSS media queries adapt a page to phones, tablets, and desktops.\n\n" +
            "5. Documentation: Many manuals and help pages are written in HTML.",

            // ADVANTAGES
            "HTML and CSS are free, open standards that every browser understands. They are easy to start with, they keep content separate from design so a whole site can be restyled by changing one file, and they work on almost every device.",

            // LIMITATIONS
            "HTML and CSS describe pages but cannot make decisions or process data, so JavaScript or a server-side language is needed for that. Browsers may display some CSS features differently, and large style sheets can become hard to manage without careful organization.",

            // RELATED TOPICS
            "JavaScript, Responsive Design, DOM, Web Accessibility, Web Browsers, HTTP, CSS Frameworks, Web Development.",

            // REFERENCES
            Arrays.asList(
                "HTML - MDN Web Docs: https://developer.mozilla.org/en-US/docs/Web/HTML",
                "CSS - MDN Web Docs: https://developer.mozilla.org/en-US/docs/Web/CSS",
                "HTML - Wikipedia: https://en.wikipedia.org/wiki/HTML"
            )

        ));

        manager.addArticle(new Article(

            18,

            "REST APIs and JSON",

            "Web Development",

            "An introduction to REST APIs and the JSON format, including how clients and servers exchange data, HTTP methods and status codes, a worked example, and how Search IT uses them.",

            // DEFINITION
            "An API (Application Programming Interface) is a defined way for one program to request data or actions from another. A REST API is a web API that follows the REST (Representational State Transfer) style: resources are identified by addresses, and clients use standard HTTP methods to work with them. JSON (JavaScript Object Notation) is a lightweight text format that REST APIs commonly use to send data.",

            // HISTORY
            "Roy Fielding described the REST architectural style in his doctoral dissertation in 2000. JSON was popularized by Douglas Crockford in the early 2000s and was based on the object notation of JavaScript. Because JSON is smaller and easier to read than XML, it replaced XML in most new web APIs during the 2010s.",

            // CORE CONCEPTS
            "1. Client and Server: The client, such as a browser, sends a request, and the server sends back a response.\n\n" +
            "2. Resource: A thing the API manages, such as an article or a user. Each resource has an address.\n\n" +
            "3. Endpoint: A specific address of the API, such as /api/search.\n\n" +
            "4. HTTP Method: The action requested. GET reads data, POST creates data, PUT replaces data, and DELETE removes data.\n\n" +
            "5. Status Code: A number in the response that shows the result, such as 200 for success, 404 for not found, and 500 for a server error.\n\n" +
            "6. Query Parameter: A value added to the address after a question mark, such as ?q=java.\n\n" +
            "7. Stateless: Each request contains everything the server needs, so the server does not need to remember earlier requests.\n\n" +
            "8. JSON Structure: Data is written as objects in curly braces, with name and value pairs, and as arrays in square brackets.",

            // HOW IT WORKS
            "The client sends an HTTP request that contains a method, an address, and sometimes extra data. The server reads the request, finds or changes the data, and sends back a response with a status code and, usually, a JSON body. The client reads the JSON and uses it, for example by showing it on the page. Because REST uses ordinary HTTP, any program that can make web requests, in any language, can use the API.",

            // TYPES AND CLASSIFICATIONS
            "1. REST APIs: Use standard HTTP methods and resource addresses. They are the most common style.\n\n" +
            "2. SOAP APIs: An older style that exchanges XML messages with strict rules.\n\n" +
            "3. GraphQL APIs: Let the client ask for exactly the fields it needs through one endpoint.\n\n" +
            "JSON supports these value types: string, number, true or false, null, object, and array.",

            // PRACTICAL EXAMPLES
            "Example: The Search IT search endpoint.\n\n" +
            "Request:\n" +
            "GET /api/search?q=java\n\n" +
            "Response (shortened):\n" +
            "{\n" +
            "  \"found\": true,\n" +
            "  \"count\": 1,\n" +
            "  \"results\": [\n" +
            "    { \"title\": \"Java Programming\", \"category\": \"Programming\" }\n" +
            "  ]\n" +
            "}\n\n" +
            "Explanation:\n" +
            "- GET asks the server to read data, and q=java is the search keyword.\n" +
            "- found, count, and results are names, and each one has a value.\n" +
            "- results is an array that holds one object for each article.\n\n" +
            "In Search IT, the JavaScript in the page uses fetch() to send this request to the Java server, and the Java code builds the JSON text.",

            // APPLICATIONS
            "1. Web and Mobile Apps: Apps load data from servers, such as posts, products, and weather.\n\n" +
            "2. Third-Party Services: Payment, map, and login services offer APIs to other developers.\n\n" +
            "3. Microservices: Large systems are split into small services that talk through APIs.\n\n" +
            "4. Configuration Files: JSON is also used to store settings and data.\n\n" +
            "5. Learning Platforms: Systems such as Search IT use an API to serve their content.",

            // ADVANTAGES
            "REST APIs are simple, because they reuse standard web technology. JSON is easy for people to read and for programs to process, and almost every programming language can handle it. Clients and servers can be developed independently as long as they agree on the API.",

            // LIMITATIONS
            "REST APIs can send more data than a client needs, or require several requests to collect related data. An API must be protected with authentication and input checking, or it can expose private data. JSON does not support comments or dates directly, and large responses can be slow to send.",

            // RELATED TOPICS
            "HTTP, JavaScript, Web Servers, GraphQL, XML, Authentication, Web Security, Java Programming.",

            // REFERENCES
            Arrays.asList(
                "An overview of HTTP - MDN Web Docs: https://developer.mozilla.org/en-US/docs/Web/HTTP/Overview",
                "Working with JSON - MDN Web Docs: https://developer.mozilla.org/en-US/docs/Learn_web_development/Core/Scripting/JSON",
                "Representational state transfer - Wikipedia: https://en.wikipedia.org/wiki/REST"
            )

        ));

                manager.addArticle(new Article(

            19,

            "SQL Basics",

            "Database Management",

            "An introduction to SQL, the language used to create, read, update and delete data in relational databases, with worked examples of SELECT, INSERT, UPDATE, DELETE, WHERE, ORDER BY, GROUP BY and JOIN.",

            // DEFINITION
            "SQL (Structured Query Language) is the standard language for working with relational databases. A relational database stores data in tables made of rows and columns, and SQL is how you ask the database to store, find, change, or remove that data. You describe what result you want, and the database system works out the steps to produce it.",

            // HISTORY
            "SQL grew out of Edgar F. Codd's relational model, published in 1970. In the early 1970s, Donald Chamberlin and Raymond Boyce at IBM created a language for it, first called SEQUEL and later shortened to SQL. Oracle released the first commercially available SQL database in 1979. SQL became an ANSI standard in 1986 and an ISO standard in 1987, and it has been revised many times since. Today MySQL, PostgreSQL, SQLite, Microsoft SQL Server and Oracle Database all use SQL, each with small differences called dialects.",

            // CORE CONCEPTS
            "1. Table: A collection of related data arranged in rows and columns, such as a table of students.\n\n" +
            "2. Row (record): One item in a table, such as one student.\n\n" +
            "3. Column (field): One property of every row, such as name or grade. Each column has a data type, such as INT for whole numbers, VARCHAR for text, or DATE for dates.\n\n" +
            "4. Primary key: A column whose value is different for every row, so each row can be identified exactly.\n\n" +
            "5. Foreign key: A column that holds the primary key of a row in another table. It is how two tables are linked.\n\n" +
            "6. Query: A SQL statement that asks the database for data or asks it to change data.",

            // HOW IT WORKS
            "1. You write a SQL statement and send it to the database system.\n\n" +
            "2. The database checks that the statement is written correctly.\n\n" +
            "3. It plans the fastest way to find or change the data, often using indexes.\n\n" +
            "4. It runs the plan on the tables.\n\n" +
            "5. It returns the result, which is either a table of rows (for SELECT) or a message saying how many rows were changed.",

            // TYPES
            "SQL commands are grouped by what they do:\n\n" +
            "1. DDL (Data Definition Language): CREATE, ALTER and DROP. They build or change the structure of tables.\n\n" +
            "2. DML (Data Manipulation Language): INSERT, UPDATE and DELETE. They add, change and remove rows.\n\n" +
            "3. DQL (Data Query Language): SELECT. It reads data. Some books place SELECT under DML.\n\n" +
            "4. DCL (Data Control Language): GRANT and REVOKE. They control who may use the data.\n\n" +
            "5. TCL (Transaction Control Language): COMMIT and ROLLBACK. They save or undo a group of changes.",

            // EXAMPLES
            "The examples use a table named students.\n\n" +
            "1. Create the table:\n" +
            "```\n" +
            "CREATE TABLE students (\n" +
            "  id INT PRIMARY KEY,\n" +
            "  name VARCHAR(50),\n" +
            "  course VARCHAR(30),\n" +
            "  grade INT\n" +
            ");\n" +
            "```\n\n" +
            "2. Add a row:\n" +
            "```\n" +
            "INSERT INTO students (id, name, course, grade)\n" +
            "VALUES (1, 'Ana', 'BSIT', 92);\n" +
            "```\n\n" +
            "3. Read rows that match a condition, highest grade first:\n" +
            "```\n" +
            "SELECT name, grade FROM students\n" +
            "WHERE course = 'BSIT'\n" +
            "ORDER BY grade DESC;\n" +
            "```\n\n" +
            "4. Change a row:\n" +
            "```\n" +
            "UPDATE students SET grade = 95 WHERE id = 1;\n" +
            "```\n\n" +
            "5. Delete a row:\n" +
            "```\n" +
            "DELETE FROM students WHERE id = 1;\n" +
            "```\n\n" +
            "6. Count students in each course:\n" +
            "```\n" +
            "SELECT course, COUNT(*) FROM students GROUP BY course;\n" +
            "```\n\n" +
            "7. Combine two tables with a JOIN:\n" +
            "```\n" +
            "SELECT students.name, enrollments.subject\n" +
            "FROM students\n" +
            "JOIN enrollments ON students.id = enrollments.student_id;\n" +
            "```\n\n" +
            "Always write a WHERE clause with UPDATE and DELETE. Without it, the command changes or removes every row in the table.",

            // APPLICATIONS
            "SQL is used behind websites and mobile apps to store accounts, products and orders. Schools, banks and hospitals use it for their records. Businesses use it to produce reports, and data analysts use it to filter and summarize large amounts of data. Android and many desktop programs use SQLite, a small SQL database stored in a single file.",

            // ADVANTAGES
            "SQL is a widely used standard, so the skill carries over between database systems. It is readable, because commands look like short English instructions. It can handle very large tables, lets many users work at the same time, and has built-in tools for security and for keeping data correct.",

            // LIMITATIONS
            "SQL works best with data that fits neatly in tables, so it is less natural for loosely structured data such as documents or social graphs. Each database system has its own dialect, so some commands must be rewritten when switching systems. Poorly written queries can be slow on large tables. Queries that put user input directly into the command text are open to SQL injection, so programs must use prepared statements.",

            // RELATED TOPICS
            "Database Normalization, NoSQL Databases, REST APIs, Web Development, Cybersecurity.",

            // REFERENCES
            Arrays.asList(
                "SQL Tutorial - W3Schools: https://www.w3schools.com/sql/",
                "SQL - Wikipedia: https://en.wikipedia.org/wiki/SQL",
                "SQLite Query Language Documentation: https://www.sqlite.org/lang.html"
            )

        ));

                manager.addArticle(new Article(

            20,

            "Database Normalization",

            "Database Management",

            "An explanation of database normalization, the process of organizing tables so each fact is stored only once, with a step-by-step example that moves a messy table through First, Second and Third Normal Form.",

            // DEFINITION
            "Database normalization is the process of organizing the data in a relational database into well-structured tables so that each fact is stored in only one place. It reduces repeated data and prevents the errors that appear when repeated data is inserted, changed or deleted. The rules for how far a table has been cleaned up are called normal forms.",

            // HISTORY
            "Edgar F. Codd introduced normalization together with the relational model. He described First Normal Form in 1970, and defined Second and Third Normal Form in 1971. In 1974, Raymond Boyce and Codd introduced a stricter version of Third Normal Form, called Boyce-Codd Normal Form (BCNF). Later researchers added Fourth and Fifth Normal Form, which deal with rarer situations.",

            // CORE CONCEPTS
            "1. Redundancy: The same fact stored in many places, such as a customer phone number repeated on every order.\n\n" +
            "2. Anomalies: Problems caused by redundancy. An update anomaly means changing a fact in one row but not in the others. An insertion anomaly means being unable to record a fact until unrelated data exists. A deletion anomaly means losing a fact by deleting a row that also held other information.\n\n" +
            "3. Functional dependency: When the value of one column decides the value of another. For example, a customer id decides the customer name.\n\n" +
            "4. Primary key: The column, or group of columns, that identifies each row.\n\n" +
            "5. Normal form: A rule a table must satisfy, such as First, Second or Third Normal Form.\n\n" +
            "6. Decomposition: Splitting one table into smaller tables that are linked by keys, without losing any information.",

            // HOW IT WORKS
            "1. Look at the table and find data that repeats.\n\n" +
            "2. Decide which column, or columns, is the primary key.\n\n" +
            "3. List which columns depend on which, using functional dependencies.\n\n" +
            "4. Split the table so every column depends only on the key of its own table.\n\n" +
            "5. Link the new tables with foreign keys.\n\n" +
            "6. Check the result against each normal form, starting from the first.",

            // TYPES
            "1. First Normal Form (1NF): Every cell holds a single value, there are no repeating groups of columns, and every row can be identified by a key.\n\n" +
            "2. Second Normal Form (2NF): The table is in 1NF, and every non-key column depends on the whole primary key, not on just a part of it. This matters when the key is made of more than one column.\n\n" +
            "3. Third Normal Form (3NF): The table is in 2NF, and no non-key column depends on another non-key column.\n\n" +
            "4. Boyce-Codd Normal Form (BCNF): A stricter 3NF, in which every column that decides another column must itself be a candidate key.\n\n" +
            "5. Fourth and Fifth Normal Form: Handle special cases with multiple independent lists of values. They are rarely needed in everyday design.",

            // EXAMPLES
            "Start with one table of orders that stores everything together. The key is order_id plus product:\n" +
            "```\n" +
            "order_id | customer | phone    | product  | price\n" +
            "1        | Ana      | 0917-111 | Pen      | 10\n" +
            "1        | Ana      | 0917-111 | Notebook | 40\n" +
            "2        | Ben      | 0918-222 | Pen      | 10\n" +
            "```\n\n" +
            "Problems: Ana's phone is stored twice, and the price of a Pen is stored twice. If Ana changes her phone number, every one of her rows must be updated, or the data becomes inconsistent.\n\n" +
            "Step 1 (1NF): Each cell has one value. If an order had held the text Pen, Notebook in a single cell, we would give each item its own row, as shown above.\n\n" +
            "Step 2 (2NF): The price depends only on the product, which is just part of the key. Move it into its own table.\n\n" +
            "Step 3 (3NF): The phone depends on the customer, not on the order. Move customers into their own table.\n\n" +
            "Result:\n" +
            "```\n" +
            "customers(customer_id, name, phone)\n" +
            "products(product_id, product_name, price)\n" +
            "orders(order_id, customer_id)\n" +
            "order_items(order_id, product_id, quantity)\n" +
            "```\n\n" +
            "Now each phone number and each price is stored once, and the tables are connected by their ids.",

            // APPLICATIONS
            "Normalization is used when designing databases for schools, hospitals, banks, online shops and any system where records must stay correct over time. It is a standard step in database design, taught before building tables in systems such as MySQL, PostgreSQL and SQL Server.",

            // ADVANTAGES
            "Normalized data takes less storage and is easier to keep consistent, because each fact lives in one place. Updates are simpler, and the insertion, update and deletion anomalies are avoided. The structure is clearer, which makes the database easier to understand and to change later.",

            // LIMITATIONS
            "Splitting data into more tables means queries must use JOINs to put it back together, which can be slower on very large reports. Going too far can make a design hard to read. For this reason, some systems, such as data warehouses, deliberately repeat data (denormalization) to read faster. Good normalization also needs careful thought about how the data really depends on itself.",

            // RELATED TOPICS
            "SQL Basics, NoSQL Databases, Data Modeling, Information Systems, Software Development.",

            // REFERENCES
            Arrays.asList(
                "Database normalization - Wikipedia: https://en.wikipedia.org/wiki/Database_normalization",
                "Description of the database normalization basics - Microsoft Learn: https://learn.microsoft.com/en-us/office/troubleshoot/access/database-normalization-description",
                "A Relational Model of Data for Large Shared Data Banks - E. F. Codd (1970): https://www.seas.upenn.edu/~zives/03f/cis550/codd.pdf"
            )

        ));

                manager.addArticle(new Article(

            21,

            "NoSQL Databases",

            "Database Management",

            "An introduction to NoSQL databases, which store data in flexible forms instead of fixed tables, covering the four main types (document, key-value, wide-column and graph), how they scale across many servers, and when to use them instead of SQL.",

            // DEFINITION
            "NoSQL, often read as not only SQL, describes databases that store data in ways other than the fixed rows and columns of a relational database. They use flexible structures such as documents, key-value pairs or graphs, and they are designed to handle large amounts of data, fast access, and spreading the data across many servers.",

            // HISTORY
            "The word NoSQL was first used in 1998 by Carlo Strozzi for a small relational database that did not use SQL. It became popular after 2006 and 2007, when Google published its Bigtable design and Amazon published its Dynamo design for handling huge amounts of web data. Facebook released Cassandra as open source in 2008, and MongoDB and Redis appeared in 2009. In 2009, Johan Oskarsson used the name NoSQL for a meeting about these new non-relational databases, and the name stuck.",

            // CORE CONCEPTS
            "1. Flexible schema: Records in the same collection do not all need the same fields, so the structure can change without rebuilding the database.\n\n" +
            "2. Horizontal scaling: Instead of buying one bigger computer (vertical scaling), more ordinary computers are added to share the work.\n\n" +
            "3. Sharding: Splitting the data into parts, called shards, and storing each part on a different server.\n\n" +
            "4. Replication: Keeping copies of the data on more than one server, so the system keeps working if one server fails.\n\n" +
            "5. CAP theorem: When a network failure splits a distributed system, it must choose between keeping the data consistent and keeping the system available. It cannot guarantee both at that moment.\n\n" +
            "6. Eventual consistency: A rule used by many NoSQL systems where all copies of the data may differ briefly but will agree after a short time. This is different from the strict ACID guarantees of traditional relational databases, although many modern NoSQL systems now offer transactions too.",

            // HOW IT WORKS
            "1. The application sends a request that uses the database's own commands or programming interface, instead of SQL.\n\n" +
            "2. The database finds which server holds the data, usually using the key or a chosen shard key.\n\n" +
            "3. It reads or writes the data on that server.\n\n" +
            "4. It copies the change to the replica servers.\n\n" +
            "5. It returns the result. Depending on the settings, it may answer after the first copy is saved, which is faster, or after several copies agree, which is safer.",

            // TYPES
            "1. Document databases: Store records as JSON-like documents. Examples: MongoDB and Couchbase.\n\n" +
            "2. Key-value databases: Store each value under a unique key, like a very large dictionary. Examples: Redis and Amazon DynamoDB.\n\n" +
            "3. Wide-column databases: Store data in rows whose columns can differ, grouped into column families, which is useful for huge amounts of data. Examples: Apache Cassandra and Apache HBase.\n\n" +
            "4. Graph databases: Store items as nodes and the connections between them as relationships, which suits data about networks of people or places. Example: Neo4j.",

            // EXAMPLES
            "1. A document in a document database. Notice that the hobbies list sits inside the same record, which would need a separate table in SQL:\n" +
            "```\n" +
            "{\n" +
            "  \"name\": \"Ana\",\n" +
            "  \"course\": \"BSIT\",\n" +
            "  \"hobbies\": [\"coding\", \"chess\"]\n" +
            "}\n" +
            "```\n\n" +
            "2. Finding documents in MongoDB:\n" +
            "```\n" +
            "db.students.find({ course: 'BSIT' })\n" +
            "```\n\n" +
            "3. Storing and reading a value in Redis, a key-value database:\n" +
            "```\n" +
            "SET user:1 Ana\n" +
            "GET user:1\n" +
            "```\n\n" +
            "4. A graph database can answer questions such as which friends of my friends also like the same game, by following relationships instead of joining tables.",

            // APPLICATIONS
            "NoSQL databases are used for social media feeds, real-time apps, online games and leaderboards, shopping carts and product catalogs, content management, and storing data from sensors. Redis is often used as a fast cache in front of another database. Graph databases are used for recommendations and for finding links between people or accounts.",

            // ADVANTAGES
            "NoSQL databases can store varied data without a fixed design, and they grow by adding servers. They are very fast for the specific kinds of requests they are built for. Document databases are natural for programmers, because the stored data looks like the objects used in their code.",

            // LIMITATIONS
            "Most NoSQL databases do not support joins as well as SQL, so related data is often repeated, and the data must be designed around the questions the app will ask. There is no single standard query language, so skills do not transfer as easily between products. Eventual consistency can show slightly old data for a short time. For structured data with strict rules, such as bank records, a relational database is usually still the better choice.",

            // RELATED TOPICS
            "SQL Basics, Database Normalization, REST APIs and JSON, Cloud Computing, Big Data.",

            // REFERENCES
            Arrays.asList(
                "NoSQL - Wikipedia: https://en.wikipedia.org/wiki/NoSQL",
                "What is NoSQL? - MongoDB: https://www.mongodb.com/resources/basics/databases/nosql-explained",
                "Redis Documentation: https://redis.io/docs/"
            )

        ));

    }
}