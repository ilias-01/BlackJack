/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;


import java.util.ArrayList;
import java.util.List;

/**
 * Classe abstraite qui utilise les deux interfaces créées
 */
public abstract class AbstractPaquetEcoutable implements PaquetEcoutable
{
    /**
     * liste des écouteurs sur le modèle
     */
    private List<EcouteurPaquet> ecouteur;
    
    /**
     * contructeur pour créer la liste vide
     */
    public AbstractPaquetEcoutable(){
        this.ecouteur  = new ArrayList<EcouteurPaquet>();
    }
    /**
     * ajoute un écouteur dans la liste
     * @param e l'écouteur à jouter
     */
    @Override
    public void ajoutEcouteur(EcouteurPaquet e){
        this.ecouteur.add(e);
    }
    
    /**
     * supprime un écouteur de la liste
     * @param e l'couteur à supprimer
     */
    @Override
    public void retraitEcouteur(EcouteurPaquet e){
        this.ecouteur.remove(e);
    }
    /**
     * la mise à jour du modèle
     */
    public void changement(){
        for(EcouteurPaquet e: this.ecouteur){
            e.paquetMiseAJour(this);
        }
    }

}
