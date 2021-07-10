/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mobile;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import org.apache.commons.csv.CSVFormat;
import smile.data.DataFrame;
import smile.io.Read;
import smile.plot.swing.Canvas;
import smile.plot.swing.Histogram;

/**
 *
 * @author Esraa
 */
public class Dao {
    public DataFrame passengerDataFrame;
     public DataFrame readCSV(String path) {
        CSVFormat format = CSVFormat.DEFAULT.withFirstRecordAsHeader ();
        DataFrame df = null;
        try {
            df = Read.csv (path, format);
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace ();
        }
        passengerDataFrame = df;
        return df;
    }
      public void getTrainDataSummery(DataFrame data) {
        DataFrame summary = data.summary ();
        DataFrame selectedColumns = data.select ("battery_power", "n_cores");
        System.out.println("All data summary");
        System.out.println (summary);
        System.out.println("All data Select 5");
        System.out.println (data.slice (0, 5));
        System.out.println (data.select (5));
        System.out.println("All data Select Features");
        System.out.println (selectedColumns.slice (0, 10));
    }
      public DataFrame processTrainData(DataFrame data){
       DataFrame nonNullData= data.omitNullRows ();
        System.out.println ("Number of non Null rows is: "+nonNullData.nrows ());
        

        return nonNullData;
    }
      public void plotData(DataFrame data) {
        if (data != null) {
          DataFrame selectedDF = data.select ("clock_speed","int_memory");
            Canvas canvas = Histogram.of (selectedDF.doubleVector (0).array ()).canvas ();
            canvas.setAxisLabels("ClockSpeed");
            try {
                canvas.window();
            } catch (InterruptedException | InvocationTargetException e) {
            }
        }
    }
    
}
