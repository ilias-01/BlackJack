/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import model.Paquet;

/**
 * représente un paquet caché(les cartes sont visible), utilisée pour la main d'un joueur
 * Cette classe hérite de la classe VuePaquet
 */

public class VuePaquetVisible extends VuePaquet {

    /**
     * un rectangle qui représente une carte
     */
    private  Rectangle2D rec;
    /**
     * l'abscisse de la pioche
     */
    private final int X = 1;
    /**
     * l'orodonné de la pioche
     */
    private final int Y = 1;
    /**
     * l'abscisse du rectange
     */
    private final int ABSCISSE = 10;
    /**
     * l'ordonné du rectangle
     */
    private final int ORDONNEE = 10;
    /**
     * la largeur de la carte
     */
    private final int LARGEUR = 70;
    /**
     * la hauteur de la carte
     */
    private final int HAUTEUR = 100;
    /**
     * la valueur qu'on ajoute sur les abscisse après chaque dessin d'une carte
     */
    private final int AJOUT_SUR_ABSCISSE = 50;
    /**
     * la valueur qu'on ajoute sur les position des largeurs après chaque dessin d'une carte
     */
    private final int AJOUT_SUR_LARGEUR = 90;
    /**
     * la valueur qu'on ajoute sur les position des hauteurs après chaque dessin d'une carte
     */
    private final int AJOUT_SUR_HAUTEUR = 80;
    
    /**
     * indique si une carte est séléctionnée ou non
     */
    private int selectedCard=-1;
    /**
     * Construction de la vue d'un paquet visible pour la main d'un joueur
     * @param p le paquet à représenter
     */
    public VuePaquetVisible(Paquet p) {
        /**
         * l'appel du contructeur de la classe de base
         */
        super(p);
        /**
         * l'abonnement sur le modèle
         */
        p.ajoutEcouteur(this);
        /**
         * création d'un rectangle pour une carte
         */
        this.rec = new Rectangle2D.Double(X, Y, LARGEUR, HAUTEUR);

    }

    /**
     * met à jour la main d'un joueur
     * @param p la main du joueur
     */
    @Override
    public void paquetMiseAJour(Object p) {
        super.paquetMiseAJour(p); 
    }

    /**
     * représentation graphique des cartes (horizontalement) avec un décalage important sur les abscisses.
     * la position de laxe des ordonnées reste la même pour toutes les cartes 
     * @param g l'objet graphique qu'on veut utilise
     */
    
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        super.paintComponent(g);
        int k = ABSCISSE;
        int c = 7;

        for (int i = 0; i < this.p.getListeCarte().size(); i++) {
            
            g2D.setColor(Color.white);
            g2D.fillRoundRect((int) rec.getX() + k, (int) rec.getY()+AJOUT_SUR_ABSCISSE, (int) rec.getWidth(), (int) rec.getHeight(), ABSCISSE, ORDONNEE);;
            g2D.setColor(i== selectedCard ? Color.GREEN : Color.black);
            g2D.drawRoundRect((int) rec.getX()+k,(int) rec.getY()+AJOUT_SUR_ABSCISSE, (int) rec.getWidth(), (int) rec.getHeight(), ABSCISSE, ORDONNEE);
            g2D.drawString(p.getListeCarte().get(i).getValeur(), (int) rec.getX() +k+c, (int) rec.getY() + LARGEUR);
            g2D.drawString(p.getListeCarte().get(i).getCouleur(), (int) rec.getX() +k+c, (int) rec.getY() + AJOUT_SUR_LARGEUR);
           
            k += AJOUT_SUR_HAUTEUR;
        }
    }
    /**
     * un getter pour l'attribut selectedCard
     * @return la valeur de l'attribut
     */
    public int getSelectedCard()
    {
        return selectedCard;
    }
    /**
     * change la valeur de l'attribut selectedCard
     * @param i nouvelle valeur de l'attribut
     */
    public void setSelectedCard(int i)
    {
        this.selectedCard=i;
        /**
         * on met à jour la vue
         */
        repaint();
    }
    /**
     * @return l'attribut rec
     */
    public Rectangle2D getRect(){
        return this.rec;
    }

}
