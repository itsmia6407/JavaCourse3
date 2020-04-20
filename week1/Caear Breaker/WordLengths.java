import java.net.*;
import edu.duke.*;
import java.io.*;
//import java.util.Arrays;

public class WordLengths {
    
     public void countWordlengths(FileResource resource, int []counts)
    {
        
        for(String words : resource.words()){
            int wordLength=0;
            for (int k=0; k<words.length();k++){
                if(Character.isLetter(words.charAt(k))){
                    wordLength+=1;
                }
            }
            if (wordLength >30 ){
                counts[31]+=1;
                }
            else{
                counts[wordLength] +=1;   
                }
            }
    }
    public int indexOfMax(int[] values){
        int maxIndex=0;
        for(int k=0; k<values.length;k++){
            if(values[k]>values[maxIndex]){
               maxIndex=k;
            }
        }
        return maxIndex;
    }
    public void testCountWordLengths()
    {
        FileResource fr = new FileResource();
        int[] counts = new int[32];
        countWordlengths(fr,counts);
        for (int k=0; k<counts.length; k++){
            if(counts[k]>0){
            System.out.println("There are " + counts[k]+ " words of length " + k );
           }
        }
        System.out.println("There most common word length is  " + indexOfMax(counts));
        
    }


}
