import java.util.*;
import java.net.*;
import java.io.*;

public class crt{
    public static void main(String args[]) throws IOException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of congruencies:");
        int n = sc.nextInt();
        System.out.println("Enter congruencies as a mod m");
        int[] a = new int[n];
        int[] m = new int[n];
        int M = 1;
        for(int i = 0;i < n; i++){
            a[i] = sc.nextInt();
            m[i] = sc.nextInt();
            M = M*m[i];
        }
        int[] Mn = new int[n];
        int[] Mi = new int[n];
        int res = 0 ;
        for(int i = 0;i < n; i++){
            Mn[i] = M/m[i];
            Mi[i] = CommonUtils.modInverse(Mn[i],m[i]);
            res+= (a[i]*Mn[i]*Mi[i]);
        }
        System.out.println("Result:"+res%M);
    }
}