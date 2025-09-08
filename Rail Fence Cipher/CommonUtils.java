public class CommonUtils{

    public static String railfence_encrypt(String plainText, int key){
        int n = plainText.length();
        char[][] rail = new char[key][n];
        for(int i = 0; i < key; i++){
            for(int j = 0; j < n; j++){
                rail[i][j] = '\n';
            }
        }

        int row = 0, col = 0;
        boolean dir_down = false;

        for(int i = 0; i < n; i++){
            if (row == 0 || row == key-1){
                dir_down = !dir_down;
            }
            rail[row][col++] = plainText.charAt(i);
            row += dir_down ? 1 : -1;
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < key ;i++){
            for(int j = 0 ; j < n; j++){
                if(rail[i][j]!='\n'){
                    sb.append(rail[i][j]);
                }
            }
        }
        return sb.toString();
    }

    public static String railfence_decrypt(String cipherText, int key){
        
    }
}