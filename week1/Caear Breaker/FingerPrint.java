
import edu.duke.*;
import java.io.*;

public class FingerPrint {
   public void textFingerPrint(String s){
       
    String alpha = "abcdefghijklmnopqrstuvwyz";
    int[] counters = new int [26];
    
    for(int k=0; k< s.length() ;k++){
        char ch =s.charAt(k);
        int index = alpha.indexOf(Character.toLowerCase(ch));
        if(index != -1){
            counters[index] +=1;
        }
    }
    
    for(int k=0; k< counters.length ; k++){
        System.out.println(alpha.charAt(k) + "\t" + counters[k]);
    }
}
}
