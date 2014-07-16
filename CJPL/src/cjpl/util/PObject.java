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
public abstract class PObject {
    
    private double x, y, z; // position. May add a location class later on.
    
    private boolean isVis; // is it visible on the screen?
    
    public PObject(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        isVis = true;
    }
    
    public double getX() {
        return x;
    }
    
    public double getY() {
        return y;
    }
    
    public double getZ() {
        return z;
    }
    
    @Override
    public String toString() {
        return "x = " + x + ", y = " + y + ", z = " + z;
    }
    
    public double[] get() {
        return new double[] {this.x, this.y, this.z};
    }
    
    public void setX(double x) {
        this.x = x;
    }
    
    public void setY(double y) {
        this.y = y;
    }
    
    public void setZ(double z) {
        this.z = z;
    }
    
    public void set(double[] v) {
        this.x = v[0];
        this.y = v[1];
        this.z = v[2];
    }
    
    public void set(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    private void setVisible(boolean vis) {
        isVis = vis;
    }
    
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
