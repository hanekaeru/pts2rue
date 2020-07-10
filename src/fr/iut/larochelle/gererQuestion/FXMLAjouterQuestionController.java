package fr.iut.larochelle.gererQuestion;

import fr.iut.larochelle.database.QuestionDAO;
import fr.iut.larochelle.database.UtilisateurDAO;
import fr.iut.larochelle.modele.Matiere;
import fr.iut.larochelle.modele.Niveau;
import fr.iut.larochelle.modele.Professeur;
import fr.iut.larochelle.modele.Question;
import fr.iut.larochelle.modele.UE;
import fr.iut.larochelle.modele.Utilisateur;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * <h1> Controller Ajouter une Question</h1>
 *
 * FXML controller, permettant d'ajouter une nouvelle question
 * dans la base de données.
 *
 * @author maxime
 */
public class FXMLAjouterQuestionController implements Initializable {
    
    @FXML
    private TextArea questionArea;
    
    @FXML
    private TextField reponse1;
    
    @FXML
    private TextField reponse2;
    
    @FXML
    private TextField reponse3;
    
    @FXML
    private TextField reponse4;
    
    @FXML
    private TextField bonneReponse;
    
    @FXML
    private DatePicker dateQuestion;
    
    @FXML
    private ComboBox matiere;
    
    @FXML
    private ComboBox ue;
    
    @FXML
    private RadioButton radioButton1;
    
    @FXML
    private RadioButton radioButton2;
    
    @FXML
    private ToggleGroup toogleGroupAnnee;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.matiere.setItems(FXCollections.observableArrayList(Matiere.values()));
        this.ue.setItems(FXCollections.observableArrayList(UE.values()));
        
        this.toogleGroupAnnee = new ToggleGroup();
        this.radioButton1.setToggleGroup(toogleGroupAnnee);
        this.radioButton2.setToggleGroup(toogleGroupAnnee);
    }
    
    public void sauvegarderQuestion() throws SQLException{
        UtilisateurDAO utilisateurDAO = new UtilisateurDAO();
        ArrayList<String> list = new ArrayList<>();
        list.add(reponse1.getText());
        list.add(reponse2.getText());
        list.add(reponse3.getText());
        list.add(reponse4.getText());
        Niveau niveau = null;
        if (radioButton1.isSelected() == true) {
            niveau = Niveau.PREMIERE_ANNEE;
        }
        else {
            niveau = Niveau.DEUXIEME_ANNEE;
        }
        Professeur professeur=null;
        professeur = utilisateurDAO.newProfesseur(Utilisateur.username,utilisateurDAO.getPassword(Utilisateur.username));
        
        Question question = new Question((Matiere) matiere.getValue(),  niveau,
                dateQuestion.getValue(), questionArea.getText(), bonneReponse.getText(), list, (UE)ue.getValue(), professeur);
        
        QuestionDAO questionDAO = new QuestionDAO();
        questionDAO.addQuestion(question);
        
    }
    
    public void importerImage(){
        
    }
}
