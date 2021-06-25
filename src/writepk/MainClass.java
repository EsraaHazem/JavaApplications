/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package writepk;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter; 
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Esraa
 */
public class MainClass {
    public static void main (String[] args)throws IOException{
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br =new BufferedReader(r);          
        FileWriter Writer1 = new FileWriter("out1.txt") ; 
        BufferedWriter buffer =new BufferedWriter(Writer1);
        
        String name="";  
        while(!name.equals("stop")){ 
             System.out.println("Enter data: ");
             name=br.readLine();
             if(!name.equals("stop")){
               System.out.println("data is: "+name);  
               buffer.write("data is: "+name+"\n");
             }     
        }
        
        buffer.close();
        br.close();
        r.close();  
        
    }
    
}
