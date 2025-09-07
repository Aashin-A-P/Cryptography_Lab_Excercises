import java.util.*;

public class Multiplicative_Inverse{
    public static int multiplicative_inverse(int num, int mod){
        for(int i = 1; i <= mod; i++){
            if((num*i) % mod == 1){
                return i;
            }
        }
        return -1;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter num: ");
        int a = sc.nextInt();
        System.out.print("Enter mod: ");
        int b = sc.nextInt();

        sc.nextLine();

        int res = multiplicative_inverse(a,b);

        System.out.println("Multiplicative inverse of " + a + " mod " + b + " is " + res);

    }
}