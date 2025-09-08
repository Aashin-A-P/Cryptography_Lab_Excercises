import java.io.*;
import java.util.*;

public class CaesarCipherAttack{

    public static String caesar_decrypt(String cipherText, int key){
        StringBuilder sb = new StringBuilder();
        int n = cipherText.length();
        for(int i = 0; i < n; i++){
            char curr = cipherText.charAt(i);
            int shift = (curr - 'a' - key + 26) % 26;
            sb.append((char)('a'+shift));
        }
        return sb.toString();
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Cipher text: ");
        String cipherText = sc.nextLine();

        for(int i = 0; i < 26; i++){
            String plainText = caesar_decrypt(cipherText, i);
            System.out.println("Decrypted with key:" + i + " is " + plainText);
        }
    }
}