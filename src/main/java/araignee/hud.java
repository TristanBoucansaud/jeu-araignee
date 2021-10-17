/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package araignee;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.*;
import javax.swing.*;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author trist
 */
public class hud extends JFrame{
    
    private int joueur=1;
    private ArrayList grille;
    private static ArrayList pions;
    private String caseNoireURL;
    private String caseBlancheURL;
    private String caseJauneURL;
    private String pionRougeBlancURL;
    private String pionRougeNoirURL;
    private String pionBleuBlancURL;
    private String pionBleuNoirURL;
    private TexteTour tour;
    private clicArraignee clic;
    private String J1="Joueur 1",J2="Joueur 2";
    
    public hud(){
        
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        menuBar.add(menu);
        
        JMenuItem menuNewGame=new JMenuItem("Nouvelle Partie");
        menuNewGame.addActionListener(new NewGame(this));
        menuNewGame.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
        menu.add(menuNewGame);
        
        JMenuItem menuRegles=new JMenuItem("Règles");
        menuRegles.addActionListener(new Regles());
        menu.add(menuRegles);
        
        menu.addSeparator();
        
        JMenu submenu=new JMenu("Changer de nom");
        
        JMenuItem menuJ1=new JMenuItem("Joueur 1");
        JMenuItem menuJ2=new JMenuItem("Joueur 2");
        menuJ1.addActionListener(new NewName(J1,1,this));
        menuJ2.addActionListener(new NewName(J2,2,this));
        
        submenu.add(menuJ1);
        submenu.add(menuJ2);
        menu.add(submenu);
        
        menu.addSeparator();
        
        JMenuItem menuQuitter=new JMenuItem("Quitter");
        menuQuitter.addActionListener(new Quitter(this));
        menuQuitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4,ActionEvent.ALT_MASK));
        menu.add(menuQuitter);
        
        setJMenuBar(menuBar);
        
        setTitle("Jeu de l'Araignée");
        setSize(600,700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        caseNoireURL="case_noire.png";
        caseBlancheURL="case_blanche.png";
        caseJauneURL="case_jaune.png";
        pionRougeBlancURL="rouge_blanc.png";
        pionRougeNoirURL="rouge_noir.png";
        pionBleuBlancURL="bleu_blanc.png";
        pionBleuNoirURL="bleu_noir.png";
        grille = new ArrayList<NewImage>();
        pions = new ArrayList<Pion>();
        tour=new TexteTour(this,J1,J2);
        clic=new clicArraignee(this,joueur,pions,tour);
        paintGame();
        addMouseListener(clic);
    }
    
    private ArrayList coor(int x){
        ArrayList c= new ArrayList();
        c.add((x%3)*150+75);
        c.add((x/3)*150+30);
        return c;
    }
    
    public void paintGame(){
        for (int i=0; i<9;i++){
            ArrayList c=coor(i);
            int x=(int) c.get(0);
            int y=(int) c.get(1);
            if (i%2==0){
                grille.add(new NewImage(caseBlancheURL,x,y));
            }
            else{
                grille.add(new NewImage(caseNoireURL,x,y));            
            }
        }
        for (int i=0; i<9;i++){
            add((NewImage) grille.get(i));
        }
    }
    
    public void majNom(String nom,int joueur){
        if (joueur==1){
            J1=nom;
        }
        else{
            J2=nom;
        }
        tour.changerNom(nom, joueur);
    }
    
    public void selectCase(int i){
        NewImage n=(NewImage) grille.get(i);
        String url=n.getURL();
        if (url==caseJauneURL){
            if (i%2==0){
                n.setURL(caseBlancheURL);
            }
            else{
                
                n.setURL(caseNoireURL);           
            }
        }
        else{
            n.setURL(caseJauneURL);
        }
        repaint();
    }
    
    public void ajouterPion(Pion p){
        pions.add(p);
        int i=p.getPos();
        int j=p.getJoueur();
        ArrayList c=coor(i);
        int x=(int) c.get(0);
        int y=(int) c.get(1);
        NewImage n=(NewImage) grille.get(i);
        if (j==1){
            if (i%2==0){
                n.setURL(pionRougeBlancURL);
            }
            else{
                n.setURL(pionRougeNoirURL);
            }
        }
        else{
            if (i%2==0){
                n.setURL(pionBleuBlancURL);
            }
            else{
                n.setURL(pionBleuNoirURL);
            }
        }
        repaint();
    }
    
    public void enleverPion(Pion p){
        int i=p.getPos();
        ArrayList c=coor(i);
        int x=(int) c.get(0);
        int y=(int) c.get(1);
        NewImage n=(NewImage) grille.get(i);
        if (i%2==0){
                n.setURL(caseBlancheURL);
            }
            else{
                
                n.setURL(caseNoireURL);           
            }
        repaint();
        p.removeDeListe(pions);
    }
    
    public int getJoueur(){return joueur;}
    
    public void changerJoueur(){
        if (joueur==1){joueur=2;}
        else{joueur=1;}
    }
    
    public void reset(){
        for (int i=0;i<9;i++){
            NewImage n=(NewImage) grille.get(i);
            if (i%2==0){
                n.setURL(caseBlancheURL);
            }
            else{        
                n.setURL(caseNoireURL);           
            }
        }
        int maxi=(int)pions.size();
        for (int i=0;i<maxi;i++){
            Pion p=(Pion) pions.get(0);
            enleverPion(p);
        }
        tour.reset();
        clic.reset();
        
        repaint();
    }
}

