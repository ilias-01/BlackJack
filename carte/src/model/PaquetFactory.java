/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 * La classe qui crée un paquet de 52 ou 32 cartes, ou un paquet vide
 * @author Pc
 */
public class PaquetFactory {
    /**
     * initialisation des valeurs des cartes
     */
    private static String[] valeur ={"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "AS"};
    /**
     * initialisation des couleurs des cartes
     */
    private static String[] couleur ={"PIQUE", "COEUR", "CARREAU", "TREFLE"};
    /**
     * Crée un paquet de 32/52 cartes ou un paquet vide
     * @param taille la taille du paquet
     * @return le paquet
     */
    public static Paquet createPaquet(int taille){
        /**
         * si la taille est 32 ou 52 on crée le paquet avec cette taille
         */
        if((taille==32) || (taille == 52)){
            Paquet paquet = new Paquet(taille);
            if(taille==52){
                for(int i=0; i<valeur.length; i++){
                    for(int j=0; j<couleur.length; j++){
                       paquet.addCardFin(new Carte(valeur[i], couleur[j]));
                     }
                }
            }else{
                for(int i=5; i<valeur.length; i++){
                    for(int j=0; j<couleur.length; j++){
                       paquet.addCardFin(new Carte(valeur[i], couleur[j]));
                     }
                }
            }
            return paquet;
        }else{
            /**
             * Pour une main initialement vide quand le paquet n'est pas d'une taille 52/32
             */
            return new Paquet(); 
        }
    }
}
