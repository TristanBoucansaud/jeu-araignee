/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package araignee;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.*;
import javax.swing.*;
import java.util.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author trist
 */
public class NewImage extends JPanel{
    
    private Image image;
    private String URL;
    private int x;
    private int y;
    
    public NewImage(String url,int xim,int yim) {
        x=xim;
        y=yim;
        URL=url;
        setBackground(Color.GRAY);
        setOpaque(false);
        setBounds(0,0,600,700);
        try {
            image=ImageIO.read(new File(URL));
        } catch (IOException ex) {
            Logger.getLogger(NewImage.class.getName()).log(Level.SEVERE, null, ex);
        }
        Dimension size = new Dimension(150,150);
        setPreferredSize(size);
    }
    
    public String getURL(){
        return(URL);
    }
    
    public void setURL(String newURL){
        URL=newURL;
        try {
            image=ImageIO.read(new File(newURL));
        } catch (IOException ex) {
            Logger.getLogger(NewImage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
	g.drawImage(image,x,y,150,150,this);
    }
    
}
