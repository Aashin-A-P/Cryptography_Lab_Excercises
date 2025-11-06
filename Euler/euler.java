import java.io.*;
import java.util.*;


public class euler{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a:");
        int a = sc.nextInt();
        System.out.println("Enter p:");
        int p = sc.nextInt();
        if (CommonUtils.gcd(a,p) != 1){
            System.out.println("Cant proceed");
            System.exit(0);
        }
        int phi = CommonUtils.phi(p);
        System.out.println("phi = "+phi);
        int modpow = CommonUtils.powerMod(a,phi,p);
        System.out.println("Mod pow"+modpow);
    }
}