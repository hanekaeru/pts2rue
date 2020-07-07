package fr.iut.larochelle.professeur;

import fr.iut.larochelle.database.MessageDuJourDAO;
import fr.iut.larochelle.database.UtilisateurDAO;
import fr.iut.larochelle.configuration.FXMLConfigurationController;
import fr.iut.larochelle.gererEvenement.FXMLGestioneEvenementController;
import fr.iut.larochelle.gererUtilisateur.FXMLGererUtilisateurController;
import fr.iut.larochelle.gestionquestion.FXMLGestionQuestionController;
import fr.iut.larochelle.modele.Utilisateur;
import fr.iut.larochelle.modererMessage.FXMLModererMessageController;
import fr.iut.larochelle.principal.FXMLPrincipalController;
import com.sun.javafx.scene.control.skin.DatePickerSkin;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import javafx.util.Callback;

/**
 * <h1>Controller Professeur</h1>
 * Controller gérant l'interface professeur.
 * @author Antonin
 */
public class FXMLProfesseurController implements Initializable {
    
    @FXML
    private Window sPrimaryStage;
    
    @FXML
    private AnchorPane conteneurCalendrier;
    
    @FXML
    private Button btnEditQR;
    
    @FXML
    private Button btnEditEvent;
    
    @FXML
    private Button btnModerer;
    
    @FXML
    private Button btnAjouter;
    
    @FXML
    public Label messageDuJour;
    
    
    public FXMLProfesseurController(){
        //this.btnTest.setGraphic(this.btnStats); inutile
    }
    
    public void ouvrirEditionQuestion() throws IOException{
        FXMLLoader leLoader = new FXMLLoader (getClass().getResource("/fr/iut/larochelle/gestionquestion/FXMLGestionQuestion.fxml") ) ;
        AnchorPane laPage = (AnchorPane) leLoader.load() ;
        Stage fenetreSecondaire= new Stage() ;
        
        StageStyle stageStyle = StageStyle.UTILITY; //Fenetre "minimaliste"
        fenetreSecondaire.initStyle(stageStyle);
        
        fenetreSecondaire.setResizable(false);      //on empeche le redimentionnement de la fenetre
        
        fenetreSecondaire.setTitle("Édition des questions") ;
        fenetreSecondaire.initModality(Modality.WINDOW_MODAL) ;
        fenetreSecondaire.initOwner(this.sPrimaryStage);
        Scene laScene = new Scene(laPage);
        fenetreSecondaire.setScene( laScene);
        
        FXMLGestionQuestionController leController;       //Création du Controller associé à la fenêtre secondaire
        
        leController = leLoader.getController();
        fenetreSecondaire.showAndWait() ;
    }
    
    
    
    /*
    Création d'une méthode qui permet d'accéder à la fenêtre "Édition des Questions"
    */
    
    /**
     * <h2>Ouvrir Edition question</h2>
     * Ouvre la fenetre permettant d'editer une question.
     * @author antonin
     * @throws IOException
     */
    public void ouvrirFenetreQuestion(LocalDate item) throws IOException, SQLException{
        FXMLLoader leLoader = new FXMLLoader (getClass().getResource("/fr/iut/larochelle/gestionquestion/FXMLGestionQuestion.fxml") ) ;
        AnchorPane laPage = (AnchorPane) leLoader.load() ;
        Stage fenetreSecondaire= new Stage() ;
        
        StageStyle stageStyle = StageStyle.UTILITY; //Fenetre "minimaliste"
        fenetreSecondaire.initStyle(stageStyle);
        
        fenetreSecondaire.setResizable(false);      //on empeche le redimentionnement de la fenetre
        
        fenetreSecondaire.setTitle("Édition des questions") ;
        fenetreSecondaire.initModality(Modality.WINDOW_MODAL) ;
        fenetreSecondaire.initOwner(this.sPrimaryStage);
        Scene laScene = new Scene(laPage);
        fenetreSecondaire.setScene( laScene);
        
        FXMLGestionQuestionController leController;       //Création du Controller associé à la fenêtre secondaire
        
        leController = leLoader.getController();
        fenetreSecondaire.showAndWait() ;
    }
    
