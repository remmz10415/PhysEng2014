/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cjpl.engine;

import cjpl.util.PObject;
import java.util.ArrayList;

/**
 *
 * @author steven
 */
public class Engine {
    
    ArrayList<PObject> objects;
    
    
    public Engine() {
        objects = new ArrayList<PObject>(); // we assume nothing is on the screen at startup
    }
    
    public void removeObject(int index) {
        objects.remove(index);
    }
    
    public void addObject(PObject po) {
        objects.add(po);
    }
    
    
    public ArrayList<PObject> getObjects() {
        return objects;
    }
}
