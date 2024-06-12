/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package occurencesmots;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 *
 * @author ANDRY-PC
 */
public class OccurencesMots {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String s = "bonjour bonjour bonjour les etudiants les plus sérieux des plus sérieux";
        String tab[] = s.split(" ");
        System.out.println(s);
        HashMap<String,Integer> freq = new HashMap<>();
        for (String mot : tab) {
            if (!freq.containsKey(mot)) freq.put(mot, 1);
            else freq.put(mot, freq.get(mot)+1);
        }
        
        System.out.println("-------------");
        for (String string : tab) {
            System.out.println(string);
        }
        
        System.out.println("-------------");
        
        for (String mot : freq.keySet()) {
            System.out.println(mot+", "+freq.get(mot));
        }
        /*
        PriorityQueue<Integer> pdf = new PriorityQueue<>();
        pdf.add(3);
        pdf.add(4);
        pdf.add(17);
        pdf.add(6);
        pdf.add(9);
        pdf.add(8);
        */
        
        ///resaka Fil de Priorité
        PriorityQueue<Vocabulaire> prio = new PriorityQueue<>();
        
        for (String mot : freq.keySet()) {
            prio.add(new Vocabulaire(mot, freq.get(mot)));
        }
          
        while(!prio.isEmpty()){
            System.out.println(prio.poll().getMot());
        }
    }
    
}
