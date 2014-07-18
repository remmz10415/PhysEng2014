/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cjpl.engine;

import java.util.ArrayList;
import cjpl.util.*;
/**
 *
 * @author steven
 */
public class Engine {
    
    ArrayList<PUtil> objects;
    
    
    public Engine() {
        objects = new ArrayList<PUtil>(); // we assume nothing is on the screen at startup
    }
    
    public void removeObject(int index) {
        objects.remove(index);
    }
    
    public void addObject(PUtil po) {
        objects.add(po);
    }
    
    
    public ArrayList<PUtil> getObjects() {
        return objects;
    }
}
