/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package araignee;

import java.util.ArrayList;

/**
 *
 * @author trist
 */
public class Pion {
    
    private int i;
    private final int joueur;
    
    public Pion(int l, int j){
        i=l;
        joueur=j;
    }
    
    public void movePion(int newi){
        i=newi;
    }
    
    public int getPos(){return(i);}
    
    public int getJoueur(){return(joueur);}
    
    public boolean estDansListe(ArrayList a){
        boolean test=false;
        for (int k=0; k<a.size();k++){
            Pion p=(Pion) a.get(k);
            if (p.getPos()==i){
                test=true;
            }
        }
        return test;
    }
    
    public void removeDeListe(ArrayList a){
        for (int k=0; k<a.size();k++){
            Pion p=(Pion) a.get(k);
            if (p.getPos()==i){
                a.remove(k);
            }
        }
    }
}
