import java.io.*;
import java.net.*;
import java.util.*;

public class Client{
    public static void main(String args[]) throws IOException{
        Scanner sc = new Scanner(System.in);
        Socket s = new Socket("localhost",4444);
        System.out.println("Client Connected....");

        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter pw = new PrintWriter(s.getOutputStream(),true);

        int p = 23, g = 2;
        System.out.print("Enter y: ");
        int y = sc.nextInt();

        int r2 = CommonUtils.modPow(g,y,p);
        pw.println(r2);

        int r1 = Integer.parseInt(br.readLine());
        System.out.println("Received R1: " + r1);
        int key = CommonUtils.modPow(r1,y,p);

        System.out.println("Shared Key: " + key);

        s.close();
    }
}