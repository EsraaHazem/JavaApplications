/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.titanicj;

import java.io.IOException;
import java.util.*;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 *
 * @author Esraa
 */
public class MainClass {
    public static void main(String[] args) throws IOException  {
        Dao d1=new Dao();
        List<TitanicPassenger> allPassengers=d1.readFromJson();
        for(TitanicPassenger x:allPassengers){
            System.out.println(x);
        } 
        d1.graphPassengerAges(allPassengers);
        d1.graphPassengerClass(allPassengers);
        d1.graphPassengersurvived(allPassengers);
        d1.graphPassengersurvivedGender(allPassengers);
        
    }
    
}
