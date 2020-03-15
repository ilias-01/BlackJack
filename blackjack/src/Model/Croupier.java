
package Model;

import java.util.ArrayList;
import java.util.List;
import model.Paquet;

/**
 *
 * Classe qui représente le Croupier en BlackJack -- hérite de la classe Joueur
 */
public class Croupier extends Joueur {
    /**
     *  joueurCourant : attribut qui représente  le joueur qui est dans  son tour  pour jouer
     */
    private List<Joueur> listPlayer=new ArrayList<Joueur>();
    private TablePioche table;
    private Joueur joueurCourant;
    /**
     * 
     * @param nom        nom du croupier 
     * @param caisse     équivalente de la mise pour les autres joueurs 
     * @param listplayer liste des joueurs dans la partie
     * @param table      attribut de type TablePioche qui contient la pioche
     */
    public Croupier(String nom, double caisse, List<Joueur> listplayer,TablePioche table){
        super(nom, caisse);
        this.table=table;
        this.listPlayer = listplayer;
        this.joueurCourant = listplayer.get(0);
    }

    /**
     * methode qui change le JoueurCourant 
     * on change le joueurCourant en  passant au joueur qui lle suit dans la liste des joueurs  à l'aide de son  l'indice 
     * si on ai à la fin de la liste on revient au joueur qui est  à l'indice 0 
     */
    public void donnerTour(){
        int nbrJoueur=this.listPlayer.size();
        int indexJoueurCourant=this.listPlayer.indexOf(this.joueurCourant);
        if(indexJoueurCourant==nbrJoueur-1){
            indexJoueurCourant=0;
        }
        else{
            indexJoueurCourant++;
        }
        if(!this.listPlayer.isEmpty()){
        this.joueurCourant=listPlayer.get(indexJoueurCourant);
        }
    }

    /**
     * 
     * @return renvoie la liste des joueurs du croupier
     */
    public List<Joueur> getListPlayer() {
    return this.listPlayer;
    }
    /**
     * 
     * @return  renvoie l'objet table qui contient la pioche
     */
    public TablePioche getTable() {
        return this.table;
    }
    /**
     * 
     * @return  renvoie le joueur courant  
     */
    public Joueur getJoueurCourant(){
        return this.joueurCourant;
    }
}
