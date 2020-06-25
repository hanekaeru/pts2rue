/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PTS2.gererUtilisateur;

import PTS2.modele.Niveau;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

/**
 * <h1> Controller Modifer Actif un Utilisateur</h1>
 * 
 * FXML controller, permettant de modifier un utilisateur
 * dans la base de données.
 *
 * @author maxim
 */

public class FXMLModifierActifUtilisateurController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private ComboBox cbNiveau;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.cbNiveau.setItems(FXCollections.observableArrayList(Niveau.values()));
    }    
    
    public void sauvegarderUser(){
        
    }
    
}
