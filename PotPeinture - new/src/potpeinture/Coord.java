/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package potpeinture;

import java.util.ArrayList;

/**
 *
 * @author Andry
 */
public class Coord {
    private int x;
    private int y;
    public Coord(int _x, int _y){
        x = _x;
        y = _y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public ArrayList<Coord> getVoisinage(int minX, int minY, int maxX, int maxY){
        ArrayList<Coord> tmp = new ArrayList<>();
        if (x-1>=minX) tmp.add(new Coord(x-1,y));
        if (y-1>=minY) tmp.add(new Coord(x,y-1));
        if (x+1<maxX) tmp.add(new Coord(x+1,y));
        if (y+1<maxY) tmp.add(new Coord(x,y+1));
        return tmp;
    }

    /***********
    **********
    ***********/
    
    
}
