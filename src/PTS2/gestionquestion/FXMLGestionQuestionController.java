package PTS2.gestionquestion;

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
 * <h1> Controller Gerer une Question</h1>
 *
 * FXML controller, permettant d'acceder à la gestion d'une question
 * dans la base de données.
 *
 * @author maxim
 */

public class FXMLGestionQuestionController implements Initializable {
    
    @FXML
    private Window sPrimaryStage;
    
    @FXML
    private Button btnQuitter;
    /**
     * Initializes the controller class.
     */
    
    public void quitter(){
        Stage fenetre = (Stage)btnQuitter.getScene().getWindow();
        fenetre.close();
    }
    
    /*
    
    Création d'une méthode qui permet d'accéder à la fenêtre "Ajouter une Question"
    
    */
    
    public void accederAjouterQuestion() throws IOException{
        FXMLLoader leLoader = new FXMLLoader (getClass().getResource("/PTS2/gestionquestion/FXMLAjouterQuestion.fxml") ) ;
        AnchorPane laPage = (AnchorPane) leLoader.load();
        Stage fenetreSecondaire= new Stage() ;
        
        StageStyle stageStyle = StageStyle.UTILITY; //Fenetre "minimaliste"
        fenetreSecondaire.initStyle(stageStyle);
        
        fenetreSecondaire.setResizable(false);      //on empeche le redimentionnement de la fenetre
        
        fenetreSecondaire. setTitle("Ajouter une Question") ;
        fenetreSecondaire.initModality(Modality.WINDOW_MODAL) ;
        fenetreSecondaire.initOwner(this.sPrimaryStage);
        Scene laScene = new Scene(laPage);
        fenetreSecondaire.setScene( laScene);
        
        FXMLAjouterQuestionController leController;       //Création du Controller associé à la fenêtre secondaire
        
        leController = leLoader.getController();
        fenetreSecondaire.showAndWait() ;
    }
    
    /*
    
    Création d'une méthode qui permet d'accéder à la fenêtre "Modifier une question"
    
    */
    
    public void accederModifierQuestion() throws IOException{
        FXMLLoader leLoader = new FXMLLoader (getClass().getResource("/PTS2/gestionquestion/FXMLModifierQuestion.fxml") ) ;
        AnchorPane laPage = (AnchorPane) leLoader.load();
        Stage fenetreSecondaire= new Stage() ;
        
        StageStyle stageStyle = StageStyle.UTILITY; //Fenetre "minimaliste"
        fenetreSecondaire.initStyle(stageStyle);
        
        fenetreSecondaire.setResizable(false);      //on empeche le redimentionnement de la fenetre
        
        fenetreSecondaire. setTitle("Modifier une Question") ;
        fenetreSecondaire.initModality(Modality.WINDOW_MODAL) ;
        fenetreSecondaire.initOwner(this.sPrimaryStage);
        Scene laScene = new Scene(laPage);
        fenetreSecondaire.setScene( laScene);
        
        FXMLModifierQuestionController leController;       //Création du Controller associé à la fenêtre secondaire
        
        leController = leLoader.getController();
        fenetreSecondaire.showAndWait() ;
    }
    
    /*
    
    Création d'une méthode qui permet d'accéder à la fenêtre "Supprimer une question"
    
    */
    
    public void accederSupprimerQuestion() throws IOException{
        FXMLLoader leLoader = new FXMLLoader (getClass().getResource("/PTS2/gestionquestion/FXMLSupprimerQuestion.fxml") ) ;
        AnchorPane laPage = (AnchorPane) leLoader.load();
        Stage fenetreSecondaire= new Stage() ;
        
        StageStyle stageStyle = StageStyle.UTILITY; //Fenetre "minimaliste"
        fenetreSecondaire.initStyle(stageStyle);
        
        fenetreSecondaire.setResizable(false);      //on empeche le redimentionnement de la fenetre
        
        fenetreSecondaire. setTitle("Supprimer une Question") ;
        fenetreSecondaire.initModality(Modality.WINDOW_MODAL) ;
        fenetreSecondaire.initOwner(this.sPrimaryStage);
        Scene laScene = new Scene(laPage);
        fenetreSecondaire.setScene( laScene);
        
        FXMLSupprimerQuestionController leController;       //Création du Controller associé à la fenêtre secondaire
        
        leController = leLoader.getController();
        fenetreSecondaire.showAndWait() ;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
}
