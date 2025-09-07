import java.util.*;

public class GCD{
    public static int gcd (int a, int b){
        if (b==0){
            return a;
        }
        return gcd (b, a%b);
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter No 1: ");
        int a = sc.nextInt();
        System.out.print("Enter No 2: ");
        int b = sc.nextInt();

        sc.nextLine();

        int res = gcd(a,b);

        System.out.println("GCD of " + a + " and " + b + " is " + res);
    }
}