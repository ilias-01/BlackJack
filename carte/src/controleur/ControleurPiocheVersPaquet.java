/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import model.Carte;
import vue.VuePaquet;
import vue.VuePaquetVisible;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Contrôleur qui prend une carte dans la pioche pour l'envoyer dans la main d'un joueur
 */
public class ControleurPiocheVersPaquet implements MouseListener {

    /**
     * la pioche
     */
    private VuePaquet vuepaquet;
    /**
     * la main du joueur
     */
    private VuePaquet paquetDestation;

    /**
     * Constructeur
     * @param vuePaquet la pioche
     * @param paquetDestation  la main du joueur
     */
    public ControleurPiocheVersPaquet(VuePaquet vuePaquet, VuePaquet paquetDestation) {
        this.vuepaquet = vuePaquet;
        this.paquetDestation = paquetDestation;
        
    }

    /**
     * Donne la première carte de la pioche au joeur puis la supprime de la pioche suite à un clique
     * @param e l'évènement du clique
     */
    public void mouseClicked(MouseEvent e) {
        paquetDestation.getP().addCardDebut(vuepaquet.getP().getListeCarte().get(0));
        vuepaquet.getP().getListeCarte().remove(vuepaquet.getP().getListeCarte().get(0));

    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

}
