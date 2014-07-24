package cjpl.util;

import java.util.ArrayList;

/**
 *
 * @author Evan Coleman
 */
public class Vector2d extends PUtil {
 
    private double x,y,m,angle;
    private Vector2d deriv, antideriv;
    
    public Vector2d(double x, double y, double m, double angle) {
        super(x, y);
        this.m = m;
        this.angle = (angle < 0 || angle > Math.PI*2 ? (angle < 0 ? angle % (-Math.PI*2) : angle % (Math.PI*2)) : angle);
    }
    
    public Vector2d(double x, double y, double[] components) {
        super(x,y);
        this.m = Math.sqrt(Math.pow(components[0]-x,2) + Math.pow(components[1]-y,2));
        this.angle = Math.atan(components[1]/components[0]) + (components[0] < 0 ? Math.PI : 0);
    }
    
    public double[] getPos() {
        return new double[] {this.x, this.y};
    }
    
    public double getMagnitude() {
        return this.m;
    }
    
    public double getAngle() {
        return this.angle;
    }
    
    public double[] getComponents() {
        return new double[] {this.m * Math.cos(this.angle), this.m * Math.sin(this.angle)};
    }
    
    public void setX(double x) {
        this.x = x;
    }
    
    public void setY(double y) {
        this.y = y;
    }
    
    public void setMagnitude(double m) {
        this.m = m;
    }
    
    public void setComponents(double[] components) {
        this.m = Math.sqrt(Math.pow(components[0]-this.x,2) + Math.pow(components[1]-this.y,2));
        this.angle = Math.atan(components[1]/components[0]) + (components[0] < 0 ? Math.PI : 0);
    }
    
    public void setComponents(double x, double y) {
        this.m = Math.sqrt(Math.pow(x-this.x,2) + Math.pow(y-this.y,2));
        this.angle = Math.atan(y/x) + (x < 0 ? Math.PI : 0);
    }
    
    public void setAngle(double angle) {
        this.angle = (angle < 0 || angle > Math.PI*2 ? (angle < 0 ? angle % (-Math.PI*2) : angle % (Math.PI*2)) : angle);
    }
    
    public void setPos(double[] v) {
        this.x = v[0];
        this.y = v[1];
    }
    
    public void setPos(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public boolean compare(Vector2d v) {
        if(this.getPos() == v.getPos() && this.getMagnitude() == v.getMagnitude()
           && this.getAngle() == v.getAngle()) {
            return true;
        } else {
            return false;
        }
    }
    
    public Vector2d getDeriv() {
        return this.deriv;
    }
    
    public Vector2d getAntideriv() {
        return this.antideriv;
    }
    
    public void bindDerivative(Vector2d v, int order) {
        if(order <= 0) {
            System.err.println("ERROR: Can't set derivative of negative order. Please see Vector2d.bindAntiderivative()");
            return;
        }
        
        Vector2d d = v.deriv;
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
    
    public void bindAntiderivative(Vector2d v, int order) {
        if(order <= 0) {
            System.err.println("ERROR: Can't set derivative of negative order. Please see Vector2d.bindAntiderivative()");
            return;
        }
        
        Vector2d d = v.antideriv;
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
