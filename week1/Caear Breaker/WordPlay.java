 

import edu.duke.*;
import java.io.*;
import java.lang.String;

public class WordPlay {

    public boolean isVowel( char ch){
        if( Character.isLowerCase(ch) == true && 
        (ch == 'a'|| ch=='e' || ch=='o'||ch=='i'||ch=='u')){
            return true;
        }
        
            return false;
        
    }
    
    public void testIsVowel (){
        System.out.println(isVowel('F'));
        System.out.println(isVowel('a'));
        
    }
    
    public String replaceVowels (String phrase, char ch){
        StringBuilder sb = new StringBuilder(phrase);
        
        for (int i = 0; i<sb.length(); i++){
            
            char currChar = sb.charAt(i);
            isVowel(currChar);
            if(isVowel(currChar) == true){
                currChar = ch;
                System.out.print(currChar);
            }else{
                currChar = currChar;
                System.out.print(currChar);
            }
       
    }
    //System.out.println(phrase);
    return phrase;
}

public void testReplaceVowels(){
    replaceVowels("Hello World", '*');
}

public String emphasize(String phrase, char ch){
     StringBuilder sb = new StringBuilder(phrase);
      int i;
      String ans = "";
    
    for ( i = 0; i<sb.length(); i++){
            
         char currChar = sb.charAt(i);
            
            
         if ( i % 2 == 1 && currChar == ch){
                currChar ='+';
            } 
         else if (i % 2 == 0 && currChar == ch){
                 currChar ='*';
                }
         else { currChar = currChar;}
             
            
            // ans = Character.toString(currChar);
             
             System.out.print(currChar);
             ans = Character.toString(currChar);
}

return ans;
}

public void testEmphasize(){
   emphasize("dna ctgaaactga",'a');
   emphasize("Mary Bella Abracadabra", 'a'); 
    
}
}

