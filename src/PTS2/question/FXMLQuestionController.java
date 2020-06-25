package PTS2.question;

import PTS2.modele.Question;
import PTS2.principal.FXMLPrincipalController;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;



/**
 *
 * @author Antonin
 */
public class FXMLQuestionController implements Initializable {
    public Chrono chrono=new Chrono();
    private LocalDate date;
    
    
    @FXML
    private RadioButton rbRep1;
    @FXML
    private RadioButton rbRep2;
    @FXML
    private RadioButton rbRep3;
    @FXML
    private RadioButton rbRep4;
    
    
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
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
//        System.out.println("You clicked me!");
//        label.setText("Hello World!");
    }
    
    public void valider(){
        Stage fenetre = (Stage)btnQuitter.getScene().getWindow();
        chrono.stop();
        System.out.println(chrono.getDureeSec());
//        Statistiques.tempsReponse=chrono.getDureeSec();
//        System.out.println(Statistiques.tempsReponse);

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Résultat");
        alert.setHeaderText("La réponse était : ");
        alert.setContentText("\n" + FXMLPrincipalController.question.getBonneReponse().replace("&#&", ", "));
        alert.showAndWait();


        fenetre.close();
    }
    
    public void quitter(){
        Stage fenetre = (Stage)btnQuitter.getScene().getWindow();
        chrono.stop();
        System.out.println(chrono.getDureeSec());
        fenetre.close();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        chrono.start();
        this.labelQuestion.setText(FXMLPrincipalController.question.getQuestion());
//        ArrayList<String> reponses = FXMLPrincipalController.question.getReponses();
        this.rbRep1.setText(FXMLPrincipalController.question.getReponses().get(0));
        this.rbRep2.setText(FXMLPrincipalController.question.getReponses().get(1));



        if (FXMLPrincipalController.question.getReponses().size() > 2)
        {
            this.rbRep3.setText(FXMLPrincipalController.question.getReponses().get(2));
            this.rbRep4.setText(FXMLPrincipalController.question.getReponses().get(3));
        }

    }
}
