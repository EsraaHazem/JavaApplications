/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package letterapplication;
import java.util.*;

/**
 *
 * @author Esraa
 */
public class MainClass {
   
    public static void main(String[] args) {
        String c ="esraa";
        boolean x =  LetterClass.isabcstring(c);
        System.out.println(c);
        System.out.println(x);
        String c1 ="es2raa";
        boolean x1 =  LetterClass.isabcstring(c1);
        System.out.println(c1);
        System.out.println(x1);
        
        
    }
    
    
}
