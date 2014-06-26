package cjpl.util;

import java.util.ArrayList;

/**
 *
 * @author Evan Coleman
 */
public class Vector3d extends PObject {
 
    private Vector3d deriv, antideriv;
    private static Vector3d ZERO = null;
    
    public Vector3d(double x, double y, double z) {
        super(x, y, z);
    }
    

    
    public boolean compare(Vector3d v) {
        if(get() == v.get()) {
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
