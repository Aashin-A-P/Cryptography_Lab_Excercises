public class CommonUtils{
    public static int modPow(int base, int pow, int mod){
        int res = 1;
        for(int i = 0; i<pow; i++){
            res = (res * base) % mod;
        }
        return res;
    }
}