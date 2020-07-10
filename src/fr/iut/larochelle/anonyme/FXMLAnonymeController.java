package fr.iut.larochelle.anonyme;

import fr.iut.larochelle.database.MessageDuJourDAO;
import fr.iut.larochelle.database.QuestionDAO;
import fr.iut.larochelle.modele.Question;
import fr.iut.larochelle.principal.FXMLPrincipalController;
import fr.iut.larochelle.question.FXMLQuestionController;
import com.sun.javafx.scene.control.skin.DatePickerSkin;
import fr.iut.larochelle.util.ErrorManager;
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
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
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
 * <h1>FXML Controller Anonyme</h1>
 * Controller qui va gérer l'interface de connexion anonyme.
 * 
 * @author maxim
 */
public class FXMLAnonymeController implements Initializable {
    
    @FXML
    private AnchorPane conteneurCalendrier;
    @FXML
    private Window sPrimaryStage;
    @FXML
    private Label messageDuJour;
    
    
    public static Question question;
    
    /**
     * <h2>Ouvrir la fenetre de question de l'interface Anonyme.</h2>
     * 
     * @author antonin, maxime
     * @param item
     * @throws java.io.IOException
     * @throws java.sql.SQLException
     */
    public void ouvrirFenetreQuestion(LocalDate item) throws IOException, SQLException{
        FXMLAnonymeController.question = null;
        
        //recupération des informations depuis la BD
        try {
            //question
            QuestionDAO questionDAO = new QuestionDAO();
            FXMLAnonymeController.question = questionDAO.getQuestion(item);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLQuestionController.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        if (question == null) {
            ErrorManager.displayNoQuestionFound(item);
            return;
        }
        
        FXMLLoader leLoader = new FXMLLoader (getClass().getResource("/fr/iut/larochelle/question/FXMLQuestion.fxml") ) ;
        SplitPane laPage = (SplitPane) leLoader.load() ;
        Stage fenetreSecondaire = new Stage() ;
        
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
     * <h2>Init Calendrier</h2>
     * Méthode implementant le calendrier des questions, une question par jour.
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
                                    } catch (IOException | SQLException ex) {
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
        popupContent.setLayoutX(600*0.30);
        popupContent.setTranslateY(30);
        
        conteneurCalendrier.getChildren().add(popupContent);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //initialisation du messageDuJour
        try {
            this.messageDuJour.setText(MessageDuJourDAO.getMsg());
        } catch (SQLException ex) {
            Logger.getLogger(FXMLAnonymeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        initCalendrier();
    }
    
}
