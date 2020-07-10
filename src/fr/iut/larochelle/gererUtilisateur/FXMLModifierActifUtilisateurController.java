package fr.iut.larochelle.gererUtilisateur;

import fr.iut.larochelle.modele.Niveau;
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
 * @author maxime
 */
public class FXMLModifierActifUtilisateurController implements Initializable {
    
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
