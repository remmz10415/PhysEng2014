/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package slick;

import cjpl.util.PUtil;
import java.util.ArrayList;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
/**
 * @author steven
 */
public class SlickTest extends BasicGame
{
    
    private static ArrayList<PUtil> objects;
    
    public SlickTest() {
        super("CPJL");
    }
    
    public static void startWindow(ArrayList<PUtil> pos) {
        try
        {
            objects = pos;
            AppGameContainer app = new AppGameContainer(new SlickTest());
            app.setDisplayMode(500, 400, false);
            app.setTargetFrameRate(60);
            app.start();
            
        }
        catch (SlickException e)
        {
            e.printStackTrace();
        }
    }
    
 
    @Override
    public void init(GameContainer container) throws SlickException {
    }
 
    @Override
    public void update(GameContainer container, int delta) throws SlickException {
    }
 
    public void render(GameContainer container, Graphics g) throws SlickException {
        for(PUtil po : objects) {
            if(po.isVisible()) {
                g.drawOval((float) po.getX(), (float) po.getY(), 30, 30);
            }
        }
        
    }
}