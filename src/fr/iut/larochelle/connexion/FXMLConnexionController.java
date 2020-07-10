package fr.iut.larochelle.connexion;

import fr.iut.larochelle.database.UtilisateurDAO;
import fr.iut.larochelle.modele.Etudiant;
import fr.iut.larochelle.modele.Matiere;
import fr.iut.larochelle.modele.Niveau;
import fr.iut.larochelle.modele.Professeur;
import fr.iut.larochelle.modele.Statistiques;
import fr.iut.larochelle.modele.Utilisateur;
import fr.iut.larochelle.util.ErrorManager;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.web.WebView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

/**
 * <h1>Controller gérant l'interface de Connexion</h1>.
 *
 * @author antonin, maxime
 */
public class FXMLConnexionController implements Initializable {
    
    @FXML
    private Label msgErreur;
    
    @FXML
    private Button btnConnexion;
    
    @FXML
    private ToggleGroup tgAnnee;
    
    @FXML
    private RadioButton rbAnnee1;
    
    @FXML
    private RadioButton rbAnnee2;
    
    @FXML
    private TextField tfUtilisateur;
    
    @FXML
    private PasswordField pfMotDePasse;
    
    @FXML
    private Button btnConnexionAnonyme;
    
    @FXML
    private Hyperlink lienAPropos;
    
    @FXML
    private WebView browser;
    
    @FXML
    private Window sPrimaryStage;
    
    public Utilisateur utilisateurConnecté;
    
    
    /**
     * <h2>Se connecter Anonyme</h2>.
     * Méthode pour se connecter anonymement, sans compte dans la BD.
     * @author antonin
     * @throws java.io.IOException
     */    
    public void seConnecterAnonyme() throws IOException{
        //todo
        FXMLLoader leLoader = new FXMLLoader (getClass().getResource("/fr/iut/larochelle/anonyme/FXMLAnonyme.fxml"));
        SplitPane laPage = (SplitPane) leLoader.load() ;
        Stage fenetreSecondaire = new Stage(StageStyle.UTILITY);
        
        fenetreSecondaire.setResizable(false);      // On empeche le redimensionnement de la fenetre
        
        fenetreSecondaire.setTitle("Révi'Tech [Anonyme]") ;
        fenetreSecondaire.initModality(Modality.WINDOW_MODAL) ;
        fenetreSecondaire.initOwner(this.sPrimaryStage);
        Scene laScene = new Scene(laPage);
        fenetreSecondaire.setScene(laScene);

        quitter();
        fenetreSecondaire.showAndWait();
    }
    
    /**
     * <h2>Se connecter </h2>.
     * Méthode pour se connecter.
     * 
     * @author antonin
     * @throws java.io.IOException
     * @throws java.sql.SQLException
     */    
    public void seConnecter() throws IOException, SQLException{
        String user = "INCONNU";
        
        // Test du login + passwd dans la Base de Données (méthode d'Enzo)
        // si besoin : https://stackoverflow.com/questions/14162225/getting-text-from-password-field
        
        UtilisateurDAO utilisateurDAO = new UtilisateurDAO();
        if (utilisateurDAO.connexion(this.tfUtilisateur.getText(), this.pfMotDePasse.getText())) {
            user = utilisateurDAO.getTypeUser(this.tfUtilisateur.getText());
        }
        
        switch (user.toUpperCase()) {
            case "ETUDIANT":
                //utilisateurConnecté = new Etudiant(this.tfUtilisateur.getText(), this.pfMotDePasse.getText(), niveau, statistiques, classement, points);
                connecterEtudiant();
                break;
            case "PROFESSEUR":
                //utilisateurConnecté = new Professeur(this.tfUtilisateur.getText(), this.pfMotDePasse.getText(), matiere);
                connecterProfesseur();
                break;
            case "ADMINISTRATEUR":
                utilisateurConnecté = new Professeur(this.tfUtilisateur.getText(), this.pfMotDePasse.getText(), Matiere.M111);
                connecterProfesseur();
                break;
            case "INCONNU":
                // Affiche une erreur dans le label prévu à cet effet + propose connexion anonyme.
                this.msgErreur.setText("Catégorie d'utilisateur non reconnu.");
                ErrorManager.unknownUserWarner();
                break;
            default:
                break;
        }
    }
    
    
    /**
     * <h2>Se connecter professeur</h2>.
     * Méthode pour se connecter en tant que professeur.
     * 
     * @author antonin
     * @throws java.io.IOException
     */
    public void connecterProfesseur() throws IOException{
        FXMLLoader leLoader = new FXMLLoader (getClass().getResource("/fr/iut/larochelle/professeur/FXMLProfesseur.fxml"));
        
        SplitPane laPage = (SplitPane) leLoader.load() ;
        Stage fenetreSecondaire = new Stage(StageStyle.UTILITY);
        
        fenetreSecondaire.setResizable(false);      // On empeche le redimensionnement de la fenetre
        
        fenetreSecondaire.setTitle("Révi'Tech [Professeur]") ;
        fenetreSecondaire.initModality(Modality.WINDOW_MODAL) ;
        fenetreSecondaire.initOwner(this.sPrimaryStage);
        Scene laScene = new Scene(laPage);
        fenetreSecondaire.setScene(laScene);

        quitter();
        fenetreSecondaire.showAndWait();
    }
    
