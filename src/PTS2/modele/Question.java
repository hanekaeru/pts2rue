/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PTS2.modele;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Martin
 */
public class Question {
    
    private Matiere matiere;
    private Niveau niveau;
    private LocalDate datePubliee;
    private String question;
    private String bonneReponse;
    private ArrayList<String> reponses;
    private String image;
    private UE ue;
    private Professeur professeur; 

    public Question(Matiere matiere, Niveau niveau, LocalDate datePubliee, String question, String bonneReponse, ArrayList<String> reponses, UE ue, Professeur professeur) {
        this.matiere = matiere;
        this.niveau = niveau;
        this.datePubliee = datePubliee;
        this.question = question;
        this.bonneReponse = bonneReponse;
        this.reponses = reponses;
        this.ue = ue;
        this.professeur = professeur;
        this.image = " ";
    }
    
    public Question(Matiere matiere, Niveau niveau, LocalDate datePubliee, String question, String bonneReponse, ArrayList<String> reponses, UE ue) {
        this.matiere = matiere;
        this.niveau = niveau;
        this.datePubliee = datePubliee;
        this.question = question;
        this.bonneReponse = bonneReponse;
        this.reponses = reponses;
        this.ue = ue;
        this.image = " ";
    }


    
    
    public void setImage(String image)
    {
        this.image = image;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public LocalDate getDatePubliee() {
        return datePubliee;
    }

    public String getQuestion() {
        return question;
    }

    public String getBonneReponse() {
        return bonneReponse;
    }

    public ArrayList<String> getReponses() {
        return reponses;
    }

    public String getImage() {
        return image;
    }

    public UE getUe() {
        return ue;
    }

    public Professeur getProfesseur() {
        return professeur;
    }

    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }
    
    
}
