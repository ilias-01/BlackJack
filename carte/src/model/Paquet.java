/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import vue.VuePaquetVisible;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import util.AbstractPaquetEcoutable;

/**
 *
 * @author 21912873
 */

/**
 * Classe qui symbolise un ensemble de cartes
 */
public class Paquet extends AbstractPaquetEcoutable {
    /**
     * Liste qui contient les cartes d'un paquet
     */
    private List<Carte> listCarte;
    /**
     * 
     * @param taille la taille du paquet (nombre de cartes)
     */
    public Paquet(int taille) {
        /**
         * création d'une liste de cartes avec la taille donnée
         */
        this.listCarte = new ArrayList<Carte>(taille);
    }
    /**
     * Création d'un paquet vide
     */
    public Paquet(){
        /**
         * Création d'une liste vide de type Carte
         */
        this.listCarte = new ArrayList<Carte>();
    }
    /**
     * Méthode qui ajoute une carte qu début de la liste d'un paquet
     * @param c La carte à ajouter
     */
    public void addCardDebut(Carte c) {
        /**
         * On ajoute la carte dans le paquet
         */
        listCarte.add(0, c);
        /**
         * On fait une mise à jour du paquet
         */
        changement();
    }

    /**
     * Méthode qui ajoute une Carte à la fin de la liste d'un paquet
     * @param c la carte à ajouter
     */
    public void addCardFin(Carte c) {
        /**
         * On ajoute la carte dans le paquet
         */
        listCarte.add(c);
        /**
         * On fait une mise à jour du paquet
         */
        changement();
    }

    /**
     * Méthode qui tire une carte qu hasard
     * @return la carte tirée
     */
    public Carte tirerAuHasard() {
        /**
         * On crée un random pour l'aléa
         */
        Random ran = new Random();
        /**
         * On choisit aléatoirement l'indice de la carte
         */
        int aleatoire = ran.nextInt(listCarte.size());
        /**
         * On retoure la carte qui se trouve à l'indice trouvé aléatoirement
         */
        return listCarte.get(aleatoire);
    }
    /**
     * méthode qui mélange les cartes d'un paquet
     */
    public void melanger() {
        /**
         * on crée un random
         */
        Random ran = new Random();
        /**
         * Boucle pour le mélange. on itère sur la lise des cartes
         */
        for(int i = 0; i < this.listCarte.size(); i++) {
            /**
             * On choisit un premier indice aléatoirement
             */
            int index1 = ran.nextInt(listCarte.size());
            /**
             * On choisit un deuxième indice aléatoirement
             */
            int index2 = ran.nextInt(listCarte.size());
            /**
             * On crée un trmpon pour l'échange
             */
            Carte tmp = listCarte.get(index1);
            /**
             * On échange les deux cartes
             */
            listCarte.set(index1, listCarte.get(index2));
            listCarte.set(index2, tmp);
        }
      /**
       * la mise à jour du paquet
       */
        changement();
    }
    
    /**
     * méthode qui fait une coupe aléatoire sur un paquet
     */
    public void coupeAleatoire() {
        /**
         * on crée un random
         */
        Random ran = new Random();
        /**
         * on fait la coupe en conservant les trois premières et les trois dernières cartes
         */
        int rand = 3+ran.nextInt(this.listCarte.size()-6);
        /**
         * itération sur l'espace entre les trois premières et les trois dernières cartes
         */
        for(int i=0;i<rand;i++)
        {   
            /**
             * On ajoute la crate tirée dans la liste
             */
            listCarte.add(listCarte.get(i));
            /**
             * on la supprime de la lise
             */
            listCarte.remove(i);
        }
        /**
         * mise à jour du paquet
         */
        changement();
    }
    /**
     * méthode qui change une crte à un indice donné
     * @param c la carte avec laquelle on fait le remplacement
     * @param i l'indice de la carte à remplacer
     */
    public void setCarte(Carte c, int i){
        this.listCarte.set(i, c);
    }
    /**
     * @return retourne la liste des cartes d'un point
     */
    public List<Carte> getListeCarte(){
        return this.listCarte;
    }
    /**
     * méthode qui retourne la carte d'un indice donné
     * @param index l'indice de la carte à renvoyer
     * @return la carte
     */
    public Carte getCarte(int index){
        return this.listCarte.get(index);
    }
    
    
}
