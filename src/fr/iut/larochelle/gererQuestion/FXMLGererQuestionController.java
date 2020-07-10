package fr.iut.larochelle.gererQuestion;

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
 * @author maxime
 */
public class FXMLGererQuestionController implements Initializable {
    
    @FXML
    private Window sPrimaryStage;
    
    @FXML
    private Button btnQuitter;
    
    public void quitter(){
        Stage fenetre = (Stage)btnQuitter.getScene().getWindow();
        fenetre.close();
    }
    
    /**
     * Création d'une méthode qui permet d'accéder à la fenêtre "Ajouter une Question"
     * 
     * @throws java.io.IOException
     */
    @FXML
    public void accederAjouterQuestion() throws IOException{
        FXMLLoader leLoader = new FXMLLoader(getClass().getResource("/fr/iut/larochelle/gererQuestion/FXMLAjouterQuestion.fxml") ) ;
        AnchorPane laPage = (AnchorPane) leLoader.load();
        Stage fenetreSecondaire = new Stage(StageStyle.UTILITY);
        
        fenetreSecondaire.setResizable(false);      // On empeche le redimensionnement de la fenetre
        
        fenetreSecondaire.setTitle("Ajouter une Question") ;
        fenetreSecondaire.initModality(Modality.WINDOW_MODAL) ;
        fenetreSecondaire.initOwner(this.sPrimaryStage);
        Scene laScene = new Scene(laPage);
        fenetreSecondaire.setScene(laScene);

        fenetreSecondaire.showAndWait();
    }
    
    /*
        Création d'une méthode qui permet d'accéder à la fenêtre "Modifier une question"
    */    
    public void accederModifierQuestion() throws IOException{        
        FXMLLoader leLoader = new FXMLLoader(getClass().getResource("/fr/iut/larochelle/gererQuestion/FXMLModifierQuestion.fxml") ) ;
        AnchorPane laPage = (AnchorPane) leLoader.load();
        Stage fenetreSecondaire = new Stage(StageStyle.UTILITY);
        
        fenetreSecondaire.setResizable(false);      // On empeche le redimensionnement de la fenetre
        
        fenetreSecondaire.setTitle("Modifier une Question") ;
        fenetreSecondaire.initModality(Modality.WINDOW_MODAL) ;
        fenetreSecondaire.initOwner(this.sPrimaryStage);
        Scene laScene = new Scene(laPage);
        fenetreSecondaire.setScene(laScene);

        fenetreSecondaire.showAndWait();
    }
    
    /*
        Création d'une méthode qui permet d'accéder à la fenêtre "Supprimer une question"
    */
    public void accederSupprimerQuestion() throws IOException{
        FXMLLoader leLoader = new FXMLLoader(getClass().getResource("/fr/iut/larochelle/gererQuestion/FXMLSupprimerQuestion.fxml") ) ;
        AnchorPane laPage = (AnchorPane) leLoader.load();
        Stage fenetreSecondaire = new Stage(StageStyle.UTILITY);
        
        fenetreSecondaire.setResizable(false);      // On empeche le redimensionnement de la fenetre
        
        fenetreSecondaire.setTitle("Supprimer une Question") ;
        fenetreSecondaire.initModality(Modality.WINDOW_MODAL) ;
        fenetreSecondaire.initOwner(this.sPrimaryStage);
        Scene laScene = new Scene(laPage);
        fenetreSecondaire.setScene(laScene);

        fenetreSecondaire.showAndWait();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
}
