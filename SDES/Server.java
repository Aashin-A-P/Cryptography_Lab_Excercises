import java.io.*;
import java.net.*;
import java.util.*;

public class Server{
    public static void main(String args[]) throws IOException{
        Scanner sc= new Scanner(System.in);
        ServerSocket ss = new ServerSocket(4444);
        Socket s = ss.accept();
        PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
        String[] keys = CommonUtils.SubKeyGeneration("1010110101");
        String key1 = keys[0];
        String key2 = keys[1];
        System.out.println(key1 + " " + key2);
        System.out.println("Enter message to be encrypted:");
        String PT = sc.nextLine();
        String CT = CommonUtils.SDES(PT,key1,key2);
        System.out.println("Plain Text:" + PT);
        System.out.println("Cipher text:" +CT);
        pw.println(CT);
    }
}