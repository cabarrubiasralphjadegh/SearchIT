package org.example;

import java.util.Arrays;

public class ArticleDataNetworking {

    public static void load(ArticleManager manager) {

        manager.addArticle(new Article(

            11,

            "OSI and TCP/IP Models",

            "Networking",

            "An introduction to the OSI model and the TCP/IP model, including their layers, what each layer does, how data is wrapped as it travels, and how the two models compare.",

            // DEFINITION
            "The OSI (Open Systems Interconnection) model and the TCP/IP model are layered frameworks that describe how data moves from one computer to another over a network. Each layer has a specific job and communicates only with the layers directly above and below it. Dividing network communication into layers makes it easier to design, understand, and troubleshoot.",

            // HISTORY
            "The OSI model was developed by the International Organization for Standardization (ISO) and published in 1984 as a reference model. The TCP/IP protocols came from research funded by the United States Department of Defense, and ARPANET switched to TCP/IP on January 1, 1983. TCP/IP became the basis of the Internet, while the OSI model remained mainly a teaching and reference tool.",

            // CORE CONCEPTS
            "1. Layer: A group of related network functions that provides services to the layer above it.\n\n" +
            "2. Protocol: A set of rules used at a layer, such as HTTP, TCP, or IP.\n\n" +
            "3. Encapsulation: Each layer adds its own header, and sometimes a trailer, to the data as it moves down the layers at the sender.\n\n" +
            "4. Decapsulation: At the receiver, each layer removes its own header as the data moves up the layers.\n\n" +
            "5. Packet: A small unit of data that is sent across a network.\n\n" +
            "6. Port Number: A number that identifies which program on a computer should receive the data.\n\n" +
            "7. Reference Model: A model that explains concepts, as opposed to a protocol that a computer runs directly.",

            // HOW IT WORKS
            "When you send a message, it starts at the top layer and moves down. At each layer, headers with addressing and control information are added. At the bottom, the data is turned into signals that travel over cables or radio waves. The receiving computer reverses the process: it turns the signals back into data and moves it up through the layers, removing a header at each step, until the message reaches the receiving program. Routers only need to look at the lower layers to forward the data to its destination.",

            // TYPES AND CLASSIFICATIONS
            "The OSI model has seven layers, from top to bottom:\n\n" +
            "7. Application: Network services used by programs, such as HTTP and DNS.\n\n" +
            "6. Presentation: Data format, encryption, and compression.\n\n" +
            "5. Session: Starting, managing, and ending connections between programs.\n\n" +
            "4. Transport: Delivery between programs, using TCP for reliable delivery or UDP for fast delivery without guarantees.\n\n" +
            "3. Network: Addressing and routing between networks, using IP.\n\n" +
            "2. Data Link: Delivery between devices on the same network, using MAC addresses and technologies such as Ethernet and Wi-Fi.\n\n" +
            "1. Physical: The actual signals, cables, and hardware.\n\n" +
            "The TCP/IP model has four layers:\n\n" +
            "4. Application: Combines the OSI application, presentation, and session layers.\n\n" +
            "3. Transport: TCP and UDP.\n\n" +
            "2. Internet: IP addressing and routing.\n\n" +
            "1. Network Access (Link): Combines the OSI data link and physical layers.",

            // PRACTICAL EXAMPLES
            "Example: Opening a web page.\n\n" +
            "1. Application layer: Your browser creates an HTTP request for the page.\n" +
            "2. Transport layer: TCP breaks the request into segments and adds a port number, usually 443 for secure websites.\n" +
            "3. Internet layer: IP adds the source and destination IP addresses.\n" +
            "4. Network access layer: Ethernet or Wi-Fi adds the hardware addresses and sends the signals.\n\n" +
            "The web server then reverses these steps to read your request and sends the page back the same way.\n\n" +
            "A practical use of the layers is troubleshooting: if a website will not open but you can reach other websites, the problem is probably at a higher layer, while a loose cable points to the physical layer.",

            // APPLICATIONS
            "1. Teaching: The OSI model is widely used to explain how networks work.\n\n" +
            "2. Troubleshooting: Network technicians check one layer at a time to find a fault.\n\n" +
            "3. Protocol Design: Engineers design protocols to fit into a layer.\n\n" +
            "4. Network Equipment: Devices are described by the layer they work at, such as a switch at layer 2 and a router at layer 3.\n\n" +
            "5. Security: Firewalls and other tools are placed at specific layers.",

            // ADVANTAGES
            "Layering breaks a complex system into smaller parts. A change in one layer, such as a new type of cable, does not require changes to the other layers. It also lets products from different manufacturers work together and gives technicians a clear way to describe and locate problems.",

            // LIMITATIONS
            "The OSI model is a reference model, and real networks mainly use TCP/IP, so the OSI layers do not match actual protocols exactly. The session and presentation layers are not clearly separate in the TCP/IP model. Layers also add some overhead, because each one adds its own header to the data.",

            // RELATED TOPICS
            "IP Addressing, TCP and UDP, DNS, Routers and Switches, Ethernet, Network Security, Computer Networks, Internet.",

            // REFERENCES
            Arrays.asList(
                "OSI model - Wikipedia: https://en.wikipedia.org/wiki/OSI_model",
                "Internet protocol suite - Wikipedia: https://en.wikipedia.org/wiki/Internet_protocol_suite",
                "RFC 1122 - Requirements for Internet Hosts: https://www.rfc-editor.org/rfc/rfc1122"
            )

        ));

        manager.addArticle(new Article(

            12,

            "IP Addressing",

            "Networking",

            "An introduction to IP addresses, including IPv4 and IPv6, public and private addresses, subnet masks, how addresses are assigned, and a worked example.",

            // DEFINITION
            "An IP (Internet Protocol) address is a number that identifies a device on a network and shows where to send data for it. Every device that communicates using the Internet Protocol needs an IP address, much like a house needs an address for mail to arrive. IP addresses are used at the network layer to route data between networks.",

            // HISTORY
            "IPv4 was defined in 1981 in RFC 791 and became the main addressing system of the Internet. As the Internet grew, the supply of IPv4 addresses ran low, and the central pool of unassigned IPv4 addresses was used up in 2011. IPv6, with a much larger address space, was developed in the 1990s to solve this problem, and its use has been growing since then.",

            // CORE CONCEPTS
            "1. IPv4 Address: A 32-bit number written as four decimal numbers from 0 to 255 separated by dots, such as 192.168.1.10. It allows about 4.3 billion addresses.\n\n" +
            "2. IPv6 Address: A 128-bit number written as eight groups of hexadecimal digits separated by colons, such as 2001:db8::1. It allows a vastly larger number of addresses.\n\n" +
            "3. Network Part and Host Part: Each address has a part that identifies the network and a part that identifies the device in that network.\n\n" +
            "4. Subnet Mask: A number that shows which part of an IPv4 address is the network part, for example 255.255.255.0.\n\n" +
            "5. Default Gateway: The router that a device sends data to when the destination is outside its own network.\n\n" +
            "6. DHCP: A service that automatically gives IP addresses to devices.\n\n" +
            "7. NAT (Network Address Translation): A method that lets many devices on a private network share one public IP address.",

            // HOW IT WORKS
            "When a device wants to send data, it compares the destination address with its own network using the subnet mask. If the destination is in the same network, the data is sent directly. If not, the data goes to the default gateway, which forwards it toward the destination through other routers. Addresses can be assigned manually, which is called static, or automatically by a DHCP server, which is called dynamic. Most home devices receive dynamic addresses from the router.",

            // TYPES AND CLASSIFICATIONS
            "IP addresses are grouped in several ways:\n\n" +
            "1. IPv4 and IPv6: The two versions of the protocol.\n\n" +
            "2. Public Addresses: Unique addresses used on the Internet and given by an Internet service provider.\n\n" +
            "3. Private Addresses: Addresses for use inside a home, school, or office network. The IPv4 private ranges are 10.0.0.0 to 10.255.255.255, 172.16.0.0 to 172.31.255.255, and 192.168.0.0 to 192.168.255.255.\n\n" +
            "4. Static and Dynamic Addresses: Fixed addresses and automatically assigned addresses.\n\n" +
            "5. Special Addresses: 127.0.0.1 is the loopback address, which always refers to the device itself.",

            // PRACTICAL EXAMPLES
            "Example: A device with the address 192.168.1.10 and the subnet mask 255.255.255.0.\n\n" +
            "1. The mask 255.255.255.0 means the first three numbers are the network part.\n" +
            "2. The network is 192.168.1.0, and the device is host number 10 in it.\n" +
            "3. Addresses from 192.168.1.1 to 192.168.1.254 can be given to devices, which is 254 usable addresses.\n" +
            "4. 192.168.1.255 is the broadcast address, which reaches every device in the network.\n" +
            "5. A device with the address 192.168.1.25 is in the same network, so data goes directly. A device with the address 8.8.8.8 is outside it, so the data goes to the default gateway.\n\n" +
            "Another common use is the loopback address: when you run a web server on your own computer, you can open it at 127.0.0.1, which is the same as localhost.",

            // APPLICATIONS
            "1. Internet Access: Every connected device needs an address to send and receive data.\n\n" +
            "2. Network Planning: Schools and offices divide their addresses into subnets for different departments.\n\n" +
            "3. Troubleshooting: Technicians check IP settings with tools such as ping and ipconfig.\n\n" +
            "4. Web Hosting: Servers are reached through public IP addresses, which DNS connects to website names.\n\n" +
            "5. Security: Firewalls can allow or block traffic by IP address.",

            // ADVANTAGES
            "A common addressing system lets different kinds of devices and networks exchange data. Dividing addresses into networks makes routing efficient, and private addresses with NAT let many devices share a few public addresses. IPv6 gives enough addresses for the growing number of connected devices.",

            // LIMITATIONS
            "IPv4 has a limited number of addresses, which is why NAT is widely used. IPv4 and IPv6 are not directly compatible, so networks often run both. Addresses are hard to remember, so people use DNS names instead, and incorrect address settings can stop a device from connecting.",

            // RELATED TOPICS
            "DNS, DHCP, Subnetting, NAT, OSI and TCP/IP Models, Routers and Switches, MAC Addresses, Network Security.",

            // REFERENCES
            Arrays.asList(
                "IP address - Wikipedia: https://en.wikipedia.org/wiki/IP_address",
                "RFC 791 - Internet Protocol: https://www.rfc-editor.org/rfc/rfc791",
                "RFC 8200 - Internet Protocol, Version 6 (IPv6) Specification: https://www.rfc-editor.org/rfc/rfc8200"
            )

        ));

    }
}