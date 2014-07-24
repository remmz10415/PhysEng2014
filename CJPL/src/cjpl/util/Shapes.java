/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cjpl.util;

/**
 *
 * @author steven
 * Represents the type of shapes a PUtil can be when drawn on the screen.
 */
public class Shapes {
    public enum Shape { SQUARE, CIRCLE, POINT, LINE  }
    
    /**
     *  Used to convert a string to the Shape. Should only be called when changing attribute
     * @param str String representation of the shape.
     * @return 
     */
    protected static Shape getShape(String str) {
        Shape s;
        if(str.equals("square")) {
            s = Shape.SQUARE;
        } else if(str.equals("circle")) {
            s = Shape.CIRCLE;
        } else if(str.equals("point")) {
            s = Shape.POINT;
        } else if(str.equals("line")) {
            s = Shape.LINE;
        } else {
            s =  null;
        }
        return s;
        
    }
}