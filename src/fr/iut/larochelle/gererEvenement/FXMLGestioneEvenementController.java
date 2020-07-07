package fr.iut.larochelle.gererEvenement;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

/**
 * <h1> Controller Gerer un Evenement</h1>
 *
 * FXML controller, permettant d'acceder à la Evenement d'utilisateur
 * dans la base de données.
 *
 * @author maxime, kyllian
 */

public class FXMLGestioneEvenementController implements Initializable {
    
    @FXML
    private Button btnQuitter;
    private Window sPrimaryStage;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public void quitter(){
        Stage fenetre = (Stage)btnQuitter.getScene().getWindow();
        fenetre.close();
    }
    
    /**
     * <h2>Acceder à l'interface d'ajout d'evenement</h2>
     * Permet d'ajouter un evenement a la BD.
     * @author kyllian
     * @throws IOException
     */    
    public void accederAjouterEvenement() throws IOException{
        FXMLLoader leLoader = new FXMLLoader (getClass().getResource("/fr/iut/larochelle/gererEvenement/FXMLAjouterEvent.fxml") ) ;
        AnchorPane laPage = (AnchorPane) leLoader.load();
        Stage fenetreSecondaire= new Stage() ;
        
        StageStyle stageStyle = StageStyle.UTILITY; //Fenetre "minimaliste"
        fenetreSecondaire.initStyle(stageStyle);
        
        fenetreSecondaire.setResizable(false);      //on empeche le redimentionnement de la fenetre
        
        fenetreSecondaire.setTitle("Ajouter un Evenement") ;
        fenetreSecondaire.initModality(Modality.WINDOW_MODAL) ;
        fenetreSecondaire.initOwner(this.sPrimaryStage);
        Scene laScene = new Scene(laPage);
        fenetreSecondaire.setScene( laScene);
        
        FXMLAjouterEventController leController;       //Création du Controller associé à la fenêtre secondaire
        
        leController = leLoader.getController();
        fenetreSecondaire.showAndWait() ;
    }
    
    /**
     * <h2>Acceder à l'interface de modification d'evenement</h2>
     * Permet de modifier un evenement dans la BD.
     * @author kyllian
     * @throws IOException
     */    
    public void accederModifierEvenement() throws IOException{
        FXMLLoader leLoader = new FXMLLoader (getClass().getResource("/fr/iut/larochelle/gererEvenement/FXMLModifierEvenement.fxml") ) ;
        AnchorPane laPage = (AnchorPane) leLoader.load();
        Stage fenetreSecondaire= new Stage() ;
        
        StageStyle stageStyle = StageStyle.UTILITY; //Fenetre "minimaliste"
        fenetreSecondaire.initStyle(stageStyle);
        
        fenetreSecondaire.setResizable(false);      //on empeche le redimentionnement de la fenetre
        
        fenetreSecondaire.setTitle("Modifier un Evenement") ;
        fenetreSecondaire.initModality(Modality.WINDOW_MODAL) ;
        fenetreSecondaire.initOwner(this.sPrimaryStage);
        Scene laScene = new Scene(laPage);
        fenetreSecondaire.setScene( laScene);
        
        FXMLModifierEvenementController leController;       //Création du Controller associé à la fenêtre secondaire
        
        leController = leLoader.getController();
        fenetreSecondaire.showAndWait() ;
    }
    
    /**
     * <h2>Acceder à l'interface pour supprimer un evenement</h2>
     * Permet de supprimer un evenement dans la BD.
     * @author kyllian
     * @throws IOException
     */    
    public void accederSupprimerEvenement() throws IOException{
        FXMLLoader leLoader = new FXMLLoader (getClass().getResource("/fr/iut/larochelle/gererEvenement/FXMLSupprimerEvenement.fxml") ) ;
        AnchorPane laPage = (AnchorPane) leLoader.load();
        Stage fenetreSecondaire= new Stage() ;
        
        StageStyle stageStyle = StageStyle.UTILITY; //Fenetre "minimaliste"
        fenetreSecondaire.initStyle(stageStyle);
        
        fenetreSecondaire.setResizable(false);      //on empeche le redimentionnement de la fenetre
        
        fenetreSecondaire.setTitle("Supprimer un Evenement") ;
        fenetreSecondaire.initModality(Modality.WINDOW_MODAL) ;
        fenetreSecondaire.initOwner(this.sPrimaryStage);
        Scene laScene = new Scene(laPage);
        fenetreSecondaire.setScene( laScene);
        
        FXMLSupprimerEvenementController leController;       //Création du Controller associé à la fenêtre secondaire
        
        leController = leLoader.getController();
        fenetreSecondaire.showAndWait() ;
    }
    
    
    
    
}
