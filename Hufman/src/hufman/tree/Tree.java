package hufman.tree;

import java.util.HashMap;

/**
 *
 * @author ISPM
 */
public class Tree extends Node{
    private Node lChild;
    private Node rChild;

    public Tree(Node lChild, Node rChild) {
        this.lChild = lChild;
        this.rChild = rChild;
    }

    @Override
    public int getFrequency() {
        return lChild.getFrequency()+rChild.getFrequency();
    }

    @Override
    void doTableCreation(HashMap<Character, String> table, String prefix) {
        lChild.doTableCreation(table, prefix+"0");
        rChild.doTableCreation(table, prefix+"1");
    }
    
    public HashMap<Character, String> createTable(){
        HashMap<Character, String> dico = new HashMap<>();
        doTableCreation(dico, "");
        return dico;
    }
    
}
