/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package occurencesmots;

/**
 *
 * @author ANDRY-PC
 */
public class Vocabulaire implements Comparable<Vocabulaire>{
    private String mot;
    private int freq;

    public Vocabulaire(String mot, int freq) {
        this.mot = mot;
        this.freq = freq;
    }

    public String getMot() {
        return mot;
    }

    public int getFreq() {
        return freq;
    }

    @Override
    public int compareTo(Vocabulaire autre) {
        int c=this.freq-autre.freq;
        if (c!=0) return c;
        return mot.compareTo(autre.mot);
    }
    
}
