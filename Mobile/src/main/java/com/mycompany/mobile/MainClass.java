/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mobile;

import smile.data.DataFrame;

/**
 *
 * @author Esraa
 */
public class MainClass {
     public static void main(String[] args) {
        Dao d1= new Dao();
        DataFrame trainData=d1.readCSV("Mobile_train.csv");
        System.out.println (trainData.structure ());
        System.out.println (trainData.summary ());
        d1.getTrainDataSummery(trainData) ;
        System.out.println (d1.processTrainData(trainData));
        d1.plotData(trainData);
         
     }
    
}
