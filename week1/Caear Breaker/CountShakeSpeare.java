/*
 * Author: miale6407@gmail.com
 * Date: April 19,2020
 * This program will count all of the common words in ShakeSpear plays and display all of those words
 * This program is about string, array of String, string manipulate and read from files.
 *
 */
import edu.duke.*;
import java.io.*;

public class CountShakeSpeare {
    public String[] getCommon(){
    FileResource resource =new FileResource("data/common.txt");
    String[] common = new String[20];
    int index =0;
    for (String s: resource.words()){
        common[index] = s;
        index +=1;
    } 
    return common;
}

       public void countShakeSpear(){ 
    String[] plays ={"caesar.txt", "errors.txt", "hamlet.txt","likeit.txt", "macbeth.txt", "romeo.txt"};
    
    String[] common = getCommon();
    
    int[] counts = new int [common.length];
    for(int i=0; i<plays.length;i++){
        FileResource resource = new FileResource("data/"+ plays[i]);
        countWords(resource,common,counts);
        System.out.println("done with "+plays[i]);
    }
    for(int k =0; k<common.length;k++){
        System.out.println(common[k]+"\t"+counts[k]);
    }
}



public int indexOf(String[] list, String word){
    for (int i=0;i<list.length;i++){
        if(list[i].equals(word)){
            return i;
        }
    }
    return -1;
}

public void countWords(FileResource resource, String[] common, int[] counts){
    for(String word:resource.words()){
        word=word.toLowerCase();
        int index = indexOf(common,word);
        if(index !=-1){
            counts[index]+=1;
        }
    }
}

    
    
    
}


