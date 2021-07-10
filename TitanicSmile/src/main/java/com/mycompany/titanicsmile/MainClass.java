/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.titanicsmile;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import smile.data.DataFrame;
import smile.data.vector.IntVector;

/**
 *
 * @author Esraa
 */
public class MainClass {
    public static void main(String[] args) throws IOException,InterruptedException, InvocationTargetException {
        Dao d1= new Dao();
        DataFrame trainData=d1.readCSV("titanic_train.csv");
        System.out.println (trainData.structure ());
        System.out.println (trainData.summary ());
        trainData = trainData.merge (IntVector.of ("Gender",
                Dao.encodeCategory(trainData, "Sex")));
        System.out.println ("=======Encoding Non Numeric Data (sex)==============");
        System.out.println (trainData.structure ());
        System.out.println (trainData.summary ());
        
        System.out.println("Here");
        
        trainData = trainData.merge (IntVector.of ("PClassValues",
                Dao.encodeCategory(trainData, "Pclass")));
        System.out.println ("=======Encoding Non Numeric Data(pclass)==============");
        System.out.println (trainData.structure ());
        System.out.println (trainData);
        System.out.println ("=======Dropping the Name, Pclass, and Sex Columns==============");
        trainData = trainData.drop ("Name");
        trainData=trainData.drop("Pclass");
        trainData=trainData.drop("Sex");
        System.out.println (trainData.structure ());
        System.out.println (trainData.summary ());
        System.out.println ("=======After Omitting null Rows==============");
        trainData = trainData.omitNullRows ();
        System.out.println (trainData.summary ());
        Dao.edaChart(trainData);
        
        
        
        
        
    }
    
}
