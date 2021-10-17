/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package araignee;

import java.awt.event.*;

/**
 *
 * @author trist
 */
public class Quitter implements ActionListener{
    
    private hud h;
    
    public Quitter(hud hu){
        h=hu;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        h.dispatchEvent(new WindowEvent(h, WindowEvent.WINDOW_CLOSING));
    }
    
}
