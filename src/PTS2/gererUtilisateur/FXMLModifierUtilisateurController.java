package PTS2.gererUtilisateur;

import PTS2.modele.Niveau;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

/**
 * <h1> Controller Modifier un Utilisateur</h1>
 *
 * FXML controller, permettant de modifier un utilisateur
 * dans la base de données.
 *
 * @author maxim
 */
public class FXMLModifierUtilisateurController implements Initializable {
    
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
    
    public void modifierUser(){
        
    }
    
    
    public void recupereDansTableau(){
        
    }
    
}
