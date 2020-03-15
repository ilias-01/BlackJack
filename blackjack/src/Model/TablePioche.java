
package Model;

import model.Paquet;

/**
 *
 * Classe  contient un paquet qui représente la pioche 
 */
public class TablePioche{
    private Paquet pioche;
    /**
     * 
     * @param pioche  paquet de cartes 
     */
    public TablePioche(Paquet pioche){
        this.pioche=pioche;
    }
    /**
     * 
     * @return  revoie le paquet des cartes représentant la pioche 
     */
    public Paquet getPioche(){
        return this.pioche;
    }
    
}
