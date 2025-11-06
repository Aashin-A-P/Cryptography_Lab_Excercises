public class CommonUtils{
    public static int modInverse(int a, int mod){
        for(int i=0;i<mod;i++){
            if((a*i)%mod==1){
                return i;
            }
        }
        return -1;
    }
}