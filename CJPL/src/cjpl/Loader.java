
package cjpl;

import cjpl.engine.*;
import cjpl.engine.Engine;
import cjpl.gui.*;
import cjpl.util.*;
import java.lang.reflect.Field;
import slick.SlickTest;

/**
 *Class that a user will call to start up the entire project. Puts everything together
 * @author steven
 */
public class Loader {
    
    public Engine engine;
    public GUI gui;
    
    public Loader() {
        
        engine = new Engine();
        gui = new GUI();
        System.out.println("here");
        gui.getCmd().bindEngine(engine); // awk as hell?
        
        SlickTest.startWindow(engine.getObjects());
        

    }
    
    public static void main(String[] args) {
        new Loader();
    }
    
    
}
