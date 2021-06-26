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
public class Ip {
    String ip;

    public Ip(String ip) {
        this.ip = ip;
    }

    
    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getIp() {
        return ip;
    }
    
    public void cutIp(){
        String x = getIp();
        String[] arrOfStr = x.split("\\.");
        if (arrOfStr.length != 4){
           System.out.println("error");
        }
        else{
            for (String v :arrOfStr){
                int v1=Integer.parseInt(v);
                System.out.println(v1);
            }   
        }   
    }
    

    @Override
    public String toString() {
        return "Ip{" + "ip=" + ip + '}';
    }
    
    
}
