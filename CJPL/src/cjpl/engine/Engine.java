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
public class Engine implements Runnable {
    
    ArrayList<PUtil> objects;
    private static long GLOBAL_TIME = 0;
    private Boolean isRunning = false;
    
    
    public Engine() {
        isRunning = true;
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
    
    public void run() {
        while(isRunning) {
            long time1 = System.currentTimeMillis();
            //System.out.println(GLOBAL_TIME);
            //... stuff goes here
                    
            long time2 = System.currentTimeMillis();
            GLOBAL_TIME += time2-time1;
        }
    }
    
}
