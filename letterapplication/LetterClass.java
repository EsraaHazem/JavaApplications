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
public class LetterClass {
     public static boolean isabcstring(String s){
        return ((!(s.equals("")))&&(s!= null)&&s.chars().allMatch(Character::isLetter));
    }
    
}
