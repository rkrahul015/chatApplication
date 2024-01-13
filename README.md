# Chat-Application Using JAVA
Requirements:
    JAVA Basics(OOPs)
    Reading and Writing
    Networking(Socket Programming)
    for GUI - Java Swing
    Multi-threading

Info :
    ServerSocket for Server and Socket for Client
    use IP address to connect to server to client and vice versa


### Working Explanation:

1. **Server Side:**
   - The server creates a `ServerSocket` and listens on port 7777.
   - When a client connects, the server accepts the connection and establishes input and output streams for communication.
   - Two threads are started for reading and writing, allowing simultaneous communication with the client.
   - The server continuously reads messages from the client and prints them. If the client sends "exit," the server terminates the chat.
   - The server also continuously takes input from the user and sends it to the client. If the server types "exit," it closes the socket and terminates the chat.

2. **Client Side:**
   - The client attempts to connect to the server at "localhost" on port 7777.
   - After successfully connecting, input and output streams are established for communication.
   - Two threads are started for reading and writing, allowing simultaneous communication with the server.
   - The client continuously reads messages from the server and prints them. If the server sends "exit," the client terminates the chat.
   - The client also continuously takes input from the user and sends it to the server. If the client types "exit," it closes the socket and terminates the chat.


# Simple Java Socket Chat Application

This is a simple console-based chat application implemented in Java using sockets. It consists of a server and a client allowing basic text communication.

## Technologies Used:

- Java
- Sockets

## Usage:

1. Compile the Server.java file:
   ```bash
   javac Server.java
   ```

2. Compile the Client.java file:
   ```bash
   javac Client.java
   ```

3. Run the Server:
   ```bash
   java Server
   ```

4. Run the Client (in a separate terminal or command prompt):
   ```bash
   java Client
   ```

5. Follow the instructions in the console to send and receive messages.

## Additional Notes:

- Type "exit" to terminate the chat.

## Author:

Rahul Kumar

