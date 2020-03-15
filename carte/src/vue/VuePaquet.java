/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import javax.swing.JPanel;
import model.Paquet;
import util.EcouteurPaquet;

/**
 * La vue d'un paquet qui sera héritée  par deux type de vues:
 * une qui sera paquet visible (les cartes seront visibles)
 * une qui sera paquet cache (les cartes sont cachées)
 * Cette classe implémente l'interface EcouteurPaquet pour pouvoir s'abonner au modèle 
 */
public abstract class VuePaquet extends JPanel implements EcouteurPaquet {
    /**
     * la référence sur le modèle
     */
    protected Paquet p;
    /**
     * Construction d'une pour un paquet
     * @param p le paquet à représenter
     */
    public VuePaquet(Paquet p) {
        this.p = p;
        /**
         * l'abonnement sur le modèle
         */
        p.ajoutEcouteur(this);
    }

    /**
     * la vue se repaint quand le modèle change
     * @param o l'objet à repaindre
     */
    @Override
    public void paquetMiseAJour(Object o) {
        repaint();
    }
        
    /**
     * un getter pour le paquet
     * @return le paquet de l'attribut
     */
    public Paquet getP(){
        return this.p;
    }
}
