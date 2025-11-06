import java.util.*;

public class fermat{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a:");
        int a = sc.nextInt();
        System.out.println("Enter p:");
        int p = sc.nextInt();
        int res = CommonUtils.powerMod(a,p-1,p);
        System.out.println(a +" ^ "+(p-1)+" mod "+p+" = "+res);
    }
}