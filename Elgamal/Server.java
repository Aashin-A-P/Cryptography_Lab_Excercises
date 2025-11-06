import java.io.*;
import java.net.*;
import java.util.*;

public class Server{ 
    public static void main(String args[]) throws IOException{
        Scanner sc = new Scanner(System.in);
        ServerSocket ss = new ServerSocket(4444);
        Socket s = ss.accept();

        PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

        int p = 997;

        pw.println(p);

        int e1 = 5;
        pw.println(e1);

        System.out.println("Enter private key d:");
        int d = sc.nextInt();

        int e2 = CommonUtils.modPow(e1,d,p);
        pw.println(e2);

        System.out.println("Private key: " + d);
        
        int len = Integer.parseInt(br.readLine());
        StringBuilder C1 = new StringBuilder();
        StringBuilder C2 = new StringBuilder();
        StringBuilder P = new StringBuilder();
        for(int i = 0 ; i < len; i++){
            int c1 = Integer.parseInt(br.readLine());
            int c2 = Integer.parseInt(br.readLine());
            C1.append(c1);
            C2.append(c2);
            int inv = CommonUtils.modInverse(CommonUtils.modPow(c1,d,p),p);
            int p1 = (c2*inv)%p;
            System.out.println(p1); 
            System.out.println((char)p1);
            P.append((char)p1);
        }

        System.out.println("C1:" + C1);
        System.out.println("C2:" + C2);
        System.out.println("P:" + P);
        

    }
}