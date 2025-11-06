public class CommonUtils{
    private static final int[] P10 = {3, 5, 2, 7, 4, 10, 1, 9, 8, 6};
    private static final int[] P8 = {6, 3, 7, 4, 8, 5, 10, 9};
    private static final int[] IP = {2, 6, 3, 1, 4, 8, 5, 7};
    private static final int[] IP_INV = {4, 1, 3, 5, 7, 2, 8, 6};
    private static final int[] EP = {4, 1, 2, 3, 2, 3, 4, 1};
    private static final int[] P4 = {2, 4, 3, 1};

    private static final int[][] S0 = {
        {1, 0, 3, 2},
        {3, 2, 1, 0},
        {0, 2, 1, 3},
        {3, 1, 3, 2}
    };

    private static final int[][] S1 = {
        {0, 1, 2, 3},
        {2, 0, 1, 3},
        {3, 0, 1, 0},
        {2, 1, 0, 3}
    };

    public static String[] SubKeyGeneration(String key10bit){
        int[] key = toIntArray(key10bit);
        printArray("Initial 10-bit Key", key);
        int[] pbox10 = permute(key,P10);
        printArray("Key after P-box 10 bit", pbox10);
        String pbox10string = ArraytoString(pbox10);
        System.out.println("P-Box String: " + pbox10string);
        int[] left = toIntArray(pbox10string.substring(0,5));
        printArray("LEFT 5 bits",left);
        int[] right = toIntArray(pbox10string.substring(5,10));
        printArray("Right 5 bits",right);
        left = LeftShift(left,1);
        printArray("LEFT 5 bits after LS-1",left);
        right = LeftShift(right,1);
        printArray("Right 5 bits after LS-1",right);
        int[] concat = concatenate(left,right);
        printArray("Concatenated 10 bits after LS-1:",concat);
        int[] compression = permute(concat,P8);
        printArray("Compressed with P8:", compression);
        String key1 = ArraytoString(compression);
        System.out.println("Key1: "+ key1);
        left = LeftShift(left,2);
        printArray("LEFT 5 bits after LS-2",left);
        right = LeftShift(right,2);
        printArray("Right 5 bits after LS-2",right);
        concat = concatenate(left,right);
        printArray("Concatenated 10 bits after LS-2:",concat);
        compression = permute(concat,P8);
        printArray("Compressed with P8:", compression);
        String key2 = ArraytoString(compression);
        System.out.println("Key2: "+ key2);
        return new String[] {key1,key2};
    }

    public static String SDES(String PlainText, String key1, String key2){
        int[] PT = toIntArray(PlainText);
        printArray("PlainText", PT);
        int[] IP_PT = permute(PT,IP);
        printArray("After Initial Permutation",IP_PT);
        String IP_String = ArraytoString(IP_PT);
        System.out.println("After IP String: "+ IP_String);
        int[] left = toIntArray(IP_String.substring(0,4));
        printArray("Left 4 bits",left);
        int[] right = toIntArray(IP_String.substring(4,8));
        printArray("Right 4 bits",right);
        int[] function_output = SDES_Function(right,key1);
        printArray("DES Round Function Output", function_output);
        int[] final_xor = xor(left,function_output);
        printArray("First Round Output Left", final_xor);
        int[] round2_start = concatenate(final_xor,right);
        printArray("Round 2 starts with LR as", round2_start);
        left = right;
        right = final_xor;
        printArray("After swap", concatenate(left,right));
        function_output = SDES_Function(right,key2);
        printArray("DES Round Function Output", function_output);
        final_xor = xor(left,function_output);
        printArray("First Round Output Left", final_xor);
        round2_start = concatenate(final_xor,right);
        printArray("Round 2 ends with", round2_start);
        int[] final_permute = permute(round2_start, IP_INV);
        printArray("After IP Inverse", final_permute);
        String CT = ArraytoString(final_permute);
        return CT;
    }

    public static int[] SDES_Function(int[] input, String key){
        int[] right = permute(input,EP);
        printArray("After EP", right);
        int[] key1 = toIntArray(key);
        printArray("Key", key1);
        int[] xorkey = xor(key1, right);
        printArray("After XOR with Key:", xorkey);
        String XOR = ArraytoString(xorkey);
        System.out.println("XOR String: "+XOR);
        int[] l1 = toIntArray(XOR.substring(0,4));
        printArray("Left 4 bits",l1);
        int[] r1 = toIntArray(XOR.substring(4,8));
        printArray("Right 4 bits",r1);
        int[] sboxoutput = SBOX(l1,r1);
        printArray("After SBOX 4 bits",sboxoutput);
        int[] p4 = permute(sboxoutput,P4);
        printArray("After P4" , p4);
        return p4;
    }

    public static int[] SBOX(int[] a,int[] b){
        String row1 = ArraytoString(new int[]{a[0],a[3]});
        String col1 = ArraytoString(new int[]{a[1],a[2]});
        int i1 = calc(row1);
        int j1 = calc(col1);
        String leftSBOX = SBOX_Function(S0, i1, j1);
        String row2 = ArraytoString(new int[]{b[0],b[3]});
        String col2 = ArraytoString(new int[]{b[1],b[2]});
        int i2 = calc(row2);
        int j2 = calc(col2);
        String rightSBOX = SBOX_Function(S1, i2, j2);
        int[] left = toIntArray(leftSBOX);
        int[] right = toIntArray(rightSBOX);
        int[] res = concatenate(left,right);
        return res;
    }

    public static int calc(String a){
        if(a.equals("00"))
            return 0;
        if(a.equals("01"))
            return 1;
        if(a.equals("10"))
            return 2;
        if(a.equals("11"))
            return 3;
        return 0;
    }

    public static String SBOX_Function(int[][] S, int i, int j){
        int a = S[i][j];
        if(a==0){
            return "00";
        }
        else if(a==1){
            return "01";
        }
        else if(a==2){
            return "10";
        }
        else{
            return "11";
        }
    }

    public static int[] xor(int[] a, int[] b){
        int[] res = new int[a.length];
        for(int i =0 ;i < a.length;i++){
            res[i] = a[i]^b[i];
        }
        return res;
    }

    public static int[] concatenate(int[] a,int[] b){
        int[] result = new int[a.length+b.length];
        for(int i = 0; i < a.length;i++){
            result[i] = a[i];
        }
        for(int i=a.length;i<a.length+b.length;i++){
            result[i] = b[i-a.length];
        }
        return result;
    }
    public static int[] toIntArray(String key){
        int[] result = new int[key.length()];
        for(int i=0;i<key.length();i++){
            result[i] = key.charAt(i) - '0';
        }
        return result;
    }

    public static int[] permute(int[] key, int[] pbox){
        int[] result = new int[pbox.length];
        for(int i=0;i<pbox.length;i++){
            result[i] = key[pbox[i]-1];
        }
        return result;
    }

    public static void printArray(String title, int[] a){
        System.out.print(title + ": ");
        for(int i=0;i<a.length;i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static String ArraytoString(int[] a){
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<a.length;i++){
            sb.append(a[i]);
        }
        return sb.toString();
    }

    public static int[] LeftShift(int[] a, int shift){
        int[] result = new int[a.length];
        for(int i = 0; i < a.length;i++){
            result[i] = a[(i+shift)%a.length];
        }
        return result;
    }

    public static void main(String args[]){
        String[] keys = SubKeyGeneration("1010110101");
        String key1 = keys[0];
        String key2 = keys[1];
        System.out.println(key1 + " " + key2);
        SDES("10110011",key1,key2);
    }
}