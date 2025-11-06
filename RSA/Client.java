import java.io.*;
import java.net.*;
import java.util.*;

public class Client{
    public static void main(String args[]) throws IOException{
        Scanner sc = new Scanner(System.in);
        Socket s = new Socket("localhost",4444);
        System.out.println("Client Connected...");

        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter pw = new PrintWriter(s.getOutputStream(),true);

        int n =  Integer.parseInt(br.readLine());
        System.out.println("n: "+n);

        int e = Integer.parseInt(br.readLine());
        System.out.println("e: "+e);
        while(1>0){

        System.out.print("Enter P:");
        String P = sc.nextLine();

        pw.println(P.length());

        for(int i = 0; i < P.length();i++){
            int ascii = (int) P.charAt(i);
            int c = CommonUtils.modPow(ascii,e,n);
            pw.println(c);
        }
        StringBuilder C = new StringBuilder();

        for(int i = 0; i < P.length();i++){
            int p = Integer.parseInt(br.readLine());
            char ch = (char) p ;
            C.append(ch);
        }
        
        System.out.println("Decrypted: " + C);
        }

    }
}