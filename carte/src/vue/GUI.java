/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controleur.ControleurVuePaquetVisibleVersPaquet;
import controleur.ControleurPiocheVersPaquet;
import model.PaquetFactory;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
 

/**
 * Une fenêtre pour représenter le jeu de cartes
 * @author Pc
 */
public class GUI extends JFrame implements MouseListener {
    /**
     * vue d'un paquet visible
     */
    private VuePaquetVisible vueMainJoueur;
    /**
     * vue d'un paquet caché
     */
    private VuePaquet vuePioche;
    /**
     * vue de la défausse (qu'on a pas représentée ici)
     */
    private VuePaquet vueDefausse;
    /**
     * controleur qui prend une carte dans la pioche pour l'envoyer dans un paquet
     */
    private ControleurPiocheVersPaquet piochePaquet;
        
    public GUI(){
        /**
         * création d'une main vide (qui est vide)
         */
        vueMainJoueur = new VuePaquetVisible(PaquetFactory.createPaquet(0));
        /**
         * la pioche est un paque de 52 cartes
         */
        vuePioche = new VuePaquetCache(PaquetFactory.createPaquet(52));
        /**
         * vue pour la défausse (qui est aussi visible)
         */
        vueDefausse = new VuePaquetVisible(PaquetFactory.createPaquet(0));
        /**
         * mélanger le paquet avant le debut du jeu
         */
        vuePioche.getP().melanger();
        /**
         * on crée un contenaire pour les vues précédentes
         */
        Container cp = this.getContentPane();
        /**
         * création du contrôlelur qui prend une carte de la main d'un joueur pour l'envoyer dans la défausse
         */
        new ControleurVuePaquetVisibleVersPaquet(vueMainJoueur,vueDefausse.getP());
        /**
         * le Layout Manager de notre contenair
         */
        cp.setLayout(new BorderLayout());
        /**
         * l'instanciation du contrôleur qui prend une carte dans la pioche et la donner à un joueur
         */
        piochePaquet = new ControleurPiocheVersPaquet(vuePioche, vueMainJoueur);
        /**
         * on crée un Listener pour la pioche pour qu'il distribue une carte après un clique
         */
        vuePioche.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                /**
                 * On fait la restriction sur la zone d'écoute(uniquement sur la pioche)
                 * sinon ça prend tout le panel
                 */
               if((e.getX()<150) && (e.getY()<200)){
               
               piochePaquet.mouseClicked(e);
               /**
                * la picohe se met à jour après chaque clique
                */
               vuePioche.paquetMiseAJour(vuePioche.getP());
               }
               
            }

            public void mousePressed(MouseEvent e) {
            }

            public void mouseReleased(MouseEvent e) {
            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
            }
        });
        /**
         * un Listener sur les cartes de la main du joeur
         * Quand on clique sur une carte, elle est supprimée de la main du joueur et est envoyée à la défausse
         */
        vueMainJoueur.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                System.out.println(vueDefausse.getP().getListeCarte().size());
                System.out.println(vueMainJoueur.getP().getListeCarte().size());
                vueMainJoueur.paquetMiseAJour(vueMainJoueur.getP());
            
                }

            public void mousePressed(MouseEvent e) {
            }

            public void mouseReleased(MouseEvent e) {
            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
            }
        });
        
        
         
        /**
         * On ajoute lamain du joueur au centre du panel
         */
        cp.add(vueMainJoueur,BorderLayout.CENTER);
        /**
         * on crée une une dimension pour la pioche
         */
        vuePioche.setPreferredSize( new Dimension(400,200));
        /**
         * on l'ajoute au debut du panel
         */
        cp.add(vuePioche,BorderLayout.PAGE_START);
        /**
         * la taille de la fenêtre
         */
        this.setSize(800, 500);
        /**
         * centrer la fenêtre
         */
        this.setLocationRelativeTo(null);
        /**
         * on rend la fenêtre visible
         */
        this.setVisible(true);
        /**
         * On arrête le programme quand la fenêtre est fermée
         */
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void mouseClicked(MouseEvent e) {
      
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }
    /**
     * la fenêtre se repaint quand le modèle change
     * @param ob l'objet
     */
    public void paquetMiseAJour(Object ob) {
        this.repaint();
    }
}
