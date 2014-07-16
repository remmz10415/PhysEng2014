package cjpl.gui;

import java.io.*;
import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Settings {

	public static int width = 800;
	public static int height = 600;
	
	
	public static void readSettings(String file) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(file));
                Class c = Settings.class;
                Field[] fields = c.getFields();
    
                try {
                    String current;
                    while((current = reader.readLine()) != null) {
                        String var = current.split("=")[0];
                        Field f = c.getField(var);
                        if(f == null) continue;
			f.set(f, c.cast(var));
                    }
                } catch(Exception e) {
                    e.printStackTrace();
                    Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null);
                }
                reader.close();
	}
        
}
