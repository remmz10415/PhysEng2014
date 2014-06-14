package cjpl.util;

import java.util.ArrayList;

/**
 *
 * @author Evan Coleman
 */
public abstract class Vector3d {
 
    protected double x,y,z;
    protected ArrayList<Vector3d> derivatives;
    protected ArrayList<Vector3d> antiderivativeOf;
    public final Vector3d ZERO = null;
    
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
    
    public void bindDerivative(Vector3d d, int order) {
        if(order < 1) {
            System.err.println("ERROR: Attempt to add derivative of nonsensical order. For negative orders, see Vector3d.bindAsAntiderivative()");
            return;
        } else if(order > this.derivatives.size() - 1) {
            d.bindAsAntiderivative(this, order);
            ZERO.set(0,0,0);
            System.err.println("WARNING: Order exceeds that of highest-order defined derivative. Undefined derivatives have been zeroed to factor in specified vector.");
            for(int i = this.derivatives.size() - 1; i < order; i++) {
                this.derivatives.add(i, ZERO);
            }
            this.derivatives.add(order, d);
        } else {
            d.bindAsAntiderivative(this, order);
            this.derivatives.add(order, d);
        }
    }
    
    public void bindAsAntiderivative(Vector3d d, int order) {
        
        if(order < 1) {
            System.err.println("ERROR: Attempt to add antiderivative of nonsensical order. For negative orders, see Vector3d.bindDerivative()");
            return;
        } else if(order > this.antiderivativeOf.size() - 1) {
            d.bindDerivative(this, order);
            ZERO.set(0,0,0);
            System.err.println("WARNING: Order exceeds that of highest-order defined antiderivative. Undefined antiderivatives have been zeroed to factor in specified vector.");
            for(int i = this.antiderivativeOf.size() - 1; i < order; i++) {
                this.antiderivativeOf.add(i, ZERO);
            }
            this.antiderivativeOf.add(order, d);    
        } else {
            d.bindDerivative(this, order);
            this.antiderivativeOf.add(order, d);
        }
    }
}
