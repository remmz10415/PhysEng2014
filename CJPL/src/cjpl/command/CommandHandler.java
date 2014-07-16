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
    
        
        public static final String[] COMMANDS = {"removepo",
                                                "addvo",
                                                "list",
                                                "set",
                                                "help"};
        
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
		case "removepo": {
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
                }
                // adds a new Vector3D to the engine
                case "addvo": {
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
                }
                case "list": {
                       if(input.length > 1 && input[1].equals("objects")) {
                           me = "";
                           ArrayList<PObject> pos = e.getObjects();
                           for(PObject po : pos) {
                               me += po + "\n";
                           }
                       } else {
                           me = "Bad syntax";
                       }
                break;
                } 
                
                case "help": {
                    me = "Commands:\n";
                    for(String str : COMMANDS) {
                        me = me + str + "\n";
                    }
                    break;
                }
                
                /* input[1] = var index
                 * input[2] = name of attribute to change
                 * input[3] = what to set the attribute to */
                case "set": {
                    if(input.length < 3) {
                        me = "format for command is 'set var_index attribute_name value'";
                        break;
                    }
                    int index = Integer.parseInt(input[1]);
                    String attribute = input[2];
                    String value = input[3]; // we'll pass this as a string and let the class deal with it
                    try {
                        boolean success = e.getObjects().get(index).setAttribute(attribute, value);
                        if(success) me = "Sucessfully changed attribute";
                        else        me = "Failed to change attribute";
                    } catch(Exception e) {
                        me = "params must be numbers";
                        break;
                    }
                break;
                }
                
		}
		return me;
	}
	
}
