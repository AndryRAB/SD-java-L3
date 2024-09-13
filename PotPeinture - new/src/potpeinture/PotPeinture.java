/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package potpeinture;

import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;

/**
 *
 * @author Andry
 */
public class PotPeinture {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame frame =  new JFrame();
        Container c = frame.getContentPane();
        Dessin d = new Dessin(800,800);
        c.add(d);
       frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);          
        frame.pack();
          d.potBF(20, 10, Color.cyan);
     
       
       frame.repaint();
       
   
        
        
    }
}
