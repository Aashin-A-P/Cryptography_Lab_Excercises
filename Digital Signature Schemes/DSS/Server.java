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
        int q = 83;
        int d = 81;
        System.out.println("Select e1:");
        int e1 = 108;
        int e2 = CommonUtils.modPow(e1,d,p);
        pw.println(p);
        pw.println(q);
        pw.println(e1);
        pw.println(e2);

        System.out.println("Private key: "+d);
        while(true){
        System.out.println("Enter no to encrypt:");
        int M = sc.nextInt();

        pw.println(M);

        
        System.out.println("Enter r:");
        int r = sc.nextInt();
        int S1 = CommonUtils.modPow(e1,r,p)%q;
        pw.println(S1);

        int S2 = ((M + (d*S1)%(q)) * CommonUtils.modInverse(r,q)%(q))%(q);
        if(S2<0){
            S2+= (q);
        }

        pw.println(S2);
        System.out.println(S1 + " " + S2);
        }
    }
}