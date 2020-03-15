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

/**
 * Contrôleur qui gère le choix d'une carte vers un paquet 
 * (de la main du joueur vers la défausse)
 */
public class ControleurChoixCarteVersPaquet {
    /**
     * carte qu'on veut envoyer
     */
   private Carte carteSource;
   /**
    * la vue d'où vient la carte
    */
   private VuePaquetVisible vuesource;
   /**
    * le paquet vers où on envoie la carte
    */
   private Paquet destination;
   
   /**
    * Constructeur
    * @param vueSource la vue d'où vient la carte
    * @param destination le paquet vers où on envoie la carte
    */
    public ControleurChoixCarteVersPaquet(VuePaquetVisible vueSource, Paquet destination){
        /**
         * si la carte se trouve dans le paquet, on l'ajoute dans le paquet de destination
         * puis on la supprime de la main du joueur
         */
        if(vueSource.getP().getListeCarte().contains(this.carteSource))   
        {
          destination.addCardDebut(carteSource);
          vuesource.getP().getListeCarte().remove(carteSource);
        }
        /**
         * initialisation des attributs
         */
        this.vuesource = vueSource;
        this.destination = destination;
     }
}
