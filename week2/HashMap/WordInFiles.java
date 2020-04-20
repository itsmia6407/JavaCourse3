
import edu.duke.*;
import java.util.*;
import java.io.File;

public class WordInFiles {

    private HashMap<String, ArrayList<String>> map;
    
    public WordInFiles(){
        map = new HashMap<String, ArrayList<String>>();
    }
    
    private void addWordsFromFile (File f){
        FileResource fr = new FileResource(f);
        //String fileName =f.getName();
        
        for(String w : fr.words()){
            //w=w.toLowerCase();
           
            
            /*if(! map.containsKey(w) == true){
               ArrayList<String> list=map.get(w);
               String name = f.getName();
               if(!list.contains(name)){
                   list.add(f.getName());
                   map.put(w,list);
                }
           } 
           else{
               ArrayList<String> list = new ArrayList<String>();
               list.add(f.getName());
               map.put(w,list);
           }*/
           if(!map.containsKey(w)){
                ArrayList<String> fNamesList = new ArrayList<>();
                fNamesList.add(f.getName());
                map.put(w, fNamesList);
            }else{
                ArrayList<String> fNamesList = map.get(w);
                if(!fNamesList.contains(f.getName()))
                    fNamesList.add(f.getName());
                map.put(w, fNamesList);
            }
            }
        
        
}

void buildWordFileMap (){
 map.clear();   
 DirectoryResource dr = new DirectoryResource();
 for(File f: dr.selectedFiles()){
     addWordsFromFile(f);
    }
}

 int maxNumber (){
 int max = 0;
 int temp = 0;
/* for(String w : map.keySet()){
     int fileCount =map.get(w).size();
     if( fileCount > max ){
       max = fileCount;
        }
    */
   for(ArrayList<String> list : map.values()){
       temp = list.size();
       //System.out.println("list size is : "+ temp);
       if(max<temp){
           max = temp;
        }
     
}
 return max;  
}

ArrayList<String> wordsInNumFiles ( int number){
     
    ArrayList<String> wordList = new ArrayList<String>();
    int temp =0;
    for(String key : map.keySet()){
        ArrayList<String> tempList = map.get(key);
        temp = tempList.size();
        
        if(temp == number){
            wordList.add(key);
        }
    
} return wordList;
}

void printFilesIn (String word){
    ArrayList<String> f = map.get(word);
    for(String s : f){
        System.out.print(s);
    }
    
}


public void printEntireMapping(){
        System.out.println("Complete Mapping : \n");
        for(String word: map.keySet()){
            System.out.print(word+"\t");
            ArrayList<String> fileList = map.get(word);
            for(String fileName : fileList)
                System.out.print(fileName+" ");
                    System.out.println();
        }
    }
    
void tester(){
        buildWordFileMap(); 
       // System.out.println("test words in num files 2 : " + wordsInNumFiles(2));
      //  printFilesIn("cats");
        System.out.println(" ");
        int maxNumberOfFiles = maxNumber();
        System.out.println("Number of file any word appears in :" + maxNumberOfFiles);
        ArrayList<String> result = wordsInNumFiles(maxNumberOfFiles);
        System.out.println("Words in Files :" + result);
        System.out.println("Word and the file they appear in : ");
       
        for(String s : result){
            //System.out.println(s + " is in file " + map.get(s));
           
        }
        System.out.println("Appear in 7 files" + wordsInNumFiles(7).size());
        //ArrayList<String> result5files = wordsInNumFiles(5);
        //System.out.println("total files are: " + result5files.size());
        
        
        System.out.println("Appear in 4 files");
        ArrayList<String> result4files = wordsInNumFiles(4);
        System.out.println("total files are: " + result4files.size());
        
        System.out.println("File that SAD is not appear");
        printFilesIn("sad");
        
        System.out.println("File that red is appear");
        printFilesIn("red");
    }
}
