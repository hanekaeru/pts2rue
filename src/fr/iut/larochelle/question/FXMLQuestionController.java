package fr.iut.larochelle.question;

import fr.iut.larochelle.modele.Question;
import fr.iut.larochelle.principal.FXMLPrincipalController;
import fr.iut.larochelle.util.ErrorManager;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;


/**
 *
 * @author Antonin
 */
public class FXMLQuestionController implements Initializable {
    public Chrono chrono = new Chrono();
    private LocalDate date;
    
    
    @FXML
    private RadioButton rbRep1;
    @FXML
    private RadioButton rbRep2;
    @FXML
    private RadioButton rbRep3;
    @FXML
    private RadioButton rbRep4;
    
    
    // inutile ici car static dans FXMLPrincipalController..
    private Question question;
    
    @FXML
    private Label labelQuestion;
    
    @FXML
    private Button btnQuitter;
    
    public FXMLQuestionController() {
        
    }
    
    public FXMLQuestionController(Question question) {
        this.question = question;
    }
    
    public void setQuestion(Question question) {
        this.question = question;
    }
    
    @FXML
    public void valider(){
        Stage fenetre = (Stage)btnQuitter.getScene().getWindow();
        chrono.stop();
        System.out.println(chrono.getDureeSec());
//        Statistiques.tempsReponse=chrono.getDureeSec();
//        System.out.println(Statistiques.tempsReponse);

        ErrorManager.displayResult(FXMLPrincipalController.question.getBonneReponse());

        fenetre.close();
    }
    
    @FXML
    public void quitter(){
        Stage fenetre = (Stage)btnQuitter.getScene().getWindow();
        chrono.stop();
        System.out.println(chrono.getDureeSec());
        fenetre.close();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        chrono.start();
        
        labelQuestion.setText(FXMLPrincipalController.question.getQuestion());

        ArrayList<String> reponses = FXMLPrincipalController.question.getReponses();

        rbRep1.setText(reponses.get(0));
        rbRep2.setText(reponses.get(1));

        if (reponses.size() > 2) {
            rbRep3.setText(reponses.get(2));
            rbRep4.setText(reponses.get(3));
        }

    }
}
