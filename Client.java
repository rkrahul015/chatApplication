import java.net.*;
import java.io.*;
public class Client {
    Socket socket;

    BufferedReader br;
    PrintWriter out;

    public Client() {
        try{
            System.out.println("Sending request to server");
            socket = new Socket("localhost", 7777);
            System.out.println("connected to server");
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream());

            startReading();
            startWriting();
        }
        catch (Exception e) {
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
                        System.out.println("Server terminated the chat");
                        break;
                    }
                    System.out.println("Server: " + data);
                }
            }
            catch (IOException e) {
                System.out.println("Connection is Closed");
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
                System.out.println("Connection is Closed");
            }
            catch (IOException e) {
                System.exit(0);
            }
        };
        new Thread(r2).start();

    }
    public static void main(String[] args) {
        System.out.println("This is client...");
        new Client();
    }
}
