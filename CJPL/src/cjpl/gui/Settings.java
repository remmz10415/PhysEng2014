package cjpl.gui;

import cjpl.Loader;
import java.io.*;
import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Settings {

	public static int width = 800;
	public static int height = 600;
	

	
	public static void readSettings(String file) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(file));
                
                // old code
                /*Field[] fields = Loader.class.getFields(); 
                try {
                    String current;
                    while((current = reader.readLine()) != null) {
                        String var = current.split("=")[0];
                        for(Field f : fields) {
                            Class c = f.getClass();
                            //Yes, this is all magic. I cried writing it.
                            String fieldName = f.toString().split(" ")[3].split(".")[3];
                            if( fieldName == null ? var == null : fieldName.equals(var)) {
                                try {
                                    f.set(f, c.cast(var));
                                } catch (IllegalArgumentException ex) {
                                    Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (IllegalAccessException ex) {
                                    Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        }
                    }
                } catch(IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if(reader != null) reader.close();
                    } catch(IOException e) {
                        e.printStackTrace();
                    }
                } */
                
                try {
                    Class c = Settings.class;
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
	}
	
}
