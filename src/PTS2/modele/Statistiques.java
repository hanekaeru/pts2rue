/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PTS2.modele;

import PTS2.DataBase.StatistiqueDAO;
import java.sql.SQLException;

/**
 * <h1> Statistiques </h1>
 * 
 * Classe Statistiques permettant de calculer à l'aide de la
 * base de données les statistiques de l'onglet Stats de l'application.
 * 
 * @author maxim
 */

public class Statistiques {
        private int nombreQuestion;
	private int nombreBonnesQuestions;
	private int nombreQuestionsRepondues;
	private float vitesseMoyenne;
	private int meilleureSerieBonneReponse;
	private int meilleurClassement;
	private int meilleurNombreDePointSemaine;
	private int nombreGagnant;
        public  float tempsReponse;
        
        public Statistiques(int nombreQuestion, int nombreBonnesQuestions, int nombreQuestionsRepondues, float vitesseMoyenne, int meilleureSerieBonneReponse, int meilleurClassement, int meilleurNombreDePointSemaine, int nombreGagnant, float tempsReponse)
        {
            this.nombreQuestion = nombreQuestion;
            this.nombreBonnesQuestions = nombreBonnesQuestions;
            this.nombreQuestionsRepondues = nombreQuestionsRepondues;
            this.vitesseMoyenne = vitesseMoyenne;
            this.meilleureSerieBonneReponse = meilleureSerieBonneReponse;
            this.meilleurClassement = meilleurClassement;
            this.meilleurNombreDePointSemaine = meilleurNombreDePointSemaine;
            this.nombreGagnant = nombreGagnant;
            this.tempsReponse = tempsReponse;
        }
        
        public Statistiques(){}
        

        
        /**
         * Le nombre total de questions soumises à l'étudiant (commun à tous) 
         * @author Kylian
         * @return le nombre de question au format int
         */
	public int getNombreQuestion() {
		return this.nombreQuestion;
	}
        /**
         * Le nombre total de questions soumises à l'étudiant (commun à tous) 
         * @author Martin
         * @return le nombre de question au format String
         */
	public String getNombreQuestionString() {
		return (""+this.nombreQuestion);
	}
        
        
        
        /**
         * Le nombre total de bonnes réponses de l'étudiant 
         * @author Kylian
         * @return le nombre de bonnes réponses au format int
         */
	public int getNombreBonnesReponses() {
		return this.nombreBonnesQuestions;
	}
        /**
         * Le nombre total de bonnes réponses de l'étudiant 
         * @author Martin
         * @return le nombre de bonnes réponses au format String
         */
	public String getNombreBonnesReponsesString() {
		return ""+this.nombreBonnesQuestions;
	}
        /**
         * Ajoute une bonne réponse 
         * @author Martin
     * @throws java.sql.SQLException
         */
        public void ajouterBonneReponse() throws SQLException{
            this.nombreBonnesQuestions ++;
            StatistiqueDAO statsDAO = new StatistiqueDAO();
            String username = Utilisateur.username;
            statsDAO.setAttribut(username, "nombreBonnesQuestions", this.getNombreBonnesReponses());
        }

        
        
