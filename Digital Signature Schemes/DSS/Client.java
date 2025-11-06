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
        int q = Integer.parseInt(br.readLine());
        int e1 = Integer.parseInt(br.readLine());
        int e2 = Integer.parseInt(br.readLine());
        System.out.println("Public key: "+ e1 + "," + e2 + "," + p);
        while(true){
        int M = Integer.parseInt(br.readLine());

        int S1 = Integer.parseInt(br.readLine());
        System.out.println("S1:" + S1);

        int S2 = Integer.parseInt(br.readLine());
        System.out.println("S2:" +S2);
        int p1 = CommonUtils.modInverse(S2,q);
        int a = (p1*M)%q;
        int b = (p1*S1)%q;
        int V1 = ((CommonUtils.modPow(e1,a,p)*CommonUtils.modPow(e2,b,p))%p)%q;
        if(V1<0)
            V1+=(q);

        System.out.println(V1+ " " + S1);
        if(V1==S1)
            System.out.println("Signature Verified");
        else
            System.out.println("Not Verified");
        }
    }
}