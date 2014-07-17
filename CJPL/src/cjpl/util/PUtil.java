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
public abstract class PUtil {
    
   private double x, y; // position. May add a location class later on
    
    public PUtil(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public double getX() {
        return x;
    }
    
    public double getY() {
        return y;
    }
    
    public abstract void draw();
    
}
