/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PTS2.modele;

/**
 *<h1>Classe Administrateur</h1>
 * @author yoann
 */
public class Administrateur extends Professeur {

    public Administrateur(String username, String password, Matiere matiere) {
        super(username, password, matiere);
    }


	/**
	 * 
	 * @param username
	 * @param password
	 */
	public void inscrire(String username, String password) {
		
	}
        /**
         * <h2>Desinscrire un etudiant</h2>
         * @param username nom d'utilisateur
         */
        
        public void desinscrire(String username) {
            // TODO - implement Administrateur.inscrire
            throw new UnsupportedOperationException();
        }
        
}
