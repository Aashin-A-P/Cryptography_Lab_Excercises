public class CommonUtils{
    public static int powerMod(int base,int exp, int mod){
        base = base%mod;
        int res = 1;
        while(exp>0){
            if(base%2==1){
                res = (res*base)%mod;
            }
            base = (base*base)%mod;
            exp =exp/2;
        }
        return res;
    }
}