/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countrycityapplicaton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.stream.*;
import java.util.stream.IntStream;
import java.util.OptionalDouble;


/**
 *
 * @author Esraa
 */
public class MainClass {
      public static void main(String[] args)throws IOException {
          ////read Cities///
        CountryCityDao ccd1= new CountryCityDao();
        List<City> city1=ccd1.readCitiesFromCsv ("Cities.csv");
        System.out.println("#### cities ####");
        int j=0;
        for (City p :city1){
            System.out.println("##"+(++j)+p);    
        }
       ////read Countries///
        CountryCityDao ccd2= new CountryCityDao();
        List<Country> ctry1=ccd2.readCountriesFromCsv ("Countries.csv");
        System.out.println("#### countries ####");
        int i=0;
       for (Country p1 :ctry1){
            System.out.println("##"+(++i)+p1);    
        }
       /////Create a map that uses the country code as keys and a list of cities as the value for each country.
        Map<String,List<City>> x = ccd2.mapCitiesInCountry(ctry1,city1);
        System.out.println("#### countrycode&cities ####");
       x.forEach((k, v) -> System.out.println( k + "=" + v));
       /////For a given country code (from Console) sort the cities according to the population
       System.out.println("#### sort the cities according to the population ####");
       System.out.println("#### enter your coutry code in upper case ####");
       InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br =new BufferedReader(r); 
        System.out.println(ccd2.sortCities (br.readLine(), x));
        ///Get a List of countries population
        System.out.println("#### Get a List of countries population ####");
        List<Integer> y = ccd2. Countriespopulation(ctry1);
        System.out.println(y);
        ///Get the average countries population
        System.out.println("#### Get the average countries population ####");
        System.out.println(ccd2.averagePopulation( y));
        ///Get the maximum countries population
        System.out.println("#### Get the maximum countries population####");
        System.out.println(ccd2.maxPopulation( y, ctry1 ));
        ////Highest population capital
        System.out.println("####Highest population capital####");
        System.out.println(ccd2.highestCapital(ctry1,city1));
        ////Highest population city of each country
        List<High> t = ccd2.highestPopulationCityOfCountry (x);
        System.out.println("####Highest population city of each country####");
        int k=0;
       for (High p1 :t){
            System.out.println("##"+(++k)+p1);    
        }
        
        
        
        
        
        
        
       
        
        
        
       
       
       
        
        
        
        
       
    }
    
}