    /**
     * 
     * <h2>Se connecter etudiant</h2>.
     * Méthode pour se connecter en tant qu'etudiant.
     * 
     * @author antonin
     * @throws java.io.IOException
     */    
    public void connecterEtudiant() throws IOException{
        FXMLLoader leLoader = new FXMLLoader (getClass().getResource("/fr/iut/larochelle/principal/FXMLPrincipal.fxml"));
        
        SplitPane laPage = (SplitPane) leLoader.load() ;
        Stage fenetreSecondaire = new Stage(StageStyle.UTILITY);
        
        fenetreSecondaire.setResizable(false);      // On empeche le redimensionnement de la fenetre
        
        fenetreSecondaire.setTitle("Révi'Tech [Etudiant]") ;
        fenetreSecondaire.initModality(Modality.WINDOW_MODAL) ;
        fenetreSecondaire.initOwner(this.sPrimaryStage);
        Scene laScene = new Scene(laPage);
        fenetreSecondaire.setScene(laScene);

        quitter();
        fenetreSecondaire.showAndWait();
    }
    
    /**
     * <h2>Ouvrir lien</h2>.
     * Méthode pour ouvrir les liens de l'universite et de moodle.
     * @author antonin
     * @throws java.net.URISyntaxException
     * @throws java.io.IOException
     */    
    public void ouvrirLienAPropos() throws URISyntaxException, IOException{
        Desktop d = Desktop.getDesktop();
        d.browse(new URI("http://www.iut-larochelle.fr/formations/dut"));
    }
    
    /**
     * <h2>Ouvrir lien</h2>.
     * Méthode pour ouvrir les liens de l'universite et de moodle.
     * @author antonin
     * @throws java.net.URISyntaxException
     * @throws java.io.IOException
     * @throw IOException
     */    
    public void ouvrirMoodle() throws URISyntaxException, IOException{
        Desktop d = Desktop.getDesktop();
        d.browse(new URI("https://moodle.univ-lr.fr/2017/login/index.php"));
    }
    
    /**
     * <h2>Quitter la fenetre</h2>.
     * Quitter la fenetre actuelle.
     * 
     * @author maxime
     */
    public void quitter(){
        Stage fenetre = (Stage)btnConnexion.getScene().getWindow(); //@FXML    private Button detailsButton;
        fenetre.close();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.msgErreur.setText("");
        
        this.tgAnnee = new ToggleGroup();
        
        
        this.rbAnnee1.setToggleGroup(tgAnnee);
        this.rbAnnee2.setToggleGroup(tgAnnee);
        
        this.rbAnnee1.setSelected(true);
        
        
        // Listener déclenchant l'authentification lors de l'appui sur la touche "enter".
        EventHandler authEnterListener = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                if (e.getCode().equals(KeyCode.ENTER)) {
                    if (tfUtilisateur.getText() != null && !tfUtilisateur.getText().equals("") &&   // Si username non null
                        pfMotDePasse.getText() != null && !pfMotDePasse.getText().equals("")) {     // et mdp non null
                        try {
                            seConnecter();
                        } catch (IOException | SQLException ex) {
                            Logger.getLogger(FXMLConnexionController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        ErrorManager.missingCredentialsWarner();
                        msgErreur.setText("Complétez les champs manquants.");
                    }
                }
            }
        };
        pfMotDePasse.setOnKeyPressed(authEnterListener);
        btnConnexion.setOnKeyPressed(authEnterListener);
    }
    
}
