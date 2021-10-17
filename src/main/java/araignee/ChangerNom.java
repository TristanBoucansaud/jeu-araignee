/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package araignee;

import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author trist
 */
public class ChangerNom implements ActionListener{
    
    private JFrame fen;
    private JTextField zone;
    private String nom;
    private int jo;
    private hud h;

    public ChangerNom(JTextField z, String n, int j, hud hu,JFrame f){
        fen=f;
        zone=z;
        nom=n;
        jo=j;
        h=hu;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        nom=zone.getText();
        zone.setText("");
        h.majNom(nom, jo);
        fen.setVisible(false);
        
    }
    
    
    
}
