public class CommonUtils{
    public static int modPow(int base, int exp, int mod){
        int res = 1;
        for(int i = 0;i<exp;i++){
            res = (res*base)%mod;
        }
        return res;
    }
    public static int modInverse(int a, int mod){
        for(int i = 0 ;i < mod; i++){
            if((a*i)%mod == 1){
                return i;
            }
        }
        return -1;
    }
}