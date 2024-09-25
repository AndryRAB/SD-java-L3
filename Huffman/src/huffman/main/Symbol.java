package huffman.main;

/**
 *
 * @author andry
 */
public class Symbol {
    private char symbol;
    private int frequency;

    public Symbol(char symbol, int frequency) {
        this.symbol = symbol;
        this.frequency = frequency;
    }

    public char getSymbol() {
        return symbol;
    }


    public int getFrequency() {
        return frequency;
    }
    
}
