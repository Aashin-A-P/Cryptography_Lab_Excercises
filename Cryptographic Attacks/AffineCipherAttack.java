import java.io.*;
import java.util.*;

public class AffineCipherAttack{
    public static void main(String args[]){
        String pt = "abcd";
        String ct = "filo";
        int[] inv = {1,3,5,7,9,11,15,17,19,21,23,25};
        for(int i : inv){
            for(int j = 1 ; j < 26; j++){
                boolean abc = true;
                for(int k = 0; k < pt.length(); k++){
                    int curr = pt.charAt(k) - 'a';
                    int currc = ct.charAt(k) - 'a';
                    if (((curr*i)+j)%26 != currc){
                        abc = false;
                    }
                }
                if (abc){
                    System.out.println(i+ " "+j);
                    return;
                }
            }
        }
    }
}