/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dfsinfo4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.TreeSet;

/**
 *
 * @author ANDRY-PC
 */
public class Graphe {
    private ArrayList<LinkedList<Integer>> succ = new ArrayList<>();
    private TreeSet<Integer> discovered = new TreeSet<>();
    
    public Graphe(int nbNoeud){
        for (int i = 0; i < nbNoeud; i++) {
            succ.add(new LinkedList<>());
        }
    }
    
    public Graphe ajoutArete(int dep, int arr){
    /*    if (!succ.get(dep).contains(arr)) succ.get(dep).add(arr);
        if (!succ.get(arr).contains(dep)) succ.get(arr).add(dep);
     */   
       succ.get(dep).add(arr);
       succ.get(arr).add(dep);
       return this;
    }
    
    public void dfs(int start){
        discovered = new TreeSet<>();
        doDFS(start);
    }
    
    private void doDFS(int start){
        System.out.println(start);
        discovered.add(start); /// marquer
        for (Integer i : succ.get(start)) {
            if (!discovered.contains(i))
                doDFS(i);
        }
    }
    
    public void bfs(int start){
        LinkedList<Integer> fifo = new LinkedList<>();
        discovered = new TreeSet<>(); // vider
        discovered.add(start); /// marquer
        fifo.addFirst(start);
        while(!fifo.isEmpty()){
            int x = fifo.removeLast();
            System.out.println(x);
            for (Integer i : succ.get(x)) {
                if (!discovered.contains(i)){
                    discovered.add(i);
                    fifo.addFirst(i);
                }
            }
        }
    }
    
    public Collection<Integer> getSucc(int noeud){
        return succ.get(noeud);
    }
}
