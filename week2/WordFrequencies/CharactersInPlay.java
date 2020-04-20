
import edu.duke.*;
import java.util.*;
import java.io.*;

public class CharactersInPlay {

    private ArrayList<String> myCharNames;
    private ArrayList<Integer> myFreqs;
    
    public CharactersInPlay(){
      myCharNames = new ArrayList<String>();
      myFreqs = new ArrayList<Integer>();
    }
    
    public void update (String person){
      int index = myCharNames.indexOf(person);
      
      //if (index != -1){
        if(!myCharNames.contains(person)){
          myCharNames.add(person);
          myFreqs.add(1);
    } else {
          int freqs = myFreqs.get(index);
         
          myFreqs.set(index,freqs+1);
        }
    
}

    public void findAllCharacters(){
        myCharNames.clear();
        myFreqs.clear();
        
        FileResource fr = new FileResource();
        for(String line : fr.lines()){
            line = line.toUpperCase();
            int index = line.indexOf(".");
            if (index != -1){
               
                String Characters = line.substring(0,index);
                update(Characters);
            }
            
        }
        /* FileResource playFile = new FileResource();

        for (String line : playFile.lines()) {
            if (line.contains(".")) {
                int endIndex = line.indexOf(".");
                update(line.substring(0,endIndex).trim());         //take all of sentence prior to period
            }
        }*/
    }
    
    public void tester(){
       findAllCharacters();
       for(int k=0; k < myCharNames.size() ; k++){
           if(myFreqs.get(k)>1){
               System.out.println(myCharNames.get(k)+ " " +myFreqs.get(k));
            }
        }
            System.out.println(" ");
            charactersWithNumParts(10,15);
        }
   
    
    private void charactersWithNumParts(int num1, int num2){
        findAllCharacters();
       /* for (int i = 0 ; i<myCharNames.size(); i++){
            int t =myFreqs.get(i);
            if( (t>= num1) && (t<=num2) ){
                System.out.println( myCharNames.get(i)+ " " +t);*/
                
        for(String s : myCharNames){
            int index = myCharNames.indexOf(s);
            if(myFreqs.get(index) >= num1 && myFreqs.get(index) <=num2){
                System.out.println("<100 lines : " + myCharNames.get(index) + "\t " + myFreqs.get(index));
            }
        }
    }   

}

