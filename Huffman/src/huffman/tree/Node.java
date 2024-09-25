package huffman.tree;

import java.util.HashMap;

/**
 *
 * @author ISPM
 */
public abstract class Node implements Comparable<Node>{
    public abstract int getFrequency();
    
    abstract void doTableCreation(HashMap<Character,String> table, String prefix);
    
    @Override
    public int compareTo(Node other) {
        return this.getFrequency()-other.getFrequency();
    }
    
    
}