    /**
     * <h2>Acceder gerer Utilisateur</h2>
     * Methode permettant d'acceder a l'interface de gestion des utilisateurs (admin).
     * @maxim
     * @throws IOException
     */    
    public void accederGererUtilisateur() throws IOException{
        FXMLLoader leLoader = new FXMLLoader (getClass().getResource("/fr/iut/larochelle/gererUtilisateur/FXMLGererUtilisateur.fxml") ) ;
        AnchorPane laPage = (AnchorPane) leLoader.load() ;
        Stage fenetreSecondaire= new Stage() ;
        
        StageStyle stageStyle = StageStyle.UTILITY; //Fenetre "minimaliste"
        fenetreSecondaire.initStyle(stageStyle);
        
        fenetreSecondaire.setResizable(false);      //on empeche le redimentionnement de la fenetre
        
        fenetreSecondaire.setTitle("Gestion Utilisateur") ;
        fenetreSecondaire.initModality(Modality.WINDOW_MODAL) ;
        fenetreSecondaire.initOwner(this.sPrimaryStage);
        Scene laScene = new Scene(laPage);
        fenetreSecondaire.setScene( laScene);
        
        FXMLGererUtilisateurController leController;       //Création du Controller associé à la fenêtre secondaire
        
        leController = leLoader.getController();
        fenetreSecondaire.showAndWait() ;
    }
    
    /**
     * <h2>Ouvrir Edition Evenement</h2>
     * Ouvre la fenetre permettant d'editer un evenement.
     * @author antonin
     * @throws IOException
     */    
    public void ouvrirEditionEvenement() throws IOException{
        FXMLLoader leLoader = new FXMLLoader (getClass().getResource("/fr/iut/larochelle/gererEvenement/FXMLGestioneEvenement.fxml") ) ;
        AnchorPane laPage = (AnchorPane) leLoader.load() ;
        Stage fenetreSecondaire= new Stage() ;
        
        StageStyle stageStyle = StageStyle.UTILITY; //Fenetre "minimaliste"
        fenetreSecondaire.initStyle(stageStyle);
        
        fenetreSecondaire.setResizable(false);      //on empeche le redimentionnement de la fenetre
        
        fenetreSecondaire.setTitle("Question du *date*") ;
        fenetreSecondaire.initModality(Modality.WINDOW_MODAL) ;
        fenetreSecondaire.initOwner(this.sPrimaryStage);
        Scene laScene = new Scene(laPage);
        fenetreSecondaire.setScene( laScene);
        
        FXMLGestioneEvenementController leController;        //Création du Controller associé à la fenêtre secondaire
        
        leController = leLoader.getController();
        fenetreSecondaire.showAndWait() ;
    }
    
    
    /**
     * <h2>Ouvrir Fenetre Calendrier</h2>
     * Ouvre la fenetre du calendrier.
     * @author antonin
     * @throws IOException
     */    
    public void ouvrirFenetreCalendrier() throws IOException{
        FXMLLoader leLoader = new FXMLLoader (getClass().getResource("") ) ;
        AnchorPane laPage = (AnchorPane)leLoader.load() ;
        Stage fenetreSecondaire= new Stage() ;
        
        StageStyle stageStyle = StageStyle.UTILITY; //Fenetre "minimaliste"
        fenetreSecondaire.initStyle(stageStyle);
        
        fenetreSecondaire.setResizable(false);      //on empeche le redimentionnement de la fenetre
        
        fenetreSecondaire.setTitle("Configuration") ;
        fenetreSecondaire.initModality(Modality.WINDOW_MODAL) ;
        fenetreSecondaire.initOwner(this.sPrimaryStage);
        Scene laScene = new Scene(laPage);
        fenetreSecondaire.setScene( laScene);
        
        FXMLConfigurationController leController;       //Création du Controller associé à la fenêtre secondaire
        
        leController = leLoader.getController();
        fenetreSecondaire.showAndWait() ;
    }
    
    
    /**
     * <h2>Ouvrir Fenetre Modération</h2>
     * Ouvre la fenetre permettant de moderer le message de la semaine.
     * @author antonin
     * @throws IOException
     */    
    public void ouvrirFenetreModeration() throws IOException{
        FXMLLoader leLoader = new FXMLLoader (getClass().getResource("/fr/iut/larochelle/modererMessage/FXMLModererMessage.fxml") ) ;
        AnchorPane laPage = (AnchorPane) leLoader.load() ;
        Stage fenetreSecondaire= new Stage() ;
        
        StageStyle stageStyle = StageStyle.UTILITY; //Fenetre "minimaliste"
        fenetreSecondaire.initStyle(stageStyle);
        
        fenetreSecondaire.setResizable(false);      //on empeche le redimentionnement de la fenetre
        
        fenetreSecondaire.setTitle("Utilisateur") ;
        fenetreSecondaire.initModality(Modality.WINDOW_MODAL) ;
        fenetreSecondaire.initOwner(this.sPrimaryStage);
        Scene laScene = new Scene(laPage);
        fenetreSecondaire.setScene( laScene);
        
        FXMLModererMessageController leController;     //Création du Controller associé à la fenêtre secondaire
        
        leController = leLoader.getController();
        fenetreSecondaire.showAndWait() ;
    }
    
