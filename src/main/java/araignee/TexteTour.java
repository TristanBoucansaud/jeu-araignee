/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package araignee;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author trist
 */
public class TexteTour extends JLabel{
    
    private int joueur=1;
    private String nomDisp;
    private String J1,J2;
    
    public TexteTour(hud f,String Jo1, String Jo2){
        J1=Jo1;
        J2=Jo2;
        nomDisp=J1;
        setText("Tour : "+nomDisp);
        f.add(this);
        setFont(new java.awt.Font(Font.DIALOG,Font.BOLD,30));
        setForeground(Color.red);
        Insets insets = getInsets();
        Dimension size=this.getPreferredSize();
        setBounds(192+insets.left, 550+insets.top, size.width, size.height);
        }
    
    public void changeJoueur(){
        if (joueur==1){
            joueur=2;
            setForeground(Color.blue);
            nomDisp=J2;
        }
        else{
            joueur=1;
            setForeground(Color.red);
            nomDisp=J1;
        }
        setText("Tour : "+nomDisp);
        Insets insets = getInsets();
        Dimension size=this.getPreferredSize();
        setBounds(250-(7*nomDisp.length())+insets.left, 550+insets.top, size.width, size.height);
    }
    
    public void gagnant(int joueur){
        if (joueur==1){
            setForeground(Color.red);
            nomDisp=J1;
        }
        else{
            setForeground(Color.blue);
            nomDisp=J2;
        }
        setText("GRAND GAGNANT : "+nomDisp);
        Insets insets = getInsets();
        Dimension size=this.getPreferredSize();
        setBounds(140-(7*nomDisp.length())+insets.left, 550+insets.top, size.width, size.height);
    }
    
    public void reset(){
        joueur=1;
        nomDisp=J1;
        setText("Tour : "+nomDisp);
        setFont(new java.awt.Font(Font.DIALOG,Font.BOLD,30));
        setForeground(Color.red);
        Insets insets = getInsets();
        Dimension size=this.getPreferredSize();
        setBounds(192+insets.left, 550+insets.top, size.width, size.height);
    }
    
    public void changerNom(String nom, int joueur){
        if (joueur==1){
            J1=nom;
        }
        else{
            J2=nom;
        }
    }
}
