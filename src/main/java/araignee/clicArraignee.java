/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package araignee;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author trist
 */
public class clicArraignee implements MouseListener{
    
    private hud h;
    private int joueur;
    private ArrayList pions;
    private TexteTour texte;
    private int etape;
    private Pion memPion;
    private ArrayList pos;
    
    public clicArraignee(hud hu,int j, ArrayList p,TexteTour t){
        texte=t;
        h=hu;
        joueur=j;
        pions=p;
    }
    
    public void poserPion(Pion p){
        if (!p.estDansListe(pions)){
            h.ajouterPion(p);
            if (joueur==1){joueur=2;}
            else{joueur=1;}
            texte.changeJoueur();
            h.changerJoueur();
        }
    }
    
    public ArrayList selectPion(int i){
        ArrayList a=new ArrayList();
        if (pionValide(i)){
            if (i-1>=0 && i!=3 && i!=6 && !casePrise(i-1)){
                a.add(i-1);
                h.selectCase(i-1);
            }
            if (i+1<9 && i!=2 && i!=5 && !casePrise(i+1)){
                a.add(i+1);
                h.selectCase(i+1);
            }
            if (i-3>=0 && !casePrise(i-3)){
                a.add(i-3);
                h.selectCase(i-3);
            }
            if (i+3<9 && !casePrise(i+3)){
                a.add(i+3);
                h.selectCase(i+3);
            }
            if (a.size()>0){
                etape=2;
            }
        }
        return(a);
    }
    
    public void bougerPion(Pion newp,Pion oldp, ArrayList pos){
        if (pos.contains(newp.getPos())){
            for (int k=0; k<pos.size();k++){
                h.selectCase((int) pos.get(k));
            }
            h.enleverPion(oldp);
            h.ajouterPion(newp);
            if (joueur==1){joueur=2;}
            else{joueur=1;}
            texte.changeJoueur();
            h.changerJoueur();
            etape=1;
        }
        else if(oldp.getPos()==newp.getPos()){
            for (int k=0; k<pos.size();k++){
                h.selectCase((int) pos.get(k));
            }
            etape=1;
        }
    }
    
    private int seekCase(int x,int y){
        int x1=0,y1=0;
        if(80<x && x<232){
            x1=0;
        }
        else if(231<x && x<382){
            x1=1;
        }
        else if(381<x && x<531){
            x1=2;
        }
        if(81<y && y<232){
            y1=0;
        }
        else if(231<y && y<382){
            y1=1;
        }
        else if(381<y && y<532){
            y1=2;
        }
        return(x1+3*y1);
    }
    
    private boolean pionValide(int i){
        for (int k=0;k<pions.size();k++){
            Pion p=(Pion) pions.get(k);
            if (p.getPos()==i){
                if (p.getJoueur()==joueur){
                    return(true);
                }
                else{return false;}
            }
        }
        return false;
    }
    
    private boolean casePrise(int i){
        for (int k=0;k<pions.size();k++){
            Pion p=(Pion) pions.get(k);
            if (p.getPos()==i){
                return(true);
            }
        }
        return(false);
    }
    
    private int winner(){
        int gagnant=0;
        ArrayList pionsJ1=new ArrayList();
        ArrayList pionsJ2=new ArrayList();
        for (int k=0;k<pions.size();k++){
            Pion p=(Pion) pions.get(k);
            if (p.getJoueur()==1){pionsJ1.add(p.getPos());}
            else{pionsJ2.add(p.getPos());}
        }
        pionsJ1.sort(null);
        pionsJ2.sort(null);
        if ((int)pionsJ1.get(0)==0 && (int)pionsJ1.get(1)==1 && (int)pionsJ1.get(2)==2){
            gagnant=1;
        }
        if ((int)pionsJ1.get(0)==3 && (int)pionsJ1.get(1)==4 && (int)pionsJ1.get(2)==5){
            gagnant=1;
        }
        if ((int)pionsJ1.get(0)==6 && (int)pionsJ1.get(1)==7 && (int)pionsJ1.get(2)==8){
            gagnant=1;
        }
        if ((int)pionsJ1.get(0)==0 && (int)pionsJ1.get(1)==3 && (int)pionsJ1.get(2)==6){
            gagnant=1;
        }
        if ((int)pionsJ1.get(0)==1 && (int)pionsJ1.get(1)==4 && (int)pionsJ1.get(2)==7){
            gagnant=1;
        }
        if ((int)pionsJ1.get(0)==2 && (int)pionsJ1.get(1)==5 && (int)pionsJ1.get(2)==8){
            gagnant=1;
        }
        if ((int)pionsJ1.get(0)==2 && (int)pionsJ1.get(1)==4 && (int)pionsJ1.get(2)==6){
            gagnant=1;
        }
        if ((int)pionsJ1.get(0)==0 && (int)pionsJ1.get(1)==4 && (int)pionsJ1.get(2)==8){
            gagnant=1;
        }
        if ((int)pionsJ2.get(0)==0 && (int)pionsJ2.get(1)==1 && (int)pionsJ2.get(2)==2){
            gagnant=2;
        }
        if ((int)pionsJ2.get(0)==3 && (int)pionsJ2.get(1)==4 && (int)pionsJ2.get(2)==5){
            gagnant=2;
        }
        if ((int)pionsJ2.get(0)==6 && (int)pionsJ2.get(1)==7 && (int)pionsJ2.get(2)==8){
            gagnant=2;
        }
        if ((int)pionsJ2.get(0)==0 && (int)pionsJ2.get(1)==3 && (int)pionsJ2.get(2)==6){
            gagnant=2;
        }
        if ((int)pionsJ2.get(0)==1 && (int)pionsJ2.get(1)==4 && (int)pionsJ2.get(2)==7){
            gagnant=2;
        }
        if ((int)pionsJ2.get(0)==2 && (int)pionsJ2.get(1)==5 && (int)pionsJ2.get(2)==8){
            gagnant=2;
        }
        if ((int)pionsJ2.get(0)==2 && (int)pionsJ2.get(1)==4 && (int)pionsJ2.get(2)==6){
            gagnant=2;
        }
        if ((int)pionsJ2.get(0)==0 && (int)pionsJ2.get(1)==4 && (int)pionsJ2.get(2)==8){
            gagnant=2;
        }
        return(gagnant);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        int x=e.getX();
        int y=e.getY();
        if (80<x && x<531 && 81<y && y<532){
            int i = seekCase(x,y);
            if (etape==0){
                Pion p = new Pion(i,joueur);
                poserPion(p);
                if (pions.size()==6){
                    int g=winner();
                    if (g!=0){
                        etape=3;
                        texte.gagnant(g);
                    }
                    etape=1;
                }
            }
            else if(etape==1){
                memPion = new Pion(i,joueur);
                pos=selectPion(i);
            }
            else if (etape==2){
                Pion newp = new Pion(i,joueur);
                bougerPion(newp, memPion, pos);
                int g=winner();
                if (g!=0){
                    etape=3;
                    texte.gagnant(g);
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    public void reset(){
        etape=0;
        memPion=null;
        pos=null;
        joueur=1;
    }
}
