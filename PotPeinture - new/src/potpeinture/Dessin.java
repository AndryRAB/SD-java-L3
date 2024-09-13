/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package potpeinture;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Andry
 */
public class Dessin extends JPanel{
    private BufferedImage buff;
    private int width;
    private int height;
    
    public Dessin(int w, int h){         
         width = w;
         height = h;
         try {
            buff = ImageIO.read(new File("lab.bmp"));
         } catch (IOException ex) {
            Logger.getLogger(Dessin.class.getName()).log(Level.SEVERE, null, ex);
         }
         /*buff = new BufferedImage(w, h, BufferedImage.OPAQUE);         
         Graphics gbuf = buff.getGraphics();
         gbuf.drawOval(30,30, 150, 100);*/
         //i= 0;
    }

    @Override
    public void paint(Graphics g) {        // efa misy le paint fa ovaina
        super.paint(g);         
        //  g.drawOval(30, 30, 100, 150);
        g.drawImage(buff, 0, 0, this);
    }
    
    public void pot(int x, int y, Color coul){        /// potDF
        int coulfond = buff.getRGB(x, y);
        buff.setRGB(x, y, coul.getRGB()); // marquage!?!?
        repaint();
        try {
            Thread.sleep(1);
        } catch (InterruptedException ex) {
            Logger.getLogger(Dessin.class.getName()).log(Level.SEVERE, null, ex);
        }
        Coord coord = new Coord(x, y);
        ArrayList<Coord> voisinage =  coord.getVoisinage( 0,0, buff.getWidth(), buff.getHeight());
        
        for (Coord c : voisinage){
            if (buff.getRGB(c.getX(), c.getY())==coulfond) //successeur + non marqué
                pot(c.getX(), c.getY(),coul);
        }
    }
    
    public void potBF(int x, int y, Color coul){        /// potDF
        int coulfond = buff.getRGB(x, y);
       LinkedList  <Coord> l1 = new LinkedList<>() ;
        buff.setRGB(x, y, coul.getRGB()); // marquage!?!     
       l1.addFirst(new Coord (x,y));
        while (!l1.isEmpty())
        {
            Coord  n = l1.removeLast() ;
            for (Coord i : n.getVoisinage(0, 0, buff.getWidth(), buff.getHeight())){
                if (coulfond == buff.getRGB(i.getX(), i.getY())) {
                    l1.addFirst(i);
                    buff.setRGB(i.getX(), i.getY(), coul.getRGB());
                    repaint();
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Dessin.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }                    
            }
        }
        
    }
    
    public void potBFLoko(int x, int y, Color coul){        /// potDF
        int coulfond = buff.getRGB(x, y);
       LinkedList  <Coord> l1 = new LinkedList<>() ;
        buff.setRGB(x, y, Color.red.getRGB()); // marquage!?!     
       l1.addFirst(new Coord (x,y));
        while (!l1.isEmpty())
        {
            Coord  n = l1.removeLast() ;
            buff.setRGB(n.getX(),n.getY(), coul.getRGB()); // marquage!?!     
            for (Coord i : n.getVoisinage(0, 0, buff.getWidth(), buff.getHeight())){
                if (coulfond == buff.getRGB(i.getX(), i.getY())) {
                    l1.addFirst(i);
                    buff.setRGB(i.getX(), i.getY(), Color.red.getRGB());
                    //    buff.setRGB(x, y, Color.red.getRGB()); 
                    repaint();
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Dessin.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }                    
            }
        }
        
    }
    
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(width, height);
    }
}
 
    