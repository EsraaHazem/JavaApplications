/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countrycityapplicaton;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.*;


/**
 *
 * @author Esraa
 */
public class CountryCityDao {

    public CountryCityDao() {
    }
    /////readCity
    public List<City> readCitiesFromCsv (String fileName) throws IOException{
        List<City> city = new ArrayList<>();
        FileReader csv1 = new FileReader(fileName);
        BufferedReader Buffer1 = new BufferedReader(csv1);
        String line = Buffer1.readLine() ;
        while(line != null){
          String[] arr = line.split(",");
          City cty=createCity(arr);
          city.add(cty);
          line = Buffer1.readLine();         
        }
        
        return city;
    }
    public City createCity(String[] data)
    {
        int id=Integer.parseInt(data[0]);
        String name=data[1];
        int population=Integer.parseInt(data[2]);
        String countryCode=data[3];
        City c1= new City(id,name,population,countryCode);
        
     return c1 ;   
    }
    /////readCountry
    public List<Country> readCountriesFromCsv (String fileName) {
        List<Country> country = new ArrayList<>();
        try{
            FileReader csv2 = new FileReader(fileName);
        BufferedReader Buffer2 = new BufferedReader(csv2);
        String line = Buffer2.readLine() ;
       
        
        while(line!=null){
          String[] arr = line.split(",");
          Country ctry=createCountry(arr);
          country.add(ctry);
          line = Buffer2.readLine();         
        }
        }catch (IOException ex){
                    ex.printStackTrace();
        }
        return country ;
    }
    public Country createCountry(String[] data){
         String code=data[0] ;
         String name=data[1];
         String continent=data[2];
         double surfaceArea=Double.parseDouble(data[4]);
         int population=Integer.parseInt(data[3]);
         double gnp=Double.parseDouble(data[5]);
         int capital=Integer.parseInt(data[6]);
         Country ctr = new Country(code,name,continent,surfaceArea,population,gnp,capital);
         return ctr;
        
    }
    //Create a map that uses the country code as keys and a list of cities as the value for each country.
    public Map<String,List<City> > mapCitiesInCountry (List<Country> cy1,List<City> ci1) {
       Map<String,List<City> > citiesInCountry = new HashMap<>(); 
       List<String> b = cy1.stream().map(Country::getCode).collect(Collectors.toList());
       for(String x:b){
         List<City> w = ci1.stream().filter(c -> (c.getCountryCode()).trim().equals(x)).collect(Collectors.toList());
         citiesInCountry.put(x, w); 
       }          
    return citiesInCountry;      
   }
    ///For a given country code (from Console) sort the cities according to the population
    public List<City> sortCities (String s,Map<String,List<City> > x){
         List<String> t =new ArrayList<>();
         List<City> m =new ArrayList<>();
         for (Map.Entry<String, List<City>> entry : x.entrySet()) {
                String k = entry.getKey();
                t.add(k);
         }
         
        if (!(t.contains(s))){
            System.out.println("error " );
            return m;
        } 
         
        return  x.get(s).stream().sorted(Comparator.comparingInt(City::getPopulation)).collect(Collectors.toList());
    }
     ///Get a List of countries population
    public List<Integer> Countriespopulation (List<Country> cy1){ 
        return cy1.stream().map(Country::getPopulation).collect(Collectors.toList());  
    }
    ///Get the average countries population
    public Double averagePopulation(List<Integer> y ){
        return y.stream().mapToInt((e) -> e).average().getAsDouble();    
    }
    ///Get the maximum countries population
    public Integer maxPopulation(List<Integer> y,List<Country> cy1 ){
        Integer a= y.stream().mapToInt((e) -> e).max().getAsInt();
        cy1.stream().filter(c -> (c.getPopulation()) == a).forEach(c ->System.out.println(c.getName()));
        return a;    
    }
    ////////Highest population capital
    public List<City> highestCapital(List<Country> cy1,List<City> ci1){
        List<City> v=new ArrayList<>();
        List<Integer> p=new ArrayList<>(); 
        List<Integer> b = cy1.stream().map(Country::getCapital).collect(Collectors.toList());
        int u=0;
        for(Integer x:b){
            if (x == -1){
               u=u+1;  
            }
            else{
                v=(ci1.stream().filter(c -> (c.getId())== x).collect(Collectors.toList()));   
            } 
         p.add( v.stream().map(City::getPopulation).mapToInt(c->c).findFirst().orElseThrow(() -> new IllegalArgumentException("value not found")));  
       }  
       Integer e = p.stream().mapToInt(c->c).max().getAsInt();
        List<City> s = ci1.stream().filter(c -> c.getPopulation()== e).map(c->c).collect(Collectors.toList());
        return s;
        }
        
        
  ////Highest population city of each country
    
    public List<High> highestPopulationCityOfCountry (Map<String,List<City>>m) {
            List<High> r=new ArrayList<>();
            Map<String,List<City> > citiesInCountry = new HashMap<>(); 
            int b=0;
           for (Map.Entry<String, List<City>> entry : m.entrySet()) {
                String k = entry.getKey();
                
                if(m.get(k).size()==0)
                {
                  b=b+1;  
                }
                else
                {
                   citiesInCountry.put(k, m.get(k));
                }                
           }
           for (Map.Entry<String, List<City>> entry : citiesInCountry.entrySet()) {
                String key = entry.getKey();
                List<City> v = entry.getValue();
                Integer q =v.stream().map(City::getPopulation).mapToInt((e) -> e).max().getAsInt();
                String s=v.stream().filter(c -> c.getPopulation()== q).map(City::getName).map(c->c).findFirst().orElseThrow(() -> new IllegalArgumentException("value not found"));
                High h = new High(key,s,q);
                r.add(h);   
           }
           return r;      
    }
    

    
    
    
    
    
    
}