    /**
     * <h2>Init Calendrier</h2>
     * Méthode implementant la calendrier des questions.
     * @author antonin
     */
    public void initCalendrier(){
        DatePicker dateTest = new DatePicker();
        final Callback<DatePicker, DateCell> dayCellFactory = new Callback<DatePicker, DateCell>()
        {
            public DateCell call(final DatePicker datePicker)
            {
                return new DateCell()
                {
                    @Override
                    public void updateItem(LocalDate item, boolean empty)
                    {
                        super.updateItem(item, empty);
                        
                        
                        if (item.equals(LocalDate.now())) {
                            setFont(Font.font("System", FontWeight.EXTRA_BOLD, 12));
                        }
                        
                        if (item.isBefore(LocalDate.now().plusDays(1))) {
                            setOnMouseClicked(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent event) {
                                    try {
                                        ouvrirFenetreQuestion(item);
                                    } catch (IOException ex) {
                                        Logger.getLogger(FXMLPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
                                    } catch (SQLException ex) {
                                        Logger.getLogger(FXMLPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                            });
                            
                        }
                        
                        if (item.isAfter(LocalDate.now()))
                        {
                            setDisable(true);
                        }
                    }
                };
            }
        };
        dateTest.setDayCellFactory(dayCellFactory);
        
        DatePickerSkin datePickerSkin = new DatePickerSkin(dateTest);
        //datePickerSkin.computeMaxWidth​(double height, double topInset, double rightInset, double bottomInset, double leftInset);
        //datePickerSkin.setMaxWidth(150);
        Node popupContent = datePickerSkin.getPopupContent();
        //popupContent.autosize();
        popupContent.setLayoutX(100*0.30);
        popupContent.setTranslateY(40);
        
        conteneurCalendrier.getChildren().add(popupContent);
    }
    
    
    public void methodeAuRebut(){
        System.out.println("Méthode inutilisée");
    }
    
    /**
     * <h2>Quitter la fenetre</h2>
     * @author maxime
     */
    public void quitter(){
        Stage fenetre = (Stage)sPrimaryStage.getScene().getWindow();
        fenetre.close();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //        btnConfiguration.setCursor(Cursor.HAND);
        //        btnUtilisateur.setCursor(Cursor.HAND);
        //        btnQuestion.setCursor(Cursor.HAND);
        //        btnStats.setCursor(Cursor.HAND);
        
        try {
            this.messageDuJour.setText(MessageDuJourDAO.getMsg());
        } catch (SQLException ex) {
            Logger.getLogger(FXMLProfesseurController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        UtilisateurDAO user = new UtilisateurDAO();
        String type="";
        try {
            type = user.getTypeUser(Utilisateur.username);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLProfesseurController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (type.equalsIgnoreCase("ADMINISTRATEUR")) {
            this.btnAjouter.setDisable(false);
        }
        
        initCalendrier();
    }
    
}
