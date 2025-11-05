import java.io.*;
import java.net.*;
import java.util.*;

public class Server{
    public static void main(String args[]) throws IOException{
        Scanner sc = new Scanner(System.in);
        ServerSocket ss = new ServerSocket(4444);
        System.out.println("Server is running at port 4444....");
        Socket s = ss.accept();
        System.out.println("Client Connected....");

        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter pw = new PrintWriter(s.getOutputStream(),true);

        int p = 23, g = 2;
        System.out.print("Enter x: ");
        int x = sc.nextInt();

        int r1 = CommonUtils.modPow(g,x,p);
        pw.println(r1);

        int r2 = Integer.parseInt(br.readLine());
        System.out.println("Received R2: " + r2);
        int key = CommonUtils.modPow(r2,x,p);

        System.out.println("Shared Key: " + key);

        ss.close();
    }
}