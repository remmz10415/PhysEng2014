package cjpl.gui;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

import cjpl.command.CommandHandler;

/**
 * The main class to start the engine. Uses ugly Swing.
 * @author steven
 *
 */
public class GUI extends JFrame implements ActionListener {

	// text field can only enter 1 line. How tall should the box be in pixels.
	public static final int TEXT_HEIGHT = 30;
	
	// distance between the bottom of GUI to the bottom of the text field
	public static final int TEXT_OFFSET = 25;
	
	// margins
	public static final String LEFT_MARGIN = "  ";
	
	// hopefully the only containers on the screen
	private JTextArea area;
	private JTextField field;
	
        CommandHandler cmd;
	
        /* It seems that code past the gui never executes. Do I need a new thread? */
	public GUI() {
                // really unsafe
                new Thread(new Runnable() {
                    public void run() {
                        
                        JFrame frame = new JFrame("Engine");
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame.pack();
                        frame.setVisible(true);
                        frame.setSize(Settings.width, Settings.height);
                        //awk? 
                        Container main = new Container();
                        initItems(main);

                        frame.add(main);
                        cmd = new CommandHandler();
                    }
                }).start();
	}
        
        
        public CommandHandler getCmd() {
            return cmd;
        }
	
	/**
	 * Initializes the main components onto a component, which is then added to the screen.
	 * Currently awkward, but Swing is awkward :O
	 * @param c Main container to hold all of the items.
	 */
	public void initItems(Container c) {
		//c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));
		area = new JTextArea();
		area.setBounds(0, 0, Settings.width, Settings.height - TEXT_HEIGHT - TEXT_OFFSET);
		area.setEditable(false);
                JScrollPane scroll = new JScrollPane();
                scroll.setViewportView(area);
                scroll.getVerticalScrollBar().setUnitIncrement(16);
                c.add(scroll);
                c.add(area);
		field = new JTextField("");
		field.setBounds(0, Settings.height - TEXT_HEIGHT - TEXT_OFFSET, Settings.width, Settings.height - TEXT_OFFSET);
		field.setSize(Settings.width, TEXT_HEIGHT);
		field.addActionListener(this);
		c.add(field);
		
	}
	
	@Override
	/**
	 * Currently only handles events for the TextField. Clears the field, executes the commands, and prints output in console.
	 */
	public void actionPerformed(ActionEvent evt) {
		 String text = field.getText().toLowerCase(); //ignore case
	     if(!text.equals("")) { // ignore blank commands
	    	area.append(LEFT_MARGIN + text + "\n");
	    	String re = cmd.handleCommand(text);
	    	area.append(LEFT_MARGIN + LEFT_MARGIN + re + "\n");
	    	field.setText("");
	    }
	}
	
	
	
	
	public static void main(String[] args) throws IOException {
		//Settings.readSettings(args[0]);
		new GUI();
		
	}


	
}
