/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

/**
 *
 * @author Esraa
 */
public class MainClass {
     public static void main (String [] args){
         MyThread th1 = new MyThread("Thread object 1");
         MyThread th2 = new MyThread("Thread object 2");
         MyTask t1 = new MyTask("Task object ");
         Thread th3 = new Thread(t1);
         th1.start();
         th2.start();
         th3.start();
         System.out.println("Main");           
     }
}
