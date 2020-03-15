
package Model;

import java.util.Random;

/**
 *
 * Classe qui représente un joueur fictif dans le jeu -- hérite de la classe Joueur
 */
public class Robots extends Joueur {
    /**
     * 
     * @param nom  : nom du joueur 
     * @param mise : mise du joueur 
     */
    public Robots(String nom, double mise) {
        super(nom, mise);
    }

    /**
     * @return revoie  un boolean qui représente la décision du joueur fictif s'il veut passer son tour ou demander une carte
     *       true : il demande une carte 
     *       false: passe son tour
     *  si le poid de sa main est inférieur à 12 il demande toujour une carte 
     *  si le poid est proche de 21 ,la décision sera aléatoire
     */
    public boolean demanderCarte() {
        if (this.getPoids() >= 12) {
            if (this.getPoids() >= 21) {
                return false;
            } else {
                Random ran = new Random();
                return ran.nextBoolean();
            }
        } else {
            return true;
        }
    }
}
