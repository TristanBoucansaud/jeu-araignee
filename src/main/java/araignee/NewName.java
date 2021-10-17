/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package araignee;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author trist
 */
public class NewName implements ActionListener{
    
    private hud h;
    private String nom;
    private int jo;
    private JFrame f;
    
    public NewName(String n,int j,hud hu){
        h=hu;
        nom=n;
        jo=j;
        f=new JFrame();
        f.setLocationRelativeTo(null);
        f.setLayout(new FlowLayout());
        f.setTitle("J"+jo);
        JTextField zone=new JTextField(12);
        JButton valider=new JButton("Valider");
        valider.addActionListener(new ChangerNom(zone,nom,jo,h,f));
        f.add(zone);
        f.add(valider);
        f.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        f.setVisible(true);
    }
    
}
