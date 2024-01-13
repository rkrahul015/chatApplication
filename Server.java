import java.net.*;
import java.io.*;
public class Server {

    ServerSocket server;
    Socket socket;

    BufferedReader br;
    PrintWriter out;
    //Constructor
    public Server() {
        try{
            server = new ServerSocket(7777); //7777 is port number
            System.out.println("the server is ready to accept connection");
            System.out.println("waitng...");
            socket = server.accept();

            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream());

            startReading();
            startWriting();
        }
        catch (Exception e) {
            System.out.println("Connection is Closed");
            System.exit(0);
        }
    }

    public void startReading() {
        // make a thread to continuiusly read data
        Runnable r1 = ()-> {
            System.out.println("reader started...");
            try {
                while (!socket.isClosed()) {

                    String data = br.readLine();
                    if (data.equals("exit")) {
                        System.out.println("Client terminated the chat");
                        break;
                    }
                    System.out.println("Client: " + data);
                }
                System.out.println("Connection is Closed");
            }
             catch (IOException e) {
                 System.exit(0);
                }
            };
        new Thread(r1).start();

    }

    public void startWriting() {
        // make a thread to continuiusly take data from user and sent it to user
        Runnable r2 = ()-> {
            System.out.println("writer started...");
            try {
                while (!socket.isClosed()) {
                    BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
                    String content = br1.readLine();
                    out.println(content);
                    out.flush();
                    if (content.equals("exit")) {
                        socket.close();
                        break;
                    }
                }
            }
            catch (IOException e) {
                System.exit(0);
            }

        };
        new Thread(r2).start();

    }
    public static void main(String[] args) {
        System.out.println("this is Server... going ti start server");
        new Server();
    }

}
