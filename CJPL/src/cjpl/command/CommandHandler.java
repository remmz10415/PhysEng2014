package cjpl.command;

import cjpl.engine.Engine;
import cjpl.util.PObject;
import cjpl.util.Vector3d;
import java.util.ArrayList;

/**
 * Handles commands.
 * @author steven
 *
 */
public class CommandHandler {

        Engine e; // don't know how I want this instantiated yet
    
        public CommandHandler() {
            e = null;
        }
        
        public void bindEngine(Engine e) {
            this.e = e;
        }
	
	/**
	 * 
	 * @param cmd
	 * @return me returns command message. 
	 */
	public String handleCommand(String cmd) {
		String me = "Invalid Command"; // default message if command not found.
		
                String[] input = cmd.split(" ");
		switch(input[0]) {
		case "removepo":
                        int index = 0;
                        try {
                            index = Integer.parseInt(input[1]);
                        } catch(Exception e) {
                            me = "input[1] must be a number";
                            break;
                        }
                        if(index < 0 || index >= e.getObjects().size()) {
                            me = "Index out of bounds";
                        } else {
                            e.removeObject(index);
                            me = "Successfully removed object at index " + index;
                        }
			break;
                // adds a new Vector3D to the engine
                case "addvo":
                    double x = 0;
                    double y = 0;
                    double z = 0;
                    try {
                        x = Double.parseDouble(input[1]);
                        y = Double.parseDouble(input[2]);
                        z = Double.parseDouble(input[3]);
                    } catch(Exception e) {
                        me = "params must be numbers";
                        break;
                    }
                    e.addObject(new Vector3d(x, y, z));
                    me = "Successfully added Vector3d object";
                    break;
                case "list":
                       if(input.length > 1 && input[1].equals("objects")) {
                           me = "";
                           ArrayList<PObject> pos = e.getObjects();
                           for(PObject po : pos) {
                               me += po + "\n";
                           }
                       }
                       break;
		}
                
		return me;
	}
	
}
