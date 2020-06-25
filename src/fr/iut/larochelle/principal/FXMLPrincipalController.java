package fr.iut.larochelle.principal;

import fr.iut.larochelle.database.MessageDuJourDAO;
import fr.iut.larochelle.database.QuestionDAO;
import fr.iut.larochelle.question.FXMLQuestionController;
import fr.iut.larochelle.stats.FXMLStatsController;
import fr.iut.larochelle.utilisateur.FXMLUtilisateurController;
import fr.iut.larochelle.configuration.FXMLConfigurationController;
import fr.iut.larochelle.connexion.FXMLConnexionController;
import fr.iut.larochelle.modele.Question;
import com.sun.javafx.scene.control.skin.DatePickerSkin;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.MonthDay;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
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
 * <h1>Controller Principale</h1>.
 * Controller gérant l'interface principal.
 * @author antonin, maxime, kyllian
 *
 */
public class FXMLPrincipalController implements Initializable {
    
    @FXML
    private Window sPrimaryStage;
    @FXML
    private ImageView btnStats;
    @FXML
    private ImageView btnConfiguration;
    @FXML
    private ImageView btnUtilisateur;
    @FXML
    private ImageView seDeconnecter;
    @FXML
    private Button btnModifier;
    @FXML
    private AnchorPane conteneurCalendrier;
    @FXML
    private Label labelMessage;
    
    public static Question question;
    
    
    public FXMLPrincipalController(){
        //this.btnTest.setGraphic(this.btnStats); inutile
    }
    
    /**
     * <h2>Ouvrir fenetre Stats</h2>
     * Ouvre la fenetre de statistiques de l'étudiant.
     * @author maxime
     * @throws IOException
     */
    public void ouvrirFenetreStats() throws IOException{
        FXMLLoader leLoader = new FXMLLoader (getClass().getResource("/fr/iut/larochelle/stats/FXMLStats.fxml") ) ;
        AnchorPane laPage = (AnchorPane) leLoader.load() ;
        Stage fenetreSecondaire= new Stage() ;
        
        StageStyle stageStyle = StageStyle.UTILITY; //Fenetre "minimaliste"
        fenetreSecondaire.initStyle(stageStyle);
        
        fenetreSecondaire.setResizable(false);      //on empeche le redimentionnement de la fenetre
        
        fenetreSecondaire. setTitle("Statistiques") ;
        fenetreSecondaire.initModality(Modality.WINDOW_MODAL) ;
        fenetreSecondaire.initOwner(this.sPrimaryStage);
        Scene laScene = new Scene(laPage);
        fenetreSecondaire.setScene( laScene);
        
        FXMLStatsController leController;       //Création du Controller associé à la fenêtre secondaire
        
        leController = leLoader.getController();
        fenetreSecondaire.showAndWait() ;
    }
    
