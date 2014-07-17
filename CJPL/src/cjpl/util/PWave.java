/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cjpl.util;

/**
 *
 * @author Evan Coleman
 */
public abstract class PWave {
    
    private double sourceX,sourceY,sourceZ,amplitude,phase;
    private Double wavelength,frequency,speed;
    
    public PWave(double sourceX, double sourceY, double sourceZ) {
        this.sourceX = sourceX;
        this.sourceY = sourceY;
        this.sourceZ = sourceZ;
    }
    
    public double getSourceX() {
        return this.sourceX;
    }
    
    public double getSourceY() {
        return this.sourceY;
    }
    
    public double getSourceZ() {
        return this.sourceZ;
    }
    
    public Double getWavelength() {
        return this.wavelength;
    }
    
    public Double getFrequency() {
        return this.frequency;
    }
    
    public Double getSpeed() {
        return this.speed;
    }
    
    public double getAmplitude() {
        return this.amplitude;
    }
    
    public double getPhase() {
        return this.amplitude;
    }
    
    public void setSourceX(double x) {
        this.sourceX = x;
    }
    
    public void setSourceY(double y) {
        this.sourceY = y;
    }
    
    public void setSourceZ(double z) {
        this.sourceZ = z;
    }
    
    public void setWavelength(double w) {
        //TODO: THIS
    }
    
    public void setAmplitude(double a) {
        this.amplitude = a;
    }
    
    public void setPhase(double p) {
        this.phase = p;
    }
    
    public void setSource(double x, double y, double z) {
        this.sourceX = x;
        this.sourceY = y;
        this.sourceZ = z;
    }
    
    public void setSource(double[] d) {
        this.sourceX = d[0];
        this.sourceY = d[1];
        this.sourceZ = d[2];
    }
    
    public void bindWFS(Double w, Double f, Double s) {
        int nullCount = 0;
        if(w == null) { nullCount++; }
        if(f == null) { nullCount++; }
        if(s == null) { nullCount++; }
        
        if(nullCount != 1) { return; }
        
        if(w == null) {
            this.frequency = f;
            this.speed = s;
            this.wavelength = s/f;
        }
        
        if(f == null) {
            this.wavelength = w;
            this.speed = s;
            this.frequency = s/w;
        }
        
        if(s == null) {
            this.wavelength = w;
            this.frequency = f;
            this.speed = w*f;
        }
    }
    
    public void bindWFS(Double[] d) {
        double w = d[0], f = d[1], s = d[3];
        this.bindWFS(w, f, s);
    }
    
    public abstract void draw(String xfn, String yfn, String zfn);
    
}
