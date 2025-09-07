import java.util.*;

public class PrimeNo{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number: ");
        int a = sc.nextInt();

        int c = 0;

        for(int i=1;i<=a;i++){
            if (a%i == 0){
                c++;
            }
        }

        if (c==2){
            System.out.println(a+ " is prime");
        }
        else{
            System.out.println(a+ " is not prime");
        }
    }
}