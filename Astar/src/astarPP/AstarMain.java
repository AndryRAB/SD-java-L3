/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package astarPP;

import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;

/**
 *
 * @author Andry
 */
public class AstarMain {

    /**
     * @param args the command line arguments
     *///
    public static void main(String[] args) {
        JFrame frame =  new JFrame();
        Container c = frame.getContentPane();
        Dessin d = new Dessin(600,600);
        c.add(d); 
        //d.potBF(20, 20, Color.BLUE);
       frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);          
        frame.pack();
         d.astar(20, 20,30 , 215, Color.cyan);
      
       
       frame.repaint();
       
   
        
        
    }
}
