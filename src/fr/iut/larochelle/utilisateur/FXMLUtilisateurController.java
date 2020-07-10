package fr.iut.larochelle.utilisateur;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * <h1>Controller Utilisateur</h1>
 * Controller qui gère l'interface utilisateur.
 * 
 * @author maxime
 */
public class FXMLUtilisateurController implements Initializable {
    
    @FXML
    private Button btnQuitter;
    
    private Window sPrimaryStage;
    
//
//    public void creerFenetre() throws IOException{
//        FXMLLoader leLoader = new FXMLLoader (getClass().getResource("../fenetre/FXMLFenetre.fxml") ) ;
//        ? SplitPane laPage = (SplitPane) leLoader.load() ;
//        Stage fenetreSecondaire = new Stage();
//        fenetreSecondaire.setTitle("NomFenetre") ;
//        fenetreSecondaire.initModality(Modality.WINDOW_MODAL) ;
//        fenetreSecondaire.initOwner(this.sPrimaryStage);
//        Scene laScene = new Scene(laPage);
//        fenetreSecondaire.setScene(laScene);
//
//        quitter();
//        fenetreSecondaire.showAndWait();
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
