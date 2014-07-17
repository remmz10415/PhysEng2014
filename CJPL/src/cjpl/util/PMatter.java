/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cjpl.util;

/**
 *
 * @author Evan Coleman
 */
public abstract class PMatter {
    
    private double x,y,mass,charge;
    private Double xCOM, yCOM, inertiaCOM;
    
    public PMatter(double x, double y, double mass, double charge) {
        this.x = x;
        this.y = y;
        this.mass = mass;
        this.charge = charge;
    }
    
    public Double getInertia(double disp) {
        if (this.inertiaCOM == null) { this.calcInertiaCOM(); }
        return this.inertiaCOM;
    }
    
    public Double getIntertiaCOM() {
        return this.inertiaCOM;
    }
    
    public Double getXCOM() {
        return this.xCOM;
    }
    
    public Double getYCOM() {
        return this.yCOM;
    }
    
    public double getMass() {
        return this.mass;
    }
    
    public double[] getPos() {
        return new double[] {this.x, this.y};
    }
    
    public double getX() {
        return this.x;
    }
    
    public double getY() {
        return this.y;
    }
    
    public double getCharge() {
        return this.charge;
    }
    
    public abstract void calcInertiaCOM();
}
