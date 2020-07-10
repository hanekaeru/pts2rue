package fr.iut.larochelle.gererUtilisateur;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

/**
 * <h1> Controller Gerer un Utilisateur</h1>
 *
 * FXML controller, permettant d'acceder à la gestion d'utilisateur
 * dans la base de données.
 *
 * @author maxime
 */
public class FXMLGererUtilisateurController implements Initializable {
    
    @FXML
    private Button btnQuitter;
    @FXML
    private ImageView btnAddUser;
    @FXML
    private ImageView btnSupprUser;
    @FXML
    private ImageView btnModifUser;
    
    private Window sPrimaryStage;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public void quitter(){
        Stage fenetre = (Stage)btnQuitter.getScene().getWindow();
        fenetre.close();
    }
    
    
    public void accederAjouterUtilisateur() throws IOException{
        FXMLLoader leLoader = new FXMLLoader (getClass().getResource("/fr/iut/larochelle/gererUtilisateur/FXMLAjouterUtilisateur.fxml") ) ;
        AnchorPane laPage = (AnchorPane) leLoader.load();
        Stage fenetreSecondaire = new Stage(StageStyle.UTILITY);
        
        fenetreSecondaire.setResizable(false);      // On empeche le redimensionnement de la fenetre
        
        fenetreSecondaire.setTitle("Ajouter un Utilisateur") ;
        fenetreSecondaire.initModality(Modality.WINDOW_MODAL) ;
        fenetreSecondaire.initOwner(this.sPrimaryStage);
        Scene laScene = new Scene(laPage);
        fenetreSecondaire.setScene(laScene);

        fenetreSecondaire.showAndWait();
    }
    
    
    public void accederModifierUtilisateur() throws IOException{
        FXMLLoader leLoader = new FXMLLoader (getClass().getResource("/fr/iut/larochelle/gererUtilisateur/FXMLModifierUtilisateur.fxml") ) ;
        AnchorPane laPage = (AnchorPane) leLoader.load();
        Stage fenetreSecondaire = new Stage(StageStyle.UTILITY);
        
        fenetreSecondaire.setResizable(false);      // On empeche le redimensionnement de la fenetre
        
        fenetreSecondaire.setTitle("Modifier un Utilisateur") ;
        fenetreSecondaire.initModality(Modality.WINDOW_MODAL) ;
        fenetreSecondaire.initOwner(this.sPrimaryStage);
        Scene laScene = new Scene(laPage);
        fenetreSecondaire.setScene(laScene);

        fenetreSecondaire.showAndWait();
    }
    
    /*
    
    Création d'une méthode qui permet d'accéder à la fenêtre "Supprimer un utilisateur"
    
    */
    
    public void accederSupprimerUtilisateur() throws IOException{
        FXMLLoader leLoader = new FXMLLoader (getClass().getResource("/fr/iut/larochelle/gererUtilisateur/FXMLSupprimerUtilisateur.fxml") ) ;
        AnchorPane laPage = (AnchorPane) leLoader.load();
        Stage fenetreSecondaire = new Stage(StageStyle.UTILITY);
        
        fenetreSecondaire.setResizable(false);      // On empeche le redimensionnement de la fenetre
        
        fenetreSecondaire.setTitle("Supprimer un Utilisateur") ;
        fenetreSecondaire.initModality(Modality.WINDOW_MODAL) ;
        fenetreSecondaire.initOwner(this.sPrimaryStage);
        Scene laScene = new Scene(laPage);
        fenetreSecondaire.setScene(laScene);

        fenetreSecondaire.showAndWait();
    }
    
    
    
}
