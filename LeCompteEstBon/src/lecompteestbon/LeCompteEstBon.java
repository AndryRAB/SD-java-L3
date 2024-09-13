/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lecompteestbon;

/**
 *
 * @author Andry
 */
public class LeCompteEstBon {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int t[] = new int[]{3,300,14,100,43,47};
        Noeud racine = new Noeud(t,824);
        AstarCompteEstBon as = new AstarCompteEstBon((racine));
        as.doAstar();
        as.afficheStat();
    }
}
