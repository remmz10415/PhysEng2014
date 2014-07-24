/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cjpl.util;

/**
 *
 * @author Evan Coleman
 */
public abstract class PWave extends PUtil {
    
    private double sourceX,sourceY,amplitude,phase;
    private double wavelength,frequency,speed;
    
    public PWave(double sourceX, double sourceY) {
        super(sourceX, sourceY);
    }
    
    public double getSourceX() {
        return sourceX;
    }
    
    public double getSourceY() {
        return sourceY;
    }
    
    
    public Double getWavelength() {
        return wavelength;
    }
    
    public Double getFrequency() {
        return frequency;
    }
    
    public Double getSpeed() {
        return speed;
    }
    
    public double getAmplitude() {
        return amplitude;
    }
    
    public double getPhase() {
        return amplitude;
    }
    
    public void setSourceX(double x) {
        sourceX = x;
    }
    
    public void setSourceY(double y) {
        sourceY = y;
    }
   
    
    public void setWavelength(double w) {
        //TODO: THIS
    }
    
    public void setAmplitude(double a) {
        amplitude = a;
    }
    
    public void setPhase(double p) {
       phase = p;
    }
    
    public void setSource(double x, double y) {
       sourceX = x;
        sourceY = y;
    }
    
    public void setSource(double[] d) {
        sourceX = d[0];
        sourceY = d[1];
    }
    
    /*
     * Fix this later. Forcing double to be an objects prob isn't a good solution
    */
    public void bindWFS(Double w, Double f, Double s) {
        int nullCount = 0;
        if(w == null) { nullCount++; }
        if(f == null) { nullCount++; }
        if(s == null) { nullCount++; }
        
        if(nullCount != 1) { return; }
        
        if(w == null) {
            frequency = f;
            speed = s;
            wavelength = s/f;
        }
        
        if(f == null) {
            wavelength = w;
            speed = s;
            frequency = s/w;
        }
        
        if(s == null) {
            wavelength = w;
            frequency = f;
            speed = w*f;
        }
    }
    
    public void bindWFS(Double[] d) {
        double w = d[0], f = d[1], s = d[3];
        this.bindWFS(w, f, s);
    }
    
    
}
