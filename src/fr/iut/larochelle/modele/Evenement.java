package fr.iut.larochelle.modele;

import java.time.LocalDate;

/**
 *
 * @author Enzo
 */
public class Evenement {
    private String messageEvenement;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    
    public Evenement(String messageEvenement, LocalDate dateDebut, LocalDate dateFin) {
        this.messageEvenement = messageEvenement;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }
    
    public String getMessageEvenement() {
        return messageEvenement;
    }
    
    public LocalDate getDateDebut() {
        return dateDebut;
    }
    
    public LocalDate getDateFin() {
        return dateFin;
    }
    
}
