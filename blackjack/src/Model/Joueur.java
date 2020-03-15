
package Model;

import model.Carte;
import model.Paquet;
import model.PaquetFactory;



/**
 * 
 * Classe abstaraite commune à tout joueur
 */
public abstract class Joueur {
    /**
     *  mainJoueur : attribut des cartes à  la main du joueur représenté par un paquet
     *  poid       : la sommme des valeurs des cartes
     */
    private Paquet mainJoueur;
    private String nom;
    private int poids;
    private double mise;
    /**
     * 
     * @param nom  le nom donner au joueur
     * @param mise  la mise du joueur 
     */
    public Joueur(String nom, double mise) {
        this.mainJoueur = PaquetFactory.createPaquet(0);
        this.poids = 0;
        this.mise = mise;
        this.nom = nom;
    }
    /**
     * 
     * @return renvoie le nom du joueur
     */
    public String getNomJoueur(){
        return this.nom;
    }
    /**
     * 
     * @return revoie le poid de la main du joueur
     */
    public int getPoids() {
        return poids;
    }
    /**
     * 
     * @param gain le gain du joueur après la fin de la  partie 
     * change la valeur de la mise 
     */
    public void setMise(double gain){
        this.mise=gain;
    }
    /**
     * 
     * @return  renvoie la mise du joueur
     */
    public double getMise(){
        return this.mise;
    }
    /**
     * 
     * @return revoie le paquet de la main du joueur 
     */
    public Paquet getMainJoueur() {
        return mainJoueur;
    }
    /**
     * modifie  le paquet MainJoeur
     * @param mainJoueur  paquet qui représente la main du Joueur 
     */
    public void setMainJoueur(Paquet mainJoueur) {
        this.mainJoueur = mainJoueur;
    }
    /**
     * methode qui calcule le poid de de l'ensemble des cartes de la main du joueur 
     */
    public void calculePoid() {
        this.poids = 0; 
        for (Carte carte : this.mainJoueur.getListeCarte()) {
            if(!carte.getValeur().equalsIgnoreCase("AS") && !carte.getValeur().equalsIgnoreCase("J") && !carte.getValeur().equalsIgnoreCase("K") 
                    && !carte.getValeur().equalsIgnoreCase("Q")){
                int poidsCarte = Integer.parseInt(carte.getValeur());
                 this.poids += poidsCarte;
            }else if(carte.getValeur().equalsIgnoreCase("AS")) {
                int a = this.poids +11;
                if(a <=21){
                    this.poids +=11;
                }else{
                this.poids +=1;
                }
            } else {
                this.poids += 10;
            }
        }
    }
    /**
     * methode qui double la mise du joueur
     */
    public void doublerSaMise()
    {
        this.mise*=2;
    }

}
