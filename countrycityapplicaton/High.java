/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countrycityapplicaton;

/**
 *
 * @author Esraa
 */
public class High {
     
        
           String key;
           String s;
           Integer q;

            public High(String key, String s, Integer q) {
                this.key = key;
                this.s = s;
                this.q = q;
            }

    public String getKey() {
        return key;
    }

    public String getS() {
        return s;
    }

    public Integer getQ() {
        return q;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setS(String s) {
        this.s = s;
    }

    public void setQ(Integer q) {
        this.q = q;
    }

    @Override
    public String toString() {
        return "High{" + "key=" + key + ", s=" + s + ", q=" + q + '}';
    }
           
             
        
    
}
