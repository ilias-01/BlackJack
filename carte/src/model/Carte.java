
 
package model;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

/**
 *
 * @author 21814195
 */
/**
 * La classe de l'objet carte
 */
public class Carte extends JComponent{
    
   private String valeur;
   private String couleur;
   /**
    * 
    * @param valeur la valeur de la carte 
    * @param couleur le type de la carte 
    */
    public Carte(String valeur, String couleur) {
        this.valeur = valeur;
        this.couleur = couleur;
    }
    /**
    * @return renvoie la valeur de la carte
    */
    public String getValeur() {
        return valeur;
    }
    /**
    * 
    * @return renvoie le type de la carte
    */
    public String getCouleur() {
        return couleur;
    }
    /**
     * @return renvoie une chaine la valeur et la couleur correspondante
     * à la carte donnée
     */
    @Override
    public String toString() {
        return valeur + " : " + couleur;
    }
    
}
