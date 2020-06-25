package PTS2.gererUtilisateur;

import PTS2.DataBase.UtilisateurDAO;
import PTS2.modele.Niveau;
import PTS2.modele.Utilisateur;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;



public class FXMLSupprimerUtilisateurController implements Initializable {
    
    /**
     * Initializes the controller class.
     */
    
    @FXML
    private ComboBox cbNiveau;
    
    @FXML
    private TableView<Utilisateur> tableview;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.cbNiveau.setItems(FXCollections.observableArrayList(Niveau.values()));
    }
    
    /**
     * <h1> Controller Supprimer un Utilisateur</h1>
     *
     * FXML controller, permettant de supprimer un utilisateur
     * dans la base de données.
     *
     * @author maxim
     */
    public void supprimerUser(){
        UtilisateurDAO userDAO = new UtilisateurDAO();
        Utilisateur user = tableview.getSelectionModel().getSelectedItem();
        userDAO.removeUtilisateur(user);
    }
}
