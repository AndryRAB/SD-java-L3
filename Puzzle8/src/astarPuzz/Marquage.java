/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package astarPuzz;

/**
 *
 * @author Andry
 */
public class Marquage implements Ensemble{

    
    private boolean[][] tab;

    public Marquage(int width, int height) {
        tab = new boolean[width][height];
    }
    
    public void add(int x, int y){
        tab[x][y] = true;
    }
    @Override
    public boolean containsCoord(int x, int y) {
        return  tab[x][y];
    }
    
}
