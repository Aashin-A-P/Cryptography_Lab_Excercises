public class CommonUtils{
    public static int gcd (int a, int b){
        if (b==0){
            return a;
        }
        return gcd(b,a%b);
    }

    public static boolean iscoprime(int a,int b){
        return (gcd(a,b) == 1);
    }

    public static int inverse(int a, int phi){
        for (int i = 0; i <= phi; i++){
            if ((a*i)%phi == 1){
                return i;
            }
        }
        return -1;
    }

    public static int modPow(int base, int exp, int mod){
        int res = 1;
        for (int i = 0; i< exp; i++){
            res = (res*base)%mod;
        }
        return res;
    }
}