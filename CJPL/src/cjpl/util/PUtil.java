/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cjpl.util;

/**
 * Represents all physics objects. Don't know what attributes it'll represent yet
 * Making class generic is probably overkill.
 * @author steven
 */
public class PUtil {
    
    private boolean isVis;
   private double x, y; // position. May add a location class later on
    
    public PUtil(double x, double y) {
        this.x = x;
        this.y = y;
        isVis = true;
    }
    
    public double getX() {
        return x;
    }
    
    public double getY() {
        return y;
    }
    

    @Override
    public String toString() {
        return "x = " + x + ", y = " + y;
    }
    
    public void setX(double x) {
        this.x = x;
    }
    
    public void setY(double y) {
        this.y = y;
    }
    
  
    
    public void set(double[] v) {
        this.x = v[0];
        this.y = v[1];
    }
    
    public void set(double x, double y, double z) {
        this.x = x;
        this.y = y;
    }
    
    private void setVisible(boolean vis) {
        isVis = vis;
    }
    
    // is it visible on the screen?
    public boolean isVisible() {
        return isVis;
    }
    
    /**
     * 
     * @param attribute Name of the attribute.
     * @param value What the attribute should be set to.
     * @return true if attribute was successfully changed. Occasionally, attribute
     * may be defined in the super.setAttribute(), but not the subclass. We test if
     * setAttribute() is false for the call. If false, we use super.setAttribute().
     * If false again, the attribute was never defined.
     * 
     */
    public boolean setAttribute(String attribute, String value) {
        try {
            switch(attribute) {
                // example usage
                case "visible": {
                    setVisible(Boolean.parseBoolean(value));
                    return true;
                }
            }
        } catch(Exception e) {
            // how are we going to report the error to the console? Should we have a writer seperate from the GUI?
            
        }
        // Attribute not found in the switch statement above
        return false;
    }
    
  
}
