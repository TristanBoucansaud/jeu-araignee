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
public class NewGame implements ActionListener{
    
    private hud h;
    
    public NewGame(hud hu){
        h=hu;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        h.reset();
    }

    
}
