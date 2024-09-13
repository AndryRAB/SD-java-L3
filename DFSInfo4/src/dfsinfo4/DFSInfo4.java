/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dfsinfo4;

/**
 *
 * @author ANDRY-PC
 */
public class DFSInfo4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Graphe g = new Graphe(5)
        .ajoutArete(0, 1).ajoutArete(0, 2).ajoutArete(1, 2)
        .ajoutArete(2, 3).ajoutArete(2, 4);
        
        System.out.println("Parcours en profondeur");
        g.dfs(1);
        System.out.println("Parcours en profondeur");
        g.dfs(1);
        System.out.println("Parcours en largeur");
        g.bfs(1);
    
    }
    
}
