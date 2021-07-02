/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.titanic;

import java.io.IOException;

import tech.tablesaw.api.Table;



/**
 *
 * @author Esraa
 */
public class MainClass {
    public static void main(String[] args)  throws IOException {
        Table titanicData;
        String dataPath="titanic.csv";
        titanicData = Table.read().csv(dataPath);
        System.out.println(titanicData.columns());
        System.out.println(titanicData.summary());
        
        
    }
    
}
