/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examplehash;

/**
 *
 * @author ANDRY-PC
 */
public class Bulletin {
    private String nom;
    private String prenom;
    private int age;
    private float notes[];

    public Bulletin(String nom, String prenom, int age, float[] notes) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.notes = notes;
    }
    
    public float getMoyenne(){
        float total = 0;
        for (int i = 0; i < notes.length; i++) {
             total+=notes[i];
        }
        return total/notes.length;
    }
    
    private String notes()
    {
        String s = "";
        for (int i = 0; i < notes.length; i++) {
             s+="matière "+i+" : "+notes[i]+"\n";
        }
        return s;
    }

    @Override
    public String toString() {
        String s  = "nom : "+nom+"\n";
               s += "prenom : "+prenom+"\n";
               s += "------------------\n";
               s += notes();
               s += "------------------\n";
               s += "moyenne = "+getMoyenne()+"\n";
        return s;
    }
    
    
    
    
    
}
