/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *Une interface qui écoute le modèle
 */
public interface PaquetEcoutable {
    /**
     * méthode qui ajoute un écoteur 
     * @param e écouteur à ajouter
     */
    public void ajoutEcouteur(EcouteurPaquet e);
    /**
     * méthode qui supprime un écoteur 
     * @param e écouteur à supprimer
     */
    public void retraitEcouteur(EcouteurPaquet e);
}
