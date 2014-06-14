package cjpl.command;

/**
 * Handles commands.
 * @author steven
 *
 */
public class CommandManager {

	
	/**
	 * 
	 * @param cmd
	 * @return me returns command message. 
	 */
	public static String handleCommand(String cmd) {
		String me = "Invalid Command"; // default message if command not found.
		
		switch(cmd) {
		case "MEEEOOOWWW":
			//someStatement();
			me = "Cat Swag";
			break;
		}
		
		return me;
	}
	
}
