/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PTS2.utilisateur;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;  //Label à rajouter pour les erreurs de mot de passe
import javafx.scene.control.SplitPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 *<h1>Controller Utilisateur</h1>
 * controller qui gère l'interface utilisateur.
 * @author maxime
 */
public class FXMLUtilisateurController implements Initializable {
    
    @FXML
    private Button btnQuitter;
    
    private Window sPrimaryStage;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
//        System.out.println("You clicked me!");
//        label.setText("Hello World!");
    }
    
//    
//    public void creerFenetre() throws IOException{
//        FXMLLoader leLoader = new FXMLLoader (getClass().getResource("../fenetre/FXMLFenetre.fxml") ) ;
//        ? SplitPane laPage = (SplitPane) leLoader.load() ;
//        Stage fenetreSecondaire= new Stage() ;
//        fenetreSecondaire. setTitle("NomFenetre") ;
//        fenetreSecondaire.initModality(Modality.WINDOW_MODAL) ;
//        fenetreSecondaire.initOwner(this.sPrimaryStage);
//        Scene laScene = new Scene(laPage);
//        fenetreSecondaire. setScene( laScene);
//        
//        FXMLPrincipalController leController;
//        
//        leController = leLoader.getController();
//        quitter();
//        fenetreSecondaire.showAndWait() ;
//    }
    
    /**
     * @author maxime
     * Quitte l'interface utilisateur
     */
    public void quitter(){
        Stage fenetre = (Stage)btnQuitter.getScene().getWindow();
        fenetre.close();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
