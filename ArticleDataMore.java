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

    }
}