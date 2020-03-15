
package Controlleur;

import Model.Croupier;
import Model.Joueur;
import Model.Robots;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * Classe qui représente le controleur entre le modele et la vue 
 */
public class ControleurPiocheJoueur {
    /**
     * insctance du croupier 
     */
    private Croupier croupier;
    /**
     * 
     * @param croupier  instance de la  classe Croupier
     */
    public ControleurPiocheJoueur(Croupier croupier) {

        this.croupier = croupier;
    }
    
    /**
     * @param joueur joueur à qui on distribue un carte
     * méthode qui distribue une carte au joueur passé en paramètre et suprime cette carte de la pioche passant par le croupier
     */
    public void donnerCarte(Joueur joueur) {
        if(joueur instanceof Croupier){
          this.croupier.getMainJoueur().addCardDebut(this.croupier.getTable().getPioche().getListeCarte().get(0));
          this.croupier.getTable().getPioche().getListeCarte().remove(0);
          this.croupier.calculePoid();
        }else if(this.croupier.getListPlayer().contains(joueur)){
            
            joueur.getMainJoueur().addCardDebut(this.croupier.getTable().getPioche().getListeCarte().get(0));
            this.croupier.getTable().getPioche().getListeCarte().remove(0);
            joueur.calculePoid();
            } 
    }
    
    /**
     * méthode qui qui fait une distribution initial --donner deux cartes à chaque joueur et au croupier aussi-- 
     * à travers l'objet croupier
     *
     */
    public void distribuerInit(){
        this.donnerCarte(this.croupier);
        this.donnerCarte(this.croupier);

        for (Joueur player : this.croupier.getListPlayer()) {
            this.donnerCarte(player);
            this.donnerCarte(player);
        }
    }
    
    /**
     * methode pour mettre à jour les mises des joueurs gagnants et perdants 
     * on double la mise du joueur gagnant  
     * @param joueurPerdant : instance de joueur  supposé perdant
     * @param joueurGagnant : instance de joueur  supposé gagnant
     */
    public void operationsSurMise(Joueur joueurPerdant, Joueur joueurGagnant) {
        if (joueurPerdant instanceof Croupier){
            this.croupier.setMise(this.croupier.getMise()-joueurGagnant.getMise());
            double gaintJoueur = joueurGagnant.getMise()*2;
            joueurGagnant.setMise(gaintJoueur);
        } else {
            double caisseBanque = joueurPerdant.getMise() + joueurGagnant.getMise();
            joueurGagnant.setMise(caisseBanque);
        }
    }
    /**
     * methode qui suprimme les joueurs de la liste des joueurs du croupier , qui ont comme poid > 21
     * @param listeJoueurs 
     */
    public void supprimeJoueursPerdants(List<Joueur> listeJoueurs) {

        for (int i = 0; i < listeJoueurs.size(); i++) {
            if (listeJoueurs.get(i).getPoids() > 21) {
                this.operationsSurMise(listeJoueurs.get(i), croupier);
                
                listeJoueurs.remove(i);
            }
        }
    }
    /**
     * 
     * methode qui représente le tour des joueurs fictifs -robot-
     * au début de chaque tour de robot en supprime les joueurs perdants
     * on distribue au robot une care tant qu'il demande une carte --boucle while()--
     * le croupier passe au joueur suivant s'il ne demande plus de carte 
     */
    public void gestionRobots() {
        Robots r = ((Robots) this.croupier.getJoueurCourant());
        this.supprimeJoueursPerdants(this.croupier.getListPlayer());
          while(r.demanderCarte()==true)
          {
              this.donnerCarte(r);
                        
          }
          this.croupier.donnerTour();
    }
    /**
     * le jeu se termine si le poid du croupier > 17 
     * ou la liste des joueurs du croupier est  vide -tout les joueurs ont perdu-
     * @return envoie true si le jeu et terminer si non false 
     */
    public boolean gameOver() {
        return this.croupier.getPoids() > 17 || this.croupier.getListPlayer().isEmpty();
    }
    
    /**
     * si le jeu est terminé ( gameOver renvoie true ) on supprime les joueurs perdant da la liste du croupier 
     * si le croupier à plus que 21 tout les joueurs ont gagné , on les ajoute dans la liste des gagnants
     * si non ajoute à la liste seulement les joueurs qui ont un poid supérieur au poid du croupier 
     * @return envoie la liste des joueurs gagnant  quand le jeu est terminé 
     */
    public Set<Joueur> gagnants() {
        Set<Joueur> listeGagnants = new HashSet<Joueur>();

        if(this.gameOver()==true){
            this.supprimeJoueursPerdants(this.croupier.getListPlayer());
            if (this.croupier.getPoids() > 21) {
                for (Joueur j : this.croupier.getListPlayer()) {
                    this.operationsSurMise(croupier, j);
                    listeGagnants.add(j);
                }
            } else {
                for (Joueur j : this.croupier.getListPlayer()) {
                    if (j.getPoids() > this.croupier.getPoids()) {
                        listeGagnants.add(j);
                        this.operationsSurMise(croupier, j);
                    } else {
                        listeGagnants.add(this.croupier);
                        this.operationsSurMise(j, this.croupier);
                    }
                }
            }
            if(listeGagnants.isEmpty() && this.croupier.getPoids()<21){
                listeGagnants.add(this.croupier);
            }
            return listeGagnants;
        }
        return null;
    }
    /**
     * méthode qui fait attendre le joueur humain le nombre des secondes qu'on a passé au paramétre 
     * @param nbreSecondes  :  entier qui représente le nombre des secondess
     */
    public void attente(int nbreSecondes){
		int wait = nbreSecondes*1000;
		Date date = new Date();
		long debut = date.getTime();
		long somme = debut + wait;
		
		while(debut<somme)
		{
			date = new Date();
			debut = date.getTime();
		}
    }
    /**
     * 
     * @return  renvoie l'attribut croupier du controleur
     */
    public Croupier getCroupier(){
        return this.croupier;
    }
}
