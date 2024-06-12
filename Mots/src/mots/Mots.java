
package mots;

import java.util.HashMap;
import java.util.PriorityQueue;

public class Mots {

   
    public static void main(String[] args) {
        String s = "bonjour les etudiants etudiants les plus sérieux dans les classes";
        String tab[] = s.split(" ");
        for (String mot : tab) {
            System.out.println(mot);
        }
        HashMap<String,Integer> occurences = new HashMap<>();
        for (String mot: tab) {
            if (!occurences.containsKey(mot)) 
                occurences.put(mot, 1);
            else 
                occurences.put(mot, occurences.get(mot)+1);
        }
        
        System.out.println(occurences.get("les"));
        System.out.println(occurences.get("bonjour"));
        System.out.println(occurences.get("voiture"));
        
        for (String mot : occurences.keySet()) {
            System.out.println(mot+" "+occurences.get(mot));
        }
        
        /*PriorityQueue<Integer> liste0 = new PriorityQueue<>();
        liste0.add(3);
        liste0.add(1);
        liste0.add(17);
        liste0.add(24);
        
        System.out.println(liste0.poll());
        */
        
        System.out.println("--------------");
        PriorityQueue<Vocabulaire> liste = new PriorityQueue<>();
         
        for (String mot : occurences.keySet()) {
            liste.add(new Vocabulaire(mot, occurences.get(mot)));
        }
        
        while(!liste.isEmpty()){
            System.out.println(liste.poll());
        }

    }
    
}
