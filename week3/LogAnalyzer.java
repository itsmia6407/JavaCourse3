
/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     
     public LogAnalyzer() {
         records = new ArrayList<LogEntry>();
     }
        
     public void readFile(String filename) {
         FileResource fr = new FileResource();
         for(String line : fr.lines()){
             records.add(WebLogParser.parseEntry(line));
             
            }
     }
        
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     
     public int countUniqueIPs(){
      //uniqueIPs starts as an empty list
      ArrayList<String> uniqueIPs = new ArrayList<String>();
      //for each element le in records
      for(LogEntry le: records){
          //ipAddr is le's ipAddress
          String ipAddr = le.getIpAddress();
          //if ipAddr is not in uniqueIPs
          if(!uniqueIPs.contains(ipAddr)){
              //add ipAddr to uniqueIps
              uniqueIPs.add(ipAddr);
            }
        }
        return uniqueIPs.size();        
         
        }
        
     public void printAllHigherThanNum ( int num ){
         ArrayList<String> IPsStatus = new ArrayList<String>();
         for( LogEntry le : records){
             // examine all the web log entries in records and print those
             // LogEntrys that have a status code greater than num
             int statusCode = le.getStatusCode();
             if(statusCode > num){
                 System.out.println(le);
                 
                }
         
        }
}

public ArrayList<String> uniqueIPVisitsOnDay(String someday){
    ArrayList<String> uniqueIPVisitsOnDay = new ArrayList<String>();
    
    for (LogEntry le : records){
      String date = le.getAccessTime().toString();  
      String ipAddr = le.getIpAddress();
      if( date.contains(someday) && !uniqueIPVisitsOnDay.contains(ipAddr)){
          uniqueIPVisitsOnDay.add(ipAddr);
          System.out.println(le);
        }
    }
    return uniqueIPVisitsOnDay;
}

public int countUniqueIPsInRange( int low, int high){
   ArrayList<String> uniqueIPs = new ArrayList<String>();
  
   for ( LogEntry le : records){
       int statusCode = le.getStatusCode();
       String ipAddr = le.getIpAddress();
       if( statusCode >= low && statusCode <=high && !uniqueIPs.contains(ipAddr)){
           uniqueIPs.add(ipAddr);
           System.out.println(le);
           
        }
        
    }

    return uniqueIPs.size();
}

public HashMap<String,Integer> countVisitsPerIP(){
 HashMap<String,Integer> counts = new HashMap <String,Integer>();
 //for each le in records
 for(LogEntry le:records){
     String ip = le.getIpAddress();
     if(!counts.containsKey(ip)){
         counts.put(ip,1);
        } else{
            counts.put(ip, counts.get(ip) +1);
        }
    }
    return counts;
}

public int mostNumberVisitByIP ( HashMap<String,Integer> counts){
 //HashMap<String,Integer> counts = new HashMap<String,Integer>();
 
 int max = 1; //min is 1
 for(String ip : counts.keySet() ) {
     if(max<counts.get(ip)){
         max = counts.get(ip);
        }
   }
  return max;
  }

  public ArrayList<String> iPsMostVisits (HashMap<String,Integer> counts){
      int maxNum = mostNumberVisitByIP(counts);
      ArrayList<String> most = new ArrayList<String>();
      for(String ip: counts.keySet()){
          if(maxNum == counts.get(ip)){
              most.add(ip);
            }
        }
      return most;
      
    }
    
    public HashMap<String,ArrayList<String>> iPsForDays (){
        HashMap<String,ArrayList<String>> eachDay = new HashMap<String,ArrayList<String>>();
        
     for(LogEntry le : records ){
         String ip = le.getIpAddress();
         String accessTime = le.getAccessTime().toString();
         String accessMonth = accessTime.substring(4,7);
         String accessDate = accessTime.substring(8,10);
         String countDay = accessMonth +" "+ accessDate;
         if(!eachDay.containsKey(countDay)){
             eachDay.put(countDay, new ArrayList<String>());
        }
        eachDay.get(countDay).add(ip);
    }
    return eachDay;
}

public String dayWithMostIPVisit (HashMap<String,ArrayList<String>> counts){
    String dayWithMostIPVisit = null;
    int max = 0;
    //maps days from web logs to an ArrayList of IP addresses that occurred on that day
    for(String s : counts.keySet()){
     int currDay = counts.get(s).size();
     if( max < currDay){
         max = currDay;
         dayWithMostIPVisit = s;
  
    }
  } return dayWithMostIPVisit;
}

public ArrayList<String> iPsWithMostVisitsOnDay(HashMap<String, ArrayList<String>> map , String date){
    	 HashMap<String,Integer> iPCounter = new HashMap<String,Integer>();
    	 for(String each : map.get(date)) {
    		if(!iPCounter.containsKey(each)) {
    			iPCounter.put(each, 1);
    		}
    		else {
    			iPCounter.put(each, iPCounter.get(each)+1);
    		}
    	}
    	 int maxNum = 0;
    	 ArrayList<String> maxIP = new ArrayList<String>();
    	 for(String each : iPCounter.keySet()) {
    		 if(iPCounter.get(each) >= maxNum ) {
    			 maxNum = iPCounter.get(each);
    		 }
    	 }
    	 for(String each : iPCounter.keySet()) {
    		 if(iPCounter.get(each) >= maxNum) {
    			 maxIP.add(each);
    		 }
    	 }
    	 return maxIP;
     }
}