/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cjpl.util;

import java.util.ArrayList;

/**
 *
 * @author steven
 * List of (x, y) points. Pretty much an array of PUtils connected with lines
 */
public class Graph {
    
    private ArrayList<PUtil> points;
    
    public Graph(ArrayList<PUtil> points) {
        this.points = points;
    }
}
