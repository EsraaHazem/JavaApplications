/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyramidsdao;

/**
 *
 * @author Esraa
 */
public class PyramidsClass {
    
    String pharaoh;
    String modernName;
    String site;
    double height;

    public PyramidsClass(String pharaoh, String modernName,String site,double height  ) {
        this.pharaoh = pharaoh;
        this.modernName = modernName;
        this.site = site;
        this.height = height;    
    }

    public String getPharaoh() {
        return pharaoh;
    }

    public String getModernName() {
        return modernName;
    }

    public String getSite() {
        return site;
    }

    public double getHeight() {
        return height;
    }

    public void setPharaoh(String pharaoh) {
        this.pharaoh = pharaoh;
    }

    public void setModernName(String modernName) {
        this.modernName = modernName;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    @Override
    public String toString() {
        return "PyramidsClass{" + "pharaoh=" + pharaoh + ", modernName=" + modernName + ", site=" + site + ", height=" + height + '}';
    }   
}
    

