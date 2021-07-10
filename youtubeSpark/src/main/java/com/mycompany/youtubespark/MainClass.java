/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.youtubespark;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author Esraa
 */
public class MainClass {
   
    public static void main(String[] args) throws IOException{
      List<Map<String, Long>> wordCounts=  Youtube.YoutubeTitleWordCount("USvideos.csv");
      for (Map<String, Long> a:wordCounts){
          List<Map.Entry> sort1 = a.entrySet ().stream ()
                    .sorted (Map.Entry.comparingByValue ()).collect (Collectors.toList ());
          for (Map.Entry<String, Long> entry : sort1) {
                System.out.println (entry.getKey () + " : " + entry.getValue ());
            } 
      }    
    }
    
}
