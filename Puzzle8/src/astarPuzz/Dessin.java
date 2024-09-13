/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package astarPuzz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Andry
 */
public class Dessin extends JPanel implements Ensemble{
    private BufferedImage buff;
    private int width;
    private int height;
    private int fond;
    
    
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

    
    private void drawCross(Graphics g, int x, int y, Color coul){
        g.setColor(coul);
        g.drawLine(x-4, y-4, x+4, y+4);
        g.drawLine(x+4, y-4, x-4, y+4);        
    }
    
    public boolean astar(int x, int y, int destx, int desty, Color coul){   //Astar    
        fond = buff.getRGB(x, y);
        Graphics g = buff.getGraphics();
        drawCross(g, x, y, Color.YELLOW);
        drawCross(g, destx, desty, Color.BLUE);
        buff.setRGB(x, y, Color.green.getRGB()); 
        buff.setRGB(destx, desty, fond); 
           
        Marquage mark = new Marquage(buff.getWidth(), buff.getHeight());
        mark.add(x, y);
        PriorityQueue<Noeud> openList = new PriorityQueue<>();
        openList.add(new Noeud(x, y, new Noeud(destx, desty)));
        while(!openList.isEmpty()){
            Noeud nd = openList.poll();
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(Dessin.class.getName()).log(Level.SEVERE, null, ex);
            }
            buff.setRGB(nd.getX(), nd.getY(), coul.getRGB()); //mandoko
            for (Noeud i : nd.getSucc(0, 0, buff.getWidth()-1, buff.getHeight()-1, this)) {
                if (!mark.containsCoord(i.getX(), i.getY())) {        
                       if ((i.isFinished())) {
                       Noeud tmp = i;
                        while (tmp!=null){ //mandoko mainty² ny lalana
                            buff.setRGB(tmp.getX(), tmp.getY(), Color.black.getRGB());                             
                            tmp = tmp.getPred();                         
                        }
                        repaint();
                        return true;
                    }
                    openList.add(i);
                    mark.add(i.getX(), i.getY());
                    buff.setRGB(i.getX(), i.getY(), Color.red.getRGB()); 
                    repaint();            
                }
            }
        
        }
        return false;
    }
 
    @Override
    public boolean containsCoord(int x, int y) {
        //raha vao tsy mitovy @le fond de obstacle
        return buff.getRGB(x, y)!=fond;
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(width, height);
    }
    
}
    
    
     
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
 /*  
  
    public void potBFLoko(int x, int y, Color coul){        /// potDF
        int coulfond = buff.getRGB(x, y);
       LinkedList  <Noeud> l1 = new LinkedList<>() ;
        buff.setRGB(x, y, Color.red.getRGB()); // marquage!?!     
       l1.addFirst(new Noeud (x,y));
        while (!l1.isEmpty())
        {
            Noeud  n = l1.removeLast() ;
            buff.setRGB(n.getX(),n.getY(), coul.getRGB()); // marquage!?!     
            for (Noeud i : n.getVoisinage(0, 0, buff.getWidth(), buff.getHeight())){
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
 
   */ 