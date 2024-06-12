/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mots;


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
    
    /// retourne <0 si this est prioritaire
    /// retourne >0 si autre est prioritaire
    @Override
    public int compareTo(Vocabulaire autre) {
        int c=this.freq-autre.freq;
        if (c==0) c = this.mot.length()-autre.mot.length();
        if (c==0) c = this.mot.compareTo(autre.mot);
        return c;
    }

    @Override
    public String toString() {
        return "Vocabulaire{" + "mot=" + mot + ", freq=" + freq + '}';
    }
    
}
