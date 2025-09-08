import java.util.*;

public class ExtendedEuclidean{

    public static int euclidean(int r1, int r2, int t1, int t2, int s1, int s2){
        int q = r1/r2;
        int r = r1%r2;
        int t = t1-q*t2;
        int s = s1 - q*s2;
        System.out.println(q+"\t"+r1+"\t"+r2+"\t"+r+"\t"+t1+"\t"+t2+"\t"+t+"\t"+s1+"\t"+s2+"\t"+s);
        if (r == 0){
            return t2;
        }
        return euclidean(r2,r,t2,t,s2,s);
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter r1: ");
        int r1 = sc.nextInt();

        System.out.print("Enter r2: ");
        int r2 = sc.nextInt();

        System.out.println("q\tr1\tr2\tr\tt1\tt2\tt\ts1\ts2\ts");

        int mul_inv = euclidean(r1,r2,0,1,1,0);
        if (mul_inv < 0){
            mul_inv+= r1;
        }
        System.out.println("Ans:" + mul_inv);
    }
}