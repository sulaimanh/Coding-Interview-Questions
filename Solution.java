import java.io.*;
import java.util.*;
import java.util.HashMap;

class Solution{
	String [] counts = {
		"900,google.com",
    	"60,mail.yahoo.com",
    	"10,mobile.sports.yahoo.com",
    	"40,sports.yahoo.com",
    	"300,yahoo.com",
    	"10,stackoverflow.com",
    	"2,en.wikipedia.org",
    	"1,es.wikipedia.org",
    	"1,mobile.sports"
	};

	// Write a function that takes this input as a parameter and returns a data structure 
    // containing the number of hits that were recorded on each domain AND each domain under it. 
    // For example, an impression on "mail.yahoo.com" counts for "mail.yahoo.com", "yahoo.com", 
    // and "com". (Subdomains are added to the left of their parent domain. So "mail" and
    // "mail.yahoo" are not valid domains.)

// Sample output (in any order):
// 1320    com
//  900    google.com
//  410    yahoo.com
//   60    mail.yahoo.com
//   10    mobile.sports.yahoo.com
//   50    sports.yahoo.com
//   10    stackoverflow.com 
//    3    org
//    3    wikipedia.org
//    2    en.wikipedia.org
//    1    es.wikipedia.org
//    1    mobile.sports
//    1    sports

  
  public static void main(String[] args){
    Solution temp = new Solution();
    
    HashMap<String, Integer> hashy = new HashMap<>();
    temp.seperate(hashy);
    HashMap<String, Integer> fin = new HashMap<>();
    for(String x : hashy.keySet())
        temp.lookThrough(x, hashy.get(x), fin);
    
    for(String x : fin.keySet())
        System.out.println(fin.get(x)+"\t"+x);
    
    
  }
  
  public void lookThrough(String key, int value, HashMap<String, Integer> fin){
    if(!fin.containsKey(key))
        fin.put(key, value);
    else
        fin.put(key, fin.get(key) + value);
    
    String temp;
    for(int i = 0; i < key.length(); i++){
        
        if(key.charAt(i) == '.'){
            temp = key.substring(i+1, key.length());
            if(!fin.containsKey(temp))
                fin.put(temp, value);
            else
                fin.put(temp, fin.get(temp)+value);
        }
    }
  }
  
  
  public void seperate(HashMap<String, Integer> hashy){
    
    for(int i = 0; i < counts.length; i++)
      for(int j = 0; j < counts[i].length(); j++)
        if(counts[i].charAt(j) == ','){
          hashy.put(counts[i].substring(j+1, counts[i].length()), Integer.parseInt(counts[i].substring(0,j)));
          break;
        }
        
      
    
  }
}