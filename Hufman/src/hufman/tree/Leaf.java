package hufman.tree;

import java.util.HashMap;

/**
 *
 * @author ISPM
 */
public class Leaf extends Node{
    private final char character;
    private final int frequency;

    public Leaf(char character, int frequency) {
        this.character = character;
        this.frequency = frequency;
    }

    public char getChar(){
        return character;
    }
  
    @Override
    public int getFrequency() {
        return this.frequency;
    }

    @Override
    void doTableCreation(HashMap<Character, String> table, String prefix) {
        table.put(character, prefix);
    }
    
}
