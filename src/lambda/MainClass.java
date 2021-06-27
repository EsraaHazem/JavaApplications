/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambda;

/**
 *
 * @author Esraa
 */
public class MainClass {
     public static void main(String[] args) {
         String longer =StringUtils.betterString("e","eidsasade",(s1,s2)->s1.length()>s2.length());
         String first =StringUtils.betterString("aa","ee",(s1,s2)->true);
         System.out.println(longer);
         System.out.println(first);        
    }
    
}
