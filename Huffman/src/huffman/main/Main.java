
package huffman.main;

import huffman.tree.Leaf;
import huffman.tree.Node;
import huffman.tree.Tree;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author ISPM
 */
public class Main {
    public static HashMap<Character,String> huffmanMain(List<Symbol> symbolList){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        //partie 1 - chargement des symboles recensés avec leurs fréquences respectives
        for (Symbol symbol : symbolList) {
            pq.add(new Leaf(symbol.getSymbol(), symbol.getFrequency()));
        }
        
        //partie 2 - création de l'arbre
        while(pq.size()>1){
            Node left = pq.poll();
            Node right = pq.poll();
            pq.add(new Tree(left, right));
        }
        
        
        //partie 3 - création de la table de codes selon l'arbre
        Tree t = (Tree)pq.peek();
        return t.createTable();
        
    }
    
    public static void main(String[] args) {
        var symbList = new ArrayList<Symbol>();
        symbList.add(new Symbol('a',150));
        symbList.add(new Symbol('b',10));
        symbList.add(new Symbol('e',44));
        symbList.add(new Symbol('g',20));
        symbList.add(new Symbol('x',44));
        symbList.add(new Symbol('.',4));
        symbList.add(new Symbol('s',60));
                    
        var codes = huffmanMain(symbList);
                
       
        System.out.println(codes);
    }
        
    
}
