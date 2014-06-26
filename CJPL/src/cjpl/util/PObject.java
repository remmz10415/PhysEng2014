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
    
   private double x, y, z; // position. May add a location class later on
    
    public PObject(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
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
    
}
