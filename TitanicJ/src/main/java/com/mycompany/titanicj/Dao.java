/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.titanicj;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;
import java.io.InputStream;
import java.io.FileInputStream; 
import java.io.IOException;
import com.fasterxml.jackson.core.type.TypeReference;
import java.awt.Color;
import java.util.stream.Collectors;
import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.style.Styler;



/**
 *
 * @author Esraa
 */
public class Dao {

    public Dao() {
    }
    
    public List<TitanicPassenger> readFromJson() throws IOException{
        List<TitanicPassenger> allPassengers = new ArrayList<TitanicPassenger>();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        
        InputStream input = new FileInputStream("titanic.json");
        allPassengers= objectMapper.readValue(input, new TypeReference <List<TitanicPassenger>>(){});
        return allPassengers;  
    }
    public void graphPassengerAges(List<TitanicPassenger> passengerList) {//filter to get an array of passenger ages
        List<Float> pAges= passengerList.stream().map (TitanicPassenger::getAge).limit (8).collect (Collectors.toList());
        List<String> pNames= passengerList.stream().map (TitanicPassenger::getName).limit (8).collect (Collectors.toList());
        CategoryChart chart = new CategoryChartBuilder().width (1024).height (768).title ("Age Histogram").xAxisTitle("Names").yAxisTitle("Age").build ();
        // 2.Customize Chart
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNW);
        chart.getStyler().setHasAnnotations(true);
        chart.getStyler().setStacked(true);
        // 3.Series
        chart.addSeries("Passenger's Ages", pNames, pAges);
        // 4.Show it
        new SwingWrapper(chart).displayChart();
    }
       public void graphPassengerClass(List<TitanicPassenger> passengerList) {
            
            Map<String, Long> result =passengerList.stream().collect (Collectors.groupingBy(TitanicPassenger::getPclass, Collectors.counting() ) );
        
        PieChart chart = new PieChartBuilder().width (800).height (600).title (getClass().getSimpleName()).build ();
                
            Color[] sliceColors= new Color[]{new Color (180, 68, 50), new Color (130, 105, 120), new Color (80, 143, 160)};
            chart.getStyler().setSeriesColors(sliceColors);
                
            chart.addSeries("First Class", result.get("1"));
            chart.addSeries("Second Class", result.get("2"));
            chart.addSeries("Third Class", result.get("3"));
                
            new SwingWrapper(chart).displayChart();
       }
    public void graphPassengersurvived(List<TitanicPassenger> passengerList) {
            
         Map<String, Long> result =passengerList.stream().collect (Collectors.groupingBy(TitanicPassenger::getSurvived, Collectors.counting() ) );
         PieChart chart = new PieChartBuilder().width (800).height (600).title (getClass().getSimpleName()).build ();
                
            Color[] sliceColors= new Color[]{new Color (180, 68, 50), new Color (130, 105, 120)};
            chart.getStyler().setSeriesColors(sliceColors);
                
            chart.addSeries("not Survived Class", result.get("0"));
            chart.addSeries("Survived Class", result.get("1"));  
            new SwingWrapper(chart).displayChart();
       }
    public void graphPassengersurvivedGender(List<TitanicPassenger> passengerList) {
            
         Map<String, Long> result =passengerList.stream().filter(c->c.getSurvived().trim().equals("1")).collect (Collectors.groupingBy(TitanicPassenger::getSex, Collectors.counting() ) );
         PieChart chart = new PieChartBuilder().width (800).height (600).title (getClass().getSimpleName()).build ();
                
            Color[] sliceColors= new Color[]{new Color (180, 68, 50), new Color (130, 105, 120)};
            chart.getStyler().setSeriesColors(sliceColors);
            
            chart.addSeries("Survived female", result.get("female"));    
            chart.addSeries("Survived male", result.get("male"));
              
            new SwingWrapper(chart).displayChart();
       }
  
    
}

        
        
        

