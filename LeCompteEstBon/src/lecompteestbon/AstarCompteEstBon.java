/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lecompteestbon;

import java.util.PriorityQueue;

/**
 *
 * @author Andry
 */
public class AstarCompteEstBon {
    private Noeud racine;
    private int nbNodes;
    
    public AstarCompteEstBon(Noeud racine) {
        this.racine = racine;
        nbNodes = 0;
    }
    
    public  boolean doAstar(){
        
        PriorityQueue<Noeud> openList = new PriorityQueue<>();
        openList.add(racine);
        Noeud best = racine;
        while(!openList.isEmpty()){
            Noeud x = openList.poll();
            if (x.h()<best.h())
                best = x;
            //stockage du meilleur résultat 
            for (Noeud i : x.getSucc()) {
                openList.add(i);
                nbNodes++;
                if (i.isFinished()){
                    i.affiche_Chemin();
                    return true;
                }
            }
            if (openList.isEmpty())
              best.affiche_Chemin();

        }
     //   best.affiche_Chemin();
        return false;
    }
    
    public void afficheStat(){
        System.out.println("Nbre de noeuds = " + nbNodes);
    }
    
}