    /**
     * <h2>Ouvrir fenetre question</h2>
     * Ouvre la fenetre pour repondre a une question.
     *
     * @author maxime
     * @param date
     * @throws IOException
     */
    public void ouvrirFenetreQuestion(LocalDate item) throws IOException, SQLException{
        FXMLPrincipalController.question = null;
        
        //recupération des informations depuis la BD
        try {
            //question
            QuestionDAO questionDAO = new QuestionDAO();
            FXMLPrincipalController.question = questionDAO.getQuestion(item);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLQuestionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        FXMLLoader leLoader = new FXMLLoader (getClass().getResource("/fr/iut/larochelle/question/FXMLQuestion.fxml") ) ;
        SplitPane laPage = (SplitPane) leLoader.load() ;
        Stage fenetreSecondaire= new Stage() ;
        
        StageStyle stageStyle = StageStyle.UTILITY; //Fenetre "minimaliste"
        fenetreSecondaire.initStyle(stageStyle);
        
        fenetreSecondaire.setResizable(false);      //on empeche le redimentionnement de la fenetre
        
        fenetreSecondaire.setTitle("Question du " + item.toString()) ;
        fenetreSecondaire.initModality(Modality.WINDOW_MODAL) ;
        fenetreSecondaire.initOwner(this.sPrimaryStage);
        Scene laScene = new Scene(laPage);
        fenetreSecondaire.setScene( laScene);
        
        FXMLQuestionController leController = new FXMLQuestionController();        //Création du Controller associé à la fenêtre secondaire
        
        leController = leLoader.getController();
        fenetreSecondaire.showAndWait() ;
    }
    
    /**
     * <h2>Ouvrir fenetre Config</h2>
     * Ouvre la fenetre de configuration de l'etudiant.
     * @author maxime
     * @throws IOException
     */
    public void ouvrirFenetreConfiguration() throws IOException{
        FXMLLoader leLoader = new FXMLLoader (getClass().getResource("/fr/iut/larochelle/configuration/FXMLConfiguration.fxml") ) ;
        AnchorPane laPage = (AnchorPane)leLoader.load() ;
        Stage fenetreSecondaire= new Stage() ;
        
        StageStyle stageStyle = StageStyle.UTILITY; //Fenetre "minimaliste"
        fenetreSecondaire.initStyle(stageStyle);
        
        fenetreSecondaire.setResizable(false);      //on empeche le redimentionnement de la fenetre
        
        fenetreSecondaire. setTitle("Configuration") ;
        fenetreSecondaire.initModality(Modality.WINDOW_MODAL) ;
        fenetreSecondaire.initOwner(this.sPrimaryStage);
        Scene laScene = new Scene(laPage);
        fenetreSecondaire.setScene( laScene);
        
        FXMLConfigurationController leController;       //Création du Controller associé à la fenêtre secondaire
        
        leController = leLoader.getController();
        fenetreSecondaire.showAndWait() ;
    }
    
    /**
     * <h2>Ouvrir fenetre Utilsateur</h2>
     * @author antonin
     * @throws IOException
     */
    public void ouvrirFenetreUtilisateur() throws IOException{
        FXMLLoader leLoader = new FXMLLoader (getClass().getResource("/fr/iut/larochelle/utilisateur/FXMLUtilisateur.fxml"));
        AnchorPane laPage = (AnchorPane) leLoader.load() ;
        Stage fenetreSecondaire= new Stage() ;
        
        StageStyle stageStyle = StageStyle.UTILITY; //Fenetre "minimaliste"
        fenetreSecondaire.initStyle(stageStyle);
        
        fenetreSecondaire.setResizable(false);      //on empeche le redimentionnement de la fenetre
        
        fenetreSecondaire. setTitle("Utilisateur") ;
        fenetreSecondaire.initModality(Modality.WINDOW_MODAL) ;
        fenetreSecondaire.initOwner(this.sPrimaryStage);
        Scene laScene = new Scene(laPage);
        fenetreSecondaire.setScene( laScene);
        
        FXMLUtilisateurController leController;     //Création du Controller associé à la fenêtre secondaire
        
        leController = leLoader.getController();
        fenetreSecondaire.showAndWait() ;
    }
    
    /**
     * <h2>Quitter la fenetre</h2>
     * @author maxime
     */
    public void quitter(){
        Stage fenetre = (Stage)seDeconnecter.getScene().getWindow();
        fenetre.close();
    }
    
    
    public void seDeconnecter() throws IOException{
        
        FXMLLoader leLoader = new FXMLLoader(getClass().getResource("/fr/iut/larochelle/connexion/FXMLConnexion.fxml"));
        
        AnchorPane laPage = (AnchorPane) leLoader.load() ;
        Stage fenetreSecondaire= new Stage();
        
        StageStyle stageStyle = StageStyle.UTILITY; //Fenetre "minimaliste"
        fenetreSecondaire.initStyle(stageStyle);
        
        fenetreSecondaire.setResizable(false);      //on empeche le redimentionnement de la fenetre
        
        fenetreSecondaire. setTitle("") ;
        fenetreSecondaire.initModality(Modality.WINDOW_MODAL) ;
        fenetreSecondaire.initOwner(this.sPrimaryStage);
        Scene laScene = new Scene(laPage);
        fenetreSecondaire. setScene( laScene);
        
        FXMLConnexionController leController;
        
        leController = leLoader.getController();
        
        quitter();
        
        fenetreSecondaire.showAndWait() ;
    }
    
    /**
     * <h2>Init Calendrier</h2>
     * Méthode implementant la calendrier des questions.
     * @author antonin
     *
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
                        
                        
                        
                        if (MonthDay.from(item).equals(MonthDay.of(6, 9)))
                        {
                            setTooltip(new Tooltip("Affichage de l'évenement du jour ou de la question."));
                            setStyle("-fx-background-color: #ff2244;");
                        }
                        if (MonthDay.from(item).equals(MonthDay.of(6, 10)))
                        {
                            setTooltip(new Tooltip("Affichage de l'évenement du jour ou de la question."));
                            setStyle("-fx-background-color: #ff2244;");
                        }
                        if (MonthDay.from(item).equals(MonthDay.of(6, 11)))
                        {
                            setTooltip(new Tooltip("Affichage de l'évenement du jour ou de la question."));
                            setStyle("-fx-background-color: #22ff44;");
                        }
                        if (MonthDay.from(item).equals(MonthDay.of(6, 12)))
                        {
                            setTooltip(new Tooltip("Partiel d'Expression Communication"));
                            setStyle("-fx-background-color: #ff2244;");
                        }
                        if (MonthDay.from(item).equals(MonthDay.of(6, 13))){
                            setTooltip(new Tooltip("Affichage de l'évenement du jour."));
                            setStyle("-fx-background-color: #22ff44;");
                        }
                        if (MonthDay.from(item).equals(MonthDay.of(6, 14))){
                            setTooltip(new Tooltip("Affichage de l'évenement du jour."));
                            setStyle("-fx-background-color: #22ff44;");
                        }
                        if (MonthDay.from(item).equals(MonthDay.of(6, 15))){
                            setTooltip(new Tooltip("Partiel de Marketing opérationnel"));
                            setStyle("-fx-background-color: #ff2244;");
                        }
                        if (MonthDay.from(item).equals(MonthDay.of(6, 16))){
                            setTooltip(new Tooltip("Partiel d'Economie"));
                            setStyle("-fx-background-color: #ff2244;");
                        }
                        if (MonthDay.from(item).equals(MonthDay.of(6, 17))){
                            setTooltip(new Tooltip("Affichage de l'évenement du jour."));
                            setStyle("-fx-background-color: #22ff44;");
                        }
                        if (MonthDay.from(item).equals(MonthDay.of(6, 18))){
                            setTooltip(new Tooltip("Partiel d'anglais"));
                            setStyle("-fx-background-color: #ff2244;");
                        }
                        if (MonthDay.from(item).equals(MonthDay.of(6, 19))){
                            setTooltip(new Tooltip("Affichage de l'évenement du jour."));
                            setStyle("-fx-background-color: #22ff44;");
                        }
                        if (MonthDay.from(item).equals(MonthDay.of(6, 20))){
                            setTooltip(new Tooltip("Partiel de Droit"));
                            setStyle("-fx-background-color: #22ff44;");
                        }
                        if (MonthDay.from(item).equals(MonthDay.of(6, 21))){
                            setTooltip(new Tooltip("Affichage de l'évenement du jour."));
                            setStyle("-fx-background-color: #ff2244;");
                        }
                        if (MonthDay.from(item).equals(MonthDay.of(6, 22))){
                            setTooltip(new Tooltip("Gala de fin d'année"));
                            setStyle("-fx-background-color: #22ff44;");
                        }
                        
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
                            
//                            Question question = item.getDayOfMonth();
//
//                            if (bonneReponse??) {
//                                setStyle("-fx-background-color: #22FF22;");
//                                setTooltip(new Tooltip("Bonne réponse\n"+question.getMatiere().toString()));
//                            }else{
//                                setStyle("-fx-background-color: #FF2222;");
//                                setTooltip(new Tooltip("Mauvaise réponse\n"+question.getMatiere().toString()));
//                            }
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
        popupContent.setTranslateY(10);
        
        conteneurCalendrier.getChildren().add(popupContent);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        btnConfiguration.setCursor(Cursor.HAND);
        btnUtilisateur.setCursor(Cursor.HAND);
        btnStats.setCursor(Cursor.HAND);
        btnModifier.setDisable(true);
        seDeconnecter.setCursor(Cursor.HAND);
        
        
        try {
            //initialisation du message du jour
            this.labelMessage.setText(MessageDuJourDAO.getMsg());
        } catch (SQLException ex) {
            Logger.getLogger(FXMLPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        //majCalendrier(); ??
        initCalendrier();
    }
    
}
