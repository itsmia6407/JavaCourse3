 


import edu.duke.*;
import java.io.*;

public class CaesarCipherOO {

    private String alphabet;
    private String shiftedAlphabet;
    private int mainKey;
    public CaesarCipherOO(int key){
    alphabet = "ABCDEFGHIJKLMNOQRSTUVWXYZ";
    shiftedAlphabet = alphabet.toLowerCase().substring(key) +
                       alphabet.substring(0,key);
    mainKey = key;                    
                    }
                    
    public String encrypt (String input){
        StringBuilder sb = new StringBuilder(input);
        String alphaLower = alphabet.toLowerCase();
        String shiftLower = shiftedAlphabet.toLowerCase();
        for(int i =0; i<sb.length();i++){
            char c = sb.charAt(i);
            int idx = alphabet.indexOf(c);
            int idxLower = alphaLower.indexOf(c);
            if(Character.isLowerCase(c)){
                if(idxLower != -1){
                c = shiftLower.charAt(idxLower);
                sb.setCharAt(i,c);
            }
        }
        else {
            if(idx != -1){
                c = shiftedAlphabet.charAt(idx);
                sb.setCharAt(i,c);
            }
        }
    }
        return sb.toString();
    }
     
    public String decrypt(String input){
       int k = 26- mainKey;
       
       CaesarCipherOO cc = new CaesarCipherOO(k);
       
       String message = cc.encrypt(input);
       
       return message;
    }
    
        
     public int[] countLetters( String message){
       String alph = "abcdefghijklmnoqrstuvwxyz";
       
       int [] counts = new int [26];
       for(int k=0; k <message.length(); k ++){
         char ch = message.charAt(k);
         char lch = Character.toLowerCase(ch);
        
         int dex = alph.indexOf(lch);
         if(dex != -1){
             counts[dex] +=1;
            }
           
        }
        return counts;
    }
    
    public int maxIndex(int[] freqs){
     int max = 0;
     for(int k=0; k<freqs.length; k++){
         if(freqs[k] > freqs[max]){
             max = k;
            }
    } return max;
   }
      
   public void simpleTests (){  
      FileResource fr = new FileResource();
      String s = fr.asString();
      CaesarCipherOO cc= new CaesarCipherOO(18);
      String encryptStr = cc.encrypt(s);
      System.out.println(encryptStr);
      String decryptStr = cc.decrypt(encryptStr);
      System.out.println(decryptStr);
    }
    
     public String breakCaesarCipher (String input) {
        int key = getKey(input);
        CaesarCipherOO c = new CaesarCipherOO(key);
        return c.decrypt(input);
    }
    
    public int getKey(String s) {
        int[] counts = countLetters(s);
        int indOfMax = maxIndex(counts);
        int key = indOfMax - 4;
        if (key<0) return key+26;
        else return key;
    }
}
