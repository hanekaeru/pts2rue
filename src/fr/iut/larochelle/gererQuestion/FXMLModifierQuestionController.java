package fr.iut.larochelle.gererQuestion;

import fr.iut.larochelle.modele.Matiere;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;

/**
 * <h1> Controller Modifier une Question</h1>
 *
 * FXML controller, permettant d'acceder à la modification d'une question
 * dans la base de données.
 *
 * @author maxime
 */
public class FXMLModifierQuestionController implements Initializable {
    
    @FXML
    private ComboBox cbMatiere;
    
    @FXML
    private Button buttonChercher;
    
    @FXML
    private DatePicker datemin;
    
    @FXML
    private DatePicker datemax;
    
    @FXML
    private TableView<String> tableviewQuestion;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.cbMatiere.setItems(  FXCollections.observableArrayList(   Matiere.values()   )  );
        this.tableviewQuestion = new TableView<>();
        tableviewQuestion.getItems().setAll("string", "string");
    }
    
    public void modifierQuestion(){
        
    }
    
    public void recupereDansTableau(){
        
    }
    
    public void chercherQuestion(){
        
    }
}
