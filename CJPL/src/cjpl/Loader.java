
package cjpl;

import cjpl.engine.*;
import cjpl.gui.*;
import cjpl.util.*;
import cjpl.engine.Engine;

/**
 *Class that a user will call to start up the entire project. Puts everything together
 * @author steven
 */
public class Loader {
    
    private Engine engine;
    private GUI gui;
    
    public Loader() {
        
        engine = new Engine();
        gui = new GUI();
        System.out.println("here");
        gui.getCmd().bindEngine(engine); // awk as hell?
        //gui.show();
        // Main loop. Do we want Graphics and Engine to be calculated in the same loop?
        //while(true) {
            
            
        //}
    }
    
    public static void main(String[] args) {
        new Loader();
    }
    
    
}
