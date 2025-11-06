public class CommonUtils{
    public static int gcd(int a,int b){
        if (b==0){
            return a;
        }
        return gcd(b,a%b);
    }
    public static int phi(int n){
        int result = n;
        for(int i = 2; i*i <= n;i++){
            if(n%i==0){
                while(n%i==0){
                    n = n/i;
                }
                result = result - result/i;
            }
        }
        if (n>1){
            result = result - result/n;
        }
        return result;
    }
    public static int powerMod(int base, int exp, int mod){
        base = base%mod;
        int res = 1;
        while(exp>0){
            if(base%2==0){
                res = (res*base)%mod;
            }
            base = (base*base)%mod;
            exp = exp/2;
        }
        return res;
    }
}