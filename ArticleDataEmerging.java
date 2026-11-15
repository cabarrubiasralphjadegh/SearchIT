package org.example;

import java.util.Arrays;

public class ArticleDataEmerging {

    public static void load(ArticleManager manager) {

        manager.addArticle(new Article(

            8,

            "Introduction to Emerging Technologies",

            "Emerging Technologies",

            "An introduction to emerging technologies, including what makes a technology emerging, major examples such as artificial intelligence, the Internet of Things, cloud computing, and blockchain, how they work, their uses, and their risks.",

            // DEFINITION
            "Emerging technologies are new or fast-developing technologies whose uses and effects are still growing. They are often expected to change how people work, communicate, and solve problems, but they may not yet be widely adopted, fully understood, or regulated. A technology stops being called emerging once it becomes common and stable.",

            // HISTORY
            "The idea of artificial intelligence was formally introduced at the Dartmouth workshop in 1956. Cloud computing grew in the mid-2000s when companies began offering computing power and storage over the Internet. The term Internet of Things became popular around 1999. In 2008, a person or group using the name Satoshi Nakamoto described Bitcoin, the first widely used blockchain system. Since the 2010s, advances in computing power and the availability of large amounts of data have made machine learning practical for many everyday uses.",

            // CORE CONCEPTS
            "1. Artificial Intelligence (AI): Computer systems that perform tasks that normally need human intelligence, such as recognizing speech or images and making predictions.\n\n" +
            "2. Machine Learning: A part of AI in which a system learns patterns from data instead of being given every rule by a programmer.\n\n" +
            "3. Internet of Things (IoT): Everyday objects with sensors and network connections that collect and share data, such as smart thermostats and fitness trackers.\n\n" +
            "4. Cloud Computing: Using servers on the Internet to store data and run programs, instead of relying only on your own computer.\n\n" +
            "5. Blockchain: A shared record of transactions stored in linked blocks across many computers, which makes past entries very hard to change.\n\n" +
            "6. Big Data: Very large and varied sets of data that are analyzed to find patterns.\n\n" +
            "7. Virtual and Augmented Reality: Technologies that place a user inside a computer-made world (VR) or add digital objects to the real world (AR).",

            // HOW IT WORKS
            "Many emerging technologies depend on the same ingredients: data, computing power, and connectivity. For example, a machine learning system is first given many examples, such as thousands of labeled photos. It adjusts itself to find patterns in them, which is called training. After training, it can make predictions about new data it has not seen before. An IoT device works differently: a sensor measures something such as temperature, sends the reading over a network to a cloud service, and the service stores it or triggers an action, such as turning on a fan.",

            // TYPES AND CLASSIFICATIONS
            "Commonly discussed emerging technologies include:\n\n" +
            "1. Artificial Intelligence and Machine Learning: Chatbots, image recognition, and recommendation systems.\n\n" +
            "2. Internet of Things: Smart homes, connected vehicles, and smart farming.\n\n" +
            "3. Cloud and Edge Computing: Cloud computing uses distant data centers, while edge computing processes data closer to where it is created.\n\n" +
            "4. Blockchain: Cryptocurrencies and tamper-resistant record keeping.\n\n" +
            "5. Robotics and Automation: Machines that perform physical tasks.\n\n" +
            "6. Extended Reality: Virtual reality, augmented reality, and mixed reality.\n\n" +
            "7. Quantum Computing: Computers that use quantum physics. They are still in an early stage, and they are expected to help with certain specialized problems.",

            // PRACTICAL EXAMPLES
            "Example: A smart home thermostat.\n\n" +
            "1. A temperature sensor measures the room (IoT).\n" +
            "2. The thermostat sends the readings over Wi-Fi to a cloud service (cloud computing).\n" +
            "3. The service studies past readings and your schedule to learn when you are usually home (machine learning).\n" +
            "4. It adjusts the temperature before you arrive and shows the results in a phone app.\n\n" +
            "This single product combines three emerging technologies working together.",

            // APPLICATIONS
            "1. Healthcare: Analyzing medical images and monitoring patients remotely.\n\n" +
            "2. Education: Personalized learning and virtual classrooms.\n\n" +
            "3. Agriculture: Sensors that track soil moisture and crop conditions.\n\n" +
            "4. Transportation: Driver-assistance systems and route planning.\n\n" +
            "5. Finance: Fraud detection and digital payments.\n\n" +
            "6. Manufacturing: Robots and equipment monitoring.",

            // ADVANTAGES
            "Emerging technologies can automate repetitive work, help people make better decisions by analyzing large amounts of data, create new products and services, and make services available to more people. They can also improve safety and efficiency in areas such as healthcare, farming, and transportation.",

            // LIMITATIONS
            "Emerging technologies can be costly, and their results are not always reliable. AI systems can reflect biases found in their training data. Connected devices and large data collections raise privacy and security concerns. Some jobs may change or disappear, and laws and standards often develop more slowly than the technology itself. Their long-term effects are also not yet fully known.",

            // RELATED TOPICS
            "Artificial Intelligence, Machine Learning, Internet of Things, Cloud Computing, Blockchain, Robotics, Virtual Reality, Quantum Computing, Cybersecurity, Data Privacy.",

            // REFERENCES
            Arrays.asList(
                "Emerging technologies - Wikipedia: https://en.wikipedia.org/wiki/Emerging_technologies",
                "Artificial intelligence - Wikipedia: https://en.wikipedia.org/wiki/Artificial_intelligence",
                "Internet of things - Wikipedia: https://en.wikipedia.org/wiki/Internet_of_things"
            )

        ));

    }
}