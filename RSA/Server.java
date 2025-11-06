import java.io.*;
import java.net.*;
import java.util.*;

public class Server{
    public static void main(String args[]) throws IOException{
        Scanner sc = new Scanner(System.in);
        ServerSocket ss = new ServerSocket(4444);
        System.out.println("Server is running at Port 4444...");
        Socket s = ss.accept();
        System.out.println("Client Connected to Server...");

        PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

        int p =  23, q = 29;
        int n = p * q;
        pw.println(n);
        int phi = (p-1) * (q-1);
        System.out.println("phi: "+phi);
        System.out.print("Enter e:");
        int e = sc.nextInt();
        if(CommonUtils.iscoprime(e,phi)){
            pw.println(e);
            int d = CommonUtils.inverse(e,phi);
            if (d == -1){
                System.out.println("Cannot proceed further.");
                ss.close();
            }
            System.out.println("d: " + d);
            while(0<1){
            int len = Integer.parseInt(br.readLine());
            StringBuilder C = new StringBuilder();
            StringBuilder P = new StringBuilder();
            for(int i = 0; i < len;i++){
                String c = br.readLine();
                int cr = Integer.parseInt(c);
                C.append(c);
                int pr = CommonUtils.modPow(cr,d,n);
                P.append((char)pr);
                pw.println(pr);
            }
            System.out.println("Encrypted:"+C);
            System.out.println("Decrypted:"+P);
            }
        }
        else{
            System.out.println("e is not coprime with phi");
        }
        ss.close();
    }
}