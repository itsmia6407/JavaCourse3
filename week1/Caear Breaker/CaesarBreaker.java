
import edu.duke.*;
import java.io.*;


public class CaesarBreaker {

    public String decrypt (String encrypted){
    CaesarCipher cc = new CaesarCipher();
    
    int [] freqs = countLetters(encrypted);
   
    int maxDex = maxIndex(freqs);
    //maxDex is the key !
     System.out.println(maxDex);
    //assume this is E, use index 4 -> E, can change if the maxIndex is O or sth
    //change the number, which u think occurr most : a,e,o !, their index is key
    //to decrypt
    int key = getKey(encrypted);
    //int dkey = maxDex-0;
    //if(maxDex<0){
    //    dkey = 26 -(0-maxDex);
    //}
     System.out.println("The key is:" +key);
        String decrypted = cc.encrypt(encrypted, 26-key);
     return decrypted;   
        
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
    
    public int maxIndex(int[] freqs){
     int max = 0;
     for(int k=0; k<freqs.length; k++){
         if(freqs[k] > freqs[max]){
             max = k;
            }
    } return max;
}

public void testDecrypt (){
   
    System.out.println(decrypt("KJWJWJ"));;
    
}

public String halfOfString(String message, int start){
 String newString = null;
 int k;
 for(k = start; k< message.length() ; k+=2){
     char ch = message.charAt(k);
     newString = Character.toString(ch);
     //System.out.print(newString);
    
}return newString;
}

public void testHalfOfString(){
   halfOfString("Qbkm Zgis",0); 
    halfOfString("Qbkm Zgis",1); 
}

public int getKey( String s){
    
 int [] freqs = countLetters(s);
 int maxDex = maxIndex(freqs);
 System.out.println("max Index " + maxDex);
 int dkey = maxDex -14;
 //which is the location of the encrypted letter ‘e’,
 if(maxDex <14){
     dkey = 26-(14-maxDex);
    }
 //System.out.println("key is "+ dkey);
 return dkey;
}

public void testGetKey(){
 getKey("KJWJWJ");   
    
}

public String decryptTwoKeys (String encrypted){
   CaesarCipher cc = new CaesarCipher();
  // StringBuilder stringBen = new StringBuilder(encrypted);
   //String decrypted = cc.encryptTwoKeys();
   
   String half1 = halfOfString(encrypted,0);
   String half2 = halfOfString(encrypted,1);
   
   //int[] freq1 = countLetters(half1);
   //int[] freq2 = countLetters(half2);
   
  // int maxDex1 = maxIndex(freq1);
  // int maxDex2 = maxIndex(freq2);
   
   int dkey1 =getKey(half1);
   int dkey2 = getKey(half2);
 
  // System.out.println("key1 is " + dkey1);
  // System.out.println("key2 is " + dkey2);
    
  /* String decrypted = null;
   for(int i = 0; i < 6 ; i++){
       for(int j =0 ; j < 26 ; j ++){
    decrypted = cc.encryptTwoKeys(encrypted,26- i, 26- j) ;
   System.out.println("i = " + i + " j = " + j + " " + decrypted);}
} */
    
   String decrypted = cc.encryptTwoKeys(encrypted,26-14,26-24); 
    System.out.println(decrypted);
    
   /*int[] freqs = countLetters(encrypted);
   int maxDex = maxIndex(freqs);
   
   
       
   int key1 = getKey(half1);
   int key2 = getKey(half2);
   System.out.println("key to encrypt 1 is "+ key1);
   System.out.println("key to encrypt 2 is "+ key2);
   
   int[] freqs = countLetters(encrypted);
   int maxDex = maxIndex(freqs);
   //assume it is E = 4
   int dkey1 = maxDex - 0;
   if(maxDex <0){
       dkey1 = 26-(0-maxDex);
    }
   System.out.println("key to decrypt 1 is "+ dkey1);
   int dkey2 = maxDex - 0;
   if(maxDex <0){
       dkey2 = 26-(0-maxDex);
    } 
   System.out.println("key to decrypt 2 is "+ dkey2); 
   
   
   
   System.out.println(decrypted);
   */

return decrypted;
}
public void testDecryptTwoKeys(){
    //decryptTwoKeys("Gwpv c vbuq pvokki yfve iqqu qc bgbgbgbgbgbgbgbgbu");
    //decryptTwoKeys("Top ncmy qkff vi vguv vbg ycpx");
    //decryptTwoKeys("Akag tjw Xibhr awoa aoee xakex znxag xwko");
  
    decryptTwoKeys("Hfs cpwewloj loks cd Hoto kyg Cyy.");
    //decryptTwoKeys("Aal uttx hm aal Qtct Fhljha pl Wbdl. Pvxvxlx!");
    
    /* FileResource fr = new FileResource("data/mysteryTwoKeysQuiz.txt");
    
    String message = "";

for(String word : fr.words()) { 
    message = message + " " + word; }

    decryptTwoKeys(message); */
}
 

}
