import java.io.*;
import java.net.*;
import java.util.*;

public class Server{
    public static void main(String args[]) throws IOException{
        Scanner sc= new Scanner(System.in);
        Socket s = new Socket("localhost",4444);
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String[] keys = CommonUtils.SubKeyGeneration("1010110101");
        String key1 = keys[0];
        String key2 = keys[1];
        System.out.println(key1 + " " + key2);
        String CT = br.readLine();
        String PT = CommonUtils.SDES(CT, key2,key1);
        System.out.println("Encrypted Text:" + CT);
        System.out.println("Decrypted text:" + PT);
    }
}