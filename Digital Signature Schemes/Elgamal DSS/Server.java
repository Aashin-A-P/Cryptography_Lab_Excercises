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
        int d = 29;
        System.out.println("Select e1:");
        int e1 = sc.nextInt();
        int e2 = CommonUtils.modPow(e1,d,p);
        pw.println(p);
        pw.println(e1);
        pw.println(e2);

        System.out.println("Private key: "+d);
        while(true){
        System.out.println("Enter no to encrypt:");
        int M = sc.nextInt();

        pw.println(M);

        
        System.out.println("Enter r:");
        int r = sc.nextInt();
        int S1 = CommonUtils.modPow(e1,r,p);
        pw.println(S1);

        int S2 = ((M - (d*S1)%(p-1)) * CommonUtils.modInverse(r,p-1)%(p-1))%(p-1);
        if(S2<0){
            S2+= (p-1);
        }

        pw.println(S2);
        System.out.println(S1 + " " + S2);
        }
    }
}