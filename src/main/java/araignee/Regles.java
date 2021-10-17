/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package araignee;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author trist
 */
public class Regles implements ActionListener{
    
    private JFrame f;
    
    public Regles(){
        f=new JFrame();
        f.setTitle("R�gles du jeu");
        f.setSize(600,400);
        f.setLocationRelativeTo(null);
        f.setLayout(new FlowLayout());
        JLabel r=new JLabel();
        r.setText("<html>Bienvenue sur le Jeu de l'Araign�e !<br><br>"
                + "L'objectif est d'aligner vos trois pions sur la grille.<br>"
                + "Pour cela, posez d'abord vos pions � tour de r�le, puis<br>"
                + "d�placez-les verticalement ou horizontalement pour atteindre<br>"
                + "cet objectif.<br><br>"
                + "- Pour changer de nom, s�lectionnez \"Menu\", puis<br>"
                + "\"Changer de nom\", et choisissez votre nouveau nom.<br>"
                + "- Pour poser un pion, cliquez sur la case de votre choix.<br>"
                + "- Pour le d�placer, apr�s avoir pos� vos 3 pions, cliquez dessus<br>"
                + "  puis s�lectionnez la case o� vous souhaitez le d�placer.<br>"
                + "- Pour annuler la s�lection d'un pion, cliquez � nouveau dessus.<br>"
                + "- Pour relancer une nouvelle partie, cliquez sur \"Nouvelle Partie\"<br>"
                + "  dans le menu.<html>");
        
        r.setFont(new java.awt.Font(Font.DIALOG,Font.BOLD,20));
        f.add(r);
        f.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        f.setVisible(true);
    }
    
}
