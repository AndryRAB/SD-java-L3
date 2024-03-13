/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examplehash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author ANDRY-PC
 */
public class ExampleHash {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

      /*  String s1 = "salut tout le monde";
        String s2 = "Salut tout le monde";
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
     */
        HashSet<String> ens = new HashSet<>();
        ens.add("Tsiaro");
        ens.add("Miora");
        ens.add("Andry");
        ens.add("Laeti");
        ens.add("Aika");
        ens.add("Joce");
        
        System.out.println(ens.contains("Tsiaro"));
        System.out.println(ens.contains("Aika"));
        System.out.println(ens.contains("Joce"));
        System.out.println(ens.contains("Miora"));
        System.out.println(ens.contains("Wong"));
        System.out.println(ens.contains("andry"));
        
        for (String en : ens) {
            System.out.println(en);
        }
    
        HashMap<String,Integer> map = new HashMap<>();
        map.put("Tsiaro",18);
        map.put("Miora",20);
        map.put("Laeti",14);
        map.put("Aika",25);
        map.put("Joce",30);
        map.put("Melissa",20);
        map.put("Tommy",21);
        map.put("Tsiory",20);
        
        System.out.println(map.get("Melissa"));
        System.out.println(map.get("Aika"));
        System.out.println(map.get("Tommy"));
        System.out.println(map.get("Andry"));
        
        map.put("Aika", 20);
        
        System.out.println(map.get("Aika"));
        System.out.println("les clés sont : ");
        for (String key : map.keySet()) {
            System.out.println(key+", "+map.get(key)+" ans.");
        }
        
        for (Entry<String, Integer> e : map.entrySet()) {
            System.out.println(e.getKey()+" a "+e.getValue()+" ans");
        }
 
    
        HashMap<String,Bulletin> mapbul = new HashMap<>();
        
        mapbul.put("Melissa", new Bulletin("", "Melissa", 20, new float[]{20.0f, 19.0f, 18.0f}));
        mapbul.put("Tommy", new Bulletin("", "Tommy", 21, new float[]{20.0f, 20.0f, 17.0f}));
        mapbul.put("Tsiory", new Bulletin("", "Tsiory", 19, new float[]{1.0f, 2.0f, 3.0f}));
        mapbul.put("Nandrianina", new Bulletin("", "Nandrianina", 18, new float[]{15.0f, 16.0f, 17.0f}));
        
        System.out.println(mapbul.get("Melissa"));
        System.out.println(mapbul.get("Tommy"));
        System.out.println(mapbul.get("Tsiory"));
        System.out.println(mapbul.get("Nandrianina"));
     
        
        HashMap<Point2D,String> couleur = new HashMap<>();
        couleur.put(new Point2D(1, 1), "Rouge");
        couleur.put(new Point2D(2, 1), "Vert");
        couleur.put(new Point2D(4, 0), "Bleu");
        
        System.out.println(couleur.get(new Point2D(2, 1)));
        System.out.println(new Point2D(1, 1).hashCode());
        System.out.println(new Point2D(2, 1).hashCode());
        System.out.println(new Point2D(4, 0).hashCode());
    }
    
}
