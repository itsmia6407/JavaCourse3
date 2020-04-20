import edu.duke.*;
import java.io.*;

public class CaesarCipherTwo {
    private String alphabet;
    private String shiftedAlphabet1;
    private String shiftedAlphabet2;
    private int mainKey1;
    private int mainKey2;
    public CaesarCipherTwo(int key1, int key2) {
       mainKey1 = key1;
       mainKey2 = key2;
       alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
       shiftedAlphabet1 = alphabet.substring(key1)+
       alphabet.substring(0,key1);
       shiftedAlphabet2 = alphabet.substring(key2)+
       alphabet.substring(0,key2);
       } 
       
    public String encrypt(String input){
       StringBuilder encrypted = new StringBuilder(input);
       //Count from 0 to < length of encrypted, (call it i)
        for(int i = 0; i < encrypted.length(); i++) {
            //Look at the ith character of encrypted (call it currChar)
            char currChar = encrypted.charAt(i);
            boolean a = Character.isLowerCase(currChar);
            if (a) {
                currChar = Character.toUpperCase(currChar);
            }
            //Find the index of currChar in the alphabet (call it idx)
            int idx = alphabet.indexOf(currChar);
            //If currChar is in the alphabet
            if(idx != -1){
                //Get the idxth character of shiftedAlphabet (newChar)
                char newChar;
                if (i % 2 == 0)
                    newChar = shiftedAlphabet1.charAt(idx);
                else
                    newChar = shiftedAlphabet2.charAt(idx);
                //Replace the ith character of encrypted with newChar
                if (a) {
                    newChar = Character.toLowerCase(newChar);
                }
                encrypted.setCharAt(i, newChar);
            }
        }            
        //Your answer is the String inside of encrypted
        return encrypted.toString();
       }
    
    public String decrypt(String input) {
            CaesarCipherTwo e = new CaesarCipherTwo(26-mainKey1, 26-mainKey2);
            String a = e.encrypt(input);    
            System.out.println(input);
            System.out.println(a);
            return a;
        }  
        public String halfOfString(String message, int start) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < message.length(); i+=2) 
             sb.append(message.charAt(i));
             return sb.toString();
    }
    
  public int[] countLetters( String message){
       String alph = "abcdefghijklmnopqrstuvwxyz";
       int [] counts = new int [26];
       for(int k=0; k <message.length(); k ++){
         char ch = Character.toLowerCase(message.charAt(k));
         int dex = alph.indexOf(ch);
         if(dex != -1){
             counts[dex] +=1;
            }
           
        }
        return counts;
    }
    
  public int maxIndex(int [] values) {
        int maxvalue = 0;
        int positionoflargestelement = 0;
        for (int i = 0; i < values.length; i++) {
            if (maxvalue == 0) maxvalue = values[i];
            else {
                if (maxvalue < values[i]) {
                    maxvalue = values[i];
                    positionoflargestelement = i;
                }
            }
        }
        return positionoflargestelement;
    }
    
    public void simpleTests (){
    FileResource resource = new FileResource();
        String s = resource.asString();
        CaesarCipherTwo c = new CaesarCipherTwo(17, 3);
        String a = c.encrypt(s);
        System.out.println(a);
        String b = c.decrypt(a);
        System.out.println(b);
        String x = breakCaesarCipherTwo(a);
        System.out.println(x);
    }
    
      public String breakCaesarCipherTwo(String input) {
        String half1 = halfOfString(input, 0);
        String half2 = halfOfString(input, 1);
        int key1 = getKey(half1);
        int key2 = getKey(half2);
        CaesarCipherTwo cc = new CaesarCipherTwo(26-key1, 26-key2);
 
        System.out.println("key1 is " + key1 + " key2 is " + key2);
        String a = cc.encrypt(input);
        System.out.println(input);
        System.out.println(a);
        return a;  
    }
        public int getKey(String s) {
        int[] counts = countLetters(s);
        int indOfMax = maxIndex(counts);
        int key = indOfMax - 4;
        if (key<0) return key+26;
        else return key;
    }
}