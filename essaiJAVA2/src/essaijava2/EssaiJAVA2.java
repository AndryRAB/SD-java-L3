/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package essaijava2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class EssaiJAVA2 {
    public static void main(String[] args) {
        String s1 = new String("salut");
        String s2 = new String("salut");
        String s3 = new String("INFO3");
        String s4 = s1;
        
        System.out.println("raha ==");
        System.out.println(s1==s2); //true - false kay :-/
        System.out.println(s1==s3); //false
        System.out.println(s1==s4); //true
        
        System.out.println("raha equals");
        System.out.println(s1.equals(s2)); //true
        System.out.println(s1.equals(s3)); //false
        System.out.println(s1.equals(s4)); //true
        
        
        System.out.println(" * ArrayList ndray zao");
        ArrayList<String> liste = new ArrayList<>();
        liste.add("Akelle"); // 
        liste.add("Ange");
        liste.add("Michel");
        liste.add("Roland");
        liste.add("Elf'");
        liste.add("Zo");
        liste.add("Kely Samimanana");
        
        System.out.println("liste[4] = "+liste.get(4)); //O(1)
        System.out.println("Foreach :) ");
        for (String s : liste) {
            System.out.println("\t"+s);
        }
        
        liste.remove(0); // O(n)
        System.out.println(liste); //mampiasa toString 
     
        System.out.println(" * LinkedList ndray zao");
        LinkedList<String> liste2 = new LinkedList<>();
        liste2.addLast("Akelle"); //O(1)
        liste2.addLast("Ange");
        liste2.addFirst("Michel");
        liste2.addFirst("Roland");
        liste2.addFirst("Elf'");
        liste2.addLast("Zo");
        liste2.addFirst("Kely Samimanana"); //O(1)
        
        System.out.println("liste[4] = "+liste2.get(4)); //O(n)
        System.out.println("Foreach :) ");
        for (String s : liste2) {
            System.out.println("\t"+s);
        }
        
        liste2.removeFirst(); // O(1)
        liste2.removeLast(); // O(1)
        System.out.println(liste2); //mampiasa toString 
     
        System.out.println(" * PriorityQueue ndray zao");
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(14);
        pq.add(0);
        pq.add(-99);
        pq.add(16);
        pq.add(69);
        pq.add(30);
        pq.add(11);
        
        System.out.println("élément prio "+pq.peek());
        System.out.println("élément prio "+pq.peek());
        
        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }
    }
}
