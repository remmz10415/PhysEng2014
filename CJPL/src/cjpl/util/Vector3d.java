package cjpl.util;

import java.util.ArrayList;

/**
 *
 * @author Evan Coleman
 */
public class Vector3d extends PObject {
 
    private double x,y,z;
    private Vector3d deriv, antideriv;
    private static Vector3d ZERO = null;
    
    public Vector3d(double x, double y, double z) {
        super(x, y, z);
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
    
    public boolean compare(Vector3d v) {
        if(this.get() == v.get()) {
            return true;
        } else {
            return false;
        }
    }
    
    public Vector3d getDeriv() {
        return this.deriv;
    }
    
    public Vector3d getAntideriv() {
        return this.antideriv;
    }
    
    public void bindDerivative(Vector3d v, int order) {
        if(order <= 0) {
            System.err.println("ERROR: Can't set derivative of negative order. Please see Vector3d.bindAntiderivative()");
            return;
        }
        
        Vector3d d = v.deriv;
        for(int i=1; i < order; i++) {
            d = d.deriv;
            if(d == null) {
                System.err.println("ERROR: Can't set derivative of null.");
                return;
            }
        }
        this.deriv = d;
        if(!d.getAntideriv().compare(this)) {
            d.bindAntiderivative(this, order);
        }
    }
    
    public void bindAntiderivative(Vector3d v, int order) {
        if(order <= 0) {
            System.err.println("ERROR: Can't set derivative of negative order. Please see Vector3d.bindAntiderivative()");
            return;
        }
        
        Vector3d d = v.antideriv;
        for(int i=1; i < order; i++) {
            d = d.antideriv;
            if(d == null) {
                System.err.println("ERROR: Can't set derivative of null.");
                return;
            }
        }
        this.antideriv = d;
        if(!d.getDeriv().compare(this)) {
            d.bindDerivative(this, order);
        }
    }
}
