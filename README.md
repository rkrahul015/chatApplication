 # Java Socket Chat Application

This is a foundational Java socket chat application that enables communication between a server and multiple clients for basic text-based chat functionalities.

## Overview

The application implements a simple chat system using Java and sockets, allowing threaded communication between a server and clients. The server utilizes a `ServerSocket` and listens on port 7777, while the client attempts to connect to the server at "localhost" on the same port. Upon successful connection, input and output streams are established for communication, and two threads are initiated for reading from and writing to the server, enabling simultaneous communication.

## Features

- **Server Side:**
   - Initialization and connection handling.
   - Thread management for concurrent communication.
   - Message handling with termination control.

- **Client Side:**
   - Connection establishment and setup for input/output streams.
   - Thread management for concurrent communication.
   - Message handling with termination control.

## Usage

1. **Server Setup:**
   - Compile the `Server.java` file:
     ```bash
     javac Server.java
     ```
   - Run the server:
     ```bash
     java Server
     ```

2. **Client Setup:**
   - Compile the `Client.java` file:
     ```bash
     javac Client.java
     ```
   - Run the client:
     ```bash
     java Client
     ```

3. **Communication:**
   - Follow the instructions in the console to send and receive messages. Type "exit" to terminate the chat.

## Technologies Used

- Java
- Sockets

## Additional Notes

- This application serves as a foundational understanding of Java socket programming and chat systems.

## Author

Rahul Kumar

Feel free to contribute and enhance this basic chat application for learning and development purposes.  
