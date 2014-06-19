package cjpl.command;

import cjpl.gui.Settings;
import java.lang.reflect.Array;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Handles commands and user input.
 * 
 * @author steven
 * 
 */
public class CommandManager {
        
        // text box where console output is displayed
        private JTextArea  textBox;
        // text field which handles user input
        private JTextField textField;
        // text field can only enter 1 line. How tall should the box be in pixels.
	public static final int TEXT_HEIGHT = 30,
	// distance between the bottom of GUI to the bottom of the text field
                                TEXT_OFFSET = 25;
	// margins
	public static final String LEFT_MARGIN = "  ";
        
        public CommandManager(JTextArea textBox, JTextField textField) {
            this.textBox   = textBox;
            this.textField = textField;
            
            textBox = new JTextArea();
            textBox.setBounds(0, 0, Settings.width, Settings.height - TEXT_HEIGHT - TEXT_OFFSET);
            textBox.setEditable(false);
        }
    
	/**
	 * 
	 * @param cmd
	 * @return returns command message. 
	 */
	public static String handleCommand(String cmd) {
		String output = "Invalid Command"; // default message if command not found.
                String[] options = cmd.split(" ");
                
                switch(options[0]) {
                    
                }
		
		return output;
	}

        /**
         * 
         * @param  output    the string to display onto the console
         */
        public static String println(String output) {
                return output;
        }
}
