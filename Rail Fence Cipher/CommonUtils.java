public class CommonUtils{

    public static String railfence_encrypt(String plainText, int key){
        
    }

    public static String railfence_decrypt(String cipherText, int key){
        int n = cipherText.length();
        char[][] rail = new char[key][n];
        for(int i = 0; i < key; i++){
            for(int j = 0; j < n; j++){
                rail[i][j] = '\n';
            }
        }

        int row = 0;
        int col = 0;
        boolean dir_down = true;

        for(int i = 0; i < n; i++){
            if (row == 0){
                dir_down = true;
            }
            if (row == key-1){
                dir_down = false;
            }
            rail[row][col++] = '*';
            row += dir_down ? 1 : -1;
        }

        int index = 0;

        for(int i = 0 ; i < key; i++){
            for(int j = 0; j < n; j++){
                if(rail[i][j] == '*' && index < n){
                    rail[i][j] = cipherText.charAt(index++);
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        row = 0; col = 0;

        for(int i = 0; i < n; i++){
            if (row == 0)
                dir_down = true;
            if (row == key-1)
                dir_down = false;
            
            if (rail[row][col] != '\n')
                sb.append(rail[row][col++]);
            
            row += dir_down ? 1:-1;
        }
        return sb.toString();
    }
}