/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lecompteestbon;

import java.util.ArrayList;

/**
 *
 * @author Andry
 */
public class Noeud implements Comparable<Noeud>{
    private int [] nombres;
    private int objectif;
    private int d;
    private String operation; 
    private Noeud pred;

    public Noeud(int[] nombres, int but) {
        this.nombres = nombres;
        operation = "";
        objectif = but;
        d = 0;
        pred = null;
    }
    
    private Noeud(int[] nombres, int but, int d, String operation, Noeud pred) {
        this.nombres = nombres;
        objectif = but;
        this.operation = operation;
        this.pred = pred;
        d = 0;
    }
    
    public ArrayList<Noeud> getSucc(){
        
        ArrayList<Noeud> temp = new ArrayList<>();
        for (int i = 0; i < nombres.length-1; i++) {
            for (int j = i+1; j < nombres.length; j++) {
                int max = Math.max(nombres[i],nombres[j]);
                int min = Math.min(nombres[i],nombres[j]);
                temp.add(new Noeud(copier_enlever_ajouter(nombres, i, j, max+min),objectif,d+1, max+"+"+min+" = "+(max+min),this));
                temp.add(new Noeud(copier_enlever_ajouter(nombres, i, j, max-min),objectif,d+1, max+"-"+min+" = "+(max-min),this));
                temp.add(new Noeud(copier_enlever_ajouter(nombres, i, j, max*min),objectif,d+1, max+"*"+min+" = "+(max*min),this));
                if ((min!=0)&&(max%min==0))
                    temp.add(new Noeud(copier_enlever_ajouter(nombres, i, j, max/min),objectif,d+1, max+"/"+min+" = "+(max/min),this));
            }
        }
        return temp;                
    }    
    public int h(){
       int dist = Integer.MAX_VALUE;
        for (int i = 0; i < nombres.length; i++) {
            dist = Math.min(dist,Math.abs(nombres[i]-objectif));
        }        
        return dist;
        //return 0;
    }
    
    public boolean isFinished(){
        for (int i = 0; i < nombres.length; i++) {
            if (nombres[i]==objectif) return true;
        }
        return false;
    }
    

    @Override
    public String toString() {
        String s = operation+"->(";
        for (int i = 0; i < nombres.length-1; i++) {
            s = s + nombres[i] + ",";
        }
        s = s + nombres[nombres.length-1]+")";
        return s;
    }
    
    private static int [] copier_enlever_ajouter(int src[], int enlever1, int enlever2, int nouveau){
        int [] nouvTab = new int [src.length-1];
        int j = 0;
        nouvTab[0] = nouveau;
        for (int i = 1; i < nouvTab.length; i++) {
            while ((j==enlever1)||(j==enlever2)){ 
                j++;
            }
            nouvTab[i] = src[j];
            j++;
        }
        
        return nouvTab;
    }
    
    public void affiche_Chemin(){
        if (pred!=null){
            pred.affiche_Chemin();
        }
        System.out.println(this);
    }
    
    public static int [] copier(int src[]){
        int [] nouvTab = new int [src.length];
        System.arraycopy(src, 0, nouvTab, 0, nouvTab.length);
        return nouvTab;
    }
    
    public static void afficher(int src[]){
        for (int i = 0; i < src.length; i++) {
            System.out.println(i+" = "+src[i]);
        }
    }
    
    @Override
    public int compareTo(Noeud o) {
        if (this.h() + d>o.h()+o.d) return +1;
        if (this.h() + d<o.h()+o.d) return -1;
        return 0;
    }   
}
