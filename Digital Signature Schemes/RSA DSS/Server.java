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

        int p = 23, q = 29;
        int n = p*q;
        int phi = (p-1)*(q-1);

        pw.println(n);

        System.out.println("Enter e:");
        int e = sc.nextInt();

        pw.println(e);

        int d = CommonUtils.modInverse(e,phi);

        System.out.println("Private key: " + d);
        sc.nextLine();
        while(true){
        System.out.println("Enter msg:");
        String msg = sc.nextLine();
        int len = msg.length();
        pw.println(len);
        StringBuilder S = new StringBuilder();
        for(int i = 0 ; i < msg.length(); i++){
            int ch = (int)msg.charAt(i);
            int s1 = CommonUtils.modPow(ch,d,n);
            pw.println(s1);
            S.append(s1);
        }
        System.out.println("Sign: "+S);
        pw.println(msg);
        }
    }
}