/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.titanic;

import java.io.IOException;
import joinery.DataFrame;

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
        DataFrame<Object> df=DataFrame.readCsv("titanic.csv");
        //// name of non numerical col
        System.out.println(df.nonnumeric().columns());
        ////no of records
        System.out.println(df.length());
        ////no of col
        System.out.println(df.size());
        //// type of data each col;
        System.out.println(df.types());
        DataFrame<Object> df1= df.retain("pclass","survived","fare").groupBy(row -> row.get(0)).mean();
        System.out.println(df1);
        DataFrame<Object> df2= df.retain("pclass","survived","fare").groupBy(row -> row.get(0)).sum();
        System.out.println(df2);
        DataFrame<Object> df3= df.retain("pclass","survived","fare").groupBy(row -> row.get(0)).stddev();
        System.out.println(df3);
        System.out.println(df.head());
        System.out.println(df.tail());
        
        
    }
    
}
