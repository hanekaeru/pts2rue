/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PTS2.modele;

/**
 *
 * @author yoann
 */
public class Etudiant extends Utilisateur {
        private Niveau niveau;
	private Statistiques statistiques;
	private int classement;
	private int points;

    public Etudiant(String username, String password, Niveau niveau, Statistiques statistiques, int classement, int points) {
        super(username, password);
        this.niveau=niveau;
        this.statistiques=statistiques;
        this.classement=classement;
        this.points=points;
    }

	public void repondre() {
		// TODO - implement Etudiant.repondre
		throw new UnsupportedOperationException();
	}

	public int getClassement() {
            return this.classement;
	}

	/**
	 * 
	 * @param classement
	 */
	public void setClassement(int classement) {
            
            //  Parcours de la ArrayList des étudiants
            //   
            //  Un tri est fait comme celui étudié lors du S1 qui permet de trier par ordre croissant des classements de bonnes réponses.
            //
            //
            
            this.statistiques.getNombreBonnesReponses();
            this.classement = classement;
	}

	/**
	 * 
	 * @param points
	 */
	public void ajouterPoints(int points) {
		// TODO - implement Etudiant.ajouterPoints
		throw new UnsupportedOperationException();
	}

	public int getPoints() {
		return this.points;
	}

	public void posterMessageSemaine() {
		// TODO - implement Etudiant.posterMessageSemaine
		throw new UnsupportedOperationException();
	}

    public Niveau getNiveau() {
        return niveau;
    }

    public Statistiques getStatistiques() {
        return statistiques;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    public void setStatistiques(Statistiques statistiques) {
        this.statistiques = statistiques;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}

