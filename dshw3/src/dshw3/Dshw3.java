/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dshw3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Mühendis
 */
public class Dshw3 {
    
    
    public HashMap<String, Integer> topWords(String text, int threshold) {
        String[] words = setWords(text);
        HashMap<String, Integer> wordCount = wordsToCountSet(words);
                System.out.println("Scanning...");
        HashMap<String, Integer> wordsList = wordCountToList(wordCount, threshold);
        

        return wordsList;
    }
    
    private String[] setWords(String text) {
        // Remove all non-whitespace, non-letter characters with space.
        text=text.toLowerCase();
        
        // Use whitespace as a delimiter.
        String[] words = text.split("[^a-zA-Z'&&[^']]");

        return words;
    }
    private HashMap<String, Integer> wordsToCountSet(String[] words) {
        HashMap<String, Integer> wordCount = new HashMap<String, Integer>();

        for (String word : words) {
            if (wordCount.containsKey(word))
                wordCount.put(word, wordCount.get(word) + 1);
            else
                wordCount.put(word, 1);
        }

        return wordCount;
    }
    private HashMap<String, Integer> wordCountToList(Map<String, Integer> wordCount, int T) {
        // Find the max size of the array for count sort:
        HashMap<String, Integer> words = new HashMap<String, Integer>();
        Set set = wordCount.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
         Map.Entry mentry = (Map.Entry)iterator.next();
            if((int) mentry.getValue()>= T){
             words.put((String) mentry.getKey(), (int) mentry.getValue());             
            }
        }  
        return words;
    }  
     
    public static void main(String[] args) {
        // TODO code application logic here
        String testInput = "", fileName = "totc.txt";
        int i=0;
        String[] com= new String[1000];
        BufferedReader br = null;
         BufferedReader brc = null;
        try {
            String currentLine;
            br = new BufferedReader(new FileReader(fileName));
            while ((currentLine = br.readLine()) != null)
                testInput += " " + currentLine;
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
          try {
            String currentLine2;
             
             
            brc = new BufferedReader(new FileReader("commonwords.txt"));
            while ((currentLine2 = brc.readLine()) != null)
            {
                com[i]= currentLine2;
                i++;
            }
            brc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("java word counter"+fileName+ " 200");
        Dshw3 frequencyCounter = new Dshw3();
        HashMap<String, Integer> wordsList = frequencyCounter.topWords(testInput, 200);
       System.out.println(com[3]);
        Set set = wordsList.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
         Map.Entry mentry = (Map.Entry)iterator.next();
         for(int j=0;j<i;j++){
             if(com[j]==mentry.getKey())
             {
                 
             }
             else{
                 System.out.println(mentry.getKey() + ":"+mentry.getValue());
                 break;
             }   
         }
            
        }       
        
    }
    
}
