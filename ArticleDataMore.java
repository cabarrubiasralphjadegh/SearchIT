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

    }
}