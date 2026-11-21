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

                manager.addArticle(new Article(

            22,

            "Artificial Intelligence",

            "Emerging Technologies",

            "An introduction to artificial intelligence (AI), covering what it is, how machines learn from data, the main types such as machine learning, deep learning and generative AI, real examples, and its benefits and risks.",

            // DEFINITION
            "Artificial intelligence (AI) is the field of computer science that builds systems able to do tasks that normally need human intelligence, such as recognizing images, understanding speech, translating languages, making decisions and writing text. Most modern AI does not follow a fixed list of instructions for every case. Instead, it learns patterns from large amounts of data.",

            // HISTORY
            "In 1950, Alan Turing published a paper asking whether machines can think and proposed what is now called the Turing test. The term artificial intelligence was introduced by John McCarthy for the 1956 Dartmouth workshop, which is often seen as the start of the field. Progress later slowed during two periods of reduced funding and interest, called AI winters, in the 1970s and in the late 1980s. In 1997, IBM's Deep Blue defeated the world chess champion Garry Kasparov. Around 2012, deep learning made a major leap in image recognition, and in 2016 DeepMind's AlphaGo defeated the Go champion Lee Sedol. In 2017, researchers introduced the transformer design, which led to today's large language models and the wide use of generative AI in the 2020s.",

            // CORE CONCEPTS
            "1. Model: A mathematical system that takes an input, such as a photo, and produces an output, such as the word cat.\n\n" +
            "2. Machine learning: A way of building AI in which the model learns from examples instead of being given step-by-step rules.\n\n" +
            "3. Training data: The examples the model learns from. The quality and variety of this data strongly affect how good the model is.\n\n" +
            "4. Neural network: A model made of many connected layers of simple calculating units, loosely inspired by the brain.\n\n" +
            "5. Deep learning: Machine learning that uses neural networks with many layers. It is behind most image, speech and language AI today.\n\n" +
            "6. Training and inference: Training is the learning stage, which needs a lot of computing power. Inference is using the trained model to answer new inputs.\n\n" +
            "7. Bias: Unfair or inaccurate results that happen when the training data is incomplete or reflects unfair patterns.",

            // HOW IT WORKS
            "1. Collect data that is related to the task, such as many emails labeled spam or not spam.\n\n" +
            "2. Choose a type of model that suits the task.\n\n" +
            "3. Train the model: it makes predictions, compares them with the correct answers, and adjusts its internal numbers to make fewer mistakes. This repeats many times.\n\n" +
            "4. Test the model on new data it has never seen, to check that it really learned the pattern and did not just memorize the examples.\n\n" +
            "5. Deploy the model so it can handle real inputs.\n\n" +
            "6. Monitor results and retrain with better data when the model makes mistakes.",

            // TYPES
            "AI can be grouped by ability:\n\n" +
            "1. Narrow AI: Built for one task or a small set of tasks, such as translating text or recommending videos. All AI in use today is narrow AI.\n\n" +
            "2. General AI: A hypothetical system that could learn and perform any intellectual task a human can. It does not exist yet.\n\n" +
            "AI can also be grouped by technique:\n\n" +
            "3. Supervised learning: Learns from examples that already have the correct answer.\n\n" +
            "4. Unsupervised learning: Finds hidden groups or patterns in data that has no answers.\n\n" +
            "5. Reinforcement learning: Learns by trial and error, receiving rewards for good actions.\n\n" +
            "6. Natural language processing: Lets computers work with human language.\n\n" +
            "7. Computer vision: Lets computers understand images and video.\n\n" +
            "8. Generative AI: Creates new text, images, audio or code from what it has learned.",

            // EXAMPLES
            "1. An email spam filter is trained on thousands of emails that people have already marked as spam or not spam. It learns which words and patterns suggest spam, then sorts new emails by itself.\n\n" +
            "2. A video app recommends what to watch next by learning from what similar users watched.\n\n" +
            "3. Face unlock on a phone compares the camera image with a stored face pattern.\n\n" +
            "4. Online translators convert text between languages.\n\n" +
            "5. A chatbot answers questions in natural language.\n\n" +
            "6. In hospitals, AI can help doctors spot signs of disease in X-ray images, but a doctor makes the final decision.",

            // APPLICATIONS
            "AI is used in healthcare for medical images and drug research, in banks to detect fraud, in education for tutoring and feedback, and in farming to monitor crops. It is used in transport for navigation and driver-assistance features, in customer service for chatbots, and in cybersecurity to detect unusual activity on networks.",

            // ADVANTAGES
            "AI can work quickly and without getting tired, and it can find patterns in amounts of data too large for people to check. It can automate repetitive tasks, give results around the clock, and in some narrow tasks it matches or exceeds human accuracy.",

            // LIMITATIONS
            "AI is only as good as its data, so poor or unfair data leads to poor or unfair results. A model can be wrong while sounding confident, and generative AI can produce false information, so important results must be checked by people. Many models cannot explain why they gave an answer. AI raises privacy concerns, needs large amounts of energy and computing power to train, and changes the kind of work people do. Human oversight is necessary.",

            // RELATED TOPICS
            "Python Programming, Cloud Computing, Internet of Things, Cybersecurity, Data Structures and Algorithms.",

            // REFERENCES
            Arrays.asList(
                "Artificial intelligence - Wikipedia: https://en.wikipedia.org/wiki/Artificial_intelligence",
                "Computing Machinery and Intelligence - A. M. Turing (1950): https://academic.oup.com/mind/article/LIX/236/433/986238",
                "Machine Learning Crash Course - Google for Developers: https://developers.google.com/machine-learning/crash-course"
            )

        ));

                manager.addArticle(new Article(

            23,

            "Cloud Computing",

            "Emerging Technologies",

            "An introduction to cloud computing, the delivery of servers, storage, databases and software over the internet, covering how it works, the IaaS, PaaS and SaaS service models, public, private and hybrid clouds, and its benefits and limits.",

            // DEFINITION
            "Cloud computing is the delivery of computing services, such as servers, storage, databases, networking and software, over the internet on demand. Instead of buying and running your own computers, you use the provider's computers and usually pay only for what you use. The United States National Institute of Standards and Technology (NIST) describes five key traits: on-demand self-service, broad network access, resource pooling, rapid elasticity and measured service.",

            // HISTORY
            "The idea began in the 1960s with time-sharing, where many users shared one large computer, and John McCarthy suggested that computing might one day be sold like a public utility. In the 1990s, virtualization made it possible to split one physical machine into several virtual ones, and in 1999 Salesforce began delivering business software through a website. Amazon Web Services launched its storage service (S3) and its virtual servers (EC2) in 2006, which is widely seen as the start of modern cloud computing. Google App Engine followed in 2008, and Microsoft Azure became generally available in 2010.",

            // CORE CONCEPTS
            "1. Data center: A large building full of servers, storage and networking equipment, owned and run by the cloud provider.\n\n" +
            "2. Virtualization: Software that divides one physical server into several separate virtual machines.\n\n" +
            "3. On-demand self-service: You can create or remove resources yourself, in minutes, without talking to a person.\n\n" +
            "4. Elasticity and scalability: Resources can grow when demand is high and shrink when it is low.\n\n" +
            "5. Pay-as-you-go: Usage is measured, and you are charged for what you use.\n\n" +
            "6. Region: A geographic area where the provider keeps data centers. Choosing a region affects speed, cost and legal rules about where data is stored.\n\n" +
            "7. Shared responsibility: The provider protects the underlying infrastructure, while the customer is responsible for protecting their own data, accounts and settings.",

            // HOW IT WORKS
            "1. The provider builds data centers filled with servers, storage and network equipment.\n\n" +
            "2. Virtualization divides these machines into many virtual resources that can be given to different customers, a design called multi-tenancy.\n\n" +
            "3. A customer asks for a resource, such as a server or a database, through a website or a programming interface.\n\n" +
            "4. The system sets up the resource within minutes and connects it to the internet.\n\n" +
            "5. The customer uses it over the internet from any device.\n\n" +
            "6. The provider measures usage, such as hours of computing or amount of storage, and bills for it.",

            // TYPES
            "Service models, from most control to least:\n\n" +
            "1. IaaS (Infrastructure as a Service): You rent basic computing resources such as virtual servers and storage, and manage the software yourself. Example: Amazon EC2.\n\n" +
            "2. PaaS (Platform as a Service): You get a ready platform for building and running apps, and the provider manages the servers and system software. Example: Google App Engine.\n\n" +
            "3. SaaS (Software as a Service): You use finished software through a browser or app. Examples: Gmail and Microsoft 365.\n\n" +
            "Deployment models:\n\n" +
            "4. Public cloud: Shared services offered to many customers over the internet.\n\n" +
            "5. Private cloud: Cloud resources used by only one organization, in its own data center or a dedicated one.\n\n" +
            "6. Hybrid cloud: A mix of public and private clouds that work together.",

            // EXAMPLES
            "1. Email and file storage: Gmail and Google Drive keep your messages and files on the provider's servers, so you can open them from any device.\n\n" +
            "2. Video streaming: Netflix runs much of its service on Amazon Web Services, which lets it handle millions of viewers at once.\n\n" +
            "3. Development environments: GitHub Codespaces, the tool used to build this project, runs the code editor and the program on a cloud computer and shows it in a web browser. This is how a tablet can build and run a Java program.\n\n" +
            "4. A school website that gets very few visitors most of the year can add more servers for enrollment week and remove them afterward, paying only for the extra days.",

            // APPLICATIONS
            "Cloud computing is used for web hosting, storing and backing up files, building and testing software, streaming video and music, analyzing large amounts of data, and training AI models. Schools and companies use it for online classes, remote work and shared documents.",

            // ADVANTAGES
            "There is no need to buy expensive equipment in advance, because you pay for what you use. Resources can be added within minutes and removed when no longer needed. Services can be reached from anywhere with internet. Providers handle maintenance, updates and backups, and large providers can offer high reliability by keeping copies of data in different locations.",

            // LIMITATIONS
            "A reliable internet connection is required. Costs can grow quickly if usage is not watched. The customer has less control over the underlying hardware, and moving to another provider can be difficult, a problem called vendor lock-in. Security is shared, so a weak password or wrong setting by the customer can expose data. Laws may also limit where certain data can be stored. Provider outages, although rare, can affect many customers at the same time.",

            // RELATED TOPICS
            "Networking, Operating Systems, Cybersecurity, Artificial Intelligence, Internet of Things.",

            // REFERENCES
            Arrays.asList(
                "The NIST Definition of Cloud Computing (SP 800-145): https://csrc.nist.gov/pubs/sp/800/145/final",
                "Cloud computing - Wikipedia: https://en.wikipedia.org/wiki/Cloud_computing",
                "What is Cloud Computing? - Amazon Web Services: https://aws.amazon.com/what-is-cloud-computing/"
            )

        ));

                manager.addArticle(new Article(

            24,

            "Internet of Things",

            "Emerging Technologies",

            "An explanation of the Internet of Things (IoT): physical devices with sensors and network connections that send data and receive commands, covering the parts of an IoT system, communication methods such as Wi-Fi, Bluetooth, LoRaWAN and MQTT, a worked temperature-and-fan example, and the main security risks.",

            // DEFINITION
            "The Internet of Things (IoT) is a network of physical objects, called things, that contain sensors, a small processor and a network connection, so they can collect data, send it to other devices or to the cloud, and in many cases receive commands back. A thing can be as small as a temperature sensor on a farm or as large as a factory machine. What makes a device part of the IoT is that it exchanges data over a network without a person typing it in.",

            // HISTORY
            "In 1982, students at Carnegie Mellon University connected a Coca-Cola vending machine to the internet so they could check from their computers whether a drink was available and cold, which is often cited as one of the first connected devices. In 1999, Kevin Ashton, working with the Auto-ID Center at MIT, used the phrase Internet of Things while describing how objects tagged with RFID chips could be tracked. In the same year, Andy Stanford-Clark and Arlen Nipper created MQTT, a lightweight messaging protocol that is still widely used. Around 2008 and 2009, estimates reported that more devices than people were connected to the internet. Cheap boards such as the Arduino and the ESP32 and low-cost sensors then made IoT projects possible for students and hobbyists.",

            // CORE CONCEPTS
            "1. Sensor: A component that measures something in the physical world and turns it into an electrical signal. Examples: a DHT22 for temperature and humidity, a PIR sensor for motion, and a GPS module for location.\n\n" +
            "2. Actuator: A component that does something in the physical world when it receives a command, such as a relay that switches a fan on, a motor, or a door lock.\n\n" +
            "3. Microcontroller: A small, low-power computer chip that reads sensors and controls actuators. Examples: Arduino boards and the ESP32, which also has built-in Wi-Fi and Bluetooth. A Raspberry Pi is a larger single-board computer that can run a full operating system.\n\n" +
            "4. Connectivity: How the device reaches the network. Short range: Wi-Fi, Bluetooth Low Energy and Zigbee. Long range with very low power: LoRaWAN and NB-IoT. Wide area: cellular networks such as 4G and 5G.\n\n" +
            "5. Gateway: A device that collects data from many nearby sensors and forwards it to the internet.\n\n" +
            "6. Protocol: The agreed message format. MQTT uses a publish and subscribe model, in which devices publish messages to named topics on a server called a broker, and other devices subscribe to the topics they care about. HTTP and CoAP are also used.\n\n" +
            "7. Cloud platform: The online service that stores the data, analyzes it, and shows it in dashboards.\n\n" +
            "8. Edge computing: Processing data on or near the device, instead of sending everything to the cloud, to reduce delay and network traffic.\n\n" +
            "9. Firmware: The program stored inside the device. It must be updated over time to fix bugs and security flaws.",

            // HOW IT WORKS
            "1. A sensor measures a physical value, for example 28.5 degrees Celsius.\n\n" +
            "2. The microcontroller reads the value and may filter or average it.\n\n" +
            "3. The device connects to the network using Wi-Fi, Bluetooth, LoRaWAN or cellular.\n\n" +
            "4. It sends the reading using a protocol such as MQTT to a broker or a cloud platform.\n\n" +
            "5. The cloud stores the reading and compares it with rules or analyzes it, sometimes with machine learning.\n\n" +
            "6. If a rule matches, the system sends a command back to the device or sends an alert to a phone.\n\n" +
            "7. The actuator carries out the command, and the user can watch all of it on a dashboard or in an app.",

            // TYPES
            "1. Consumer IoT: Smart speakers, smart lights and plugs, smart TVs, fitness bands and smartwatches.\n\n" +
            "2. Industrial IoT (IIoT): Sensors on factory machines that report vibration and temperature so repairs can be planned before a breakdown, and trackers on shipping containers.\n\n" +
            "3. Smart city IoT: Parking sensors, smart street lights, traffic monitoring and water meters.\n\n" +
            "4. Healthcare IoT: Wearable heart-rate monitors and connected glucose meters that send readings to a doctor.\n\n" +
            "5. Agricultural IoT: Soil-moisture sensors that tell a farm when to water, and weather stations.\n\n" +
            "6. Home and building automation: Thermostats, security cameras, door sensors and smoke alarms.",

            // EXAMPLES
            "A room temperature and fan system built with an ESP32:\n\n" +
            "1. A DHT22 sensor is connected to the ESP32. Every 10 seconds the ESP32 reads the temperature.\n\n" +
            "2. The ESP32 connects to the home Wi-Fi and publishes the reading to an MQTT broker:\n" +
            "```\n" +
            "Topic:   home/room1/temperature\n" +
            "Payload: 28.5\n" +
            "```\n\n" +
            "3. A rule on the server says: if the temperature is above 30, publish the command ON to the topic home/room1/fan.\n\n" +
            "4. A second ESP32 subscribed to home/room1/fan receives ON and switches a relay that powers a fan.\n\n" +
            "5. When the temperature falls below 28, the rule sends OFF, and the fan stops.\n\n" +
            "Other examples: a smart thermostat that learns when people are home, a wearable that sends heart-rate data to a phone, and soil-moisture sensors that start irrigation only when the soil is dry.",

            // APPLICATIONS
            "IoT is used in smart homes, farming, manufacturing, logistics and fleet tracking, hospitals, energy meters, water monitoring and environmental monitoring. Cities use it for parking and traffic management, and businesses use it to monitor equipment and plan maintenance before machines fail.",

            // ADVANTAGES
            "IoT gives real-time information about the physical world, so decisions are based on measurements instead of guesses. It automates routine tasks, such as watering or lighting, and can save energy and time. It supports early warnings, such as detecting a leak or a failing motor, and lets people monitor and control things remotely from a phone.",

            // LIMITATIONS
            "Security is the biggest concern. Many devices are sold with default passwords or no way to update their firmware, and attackers can control them. In 2016, the Mirai malware took over large numbers of cameras and routers with default passwords and used them to attack the DNS provider Dyn, which made many popular websites unreachable. Devices also collect personal information, which creates privacy risks. Different brands often do not work together because they use different standards. Small battery-powered devices must save energy, and a device that loses its network connection may stop working properly. Large systems also create large amounts of data that must be stored and analyzed.",

            // RELATED TOPICS
            "Cloud Computing, Networking, Wireless Networks, Cybersecurity, Artificial Intelligence.",

            // REFERENCES
            Arrays.asList(
                "Internet of things - Wikipedia: https://en.wikipedia.org/wiki/Internet_of_things",
                "That Internet of Things Thing - Kevin Ashton, RFID Journal (2009): https://www.rfidjournal.com/that-internet-of-things-thing",
                "MQTT: The Standard for IoT Messaging: https://mqtt.org/"
            )

        ));

                manager.addArticle(new Article(

            25,

            "Blockchain",

            "Emerging Technologies",

            "An explanation of blockchain: a shared record made of blocks that are linked by cryptographic hashes and copied across many computers, covering how a transaction is verified and added, proof of work versus proof of stake, smart contracts, a worked hash-chain example, and its real limits.",

            // DEFINITION
            "A blockchain is a shared digital ledger, a list of records, in which the records are grouped into blocks and each block contains the cryptographic hash of the block before it. Because of this link, changing an old record changes its hash and breaks every block after it, which makes tampering easy to detect. The ledger is not kept in one place. Many computers, called nodes, each hold a copy and follow the same rules to agree on what is valid, so no single company or person has to be trusted to keep the record.",

            // HISTORY
            "In 1991, Stuart Haber and W. Scott Stornetta described a way to timestamp documents by linking them with cryptography so they could not be changed without detection. On 31 October 2008, a person or group using the name Satoshi Nakamoto published the paper Bitcoin: A Peer-to-Peer Electronic Cash System, and the Bitcoin network started on 3 January 2009 with its first block, called the genesis block. Ethereum, proposed by Vitalik Buterin, launched in 2015 and added smart contracts, which are programs that run on the blockchain. In 2016, a flaw in a smart contract called The DAO was exploited and about 3.6 million ether was taken, which showed that code errors cannot be easily undone. In September 2022, Ethereum changed its method of agreeing on blocks from proof of work to proof of stake, which reduced its energy use. Companies also built private blockchains, such as Hyperledger Fabric.",

            // CORE CONCEPTS
            "1. Block: A group of records, such as transactions, together with a timestamp and the hash of the previous block.\n\n" +
            "2. Hash: A fixed-length fingerprint created from data by a hash function. Bitcoin uses SHA-256, which produces 64 hexadecimal characters. The same input always gives the same hash, and changing even one character of the input gives a completely different hash.\n\n" +
            "3. Chain: Each block stores the previous block's hash, so the blocks form a sequence that cannot be reordered or edited without changing every later hash.\n\n" +
            "4. Node: A computer that keeps a copy of the blockchain and checks new blocks against the rules.\n\n" +
            "5. Digital signature: A user signs a transaction with a private key, and anyone can check the signature with the matching public key. This proves who authorized the transaction without revealing the private key.\n\n" +
            "6. Wallet: Software or a device that stores private keys. Whoever has the private key controls the funds, and a lost key cannot be recovered.\n\n" +
            "7. Consensus: The method nodes use to agree on the next block. The two best-known are proof of work and proof of stake.\n\n" +
            "8. Smart contract: A program stored on the blockchain that runs automatically when its conditions are met.",

            // HOW IT WORKS
            "1. A user creates a transaction, for example sending a coin to another user, and signs it with their private key.\n\n" +
            "2. The transaction is broadcast to the nodes of the network.\n\n" +
            "3. Nodes check that the signature is valid and that the sender really has the funds.\n\n" +
            "4. Valid transactions are collected into a candidate block.\n\n" +
            "5. Consensus decides who adds the next block. In proof of work, miners repeatedly change a number called a nonce until the block's hash meets a difficulty target, which takes a lot of computing power. Bitcoin aims for a new block about every 10 minutes. In proof of stake, a validator is selected based on the amount of cryptocurrency it has locked up as a deposit, and it can lose that deposit for cheating.\n\n" +
            "6. The new block, containing the hash of the previous block, is sent to all nodes, which check it and add it to their copy.\n\n" +
            "7. The transaction is confirmed. Each additional block placed on top makes it harder to change.",

            // TYPES
            "1. Public blockchains: Anyone can read them and take part. Examples: Bitcoin and Ethereum.\n\n" +
            "2. Private blockchains: Run by one organization, which decides who can take part.\n\n" +
            "3. Consortium blockchains: Run by a group of organizations, such as several banks. Example: Hyperledger Fabric.\n\n" +
            "4. Hybrid blockchains: Combine private and public parts.\n\n" +
            "By consensus method: proof of work (Bitcoin) and proof of stake (Ethereum since 2022).",

            // EXAMPLES
            "A simplified chain of three blocks. The hash values below are made up for illustration:\n" +
            "```\n" +
            "Block 1  data: Ana pays Ben 5   hash: A1F3   previous: 0000\n" +
            "Block 2  data: Ben pays Cy 2    hash: 7B9C   previous: A1F3\n" +
            "Block 3  data: Cy pays Dee 1    hash: 3E52   previous: 7B9C\n" +
            "```\n\n" +
            "If someone edits Block 1 to say Ana pays Ben 500, the hash of Block 1 changes. Block 2 still stores the old hash A1F3, so the link no longer matches and the change is detected. To hide it, the attacker would have to recompute every later block and also convince most of the network to accept the new version, which is extremely hard on a large network.\n\n" +
            "A real hash example: the SHA-256 hash of the text hello is 2cf24dba5fb0a30e26e83b2ac5b9e29e1b161e5c1fa7425e73043362938b9824. If you change one letter, the new hash looks completely different.\n\n" +
            "A smart contract example: a contract can hold a payment and release it to a seller automatically once a delivery is confirmed.",

            // APPLICATIONS
            "Blockchain is used for cryptocurrencies such as Bitcoin and Ethereum, for tracking products through a supply chain, for checking the authenticity of certificates and records, for sending payments across borders, and for smart contracts in decentralized finance. Some organizations also use it to prove the origin of food or goods and to keep shared records between companies that do not fully trust each other.",

            // ADVANTAGES
            "Records are tamper-evident, because changes break the chain. The data is shared, so there is no single point of failure and no single owner who can quietly change it. Transactions can be traced and audited, and people can transact directly without relying on a central intermediary.",

            // LIMITATIONS
            "Proof of work uses large amounts of electricity. Blockchains are slower than centralized databases, because every node must check every block, and Bitcoin handles only a few transactions per second. Data written to the chain is hard to remove, so mistakes and illegal content cannot be easily undone. A lost private key means lost funds, and a stolen key lets a thief spend them. Bugs in smart contracts can be exploited, as in The DAO. If one group controls more than half of a network's power, it can rewrite recent blocks, an attack called a 51 percent attack. Many problems that are said to need a blockchain can be solved more simply with an ordinary database, so it is not always the right tool.",

            // RELATED TOPICS
            "Cryptography, Cybersecurity, Networking, Database Management, Cloud Computing.",

            // REFERENCES
            Arrays.asList(
                "Bitcoin: A Peer-to-Peer Electronic Cash System - Satoshi Nakamoto (2008): https://bitcoin.org/bitcoin.pdf",
                "Blockchain - Wikipedia: https://en.wikipedia.org/wiki/Blockchain",
                "Intro to Ethereum - ethereum.org: https://ethereum.org/en/developers/docs/intro-to-ethereum/"
            )

        ));

                manager.addArticle(new Article(

            26,

            "JavaScript",

            "Programming",

            "An introduction to JavaScript, the programming language that makes web pages interactive, covering variables, data types, functions, the DOM, events, asynchronous code with promises and fetch, where JavaScript runs, and how it differs from Java.",

            // DEFINITION
            "JavaScript is a programming language that runs in every major web browser and is used to make web pages interactive: reacting to clicks, changing what is shown without reloading the page, checking forms, and loading data from servers. It is also used outside the browser, for servers and apps. JavaScript is dynamically typed, which means a variable can hold different kinds of values at different times, and the type is checked while the program runs. Despite the similar name, JavaScript and Java are different languages.",

            // HISTORY
            "Brendan Eich created JavaScript at Netscape in May 1995, reportedly in about ten days. It was first called Mocha, then LiveScript, and was renamed JavaScript in December 1995 as part of a marketing agreement with Sun Microsystems, the company that created Java. In 1997, the language was standardized by Ecma International as ECMAScript (ECMA-262). The 2015 edition, known as ES6 or ES2015, added let and const, arrow functions, classes, modules and promises, and new editions have been published every year since. In 2009, Ryan Dahl released Node.js, which lets JavaScript run on servers outside the browser.",

            // CORE CONCEPTS
            "1. Variables: Named storage for values. Use let for a value that can change and const for a value that must not be reassigned. The older keyword var is still found in old code.\n\n" +
            "2. Data types: JavaScript has eight: string, number, bigint, boolean, undefined, null, symbol, and object. Arrays and functions are kinds of objects.\n\n" +
            "3. Functions: Reusable blocks of code. Functions are values, so they can be stored in variables, passed to other functions and returned from them.\n\n" +
            "4. Objects and arrays: An object stores named properties, such as a student with a name and a course. An array stores an ordered list.\n\n" +
            "5. DOM (Document Object Model): The browser's tree of objects that represents the HTML page. JavaScript changes the page by changing the DOM.\n\n" +
            "6. Events: Things that happen on the page, such as a click, a key press or a form submission. You attach a function, called an event listener, that runs when the event happens.\n\n" +
            "7. Asynchronous programming: Tasks that take time, such as loading data from a server, run in the background so the page does not freeze. They are handled with callbacks, promises, or the async and await keywords.\n\n" +
            "8. Event loop: The mechanism that lets JavaScript, which runs one task at a time on a single thread, still handle events and background tasks without blocking.\n\n" +
            "9. Equality: Use === (strict equality), which compares value and type. The == operator converts types first and can give surprising results.",

            // HOW IT WORKS
            "1. The browser downloads the HTML page and finds the script, either written inside the page or in a separate .js file.\n\n" +
            "2. The browser's JavaScript engine reads and runs the code. Chrome and Edge use V8, Firefox uses SpiderMonkey, and Safari uses JavaScriptCore. Modern engines compile the code to machine code while it runs, which is called just-in-time compilation.\n\n" +
            "3. The code reads and changes the DOM, so the visible page updates immediately.\n\n" +
            "4. When the user clicks or types, the browser creates an event, and the matching listener function runs.\n\n" +
            "5. When the code needs data from a server, it sends a request with fetch. The page keeps working, and a function runs when the response arrives.",

            // TYPES
            "Where JavaScript runs:\n\n" +
            "1. In the browser (client side): Controls page behavior. This is its original use.\n\n" +
            "2. On the server: Node.js, Deno and Bun run JavaScript outside a browser to build web servers and tools.\n\n" +
            "3. In apps: Electron builds desktop apps, and React Native builds mobile apps, using JavaScript.\n\n" +
            "Related tools:\n\n" +
            "4. Libraries and frameworks: React, Vue and Angular help build large interfaces.\n\n" +
            "5. TypeScript: A language built on JavaScript that adds types and is converted to JavaScript before it runs.",

            // EXAMPLES
            "1. Variables and a function:\n" +
            "```\n" +
            "let name = 'Ana';\n" +
            "const course = 'BSIT';\n" +
            "function greet(person) {\n" +
            "  return 'Hello, ' + person + '!';\n" +
            "}\n" +
            "console.log(greet(name));\n" +
            "```\n" +
            "This prints Hello, Ana! in the console.\n\n" +
            "2. Working with an array. The map method creates a new array by applying a function to every item:\n" +
            "```\n" +
            "const numbers = [1, 2, 3];\n" +
            "const doubled = numbers.map(n => n * 2);\n" +
            "console.log(doubled);\n" +
            "```\n" +
            "The result is [2, 4, 6].\n\n" +
            "3. Changing a web page and reacting to a click:\n" +
            "```\n" +
            "document.getElementById('title').textContent = 'Welcome';\n" +
            "document.querySelector('button').addEventListener('click', () => {\n" +
            "  alert('Button clicked');\n" +
            "});\n" +
            "```\n\n" +
            "4. Loading data from a server with fetch. This asks the Search IT server for articles about java:\n" +
            "```\n" +
            "fetch('http://localhost:8080/api/search?q=java')\n" +
            "  .then(response => response.json())\n" +
            "  .then(data => console.log(data.count));\n" +
            "```\n\n" +
            "5. A well-known surprise: '5' + 1 gives the text 51, because + joins text, but '5' - 1 gives the number 4, because - only works on numbers.",

            // APPLICATIONS
            "JavaScript is used in nearly every website for menus, forms, animations and live updates. It powers web apps such as online documents, chat and maps, and it is used on servers with Node.js. It is also used to build desktop and mobile apps, browser extensions and games, and the Search IT website in this project uses it to search and show articles.",

            // ADVANTAGES
            "It runs in every browser with nothing to install, so it is easy to start with. It is the only language browsers run directly, and a very large number of libraries and learning resources exist. The same language can be used on the page and on the server. It can update a page without reloading it.",

            // LIMITATIONS
            "Because types are checked only when the program runs, mistakes such as using the wrong kind of value can appear late. Automatic type conversion can give confusing results, which is why === is recommended. Long calculations can freeze a page because JavaScript runs on one thread. Code that puts user input directly into a page can allow cross-site scripting (XSS) attacks. The many frameworks change quickly, so there is a lot to keep up with.",

            // RELATED TOPICS
            "HTML and CSS, REST APIs and JSON, Web Development, Java Programming, Python Programming.",

            // REFERENCES
            Arrays.asList(
                "JavaScript - MDN Web Docs: https://developer.mozilla.org/en-US/docs/Web/JavaScript",
                "ECMA-262 (ECMAScript language specification) - Ecma International: https://ecma-international.org/publications-and-standards/standards/ecma-262/",
                "JavaScript - Wikipedia: https://en.wikipedia.org/wiki/JavaScript"
            )

        ));

                manager.addArticle(new Article(

            27,

            "Data Structures and Algorithms",

            "Programming",

            "An explanation of data structures (ways to organize data such as arrays, stacks, queues, hash tables and trees) and algorithms (step-by-step methods such as searching and sorting), with Big O notation and worked Java examples of binary search, a stack and bubble sort.",

            // DEFINITION
            "A data structure is a way of organizing and storing data in a computer so that it can be used efficiently. An algorithm is a finite, step-by-step set of instructions that solves a problem or completes a task. The two work together: the structure you choose decides how fast and how simply an algorithm can find, add or remove data. Studying them teaches you to compare different solutions to the same problem by how much time and memory they need.",

            // HISTORY
            "The word algorithm comes from the name of al-Khwarizmi, a mathematician who wrote in Baghdad in the 9th century. One of the oldest known algorithms, Euclid's method for finding the greatest common divisor of two numbers, dates to about 300 BC. Computer science added new ones: Tony Hoare invented quicksort in 1959, and Edsger Dijkstra devised his shortest-path algorithm in 1956. Donald Knuth began publishing The Art of Computer Programming in 1968, which set out how to analyze algorithms carefully. Today every major programming language ships ready-made data structures, such as the Java Collections Framework.",

            // CORE CONCEPTS
            "1. Data structure: A way to organize data, such as an array, list, stack, queue, hash table or tree.\n\n" +
            "2. Algorithm: A clear, finite sequence of steps that always produces a result for valid input.\n\n" +
            "3. Time complexity: How the number of steps grows as the amount of data (n) grows.\n\n" +
            "4. Space complexity: How much extra memory an algorithm needs as n grows.\n\n" +
            "5. Big O notation: A way to describe the growth of time or space in the worst case, ignoring small details. Common classes, from fastest to slowest growth: O(1) constant, O(log n) logarithmic, O(n) linear, O(n log n), and O(n squared) quadratic.\n\n" +
            "6. Abstract data type: A description of what a structure does, such as a stack with push and pop, separate from how it is built inside.\n\n" +
            "7. Trade-off: No structure is best for everything. One may be fast to read but slow to insert, so you choose the one that matches how your program uses the data.",

            // HOW IT WORKS
            "1. Define the problem clearly, including the input and the expected output.\n\n" +
            "2. Choose a data structure that fits how the data will be used. For example, use a hash table when you must look items up by key.\n\n" +
            "3. Design an algorithm, either from a known method or by breaking the problem into smaller steps.\n\n" +
            "4. Trace the algorithm by hand on a small example to check that it is correct.\n\n" +
            "5. Estimate its Big O time and memory use.\n\n" +
            "6. Write the code, test it with normal, empty and unusual inputs, and compare it with other solutions if it is too slow.",

            // TYPES
            "Common data structures:\n\n" +
            "1. Array: A fixed-size, ordered block of items. Reading an item by its index is O(1).\n\n" +
            "2. ArrayList: A resizable array in Java. Reading by index is O(1), and adding at the end is usually O(1).\n\n" +
            "3. Linked list: Items connected by links. Inserting after a known item is O(1), but finding an item is O(n).\n\n" +
            "4. Stack: Last in, first out (LIFO). Operations: push and pop. Used for undo and the back button.\n\n" +
            "5. Queue: First in, first out (FIFO). Used for print jobs and waiting lines.\n\n" +
            "6. Hash table (Java HashMap): Stores key-value pairs. Lookup, insert and delete are O(1) on average.\n\n" +
            "7. Tree: Items arranged in parent and child levels. A balanced binary search tree finds an item in O(log n).\n\n" +
            "8. Graph: Items (nodes) connected by links (edges), such as a map of roads.\n\n" +
            "Common algorithms:\n\n" +
            "9. Searching: Linear search checks each item, O(n). Binary search halves a sorted list each step, O(log n).\n\n" +
            "10. Sorting: Bubble sort is simple but O(n squared). Merge sort is O(n log n). Quicksort is O(n log n) on average.\n\n" +
            "11. Graph algorithms: Breadth-first search, depth-first search and Dijkstra's shortest path.\n\n" +
            "12. Techniques: Recursion, divide and conquer, greedy algorithms and dynamic programming.",

            // EXAMPLES
            "1. Binary search in Java. The array must already be sorted. Each step checks the middle item and throws away half of the remaining items:\n" +
            "```\n" +
            "int[] data = {2, 5, 8, 12, 16, 23, 38};\n" +
            "int target = 23;\n" +
            "int low = 0, high = data.length - 1;\n" +
            "while (low <= high) {\n" +
            "    int mid = (low + high) / 2;\n" +
            "    if (data[mid] == target) {\n" +
            "        System.out.println(\"Found at index \" + mid);\n" +
            "        break;\n" +
            "    } else if (data[mid] < target) {\n" +
            "        low = mid + 1;\n" +
            "    } else {\n" +
            "        high = mid - 1;\n" +
            "    }\n" +
            "}\n" +
            "```\n" +
            "Trace: the first middle is index 3 (value 12), which is less than 23, so the search moves right. The next middle is index 5 (value 23), which is found after 2 checks. A linear search would need 6 checks. For one million sorted items, binary search needs at most about 20 checks, while linear search may need one million.\n\n" +
            "2. A stack in Java:\n" +
            "```\n" +
            "Stack<Integer> stack = new Stack<>();\n" +
            "stack.push(1);\n" +
            "stack.push(2);\n" +
            "int top = stack.pop();\n" +
            "```\n" +
            "After the pop, top is 2, because the last item pushed is the first removed.\n\n" +
            "3. A hash map in Java:\n" +
            "```\n" +
            "Map<String, Integer> grades = new HashMap<>();\n" +
            "grades.put(\"Ana\", 92);\n" +
            "int g = grades.get(\"Ana\");\n" +
            "```\n" +
            "The value 92 is found directly from the key, without checking every entry.\n\n" +
            "4. Bubble sort on [5, 2, 9, 1]. Each pass compares neighbors and swaps them when they are out of order.\n" +
            "Pass 1: [2, 5, 1, 9]\n" +
            "Pass 2: [2, 1, 5, 9]\n" +
            "Pass 3: [1, 2, 5, 9]\n" +
            "The list is sorted after three passes.",

            // APPLICATIONS
            "Search engines and databases use trees and hash tables to find records quickly, and database indexes are usually built on trees. Maps and navigation apps use graph algorithms to find routes. Operating systems use queues to schedule programs, text editors use stacks for undo, and compilers use trees to understand code. Games, social networks, online shops and AI programs all depend on well-chosen data structures and algorithms.",

            // ADVANTAGES
            "Choosing the right structure and algorithm can make a program thousands of times faster and make it use less memory. Knowing them helps you compare solutions with Big O instead of guessing, write cleaner code, and prepare for technical interviews, where these topics are common. The ideas apply in every programming language.",

            // LIMITATIONS
            "There is no single best structure, so choosing needs thought about how the data will be used. Big O describes how running time grows and ignores constant factors, so a simpler O(n squared) method can be faster than a complex O(n log n) method on small data. Worst-case and average-case speed can differ, as with quicksort. Complex structures are harder to write and debug, and for small programs a plain array or ArrayList is often enough.",

            // RELATED TOPICS
            "Introduction to Programming, Java Programming, Python Programming, Database Management, Artificial Intelligence.",

            // REFERENCES
            Arrays.asList(
                "Data structure - Wikipedia: https://en.wikipedia.org/wiki/Data_structure",
                "Big-O Algorithm Complexity Cheat Sheet: https://www.bigocheatsheet.com/",
                "Collections - The Java Tutorials, Oracle: https://docs.oracle.com/javase/tutorial/collections/"
            )

        ));

                manager.addArticle(new Article(

            28,

            "Git and GitHub",

            "Programming",

            "An explanation of Git, the version control system that records every change to a project, and GitHub, the website that hosts Git repositories, covering commits, the staging area, branches, merging, remotes, the everyday commands add, commit and push, and how to keep secrets out of a repository.",

            // DEFINITION
            "Git is a free, distributed version control system. It records the history of a project as a series of saved snapshots called commits, so you can see what changed, who changed it and when, and return to an earlier version if something breaks. GitHub is a separate website and service that stores Git repositories online, so that people can back up their work, share it and work on it together. Git is the tool, and GitHub is one of the places that hosts it.",

            // HISTORY
            "Linus Torvalds created Git in April 2005 to manage the development of the Linux kernel, after the commercial tool that the Linux developers had been using became unavailable to them. He designed it to be fast, to work without a central server, and to keep the history safe. GitHub was launched in April 2008 by Tom Preston-Werner, Chris Wanstrath and PJ Hyett, and it became the most widely used place to host code. Microsoft announced in 2018 that it would buy GitHub for 7.5 billion US dollars. In 2020, GitHub changed the default name of the first branch of new repositories from master to main.",

            // CORE CONCEPTS
            "1. Repository (repo): A project folder together with its complete history, stored in a hidden folder named .git.\n\n" +
            "2. Commit: A saved snapshot of the project with a message that explains the change. Each commit has a unique ID, a 40-character hash.\n\n" +
            "3. Working directory: The files you see and edit.\n\n" +
            "4. Staging area: A holding area where you choose which changes will go into the next commit. The command git add puts changes there.\n\n" +
            "5. Branch: A separate line of development. You can try a new feature on a branch without disturbing the main code.\n\n" +
            "6. Merge: Combining the changes of one branch into another. If both branches changed the same lines, a merge conflict occurs and you must choose the correct result by hand.\n\n" +
            "7. Remote: A copy of the repository stored elsewhere, such as on GitHub. The default remote is named origin.\n\n" +
            "8. Clone, push and pull: Clone downloads a full copy of a repository. Push uploads your commits to a remote. Pull downloads new commits from a remote and combines them with yours.\n\n" +
            "9. Pull request: A request on GitHub to merge one branch into another, where teammates can review and discuss the changes first.\n\n" +
            "10. .gitignore: A file that lists files and folders Git must not track, such as passwords, build output and personal settings.",

            // HOW IT WORKS
            "1. You edit files in the working directory.\n\n" +
            "2. You run git status to see which files changed.\n\n" +
            "3. You run git add to move the chosen changes into the staging area.\n\n" +
            "4. You run git commit with a message. Git saves a snapshot of everything that was staged and gives it a hash.\n\n" +
            "5. Each commit points to the commit before it, which forms the history of the project.\n\n" +
            "6. You run git push to upload the new commits to the remote repository on GitHub.\n\n" +
            "7. Other people run git pull to receive them. Because every copy holds the full history, work can continue offline and any copy can restore the project.",

            // TYPES
            "1. Local version control: Keeps versions only on one computer.\n\n" +
            "2. Centralized version control: A single central server holds the history, as in Subversion. Everyone must connect to it.\n\n" +
            "3. Distributed version control: Every user has a full copy of the history. Git and Mercurial work this way.\n\n" +
            "Services that host Git repositories: GitHub, GitLab and Bitbucket.\n\n" +
            "Common ways of working: committing directly to the main branch for solo projects, creating a branch for each feature, or forking a repository to your own account and proposing changes through a pull request.",

            // EXAMPLES
            "1. The everyday cycle used to save work to GitHub:\n" +
            "```\n" +
            "git status\n" +
            "git add .\n" +
            "git commit -m \"Add SQL Basics article\"\n" +
            "git push\n" +
            "```\n" +
            "The first command lists what changed, the second stages everything, the third saves a snapshot with a clear message, and the last uploads it.\n\n" +
            "2. Working on a feature in a branch, then merging it:\n" +
            "```\n" +
            "git switch -c add-articles\n" +
            "git add .\n" +
            "git commit -m \"Add new articles\"\n" +
            "git switch main\n" +
            "git merge add-articles\n" +
            "```\n\n" +
            "3. Looking at the history and the last change:\n" +
            "```\n" +
            "git log --oneline\n" +
            "git diff\n" +
            "```\n\n" +
            "4. Keeping a private folder out of the repository. Add this line to .gitignore:\n" +
            "```\n" +
            "data/\n" +
            "```\n" +
            "If a file was already tracked, git rm --cached stops Git from tracking it. This is how the Search IT project keeps its accounts file, which contains password hashes, out of GitHub. Note that a file that was uploaded before stays in the old history, so a real password that was ever committed must be changed.",

            // APPLICATIONS
            "Git is used by almost all software teams to track changes and work together without overwriting each other. Students use it to submit and back up projects, open-source projects use GitHub to accept contributions from anyone, and writers and designers use it for text and configuration files. GitHub also provides issue tracking, project boards, automatic testing and free hosting for websites with GitHub Pages.",

            // ADVANTAGES
            "Nothing is lost: any earlier version can be restored. You can see who changed each line and why. Branches let people experiment safely, and many people can work on the same project at once. Because every copy has the full history, work is backed up in several places and most commands work without internet.",

            // LIMITATIONS
            "Git has a learning curve, because of ideas such as staging and branches and because commands can be confusing at first. Merge conflicts must be solved by hand. Git works best with text files and is less suited to very large files or many binary files. Mistakes, such as committing a password or a large file, are hard to fully remove from history. Anything pushed to a public repository can be seen by everyone, so private data must never be committed.",

            // RELATED TOPICS
            "Introduction to Programming, Java Programming, Web Development, Cybersecurity, Cloud Computing.",

            // REFERENCES
            Arrays.asList(
                "Pro Git book - Scott Chacon and Ben Straub: https://git-scm.com/book/en/v2",
                "Get started with GitHub - GitHub Docs: https://docs.github.com/en/get-started",
                "Git - Wikipedia: https://en.wikipedia.org/wiki/Git"
            )

        ));

                manager.addArticle(new Article(

            29,

            "Computer Hardware",

            "Computer Fundamentals",

            "An explanation of computer hardware: the physical parts of a computer, including the CPU, RAM, storage (HDD and SSD), motherboard, GPU, power supply and input and output devices, how they work together to run a program, and how to read a computer's specifications.",

            // DEFINITION
            "Computer hardware is the physical parts of a computer system, the components you can touch, such as the processor, memory, storage, motherboard, screen and keyboard. Hardware does nothing useful alone. It needs software, which is the programs and data that tell the hardware what to do. Every computer, from a phone to a large server, is built from the same kinds of hardware components.",

            // HISTORY
            "In 1837, Charles Babbage designed the Analytical Engine, a mechanical machine with a processing unit and a memory, though it was never finished. The ENIAC, completed in 1945 in the United States, used about 17,000 vacuum tubes and filled a large room. The transistor was invented at Bell Labs in 1947, and it replaced vacuum tubes with smaller, cooler and more reliable parts. Jack Kilby demonstrated the first integrated circuit in 1958, which put several transistors on one chip. In 1971, Intel released the 4004, the first commercial microprocessor, which placed a whole processor on one chip. The IBM Personal Computer arrived in 1981. In 1965, Gordon Moore observed that the number of transistors on a chip was doubling roughly every two years, an observation called Moore's law, and it held for decades. Solid-state drives (SSDs) based on flash memory gradually replaced hard disks in laptops and many desktops in the 2010s.",

            // CORE CONCEPTS
            "1. CPU (central processing unit): The processor, the part that runs program instructions. It is described by its number of cores (each core can work on a task), its clock speed in gigahertz (GHz, billions of cycles per second), and its cache, a very small, very fast memory inside the chip.\n\n" +
            "2. RAM (random access memory): The computer's short-term working memory. It holds the programs and data that are in use right now and is much faster than storage. It is volatile, which means its contents are lost when the power is turned off. Sizes are measured in gigabytes (GB), and common types are DDR4 and DDR5.\n\n" +
            "3. Storage: Keeps programs and files permanently, even without power (non-volatile). A hard disk drive (HDD) stores data on spinning magnetic platters. A solid-state drive (SSD) stores data in flash chips with no moving parts.\n\n" +
            "4. Motherboard: The main circuit board that connects the CPU, RAM, storage and other parts, and carries the signals between them.\n\n" +
            "5. GPU (graphics processing unit): A processor specialized for drawing images and doing many simple calculations at once. It is used for games, video editing and training AI models.\n\n" +
            "6. Power supply unit (PSU): Converts the electricity from the wall socket into the lower voltages the components need.\n\n" +
            "7. Firmware: Small permanent software stored on a chip on the motherboard, called BIOS or UEFI, that starts the computer and loads the operating system.\n\n" +
            "8. Fetch, decode, execute: The cycle the CPU repeats billions of times per second. It fetches an instruction from memory, decodes what it means, and executes it.",

            // HOW IT WORKS
            "1. When you press the power button, the power supply delivers electricity to the motherboard and all components.\n\n" +
            "2. The firmware (UEFI or BIOS) runs a self-test, called POST, to check that the CPU, RAM and other basic parts respond.\n\n" +
            "3. The firmware finds the operating system on the storage drive and copies the first part of it into RAM.\n\n" +
            "4. The CPU fetches instructions from RAM, decodes them, executes them, and writes results back to RAM. Frequently used data is kept in the fast cache.\n\n" +
            "5. When you open a program or a file, it is copied from the storage drive into RAM so the CPU can reach it quickly.\n\n" +
            "6. Input devices, such as a keyboard or touchscreen, send signals to the CPU. Output devices, such as the screen or speakers, receive the results. The GPU prepares the picture that appears on the screen.\n\n" +
            "7. When you save a file, the data is written from RAM to the storage drive so it is kept after the power is turned off.",

            // TYPES
            "1. Input devices: Send data into the computer. Examples: keyboard, mouse, touchscreen, microphone, scanner and webcam.\n\n" +
            "2. Output devices: Present results. Examples: monitor, printer and speakers.\n\n" +
            "3. Processing devices: The CPU and the GPU.\n\n" +
            "4. Memory: RAM for working memory, cache inside the CPU, and ROM, which holds fixed firmware.\n\n" +
            "5. Storage devices: Hard disk drives, solid-state drives, USB flash drives, memory cards and optical discs.\n\n" +
            "6. Communication devices: A network interface card (NIC), a Wi-Fi adapter, Bluetooth and a modem, which connect the computer to networks.\n\n" +
            "Kinds of computers: desktop computers, laptops, tablets, smartphones, servers and embedded computers inside appliances and cars.",

            // EXAMPLES
            "1. Reading a specification. A laptop is listed as: Intel Core i5, 8 cores, 3.0 GHz, 16 GB DDR4 RAM, 512 GB SSD. This means a processor with 8 cores that runs at 3.0 billion cycles per second, 16 GB of working memory so several programs can be open at once, and 512 GB of permanent storage on a fast flash drive.\n\n" +
            "2. Comparing storage types:\n" +
            "```\n" +
            "Type        How it stores        Typical speed        Moving parts\n" +
            "HDD         Magnetic platters    about 100-150 MB/s   Yes\n" +
            "SATA SSD    Flash chips          about 500 MB/s       No\n" +
            "NVMe SSD    Flash chips          several GB/s         No\n" +
            "```\n" +
            "An SSD makes a computer start and open programs much faster than an HDD.\n\n" +
            "3. Why more RAM helps: if the programs you use need more memory than you have, the operating system moves data to the much slower storage drive, and the computer becomes slow. Adding RAM prevents this.\n\n" +
            "4. A tablet combines a processor, memory, flash storage, a touchscreen, a camera, a battery and wireless chips on one small board. A desktop computer uses the same kinds of parts, but as separate, replaceable components.",

            // APPLICATIONS
            "Knowing hardware helps you choose a computer for a task. Office work and web browsing need a modest CPU, 8 GB of RAM and an SSD. Programming with a code editor and several tools open is more comfortable with 16 GB of RAM. Video editing, 3D design and gaming need a strong CPU and a dedicated GPU. Servers need many cores, large RAM and reliable storage. It also helps you troubleshoot problems, such as a computer that is slow because of a nearly full drive or too little RAM.",

            // ADVANTAGES
            "Modern hardware is far faster, smaller and cheaper than earlier generations. Parts follow common standards, so many components can be upgraded or replaced separately, for example adding RAM or swapping a hard disk for an SSD. Solid-state storage is quiet, fast and more resistant to shocks.",

            // LIMITATIONS
            "Hardware wears out and becomes outdated, and heat is a constant problem, because fast processors need cooling. Batteries lose capacity over time. Some devices, especially thin laptops and tablets, have parts that cannot be upgraded. Power use and cost grow with performance, and discarded electronics create electronic waste that must be recycled properly. Parts must also be compatible with each other, such as the right type of RAM for the motherboard.",

            // RELATED TOPICS
            "Computer Software, Operating Systems, Binary Number System, Networking, Internet of Things.",

            // REFERENCES
            Arrays.asList(
                "Computer hardware - Wikipedia: https://en.wikipedia.org/wiki/Computer_hardware",
                "Central processing unit - Wikipedia: https://en.wikipedia.org/wiki/Central_processing_unit",
                "Timeline of Computer History - Computer History Museum: https://www.computerhistory.org/timeline/computers/"
            )

        ));

                manager.addArticle(new Article(

            30,

            "DNS (Domain Name System)",

            "Networking",

            "An explanation of the Domain Name System (DNS), the internet service that translates domain names such as www.example.com into IP addresses, covering the DNS hierarchy, resolvers and name servers, common record types, caching and TTL, a step-by-step lookup, and DNS security problems.",

            // DEFINITION
            "The Domain Name System (DNS) is the internet's naming service. It translates human-friendly domain names, such as www.example.com, into the numeric IP addresses that computers use to find each other, such as 203.0.113.10. It is often compared to a phone book, because you look up a name and get a number. DNS is a hierarchical and distributed system, which means no single computer holds all the answers. The information is spread across millions of servers around the world.",

            // HISTORY
            "In the early days of the ARPANET, every computer name and address was listed in a single file called HOSTS.TXT, maintained by the Stanford Research Institute and copied by everyone. As the network grew, this became impossible to keep up to date. In 1983, Paul Mockapetris designed DNS, first described in RFC 882 and RFC 883, and the design was refined in RFC 1034 and RFC 1035 in 1987, which are still the base of the system. ICANN was created in 1998 to coordinate domain names and IP addresses. DNSSEC, a set of security extensions, was standardized in 2005, and DNS over HTTPS, which encrypts DNS queries, was standardized in 2018 in RFC 8484.",

            // CORE CONCEPTS
            "1. Domain name: A name that identifies a site or service, read from right to left in levels. In www.example.com, com is the top-level domain, example is the second-level domain, and www is a subdomain.\n\n" +
            "2. DNS hierarchy: At the top is the root, then top-level domains (TLDs) such as .com and .org and country codes such as .ph, then individual domains and subdomains.\n\n" +
            "3. Root name servers: The servers at the top of the hierarchy. They know where to find the servers for each TLD. There are 13 named root server addresses, labeled A to M, run by 12 organizations, and each is copied at hundreds of sites around the world.\n\n" +
            "4. Authoritative name server: The server that holds the official records for a domain and gives the final answer for it.\n\n" +
            "5. Recursive resolver: The server that does the searching for you. It is usually provided by your internet provider, or you can use a public one such as 8.8.8.8 (Google) or 1.1.1.1 (Cloudflare).\n\n" +
            "6. DNS records: The entries stored for a domain. A maps a name to an IPv4 address. AAAA maps to an IPv6 address. CNAME makes one name an alias of another. MX names the mail servers. NS names the domain's name servers. TXT holds text, often used for verification. PTR maps an address back to a name.\n\n" +
            "7. TTL (time to live): The number of seconds that an answer may be kept in a cache before it must be looked up again.\n\n" +
            "8. Caching: Storing recent answers on your device, in your browser and in the resolver, so repeated lookups are instant.\n\n" +
            "9. Port 53: DNS normally uses port 53, over UDP for short queries and TCP for large answers.",

            // HOW IT WORKS
            "When you type www.example.com into a browser:\n\n" +
            "1. The browser and the operating system check their caches. If the address is stored and still valid, the lookup ends here.\n\n" +
            "2. If not, the computer sends a query to the recursive resolver.\n\n" +
            "3. If the resolver has no cached answer, it asks a root server, which replies with the address of the servers for the .com TLD.\n\n" +
            "4. The resolver asks a .com TLD server, which replies with the address of the authoritative name server for example.com.\n\n" +
            "5. The resolver asks that authoritative server for www.example.com and receives the IP address.\n\n" +
            "6. The resolver caches the answer for the length of its TTL and returns it to your computer.\n\n" +
            "7. The browser connects to the IP address and requests the web page.\n\n" +
            "The whole lookup usually takes only a few milliseconds to a few tens of milliseconds.",

            // TYPES
            "Types of DNS servers:\n\n" +
            "1. Recursive resolvers: Look up answers on behalf of users.\n\n" +
            "2. Root servers: Point to the TLD servers.\n\n" +
            "3. TLD servers: Know the name servers of every domain under a TLD such as .com.\n\n" +
            "4. Authoritative servers: Hold the real records for a domain.\n\n" +
            "Types of queries: A recursive query asks a server to find the full answer itself. An iterative query lets a server answer with the best information it has, such as a referral to the next server.\n\n" +
            "Security and privacy variants: DNSSEC adds digital signatures that prove an answer is genuine. DNS over HTTPS (DoH) and DNS over TLS (DoT) encrypt queries so that others on the network cannot read them.",

            // EXAMPLES
            "1. Looking up a name with the nslookup tool. The address shown is a reserved example address, used for illustration:\n" +
            "```\n" +
            "nslookup example.com\n" +
            "Name:    example.com\n" +
            "Address: 203.0.113.10\n" +
            "```\n\n" +
            "2. Records in a domain's zone. Each line gives the name, the TTL in seconds, the record type and the value:\n" +
            "```\n" +
            "example.com.      3600  IN  A      203.0.113.10\n" +
            "www.example.com.  3600  IN  CNAME  example.com.\n" +
            "example.com.      3600  IN  MX 10  mail.example.com.\n" +
            "```\n" +
            "The A record gives the address, the CNAME makes www an alias of the main name, and the MX record says where email for the domain is delivered.\n\n" +
            "3. The name localhost is not looked up on the internet. Your computer's hosts file maps it to 127.0.0.1, the address of the computer itself. This is why the Search IT server at http://localhost:8080 works without any DNS server.\n\n" +
            "4. Moving a website to a new server: the owner changes the A record to the new address. Because of caching, some users see the new server immediately and others only after the old TTL expires.",

            // APPLICATIONS
            "DNS is used every time a browser, app or game reaches a named server, which makes it essential to the web, email and nearly all online services. Companies use DNS to send visitors to the nearest server, spread traffic across several servers, and move services without changing the name. DNS filtering is used by schools, families and companies to block harmful or unwanted sites. Email systems depend on MX and TXT records to deliver mail and fight spam.",

            // ADVANTAGES
            "People can use easy-to-remember names instead of numbers. A site can change its server or IP address without telling its visitors, because only the DNS record changes. The distributed design and caching make lookups fast and let the system serve billions of users without one central point that could fail.",

            // LIMITATIONS
            "If DNS fails, websites become unreachable even though their servers are working. Traditional DNS queries are not encrypted, so others on the network can see which sites you look up. Attackers can attempt DNS spoofing or cache poisoning, which gives users a false address that leads to a fake site, and security researcher Dan Kaminsky demonstrated a serious cache poisoning flaw in 2008. DNS servers can be flooded with traffic, as in the 2016 attack on the provider Dyn, which made many popular sites unreachable. Because of caching, changes to a record can take hours to reach everyone.",

            // RELATED TOPICS
            "Networking, HTTP and the Web, Web Development, Cybersecurity, Cloud Computing.",

            // REFERENCES
            Arrays.asList(
                "RFC 1034 - Domain Names: Concepts and Facilities: https://www.rfc-editor.org/rfc/rfc1034",
                "RFC 1035 - Domain Names: Implementation and Specification: https://www.rfc-editor.org/rfc/rfc1035",
                "What is DNS? - Cloudflare Learning Center: https://www.cloudflare.com/learning/dns/what-is-dns/"
            )

        ));

                manager.addArticle(new Article(

            31,

            "Wireless Networks",

            "Networking",

            "An explanation of wireless networks, which connect devices with radio waves instead of cables, covering Wi-Fi standards and frequency bands, access points, how a device joins and sends data, Bluetooth, cellular and other wireless types, security (WPA2 and WPA3), and the common limits of range and interference.",

            // DEFINITION
            "A wireless network connects devices using radio waves instead of cables. The most common example is Wi-Fi, which lets laptops, phones and tablets join a local network and the internet without plugging in a cable. Other wireless technologies include Bluetooth, which connects nearby accessories, and cellular networks (4G and 5G), which cover large areas. Wireless networks still depend on wired connections behind the scenes, since the access point or tower is usually connected to the rest of the network by a cable.",

            // HISTORY
            "In 1971, Norman Abramson and his team at the University of Hawaii created ALOHAnet, the first wireless packet network, to link computers on different islands by radio. In 1997, the IEEE published the first 802.11 standard for wireless local area networks, with a speed of up to 2 Mbps. In 1999, the faster 802.11b (11 Mbps) and 802.11a (54 Mbps) were released, and the industry group now called the Wi-Fi Alliance introduced the name Wi-Fi. Later versions include 802.11n in 2009, 802.11ac in 2013 and 802.11ax in 2019, and from 2018 the generations have been numbered Wi-Fi 4, 5 and 6, with Wi-Fi 7 (802.11be) following. Cellular networks moved from 2G digital voice in the early 1990s, to 3G data around 2001, to 4G LTE around 2010, and to 5G from 2019.",

            // CORE CONCEPTS
            "1. Radio frequency bands: Wi-Fi uses 2.4 GHz, 5 GHz and, in newer versions, 6 GHz. Lower frequencies travel farther and pass through walls better, and higher frequencies carry more data over shorter distances.\n\n" +
            "2. Access point (AP): The device that connects wireless devices to the network. A home wireless router combines an access point, a router and a small switch in one box.\n\n" +
            "3. SSID: The name of a wireless network, which is what you see in the list of networks.\n\n" +
            "4. Channel: A slice of a frequency band. Neighboring networks on the same or overlapping channels interfere with each other. In the 2.4 GHz band, only channels 1, 6 and 11 do not overlap.\n\n" +
            "5. Signal strength: Measured in dBm, a negative number. Closer to zero is stronger, so minus 50 dBm is a very strong signal and minus 80 dBm is weak.\n\n" +
            "6. Bandwidth and throughput: Bandwidth is the maximum speed the link supports, and throughput is the real speed you get, which is lower because of distance, interference, overhead and the number of users sharing the connection.\n\n" +
            "7. Encryption and authentication: A password and an encryption standard, WPA2 or WPA3, make sure only authorized devices join and that the data cannot be read by others.\n\n" +
            "8. CSMA/CA: The rule wireless devices follow to avoid collisions. Each device listens first and transmits only when the channel is free.\n\n" +
            "9. Infrastructure and ad hoc modes: In infrastructure mode, devices connect through an access point. In ad hoc mode, devices connect directly to each other.",

            // HOW IT WORKS
            "1. The access point broadcasts its SSID, and the device scans and lists the networks it hears.\n\n" +
            "2. The user selects a network and enters the password. The device and the access point perform a handshake that proves the password is correct and creates encryption keys.\n\n" +
            "3. The device is now associated with the access point. A DHCP server, usually in the router, gives it an IP address.\n\n" +
            "4. When the device sends data, it breaks it into frames, checks that the channel is free, encrypts the frames, and transmits them as radio waves.\n\n" +
            "5. The access point receives the frames, decrypts them and forwards the data to the router and the internet.\n\n" +
            "6. Replies travel the same way in reverse. If the signal gets weak, the device may switch to a stronger access point, which is called roaming.",

            // TYPES
            "By area covered:\n\n" +
            "1. Wireless personal area network (WPAN): A few meters. Bluetooth, Zigbee and NFC.\n\n" +
            "2. Wireless local area network (WLAN): A home, school or office, typically tens of meters indoors. Wi-Fi.\n\n" +
            "3. Wireless wide area network (WWAN): Kilometers. Cellular networks such as 4G LTE and 5G.\n\n" +
            "4. Low-power wide-area networks (LPWAN): Long range with very little power, for sensors. LoRaWAN and NB-IoT.\n\n" +
            "5. Satellite networks: Used where no other coverage exists, such as ships, remote areas and aircraft.\n\n" +
            "Wi-Fi generations, with the highest theoretical speeds (real speeds are lower):\n" +
            "```\n" +
            "Name     Standard     Year   Bands                Top speed (theory)\n" +
            "Wi-Fi 4  802.11n      2009   2.4 and 5 GHz        600 Mbps\n" +
            "Wi-Fi 5  802.11ac     2013   5 GHz                several Gbps\n" +
            "Wi-Fi 6  802.11ax     2019   2.4 and 5 GHz        9.6 Gbps\n" +
            "Wi-Fi 6E 802.11ax     2020   adds 6 GHz           9.6 Gbps\n" +
            "Wi-Fi 7  802.11be     2024   2.4, 5 and 6 GHz     46 Gbps\n" +
            "```",

            // EXAMPLES
            "1. Joining a home network: your tablet lists the SSIDs it hears, you choose one, you type the password, and within seconds the router gives the tablet an IP address and it can open websites.\n\n" +
            "2. Choosing a band. A router offers a 2.4 GHz and a 5 GHz network.\n" +
            "```\n" +
            "2.4 GHz: longer range, passes through walls better, slower, crowded\n" +
            "5 GHz:   shorter range, faster, less crowded\n" +
            "```\n" +
            "Use 5 GHz when you are in the same room as the router and 2.4 GHz when you are far away or behind walls.\n\n" +
            "3. Bluetooth connects wireless earphones to a phone over a few meters, using very little power.\n\n" +
            "4. A phone sends mobile data through a cellular tower, which can be several kilometers away.\n\n" +
            "5. Basic safe setup for a home router: choose WPA3 if all devices support it, otherwise WPA2 with AES, use a long password, change the default administrator password of the router, and turn off WPS.\n\n" +
            "6. Cloud tools such as the one used to build this project depend on a stable connection. A weak Wi-Fi signal can drop the connection to the online code editor.",

            // APPLICATIONS
            "Wireless networks are used in homes, schools and offices for laptops, phones and tablets, and in public places such as airports, cafes and libraries. Bluetooth connects headphones, keyboards, speakers and smartwatches. Cellular networks provide mobile calls and mobile internet. Wireless links are also used in smart homes, warehouses, hospitals and factories, in the Internet of Things, in vehicles, and in places where laying cables is difficult or costly.",

            // ADVANTAGES
            "Users can move around while staying connected. Installation is faster and cheaper than running cables, and new devices can be added easily without new wiring. Wireless access reaches places where cables are impractical, and it supports modern devices such as phones, tablets and sensors that have no cable port.",

            // LIMITATIONS
            "Range is limited, and walls, floors, metal and water reduce the signal. Interference from other networks, microwave ovens and Bluetooth devices can slow the connection. Speed and delay are usually worse than a wired Ethernet connection, and all devices on one access point share the same airtime. Because radio waves can be received by anyone nearby, security is a concern. Open networks send data that others can capture, the old WEP encryption is broken, and in 2017 a flaw called KRACK was found in WPA2, which was fixed by updates. Always use the latest security standard and keep router firmware updated.",

            // RELATED TOPICS
            "Networking, Internet of Things, Cybersecurity, Computer Hardware, DNS.",

            // REFERENCES
            Arrays.asList(
                "Wireless network - Wikipedia: https://en.wikipedia.org/wiki/Wireless_network",
                "IEEE 802.11 Working Group (Wireless LAN): https://www.ieee802.org/11/",
                "Wi-Fi Alliance: https://www.wi-fi.org/"
            )

        ));

          manager.addArticle(new Article(

            32,

            "Network Security",

            "Cybersecurity",

            "An explanation of network security: the tools and practices that protect a network and its data from unauthorized access and attacks, covering the CIA triad, firewalls, intrusion detection and prevention, VPNs, authentication, segmentation, common attacks such as DDoS and man-in-the-middle, and a sample firewall rule set.",

            // DEFINITION
            "Network security is the set of policies, tools and practices used to protect a computer network and the data that travels across it from unauthorized access, misuse, damage and attack. Its goals are summarized by the CIA triad: confidentiality (only authorized people can read the data), integrity (the data cannot be changed without detection) and availability (the network and its services work when they are needed). Good network security uses several layers of protection together instead of relying on a single tool.",

            // HISTORY
            "On 2 November 1988, the Morris worm spread across the early internet and slowed or crashed about 10 percent of the roughly 60,000 connected computers. This was a turning point that led to the creation of the first computer emergency response team and to wider use of network defenses. Packet-filtering firewalls were developed in the late 1980s and became common in the 1990s. Netscape introduced SSL in 1995, which was later standardized as TLS in 1999 and is what makes HTTPS secure. Wi-Fi security moved from WEP (1997), which was broken, to WPA (2003), WPA2 (2004) and WPA3 (2018). In 2010, John Kindervag of Forrester Research described the zero trust model, which says that no user or device should be trusted automatically just because it is inside the network.",

            // CORE CONCEPTS
            "1. CIA triad: Confidentiality, integrity and availability, the three goals of security.\n\n" +
            "2. Threat, vulnerability and risk: A threat is something that can cause harm, such as an attacker. A vulnerability is a weakness, such as unpatched software or a weak password. Risk is the chance that a threat uses a vulnerability, multiplied by the damage it would cause.\n\n" +
            "3. Firewall: A system that allows or blocks network traffic according to rules about source, destination, port and protocol.\n\n" +
            "4. IDS and IPS: An intrusion detection system (IDS) watches traffic and raises alerts about suspicious activity. An intrusion prevention system (IPS) can also block it automatically.\n\n" +
            "5. VPN (virtual private network): Creates an encrypted tunnel across a public network so that data cannot be read on the way.\n\n" +
            "6. Authentication, authorization and accounting (AAA): Proving who you are, deciding what you may do, and recording what you did. Multi-factor authentication (MFA) requires two or more proofs, such as a password and a code from a phone.\n\n" +
            "7. Network segmentation: Dividing a network into separate zones, for example with VLANs, so that a problem in one zone cannot easily spread to the others. A DMZ is a zone for public-facing servers that is separated from the internal network.\n\n" +
            "8. Least privilege: Giving each user and program only the access it needs and nothing more.\n\n" +
            "9. Defense in depth: Using several layers of protection, so that if one fails, others still protect the network.\n\n" +
            "10. Patching: Installing software updates that fix known vulnerabilities.",

            // HOW IT WORKS
            "1. Traffic arriving from the internet first meets a firewall, which compares each connection with its rules and blocks anything that is not allowed.\n\n" +
            "2. Allowed traffic is watched by an IDS or IPS, which compares it with known attack patterns and with normal behavior, and alerts or blocks when something looks wrong.\n\n" +
            "3. Users and devices must authenticate before they can use the network, and are given only the permissions their role needs.\n\n" +
            "4. Data that crosses untrusted networks is encrypted, for example by TLS for websites or by a VPN for remote workers.\n\n" +
            "5. The network is divided into segments, so servers with sensitive data sit in a more protected zone than ordinary user computers.\n\n" +
            "6. Logs from firewalls, servers and devices are collected and reviewed, often by a security information and event management (SIEM) system, so problems are noticed quickly.\n\n" +
            "7. Software and device firmware are kept updated, and the network is tested regularly for weaknesses.",

            // TYPES
            "Common attacks on networks:\n\n" +
            "1. Denial of service (DoS) and distributed denial of service (DDoS): Flooding a server or network with traffic so real users cannot reach it.\n\n" +
            "2. Man-in-the-middle: An attacker secretly sits between two parties, reading or changing their messages, for example through a fake Wi-Fi hotspot.\n\n" +
            "3. Packet sniffing: Capturing unencrypted traffic to read passwords or messages.\n\n" +
            "4. Spoofing: Pretending to be another device or site, such as ARP spoofing on a local network or DNS spoofing.\n\n" +
            "5. Port scanning: Probing a computer to find open ports and services that might be vulnerable.\n\n" +
            "6. Brute force and credential stuffing: Trying many passwords, or passwords leaked from other sites, until one works.\n\n" +
            "7. Phishing: Tricking people into giving up passwords or running malware through fake messages and sites.\n\n" +
            "8. Malware and ransomware: Harmful programs that spread across a network, and in the case of ransomware, lock files until a payment is made.\n\n" +
            "Common defenses:\n\n" +
            "9. Firewalls: packet-filtering, stateful (tracks connections), and next-generation firewalls, plus web application firewalls (WAF) that protect websites.\n\n" +
            "10. IDS and IPS: network-based or host-based, using signatures of known attacks or detection of unusual behavior.\n\n" +
            "11. VPNs: remote-access VPNs for individual users and site-to-site VPNs that join two office networks.\n\n" +
            "12. Endpoint protection, email filtering, and network access control.",

            // EXAMPLES
            "1. A simple firewall rule set. Rules are checked in order, and the last rule blocks everything not allowed above it, which is called default deny:\n" +
            "```\n" +
            "Rule  Action  Source       Destination   Port  Protocol\n" +
            "1     ALLOW   any          web server    443   TCP\n" +
            "2     ALLOW   office net   database      3306  TCP\n" +
            "3     DENY    any          any           any   any\n" +
            "```\n" +
            "Anyone may reach the web server over HTTPS (port 443). Only the office network may reach the database (port 3306). Everything else is blocked.\n\n" +
            "2. Using public Wi-Fi at a cafe: an attacker on the same network may try to capture traffic. Websites that use HTTPS are encrypted, and a VPN adds encryption for everything the device sends.\n\n" +
            "3. Multi-factor authentication: even if an attacker learns a password, they also need the code from the user's phone.\n\n" +
            "4. A DDoS attack: thousands of infected devices send requests to one website at the same time, which overloads it. Defenses include filtering traffic and using services that spread the load across many servers.\n\n" +
            "5. The Search IT project: user passwords are stored as salted PBKDF2 hashes, so a stolen accounts file does not directly reveal the passwords, and the file is kept out of GitHub with .gitignore. In the online code editor, a forwarded port set to Public can be opened by anyone who has the link, so it should be Private unless it must be shared.\n\n" +
            "6. A home network checklist: use WPA3 or WPA2 on Wi-Fi with a long password, change the router's default administrator password, update the router firmware, and turn off features you do not use.",

            // APPLICATIONS
            "Network security protects school and company networks, online banking, hospitals, government systems and home Wi-Fi. Companies use firewalls and VPNs to let employees work remotely, and security teams monitor networks around the clock. Cloud providers and online shops depend on it to protect customer data and to keep their services running.",

            // ADVANTAGES
            "Good network security protects private data and the reputation of an organization, keeps services running, and helps meet legal rules about protecting personal information. Layered defense means that one failure does not necessarily lead to a breach, and early detection reduces the damage of an attack.",

            // LIMITATIONS
            "No network is completely secure, because new vulnerabilities and attack methods keep appearing, including zero-day flaws that have no fix yet. Security can make systems less convenient, and strict rules may block legitimate work. Encryption protects privacy but also hides attacks from inspection. Insiders and human mistakes, such as falling for phishing, can bypass technical defenses. Detection systems can raise false alarms. Good security costs money, time and trained staff, and it must be maintained continuously.",

            // RELATED TOPICS
            "Cybersecurity, Cryptography, Malware, Wireless Networks, DNS, Ethical Hacking.",

            // REFERENCES
            Arrays.asList(
                "Network security - Wikipedia: https://en.wikipedia.org/wiki/Network_security",
                "Guidelines on Firewalls and Firewall Policy (SP 800-41 Rev. 1) - NIST: https://csrc.nist.gov/pubs/sp/800/41/r1/final",
                "Cybersecurity Best Practices - CISA: https://www.cisa.gov/topics/cybersecurity-best-practices"
            )

        ));

                manager.addArticle(new Article(

            33,

            "Ethical Hacking",

            "Cybersecurity",

            "An explanation of ethical hacking: authorized, legal testing of systems to find security weaknesses before criminals do, covering permission and scope, the phases of a penetration test, white, gray and black box testing, bug bounty programs, a sample finding report, and the law in the Philippines.",

            // DEFINITION
            "Ethical hacking is the practice of testing a computer system, network or application for security weaknesses with the owner's written permission, in order to fix those weaknesses before criminals can use them. Ethical hackers use many of the same techniques as attackers, but they work legally, follow an agreed plan, keep what they find confidential, and report the problems so they can be repaired. Doing the same actions without permission is a crime. A penetration test, or pen test, is the most common form of ethical hacking.",

            // HISTORY
            "In the 1970s, the United States government used tiger teams, groups of experts who were asked to break into their own systems to find weaknesses. In 1995, Netscape ran one of the first bug bounty programs, which paid outsiders for reporting flaws in its browser. Google began a bug bounty program in 2010, and platforms such as HackerOne, started in 2012, now connect companies with researchers. The EC-Council launched the Certified Ethical Hacker (CEH) certification in 2003, and other certifications such as CompTIA PenTest+ and OSCP followed. In the Philippines, the Cybercrime Prevention Act of 2012 (Republic Act No. 10175) defines illegal access to a computer system as a crime, which is why permission is essential.",

            // CORE CONCEPTS
            "1. Authorization: Written permission from the system's owner before any test begins. Without it, the activity is illegal even if the intention is good.\n\n" +
            "2. Scope and rules of engagement: The agreed list of what may be tested, what may not, when, and by which methods. Testers must stay inside it.\n\n" +
            "3. Vulnerability: A weakness that could be used to harm a system, such as an unpatched program or a default password.\n\n" +
            "4. Exploit: A method or tool that takes advantage of a vulnerability.\n\n" +
            "5. CVE and CVSS: A CVE is a public ID for a known vulnerability, such as CVE-2021-44228. CVSS is a scoring system from 0.0 to 10.0 that rates how severe a vulnerability is.\n\n" +
            "6. OWASP Top 10: A widely used list of the most serious security risks for web applications, published by the Open Worldwide Application Security Project.\n\n" +
            "7. Responsible disclosure: Reporting a vulnerability privately to the owner and giving time to fix it before telling the public.\n\n" +
            "8. Confidentiality: Findings and any data seen during testing must be protected and shared only with the client.",

            // HOW IT WORKS
            "A penetration test follows a series of phases:\n\n" +
            "1. Planning and authorization: The client and tester agree on goals, scope, schedule and rules, and sign a contract and a permission document.\n\n" +
            "2. Reconnaissance: Collecting information about the target, such as public websites, domain records and technologies in use.\n\n" +
            "3. Scanning and enumeration: Finding which computers, open ports and services are present, and which versions of software they run.\n\n" +
            "4. Vulnerability analysis: Comparing what was found with lists of known vulnerabilities and misconfigurations.\n\n" +
            "5. Controlled exploitation: Carefully confirming that a weakness is real and measuring what it would allow, without causing damage.\n\n" +
            "6. Impact assessment: Judging how serious the problem is, for example whether it would expose customer data.\n\n" +
            "7. Reporting: Writing a clear report that describes each finding, its severity, the evidence, and how to fix it.\n\n" +
            "8. Remediation and retesting: The client repairs the problems, and the tester checks that the fixes work.",

            // TYPES
            "By how much the tester knows:\n\n" +
            "1. Black box testing: The tester gets no inside information, like an outside attacker.\n\n" +
            "2. Gray box testing: The tester has limited information, such as a normal user account.\n\n" +
            "3. White box testing: The tester has full information, such as source code and diagrams.\n\n" +
            "By target:\n\n" +
            "4. Network testing, web application testing, wireless testing, mobile app testing, cloud testing, and social engineering tests, which check whether people can be tricked, and physical security tests.\n\n" +
            "By hat color:\n\n" +
            "5. White hat: Works legally and with permission, which is the ethical hacker.\n\n" +
            "6. Black hat: Attacks for personal gain or to cause harm, which is illegal.\n\n" +
            "7. Gray hat: Tests systems without permission but without harmful intent, which is still illegal in most places.\n\n" +
            "Team roles: Red teams play attackers, blue teams defend, and purple teams make the two work together. Bug bounty hunters test public programs that invite them and pay for valid reports.",

            // EXAMPLES
            "1. A scope statement: The client allows testing of the school's web server at one named address between 8 PM and 12 AM on a stated weekend, and forbids denial of service tests and access to student records.\n\n" +
            "2. An entry from a report:\n" +
            "```\n" +
            "Finding:  Default administrator password on router\n" +
            "Severity: High\n" +
            "Evidence: The login page accepted the factory default credentials\n" +
            "Impact:   Someone on the network could change the router settings\n" +
            "Fix:      Set a strong unique password, update the firmware,\n" +
            "          and turn off remote administration\n" +
            "```\n\n" +
            "3. Checking your own computer. Nmap is a well-known network scanner. Run only against systems you own or have written permission to test. This command lists the open ports and service versions on your own machine:\n" +
            "```\n" +
            "nmap -sV localhost\n" +
            "```\n\n" +
            "4. Legal places to practice: TryHackMe and Hack The Box offer guided online labs, and OWASP Juice Shop and DVWA are intentionally vulnerable web applications that you can run on your own computer.\n\n" +
            "5. A bug bounty report: a researcher finds that a website shows another user's data when an ID in the address is changed, reports it privately through the company's program, and receives a reward after it is fixed.",

            // APPLICATIONS
            "Ethical hacking is used by banks, hospitals, schools, governments and online shops to test their systems before attackers do. Companies hire penetration testers or run bug bounty programs, and many security rules and standards require regular testing. It is also used to test new software and devices before release, and in training, where students practice in safe lab environments.",

            // ADVANTAGES
            "It finds real weaknesses before criminals do, which prevents data theft and costly outages. It shows which problems matter most, so limited money and time are spent on the highest risks. It checks whether defenses actually work, tests people as well as technology, and helps an organization meet legal and industry requirements.",

            // LIMITATIONS
            "A test shows the situation only at one point in time, and new vulnerabilities appear later. It is limited by its scope and time, so it cannot find everything. Testing can disrupt systems if it is done carelessly. It needs skilled people and can be costly. Most important, it is legal only with permission. Testing a system without authorization can lead to criminal charges, even if the tester means well.",

            // RELATED TOPICS
            "Network Security, Cybersecurity, Malware, Cryptography, Operating Systems.",

            // REFERENCES
            Arrays.asList(
                "OWASP Top Ten - OWASP Foundation: https://owasp.org/www-project-top-ten/",
                "Technical Guide to Information Security Testing and Assessment (SP 800-115) - NIST: https://csrc.nist.gov/pubs/sp/800/115/final",
                "Republic Act No. 10175, Cybercrime Prevention Act of 2012 - Official Gazette of the Philippines: https://www.officialgazette.gov.ph/2012/09/12/republic-act-no-10175/"
            )

        ));

                manager.addArticle(new Article(

            34,

            "Programming Languages Compared",

            "Programming",

            "A side-by-side comparison of popular programming languages (C, C++, Java, C#, Python, JavaScript, PHP, Kotlin, Swift and Rust) by how they run, how they check types, how they manage memory and what they are mainly used for, with Hello World examples and a guide to choosing one.",

            // DEFINITION
            "A programming language is a formal language used to write instructions that a computer can carry out. There are hundreds of them, and each is designed with different goals, such as speed, safety, simplicity or a specific kind of program. No language is best for everything, so programmers choose one by comparing how it runs, how it handles data types and memory, which libraries it has, and what kind of software they want to build.",

            // HISTORY
            "FORTRAN, created at IBM by John Backus's team in 1957, was one of the first widely used high-level languages, followed by LISP in 1958 and COBOL in 1959. Dennis Ritchie created C at Bell Labs around 1972. Bjarne Stroustrup began extending C with classes in 1979, and the language was named C++ in 1983. Guido van Rossum released Python in 1991. In 1995, three important languages appeared: Java from Sun Microsystems, led by James Gosling, JavaScript from Brendan Eich at Netscape, and PHP from Rasmus Lerdorf. Microsoft released C# in 2000, designed by a team led by Anders Hejlsberg. Go came from Google in 2009, Rust reached version 1.0 in 2015, Swift was introduced by Apple in 2014, and Kotlin 1.0 was released by JetBrains in 2016, with Google announcing official Kotlin support for Android in 2017.",

            // CORE CONCEPTS
            "1. Compiled language: The whole program is translated by a compiler into machine code before it runs. This usually gives fast programs. Examples: C, C++, Rust.\n\n" +
            "2. Interpreted language: A program called an interpreter reads and runs the code directly, line by line or in parts, with no separate build step. Example: Python.\n\n" +
            "3. Bytecode and virtual machine: The compiler translates the code to an intermediate form called bytecode, which a virtual machine runs. The same bytecode runs on any system that has the virtual machine. Examples: Java on the JVM and C# on .NET.\n\n" +
            "4. Just-in-time (JIT) compilation: The runtime compiles frequently used code to machine code while the program runs. JavaScript engines and the JVM do this.\n\n" +
            "5. Static typing: The type of each variable is checked before the program runs, so many mistakes are caught early. Examples: Java, C, C++, C#.\n\n" +
            "6. Dynamic typing: Types are checked while the program runs, which makes code shorter but moves some errors to run time. Examples: Python, JavaScript, PHP.\n\n" +
            "7. Memory management: In C and C++ the programmer allocates and frees memory manually, which is fast but error-prone. Java, C#, Python and JavaScript use a garbage collector that frees unused memory automatically. Rust uses ownership rules checked at compile time, and Swift uses automatic reference counting.\n\n" +
            "8. Paradigm: The style of programming a language supports. Procedural (C), object-oriented (Java, C#, C++), functional (parts of JavaScript, Kotlin and Rust) and scripting (Python, PHP).\n\n" +
            "9. Ecosystem: The libraries, frameworks, tools and community around a language, which often matter as much as the language itself.",

            // HOW IT WORKS
            "The same idea, source code to running program, happens in different ways:\n\n" +
            "1. C and C++: A compiler such as gcc turns the source files into a native executable for one type of computer. The executable runs directly on the processor.\n\n" +
            "2. Java: The compiler javac turns .java files into .class files containing bytecode, and the Java Virtual Machine (JVM) runs them. This is exactly what happens in this project when you run javac -d out *.java and then java -cp out org.example.SearchITWindow.\n\n" +
            "3. Python: The interpreter reads the .py file, converts it internally to bytecode, and runs it immediately, with no separate compile command.\n\n" +
            "4. JavaScript: The browser or Node.js engine reads the source, compiles frequently used parts to machine code while the program runs, and executes it.\n\n" +
            "5. PHP: The PHP engine on a web server runs the script for each request and sends the resulting HTML to the browser.",

            // TYPES
            "A comparison of widely used languages:\n" +
            "```\n" +
            "Language    Typing   Runs as                  Memory             Mainly used for\n" +
            "C           static   native machine code      manual             operating systems, embedded\n" +
            "C++         static   native machine code      manual             games, browsers, performance\n" +
            "Java        static   bytecode on the JVM      garbage collector  enterprise, desktop, Android\n" +
            "C#          static   bytecode on .NET         garbage collector  Windows apps, Unity games\n" +
            "Python      dynamic  interpreted              garbage collector  data science, AI, scripting\n" +
            "JavaScript  dynamic  JIT in browser or Node   garbage collector  websites and web apps\n" +
            "PHP         dynamic  interpreted on server    garbage collector  websites, WordPress\n" +
            "Kotlin      static   bytecode on the JVM      garbage collector  Android apps\n" +
            "Swift       static   native machine code      reference counting iPhone and Mac apps\n" +
            "Rust        static   native machine code      ownership rules    safe systems programming\n" +
            "```",

            // EXAMPLES
            "The classic first program, Hello World, in five languages:\n\n" +
            "1. Java:\n" +
            "```\n" +
            "public class Hello {\n" +
            "    public static void main(String[] args) {\n" +
            "        System.out.println(\"Hello, World!\");\n" +
            "    }\n" +
            "}\n" +
            "```\n\n" +
            "2. Python:\n" +
            "```\n" +
            "print(\"Hello, World!\")\n" +
            "```\n\n" +
            "3. JavaScript:\n" +
            "```\n" +
            "console.log('Hello, World!');\n" +
            "```\n\n" +
            "4. C:\n" +
            "```\n" +
            "#include <stdio.h>\n" +
            "int main(void) {\n" +
            "    printf(\"Hello, World!\\n\");\n" +
            "    return 0;\n" +
            "}\n" +
            "```\n\n" +
            "5. C++:\n" +
            "```\n" +
            "#include <iostream>\n" +
            "int main() {\n" +
            "    std::cout << \"Hello, World!\" << std::endl;\n" +
            "    return 0;\n" +
            "}\n" +
            "```\n\n" +
            "Notice how Python needs one line, while Java needs a class and a main method. Java and C require the types to be written, so mistakes are found before the program runs.\n\n" +
            "Choosing a language for a goal:\n" +
            "```\n" +
            "Goal                          Common choices\n" +
            "Interactive website           JavaScript (with HTML and CSS)\n" +
            "Server side of a website      JavaScript (Node.js), Python, PHP, Java, C#\n" +
            "Data analysis and AI          Python\n" +
            "Android app                   Kotlin or Java\n" +
            "iPhone app                    Swift\n" +
            "Games                         C++ or C# (Unity)\n" +
            "Operating system or driver    C, C++ or Rust\n" +
            "Large business system         Java or C#\n" +
            "Learning to program           Python or Java\n" +
            "```",

            // APPLICATIONS
            "Knowing the strengths of each language helps you choose the right tool for a project, read other people's code, and move to a new language more easily. Many real systems use several languages together. For example, a website may use JavaScript in the browser, Java or Python on the server and SQL in the database, as the Search IT project does with Java, JavaScript and HTML.",

            // ADVANTAGES
            "Learning more than one language makes the core ideas clearer, such as variables, loops, functions and objects, because they appear in almost every language. Static typing finds many errors early, dynamic typing makes short programs quick to write, and compiled languages are usually faster. Once you know one language well, a second one takes much less time to learn.",

            // LIMITATIONS
            "There is no single best language, and a comparison table simplifies a lot. Performance depends as much on how the code is written as on the language. Popularity changes over time, and rankings such as the TIOBE index and the Stack Overflow Developer Survey measure different things. Fast languages such as C and C++ give more control but make mistakes with memory easier, while easy languages such as Python are slower for heavy calculations. Choosing also depends on the team, the existing code and the available libraries.",

            // RELATED TOPICS
            "Introduction to Programming, Java Programming, Python Programming, JavaScript, Object-Oriented Programming.",

            // REFERENCES
            Arrays.asList(
                "Comparison of programming languages - Wikipedia: https://en.wikipedia.org/wiki/Comparison_of_programming_languages",
                "TIOBE Programming Community Index: https://www.tiobe.com/tiobe-index/",
                "Stack Overflow Developer Survey: https://survey.stackoverflow.co/"
            )

        ));

                 manager.addArticle(new Article(

            35,

            "C++",

            "Programming",

            "An introduction to C++, a fast compiled language that adds classes, templates and a large standard library to C, covering pointers and manual memory, smart pointers, the Standard Template Library, the build process, worked examples, and how C++ differs from Java.",

            // DEFINITION
            "C++ is a general-purpose, compiled programming language that supports several styles of programming: procedural, object-oriented and generic. It was created as an extension of C, so most C code also works in C++, and it adds features such as classes, templates and a large standard library. C++ gives the programmer direct control over memory and hardware, which makes it very fast, and it is used where performance matters, such as in games, browsers and system software.",

            // HISTORY
            "Bjarne Stroustrup began work on the language at Bell Labs in 1979 under the name C with Classes, because he wanted the speed of C together with the classes of Simula. It was renamed C++ in 1983, where the ++ refers to the increment operator of C, and the first commercial release came in 1985. C++ was first standardized by ISO in 1998 and has been updated several times: C++03, then a major modernization in C++11, followed by C++14, C++17, C++20 and C++23. C++11 added features such as auto, lambda expressions, smart pointers and range-based for loops, and C++20 added concepts, ranges, coroutines and modules.",

            // CORE CONCEPTS
            "1. Classes and objects: A class describes a kind of object with data and functions. C++ supports encapsulation, inheritance and polymorphism, including multiple inheritance, where a class has more than one parent.\n\n" +
            "2. Pointers and references: A pointer stores the memory address of a value, and a reference is another name for an existing value. They allow efficient access, but pointers must be handled carefully.\n\n" +
            "3. Manual memory management: Memory created with new must be released with delete. Forgetting to release it causes a memory leak, and using it after release is a serious bug.\n\n" +
            "4. RAII and smart pointers: Resource Acquisition Is Initialization ties a resource to the lifetime of an object, so it is released automatically. Smart pointers such as unique_ptr and shared_ptr use this to manage memory safely, and modern C++ prefers them over raw new and delete.\n\n" +
            "5. Templates: Code that works with any type, written once, such as a vector that can hold integers, text or students. This is called generic programming.\n\n" +
            "6. Standard Template Library (STL): Ready-made containers such as vector and map, algorithms such as sort and find, and iterators that connect them.\n\n" +
            "7. Header files and namespaces: Declarations are shared through header files with the #include command, and names such as cout and vector live in the namespace std.\n\n" +
            "8. Undefined behavior: Some mistakes, such as reading outside an array, have no defined result. The program may crash, give wrong answers, or appear to work, which makes bugs hard to find.",

            // HOW IT WORKS
            "1. You write the source code in a .cpp file, and shared declarations in .h or .hpp header files.\n\n" +
            "2. The preprocessor handles lines that start with #, such as #include, by inserting the contents of the header files.\n\n" +
            "3. The compiler translates each .cpp file into an object file of machine code.\n\n" +
            "4. The linker joins the object files and libraries into one executable file.\n\n" +
            "5. The operating system runs the executable directly on the processor, with no virtual machine. This is why C++ programs are fast.\n\n" +
            "Common compilers are GCC (g++), Clang and Microsoft Visual C++. A typical command with GCC is:\n" +
            "```\n" +
            "g++ -std=c++17 hello.cpp -o hello\n" +
            "./hello\n" +
            "```",

            // TYPES
            "C++ standards (each adds new features):\n\n" +
            "1. C++98 and C++03: The first ISO standard and a small fix.\n\n" +
            "2. C++11: Modern C++ begins, with auto, lambdas, smart pointers and move semantics.\n\n" +
            "3. C++14 and C++17: Smaller improvements, such as simpler generic code and filesystem support.\n\n" +
            "4. C++20 and C++23: Concepts, ranges, coroutines, modules and more library features.\n\n" +
            "Programming styles supported:\n\n" +
            "5. Procedural, object-oriented, generic (templates), and functional ideas such as lambdas.",

            // EXAMPLES
            "1. A program that uses a vector and a loop to find an average:\n" +
            "```\n" +
            "#include <iostream>\n" +
            "#include <vector>\n" +
            "int main() {\n" +
            "    std::vector<int> scores = {90, 85, 77};\n" +
            "    int total = 0;\n" +
            "    for (int s : scores) {\n" +
            "        total += s;\n" +
            "    }\n" +
            "    std::cout << \"Average: \" << total / scores.size() << std::endl;\n" +
            "    return 0;\n" +
            "}\n" +
            "```\n" +
            "The output is Average: 84. The total is 252, and the loop adds each score from the vector.\n\n" +
            "2. A class:\n" +
            "```\n" +
            "#include <iostream>\n" +
            "#include <string>\n" +
            "class Student {\n" +
            "public:\n" +
            "    std::string name;\n" +
            "    int grade;\n" +
            "    Student(std::string n, int g) : name(n), grade(g) {}\n" +
            "    void show() { std::cout << name << \": \" << grade << std::endl; }\n" +
            "};\n" +
            "```\n" +
            "Creating Student s(\"Ana\", 92); and calling s.show(); prints Ana: 92.\n\n" +
            "3. A pointer and a smart pointer:\n" +
            "```\n" +
            "int x = 10;\n" +
            "int* p = &x;\n" +
            "*p = 20;\n" +
            "auto q = std::make_unique<int>(5);\n" +
            "```\n" +
            "The pointer p holds the address of x, and *p = 20 changes x to 20. The smart pointer q owns an integer with the value 5, and frees it automatically when q goes out of scope. Smart pointers need the memory header.\n\n" +
            "4. C++ compared with Java, the language of this course:\n" +
            "```\n" +
            "Feature            C++                          Java\n" +
            "Runs as            native machine code          bytecode on the JVM\n" +
            "Memory             manual, or smart pointers    garbage collector\n" +
            "Pointers           yes                          no explicit pointers\n" +
            "Multiple parents   allowed for classes          only through interfaces\n" +
            "Portability        compile again for each OS    same bytecode runs anywhere\n" +
            "Speed              usually faster               slightly slower start and more memory\n" +
            "```",

            // APPLICATIONS
            "C++ is used for game engines such as Unreal Engine, for web browsers such as Chrome and Firefox, for databases such as MongoDB, and for much of the Adobe software and desktop applications. It is used in trading systems that must respond in microseconds, in embedded systems and robotics, in simulations, and in parts of operating systems and virtual reality software.",

            // ADVANTAGES
            "C++ programs are very fast and use memory efficiently, and the programmer can control exactly how hardware and memory are used. It supports several styles of programming and has a mature, standardized language with huge libraries. Code can be compiled for almost any platform, and it can work directly with existing C libraries.",

            // LIMITATIONS
            "C++ is large and complex, so it takes a long time to learn well. Manual memory handling makes errors such as leaks, dangling pointers and buffer overflows possible, and these are a common cause of security problems. Undefined behavior makes some bugs hard to find. Compile times can be long, error messages from templates are difficult to read, and programs must be compiled separately for each operating system. For these reasons, newer languages such as Rust and safer parts of modern C++ aim to reduce memory errors.",

            // RELATED TOPICS
            "Programming Languages Compared, Introduction to Programming, Java Programming, Object-Oriented Programming, Data Structures and Algorithms, Operating Systems.",

            // REFERENCES
            Arrays.asList(
                "Standard C++ Foundation: https://isocpp.org/",
                "C++ reference - cppreference.com: https://en.cppreference.com/",
                "Bjarne Stroustrup's homepage: https://www.stroustrup.com/"
            )

        ));

                manager.addArticle(new Article(

            36,

            "PHP",

            "Programming",

            "An introduction to PHP, the server-side scripting language behind many websites, covering how a PHP page is processed by the web server, variables and forms, connecting to a database safely with prepared statements, frameworks and WordPress, and common security mistakes.",

            // DEFINITION
            "PHP is a server-side scripting language designed for building websites and web applications. A PHP script runs on the web server, not in the visitor's browser. It can read form data, talk to a database, and create the HTML page that is sent back. The visitor only receives the finished HTML, never the PHP code. The name PHP is a recursive acronym that stands for PHP: Hypertext Preprocessor.",

            // HISTORY
            "Rasmus Lerdorf created the first version in 1994 as a set of tools for his personal home page, which is where the original name Personal Home Page came from, and released it publicly in 1995. In 1998, Zeev Suraski and Andi Gutmans rewrote the engine for PHP 3, and the language was renamed PHP: Hypertext Preprocessor. PHP 4 introduced the Zend Engine in 2000, and PHP 5 in 2004 greatly improved object-oriented programming. PHP 7, released in December 2015, made scripts much faster, and PHP 8, released in November 2020, added a just-in-time compiler, named arguments, union types and the match expression. New versions are released every year, in November. Popular PHP projects include WordPress, Wikipedia's MediaWiki software, and the Laravel framework, first released in 2011.",

            // CORE CONCEPTS
            "1. Server-side execution: The code runs on the web server and produces HTML, so the browser never sees the PHP source.\n\n" +
            "2. PHP tags: PHP code is placed between the tags that open with a less-than sign, a question mark and the letters php, and close with a question mark and a greater-than sign. Everything outside these tags is sent as plain HTML.\n\n" +
            "3. Variables: Names that start with a dollar sign, such as $name. PHP is dynamically typed, and newer versions allow optional type declarations.\n\n" +
            "4. Superglobals: Built-in arrays that are always available, such as $_GET for data in the address, $_POST for submitted form data, $_SESSION for data kept between pages, and $_COOKIE.\n\n" +
            "5. Sessions and cookies: Ways to remember a user between page requests, for example to keep someone logged in.\n\n" +
            "6. Database access: PHP connects to databases such as MySQL through PDO or MySQLi. Prepared statements keep user input separate from the SQL command.\n\n" +
            "7. Composer: PHP's package manager, which downloads and updates libraries for a project.\n\n" +
            "8. Shared-nothing request model: Each request starts a fresh run of the script, and nothing is kept in memory afterward unless it is stored in a session, a database or a cache.",

            // HOW IT WORKS
            "1. A visitor's browser requests a page such as search.php from the web server, for example Apache or Nginx.\n\n" +
            "2. The web server sees that the file is PHP and passes it to the PHP interpreter.\n\n" +
            "3. PHP runs the script from top to bottom. It may read form data, check a session, and query a database.\n\n" +
            "4. The output of the script, usually HTML, replaces the PHP code.\n\n" +
            "5. The web server sends the finished HTML to the browser, which displays it.\n\n" +
            "6. The script ends, and its memory is released. The next request starts again from the beginning.",

            // TYPES
            "Ways PHP is used:\n\n" +
            "1. Dynamic web pages: Scripts embedded in or generating HTML. This is the main use.\n\n" +
            "2. Content management systems (CMS): WordPress, Drupal and Joomla are written in PHP.\n\n" +
            "3. Web frameworks: Laravel and Symfony give structure for larger applications, including routing, database tools and security features.\n\n" +
            "4. Command-line scripts: PHP can run tasks from the terminal, such as scheduled jobs.\n\n" +
            "5. Web APIs: PHP programs can return JSON to mobile apps and JavaScript front ends.",

            // EXAMPLES
            "1. A page that mixes PHP with HTML:\n" +
            "```\n" +
            "<?php\n" +
            "$name = 'Ana';\n" +
            "echo '<h1>Hello, ' . $name . '!</h1>';\n" +
            "?>\n" +
            "```\n" +
            "The browser receives only the heading Hello, Ana!\n\n" +
            "2. Reading a search word from the address. Opening search.php?q=java shows the text You searched for: java:\n" +
            "```\n" +
            "<?php\n" +
            "$q = $_GET['q'] ?? '';\n" +
            "echo 'You searched for: ' . htmlspecialchars($q);\n" +
            "?>\n" +
            "```\n" +
            "The function htmlspecialchars converts special characters so that a visitor cannot inject a script into the page.\n\n" +
            "3. A safe database query with a prepared statement. The question mark is filled in by the database driver, so the input cannot change the SQL command:\n" +
            "```\n" +
            "$pdo = new PDO('mysql:host=localhost;dbname=school', 'user', 'pass');\n" +
            "$stmt = $pdo->prepare('SELECT name FROM students WHERE course = ?');\n" +
            "$stmt->execute(['BSIT']);\n" +
            "$rows = $stmt->fetchAll();\n" +
            "```\n\n" +
            "4. Trying PHP on your own computer with its built-in test server:\n" +
            "```\n" +
            "php -S localhost:8000\n" +
            "```\n" +
            "Then open http://localhost:8000 in the browser. This is for learning only and is not for a real website.\n\n" +
            "5. Compared with the Search IT project: the Java server answers a request to /api/search with JSON, and the same job in PHP would be a script that reads $_GET['q'], searches the data, and prints JSON.",

            // APPLICATIONS
            "PHP runs a large share of the websites on the internet, mostly because it powers WordPress, which is used for blogs, company sites and online shops. It is used for e-commerce platforms such as WooCommerce and Magento, for forums, for the MediaWiki software behind Wikipedia, and for custom business applications built with Laravel. Facebook was originally written in PHP, and Slack and Etsy also used it.",

            // ADVANTAGES
            "PHP is easy to start with, and almost every web hosting company supports it, often at low cost. It was built for the web, so common tasks such as handling forms, sessions and cookies are simple. It has good documentation, a very large community, and ready-made systems like WordPress. Since PHP 7, performance is much better, and modern PHP supports classes, types and tools such as Composer.",

            // LIMITATIONS
            "Older PHP code often has inconsistent function names and poor structure, and it is easy to write messy code. Careless code is open to serious security problems, such as SQL injection, cross-site scripting, and unsafe file uploads, so input must always be validated and database queries should use prepared statements. Because each request starts fresh, PHP is less natural for long-running or real-time applications, although tools exist for that. Many new projects choose other technologies such as Node.js, Python or Java.",

            // RELATED TOPICS
            "Programming Languages Compared, JavaScript, HTML and CSS, SQL Basics, REST APIs and JSON, Web Development.",

            // REFERENCES
            Arrays.asList(
                "PHP Manual - php.net: https://www.php.net/manual/en/",
                "History of PHP - php.net: https://www.php.net/manual/en/history.php.php",
                "PHP: The Right Way: https://phptherightway.com/"
            )

        ));

                manager.addArticle(new Article(

            37,

            "C# (C Sharp)",

            "Programming",

            "An introduction to C# (pronounced C sharp), Microsoft's object-oriented language that runs on the .NET platform, covering classes and properties, how code is compiled to intermediate language and run by the CLR, LINQ, async and await, a comparison with Java, and what it is used for, including Unity games.",

            // DEFINITION
            "C# (pronounced C sharp) is a modern, statically typed, object-oriented programming language created by Microsoft. C# programs run on .NET, a software platform that provides a runtime, a large class library and tools. The language is used to build desktop apps, websites and web services, cloud services, mobile apps and games. Its syntax is similar to Java and C++, so programmers who know one of them can learn it quickly.",

            // HISTORY
            "C# was designed at Microsoft by a team led by Anders Hejlsberg, who had earlier created Turbo Pascal and Delphi. It was announced in 2000 as part of Microsoft's .NET initiative, and the first version of the .NET Framework was released in 2002. C# was standardized by Ecma International (ECMA-334) in 2002 and by ISO in 2003. Important additions over the years include generics in C# 2.0 (2005), LINQ in C# 3.0 (2007), and async and await in C# 5.0 (2012). In 2016, Microsoft released .NET Core, an open-source version that runs on Windows, Linux and macOS, and in 2020 it was combined with the other .NET versions under the name .NET 5. A new version of .NET and C# is released every year in November.",

            // CORE CONCEPTS
            "1. .NET and the CLR: The Common Language Runtime (CLR) is the engine that runs C# programs, manages memory and handles errors. The .NET class library supplies ready-made code for files, networking, data and more.\n\n" +
            "2. Intermediate Language (IL): The C# compiler turns source code into IL, a form similar to Java bytecode. The CLR then compiles IL to machine code just in time while the program runs.\n\n" +
            "3. Classes and objects: C# is fully object-oriented, with encapsulation, inheritance and polymorphism. A class can inherit from only one class but can implement many interfaces.\n\n" +
            "4. Properties: A shorter way to write getters and setters. A property looks like a field but can run code when it is read or changed.\n\n" +
            "5. Value types and reference types: A struct is a value type that is copied when assigned, and a class is a reference type that is shared through a reference.\n\n" +
            "6. Generics: Code that works with any type, such as a list of integers or a list of students, while still being type-checked.\n\n" +
            "7. LINQ (Language Integrated Query): Query syntax built into the language for filtering, sorting and grouping collections, arrays, databases and XML.\n\n" +
            "8. Delegates, events and lambdas: Ways to pass methods around and react to events, such as a button click.\n\n" +
            "9. async and await: A simple way to write code that waits for slow work, such as a network request, without freezing the program.\n\n" +
            "10. Garbage collection and NuGet: Memory is freed automatically, and NuGet is the package manager for libraries.",

            // HOW IT WORKS
            "1. You write source code in .cs files, using an editor such as Visual Studio or Visual Studio Code.\n\n" +
            "2. The C# compiler checks the types and translates the code into IL, stored in an assembly, which is a .dll or .exe file.\n\n" +
            "3. When the program starts, the CLR loads the assembly.\n\n" +
            "4. The just-in-time compiler converts the IL into machine code for the current computer, and the program runs.\n\n" +
            "5. The garbage collector frees memory that is no longer used.\n\n" +
            "With the .NET command-line tool, the steps for a new console program are:\n" +
            "```\n" +
            "dotnet new console -o Hello\n" +
            "cd Hello\n" +
            "dotnet run\n" +
            "```",

            // TYPES
            "Kinds of programs built with C#:\n\n" +
            "1. Desktop apps: Windows Forms and WPF for Windows, and cross-platform interfaces such as .NET MAUI and Avalonia.\n\n" +
            "2. Web applications and APIs: ASP.NET Core, which runs on Windows, Linux and macOS.\n\n" +
            "3. Games: The Unity game engine uses C# as its scripting language.\n\n" +
            "4. Cloud and enterprise services: Widely used with Microsoft Azure.\n\n" +
            "5. Mobile apps: .NET MAUI and its predecessor Xamarin.\n\n" +
            "6. Console tools and background services.",

            // EXAMPLES
            "1. A complete program, using a feature called top-level statements:\n" +
            "```\n" +
            "Console.WriteLine(\"Hello, World!\");\n" +
            "```\n\n" +
            "2. A class with properties:\n" +
            "```\n" +
            "public class Student\n" +
            "{\n" +
            "    public string Name { get; set; }\n" +
            "    public int Grade { get; set; }\n" +
            "}\n" +
            "```\n" +
            "The properties replace the separate getName and setName methods that Java would need.\n\n" +
            "3. LINQ to filter a list:\n" +
            "```\n" +
            "var scores = new List<int> { 90, 85, 77 };\n" +
            "var high = scores.Where(s => s >= 80).ToList();\n" +
            "Console.WriteLine(high.Count);\n" +
            "```\n" +
            "The output is 2, because only 90 and 85 are at least 80.\n\n" +
            "4. C# compared with Java, the language of this course:\n" +
            "```\n" +
            "Feature            C#                              Java\n" +
            "Runs on            CLR (.NET)                      JVM\n" +
            "Compiled to        IL                              bytecode\n" +
            "Getters/setters    properties                      methods\n" +
            "Value types        struct                          primitives only\n" +
            "Query collections  LINQ                            streams\n" +
            "Owner              Microsoft                       Oracle\n" +
            "```\n" +
            "The two languages are very similar, so knowing Java makes C# easy to learn.",

            // APPLICATIONS
            "C# is used for Windows desktop software, web services built with ASP.NET Core, and business systems in banks and large companies. It is the main language for Unity, one of the most widely used game engines, which makes it popular for mobile and indie games. It is also used heavily on Microsoft Azure for cloud services.",

            // ADVANTAGES
            "C# is a clean, modern language with strong tooling, especially in Visual Studio. Static typing finds many mistakes before the program runs, and features such as properties, LINQ and async and await make code short and readable. With .NET, programs run on Windows, Linux and macOS, and a large library and a large community support it. Performance is good, and it is well suited to large projects.",

            // LIMITATIONS
            "The language is closely connected to Microsoft's ecosystem, and some tools and frameworks work best on Windows. The .NET platform is large, and its many versions and frameworks, such as the older .NET Framework and the newer .NET, can be confusing at first. Programs need the .NET runtime to run unless they are packaged together with it. Memory use is higher than in C or C++, and the garbage collector can cause short pauses. Fewer open-source libraries exist than for some other languages.",

            // RELATED TOPICS
            "Programming Languages Compared, Java Programming, Object-Oriented Programming, C++, Cloud Computing.",

            // REFERENCES
            Arrays.asList(
                "C# documentation - Microsoft Learn: https://learn.microsoft.com/en-us/dotnet/csharp/",
                ".NET - Microsoft: https://dotnet.microsoft.com/",
                "ECMA-334 C# Language Specification - Ecma International: https://ecma-international.org/publications-and-standards/standards/ecma-334/"
            )

        ));

    }
}