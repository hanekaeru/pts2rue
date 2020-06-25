/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PTS2.principal;

import PTS2.DataBase.MessageDuJourDAO;
import PTS2.DataBase.QuestionDAO;
import PTS2.question.FXMLQuestionController;
import PTS2.stats.FXMLStatsController;
//import PTS2.modele.Question;
import PTS2.utilisateur.FXMLUtilisateurController;
import PTS2.configuration.FXMLConfigurationController;
import PTS2.connexion.FXMLConnexionController;
import PTS2.modele.Question;
import com.sun.javafx.scene.control.skin.DatePickerSkin;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.MonthDay;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import static javafx.scene.AccessibleAttribute.FONT;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
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
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
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
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
//        System.out.println("You clicked me!");
//        label.setText("Hello World!");
    }
    
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
        FXMLLoader leLoader = new FXMLLoader (getClass().getResource("/PTS2/stats/FXMLStats.fxml") ) ;
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
     * Ouvre le fenetre pour repondre a une question.
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

        FXMLLoader leLoader = new FXMLLoader (getClass().getResource("/PTS2/question/FXMLQuestion.fxml") ) ;
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
        FXMLLoader leLoader = new FXMLLoader (getClass().getResource("/PTS2/configuration/FXMLConfiguration.fxml") ) ;
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
        FXMLLoader leLoader = new FXMLLoader (getClass().getResource("/PTS2/utilisateur/FXMLUtilisateur.fxml"));
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
        
        FXMLLoader leLoader = new FXMLLoader(getClass().getResource("/PTS2/connexion/FXMLConnexion.fxml"));
        
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
