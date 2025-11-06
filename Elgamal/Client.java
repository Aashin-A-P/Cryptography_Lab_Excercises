import java.io.*;
import java.net.*;
import java.util.*;

public class Client{
    public static void main(String args[]) throws IOException{
        Scanner sc = new Scanner(System.in);
        Socket s = new Socket("localhost",4444);

        PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

        int p = Integer.parseInt(br.readLine());
        int e1 = Integer.parseInt(br.readLine());
        int e2 = Integer.parseInt(br.readLine());
        System.out.println("Public key: " + e1 + "," + e2 + "," + p);
        System.out.println("Enter message:");
        String msg = sc.nextLine();
        int len = msg.length();
        pw.println(len);

        System.out.println("Enter random key r:");
        int r = sc.nextInt();

        for(int i = 0; i < len ; i++){
            int ch = (int)msg.charAt(i);
            int c1 = CommonUtils.modPow(e1,r,p);
            int c2 = (ch * CommonUtils.modPow(e2,r,p))%p;
            pw.println(c1);
            pw.println(c2);
        }
        
    }
}