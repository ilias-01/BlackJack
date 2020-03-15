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
 * représente un paquet caché(les cartes sont invisible), utilisée pour la pioche
 * Cette classe hérite de la classe VuePaquet
 * 
 */

public class VuePaquetCache extends VuePaquet{
    /**
     * un rectangle représente une carte
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
     * Construction de la vue d'une pioche
     * @param p le paquet à représenter
     */
    public VuePaquetCache(Paquet p){
        /**
         * appelle du contructeur de la classe mère
         */
        super(p);
        /**
         * initialisation de notre attribut rectangle
         */
        this.rec = new Rectangle2D.Double(X,Y,LARGEUR,HAUTEUR);
    }
    /**
     * la mise à jour de la vue
     * @param p l'objet à mettre à jour
     */
    @Override
    public void paquetMiseAJour(Object p) {
        super.paquetMiseAJour(p); 
         
    }
    
    /**
     * représentation graphique de la pioche(les cartes verticalement avec un petit décalage pour montrer l'épaisseur )
     * @param g l'objet graphique qu'on veut utilise
     */
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        super.paintComponent(g);
        
        for (int i = 0; i < p.getListeCarte().size(); i++) {   
           g2D.drawRoundRect((int)rec.getX()+i, (int)rec.getY()+i, (int)rec.getWidth(), (int)rec.getHeight(),ABSCISSE, ORDONNEE);
           if(i<p.getListeCarte().size()-1){
               g2D.setColor(Color.black);
           }else{
               g2D.setColor(Color.white);
               g2D.fillRoundRect((int)rec.getX()+i, (int)rec.getY()+i, (int)rec.getWidth(), (int)rec.getHeight(),ABSCISSE, ORDONNEE);
           }
        }
  }
}
