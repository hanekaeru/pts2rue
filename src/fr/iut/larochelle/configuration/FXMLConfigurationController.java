package fr.iut.larochelle.configuration;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;  //Label à rajouter pour les erreurs de mot de passe
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * <h1>Controller de l'interface de Configuration</h1>.
 * Controller gérant l'interface de configuration utilisateur.
 * @author antonin
 */
public class FXMLConfigurationController implements Initializable {
    
    @FXML
    private Button btnQuitter;
    
    @FXML
    private ColorPicker colorPicker;
    
    @FXML
    private AnchorPane conteneur;
    
    private Window sPrimaryStage;
    
    /**
     * <h2>Changer de mot de passe</h2>.
     * Méthode pour changer le mdp utilisateur.
     * @author antonin
     */    
    public void changerMotDePasse(){
        System.out.println("Méthode pour changer le mdp.");
    }
    
    /**
     * <h2>Quitter la fenetre</h2>.
     * Quitter la fenetre actuelle.
     * @author antonin
     */
    public void quitter(){
        Stage fenetre = (Stage)btnQuitter.getScene().getWindow(); //@FXML    private Button detailsButton;
        fenetre.close();
    }
    
    /**
     * <h2>Méthode pour changer de couleur</h2>
     * Change l'arrière plan de la page à l'aide d'un color picker.
     * @author antonin
     */
    public void changerCouleur(){
        colorPicker.getValue();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        colorPicker.setOnAction(e -> conteneur.setBackground(new Background(new BackgroundFill(colorPicker.getValue(), CornerRadii.EMPTY, Insets.EMPTY))));
    }
    
}
