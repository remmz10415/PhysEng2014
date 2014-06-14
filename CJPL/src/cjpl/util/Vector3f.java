package cjpl.util;

import java.util.ArrayList;

/**
 *
 * @author Evan Coleman
 */
public abstract class Vector3f {
 
    protected double x,y,z;
    private Vector3f deriv, antideriv = null;
    private static Vector3f ZERO = null;
    
    public double getX() {
        return this.x;
    }
    
    public double getY() {
        return this.y;    
    }
    
    public double getZ() {
        return this.z;
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
    
    public boolean compare(Vector3f v) {
        if(this.get() == v.get()) {
            return true;
        } else {
            return false;
        }
    }
    
    public Vector3f getDeriv() {
        return this.deriv;
    }
    
    public Vector3f getAntideriv() {
        return this.antideriv;
    }
    
    public void bindDerivative(Vector3f v, int order) {
        if(order <= 0) {
            System.err.println("ERROR: Can't set derivative of negative order. Please see Vector3f.bindAntiderivative()");
            return;
        }
        
        Vector3f d = v.deriv;
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
    
    public void bindAntiderivative(Vector3f v, int order) {
        if(order <= 0) {
            System.err.println("ERROR: Can't set derivative of negative order. Please see Vector3f.bindAntiderivative()");
            return;
        }
        
        Vector3f d = v.antideriv;
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
