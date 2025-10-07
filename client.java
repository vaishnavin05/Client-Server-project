import java.net.*;
import java.io.*;
import java.util.Scanner;

public class client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5000);
            System.out.println("Connected to server");

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter first number: ");
            String a = sc.nextLine();
            System.out.print("Enter second number: ");
            String b = sc.nextLine();

            out.println(a);
            out.println(b);

            System.out.println("Server response: " + in.readLine());

            sc.close();
            socket.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
