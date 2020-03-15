/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import java.awt.Graphics;
import model.Paquet;
import vue.VuePaquetVisible;

/**
 *
 * classe qui représente la vue de la main d'un Joueur 
 * la main du joueur est un paquet de cartes de vue visible -- hérite de la classe VuePaquetVisible définie à la bibliothèque Cartes
 */
public class VueJoueur extends VuePaquetVisible{
    
    public VueJoueur(Paquet mainJoueur) {
        super(mainJoueur);
    }
    
    @Override
    public void paintComponent(Graphics g){
    super.paintComponent(g);
    
    }
}
