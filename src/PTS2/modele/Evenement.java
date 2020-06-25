/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PTS2.modele;

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
