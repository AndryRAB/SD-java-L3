/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package astarPuzz;

import java.util.ArrayList;

/**
 *
 * @author Andry
 */
public class Noeud implements Comparable<Noeud>{
    private int x;
    private int y;
    private int d;
    private Noeud dest;
    private Noeud pred;
    
    private Noeud(int x, int y, int d, Noeud dest, Noeud pred){
        this.x = x;
        this.y = y;
        this.d = d;
        this.dest = dest;
        this.pred = pred;
    }

    public Noeud(int _x, int _y, Noeud dest){
        this.x = _x;
        this.y = _y;
        this.d = 0;
        this.pred = null;
        this.dest = dest;
    }
    
     public Noeud(int _x, int _y){
        this.x = _x;
        this.y = _y;
        this.d = 0;
        this.pred = null;
        this.dest = null;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public Noeud getPred(){
        return pred;
    }
    
    public ArrayList<Noeud> getSucc(int minX, int minY, int maxX, int maxY, Ensemble obs){
        ArrayList<Noeud> tmp = new ArrayList<>();
        if ((x-1>=minX)&&!obs.containsCoord(x-1, y)) tmp.add(new Noeud(x-1,y, d+1, dest, this));
        if ((y-1>=minY)&&!obs.containsCoord(x, y-1)) tmp.add(new Noeud(x,y-1, d+1, dest, this));
        if ((x+1<=maxX)&&!obs.containsCoord(x+1, y)) tmp.add(new Noeud(x+1,y, d+1, dest, this));
        if ((y+1<=maxY)&&!obs.containsCoord(x, y+1)) tmp.add(new Noeud(x,y+1, d+1, dest, this));
        return tmp;
    }
    
    private int h(){ //distance de Manhattan
        return Math.abs(x-dest.x)
            +Math.abs(y-dest.y);                
        //     return 0;
    }

    @Override
    public int compareTo(Noeud o) {
        if (d + h()<o.d + o.h())
            return -1;
        if (d + h()>o.d + o.h())
            return +1;
        return 0;                    
    }

    public boolean isFinished() {
        return ((x==dest.x)&&(y==dest.y));
    }
}
