/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.youtubespark;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

/**
 *
 * @author Esraa
 */
public class Youtube {
     private static final String COMMA_DELIMITER = ",";
    public static  List<Map<String, Long>> YoutubeTitleWordCount(String path)throws IOException{
        Logger.getLogger ("org").setLevel (Level.ERROR);
        // CREATE SPARK CONTEXT
        SparkConf conf = new SparkConf ().setAppName ("wordCounts").setMaster ("local[3]");
        JavaSparkContext sparkContext = new JavaSparkContext (conf);
        // LOAD DATASETS
        JavaRDD<String> videos = sparkContext.textFile (path);
        
            // TRANSFORMATIONS
            JavaRDD<String> titles = videos
                    .map (Youtube::extractTitle)
                    .filter (StringUtils::isNotBlank);
           // JavaRDD<String>
            JavaRDD<String> words = titles.flatMap (title -> Arrays.asList (title
                    .toLowerCase ()
                    .trim ()
                    .replaceAll ("\\p{Punct}", " ")
                   .split (" ")).iterator ());
            
            // COUNTING
            Map<String, Long> wordCounts = words.countByValue ();
             JavaRDD<String> tags = videos
                .map (Youtube::extractTags)
                .filter (StringUtils::isNotBlank);
       // JavaRDD<String>
        JavaRDD<String> smallWords = tags.flatMap (tag -> Arrays.asList (tag
                .toLowerCase ()
                .trim ()
                .split ("\\|")).iterator ());
        // COUNTING
        Map<String, Long> WordCounts = smallWords.countByValue ();
        List<Map<String, Long>> x = new ArrayList<>();
        x.add(wordCounts);
        x.add(WordCounts);
            
            // DISPLAY
            return x;
    }
    
      
      
     public static String extractTitle(String videoLine) {
        try {
            return videoLine.split (COMMA_DELIMITER)[2];
        } catch (ArrayIndexOutOfBoundsException e) {
            return "";
        }
    }

     public static String extractTags(String line) {
        try {
            return line.split (COMMA_DELIMITER)[6];
        } catch (ArrayIndexOutOfBoundsException e) {
            return "";
        }
        
    }
    
}
