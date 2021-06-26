/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyramidsdao;
import java.io.IOException;
import java.util.*;

/**
 *
 * @author Esraa
 */
public class MainClass {
    public static void main(String[] args) throws IOException {
        PyramidsDao obj = new PyramidsDao();
        List<PyramidsClass> pyramids1=obj.readPyramidsFromCsv ("pyramids.csv");
        int i = 0;
        for (PyramidsClass p :pyramids1){
            System.out.println("##"+(++i)+p);    
        }
        System.out.println("sorting due height"); 
        List<PyramidsClass> pyramids=obj.sortList ("pyramids.csv");
        int j = 0;
        for (PyramidsClass p :pyramids){
            System.out.println("##"+(++j)+p);    
        }
        System.out.println("map -number of pyramids in a specific site-"); 
        Map<String,Integer > p2 = new HashMap<>();
        p2=obj.mapSitesPyramids ("pyramids.csv") ;
        p2.forEach((k, v) -> System.out.println( k + "=" + v));   
    }
    
}
