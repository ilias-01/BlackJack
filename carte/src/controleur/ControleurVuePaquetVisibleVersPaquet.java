/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import model.Carte;
import model.Paquet;
import vue.VuePaquetVisible;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
* Le contôleur qui prend une carte de la main du joueur pour l'envoyer dans la pioche suite à un  clique
 */
public class ControleurVuePaquetVisibleVersPaquet implements MouseListener, MouseMotionListener {
    /**
     * la main du joueur
     */
    private VuePaquetVisible vueSource;
    /**
     * la défausse
     */
    private Paquet destination;
    
    /**
     * Constructeur
     * @param vueSource la main du joeur
     * @param destination la défausse
     */

    public ControleurVuePaquetVisibleVersPaquet(VuePaquetVisible vueSource, Paquet destination) {
        this.vueSource = vueSource;
        /**
         * l'ajout des écouteurs pour la souris
         */
        vueSource.addMouseMotionListener(this);
        vueSource.addMouseListener(this);
        this.destination = destination;
    }

    /**
     * Suite à un clique, on envoie la carte sélectionnée dans la défausse
     * puis on la supprime de la main du joueur
     * @param e l'évènement du clique
     */
    public void mouseClicked(MouseEvent e) {
        /**
         * on teste si la carte est sélectionnée
         */
       if(vueSource.getSelectedCard()!=-1){
           this.destination.addCardDebut(vueSource.getP().getListeCarte().get(vueSource.getSelectedCard()));
           this.vueSource.getP().getListeCarte().remove(vueSource.getSelectedCard());
       }
    }
    /**
     * Si la souris passe sur la carte, on la colore
     * @param e l'évènement de la souris
     */
    public void mouseMoved(MouseEvent e) {
        int selectedCard = (int) (e.getX()/(vueSource.getRect().getWidth()+7));
        vueSource.setSelectedCard(selectedCard);
    
    }
    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }
   public void mouseDragged(MouseEvent e) {
   }
    
}
