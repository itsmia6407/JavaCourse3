
import edu.duke.*;
import java.io.*;

public class CaesarCipher {

    public String encrypt (String input, int key){
     String lowerInput = input.toLowerCase();
        StringBuilder Encrypted = new StringBuilder(input);
        StringBuilder encrypted = new StringBuilder(lowerInput);
      String alphabet ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
      String alphabet1="abcdefghijklmnopqrstuvwxyz";
      String shiftedAlphabet = alphabet.substring(key)+alphabet.substring(0,key);
      String shiftedAlphabet1 = alphabet1.substring(key)+alphabet1.substring(0,key);
    
      int i;
      for(i=0; i<Encrypted.length();i++){
          char currUpperChar = Encrypted.charAt(i);
          char currLowerChar = encrypted.charAt(i);
          
          //if currChar if uppercase:
          
          if(currUpperChar != currLowerChar){
              int idx = alphabet.indexOf(currUpperChar);
              if (idx != -1){
              char newUpperChar = shiftedAlphabet.charAt(idx);
              Encrypted.setCharAt(i,newUpperChar);
            }
        }
            else {
                int idx = alphabet1.indexOf(currLowerChar);
                if(idx != -1){
               char newLowerChar = shiftedAlphabet1.charAt(idx);
              Encrypted.setCharAt(i,newLowerChar);
            }
            }
        }
      
    return Encrypted.toString();
         }

    public void testCaesar(){
        int key =17;
        //Open file and build string 
        FileResource fr = new FileResource();
        String message = fr.asString();
        
        //Encrypt the message
        String encrypted = encrypt(message, key);
        System.out.println(encrypted);
        
        //Decrypt the message
        String decrypted = encrypt(encrypted, 26 - key);
        System.out.println(decrypted);
        //String encrypted = encrypt("First Legion", 23);
        //System.out.println("key is " + 23 + "\n" + encrypted);
        
        //System.out.println(encrypt("First Legion", 17));
        
        //System.out.println(encrypt("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 15));
        //System.out.println(encrypt("Can you imagine life WITHOUT the internet AND computers in your pocket?",15));
    }
    
    public String encryptTwoKeys (String input, int key1, int key2){
        //String lowerInput = input.toLowerCase();
        
        StringBuilder encrypted = new StringBuilder(input);
       // StringBuilder encrypted = new StringBuilder(lowerInput);
        
      String Alphabet ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
      //String alphabet="abcdefghijklmnopqrstuvwxyz";
      
      String shiftedAlphabet1 = Alphabet.substring(key1)+Alphabet.substring(0,key1);
      
      String shiftedAlphabet2 = Alphabet.substring(key2)+Alphabet.substring(0,key2);
    
       int i;
      for(i=0; i<encrypted.length();i++){
          //char currUpperChar = Encrypted.charAt(i);
          //char currLowerChar = encrypted.charAt(i);
          char currChar =encrypted.charAt(i);
          char upperChar = Character.toUpperCase(currChar);
          
          int idx = Alphabet.indexOf(upperChar);
          
          //if currChar if uppercase:
          
          //if(currUpperChar != currLowerChar){
              if(idx !=-1 && i%2 !=0){
                  
              
                  
              char newChar = shiftedAlphabet2.charAt(idx);
              if(Character.isLowerCase(currChar)){
                  newChar = Character.toLowerCase(newChar);
                }
              encrypted.setCharAt(i,newChar);
            }
       
            else if (idx != -1 && i%2==0){
                
               char newChar = shiftedAlphabet1.charAt(idx);
               if(Character.isLowerCase(currChar)){
                   newChar = Character.toLowerCase(newChar);
                }
              encrypted.setCharAt(i,newChar);
            }
            
        }
      
    return encrypted.toString();
         }  
        
     public void testEncryptTwoKeys(){
         //System.out.println(encryptTwoKeys("First Legion", 23,17));
         //System.out.println(encryptTwoKeys("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 8,21));
         //System.out.println(encryptTwoKeys("Just a test string with lots of eeeeeeeeeeeeeeeees",23,2));
         System.out.println(encryptTwoKeys("Can you imagine life WITHOUT the internet AND computers in your pocket?", 21, 8 ));
         //System.out.println(encryptTwoKeys("Duke Computer Science Department Overview", 4,17));
        }
}
