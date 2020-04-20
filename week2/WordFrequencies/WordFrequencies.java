import edu.duke.*;
import java.util.*;
import java.io.*;


public class WordFrequencies {

    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    
    public WordFrequencies(){
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }
    
    public void findUnique (){
     myWords.clear();
     myFreqs.clear();
     
     FileResource resource = new FileResource();
     
     for(String s : resource.words()){
         s=s.toLowerCase();
         int index = myWords.indexOf(s);
         if(index == -1){
             myWords.add(s);
             myFreqs.add(1);
            } else {
            int value = myFreqs.get(index);
            myFreqs.set(index,value+1);
        
    }
}
}

public void tester(){
    findUnique();
    
    
    for (int k =0; k < myWords.size(); k ++){
        System.out.println(myFreqs.get(k) + "\t" + myWords.get(k));
        
    }
    System.out.println("# unique words: " + myWords.size());
    
    System.out.println("The word that occurrs most often and its count are: " +
    "\t" + myWords.get(findIndexOfMax() ) + "\t" + myFreqs.get(findIndexOfMax()));;
    //System.out.println(findIndexOfMax("The word that occurrs most often and its count are: " +
    //max + myWords.get(max) ));
    
}

public int findIndexOfMax (){
  int max =0;
  int index = 0;
  for(int k = 0; k< myFreqs.size() ; k ++){
      
  if( max < myFreqs.get(k)){
      max = myFreqs.get(k);
      index = k;
      //return max;
        
}

}return index;
}
}
