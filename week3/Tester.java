
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.readFile("short-test_log");
        logAnalyzer.printAll();
    }
    
    public void testUniqueIP(){
     LogAnalyzer la = new LogAnalyzer();
     //la.readFile("short-test_log");
     la.readFile("weblog2_log");
     int uniqueIPs = la.countUniqueIPs();
     System.out.println("There are " + uniqueIPs + " IPs ");
    }
    
    public void printAllHigherThanNumTester(){
        LogAnalyzer la = new LogAnalyzer();
        //la.readFile("short-test_log");
        //String IPsStatus = ;
        la.readFile("weblog1_log");
        la.printAllHigherThanNum(400);
        //la.printAll();   
        
    }
    
    public void uniqueIPVisitsOnDayTester(){
       LogAnalyzer la = new LogAnalyzer();
       // la.readFile("weblog-short_log");
       //la.uniqueIPVisitsOnDay("Sep 30");
       la.readFile("weblog2_log");
       la.uniqueIPVisitsOnDay("Sep 27"); 
    }
    
    public void countUniqueIPsInRangeTester(){
      LogAnalyzer la = new LogAnalyzer();
       // la.readFile("short-test_log");  
        //la.countUniqueIPsInRange(200,299);
        //la.countUniqueIPsInRange(300,399);
        la.readFile("weblog2_log");
        la.countUniqueIPsInRange(200,299);
    }
    
    public void testCounts(){
     LogAnalyzer la = new LogAnalyzer();
     la.readFile("short-test_log");
     HashMap<String,Integer> counts = la.countVisitsPerIP();
     System.out.println(counts);
        
    }
    
    public void mostNumberVisitByIPTest(){
      LogAnalyzer la = new LogAnalyzer();
     //la.readFile("weblog3-short_log"); 
     //la.readFile("weblog1_log");
     la.readFile("weblog2_log");
     HashMap<String,Integer> counts = la.countVisitsPerIP();
      System.out.println(counts);
     System.out.println("most number visit by IP " + la.mostNumberVisitByIP(counts));
     System.out.println(" IP that visit most " + la.iPsMostVisits(counts)); 

     HashMap<String,ArrayList<String>> dayIPs=la.iPsForDays();
     System.out.println("hash map of ip per day : " + dayIPs);
     //System.out.println(la.dayWithMostIPVisits(dayIPs));
     System.out.println("day with most visit ip : " + la.dayWithMostIPVisit(dayIPs));
     
     System.out.println(" IP that most visit on day : " + la.iPsWithMostVisitsOnDay(dayIPs, "Sep 29"));
    }
    }

