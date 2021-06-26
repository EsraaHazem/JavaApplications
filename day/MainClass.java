/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day;

/**
 *
 * @author Esraa
 */
public class MainClass {
    public static void main (String [] args){
        Ip ip1=new Ip("163.121.12.30");
        ip1.setIp("166.121.12.30");
        System.out.println(ip1.getIp());
        ip1.cutIp();
        
        
            
        }    
        
    }
    

