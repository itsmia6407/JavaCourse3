
import edu.duke.*;
import java.util.*;
import java.io.File;

public class HashMapCountDNA {

    private HashMap<String,Integer> myMap;
    
    public HashMapCountDNA(){
     myMap = new HashMap<String,Integer>();
     
    }
    
    public void buildCodonMap(int start, String dna){
      myMap.clear();
      //codon has 3 char
      dna=dna.substring(start).toUpperCase().trim();
      
      for(int i=0; i + 3 <dna.length() ; i+=3){
          String codon = dna.substring(i,i+3);
          codon = codon.toUpperCase();
          if(!myMap.containsKey(codon)){

              myMap.put(codon,1);
            }
            else{
               
              
                myMap.put(codon,myMap.get(codon)+1);
        }
       
    }
}

    public String getMostCommonCodon (){
       int count = 0;
       String mostCommon = null;
       
       for(String s : myMap.keySet()){
           if(myMap.get(s) >count){
               count = myMap.get(s);
               mostCommon = s;
            }
        
    } return mostCommon;
}

public void printCodonCounts ( int start, int end){
    
    
    for(String w : myMap.keySet()){
        if(myMap.get(w) >= start && myMap.get(w) <= end){
            System.out.println(w + "\t" + myMap.get(w));
       
}
} System.out.println();
}

    public void tester(){
		
	FileResource fr = new FileResource();
	String dna = fr.asString().toUpperCase();
		
	int frame=3;
	for(int i = 0;i<frame; i++){
	buildCodonMap(i, dna);
	System.out.println("Reading frame starting with " + i + 
       " results in " + myMap.size() + " unique codons");
	String mostCommonCodon = getMostCommonCodon();
	System.out.println("  and most common codon is " + mostCommonCodon + " with " + "count " + myMap.get(mostCommonCodon).intValue());
	int start = 1; 
	int end = 7;
	System.out.println("Counts of codons between " + start + " and " + end + " inclusive are:");
	printCodonCounts(start, end);
	System.out.println(" ");
		}
	}
}
	