        /**
         * Le nombre total de questions répondues par l'étudiant 
         * @author Kylian
         * @return le nombre de questions répondues au format int
         */
	public int getNombreQuestionsRepondues() {
		return this.nombreQuestionsRepondues;
	}
        /**
         * Le nombre total de questions répondues par l'étudiant 
         * @author Martin
         * @return le nombre de questions répondues au format String
         */
	public String getNombreQuestionsReponduesString() {
		return ""+this.nombreQuestionsRepondues;
	}
	/**
	 * Enregistre le nombre de questions répondues dans la base de données
	 * @author Martin
         * @throws java.sql.SQLException
	 */
	public void setNombreQuestionsRepondues() throws SQLException {
            StatistiqueDAO statsDAO = new StatistiqueDAO();
            String username = Utilisateur.username;
            statsDAO.setAttribut(username, "nombreQuestionsRepondues", this.getNombreQuestionsRepondues());
        }
        
        
        
        
        /**
         * La vitesse de réponse moyenne de l'étudiant 
         * @author Kylian
         * @return La vitesse de réponse moyenne au format float
         */
	public float getVitesseMoyenne() {
		return this.vitesseMoyenne;
	}
        /**
         * La vitesse de réponse moyenne de l'étudiant 
         * @author Martin
         * @return La vitesse de réponse moyenne au format String
         */
	public String getVitesseMoyenneString() {
		return ""+this.vitesseMoyenne;
	}
        /** 
         * Permet de mettre à jour dans le modèle et la base de donnée la vitesse moyenne
         * @param vitesseMoyenne La nouvelle vitesse moyenne
         * @author Maxine & Martin
         * @throws java.sql.SQLException
         */
	public void setVitesseMoyenne(float vitesseMoyenne) throws SQLException
        {
            vitesseMoyenne = tempsReponse / nombreQuestionsRepondues;
            StatistiqueDAO statsDAO = new StatistiqueDAO();
            String username = Utilisateur.username;
            statsDAO.setAttribut(username, "vitesseMoyenne", Integer.parseInt(this.getVitesseMoyenneString()));
        }
        
        
        
        
        /**
         * La meilleure série de bonnes réponses d'affilée de l'étudiant 
         * @author Kylian
         * @return La meilleure série au format int
         */
	public int getMeilleureSerieBonneReponse() {
		return this.meilleureSerieBonneReponse;
	}
        /**
         * La meilleure série de bonnes réponses d'affilée de l'étudiant 
         * @author Martin
         * @return La meilleure série au format String
         */
	public String getMeilleureSerieBonneReponseString() {
		return ""+this.meilleureSerieBonneReponse;
	}
	/**
	 * Permet la mise à jour du modèle et l'enregistrement dans la base de donnée de la meilleure série
         * @author Martin
     * @throws java.sql.SQLException
	 */
	public void setMeilleureSerieBonneReponse() throws SQLException {
            this.meilleureSerieBonneReponse++;
            StatistiqueDAO statsDAO = new StatistiqueDAO();
            String username = Utilisateur.username;
            statsDAO.setAttribut(username, "meilleureSerieBonnesReponses", this.getMeilleureSerieBonneReponse());
	}

        
        
        
        /**
         * Le meilleur classement de l'étudiant 
         * @author Kylian
         * @return Le meilleur classement au format int
         */
	public int getMeilleurClassement() {
		return this.meilleurClassement;
	}
        /**
         * Le meilleur classement de l'étudiant 
         * @author Martin
         * @return Le meilleur classement au format String
         */
	public String getMeilleurClassementString() {
		return ""+ this.meilleurClassement;
	}
	/**
	 * Permet la mise à jour du modèle et l'nregistrement dans la base de données du meilleur classement
         * @author Martin
	 * @param meilleurClassement le nouveau meilleur classement
         * @throws java.sql.SQLException
	 */
	public void setMeilleurClassement(int meilleurClassement) throws SQLException {
            StatistiqueDAO statsDAO = new StatistiqueDAO();
            String username = Utilisateur.username;
            statsDAO.setAttribut(username, "meilleurClassement", this.getMeilleurClassement());
	}

        
        
        /**
         * Le meilleur nombre de points gagnés en une semaine par l'étudiant 
         * @author Kylian
         * @return Le meilleur classement au format int
         */
	public int getMeilleurNombreDePointSemaine() {
		return this.meilleurNombreDePointSemaine;
	}
        /**
         * Le meilleur nombre de points gagnés en une semaine par l'étudiant 
         * @author Martin
         * @return Le meilleur classement au format String
         */
	public String getMeilleurNombreDePointSemaineString() {
		return ""+ this.meilleurNombreDePointSemaine;
	}
	/**
	 * Permet d'enregistrer dans la base données le meileur nombre de points gagnés
         * @author Martin
         * @param meilleurNombreDePointSemaine
         * @throws java.sql.SQLException
	 */
	public void setMeilleurNombreDePointSemaine(int meilleurNombreDePointSemaine) throws SQLException {
            StatistiqueDAO statsDAO = new StatistiqueDAO();
            String username = Utilisateur.username;
            statsDAO.setAttribut(username, "meilleurNombreDePointsSemaine", this.getMeilleurNombreDePointSemaine());
	}


        
        
        /**
         * Le nombre de fois gagnt dont l'étudiant a été gagnant du jour
         * @author Kylian
         * @return Le meilleur classement au format int
         */
        public int getNombreGagnant() {
            return this.nombreGagnant;
        }
        /**
         * Le nombre de fois gagnt dont l'étudiant a été gagnant du jour
         * @author Martin
         * @return Le meilleur classement au format String
         */
        public String getNombreGagnantString() {
            return ""+this.nombreGagnant;
        }
        /**
         * Permet l'enregistrement dans la base de donnée du nombre de points de l'étudiant
         * @author Martin
         * @param nombreGagnant 
         * @throws java.sql.SQLException 
         */
        public void setNombreGagnant() throws SQLException {
            this.nombreGagnant++;
            StatistiqueDAO statsDAO = new StatistiqueDAO();
            String username = Utilisateur.username;
            statsDAO.setAttribut(username, "nombreDeFoisGagnant", this.getNombreGagnant());
        }
}
